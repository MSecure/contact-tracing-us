package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zad<A extends BaseImplementation$ApiMethodImpl<? extends Result, Api.AnyClient>> extends zac {
    public final A zab;

    public zad(int i, A a) {
        super(i);
        ReactYogaConfigProvider.checkNotNull(a, "Null methods are not runnable.");
        this.zab = a;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(Status status) {
        try {
            this.zab.setFailedResult(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zac(GoogleApiManager.zaa<?> zaa) throws DeadObjectException {
        try {
            A a = this.zab;
            Api.Client client = zaa.zac;
            if (a != null) {
                try {
                    a.doExecute(client);
                } catch (DeadObjectException e) {
                    a.setFailedResult(new Status(8, e.getLocalizedMessage(), null));
                    throw e;
                } catch (RemoteException e2) {
                    a.setFailedResult(new Status(8, e2.getLocalizedMessage(), null));
                }
            } else {
                throw null;
            }
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(localizedMessage).length() + simpleName.length() + 2);
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.zab.setFailedResult(new Status(10, sb.toString()));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaa(zaw zaw, boolean z) {
        A a = this.zab;
        zaw.zaa.put(a, Boolean.valueOf(z));
        a.addStatusListener(new zav(zaw, a));
    }
}
