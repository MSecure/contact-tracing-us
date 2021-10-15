package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import c.b.a.a.g.e.ba;
import c.b.a.a.g.e.u9;
import com.google.android.gms.nearby.messages.internal.zzae;
import com.google.android.gms.nearby.messages.internal.zzf;
import com.google.android.gms.nearby.messages.internal.zzm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MessageFilter extends a {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzc();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    public final int zza;
    public final List<zzae> zzb;
    public final List<ba> zzc;
    public final boolean zzd;
    public final List<u9> zze;
    public final int zzf;

    public static final class Builder {
        public final Set<zzae> zza = new HashSet();
        public final List<ba> zzb = new ArrayList();
        public final Set<u9> zzc = new HashSet();
        public boolean zzd;
        public int zze = 0;

        private final Builder zza(String str, String str2) {
            this.zza.add(new zzae(str, str2));
            return this;
        }

        public final MessageFilter build() {
            t.I(this.zzd || !this.zza.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(new ArrayList(this.zza), this.zzb, this.zzd, new ArrayList(this.zzc), this.zze);
        }

        public final Builder includeAllMyTypes() {
            this.zzd = true;
            return this;
        }

        public final Builder includeAudioBytes(int i) {
            boolean z = true;
            t.r(this.zze == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            boolean z2 = i > 0;
            StringBuilder sb = new StringBuilder(44);
            sb.append("Invalid value for numAudioBytes: ");
            sb.append(i);
            t.r(z2, sb.toString());
            if (i > 10) {
                z = false;
            }
            t.r(z, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.zze = i;
            return this;
        }

        public final Builder includeEddystoneUids(String str, String str2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            List<ba> list = this.zzb;
            String valueOf = String.valueOf(str);
            if (str2 == null) {
                str2 = "";
            }
            list.add(new ba(2, new zzf(str2.length() != 0 ? valueOf.concat(str2) : new String(valueOf)).zza()));
            return this;
        }

        public final Builder includeFilter(MessageFilter messageFilter) {
            this.zza.addAll(messageFilter.zza());
            this.zzb.addAll(messageFilter.zzc());
            this.zzc.addAll(messageFilter.zzd());
            this.zzd = messageFilter.zzb() | this.zzd;
            return this;
        }

        public final Builder includeIBeaconIds(UUID uuid, Short sh, Short sh2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.zzb.add(new ba(3, new zzm(uuid, sh, sh2).zza()));
            return this;
        }

        public final Builder includeNamespacedType(String str, String str2) {
            t.u(str != null && !str.isEmpty() && !str.contains("*"), "namespace(%s) cannot be null, empty or contain (*).", str);
            t.u(str2 != null && !str2.contains("*"), "type(%s) cannot be null or contain (*).", str2);
            return zza(str, str2);
        }
    }

    public MessageFilter(int i, List<zzae> list, List<ba> list2, boolean z, List<u9> list3, int i2) {
        this.zza = i;
        t.C(list);
        this.zzb = Collections.unmodifiableList(list);
        this.zzd = z;
        this.zzc = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.zze = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.zzf = i2;
    }

    public MessageFilter(List<zzae> list, List<ba> list2, boolean z, List<u9> list3, int i) {
        this(2, list, list2, z, list3, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.zzd == messageFilter.zzd && t.j1(this.zzb, messageFilter.zzb) && t.j1(this.zzc, messageFilter.zzc) && t.j1(this.zze, messageFilter.zze);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zze});
    }

    public String toString() {
        boolean z = this.zzd;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(valueOf.length() + 53);
        sb.append("MessageFilter{includeAllMyTypes=");
        sb.append(z);
        sb.append(", messageTypes=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.z3(parcel, 1, this.zzb, false);
        t.z3(parcel, 2, this.zzc, false);
        t.j3(parcel, 3, this.zzd);
        t.z3(parcel, 4, this.zze, false);
        t.q3(parcel, 5, this.zzf);
        t.q3(parcel, 1000, this.zza);
        t.w4(parcel, m);
    }

    public final List<zzae> zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final List<ba> zzc() {
        return this.zzc;
    }

    public final List<u9> zzd() {
        return this.zze;
    }
}
