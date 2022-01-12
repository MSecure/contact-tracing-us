package com.facebook.imagepipeline.producers;

import android.util.Pair;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    public final Producer<T> mInputProducer;
    public final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers = new HashMap();

    public class Multiplexer {
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = new CopyOnWriteArraySet<>();
        public MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
        public final K mKey;
        public T mLastIntermediateResult;
        public float mLastProgress;
        public int mLastStatus;
        public BaseProducerContext mMultiplexProducerContext;

        public class ForwardingConsumer extends BaseConsumer<T> {
            public ForwardingConsumer(AnonymousClass1 r2) {
            }

            /* JADX INFO: finally extract failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                try {
                    FrescoSystrace.isTracing();
                    Multiplexer multiplexer = Multiplexer.this;
                    synchronized (multiplexer) {
                        if (multiplexer.mForwardingConsumer == this) {
                            multiplexer.mForwardingConsumer = null;
                            multiplexer.mMultiplexProducerContext = null;
                            multiplexer.closeSafely(multiplexer.mLastIntermediateResult);
                            multiplexer.mLastIntermediateResult = null;
                            multiplexer.startInputProducerIfHasAttachedConsumers();
                        }
                    }
                    FrescoSystrace.isTracing();
                } catch (Throwable th) {
                    FrescoSystrace.isTracing();
                    throw th;
                }
            }

            /* JADX INFO: finally extract failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                try {
                    FrescoSystrace.isTracing();
                    Multiplexer.this.onFailure(this, th);
                    FrescoSystrace.isTracing();
                } catch (Throwable th2) {
                    FrescoSystrace.isTracing();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer$Multiplexer */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    FrescoSystrace.isTracing();
                    Multiplexer.this.onNextResult(this, closeable, i);
                    FrescoSystrace.isTracing();
                } catch (Throwable th) {
                    FrescoSystrace.isTracing();
                    throw th;
                }
            }

            /* JADX INFO: finally extract failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f) {
                try {
                    FrescoSystrace.isTracing();
                    Multiplexer.this.onProgressUpdate(this, f);
                    FrescoSystrace.isTracing();
                } catch (Throwable th) {
                    FrescoSystrace.isTracing();
                    throw th;
                }
            }
        }

        public Multiplexer(K k) {
            this.mKey = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.Consumer<T extends java.io.Closeable> */
        /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(r1);
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(r2);
            com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
            if (r4 == r7.mLastIntermediateResult) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
            r4 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
            if (r4 == null) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            r4 = r7.this$0.cloneOrNull(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            if (r4 == null) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
            if (r5 <= com.facebook.react.uimanager.BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            r8.onProgressUpdate(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
            r8.onNewResult(r4, r6);
            closeSafely(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
            r9.addCallbacks(new com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.AnonymousClass1(r7));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
            return true;
         */
        public boolean addNewConsumer(Consumer<T> consumer, ProducerContext producerContext) {
            MultiplexProducer<K, T>.Multiplexer multiplexer;
            final Pair create = Pair.create(consumer, producerContext);
            synchronized (this) {
                MultiplexProducer multiplexProducer = MultiplexProducer.this;
                K k = this.mKey;
                synchronized (multiplexProducer) {
                    multiplexer = multiplexProducer.mMultiplexers.get(k);
                }
                if (multiplexer != this) {
                    return false;
                }
                this.mConsumerContextPairs.add(create);
                List<ProducerContextCallbacks> updateIsPrefetch = updateIsPrefetch();
                List<ProducerContextCallbacks> updatePriority = updatePriority();
                List<ProducerContextCallbacks> updateIsIntermediateResultExpected = updateIsIntermediateResultExpected();
                Closeable closeable = this.mLastIntermediateResult;
                float f = this.mLastProgress;
                int i = this.mLastStatus;
            }
        }

        public final void closeSafely(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public final synchronized boolean computeIsIntermediateResultExpected() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean computeIsPrefetch() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized Priority computePriority() {
            Priority priority;
            priority = Priority.LOW;
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                Priority priority2 = ((ProducerContext) it.next().second).getPriority();
                if (priority != null) {
                    if (priority2 != null) {
                        if (priority.ordinal() > priority2.ordinal()) {
                        }
                    }
                }
                priority = priority2;
            }
            return priority;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
            r0 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            ((com.facebook.imagepipeline.producers.Consumer) r0.first).onFailure(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
            if (r3.hasNext() == false) goto L_0x003b;
         */
        public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, Throwable th) {
            synchronized (this) {
                if (this.mForwardingConsumer == forwardingConsumer) {
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    this.mConsumerContextPairs.clear();
                    MultiplexProducer.access$700(MultiplexProducer.this, this.mKey, this);
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            if (r3.hasNext() == false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
            r0 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            ((com.facebook.imagepipeline.producers.Consumer) r0.first).onNewResult(r4, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
            return;
         */
        public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, T t, int i) {
            synchronized (this) {
                if (this.mForwardingConsumer == forwardingConsumer) {
                    closeSafely(this.mLastIntermediateResult);
                    this.mLastIntermediateResult = null;
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                    if (BaseConsumer.isNotLast(i)) {
                        this.mLastIntermediateResult = (T) MultiplexProducer.this.cloneOrNull(t);
                        this.mLastStatus = i;
                    } else {
                        this.mConsumerContextPairs.clear();
                        MultiplexProducer.access$700(MultiplexProducer.this, this.mKey, this);
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
            r0 = r3.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            ((com.facebook.imagepipeline.producers.Consumer) r0.first).onProgressUpdate(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            if (r3.hasNext() == false) goto L_0x0029;
         */
        public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, float f) {
            synchronized (this) {
                if (this.mForwardingConsumer == forwardingConsumer) {
                    this.mLastProgress = f;
                    Iterator<Pair<Consumer<T>, ProducerContext>> it = this.mConsumerContextPairs.iterator();
                }
            }
        }

        public final void startInputProducerIfHasAttachedConsumers() {
            synchronized (this) {
                boolean z = true;
                AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(this.mMultiplexProducerContext == null);
                if (this.mForwardingConsumer != null) {
                    z = false;
                }
                AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
                if (this.mConsumerContextPairs.isEmpty()) {
                    MultiplexProducer.access$700(MultiplexProducer.this, this.mKey, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.mConsumerContextPairs.iterator().next().second;
                this.mMultiplexProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
                MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer = new ForwardingConsumer(null);
                this.mForwardingConsumer = forwardingConsumer;
                MultiplexProducer.this.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
            }
        }

        public final synchronized List<ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            ArrayList arrayList = null;
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            boolean computeIsIntermediateResultExpected = computeIsIntermediateResultExpected();
            synchronized (baseProducerContext) {
                if (computeIsIntermediateResultExpected != baseProducerContext.mIsIntermediateResultExpected) {
                    baseProducerContext.mIsIntermediateResultExpected = computeIsIntermediateResultExpected;
                    arrayList = new ArrayList(baseProducerContext.mCallbacks);
                }
            }
            return arrayList;
        }

        public final synchronized List<ProducerContextCallbacks> updateIsPrefetch() {
            ArrayList arrayList = null;
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            boolean computeIsPrefetch = computeIsPrefetch();
            synchronized (baseProducerContext) {
                if (computeIsPrefetch != baseProducerContext.mIsPrefetch) {
                    baseProducerContext.mIsPrefetch = computeIsPrefetch;
                    arrayList = new ArrayList(baseProducerContext.mCallbacks);
                }
            }
            return arrayList;
        }

        public final synchronized List<ProducerContextCallbacks> updatePriority() {
            ArrayList arrayList = null;
            if (this.mMultiplexProducerContext == null) {
                return null;
            }
            BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            Priority computePriority = computePriority();
            synchronized (baseProducerContext) {
                if (computePriority != baseProducerContext.mPriority) {
                    baseProducerContext.mPriority = computePriority;
                    arrayList = new ArrayList(baseProducerContext.mCallbacks);
                }
            }
            return arrayList;
        }
    }

    public MultiplexProducer(Producer<T> producer) {
        this.mInputProducer = producer;
    }

    public static void access$700(MultiplexProducer multiplexProducer, Object obj, Multiplexer multiplexer) {
        synchronized (multiplexProducer) {
            if (multiplexProducer.mMultiplexers.get(obj) == multiplexer) {
                multiplexProducer.mMultiplexers.remove(obj);
            }
        }
    }

    public abstract T cloneOrNull(T t);

    public abstract K getKey(ProducerContext producerContext);

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        MultiplexProducer<K, T>.Multiplexer multiplexer;
        try {
            FrescoSystrace.isTracing();
            K key = getKey(producerContext);
            do {
                z = false;
                synchronized (this) {
                    synchronized (this) {
                        multiplexer = this.mMultiplexers.get(key);
                    }
                }
                if (multiplexer == null) {
                    synchronized (this) {
                        multiplexer = new Multiplexer(key);
                        this.mMultiplexers.put(key, multiplexer);
                        z = true;
                    }
                }
            } while (!multiplexer.addNewConsumer(consumer, producerContext));
            if (z) {
                multiplexer.startInputProducerIfHasAttachedConsumers();
            }
            FrescoSystrace.isTracing();
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }
}
