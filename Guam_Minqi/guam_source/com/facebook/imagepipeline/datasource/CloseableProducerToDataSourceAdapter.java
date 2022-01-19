package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    public CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        super(producer, settableProducerContext, requestListener);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(Object obj) {
        CloseableReference.closeSafely((CloseableReference) obj);
    }

    @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
    public Object getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public void onNewResultImpl(Object obj, int i) {
        super.onNewResultImpl(CloseableReference.cloneOrNull((CloseableReference) obj), i);
    }
}
