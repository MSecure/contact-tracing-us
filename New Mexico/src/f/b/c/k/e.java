package f.b.c.k;
/* loaded from: classes.dex */
public abstract class e {
    public static final C0116e a = new C0116e();

    /* loaded from: classes.dex */
    public static class a extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.arrayRemove";
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.arrayUnion";
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e {
    }

    /* loaded from: classes.dex */
    public static class d extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.increment";
        }
    }

    /* renamed from: f.b.c.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0116e extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.serverTimestamp";
        }
    }

    public abstract String a();
}
