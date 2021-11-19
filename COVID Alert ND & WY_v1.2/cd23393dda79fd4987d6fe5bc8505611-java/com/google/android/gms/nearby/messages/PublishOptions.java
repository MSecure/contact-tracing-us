package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy zza;
    private final PublishCallback zzb;

    private PublishOptions(Strategy strategy, PublishCallback publishCallback) {
        this.zza = strategy;
        this.zzb = publishCallback;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private Strategy zza = Strategy.DEFAULT;
        private PublishCallback zzb;

        public Builder setStrategy(Strategy strategy) {
            this.zza = (Strategy) Preconditions.checkNotNull(strategy);
            return this;
        }

        public Builder setCallback(PublishCallback publishCallback) {
            this.zzb = (PublishCallback) Preconditions.checkNotNull(publishCallback);
            return this;
        }

        public PublishOptions build() {
            return new PublishOptions(this.zza, this.zzb);
        }
    }

    public final Strategy getStrategy() {
        return this.zza;
    }

    public final PublishCallback getCallback() {
        return this.zzb;
    }
}
