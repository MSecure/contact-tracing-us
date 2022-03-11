package f.b.a.c.c;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import f.b.a.c.e.b.b;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: f.b.a.c.c.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0088a extends f.b.a.c.e.b.a implements a {

        /* renamed from: f.b.a.c.c.a$a$a */
        /* loaded from: classes.dex */
        public static class C0089a extends b implements a {
            public C0089a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0088a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static a z(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof a ? (a) queryLocalInterface : new C0089a(iBinder);
        }
    }
}
