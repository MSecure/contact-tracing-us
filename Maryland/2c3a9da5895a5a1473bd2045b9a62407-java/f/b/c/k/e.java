package f.b.c.k;

public abstract class e {
    public static final C0115e a = new C0115e();

    public static class a extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.arrayRemove";
        }
    }

    public static class b extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.arrayUnion";
        }
    }

    public static class c extends e {
    }

    public static class d extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.increment";
        }
    }

    /* renamed from: f.b.c.k.e$e  reason: collision with other inner class name */
    public static class C0115e extends e {
        @Override // f.b.c.k.e
        public String a() {
            return "FieldValue.serverTimestamp";
        }
    }

    public abstract String a();
}
