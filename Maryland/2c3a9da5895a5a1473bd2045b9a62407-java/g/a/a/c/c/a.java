package g.a.a.c.c;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import f.b.a.a.a.a;
import g.a.b.b;
import java.util.Objects;

public class a implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Activity f3591d;

    /* renamed from: e  reason: collision with root package name */
    public final b<g.a.a.b.a> f3592e;

    /* renamed from: g.a.a.c.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0138a {
        g.a.a.c.a.a a();
    }

    public a(Activity activity) {
        this.f3591d = activity;
        this.f3592e = new b((ComponentActivity) activity);
    }

    public Object a() {
        if (this.f3591d.getApplication() instanceof b) {
            g.a.a.c.a.a a = ((AbstractC0138a) f.b.a.c.b.o.b.H0(this.f3592e, AbstractC0138a.class)).a();
            Activity activity = this.f3591d;
            a.c.C0069a aVar = (a.c.C0069a) a;
            Objects.requireNonNull(aVar);
            Objects.requireNonNull(activity);
            aVar.a = activity;
            f.b.a.c.b.o.b.v(activity, Activity.class);
            return new a.c.b(aVar.a, null);
        } else if (Application.class.equals(this.f3591d.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
            h2.append(this.f3591d.getApplication().getClass());
            throw new IllegalStateException(h2.toString());
        }
    }

    @Override // g.a.b.b
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
