package com.netcracker.tc.server.servlet;

import com.netcracker.tc.shared.exception.SessionExpiredException;
import nl.captcha.Captcha;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class Session {

    private static final String USER_ID = "userId";
    private static final String REGISTRATION_EMAIL_CODE = "registrationEmailCode";
    private static final String TIME_ZONE_OFFSET = "timezoneOffset";

    public static Long getUserId() {
        return (Long) (getSession().getAttribute(USER_ID));
    }

    public static void setUserId(Long id) {
        getSession().setAttribute(USER_ID, id);
    }

    public static Long getExistUserId() throws SessionExpiredException {
        Long userId = getUserId();

        if (userId == null) {
            throw new SessionExpiredException();
        }

        return userId;
    }

    public static Captcha getCaptcha() {
        Object captcha = getSession().getAttribute(Captcha.NAME);

        if (captcha != null) {
            return (Captcha) captcha;
        }

        return null;
    }

    public static String getRegistrationEmailCode() {
        return String.valueOf(getSession().getAttribute(REGISTRATION_EMAIL_CODE));
    }

    public static void setRegistrationEmailCode(String code) {
        getSession().setAttribute(REGISTRATION_EMAIL_CODE, code);
    }

    public static long getTimezoneOffset() {
        return (Long) getSession().getAttribute(TIME_ZONE_OFFSET);
    }

    public static void setTimezoneOffset(long timeZoneOffset) {
        getSession().setAttribute(TIME_ZONE_OFFSET, timeZoneOffset);
    }

    private static HttpSession getSession() {
        ServletRequestAttributes sra = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes());
        return sra.getRequest().getSession();
    }
}