package com.bugfender.sdk.a.a.h;

public class d {
    public static final d d = new b().b(false).a(false).a(0).a();
    private final boolean a;
    private final boolean b;
    private final int c;

    public static class b {
        private boolean a;
        private boolean b;
        private int c;

        public b() {
        }

        public b a(boolean z) {
            this.a = z;
            return this;
        }

        public b b(boolean z) {
            this.b = z;
            return this;
        }

        public b(d dVar) {
            if (dVar == null) {
                this.a = d.d.c();
                this.c = d.d.a();
                this.b = d.d.b();
                return;
            }
            this.a = dVar.c();
            this.c = dVar.a();
            this.b = dVar.b();
        }

        public b a(int i) {
            this.c = i;
            return this;
        }

        public d a() {
            return new d(this.a, this.b, this.c);
        }
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.a;
    }

    private d(boolean z, boolean z2, int i) {
        this.a = z;
        this.b = z2;
        this.c = i;
    }
}
