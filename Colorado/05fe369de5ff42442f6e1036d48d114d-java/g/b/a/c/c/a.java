package g.b.a.c.c;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import f.b.a.a.a.b;
import g.b.b.b;
import java.util.Objects;

public class a implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final Activity f3745d;

    /* renamed from: e  reason: collision with root package name */
    public final b<g.b.a.b.a> f3746e;

    /* renamed from: g.b.a.c.c.a$a  reason: collision with other inner class name */
    public interface AbstractC0138a {
        g.b.a.c.a.a a();
    }

    public a(Activity activity) {
        this.f3745d = activity;
        this.f3746e = new b((ComponentActivity) activity);
    }

    public Object a() {
        if (this.f3745d.getApplication() instanceof b) {
            g.b.a.c.a.a a = ((AbstractC0138a) f.b.a.c.b.o.b.t0(this.f3746e, AbstractC0138a.class)).a();
            Activity activity = this.f3745d;
            b.c.a aVar = (b.c.a) a;
            Objects.requireNonNull(aVar);
            Objects.requireNonNull(activity);
            aVar.a = activity;
            c.a(activity, Activity.class);
            return new b.c.C0068b(aVar.a, null);
        } else if (Application.class.equals(this.f3745d.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        } else {
            StringBuilder i2 = f.a.a.a.a.i("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
            i2.append(this.f3745d.getApplication().getClass());
            throw new IllegalStateException(i2.toString());
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
