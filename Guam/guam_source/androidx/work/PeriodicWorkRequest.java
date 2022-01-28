package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.concurrent.TimeUnit;

public final class PeriodicWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
            super(cls);
            WorkSpec workSpec = this.mWorkSpec;
            long millis = timeUnit.toMillis(j);
            long millis2 = timeUnit2.toMillis(j2);
            if (workSpec != null) {
                if (millis < 900000) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
                    millis = 900000;
                }
                if (millis2 < 300000) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                    millis2 = 300000;
                }
                if (millis2 > millis) {
                    Logger.get().warning(WorkSpec.TAG, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(millis)), new Throwable[0]);
                    millis2 = millis;
                }
                workSpec.intervalDuration = millis;
                workSpec.flexDuration = millis2;
                return;
            }
            throw null;
        }

        /* Return type fixed from 'androidx.work.WorkRequest' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        public PeriodicWorkRequest buildInternal() {
            if (!this.mBackoffCriteriaSet || !this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                WorkSpec workSpec = this.mWorkSpec;
                if (!workSpec.runInForeground || !workSpec.constraints.mRequiresDeviceIdle) {
                    return new PeriodicWorkRequest(this);
                }
                throw new IllegalArgumentException("Cannot run in foreground with an idle mode constraint");
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* Return type fixed from 'androidx.work.WorkRequest$Builder' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        public Builder getThis() {
            return this;
        }
    }

    public PeriodicWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
