package com.netcracker.tc.client.application;

import com.google.gwt.core.client.GWT;

public class NameTokens {

    public static final String HOME = "home";
    public static final String HOME_DEV = "home_dev";
    public static final String HOME_QA = "home_qa";
    public static final String HOME_NC = "http://odessa.edu-netcracker.com";


    public static class Admin {
        public static final String USER_LIST = "admin.users";
    }

    public static class Hr {
        public static final String USER_INTERVIEW = "hr.users";
        public static final String INTERVIEW = "hr.interview";
        public static final String INTERVIEW_RESULT = "hr.interviewResult";
        public static final String SETTINGS = "hr.settings";
        public static final String MAIL = "hr.mail";
        public static final String USER_SUMMARY_REPORT = GWT.getHostPageBaseURL() + "/total-dev-result-report-xls";
    }

    public static class Interviewer {
        public static final String USERS = "interviewer.users";
    }

    public static class User {
        public static final String STEP_POSITION = "interview.position";
        public static final String STEP_RESUME = "interview.resume";
        public static final String STEP_REGISTRATION_ON_INTERVIEW = "interview.date";
        public static final String STEP_VERIFICATION_CV = "interview.verification";
        public static final String STEP_EDITING_CV = "interview.editing";
        public static final String STEP_SUBMISSION_CV = "interview.submission";
        public static final String QA_PAGE = "user.qa";
        public static final String RESUME = "user.resume";
        public static final String INTERVIEW = "user.interview";
        public static final String ENTRY_FOR_INTERVIEW = "user.entryInterview";
        public static final String BAD_RESUME = "user.goodbye";
    }
}