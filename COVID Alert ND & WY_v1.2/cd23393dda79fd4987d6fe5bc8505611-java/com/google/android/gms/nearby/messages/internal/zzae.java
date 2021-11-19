package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.Message;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzah();
    private final int zza;
    private final Message zzb;

    zzae(int i, Message message) {
        this.zza = i;
        this.zzb = (Message) Preconditions.checkNotNull(message);
    }

    public static final zzae zza(Message message) {
        return new zzae(1, message);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        return Objects.equal(this.zzb, ((zzae) obj).zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public final String toString() {
        String message = this.zzb.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 24);
        sb.append("MessageWrapper{message=");
        sb.append(message);
        sb.append("}");
        return sb.toString();
    }
}
