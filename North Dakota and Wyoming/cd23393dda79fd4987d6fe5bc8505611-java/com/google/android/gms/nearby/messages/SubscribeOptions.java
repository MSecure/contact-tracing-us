package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    public final boolean zza;
    public final int zzb;
    private final Strategy zzc;
    private final MessageFilter zzd;
    private final SubscribeCallback zze;

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z, int i) {
        this.zzc = strategy;
        this.zzd = messageFilter;
        this.zze = subscribeCallback;
        this.zza = false;
        this.zzb = 0;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private Strategy zza = Strategy.DEFAULT;
        private MessageFilter zzb = MessageFilter.INCLUDE_ALL_MY_TYPES;
        private SubscribeCallback zzc;

        public Builder setStrategy(Strategy strategy) {
            this.zza = strategy;
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.zzb = messageFilter;
            return this;
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.zzc = (SubscribeCallback) Preconditions.checkNotNull(subscribeCallback);
            return this;
        }

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zza, this.zzb, this.zzc);
        }
    }

    public final Strategy getStrategy() {
        return this.zzc;
    }

    public final MessageFilter getFilter() {
        return this.zzd;
    }

    public final SubscribeCallback getCallback() {
        return this.zze;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length());
        sb.append("SubscribeOptions{strategy=");
        sb.append(valueOf);
        sb.append(", filter=");
        sb.append(valueOf2);
        sb.append('}');
        return sb.toString();
    }
}
