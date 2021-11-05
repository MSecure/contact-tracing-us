package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import c.b.a.a.d.m.h;

public class a extends h.a {
    @RecentlyNullable
    public static Account g0(@RecentlyNonNull h hVar) {
        if (hVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return hVar.zza();
            } catch (RemoteException unused) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
