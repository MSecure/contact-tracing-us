package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public interface IStatusCallback extends IInterface {

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static abstract class Stub extends com.google.android.gms.internal.base.zaa implements IStatusCallback {

        /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
        public static class zaa extends zab implements IStatusCallback {
            public zaa(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
            }

            @Override // com.google.android.gms.common.api.internal.IStatusCallback
            public final void onResult(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.zab);
                zad.zaa(obtain, status);
                try {
                    this.zaa.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @RecentlyNonNull
        public static IStatusCallback asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof IStatusCallback) {
                return (IStatusCallback) queryLocalInterface;
            }
            return new zaa(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zaa
        @RecentlyNonNull
        public final boolean zaa(@RecentlyNonNull int i, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            onResult((Status) zad.zaa(parcel, Status.CREATOR));
            return true;
        }
    }

    void onResult(@RecentlyNonNull Status status) throws RemoteException;
}
