package g.b.a.c.c;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import f.b.a.a.a.k;
import g.b.b.b;
import java.util.Objects;

public class a implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Activity f3810d;

    /* renamed from: e  reason: collision with root package name */
    public final b<g.b.a.b.a> f3811e;

    /* renamed from: g.b.a.c.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0138a {
        g.b.a.c.a.a a();
    }

    public a(Activity activity) {
        this.f3810d = activity;
        this.f3811e = new c((ComponentActivity) activity);
    }

    public Object a() {
        if (this.f3810d.getApplication() instanceof b) {
            g.b.a.c.a.a a = ((AbstractC0138a) f.b.a.c.b.o.b.t0(this.f3811e, AbstractC0138a.class)).a();
            Activity activity = this.f3810d;
            k.a aVar = (k.a) a;
            Objects.requireNonNull(aVar);
            Objects.requireNonNull(activity);
            aVar.c = activity;
            d.a(activity, Activity.class);
            return new k.b(aVar.a, aVar.b, aVar.c);
        } else if (Application.class.equals(this.f3810d.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
            h2.append(this.f3810d.getApplication().getClass());
            throw new IllegalStateException(h2.toString());
        }
    }

    @Override // g.b.b.b
    public Object e() {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    this.b = a();
                }
            }
        }
        return this.b;
    }
}
