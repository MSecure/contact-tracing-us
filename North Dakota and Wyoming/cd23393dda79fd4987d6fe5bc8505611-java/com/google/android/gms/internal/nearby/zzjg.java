package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzjg {
    static Pair<zzjc, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> zza(Payload payload) throws IOException {
        String str;
        int type = payload.getType();
        if (type == 1) {
            return Pair.create(new zzje().zza(payload.getId()).zza(payload.getType()).zza(payload.asBytes()).zza(), null);
        }
        if (type == 2) {
            if (payload.asFile().asJavaFile() == null) {
                str = null;
            } else {
                str = payload.asFile().asJavaFile().getAbsolutePath();
            }
            return Pair.create(new zzje().zza(payload.getId()).zza(payload.getType()).zza(payload.asFile().asParcelFileDescriptor()).zza(str).zzb(payload.asFile().getSize()).zza(), null);
        } else if (type == 3) {
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                return Pair.create(new zzje().zza(payload.getId()).zza(payload.getType()).zza(createPipe[0]).zzb(createPipe2[0]).zza(), Pair.create(createPipe[1], createPipe2[1]));
            } catch (IOException e) {
                Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                throw e;
            }
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
            Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
            throw illegalArgumentException;
        }
    }

    static Payload zza(Context context, zzjc zzjc) {
        long zza = zzjc.zza();
        int zzb = zzjc.zzb();
        if (zzb == 1) {
            return Payload.zza(zzjc.zzc(), zza);
        }
        if (zzb == 2) {
            String zze = zzjc.zze();
            Uri zzg = zzjc.zzg();
            if (zze == null || zzg == null) {
                return Payload.zza(Payload.File.zza(zzjc.zzd()), zza);
            }
            try {
                return Payload.zza(Payload.File.zza(new File(zze), context.getContentResolver().openFileDescriptor(zzg, "r"), zzjc.zzf(), zzg), zza);
            } catch (FileNotFoundException e) {
                Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", zzg, zze), e);
                return null;
            }
        } else if (zzb == 3) {
            return Payload.zza(Payload.Stream.zza(zzjc.zzd()), zza);
        } else {
            Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzjc.zza()), Integer.valueOf(zzjc.zzb())));
            return null;
        }
    }
}
