package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class PayloadTransferUpdate extends a {
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzn();
    public long zza;
    public int zzb;
    public long zzc;
    public long zzd;

    public static final class Builder {
        public final PayloadTransferUpdate zza;

        public Builder() {
            this.zza = new PayloadTransferUpdate();
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate2 = new PayloadTransferUpdate();
            this.zza = payloadTransferUpdate2;
            payloadTransferUpdate2.zza = payloadTransferUpdate.zza;
            this.zza.zzb = payloadTransferUpdate.zzb;
            this.zza.zzc = payloadTransferUpdate.zzc;
            this.zza.zzd = payloadTransferUpdate.zzd;
        }

        public final PayloadTransferUpdate build() {
            return this.zza;
        }

        public final Builder setBytesTransferred(long j) {
            this.zza.zzd = j;
            return this;
        }

        public final Builder setPayloadId(long j) {
            this.zza.zza = j;
            return this;
        }

        public final Builder setStatus(int i) {
            this.zza.zzb = i;
            return this;
        }

        public final Builder setTotalBytes(long j) {
            this.zza.zzc = j;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    public PayloadTransferUpdate() {
    }

    public PayloadTransferUpdate(long j, int i, long j2, long j3) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            return i.j.X(Long.valueOf(this.zza), Long.valueOf(payloadTransferUpdate.zza)) && i.j.X(Integer.valueOf(this.zzb), Integer.valueOf(payloadTransferUpdate.zzb)) && i.j.X(Long.valueOf(this.zzc), Long.valueOf(payloadTransferUpdate.zzc)) && i.j.X(Long.valueOf(this.zzd), Long.valueOf(payloadTransferUpdate.zzd));
        }
    }

    public final long getBytesTransferred() {
        return this.zzd;
    }

    public final long getPayloadId() {
        return this.zza;
    }

    public final int getStatus() {
        return this.zzb;
    }

    public final long getTotalBytes() {
        return this.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc), Long.valueOf(this.zzd)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.x1(parcel, 1, getPayloadId());
        i.j.u1(parcel, 2, getStatus());
        i.j.x1(parcel, 3, getTotalBytes());
        i.j.x1(parcel, 4, getBytesTransferred());
        i.j.F1(parcel, e2);
    }
}
