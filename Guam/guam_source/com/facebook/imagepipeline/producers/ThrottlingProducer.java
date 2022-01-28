package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThrottlingProducer<T> implements Producer<T> {
    public final Executor mExecutor;
    public final Producer<T> mInputProducer;
    public final int mMaxSimultaneousRequests;
    public int mNumCurrentRequests;
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests;

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        public ThrottlerConsumer(Consumer consumer, AnonymousClass1 r3) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onCancellationImpl() {
            this.mConsumer.onCancellation();
            onRequestFinished();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.DelegatingConsumer
        public void onFailureImpl(Throwable th) {
            this.mConsumer.onFailure(th);
            onRequestFinished();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, int i) {
            this.mConsumer.onNewResult(t, i);
            if (BaseConsumer.isLast(i)) {
                onRequestFinished();
            }
        }

        public final void onRequestFinished() {
            final Pair<Consumer<T>, ProducerContext> poll;
            synchronized (ThrottlingProducer.this) {
                poll = ThrottlingProducer.this.mPendingRequests.poll();
                if (poll == null) {
                    ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                    throttlingProducer.mNumCurrentRequests--;
                }
            }
            if (poll != null) {
                ThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    /* class com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.AnonymousClass1 */

                    public void run() {
                        ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                        Pair pair = poll;
                        throttlingProducer.produceResultsInternal((Consumer) pair.first, (ProducerContext) pair.second);
                    }
                });
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        if (executor != null) {
            this.mExecutor = executor;
            if (producer != null) {
                this.mInputProducer = producer;
                this.mPendingRequests = new ConcurrentLinkedQueue<>();
                this.mNumCurrentRequests = 0;
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.getListener().onProducerStart(producerContext.getId(), "ThrottlingProducer");
        synchronized (this) {
            z = true;
            if (this.mNumCurrentRequests >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(Pair.create(consumer, producerContext));
            } else {
                this.mNumCurrentRequests++;
                z = false;
            }
        }
        if (!z) {
            produceResultsInternal(consumer, producerContext);
        }
    }

    public void produceResultsInternal(Consumer<T> consumer, ProducerContext producerContext) {
        producerContext.getListener().onProducerFinishWithSuccess(producerContext.getId(), "ThrottlingProducer", null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(consumer, null), producerContext);
    }
}
