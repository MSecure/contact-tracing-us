package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

public interface ProducerContext {
    void addCallbacks(ProducerContextCallbacks producerContextCallbacks);

    Object getCallerContext();

    String getId();

    ImageRequest getImageRequest();

    RequestListener getListener();

    ImageRequest.RequestLevel getLowestPermittedRequestLevel();

    Priority getPriority();

    boolean isIntermediateResultExpected();

    boolean isPrefetch();
}
