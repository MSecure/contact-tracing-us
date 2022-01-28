package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzja {
    private final ExecutorService zza = zze.zza().zza(zzj.zza);
    private volatile InputStream zzb = null;
    private volatile boolean zzc = false;

    /* access modifiers changed from: package-private */
    public final void zza(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, long j) {
        this.zza.execute(new zzjd(this, inputStream, outputStream, j, outputStream2));
    }

    /* access modifiers changed from: private */
    public static void zza(OutputStream outputStream, boolean z, long j) {
        try {
            outputStream.write(z ? 1 : 0);
        } catch (IOException e) {
            Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j)), e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc = true;
        this.zza.shutdownNow();
        IOUtils.closeQuietly(this.zzb);
    }
}
