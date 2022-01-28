package com.bugfender.sdk.a.a.h;

import android.text.TextUtils;
import java.util.UUID;

public class e {
    private UUID a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Long f;
    private a g;

    public static final class b {
        private UUID a;
        private String b;
        private String c;
        private String d;
        private String e;
        private long f;
        private a g;

        private b() {
        }

        public b a(UUID uuid) {
            this.a = uuid;
            return this;
        }

        public b b(String str) {
            this.d = str;
            return this;
        }

        public b c(String str) {
            this.c = str;
            return this;
        }

        public b d(String str) {
            this.b = str;
            return this;
        }

        public b a(String str) {
            this.e = str;
            return this;
        }

        public b a(long j) {
            this.f = j;
            return this;
        }

        public b a(a aVar) {
            this.g = aVar;
            return this;
        }

        public e a() {
            return new e(this);
        }
    }

    public static b h() {
        return new b();
    }

    public void a(long j) {
        this.f = Long.valueOf(j);
    }

    public String b() {
        return this.e;
    }

    public Long c() {
        return this.f;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.b;
    }

    public UUID g() {
        return this.a;
    }

    private e(b bVar) {
        this.a = bVar.a;
        this.b = TextUtils.isEmpty(bVar.b) ? "issue" : bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = Long.valueOf(bVar.f);
        this.g = bVar.g;
    }

    public a a() {
        return this.g;
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    public e(UUID uuid, String str, String str2, long j, a aVar) {
        this.a = uuid;
        this.c = str;
        this.d = str2;
        this.f = Long.valueOf(j);
        this.g = aVar;
    }
}
