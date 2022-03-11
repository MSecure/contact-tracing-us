package g.b.a.c.c;

import android.app.Activity;
import android.app.Application;
import androidx.activity.ComponentActivity;
import f.b.a.a.a.k;
import g.b.b.b;
import java.util.Objects;
/* loaded from: classes.dex */
public class a implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d */
    public final Activity f4065d;

    /* renamed from: e */
    public final b<g.b.a.b.a> f4066e;

    /* renamed from: g.b.a.c.c.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC0140a {
        g.b.a.c.a.a a();
    }

    public a(Activity activity) {
        this.f4065d = activity;
        this.f4066e = new c((ComponentActivity) activity);
    }

    public Object a() {
        if (this.f4065d.getApplication() instanceof b) {
            g.b.a.c.a.a a = ((AbstractC0140a) f.b.a.c.b.o.b.u0(this.f4066e, AbstractC0140a.class)).a();
            Activity activity = this.f4065d;
            k.a aVar = (k.a) a;
            Objects.requireNonNull(aVar);
            Objects.requireNonNull(activity);
            aVar.c = activity;
            d.a(activity, Activity.class);
            return new k.b(aVar.a, aVar.b, aVar.c);
        } else if (Application.class.equals(this.f4065d.getApplication().getClass())) {
            throw new IllegalStateException("Hilt Activity must be attached to an @HiltAndroidApp Application. Did you forget to specify your Application's class name in your manifest's <application />'s android:name attribute?");
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Hilt Activity must be attached to an @AndroidEntryPoint Application. Found: ");
            h2.append(this.f4065d.getApplication().getClass());
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
