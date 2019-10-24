package com.netcracker.tc.client.util;

public class FormatUtil {

    public static String format(final String format, final String ... args) {
        String[] split = format.split("%s");
        final StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < split.length - 1; i += 1) {
            buffer.append(split[i]);
            buffer.append(args[i]);
        }
        buffer.append(split[split.length - 1]);
        return buffer.toString();
    }
}