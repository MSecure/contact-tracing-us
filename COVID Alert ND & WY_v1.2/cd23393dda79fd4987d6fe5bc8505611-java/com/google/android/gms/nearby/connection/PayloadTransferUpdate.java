package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class PayloadTransferUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzn();
    private long zza;
    private int zzb;
    private long zzc;
    private long zzd;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    private PayloadTransferUpdate() {
    }

    PayloadTransferUpdate(long j, int i, long j2, long j3) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = j3;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static final class Builder {
        private final PayloadTransferUpdate zza;

        public Builder() {
            this.zza = new PayloadTransferUpdate();
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate2 = new PayloadTransferUpdate();
            this.zza = payloadTransferUpdate2;
            payloadTransferUpdate2.zza = payloadTransferUpdate.zza;
            payloadTransferUpdate2.zzb = payloadTransferUpdate.zzb;
            payloadTransferUpdate2.zzc = payloadTransferUpdate.zzc;
            payloadTransferUpdate2.zzd = payloadTransferUpdate.zzd;
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

        public final Builder setBytesTransferred(long j) {
            this.zza.zzd = j;
            return this;
        }

        public final PayloadTransferUpdate build() {
            return this.zza;
        }
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

    public final long getBytesTransferred() {
        return this.zzd;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            return Objects.equal(Long.valueOf(this.zza), Long.valueOf(payloadTransferUpdate.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(payloadTransferUpdate.zzb)) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(payloadTransferUpdate.zzc)) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(payloadTransferUpdate.zzd));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getPayloadId());
        SafeParcelWriter.writeInt(parcel, 2, getStatus());
        SafeParcelWriter.writeLong(parcel, 3, getTotalBytes());
        SafeParcelWriter.writeLong(parcel, 4, getBytesTransferred());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
