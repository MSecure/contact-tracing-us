package com.google.android.gms.nearby.messages;

import b.x.t;

public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    public final boolean zza;
    public final int zzb;
    public final Strategy zzc;
    public final MessageFilter zzd;
    public final SubscribeCallback zze;

    public static class Builder {
        public Strategy zza = Strategy.DEFAULT;
        public MessageFilter zzb = MessageFilter.INCLUDE_ALL_MY_TYPES;
        public SubscribeCallback zzc;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zza, this.zzb, this.zzc);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            t.C(subscribeCallback);
            this.zzc = subscribeCallback;
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.zzb = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza = strategy;
            return this;
        }
    }

    public SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z, int i) {
        this.zzc = strategy;
        this.zzd = messageFilter;
        this.zze = subscribeCallback;
        this.zza = false;
        this.zzb = 0;
    }

    public final SubscribeCallback getCallback() {
        return this.zze;
    }

    public final MessageFilter getFilter() {
        return this.zzd;
    }

    public final Strategy getStrategy() {
        return this.zzc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 36);
        sb.append("SubscribeOptions{strategy=");
        sb.append(valueOf);
        sb.append(", filter=");
        sb.append(valueOf2);
        sb.append('}');
        return sb.toString();
    }
}
