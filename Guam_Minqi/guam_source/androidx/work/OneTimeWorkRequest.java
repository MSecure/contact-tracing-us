package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;

public final class OneTimeWorkRequest extends WorkRequest {

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.mWorkSpec.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        /* Return type fixed from 'androidx.work.WorkRequest' to match base method */
        @Override // androidx.work.WorkRequest.Builder
        public OneTimeWorkRequest buildInternal() {
            if (!this.mBackoffCriteriaSet || !this.mWorkSpec.constraints.mRequiresDeviceIdle) {
                WorkSpec workSpec = this.mWorkSpec;
                if (!workSpec.runInForeground || !workSpec.constraints.mRequiresDeviceIdle) {
                    return new OneTimeWorkRequest(this);
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

    public OneTimeWorkRequest(Builder builder) {
        super(builder.mId, builder.mWorkSpec, builder.mTags);
    }
}
