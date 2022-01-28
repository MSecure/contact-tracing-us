package com.google.android.gms.nearby.messages;

import b.b.k.i;

public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    public final Strategy zza;
    public final PublishCallback zzb;

    public static class Builder {
        public Strategy zza = Strategy.DEFAULT;
        public PublishCallback zzb;

        public PublishOptions build() {
            return new PublishOptions(this.zza, this.zzb);
        }

        public Builder setCallback(PublishCallback publishCallback) {
            i.j.s(publishCallback);
            this.zzb = publishCallback;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            i.j.s(strategy);
            this.zza = strategy;
            return this;
        }
    }

    public PublishOptions(Strategy strategy, PublishCallback publishCallback) {
        this.zza = strategy;
        this.zzb = publishCallback;
    }

    public final PublishCallback getCallback() {
        return this.zzb;
    }

    public final Strategy getStrategy() {
        return this.zza;
    }
}
