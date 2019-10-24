package com.netcracker.tc.server.persistence.Test;

import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.StudentDetail;
import com.netcracker.tc.server.persistence.model.user.User;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_TestCreateUser {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate4Config.xml");
        SessionFactory bean = context.getBean(SessionFactory.class);

        UserDao userDao = context.getBean(UserDao.class);

        Main.initStaticData(bean);

        User user = new User();
        user.setLogin("Yes");
        user.setPassword("dadada");
        user.setRole(userDao.getRole(1L));

        Resume resume = new Resume();
        resume.setEmail("t1");
        resume.setName("t2");
        resume.setSurname("t3");
        resume.setSkype("t4");
        resume.setTelephoneNum("3486343");
        resume.setUser(user);

        user.setResume(resume);

        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setUserStatus(userDao.getUserStatus(1L));
        studentDetail.setUser(user);
        user.setStudentDetail(studentDetail);

        userDao.create(user);
    }
}