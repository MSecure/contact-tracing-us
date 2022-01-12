package com.facebook.imagepipeline.producers;

public class SwallowResultProducer<T> implements Producer<Void> {
    public final Producer<T> mInputProducer;

    public SwallowResultProducer(Producer<T> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<Void> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new DelegatingConsumer<T, Void>(this, consumer) {
            /* class com.facebook.imagepipeline.producers.SwallowResultProducer.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(T t, int i) {
                if (BaseConsumer.isLast(i)) {
                    this.mConsumer.onNewResult(null, i);
                }
            }
        }, producerContext);
    }
}
