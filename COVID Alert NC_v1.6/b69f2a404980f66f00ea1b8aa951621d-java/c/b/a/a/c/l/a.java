package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import c.b.a.a.c.l.j;

public class a extends j.a {
    public static Account e(j jVar) {
        if (jVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return jVar.b();
            } catch (RemoteException unused) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
