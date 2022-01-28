package com.bugfender.sdk.a.c;

import android.os.Handler;
import android.os.Looper;

public class e implements d {
    private Handler a = new Handler(Looper.getMainLooper());

    @Override // com.bugfender.sdk.a.c.d
    public void a(Runnable runnable) {
        this.a.post(runnable);
    }

    @Override // com.bugfender.sdk.a.c.d
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
