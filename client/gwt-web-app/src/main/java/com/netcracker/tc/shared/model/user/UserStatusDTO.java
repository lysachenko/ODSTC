package com.netcracker.tc.shared.model.user;

import com.netcracker.tc.client.application.NameTokens;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStatusDTO implements Serializable {
//TODO Create hash map instead values
    public static final long USER_STATUS_STEP_POSITION = 1;
    public static final long FILLING_CV = 2;
    public static final long REGISTRATION_ON_INTERVIEW = 3;
    public static final long USER_HAS_BAD_RESUME = 4;
    public static final long VERIFICATION_CV = 5;
    public static Map<Long,String> userStatus;
    public static Map<Long,String> userStatusDesctiprion;
    private long id;
    private String description;
    static {
        userStatus = new HashMap<Long, String>();
        userStatusDesctiprion = new HashMap<Long, String>();

        userStatus.put(FILLING_CV, NameTokens.User.STEP_RESUME);
        userStatusDesctiprion.put(FILLING_CV, "Заполнения анкеты");

        userStatus.put(VERIFICATION_CV, NameTokens.User.STEP_VERIFICATION_CV);
        userStatusDesctiprion.put(VERIFICATION_CV,"Ожидание HR проверки");

        userStatus.put(REGISTRATION_ON_INTERVIEW,NameTokens.User.STEP_REGISTRATION_ON_INTERVIEW);
        userStatusDesctiprion.put(REGISTRATION_ON_INTERVIEW,"Регистрации на собеседование");

        userStatus.put(USER_HAS_BAD_RESUME,NameTokens.User.BAD_RESUME);
        userStatusDesctiprion.put(USER_HAS_BAD_RESUME,"Неподходящего резюме");




    }

    public UserStatusDTO(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public UserStatusDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPresenterName() {
        return userStatus.get(id);
//        if (id == USER_STATUS_STEP_POSITION) {
//            return NameTokens.User.STEP_POSITION;
//        } else if (id == FILLING_CV) {
//            return NameTokens.User.STEP_RESUME;
//        } else if (id == REGISTRATION_ON_INTERVIEW) {
//            return NameTokens.User.STEP_REGISTRATION_ON_INTERVIEW;
//        } else if (id == USER_HAS_BAD_RESUME) {
//            return NameTokens.User.BAD_RESUME;
//        } else if (id == VERIFICATION_CV) {
//            return NameTokens.User.STEP_VERIFICATION_CV;
//        }
//
//        return null;
    }
}