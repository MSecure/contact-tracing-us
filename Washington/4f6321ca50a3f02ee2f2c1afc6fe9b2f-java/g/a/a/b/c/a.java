package g.a.a.b.c;

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
    public final Activity f3495d;

    /* renamed from: e  reason: collision with root package name */
    public final b<g.a.a.a.a> f3496e;

    /* renamed from: g.a.a.b.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0133a {
        g.a.a.b.a.a a();
    }

    public a(Activity activity) {
        this.f3495d = activity;
        this.f3496e = new b((ComponentActivity) activity);
    }

    public Object a() {
        if (this.f3495d.getApplication() instanceof b) {
            g.a.a.b.a.a a = ((AbstractC0133a) f.b.a.c.b.o.b.H0(this.f3496e, AbstractC0133a.class)).a();
            Activity activity = this.f3495d;
            a.c.C0066a aVar = (a.c.C0066a) a;
            Objects.requireNonNull(aVar);
            Objects.requireNonNull(activity);
            aVar.a = activity;
            f.b.a.c.b.o.b.v(activity, Activity.class);
            return new a.c.b(aVar.a, null);
        } else if (Application.class.equals(this.f3495d.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
            h2.append(this.f3495d.getApplication().getClass());
            throw new IllegalStateException(h2.toString());
        }
    }

    @Override // g.a.b.b
    public Object d() {
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
