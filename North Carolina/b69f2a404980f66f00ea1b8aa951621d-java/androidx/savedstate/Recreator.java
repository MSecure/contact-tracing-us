package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import b.n.f;
import b.n.g;
import b.n.i;
import b.n.j;
import b.s.a;
import b.s.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class Recreator implements g {

    /* renamed from: a  reason: collision with root package name */
    public final c f284a;

    public static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<String> f285a = new HashSet();

        public a(b.s.a aVar) {
            if (aVar.f1707a.h("androidx.savedstate.Restarter", this) != null) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
        }

        @Override // b.s.a.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f285a));
            return bundle;
        }
    }

    public Recreator(c cVar) {
        this.f284a = cVar;
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        Class cls;
        if (aVar == f.a.ON_CREATE) {
            ((j) iVar.getLifecycle()).f1391a.j(this);
            Bundle a2 = this.f284a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            try {
                                Constructor<? extends U> declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(a.AbstractC0040a.class).getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((a.AbstractC0040a) declaredConstructor.newInstance(new Object[0])).a(this.f284a);
                                } catch (Exception e2) {
                                    throw new RuntimeException(c.a.a.a.a.o("Failed to instantiate ", next), e2);
                                }
                            } catch (NoSuchMethodException e3) {
                                StringBuilder g = c.a.a.a.a.g("Class");
                                g.append(cls.getSimpleName());
                                g.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(g.toString(), e3);
                            }
                        } catch (ClassNotFoundException e4) {
                            throw new RuntimeException(c.a.a.a.a.p("Class ", next, " wasn't found"), e4);
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
