package androidx.work.impl.constraints;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import okhttp3.internal.ws.RealWebSocket;

public class WorkConstraintsTracker implements ConstraintController.OnConstraintUpdatedCallback {
    public static final String TAG = Logger.tagWithPrefix("WorkConstraintsTracker");
    public final WorkConstraintsCallback mCallback;
    public final ConstraintController<?>[] mConstraintControllers;
    public final Object mLock = new Object();

    public WorkConstraintsTracker(Context context, TaskExecutor taskExecutor, WorkConstraintsCallback workConstraintsCallback) {
        Context applicationContext = context.getApplicationContext();
        this.mCallback = workConstraintsCallback;
        this.mConstraintControllers = new ConstraintController[]{new BatteryChargingController(applicationContext, taskExecutor), new BatteryNotLowController(applicationContext, taskExecutor), new StorageNotLowController(applicationContext, taskExecutor), new NetworkConnectedController(applicationContext, taskExecutor), new NetworkUnmeteredController(applicationContext, taskExecutor), new NetworkNotRoamingController(applicationContext, taskExecutor), new NetworkMeteredController(applicationContext, taskExecutor)};
    }

    public boolean areAllConstraintsMet(String str) {
        synchronized (this.mLock) {
            ConstraintController<?>[] constraintControllerArr = this.mConstraintControllers;
            for (ConstraintController<?> constraintController : constraintControllerArr) {
                RealWebSocket realWebSocket = (T) constraintController.mCurrentValue;
                if (realWebSocket != null && constraintController.isConstrained(realWebSocket) && constraintController.mMatchingWorkSpecIds.contains(str)) {
                    Logger.get().debug(TAG, String.format("Work %s constrained by %s", str, constraintController.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void replace(Iterable<WorkSpec> iterable) {
        synchronized (this.mLock) {
            ConstraintController<?>[] constraintControllerArr = this.mConstraintControllers;
            for (ConstraintController<?> constraintController : constraintControllerArr) {
                if (constraintController.mCallback != null) {
                    constraintController.mCallback = null;
                    constraintController.updateCallback(null, (T) constraintController.mCurrentValue);
                }
            }
            for (ConstraintController<?> constraintController2 : this.mConstraintControllers) {
                constraintController2.replace(iterable);
            }
            ConstraintController<?>[] constraintControllerArr2 = this.mConstraintControllers;
            for (ConstraintController<?> constraintController3 : constraintControllerArr2) {
                if (constraintController3.mCallback != this) {
                    constraintController3.mCallback = this;
                    constraintController3.updateCallback(this, (T) constraintController3.mCurrentValue);
                }
            }
        }
    }

    public void reset() {
        synchronized (this.mLock) {
            ConstraintController<?>[] constraintControllerArr = this.mConstraintControllers;
            for (ConstraintController<?> constraintController : constraintControllerArr) {
                if (!constraintController.mMatchingWorkSpecIds.isEmpty()) {
                    constraintController.mMatchingWorkSpecIds.clear();
                    constraintController.mTracker.removeListener(constraintController);
                }
            }
        }
    }
}
