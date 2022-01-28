package b.t;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;

@SuppressLint({"RestrictedApi"})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public b.c.a.b.b<String, AbstractC0050b> f2579a = new b.c.a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f2580b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2581c;

    /* renamed from: d  reason: collision with root package name */
    public Recreator.a f2582d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2583e = true;

    public interface a {
        void a(d dVar);
    }

    /* renamed from: b.t.b$b  reason: collision with other inner class name */
    public interface AbstractC0050b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f2581c) {
            Bundle bundle = this.f2580b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f2580b.remove(str);
            if (this.f2580b.isEmpty()) {
                this.f2580b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(String str, AbstractC0050b bVar) {
        if (this.f2579a.g(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void c(Class<? extends a> cls) {
        if (this.f2583e) {
            if (this.f2582d == null) {
                this.f2582d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.f2582d;
                aVar.f391a.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                StringBuilder h = c.a.a.a.a.h("Class");
                h.append(cls.getSimpleName());
                h.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(h.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
