package com.redwrenchdigital.eclipse.util;

public abstract class StringUtils {

    public static String joinFilePath(String a, String b) {
        String x = System.getProperty("file.separator");
        a = (a == null) ? "" : a;
        b = (b == null) ? "" : b;

        int n = 0;
        if (a != null && a.endsWith(x))
            n++;
        if (b != null && b.startsWith(x))
            n++;

        StringBuffer sb = new StringBuffer();
        sb.append(a);
        if (n == 0)
            sb.append(x);
        if (n == 2)
            sb.append(b.substring(1));
        else
            sb.append(b);
        return sb.toString();
    }
}
