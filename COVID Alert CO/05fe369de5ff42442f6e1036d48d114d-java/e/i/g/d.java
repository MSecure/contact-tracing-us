package e.i.g;

public final class d {
    public static final c a = new C0032d(null, false);
    public static final c b = new C0032d(null, true);
    public static final c c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f1287d;

    public static class a implements b {
        public static final a a = new a();

        @Override // e.i.g.d.b
        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i2));
                c cVar = d.a;
                if (directionality != 0) {
                    if (!(directionality == 1 || directionality == 2)) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i5 = 2;
                                break;
                        }
                        i2++;
                    }
                    i5 = 0;
                    i2++;
                }
                i5 = 1;
                i2++;
            }
            return i5;
        }
    }

    public interface b {
        int a(CharSequence charSequence, int i2, int i3);
    }

    public static abstract class c implements c {
        public final b a;

        public c(b bVar) {
            this.a = bVar;
        }

        public abstract boolean a();

        public boolean b(CharSequence charSequence, int i2, int i3) {
            if (i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            }
            b bVar = this.a;
            if (bVar == null) {
                return a();
            }
            int a2 = bVar.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: e.i.g.d$d  reason: collision with other inner class name */
    public static class C0032d extends c {
        public final boolean b;

        public C0032d(b bVar, boolean z) {
            super(bVar);
            this.b = z;
        }

        @Override // e.i.g.d.c
        public boolean a() {
            return this.b;
        }
    }

    static {
        a aVar = a.a;
        c = new C0032d(aVar, false);
        f1287d = new C0032d(aVar, true);
    }
}
