package e.w;

import android.os.Bundle;
import androidx.savedstate.Recreator;
/* loaded from: classes.dex */
public final class a {
    public Bundle b;
    public boolean c;

    /* renamed from: d */
    public Recreator.a f2106d;
    public e.c.a.b.b<String, b> a = new e.c.a.b.b<>();

    /* renamed from: e */
    public boolean f2107e = true;

    /* renamed from: e.w.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC0063a {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.c) {
            Bundle bundle = this.b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.b.remove(str);
            if (this.b.isEmpty()) {
                this.b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(String str, b bVar) {
        if (this.a.k(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void c(Class<? extends AbstractC0063a> cls) {
        if (this.f2107e) {
            if (this.f2106d == null) {
                this.f2106d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.f2106d;
                aVar.a.add(cls.getName());
            } catch (NoSuchMethodException e2) {
                StringBuilder h2 = f.a.a.a.a.h("Class");
                h2.append(cls.getSimpleName());
                h2.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(h2.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
