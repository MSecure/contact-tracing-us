package f.b.a.c.b.m;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import e.b.a.m;
import f.b.a.c.b.m.b;
import f.b.a.c.e.b.c;
import java.util.Objects;

public interface i extends IInterface {

    public static abstract class a extends f.b.a.c.e.b.a implements i {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // f.b.a.c.e.b.a
        public final boolean k(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                ((b.j) this).q(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                parcel.readInt();
                Bundle bundle = (Bundle) c.a(parcel, Bundle.CREATOR);
                new Exception();
            } else if (i2 != 3) {
                return false;
            } else {
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                z zVar = (z) c.a(parcel, z.CREATOR);
                b.j jVar = (b.j) this;
                b bVar = jVar.a;
                m.h.p(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                Objects.requireNonNull(zVar, "null reference");
                bVar.t = zVar;
                jVar.q(readInt, readStrongBinder, zVar.b);
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
