package c.b.a.a.e;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import c.b.a.a.g.c.b;

public interface a extends IInterface {

    /* renamed from: c.b.a.a.e.a$a  reason: collision with other inner class name */
    public static abstract class AbstractBinderC0068a extends c.b.a.a.g.c.a implements a {

        /* renamed from: c.b.a.a.e.a$a$a  reason: collision with other inner class name */
        public static class C0069a extends b implements a {
            public C0069a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0068a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static a f0(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0069a(iBinder);
        }
    }
}
