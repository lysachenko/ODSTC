package com.netcracker.tc.server.persistence.Test;

import com.netcracker.tc.server.persistence.dao.api.InterviewDao;
import com.netcracker.tc.server.persistence.dao.api.UserDao;
import com.netcracker.tc.server.persistence.model.interview.Interview;
import com.netcracker.tc.server.persistence.model.interview.InterviewSlot;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by unconsionable on 21.08.2014.
 */
public class Main_TestCreateInterview {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate4Config.xml");
        SessionFactory bean = context.getBean(SessionFactory.class);

        InterviewDao interviewDao = context.getBean(InterviewDao.class);
        UserDao userDao = context.getBean(UserDao.class);

        Map m = new HashMap();

        Main.initStaticData(bean);

        Interview interview = new Interview();
        interview.setInterviewDate(new Date());
        interview.setPosition(userDao.getPosition(1L));
        interview.setStartTime(500L * 60 * 1000 );
        interview.setInterviewerTimeForInterview(14);
        interview.setInterviewerCount(3);
        interview.setHrCount(5);
        interview.setHrTimeForInterview(10);
        interview.setEnable(true);
        interview.setEndTime(800L * 60 * 1000 );

        Set<InterviewSlot> interviewSlots = createInterviewSlots(interview, interviewDao);
        interview.setTotalPlaceCount(interviewSlots.size());
        interview.setAvailablePlaceCount(interviewSlots.size());


        System.out.println("INTERVIEW: " + interview.getId());

        interview.setInterviewSlots(interviewSlots);

        for (InterviewSlot slot: interviewSlots){
            slot.setInterview(interview);
        }

        interviewDao.create(interview);

    }

    private static Set<InterviewSlot> createInterviewSlots(Interview interview, InterviewDao interviewDao) {
        Set<InterviewSlot> interviewSlots = new HashSet<InterviewSlot>();

        int interviewCount = 0;
        int timeForInterview = 0;
        if (interview.getHrCount() * interview.getHrTimeForInterview() > interview.getInterviewerCount() * interview.getInterviewerTimeForInterview()) {
            interviewCount = interview.getInterviewerCount();
            timeForInterview = interview.getInterviewerTimeForInterview();
        } else {
            interviewCount = interview.getHrCount();
            timeForInterview = interview.getHrTimeForInterview();
        }

        for (long startTime = interview.getStartTime(); startTime < interview.getEndTime(); startTime += timeForInterview * 60 * 1000) {
            for (int n = 0; n < interviewCount; n++) {
                InterviewSlot slot = new InterviewSlot();
                slot.setTime(startTime);
                slot.setInterview(interview);

                interviewSlots.add(slot);
            }
        }

        return interviewSlots;
    }
}