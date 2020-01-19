package com.netcracker.tc.server.persistence.model_eav;

public class ObjType {

    public static final int TYPE_ID_USERS = 1;
    public static final int TYPE_ID_USER_STATUS = 2;
    public static final int TYPE_ID_STUDENT_DETAIL = 3;
    public static final int TYPE_ID_ROLE = 4;
    public static final int TYPE_ID_RESUME_STATUS = 5;
    public static final int TYPE_ID_RESUME_KNOWLEDGE = 6;
    public static final int TYPE_ID_RESUME = 7;
    public static final int TYPE_ID_QA_RESUME_DETAIL = 8;
    public static final int TYPE_ID_QA_INTERVIEW_RESULT_DETAIL = 9;
    public static final int TYPE_ID_POSITION = 10;
    public static final int TYPE_ID_MAIL_QUEUE = 11;
    public static final int TYPE_ID_KNOWLEDGE_TYPE = 12;
    public static final int TYPE_ID_INTERVIEW_SLOT = 13;
    public static final int TYPE_ID_INTERVIEW_RESULT = 14;
    public static final int TYPE_ID_INTERVIEW = 15;
    public static final int TYPE_ID_INSTITUTE = 16;
    public static final int TYPE_ID_DEV_RESUME_DETAIL = 17;
    public static final int TYPE_ID_DEV_INTERVIEW_RESULT_DETAIL = 18;

    public static final String CODE_USERS = "USERS";
    public static final String CODE_USER_STATUS = "USER_STATUS";
    public static final String CODE_STUDENT_DETAIL = "STUDENT_DETAIL";
    public static final String CODE_ROLE = "ROLE";
    public static final String CODE_RESUME_STATUS = "RESUME_STATUS";
    public static final String CODE_RESUME_KNOWLEDGE = "RESUME_KNOWLEDGE";
    public static final String CODE_RESUME = "RESUME";
    public static final String CODE_QA_RESUME_DETAIL = "QA_RESUME_DETAIL";
    public static final String CODE_QA_INTERVIEW_RESULT_DETAIL = "QA_INTERVIEW_RESULT_DETAIL";
    public static final String CODE_POSITION = "POSITION";
    public static final String CODE_MAIL_QUEUE = "MAIL_QUEUE";
    public static final String CODE_KNOWLEDGE_TYPE = "KNOWLEDGE_TYPE";
    public static final String CODE_INTERVIEW_SLOT = "INTERVIEW_SLOT";
    public static final String CODE_INTERVIEW_RESULT = "INTERVIEW_RESULT";
    public static final String CODE_INTERVIEW = "INTERVIEW";
    public static final String CODE_INSTITUTE = "INSTITUTE";
    public static final String CODE_DEV_RESUME_DETAIL = "DEV_RESUME_DETAIL";
    public static final String CODE_DEV_INTERVIEW_RESULT_DETAIL = "DEV_INTERVIEW_RESULT_DETAIL";


    private Integer objectTypeId;
    private Integer parentId;
    private String code;
    private String name;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Integer objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}