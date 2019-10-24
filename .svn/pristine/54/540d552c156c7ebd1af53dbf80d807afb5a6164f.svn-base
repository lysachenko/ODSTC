package com.netcracker.tc.server.persistence.Test;

import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.common.PagingLoadConfig;
import com.netcracker.tc.server.persistence.model.common.PagingLoadResult;
import com.netcracker.tc.server.persistence.model.resume.ResumeStatus;
import com.netcracker.tc.server.persistence.model.user.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by unconsionable on 29.07.2014.
 */
public class Main {

    public static Role ROLE_USER;
    public static Role ROLE_ADMIN;
    public static Role ROLE_INTERVIEWER;
    public static Role ROLE_HR;

    public static UserStatus USER_STATUS_STEP1;
    public static UserStatus USER_STATUS_STEP2;
    public static UserStatus USER_STATUS_STEP3;

    public static Position POSITION_QA;
    public static Position POSITION_DEV;

    public static ResumeStatus RESUME_STATUS_NOT_CHECKED;
    public static ResumeStatus RESUME_STATUS_CORRECT;
    public static ResumeStatus RESUME_STATUS_ERROR;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate4Config.xml");

        SessionFactory bean = context.getBean(SessionFactory.class);
        initStaticData(bean);
//        initAdmin(context);

        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.getUser("admin", "admin");
        System.out.println(user.getId());

//        PagingLoadConfig loadConfig = new PagingLoadConfig(0, 50);
//        PagingLoadResult<User> result = userDao.loadUsers(loadConfig);

//        System.out.println("Paging Load Result: ");
//        for (User userR: result.getItems()){
//            System.out.println("ResultUser: " + userR.getId() + " " +userR.getLogin() + " " + userR.getPassword());
//        }

//        User readUser = userDao.get(user.getId());
//
//        System.out.println(readUser.getId() + " "
//                        + readUser.getLogin() + " "
//                        + readUser.getPassword() + " "
//                        + readUser.getRole() + " "
//        + readUser.getStudentDetail()
//        );
//
//        user = new User();
//        user.setLogin("admin");
//        user.setPassword("admin");
//        user.setRole(ROLE_ADMIN);
//
//        userDao.create(user);
//
//        System.out.println(user.getId());
//
//        readUser = userDao.get(user.getId());
//
//        System.out.println(readUser.getId() + " " + readUser.getLogin() + " " + readUser.getPassword() + " " + readUser.getRole() + " " +readUser.getStudentDetail());
//
//        testInterviewDao(context);

    }

    private static void initAdmin(ClassPathXmlApplicationContext context) {
        UserDao userDao = context.getBean(UserDao.class);

        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        user.setRole(ROLE_ADMIN);

        userDao.create(user);
    }

    public static void initStaticData(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ROLE_USER = new Role("User");
        ROLE_USER.setId(1L);
        ROLE_ADMIN = new Role("Admin");
        ROLE_ADMIN.setId(2L);
        ROLE_INTERVIEWER = new Role("Interviewer");
        ROLE_INTERVIEWER.setId(3L);
        ROLE_HR = new Role("Hr");
        ROLE_HR.setId(4L);

        POSITION_QA = new Position("QA");
        POSITION_QA.setId(1L);
        POSITION_DEV = new Position("Dev");
        POSITION_DEV.setId(2L);

        USER_STATUS_STEP1 = new UserStatus("UserStatusStep1");
        USER_STATUS_STEP1.setId(1L);
        USER_STATUS_STEP2 = new UserStatus("UserStatusStep2");
        USER_STATUS_STEP2.setId(2L);
        USER_STATUS_STEP3 = new UserStatus("UserStatusStep3");
        USER_STATUS_STEP3.setId(3L);

        RESUME_STATUS_NOT_CHECKED = new ResumeStatus(1L ,"NOT_CHECKED");
        RESUME_STATUS_CORRECT = new ResumeStatus(2L ,"CORRECT");
        RESUME_STATUS_ERROR = new ResumeStatus(3L ,"ERROR");

        session.saveOrUpdate(ROLE_USER);
        session.saveOrUpdate(ROLE_ADMIN);
        session.saveOrUpdate(ROLE_INTERVIEWER);
        session.saveOrUpdate(ROLE_HR);
        session.saveOrUpdate(POSITION_QA);
        session.saveOrUpdate(POSITION_DEV);
        session.saveOrUpdate(USER_STATUS_STEP1);
        session.saveOrUpdate(USER_STATUS_STEP2);
        session.saveOrUpdate(USER_STATUS_STEP3);
        session.saveOrUpdate(RESUME_STATUS_NOT_CHECKED);
        session.saveOrUpdate(RESUME_STATUS_CORRECT);
        session.saveOrUpdate(RESUME_STATUS_ERROR);
        session.getTransaction().commit();
    }
}