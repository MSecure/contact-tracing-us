package com.bugfender.sdk.a.a.h;

import java.util.Objects;

public class a {
    private String a;

    public a(String str) {
        a(str);
        this.a = str;
    }

    public static a b(String str) {
        return new a(str);
    }

    public String a() {
        return this.a;
    }

    private void a(String str) {
        Objects.requireNonNull(str, "Key must be not null");
    }
}
