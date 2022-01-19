package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.concurrent.Executor;

public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    public static final Class<?> TAG = AbstractDraweeController.class;
    public Object mCallerContext;
    public String mContentDescription;
    public ControllerListener<INFO> mControllerListener;
    public Drawable mControllerOverlay;
    public DataSource<T> mDataSource;
    public final DeferredReleaser mDeferredReleaser;
    public Drawable mDrawable;
    public final DraweeEventTracker mEventTracker;
    public T mFetchedImage;
    public GestureDetector mGestureDetector;
    public boolean mHasFetchFailed;
    public String mId;
    public boolean mIsAttached;
    public boolean mIsRequestSubmitted;
    public boolean mJustConstructed;
    public boolean mRetainImageOnFailure;
    public RetryManager mRetryManager;
    public SettableDraweeHierarchy mSettableDraweeHierarchy;
    public final Executor mUiThreadImmediateExecutor;

    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.mEventTracker = DraweeEventTracker.sEnabled ? new DraweeEventTracker() : DraweeEventTracker.sInstance;
        this.mJustConstructed = true;
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(null, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.facebook.drawee.controller.ControllerListener<? super INFO> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        if (controllerListener != 0) {
            ControllerListener<INFO> controllerListener2 = this.mControllerListener;
            if (controllerListener2 instanceof InternalForwardingListener) {
                ((InternalForwardingListener) controllerListener2).addListener(controllerListener);
            } else if (controllerListener2 != null) {
                FrescoSystrace.isTracing();
                InternalForwardingListener internalForwardingListener = new InternalForwardingListener();
                internalForwardingListener.addListener(controllerListener2);
                internalForwardingListener.addListener(controllerListener);
                FrescoSystrace.isTracing();
                this.mControllerListener = internalForwardingListener;
            } else {
                this.mControllerListener = controllerListener;
            }
        } else {
            throw null;
        }
    }

    public abstract Drawable createDrawable(T t);

    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? (ControllerListener<INFO>) BaseControllerListener.NO_OP_LISTENER : controllerListener;
    }

    public int getImageHash(T t) {
        return System.identityHashCode(t);
    }

    public abstract INFO getImageInfo(T t);

    public final synchronized void init(String str, Object obj) {
        FrescoSystrace.isTracing();
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mJustConstructed && this.mDeferredReleaser != null) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        if (this.mRetryManager != null) {
            RetryManager retryManager = this.mRetryManager;
            retryManager.mTapToRetryEnabled = false;
            retryManager.mMaxTapToRetryAttempts = 4;
            retryManager.mTapToRetryAttempts = 0;
        }
        if (this.mGestureDetector != null) {
            GestureDetector gestureDetector = this.mGestureDetector;
            gestureDetector.mClickListener = null;
            gestureDetector.mIsCapturingGesture = false;
            gestureDetector.mIsClickCandidate = false;
            this.mGestureDetector.mClickListener = this;
        }
        if (this.mControllerListener instanceof InternalForwardingListener) {
            InternalForwardingListener internalForwardingListener = (InternalForwardingListener) this.mControllerListener;
            synchronized (internalForwardingListener) {
                internalForwardingListener.mListeners.clear();
            }
        } else {
            this.mControllerListener = null;
        }
        if (this.mSettableDraweeHierarchy != null) {
            this.mSettableDraweeHierarchy.reset();
            this.mSettableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mCallerContext = obj;
        FrescoSystrace.isTracing();
    }

    public final boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        if (!str.equals(this.mId) || dataSource != this.mDataSource || !this.mIsRequestSubmitted) {
            return false;
        }
        return true;
    }

    public final void logMessageAndFailure(String str, Throwable th) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    public final void logMessageAndImage(String str, T t) {
        if (FLog.isLoggable(2)) {
            Class<?> cls = TAG;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = this.mId;
            objArr[2] = str;
            objArr[3] = t != null ? t.getClass().getSimpleName() : "<null>";
            objArr[4] = Integer.valueOf(getImageHash(t));
            if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(2)) {
                ((FLogDefaultLoggingDelegate) FLog.sHandler).println(2, cls.getSimpleName(), FLog.formatString("controller %x %s: %s: image: %s %x", objArr));
            }
        }
    }

    public final void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        FrescoSystrace.isTracing();
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            FrescoSystrace.isTracing();
            return;
        }
        this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            logMessageAndFailure("final_failed @ onFailure", th);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                this.mSettableDraweeHierarchy.setImage(drawable, 1.0f, true);
            } else if (shouldRetryOnTap()) {
                this.mSettableDraweeHierarchy.setRetry(th);
            } else {
                this.mSettableDraweeHierarchy.setFailure(th);
            }
            getControllerListener().onFailure(this.mId, th);
        } else {
            logMessageAndFailure("intermediate_failed @ onFailure", th);
            getControllerListener().onIntermediateImageFailed(this.mId, th);
        }
        FrescoSystrace.isTracing();
    }

    /* JADX INFO: finally extract failed */
    public final void onNewResultInternal(String str, DataSource<T> dataSource, T t, float f, boolean z, boolean z2, boolean z3) {
        try {
            FrescoSystrace.isTracing();
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndImage("ignore_old_datasource @ onNewResult", t);
                CloseableReference.closeSafely(t);
                dataSource.close();
                FrescoSystrace.isTracing();
                return;
            }
            this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable createDrawable = createDrawable(t);
                T t2 = this.mFetchedImage;
                Drawable drawable = this.mDrawable;
                this.mFetchedImage = t;
                this.mDrawable = createDrawable;
                Animatable animatable = null;
                if (z) {
                    try {
                        logMessageAndImage("set_final_result @ onNewResult", t);
                        this.mDataSource = null;
                        this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                        ControllerListener<INFO> controllerListener = getControllerListener();
                        INFO imageInfo = getImageInfo(t);
                        Drawable drawable2 = this.mDrawable;
                        if (drawable2 instanceof Animatable) {
                            animatable = (Animatable) drawable2;
                        }
                        controllerListener.onFinalImageSet(str, imageInfo, animatable);
                    } finally {
                        if (!(drawable == null || drawable == createDrawable)) {
                            releaseDrawable(drawable);
                        }
                        if (!(t2 == null || t2 == t)) {
                            logMessageAndImage("release_previous_result @ onNewResult", t2);
                            CloseableReference.closeSafely(t2);
                        }
                    }
                } else if (z3) {
                    logMessageAndImage("set_temporary_result @ onNewResult", t);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                    ControllerListener<INFO> controllerListener2 = getControllerListener();
                    INFO imageInfo2 = getImageInfo(t);
                    Drawable drawable3 = this.mDrawable;
                    if (drawable3 instanceof Animatable) {
                        animatable = (Animatable) drawable3;
                    }
                    controllerListener2.onFinalImageSet(str, imageInfo2, animatable);
                } else {
                    logMessageAndImage("set_intermediate_result @ onNewResult", t);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, f, z2);
                    getControllerListener().onIntermediateImageSet(str, getImageInfo(t));
                }
                FrescoSystrace.isTracing();
            } catch (Exception e) {
                logMessageAndImage("drawable_failed @ onNewResult", t);
                CloseableReference.closeSafely(t);
                onFailureInternal(str, dataSource, e, z);
                FrescoSystrace.isTracing();
            }
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.mTapToRetryAttempts = 0;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.mIsCapturingGesture = false;
            gestureDetector.mIsClickCandidate = false;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        releaseFetch();
    }

    public abstract void releaseDrawable(Drawable drawable);

    public final void releaseFetch() {
        boolean z = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = this.mDataSource;
        if (dataSource != null) {
            dataSource.close();
            this.mDataSource = null;
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        this.mDrawable = null;
        T t = this.mFetchedImage;
        if (t != null) {
            logMessageAndImage("release", t);
            CloseableReference.closeSafely(this.mFetchedImage);
            this.mFetchedImage = null;
        }
        if (z) {
            getControllerListener().onRelease(this.mId);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, draweeHierarchy);
        }
        this.mEventTracker.recordEvent(draweeHierarchy != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(draweeHierarchy instanceof SettableDraweeHierarchy);
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
        }
    }

    public final boolean shouldRetryOnTap() {
        RetryManager retryManager;
        if (this.mHasFetchFailed && (retryManager = this.mRetryManager) != null) {
            if (retryManager.mTapToRetryEnabled && retryManager.mTapToRetryAttempts < retryManager.mMaxTapToRetryAttempts) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080  */
    public void submitRequest() {
        T t;
        FrescoSystrace.isTracing();
        PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) this;
        FrescoSystrace.isTracing();
        try {
            if (pipelineDraweeController.mMemoryCache != null) {
                if (pipelineDraweeController.mCacheKey != null) {
                    CloseableReference<CloseableImage> closeableReference = pipelineDraweeController.mMemoryCache.get(pipelineDraweeController.mCacheKey);
                    if (closeableReference == null || ((ImmutableQualityInfo) ((CloseableStaticBitmap) closeableReference.get()).mQualityInfo).mIsOfFullQuality) {
                        FrescoSystrace.isTracing();
                        t = closeableReference;
                        if (t == null) {
                            FrescoSystrace.isTracing();
                            this.mDataSource = null;
                            this.mIsRequestSubmitted = true;
                            this.mHasFetchFailed = false;
                            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
                            getControllerListener().onSubmit(this.mId, this.mCallerContext);
                            String str = this.mId;
                            synchronized (pipelineDraweeController) {
                                if (pipelineDraweeController.mImageOriginListener != null) {
                                    pipelineDraweeController.mImageOriginListener.onImageLoaded(str, 5, true, "PipelineDraweeController");
                                }
                            }
                            onNewResultInternal(this.mId, this.mDataSource, t, 1.0f, true, true, true);
                            FrescoSystrace.isTracing();
                            FrescoSystrace.isTracing();
                            return;
                        }
                        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
                        getControllerListener().onSubmit(this.mId, this.mCallerContext);
                        this.mSettableDraweeHierarchy.setProgress(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, true);
                        this.mIsRequestSubmitted = true;
                        this.mHasFetchFailed = false;
                        FrescoSystrace.isTracing();
                        if (FLog.isLoggable(2)) {
                            FLog.v(PipelineDraweeController.TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(pipelineDraweeController)));
                        }
                        FrescoSystrace.isTracing();
                        this.mDataSource = (DataSource<T>) pipelineDraweeController.mDataSourceSupplier.get();
                        if (FLog.isLoggable(2)) {
                            FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
                        }
                        final String str2 = this.mId;
                        final boolean hasResult = this.mDataSource.hasResult();
                        this.mDataSource.subscribe(new BaseDataSubscriber<T>() {
                            /* class com.facebook.drawee.controller.AbstractDraweeController.AnonymousClass1 */

                            @Override // com.facebook.datasource.BaseDataSubscriber
                            public void onFailureImpl(DataSource<T> dataSource) {
                                AbstractDraweeController.this.onFailureInternal(str2, dataSource, dataSource.getFailureCause(), true);
                            }

                            @Override // com.facebook.datasource.BaseDataSubscriber
                            public void onNewResultImpl(DataSource<T> dataSource) {
                                boolean isFinished = dataSource.isFinished();
                                boolean hasMultipleResults = dataSource.hasMultipleResults();
                                float progress = dataSource.getProgress();
                                T result = dataSource.getResult();
                                if (result != null) {
                                    AbstractDraweeController.this.onNewResultInternal(str2, dataSource, result, progress, isFinished, hasResult, hasMultipleResults);
                                } else if (isFinished) {
                                    AbstractDraweeController.this.onFailureInternal(str2, dataSource, new NullPointerException(), true);
                                }
                            }

                            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
                            public void onProgressUpdate(DataSource<T> dataSource) {
                                boolean isFinished = dataSource.isFinished();
                                float progress = dataSource.getProgress();
                                AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                                if (!abstractDraweeController.isExpectedDataSource(str2, dataSource)) {
                                    abstractDraweeController.logMessageAndFailure("ignore_old_datasource @ onProgress", null);
                                    dataSource.close();
                                } else if (!isFinished) {
                                    abstractDraweeController.mSettableDraweeHierarchy.setProgress(progress, false);
                                }
                            }
                        }, this.mUiThreadImmediateExecutor);
                        FrescoSystrace.isTracing();
                        return;
                    }
                    closeableReference.close();
                }
            }
            FrescoSystrace.isTracing();
            t = null;
            if (t == null) {
            }
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
        stringHelper.add("isAttached", this.mIsAttached);
        stringHelper.add("isRequestSubmitted", this.mIsRequestSubmitted);
        stringHelper.add("hasFetchFailed", this.mHasFetchFailed);
        stringHelper.addHolder("fetchedImage", String.valueOf(getImageHash(this.mFetchedImage)));
        stringHelper.addHolder("events", this.mEventTracker.toString());
        return stringHelper.toString();
    }
}
