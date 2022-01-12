package androidx.work.impl;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

public class OperationImpl implements Operation {
    public final SettableFuture<Operation.State.SUCCESS> mOperationFuture = new SettableFuture<>();
    public final MutableLiveData<Operation.State> mOperationState = new MutableLiveData<>();

    public OperationImpl() {
        setState(Operation.IN_PROGRESS);
    }

    public void setState(Operation.State state) {
        boolean z;
        MutableLiveData<Operation.State> mutableLiveData = this.mOperationState;
        synchronized (mutableLiveData.mDataLock) {
            z = mutableLiveData.mPendingData == LiveData.NOT_SET;
            mutableLiveData.mPendingData = state;
        }
        if (z) {
            ArchTaskExecutor.getInstance().mDelegate.postToMainThread(mutableLiveData.mPostValueRunnable);
        }
        if (state instanceof Operation.State.SUCCESS) {
            this.mOperationFuture.set((Operation.State.SUCCESS) state);
        } else if (state instanceof Operation.State.FAILURE) {
            this.mOperationFuture.setException(((Operation.State.FAILURE) state).mThrowable);
        }
    }
}
