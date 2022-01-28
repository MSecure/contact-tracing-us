package com.google.android.gms.common.api.internal;

import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class TaskApiCall<A, ResultT> {
    public final Feature[] zaa;
    public final boolean zab;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class Builder<A, ResultT> {
        public RemoteCall<A, TaskCompletionSource<ResultT>> zaa;
        public boolean zab = true;
        public Feature[] zac;
        public int zad = 0;

        public Builder(zacf zacf) {
        }

        @RecentlyNonNull
        public TaskApiCall<A, ResultT> build() {
            ReactYogaConfigProvider.checkArgument(this.zaa != null, "execute parameter required");
            return new zacg(this, this.zac, this.zab, this.zad);
        }
    }

    public TaskApiCall(Feature[] featureArr, boolean z, int i, zacf zacf) {
        this.zaa = featureArr;
        this.zab = z;
    }

    @RecentlyNonNull
    public static <A, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }
}
