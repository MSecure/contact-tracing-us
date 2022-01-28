package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import b.o.f;
import b.o.g;
import b.o.i;
import b.o.j;
import b.t.b;
import b.t.d;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements g {

    /* renamed from: a  reason: collision with root package name */
    public final d f390a;

    public static final class a implements b.AbstractC0050b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f391a = new HashSet();

        public a(b bVar) {
            bVar.b("androidx.savedstate.Restarter", this);
        }

        @Override // b.t.b.AbstractC0050b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f391a));
            return bundle;
        }
    }

    public Recreator(d dVar) {
        this.f390a = dVar;
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        Class cls;
        if (aVar == f.a.ON_CREATE) {
            j jVar = (j) iVar.getLifecycle();
            jVar.d("removeObserver");
            jVar.f2220a.h(this);
            Bundle a2 = this.f390a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            try {
                                Constructor<? extends U> declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(b.a.class).getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((b.a) declaredConstructor.newInstance(new Object[0])).a(this.f390a);
                                } catch (Exception e2) {
                                    throw new RuntimeException(c.a.a.a.a.q("Failed to instantiate ", next), e2);
                                }
                            } catch (NoSuchMethodException e3) {
                                StringBuilder h = c.a.a.a.a.h("Class");
                                h.append(cls.getSimpleName());
                                h.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(h.toString(), e3);
                            }
                        } catch (ClassNotFoundException e4) {
                            throw new RuntimeException(c.a.a.a.a.c("Class ", next, " wasn't found"), e4);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
