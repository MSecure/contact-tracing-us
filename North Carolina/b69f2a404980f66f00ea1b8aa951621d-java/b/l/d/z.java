package b.l.d;

import androidx.fragment.app.Fragment;
import b.n.f;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f1365a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f1366b;

    /* renamed from: c  reason: collision with root package name */
    public int f1367c;

    /* renamed from: d  reason: collision with root package name */
    public int f1368d;

    /* renamed from: e  reason: collision with root package name */
    public int f1369e;
    public int f;
    public boolean g;
    public boolean h = true;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;
    public ArrayList<Runnable> q;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1370a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f1371b;

        /* renamed from: c  reason: collision with root package name */
        public int f1372c;

        /* renamed from: d  reason: collision with root package name */
        public int f1373d;

        /* renamed from: e  reason: collision with root package name */
        public int f1374e;
        public int f;
        public f.b g;
        public f.b h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.f1370a = i;
            this.f1371b = fragment;
            f.b bVar = f.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }

        public a(int i, Fragment fragment, f.b bVar) {
            this.f1370a = i;
            this.f1371b = fragment;
            this.g = fragment.mMaxState;
            this.h = bVar;
        }
    }

    public z(m mVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.f1365a.add(aVar);
        aVar.f1372c = this.f1366b;
        aVar.f1373d = this.f1367c;
        aVar.f1374e = this.f1368d;
        aVar.f = this.f1369e;
    }

    public z c(String str) {
        if (this.h) {
            this.g = true;
            this.i = null;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int d();

    public abstract void e();

    public abstract void f();

    public void g(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder g2 = c.a.a.a.a.g("Fragment ");
            g2.append(cls.getCanonicalName());
            g2.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(g2.toString());
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.mFragmentId;
                if (i4 == 0 || i4 == i2) {
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        b(new a(i3, fragment));
    }

    public abstract z h(Fragment fragment);

    public z i(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            g(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public z j(Fragment fragment, f.b bVar) {
        b(new a(10, fragment, bVar));
        return this;
    }

    public z k(int i2) {
        this.f = i2;
        return this;
    }
}
