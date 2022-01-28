package b.s;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;

@SuppressLint({"RestrictedApi"})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public b.c.a.b.b<String, b> f1707a = new b.c.a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f1708b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1709c;

    /* renamed from: d  reason: collision with root package name */
    public Recreator.a f1710d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1711e = true;

    /* renamed from: b.s.a$a  reason: collision with other inner class name */
    public interface AbstractC0040a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f1709c) {
            Bundle bundle = this.f1708b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f1708b.remove(str);
            if (this.f1708b.isEmpty()) {
                this.f1708b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(Class<? extends AbstractC0040a> cls) {
        if (this.f1711e) {
            if (this.f1710d == null) {
                this.f1710d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.f1710d;
                aVar.f285a.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                StringBuilder g = c.a.a.a.a.g("Class");
                g.append(cls.getSimpleName());
                g.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(g.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
