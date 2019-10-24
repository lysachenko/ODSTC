package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.user.UserDTO;
import com.netcracker.tc.shared.model.user.UserStatusDTO;

public interface UserService {

    void editUserStatus(Long userId, UserStatusDTO userStatusDTO) throws ServiceException;

    PagingLoadResultDTO<UserDTO> getUsers(PagingLoadConfigDTO loadConfig, UserPagingFilterDTO filter) throws ServiceException;

    UserDTO getUser(long id) throws ServiceException;

    UserDTO loginUser(String login, String password) throws ServiceException;

    void addUser(UserDTO userDTO) throws ServiceException;

    void addStudent(UserDTO userDTO) throws ServiceException;

    void deleteUser(long id) throws ServiceException;

    void isLoginFree(String login) throws ServiceException;

    void changePassword(long id, String currentPassword, String newPassword) throws ServiceException;

    void resetPassword(long id, String newPassword) throws ServiceException;

    boolean isArchiveUser(Long userId);
}