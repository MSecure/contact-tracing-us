package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueue {
    public final Executor mExecutor;
    public boolean mQueueing = false;
    public final Deque<Runnable> mRunnableList;

    public ThreadHandoffProducerQueue(Executor executor) {
        if (executor != null) {
            this.mExecutor = executor;
            this.mRunnableList = new ArrayDeque();
            return;
        }
        throw null;
    }
}
