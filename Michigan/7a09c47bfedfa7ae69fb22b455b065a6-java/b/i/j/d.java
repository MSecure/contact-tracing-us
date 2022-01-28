package b.i.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f1833a = new C0034d(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final c f1834b = new C0034d(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final c f1835c = new C0034d(a.f1837a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final c f1836d = new C0034d(a.f1837a, true);

    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f1837a = new a();

        @Override // b.i.j.d.b
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = d.a(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    public interface b {
        int a(CharSequence charSequence, int i, int i2);
    }

    public static abstract class c implements c {

        /* renamed from: a  reason: collision with root package name */
        public final b f1838a;

        public c(b bVar) {
            this.f1838a = bVar;
        }

        public abstract boolean a();

        public boolean b(CharSequence charSequence, int i, int i2) {
            if (i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            b bVar = this.f1838a;
            if (bVar == null) {
                return a();
            }
            int a2 = bVar.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: b.i.j.d$d  reason: collision with other inner class name */
    public static class C0034d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1839b;

        public C0034d(b bVar, boolean z) {
            super(bVar);
            this.f1839b = z;
        }

        @Override // b.i.j.d.c
        public boolean a() {
            return this.f1839b;
        }
    }

    public static int a(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
