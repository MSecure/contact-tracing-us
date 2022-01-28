package com.bugfender.sdk.a.c.j;

import java.net.MalformedURLException;
import java.net.URL;

public class a {
    private final String a;
    private final String b;

    public a(String str, String str2) {
        this.b = str2;
        this.a = com.bugfender.sdk.a.c.a.a(str);
    }

    public URL a(String str) {
        return a("device", str);
    }

    public URL b(String str) {
        return a("issue", str);
    }

    public URL c(String str) {
        return a("session", str);
    }

    private URL a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder(this.b);
            if (!this.b.endsWith("/")) {
                sb.append("/");
            }
            if (!this.b.contains("intent")) {
                sb.append("intent");
                sb.append("/");
            }
            sb.append(this.a);
            sb.append("/");
            sb.append(str);
            sb.append("/");
            sb.append(str2);
            return new URL(sb.toString());
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
