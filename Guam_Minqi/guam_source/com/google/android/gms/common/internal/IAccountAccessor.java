package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public interface IAccountAccessor extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IAccountAccessor {

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        public static class zza extends zzb implements IAccountAccessor {
            public zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final Account zza() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.zzb);
                obtain = Parcel.obtain();
                try {
                    this.zza.transact(2, obtain, obtain, 0);
                    obtain.readException();
                    obtain.recycle();
                    return (Account) zzd.zza(obtain, Account.CREATOR);
                } catch (RuntimeException e) {
                    throw e;
                } finally {
                    obtain.recycle();
                }
            }
        }

        @RecentlyNonNull
        public static IAccountAccessor asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder);
        }
    }

    @RecentlyNonNull
    Account zza() throws RemoteException;
}
