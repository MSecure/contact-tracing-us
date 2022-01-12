package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.safetynet.zzk$zza;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    public static final ThreadLocal<Boolean> zaa = new zao();
    @KeepName
    public zaa mResultGuardian;
    public final Object zab;
    public final CallbackHandler<R> zac;
    public final CountDownLatch zae;
    public final ArrayList<PendingResult.StatusListener> zaf;
    public ResultCallback<? super R> zag;
    public final AtomicReference<zacn> zah;
    public R zai;
    public Status zaj;
    public volatile boolean zak;
    public boolean zam;
    public boolean zap;

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.common.api.ResultCallback */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(@RecentlyNonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e) {
                    BasePendingResult.zaa(result);
                    throw e;
                }
            } else if (i != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    public final class zaa {
        public zaa(zao zao) {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.zaa(BasePendingResult.this.zai);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(Looper.getMainLooper());
        new WeakReference(null);
    }

    public static void zaa(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@RecentlyNonNull PendingResult.StatusListener statusListener) {
        ReactYogaConfigProvider.checkArgument(true, "Callback cannot be null.");
        synchronized (this.zab) {
            if (isReady()) {
                statusListener.onComplete(this.zaj);
            } else {
                this.zaf.add(statusListener);
            }
        }
    }

    @Deprecated
    public final void forceFailureUnlessReady(@RecentlyNonNull Status status) {
        synchronized (this.zab) {
            if (!isReady()) {
                setResult(new zzk$zza(status, null));
                this.zam = true;
            }
        }
    }

    @RecentlyNonNull
    public final boolean isReady() {
        return this.zae.getCount() == 0;
    }

    public final void setResult(@RecentlyNonNull R r) {
        synchronized (this.zab) {
            if (!this.zam) {
                isReady();
                boolean z = true;
                ReactYogaConfigProvider.checkState(!isReady(), "Results have already been set");
                if (this.zak) {
                    z = false;
                }
                ReactYogaConfigProvider.checkState(z, "Result has already been consumed");
                zab(r);
                return;
            }
            zaa(r);
        }
    }

    public final void zab(R r) {
        this.zai = r;
        this.zaj = r.getStatus();
        this.zae.countDown();
        ResultCallback<? super R> resultCallback = this.zag;
        if (resultCallback != null) {
            this.zac.removeMessages(2);
            CallbackHandler<R> callbackHandler = this.zac;
            R zac2 = zac();
            if (callbackHandler != null) {
                ReactYogaConfigProvider.checkNotNull(resultCallback);
                callbackHandler.sendMessage(callbackHandler.obtainMessage(1, new Pair(resultCallback, zac2)));
            } else {
                throw null;
            }
        } else if (this.zai instanceof Releasable) {
            this.mResultGuardian = new zaa(null);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zaf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.zaj);
        }
        this.zaf.clear();
    }

    public final R zac() {
        R r;
        synchronized (this.zab) {
            ReactYogaConfigProvider.checkState(!this.zak, "Result has already been consumed.");
            ReactYogaConfigProvider.checkState(isReady(), "Result is not ready.");
            r = this.zai;
            this.zai = null;
            this.zag = null;
            this.zak = true;
        }
        zacn andSet = this.zah.getAndSet(null);
        if (andSet != null) {
            andSet.zaa(this);
        }
        ReactYogaConfigProvider.checkNotNull(r);
        return r;
    }

    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(googleApiClient.getLooper());
        new WeakReference(googleApiClient);
    }
}
