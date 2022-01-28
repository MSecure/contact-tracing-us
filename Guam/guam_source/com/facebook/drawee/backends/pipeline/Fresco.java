package com.facebook.drawee.backends.pipeline;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

public class Fresco {
    public static final Class<?> TAG = Fresco.class;
    public static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier = null;
    public static volatile boolean sIsInitialized = false;

    public static ImagePipeline getImagePipeline() {
        return ImagePipelineFactory.getInstance().getImagePipeline();
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = sDraweeControllerBuilderSupplier;
        if (pipelineDraweeControllerBuilderSupplier != null) {
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = new PipelineDraweeControllerBuilder(pipelineDraweeControllerBuilderSupplier.mContext, pipelineDraweeControllerBuilderSupplier.mPipelineDraweeControllerFactory, pipelineDraweeControllerBuilderSupplier.mImagePipeline, pipelineDraweeControllerBuilderSupplier.mBoundControllerListeners);
            pipelineDraweeControllerBuilder.mImagePerfDataListener = pipelineDraweeControllerBuilderSupplier.mDefaultImagePerfDataListener;
            return pipelineDraweeControllerBuilder;
        }
        throw null;
    }
}
