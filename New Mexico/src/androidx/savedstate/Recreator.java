package androidx.savedstate;

import android.os.Bundle;
import e.r.h;
import e.r.j;
import e.r.l;
import e.r.m;
import e.w.a;
import e.w.c;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class Recreator implements j {
    public final c a;

    /* loaded from: classes.dex */
    public static final class a implements a.b {
        public final Set<String> a = new HashSet();

        public a(e.w.a aVar) {
            aVar.b("androidx.savedstate.Restarter", this);
        }

        @Override // e.w.a.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.a));
            return bundle;
        }
    }

    public Recreator(c cVar) {
        this.a = cVar;
    }

    @Override // e.r.j
    public void d(l lVar, h.a aVar) {
        Class cls;
        if (aVar == h.a.ON_CREATE) {
            m mVar = (m) lVar.a();
            mVar.d("removeObserver");
            mVar.a.l(this);
            Bundle a2 = this.a.d().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            try {
                                Constructor declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(a.AbstractC0063a.class).getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((a.AbstractC0063a) declaredConstructor.newInstance(new Object[0])).a(this.a);
                                } catch (Exception e2) {
                                    throw new RuntimeException(f.a.a.a.a.x("Failed to instantiate ", next), e2);
                                }
                            } catch (NoSuchMethodException e3) {
                                StringBuilder h2 = f.a.a.a.a.h("Class");
                                h2.append(cls.getSimpleName());
                                h2.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(h2.toString(), e3);
                            }
                        } catch (ClassNotFoundException e4) {
                            throw new RuntimeException(f.a.a.a.a.c("Class ", next, " wasn't found"), e4);
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
