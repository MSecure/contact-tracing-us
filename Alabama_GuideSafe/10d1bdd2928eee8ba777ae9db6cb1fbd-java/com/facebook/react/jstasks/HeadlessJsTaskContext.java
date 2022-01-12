package com.facebook.react.jstasks;

import android.os.Handler;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadlessJsTaskContext {
    public static final WeakHashMap<ReactContext, HeadlessJsTaskContext> INSTANCES = new WeakHashMap<>();
    public final Map<Integer, HeadlessJsTaskConfig> mActiveTaskConfigs;
    public final Set<Integer> mActiveTasks;
    public final Handler mHandler;
    public final Set<HeadlessJsTaskEventListener> mHeadlessJsTaskEventListeners = new CopyOnWriteArraySet();
    public final WeakReference<ReactContext> mReactContext;
    public final SparseArray<Runnable> mTaskTimeouts;

    public HeadlessJsTaskContext(ReactContext reactContext) {
        new AtomicInteger(0);
        this.mHandler = new Handler();
        this.mActiveTasks = new CopyOnWriteArraySet();
        this.mActiveTaskConfigs = new ConcurrentHashMap();
        this.mTaskTimeouts = new SparseArray<>();
        this.mReactContext = new WeakReference<>(reactContext);
    }

    public static HeadlessJsTaskContext getInstance(ReactContext reactContext) {
        HeadlessJsTaskContext headlessJsTaskContext = INSTANCES.get(reactContext);
        if (headlessJsTaskContext != null) {
            return headlessJsTaskContext;
        }
        HeadlessJsTaskContext headlessJsTaskContext2 = new HeadlessJsTaskContext(reactContext);
        INSTANCES.put(reactContext, headlessJsTaskContext2);
        return headlessJsTaskContext2;
    }

    public synchronized void finishTask(final int i) {
        boolean remove = this.mActiveTasks.remove(Integer.valueOf(i));
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(remove, "Tried to finish non-existent task with id " + i + ".");
        boolean z = this.mActiveTaskConfigs.remove(Integer.valueOf(i)) != null;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(z, "Tried to remove non-existent task config with id " + i + ".");
        Runnable runnable = this.mTaskTimeouts.get(i);
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mTaskTimeouts.remove(i);
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.jstasks.HeadlessJsTaskContext.AnonymousClass2 */

            public void run() {
                for (HeadlessJsTaskEventListener headlessJsTaskEventListener : HeadlessJsTaskContext.this.mHeadlessJsTaskEventListeners) {
                    headlessJsTaskEventListener.onHeadlessJsTaskFinish(i);
                }
            }
        });
    }

    public synchronized boolean isTaskRunning(int i) {
        return this.mActiveTasks.contains(Integer.valueOf(i));
    }
}
