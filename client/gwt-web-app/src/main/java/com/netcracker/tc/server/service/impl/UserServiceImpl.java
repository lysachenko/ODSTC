package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.converter.ConverterUtil;
import com.netcracker.tc.server.persistence.dao.api.ResumeDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.StudentDetail;
import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.api.MailService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.common.AbstractService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.util.MD5;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.PositionDTO;
import com.netcracker.tc.shared.model.user.RoleDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import com.netcracker.tc.shared.model.user.UserStatusDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private MailService mailService;

    public UserServiceImpl() {
        LOGGER.trace("UserService created");
    }

    @Override
    public void editUserStatus(Long userId, UserStatusDTO userStatusDTO) throws ServiceException {
        User user = userDao.get(userId);

        if (user == null) {
            throw new ServiceException("Пользователя с id [" + userId + "] нету в системе");
        }

        StudentDetail studentDetail = user.getStudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(userStatusDTO.getId()));
//        throw new ServiceException("Пользователя с id [" + userId + "] нету в системе" + studentDetail.getUserStatus().getId());


        userDao.update(studentDetail);
    }

    @Override
    public PagingLoadResultDTO<UserDTO> getUsers(PagingLoadConfigDTO loadConfig, UserPagingFilterDTO filter) throws ServiceException {
        LOGGER.debug("GetUsers by: {}", loadConfig);
        LOGGER.debug("Filter: {}", filter);

        PagingLoadResult<User> result = userDao.loadUsers(ConverterUtil.convert(loadConfig), ConverterUtil.convert(filter));

        LOGGER.debug("Loaded: {}", result);

        return new PagingLoadResultDTO<UserDTO>(ConverterUtil.convertUsers(result.getItems()), result.getPageNumber(), result.getTotalItemCount());
    }

    @Override
    public UserDTO getUser(long id) throws ServiceException {
        return ConverterUtil.convert(userDao.get(id));
    }

    @Override
    public UserDTO loginUser(String login, String password) throws ServiceException {
        User user = userDao.getUser(login, MD5.hash(password));
        if (user == null) {
            throw new ServiceException("Неверный логин или пароль");
        }
        return ConverterUtil.convert(user);
    }

    @Override
    public void addUser(UserDTO userDTO) throws ServiceException {
        isLoginFree(userDTO.getLogin());

        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(MD5.hash(userDTO.getPassword()));
        user.setRole(userDao.getRole(userDTO.getRole().getId()));
        user.setArchive(false);

        ResumeDTO resumeDTO = userDTO.getResume();
        Resume resume = new Resume();
        resume.setEmail(resumeDTO.getEmail());
        resume.setName(resumeDTO.getName());
        resume.setSurname(resumeDTO.getSurname());
        resume.setLastName(resumeDTO.getLastName());
        resume.setSkype(resumeDTO.getSkype());
        resume.setTelephoneNum(resumeDTO.getTelephoneNum());
        resume.setUser(user);

        user.setResume(resume);

        if (userDTO.getRole().isStudent()) {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.FILLING_CV));
            studentDetail.setPosition(userDao.getPosition(PositionDTO.DEV));
            studentDetail.setUser(user);
            user.setStudentDetail(studentDetail);
        }

        userDao.create(user);
        resumeDao.create(resume);
    }

    @Override
    public void addStudent(UserDTO userDTO) throws ServiceException {
        isLoginFree(userDTO.getLogin());

        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(MD5.hash(userDTO.getPassword()));
        user.setRole(userDao.getRole(RoleDTO.ROLE_USER_ID));
        user.setArchive(false);

        Resume resume = new Resume();
        resume.setUser(user);
        resume.setEmail(userDTO.getLogin());
        user.setResume(resume);

        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(UserStatusDTO.FILLING_CV));
        studentDetail.setPosition(userDao.getPosition(PositionDTO.DEV));
        studentDetail.setUser(user);
        user.setStudentDetail(studentDetail);

        userDao.create(user);
        resumeDao.create(resume);
    }

    @Override
    public void deleteUser(long id) throws ServiceException {
        userDao.deleteByPK(id);
    }

    @Override
    public void changePassword(long id, String currentPassword, String newPassword) throws ServiceException {
        User user = userDao.get(id);

        if (user == null) {
            throw new ServiceException("Пользователя с id " + id + " нету в системе");
        }

        user.setPassword(MD5.hash(newPassword));
        userDao.update(user);
    }

    @Override
    public void resetPassword(long id, String newPassword) throws ServiceException {
        User user = userDao.get(id);

        user.setPassword(MD5.hash(newPassword));

        userDao.update(user);
    }

    @Override
    public boolean isArchiveUser(Long userId) {
        User user = userDao.get(userId);

        return user.isArchive();
    }

    @Override
    public void isLoginFree(String login) throws ServiceException {
        User userByLogin = userDao.getUserByLogin(login);

        if (userByLogin != null) {
            throw new ServiceException("Логин занят");
        }
    }
}
