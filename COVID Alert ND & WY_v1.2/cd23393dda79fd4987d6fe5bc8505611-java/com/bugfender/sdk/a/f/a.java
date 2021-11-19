package com.bugfender.sdk.a.f;

import java.lang.Thread;

public class a implements Thread.UncaughtExceptionHandler {
    private static final Thread.UncaughtExceptionHandler c = new C0022a();
    private final b a;
    private final Thread.UncaughtExceptionHandler b;

    /* renamed from: com.bugfender.sdk.a.f.a$a  reason: collision with other inner class name */
    static class C0022a implements Thread.UncaughtExceptionHandler {
        C0022a() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
        }
    }

    public a(b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = bVar;
        this.b = uncaughtExceptionHandler == null ? c : uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.a.a(c.a(thread, th));
        this.b.uncaughtException(thread, th);
    }
}
