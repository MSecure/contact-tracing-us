package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

public final class zzag extends a {
    public static final Parcelable.Creator<zzag> CREATOR = new zzaf();
    public final int zza;
    public final Message zzb;

    public zzag(int i, Message message) {
        this.zza = i;
        i.j.s(message);
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
        return i.j.X(this.zzb, ((zzag) obj).zzb);
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
        int e2 = i.j.e(parcel);
        i.j.y1(parcel, 1, this.zzb, i, false);
        i.j.u1(parcel, 1000, this.zza);
        i.j.F1(parcel, e2);
    }
}
