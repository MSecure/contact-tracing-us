package com.google.android.gms.internal.nearby;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjd implements Runnable {
    private final /* synthetic */ InputStream zza;
    private final /* synthetic */ OutputStream zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ OutputStream zzd;
    private final /* synthetic */ zzja zze;

    zzjd(zzja zzja, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.zze = zzja;
        this.zza = inputStream;
        this.zzb = outputStream;
        this.zzc = j;
        this.zzd = outputStream2;
    }

    public final void run() {
        Throwable th;
        this.zze.zzb = this.zza;
        boolean z = false;
        try {
            IOUtils.copyStream(this.zza, this.zzb, false, 65536);
            IOUtils.closeQuietly(this.zza);
            zzja zzja = this.zze;
            zzja.zza(this.zzd, false, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            this.zze.zzb = null;
        } catch (IOException e) {
            if (!(this.zze.zzc)) {
                Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.zzc)), e);
            } else {
                Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.zzc)));
            }
            IOUtils.closeQuietly(this.zza);
            zzja zzja2 = this.zze;
            zzja.zza(this.zzd, true, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            this.zze.zzb = null;
        } catch (Throwable th2) {
            z = true;
            th = th2;
            IOUtils.closeQuietly(this.zza);
            zzja zzja3 = this.zze;
            zzja.zza(this.zzd, z, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            this.zze.zzb = null;
            throw th;
        }
    }
}
