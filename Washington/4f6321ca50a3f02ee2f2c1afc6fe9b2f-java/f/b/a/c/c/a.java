package f.b.a.c.c;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import f.b.a.c.e.b.b;

public interface a extends IInterface {

    /* renamed from: f.b.a.c.c.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0086a extends f.b.a.c.e.b.a implements a {

        /* renamed from: f.b.a.c.c.a$a$a  reason: collision with other inner class name */
        public static class C0087a extends b implements a {
            public C0087a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0086a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static a n(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0087a(iBinder);
        }
    }
}
