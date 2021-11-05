package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public final class zzag extends a {
    public static final Parcelable.Creator<zzag> CREATOR = new zzaf();
    public final int zza;
    public final Message zzb;

    public zzag(int i, Message message) {
        this.zza = i;
        t.C(message);
        this.zzb = message;
    }

    public static final zzag zza(Message message) {
        return new zzag(1, message);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        return t.j1(this.zzb, ((zzag) obj).zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb});
    }

    public final String toString() {
        String message = this.zzb.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 24);
        sb.append("MessageWrapper{message=");
        sb.append(message);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.v3(parcel, 1, this.zzb, i, false);
        t.q3(parcel, 1000, this.zza);
        t.w4(parcel, m);
    }
}
