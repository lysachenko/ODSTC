package com.netcracker.tc.server.persistence.Test;

import com.netcracker.tc.server.persistence.dao.api.InterviewDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.interview.DevInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.interview.InterviewResult;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import com.netcracker.tc.server.persistence.model.interview.QAInterviewResultDetail;
import com.netcracker.tc.server.persistence.model.resume.Resume;
import com.netcracker.tc.server.persistence.model.user.StudentDetail;
import com.netcracker.tc.server.persistence.model.user.User;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by unconsionable on 11.09.2014.
 */
public class Main_TestInterviewResult {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate4Config.xml");
        SessionFactory bean = context.getBean(SessionFactory.class);

        InterviewDao interviewDao = context.getBean(InterviewDao.class);
        UserDao userDao = context.getBean(UserDao.class);
        User user = userDao.get(2L);

        InterviewSlot interviewSlot = interviewDao.getInterviewSlot(17L);


        InterviewResult interviewResult = new InterviewResult();
        interviewResult.setInterviewSlotId(interviewSlot.getId());
        interviewResult.setIsCome(true);

        interviewDao.create(interviewResult);

        interviewResult.setDevInterviewResultDetail(new DevInterviewResultDetail());
        interviewResult.getDevInterviewResultDetail().setInterviewResult(interviewResult);

        interviewDao.createOrUpdate(interviewResult);


    }
}
