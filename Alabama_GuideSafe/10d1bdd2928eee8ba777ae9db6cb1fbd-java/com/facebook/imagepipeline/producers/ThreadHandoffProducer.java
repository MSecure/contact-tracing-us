package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;

public class ThreadHandoffProducer<T> implements Producer<T> {
    public final Producer<T> mInputProducer;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        if (producer != null) {
            this.mInputProducer = producer;
            this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
            return;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final Consumer<T> consumer, final ProducerContext producerContext) {
        final RequestListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final AnonymousClass1 r10 = new StatefulProducerRunnable<T>("BackgroundThreadHandoffProducer", listener, id, consumer) {
            /* class com.facebook.imagepipeline.producers.ThreadHandoffProducer.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void disposeResult(T t) {
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public T getResult() throws Exception {
                return null;
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void onSuccess(T t) {
                listener.onProducerFinishWithSuccess(id, "BackgroundThreadHandoffProducer", null);
                ThreadHandoffProducer.this.mInputProducer.produceResults(consumer, producerContext);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.ThreadHandoffProducer.AnonymousClass2 */

            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                r10.cancel();
                ThreadHandoffProducerQueue threadHandoffProducerQueue = ThreadHandoffProducer.this.mThreadHandoffProducerQueue;
                StatefulProducerRunnable statefulProducerRunnable = r10;
                synchronized (threadHandoffProducerQueue) {
                    threadHandoffProducerQueue.mRunnableList.remove(statefulProducerRunnable);
                }
            }
        });
        ThreadHandoffProducerQueue threadHandoffProducerQueue = this.mThreadHandoffProducerQueue;
        synchronized (threadHandoffProducerQueue) {
            if (threadHandoffProducerQueue.mQueueing) {
                threadHandoffProducerQueue.mRunnableList.add(r10);
            } else {
                threadHandoffProducerQueue.mExecutor.execute(r10);
            }
        }
    }
}
