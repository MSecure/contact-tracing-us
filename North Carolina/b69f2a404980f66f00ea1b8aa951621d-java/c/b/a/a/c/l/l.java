package c.b.a.a.c.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.util.Log;
import b.b.k.i;
import c.b.a.a.c.l.b;
import c.b.a.a.e.b.c;

public interface l extends IInterface {

    public static abstract class a extends c.b.a.a.e.b.a implements l {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // c.b.a.a.e.b.a
        public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                b.j jVar = (b.j) this;
                i.j.t(jVar.f2429a, "onPostInitComplete can be called only once per call to getRemoteService");
                jVar.f2429a.onPostInitHandler(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR), jVar.f2430b);
                jVar.f2429a = null;
            } else if (i == 2) {
                parcel.readInt();
                Bundle bundle = (Bundle) c.a(parcel, Bundle.CREATOR);
                Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            } else if (i != 3) {
                return false;
            } else {
                int readInt = parcel.readInt();
                IBinder readStrongBinder = parcel.readStrongBinder();
                a0 a0Var = (a0) c.a(parcel, a0.CREATOR);
                b.j jVar2 = (b.j) this;
                i.j.t(jVar2.f2429a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
                i.j.s(a0Var);
                jVar2.f2429a.zza((b) a0Var);
                Bundle bundle2 = a0Var.f2417b;
                i.j.t(jVar2.f2429a, "onPostInitComplete can be called only once per call to getRemoteService");
                jVar2.f2429a.onPostInitHandler(readInt, readStrongBinder, bundle2, jVar2.f2430b);
                jVar2.f2429a = null;
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
