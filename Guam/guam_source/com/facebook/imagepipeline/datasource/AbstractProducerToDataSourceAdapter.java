package com.facebook.imagepipeline.datasource;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> {
    public final RequestListener mRequestListener;
    public final SettableProducerContext mSettableProducerContext;

    public AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        FrescoSystrace.isTracing();
        this.mSettableProducerContext = settableProducerContext;
        this.mRequestListener = requestListener;
        FrescoSystrace.isTracing();
        RequestListener requestListener2 = this.mRequestListener;
        ImageRequest imageRequest = settableProducerContext.mImageRequest;
        SettableProducerContext settableProducerContext2 = this.mSettableProducerContext;
        requestListener2.onRequestStart(imageRequest, settableProducerContext2.mCallerContext, settableProducerContext2.mId, settableProducerContext2.isPrefetch());
        FrescoSystrace.isTracing();
        FrescoSystrace.isTracing();
        producer.produceResults(new BaseConsumer<T>() {
            /* class com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = AbstractProducerToDataSourceAdapter.this;
                synchronized (abstractProducerToDataSourceAdapter) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkState(abstractProducerToDataSourceAdapter.isClosed());
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                AbstractProducerToDataSourceAdapter.access$000(AbstractProducerToDataSourceAdapter.this, th);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(T t, int i) {
                AbstractProducerToDataSourceAdapter.this.onNewResultImpl(t, i);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f) {
                AbstractProducerToDataSourceAdapter.this.setProgress(f);
            }
        }, settableProducerContext);
        FrescoSystrace.isTracing();
        FrescoSystrace.isTracing();
    }

    public static void access$000(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter, Throwable th) {
        if (super.setFailure(th)) {
            RequestListener requestListener = abstractProducerToDataSourceAdapter.mRequestListener;
            SettableProducerContext settableProducerContext = abstractProducerToDataSourceAdapter.mSettableProducerContext;
            requestListener.onRequestFailure(settableProducerContext.mImageRequest, settableProducerContext.mId, th, settableProducerContext.isPrefetch());
        }
    }

    @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.mRequestListener.onRequestCancellation(this.mSettableProducerContext.mId);
        this.mSettableProducerContext.cancel();
        return true;
    }

    public void onNewResultImpl(T t, int i) {
        boolean isLast = BaseConsumer.isLast(i);
        if (super.setResult(t, isLast) && isLast) {
            RequestListener requestListener = this.mRequestListener;
            SettableProducerContext settableProducerContext = this.mSettableProducerContext;
            requestListener.onRequestSuccess(settableProducerContext.mImageRequest, settableProducerContext.mId, settableProducerContext.isPrefetch());
        }
    }
}
