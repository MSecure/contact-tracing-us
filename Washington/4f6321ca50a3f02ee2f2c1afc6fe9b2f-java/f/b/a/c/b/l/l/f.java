package f.b.a.c.b.l.l;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import f.b.a.c.e.a.b;
import f.b.a.c.e.a.c;

public interface f extends IInterface {

    public static abstract class a extends f.b.a.c.e.a.a implements f {

        /* renamed from: f.b.a.c.b.l.l.f$a$a  reason: collision with other inner class name */
        public static class C0083a extends b implements f {
            public C0083a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }
        }

        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @RecentlyNonNull
        public static f E(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof f ? (f) queryLocalInterface : new C0083a(iBinder);
        }

        @Override // f.b.a.c.e.a.a
        @RecentlyNonNull
        public final boolean D(@RecentlyNonNull int i2, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i3) {
            if (i2 != 1) {
                return false;
            }
            f((Status) c.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void f(@RecentlyNonNull Status status);
}
