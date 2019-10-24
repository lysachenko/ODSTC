package com.netcracker.tc.server.persistence.dao.impl;

import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.dao.common.AbstractHibernateDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.user.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@Repository
public class UserDaoImpl extends AbstractHibernateDao<User, Long> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }


    @Override
    public User getUser(String login, String password) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login).ignoreCase());
        criteria.add(Restrictions.eq("password", password));
        criteria.add(Restrictions.eq("archive", false));

        List<User> userList = criteria.list();

        if (userList.isEmpty()) {
            return null;
        }

        return userList.get(0);
    }

    @Override
    public Role getRole(Long roleId) {
        return (Role) getCurrentSession().get(Role.class, roleId);
    }

    @Override
    public void createRole(Role role) {
        getCurrentSession().saveOrUpdate(role);
    }

    @Override
    public UserStatus getUserStatus(Long userStatusId) {
        return (UserStatus) getCurrentSession().get(UserStatus.class, userStatusId);
    }

    @Override
    public void createUserStatus(UserStatus userStatus) {
        getCurrentSession().saveOrUpdate(userStatus);
    }

    @Override
    public Position getPosition(Long positionId) {
        return (Position) getCurrentSession().get(Position.class, positionId);
    }

    @Override
    public void createPosition(Position position) {
        getCurrentSession().saveOrUpdate(position);
    }

    @Override
    public StudentDetail getStudentDetail(Long userId) {
        return (StudentDetail) getCurrentSession().get(StudentDetail.class, userId);
    }

    @Override
    public User getUserByLogin(String login) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login).ignoreCase());
        criteria.add(Restrictions.eq("archive", false));
        List<User> userList = criteria.list();

        if (userList.isEmpty()) {
            return null;
        }

        return userList.get(0);
    }

    @Override
    public PagingLoadResult<User> loadUsers(PagingLoadConfig loadConfig, UserPagingFilter filter) {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        Criteria resumeCriteria = null;
        Criteria studentDetailCriteria = null;


        if (!StringUtils.isEmpty(filter.getName())) {
            String name = "%" + filter.getName() + "%";
            if (resumeCriteria == null) {
                resumeCriteria = criteria.createCriteria("resume");
            }

            resumeCriteria.add(
                    Restrictions.or(
                            Restrictions.ilike("name", name),
                            Restrictions.ilike("lastName", name),
                            Restrictions.ilike("surname", name)
                    ));
        }

        if (filter.getRoleId() != null) {
            criteria.add(Restrictions.eq("role.id", filter.getRoleId()));
        }

        if (filter.getPositionId() != null) {
            studentDetailCriteria = criteria.createCriteria("studentDetail");
            studentDetailCriteria.add(Restrictions.eq("position.id", filter.getPositionId()));
        }

        if (filter.getUsedStatusId() != null) {
            if (studentDetailCriteria == null) {
                studentDetailCriteria = criteria.createCriteria("studentDetail");
            }
            studentDetailCriteria.add(Restrictions.eq("userStatus.id", filter.getUsedStatusId()));

        }

        if (!StringUtils.isEmpty(filter.getEmail())) {
            if (resumeCriteria == null) {
                resumeCriteria = criteria.createCriteria("resume");
            }
            resumeCriteria.add(Restrictions.ilike("email", "%" + filter.getEmail() + "%"));
        }

        if (!StringUtils.isEmpty(filter.getTelephone())) {
            if (resumeCriteria == null) {
                resumeCriteria = criteria.createCriteria("resume");
            }

            resumeCriteria.add(Restrictions.like("telephoneNum", "%" + filter.getTelephone() + "%"));
        }


//        if (filter.getDevResultInterview() != null || filter.getHrResultInterview() != null){
//            criteria.add(Restrictions.isNotEmpty("interviewSlots"));
//            Criteria interviewSlotsCriteria = criteria.createCriteria("interviewSlots");
//            Criteria interviewResult = interviewSlotsCriteria.createCriteria("interviewResult");
//            if (filter.getHrResultInterview().equals(Boolean.TRUE)) {
//                interviewResult.add(Restrictions.isNotNull("hr"));
//            }
//
//            if (filter.getDevResultInterview().equals(Boolean.TRUE)){
//                interviewResult.add(Restrictions.isNotNull("interviewer"));
//            }
//        }

        PagingLoadResult<User> result = loadPagingData(criteria, loadConfig);

        return result;
    }

    @Override
    public void update(StudentDetail studentDetail) {
        getCurrentSession().update(studentDetail);
    }

    public List<User> getAllStudents() {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("role.id", 1L));
        criteria.add(Restrictions.eq("archive", false));
        criteria.add(Restrictions.isNotEmpty("interviewSlots"));
        List<User> userList = criteria.list();

        return userList;
    }


}