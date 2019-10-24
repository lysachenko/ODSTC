package com.netcracker.tc.server.util;

import com.netcracker.tc.server.servlet.Session;

import java.util.Date;

public class DateUtil {

    private static long SERVER_TIMEZONE_OFFSET = new Date().getTimezoneOffset() * 60000 * (-1);

    public static Date toServerTimezone(Date date){
        return new Date(date.getTime() - SERVER_TIMEZONE_OFFSET + Session.getTimezoneOffset());
    }

    public static Date toUserTimezone(Date date){
        return new Date(date.getTime() + SERVER_TIMEZONE_OFFSET - Session.getTimezoneOffset());
    }
}