package b.l.d;

import androidx.fragment.app.Fragment;
import b.o.f;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class i0 {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f2035a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public int f2036b;

    /* renamed from: c  reason: collision with root package name */
    public int f2037c;

    /* renamed from: d  reason: collision with root package name */
    public int f2038d;

    /* renamed from: e  reason: collision with root package name */
    public int f2039e;

    /* renamed from: f  reason: collision with root package name */
    public int f2040f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2041g;
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
        public int f2042a;

        /* renamed from: b  reason: collision with root package name */
        public Fragment f2043b;

        /* renamed from: c  reason: collision with root package name */
        public int f2044c;

        /* renamed from: d  reason: collision with root package name */
        public int f2045d;

        /* renamed from: e  reason: collision with root package name */
        public int f2046e;

        /* renamed from: f  reason: collision with root package name */
        public int f2047f;

        /* renamed from: g  reason: collision with root package name */
        public f.b f2048g;
        public f.b h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.f2042a = i;
            this.f2043b = fragment;
            f.b bVar = f.b.RESUMED;
            this.f2048g = bVar;
            this.h = bVar;
        }

        public a(int i, Fragment fragment, f.b bVar) {
            this.f2042a = i;
            this.f2043b = fragment;
            this.f2048g = fragment.mMaxState;
            this.h = bVar;
        }
    }

    public i0(v vVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.f2035a.add(aVar);
        aVar.f2044c = this.f2036b;
        aVar.f2045d = this.f2037c;
        aVar.f2046e = this.f2038d;
        aVar.f2047f = this.f2039e;
    }

    public i0 c(String str) {
        if (this.h) {
            this.f2041g = true;
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
            StringBuilder h2 = c.a.a.a.a.h("Fragment ");
            h2.append(cls.getCanonicalName());
            h2.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(h2.toString());
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

    public i0 h(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            g(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public i0 i(Fragment fragment, f.b bVar) {
        b(new a(10, fragment, bVar));
        return this;
    }

    public i0 j(int i2) {
        this.f2040f = i2;
        return this;
    }
}
