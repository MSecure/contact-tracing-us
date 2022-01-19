package com.facebook.react.common;

import java.nio.charset.Charset;

public class StandardCharsets {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    static {
        Charset.forName("UTF-16");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
    }
}
