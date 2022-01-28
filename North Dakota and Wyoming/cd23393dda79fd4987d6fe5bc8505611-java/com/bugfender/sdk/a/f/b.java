package com.bugfender.sdk.a.f;

import com.bugfender.sdk.a.a.j.c;
import java.lang.Thread;

public class b {
    private final c<String> a;

    public b(c<String> cVar) {
        a a2 = a(this, Thread.getDefaultUncaughtExceptionHandler());
        this.a = cVar;
        a(a2);
    }

    public static b a(c<String> cVar) {
        return new b(cVar);
    }

    public void a(c cVar) {
        this.a.a(cVar.e());
        this.a.g();
    }

    private static a a(b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        return new a(bVar, uncaughtExceptionHandler);
    }

    private static void a(a aVar) {
        Thread.setDefaultUncaughtExceptionHandler(aVar);
    }
}
