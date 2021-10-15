package c.b.a.a.d.m;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import b.x.t;
import c.b.a.a.d.m.b;
import c.b.a.a.g.c.c;

public interface j extends IInterface {

    public static abstract class a extends c.b.a.a.g.c.a implements j {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // c.b.a.a.g.c.a
        public final boolean e0(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                b.j jVar = (b.j) this;
                t.D(jVar.f3079a, "onPostInitComplete can be called only once per call to getRemoteService");
                jVar.f3079a.onPostInitHandler(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR), jVar.f3080b);
                jVar.f3079a = null;
            } else if (i == 2) {
                parcel.readInt();
                Bundle bundle = (Bundle) c.a(parcel, Bundle.CREATOR);
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            } else if (i != 3) {
                return false;
            } else {
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                b0 b0Var = (b0) c.a(parcel, b0.CREATOR);
                b.j jVar2 = (b.j) this;
                b bVar = jVar2.f3079a;
                t.D(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                t.C(b0Var);
                bVar.zza((b) b0Var);
                Bundle bundle2 = b0Var.f3083b;
                t.D(jVar2.f3079a, "onPostInitComplete can be called only once per call to getRemoteService");
                jVar2.f3079a.onPostInitHandler(readInt, readStrongBinder, bundle2, jVar2.f3080b);
                jVar2.f3079a = null;
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
