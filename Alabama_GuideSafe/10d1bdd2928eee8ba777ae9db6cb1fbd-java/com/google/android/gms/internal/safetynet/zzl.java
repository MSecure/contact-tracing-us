package com.google.android.gms.internal.safetynet;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzl extends zzk$zzb {
    public final /* synthetic */ byte[] zzw;
    public final /* synthetic */ String zzx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzl(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        super(googleApiClient);
        this.zzw = bArr;
        this.zzx = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final void doExecute(zzx zzx2) throws RemoteException {
        zzx zzx3 = zzx2;
        zzg zzg = this.zzaf;
        byte[] bArr = this.zzw;
        String str = this.zzx;
        if (TextUtils.isEmpty(str)) {
            if (zzx3 != null) {
                try {
                    PackageManager packageManager = zzx3.zzap.getPackageManager();
                    if (packageManager != null) {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(zzx3.zzap.getPackageName(), 128);
                        if (applicationInfo != null) {
                            Bundle bundle = applicationInfo.metaData;
                            if (bundle != null) {
                                str = (String) bundle.get("com.google.android.safetynet.ATTEST_API_KEY");
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                str = null;
            } else {
                throw null;
            }
        }
        ((zzi) zzx3.getService()).zza(zzg, bArr, str);
    }
}
