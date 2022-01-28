package com.bugfender.sdk.a.a.h;

import com.bugfender.sdk.a.a.e.c;

public class b {
    private a a;
    private String b;
    private String c;

    public b(a aVar, String str, String str2) {
        a(aVar, str, str2);
        this.a = aVar;
        this.b = str;
        this.c = str2;
    }

    public static b b(a aVar, String str, String str2) {
        return new b(aVar, str, str2);
    }

    public a a() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    private void a(a aVar, String str, String str2) {
        c.a(aVar, "Application must be not null");
        c.a(str, "Version name must be not null");
        c.a(str2, "Version code must be not null");
    }

    public String b() {
        return this.c;
    }
}
