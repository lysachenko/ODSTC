package com.netcracker.tc.server.persistence.dao.api;

import com.netcracker.tc.server.persistence.dao.common.IDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.resume.Institute;
import com.netcracker.tc.server.persistence.model.user.*;

import java.util.List;

/**
 * Created by unconsionable on 15.06.2014.
 */
public interface UserDao extends IDao<User, Long> {

    public static final long ROLE_USER_ID = 1;
    public static final long ROLE_ADMIN_ID = 2;
    public static final long ROLE_INTERVIEWER_ID = 3;
    public static final long ROLE_HR_ID = 4;

    User getUser(String login, String password);

    Role getRole(Long roleId);

    void createRole(Role role);

    UserStatus getUserStatus(Long userStatusId);

    void createUserStatus(UserStatus userStatus);

    Position getPosition(Long positionId);

    void createPosition(Position position);

    StudentDetail getStudentDetail(Long userId);

    User getUserByLogin(String login);

    PagingLoadResult<User> loadUsers(PagingLoadConfig loadConfig, UserPagingFilter filter);

    void update(StudentDetail studentDetail);
    
    List<User> getAllStudents();
}