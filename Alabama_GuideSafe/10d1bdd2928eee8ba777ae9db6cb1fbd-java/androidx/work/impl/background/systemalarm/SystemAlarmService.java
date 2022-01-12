package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;

public class SystemAlarmService extends LifecycleService implements SystemAlarmDispatcher.CommandsCompletedListener {
    public static final String TAG = Logger.tagWithPrefix("SystemAlarmService");
    public SystemAlarmDispatcher mDispatcher;
    public boolean mIsShutdown;

    public final void initializeDispatcher() {
        SystemAlarmDispatcher systemAlarmDispatcher = new SystemAlarmDispatcher(this);
        this.mDispatcher = systemAlarmDispatcher;
        if (systemAlarmDispatcher.mCompletedListener != null) {
            Logger.get().error(SystemAlarmDispatcher.TAG, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            systemAlarmDispatcher.mCompletedListener = this;
        }
    }

    @Override // androidx.lifecycle.LifecycleService
    public void onCreate() {
        super.onCreate();
        initializeDispatcher();
        this.mIsShutdown = false;
    }

    @Override // androidx.lifecycle.LifecycleService
    public void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mDispatcher.onDestroy();
    }

    @Override // androidx.lifecycle.LifecycleService
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.add(intent, i2);
        return 3;
    }
}
