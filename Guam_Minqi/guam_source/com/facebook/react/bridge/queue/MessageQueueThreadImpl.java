package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@DoNotStrip
public class MessageQueueThreadImpl implements MessageQueueThread {
    public final String mAssertionErrorMessage;
    public final MessageQueueThreadHandler mHandler;
    public volatile boolean mIsFinished;
    public final Looper mLooper;
    public final String mName;
    public MessageQueueThreadPerfStats mPerfStats;

    /* renamed from: com.facebook.react.bridge.queue.MessageQueueThreadImpl$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            int[] iArr = new int[MessageQueueThreadSpec.ThreadType.values().length];
            $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType = iArr;
            MessageQueueThreadSpec.ThreadType threadType = MessageQueueThreadSpec.ThreadType.MAIN_UI;
            iArr[0] = 1;
            try {
                int[] iArr2 = $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType;
                MessageQueueThreadSpec.ThreadType threadType2 = MessageQueueThreadSpec.ThreadType.NEW_BACKGROUND;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this(str, looper, queueThreadExceptionHandler, null);
    }

    public static void assignToPerfStats(MessageQueueThreadPerfStats messageQueueThreadPerfStats, long j, long j2) {
        messageQueueThreadPerfStats.wallTime = j;
        messageQueueThreadPerfStats.cpuTime = j2;
    }

    public static MessageQueueThreadImpl create(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        int ordinal = messageQueueThreadSpec.getThreadType().ordinal();
        if (ordinal == 0) {
            return createForMainThread(messageQueueThreadSpec.getName(), queueThreadExceptionHandler);
        }
        if (ordinal == 1) {
            return startNewBackgroundThread(messageQueueThreadSpec.getName(), messageQueueThreadSpec.getStackSize(), queueThreadExceptionHandler);
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unknown thread type: ");
        outline15.append(messageQueueThreadSpec.getThreadType());
        throw new RuntimeException(outline15.toString());
    }

    public static MessageQueueThreadImpl createForMainThread(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        MessageQueueThreadImpl messageQueueThreadImpl = new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
        if (UiThreadUtil.isOnUiThread()) {
            Process.setThreadPriority(-4);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.bridge.queue.MessageQueueThreadImpl.AnonymousClass3 */

                public void run() {
                    Process.setThreadPriority(-4);
                }
            });
        }
        return messageQueueThreadImpl;
    }

    public static MessageQueueThreadImpl startNewBackgroundThread(String str, long j, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        new Thread(null, new Runnable() {
            /* class com.facebook.react.bridge.queue.MessageQueueThreadImpl.AnonymousClass4 */

            public void run() {
                Process.setThreadPriority(-4);
                Looper.prepare();
                MessageQueueThreadPerfStats messageQueueThreadPerfStats = new MessageQueueThreadPerfStats();
                MessageQueueThreadImpl.assignToPerfStats(messageQueueThreadPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
                SimpleSettableFuture simpleSettableFuture = simpleSettableFuture;
                simpleSettableFuture.checkNotSet();
                simpleSettableFuture.mResult = (T) new Pair(Looper.myLooper(), messageQueueThreadPerfStats);
                simpleSettableFuture.mReadyLatch.countDown();
                Looper.loop();
            }
        }, GeneratedOutlineSupport.outline8("mqt_", str), j).start();
        try {
            Pair pair = (Pair) simpleSettableFuture.get();
            return new MessageQueueThreadImpl(str, (Looper) pair.first, queueThreadExceptionHandler, (MessageQueueThreadPerfStats) pair.second);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void assertIsOnThread() {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public <T> Future<T> callOnQueue(final Callable<T> callable) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new Runnable() {
            /* class com.facebook.react.bridge.queue.MessageQueueThreadImpl.AnonymousClass1 */

            public void run() {
                try {
                    simpleSettableFuture.set(callable.call());
                } catch (Exception e) {
                    SimpleSettableFuture simpleSettableFuture = simpleSettableFuture;
                    simpleSettableFuture.checkNotSet();
                    simpleSettableFuture.mException = e;
                    simpleSettableFuture.mReadyLatch.countDown();
                }
            }
        });
        return simpleSettableFuture;
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public MessageQueueThreadPerfStats getPerfStats() {
        return this.mPerfStats;
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public boolean isOnThread() {
        return this.mLooper.getThread() == Thread.currentThread();
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void quitSynchronous() {
        this.mIsFinished = true;
        this.mLooper.quit();
        if (this.mLooper.getThread() != Thread.currentThread()) {
            try {
                this.mLooper.getThread().join();
            } catch (InterruptedException unused) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Got interrupted waiting to join thread ");
                outline15.append(this.mName);
                throw new RuntimeException(outline15.toString());
            }
        }
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void resetPerfStats() {
        assignToPerfStats(this.mPerfStats, -1, -1);
        runOnQueue(new Runnable() {
            /* class com.facebook.react.bridge.queue.MessageQueueThreadImpl.AnonymousClass2 */

            public void run() {
                MessageQueueThreadImpl.assignToPerfStats(MessageQueueThreadImpl.this.mPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
            }
        });
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void runOnQueue(Runnable runnable) {
        if (this.mIsFinished) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Tried to enqueue runnable on already finished thread: '");
            outline15.append(getName());
            outline15.append("... dropping Runnable.");
            FLog.w("ReactNative", outline15.toString());
        }
        this.mHandler.post(runnable);
    }

    public MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler, MessageQueueThreadPerfStats messageQueueThreadPerfStats) {
        this.mIsFinished = false;
        this.mName = str;
        this.mLooper = looper;
        this.mHandler = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        this.mPerfStats = messageQueueThreadPerfStats;
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Expected to be called from the '");
        outline15.append(getName());
        outline15.append("' thread!");
        this.mAssertionErrorMessage = outline15.toString();
    }

    @Override // com.facebook.react.bridge.queue.MessageQueueThread
    @DoNotStrip
    public void assertIsOnThread(String str) {
        boolean isOnThread = isOnThread();
        SoftAssertions.assertCondition(isOnThread, this.mAssertionErrorMessage + " " + str);
    }
}
