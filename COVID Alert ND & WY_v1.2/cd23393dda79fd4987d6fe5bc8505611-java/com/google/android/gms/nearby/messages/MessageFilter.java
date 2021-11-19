package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzkm;
import com.google.android.gms.internal.nearby.zzkp;
import com.google.android.gms.nearby.messages.internal.zzac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class MessageFilter extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MessageFilter> CREATOR = new zzc();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    private final int zza;
    private final List<zzac> zzb;
    private final List<zzkp> zzc;
    private final boolean zzd;
    private final List<zzkm> zze;
    private final int zzf;

    MessageFilter(int i, List<zzac> list, List<zzkp> list2, boolean z, List<zzkm> list3, int i2) {
        this.zza = i;
        this.zzb = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.zzd = z;
        this.zzc = Collections.unmodifiableList(list2 == null ? Collections.emptyList() : list2);
        this.zze = Collections.unmodifiableList(list3 == null ? Collections.emptyList() : list3);
        this.zzf = i2;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static final class Builder {
        private final Set<zzac> zza = new HashSet();
        private final List<zzkp> zzb = new ArrayList();
        private final Set<zzkm> zzc = new HashSet();
        private boolean zzd;
        private int zze = 0;

        public final Builder includeAllMyTypes() {
            this.zzd = true;
            return this;
        }

        public final Builder includeNamespacedType(String str, String str2) {
            Preconditions.checkArgument(str != null && !str.isEmpty() && !str.contains("*"), "namespace(%s) cannot be null, empty or contain (*).", str);
            Preconditions.checkArgument(str2 != null && !str2.contains("*"), "type(%s) cannot be null or contain (*).", str2);
            return zza(str, str2);
        }

        public final Builder includeFilter(MessageFilter messageFilter) {
            this.zza.addAll(messageFilter.zza());
            this.zzb.addAll(messageFilter.zzc());
            this.zzc.addAll(messageFilter.zzd());
            this.zzd = messageFilter.zzb() | this.zzd;
            return this;
        }

        public final Builder includeEddystoneUids(String str, String str2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.zzb.add(zzkp.zza(str, str2));
            return this;
        }

        public final Builder includeIBeaconIds(UUID uuid, Short sh, Short sh2) {
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.zzb.add(zzkp.zza(uuid, sh, sh2));
            return this;
        }

        public final Builder includeAudioBytes(int i) {
            boolean z = true;
            Preconditions.checkArgument(this.zze == 0, "includeAudioBytes() can only be called once per MessageFilter instance.");
            boolean z2 = i > 0;
            StringBuilder sb = new StringBuilder(44);
            sb.append("Invalid value for numAudioBytes: ");
            sb.append(i);
            Preconditions.checkArgument(z2, sb.toString());
            if (i > 10) {
                z = false;
            }
            Preconditions.checkArgument(z, "numAudioBytes is capped by AudioBytes.MAX_SIZE = 10");
            zza(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
            this.zze = i;
            return this;
        }

        private final Builder zza(String str, String str2) {
            this.zza.add(new zzac(str, str2));
            return this;
        }

        public final MessageFilter build() {
            Preconditions.checkState(this.zzd || !this.zza.isEmpty(), "At least one of the include methods must be called.");
            return new MessageFilter(new ArrayList(this.zza), this.zzb, this.zzd, new ArrayList(this.zzc), this.zze);
        }
    }

    private MessageFilter(List<zzac> list, List<zzkp> list2, boolean z, List<zzkm> list3, int i) {
        this(2, list, list2, z, list3, i);
    }

    public final List<zzac> zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final List<zzkp> zzc() {
        return this.zzc;
    }

    public final List<zzkm> zzd() {
        return this.zze;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zze, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzf);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public String toString() {
        boolean z = this.zzd;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
        sb.append("MessageFilter{includeAllMyTypes=");
        sb.append(z);
        sb.append(", messageTypes=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.zzd == messageFilter.zzd && Objects.equal(this.zzb, messageFilter.zzb) && Objects.equal(this.zzc, messageFilter.zzc) && Objects.equal(this.zze, messageFilter.zze);
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zze);
    }
}
