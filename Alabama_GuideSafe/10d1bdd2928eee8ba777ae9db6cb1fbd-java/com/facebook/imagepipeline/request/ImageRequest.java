package com.facebook.imagepipeline.request;

import android.net.Uri;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.BugsnagReactNative;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.react.modules.network.NetworkingModule;
import java.io.File;
import java.util.Arrays;

public class ImageRequest {
    public final BytesRange mBytesRange;
    public final CacheChoice mCacheChoice;
    public final Boolean mDecodePrefetches;
    public final ImageDecodeOptions mImageDecodeOptions;
    public final boolean mIsDiskCacheEnabled;
    public final boolean mIsMemoryCacheEnabled;
    public final boolean mLocalThumbnailPreviewsEnabled;
    public final RequestLevel mLowestPermittedRequestLevel;
    public final Postprocessor mPostprocessor;
    public final boolean mProgressiveRenderingEnabled;
    public final RequestListener mRequestListener;
    public final Priority mRequestPriority;
    public final ResizeOptions mResizeOptions;
    public final Boolean mResizingAllowedOverride;
    public final RotationOptions mRotationOptions;
    public File mSourceFile;
    public final Uri mSourceUri;
    public final int mSourceUriType;

    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        public int mValue;

        /* access modifiers changed from: public */
        RequestLevel(int i) {
            this.mValue = i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    public ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        int i;
        this.mCacheChoice = imageRequestBuilder.mCacheChoice;
        Uri uri = imageRequestBuilder.mSourceUri;
        this.mSourceUri = uri;
        boolean z = true;
        if (uri != null) {
            if (UriUtil.isNetworkUri(uri)) {
                i = 0;
            } else if (UriUtil.isLocalFileUri(uri)) {
                String extractMime = MediaUtils.extractMime(uri.getPath());
                i = extractMime != null && extractMime.startsWith("video/") ? 2 : 3;
            } else if (UriUtil.isLocalContentUri(uri)) {
                i = 4;
            } else if ("asset".equals(UriUtil.getSchemeOrNull(uri))) {
                i = 5;
            } else if ("res".equals(UriUtil.getSchemeOrNull(uri))) {
                i = 6;
            } else if (BugsnagReactNative.DATA_KEY.equals(UriUtil.getSchemeOrNull(uri))) {
                i = 7;
            } else if ("android.resource".equals(UriUtil.getSchemeOrNull(uri))) {
                i = 8;
            }
            this.mSourceUriType = i;
            this.mProgressiveRenderingEnabled = imageRequestBuilder.mProgressiveRenderingEnabled;
            this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.mLocalThumbnailPreviewsEnabled;
            this.mImageDecodeOptions = imageRequestBuilder.mImageDecodeOptions;
            this.mResizeOptions = imageRequestBuilder.mResizeOptions;
            RotationOptions rotationOptions = imageRequestBuilder.mRotationOptions;
            this.mRotationOptions = rotationOptions == null ? RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE : rotationOptions;
            this.mBytesRange = imageRequestBuilder.mBytesRange;
            this.mRequestPriority = imageRequestBuilder.mRequestPriority;
            this.mLowestPermittedRequestLevel = imageRequestBuilder.mLowestPermittedRequestLevel;
            this.mIsDiskCacheEnabled = (!imageRequestBuilder.mDiskCacheEnabled || !UriUtil.isNetworkUri(imageRequestBuilder.mSourceUri)) ? false : z;
            this.mIsMemoryCacheEnabled = imageRequestBuilder.mMemoryCacheEnabled;
            this.mDecodePrefetches = imageRequestBuilder.mDecodePrefetches;
            this.mPostprocessor = imageRequestBuilder.mPostprocessor;
            this.mRequestListener = imageRequestBuilder.mRequestListener;
            this.mResizingAllowedOverride = imageRequestBuilder.mResizingAllowedOverride;
        }
        i = -1;
        this.mSourceUriType = i;
        this.mProgressiveRenderingEnabled = imageRequestBuilder.mProgressiveRenderingEnabled;
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.mLocalThumbnailPreviewsEnabled;
        this.mImageDecodeOptions = imageRequestBuilder.mImageDecodeOptions;
        this.mResizeOptions = imageRequestBuilder.mResizeOptions;
        RotationOptions rotationOptions2 = imageRequestBuilder.mRotationOptions;
        this.mRotationOptions = rotationOptions2 == null ? RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE : rotationOptions2;
        this.mBytesRange = imageRequestBuilder.mBytesRange;
        this.mRequestPriority = imageRequestBuilder.mRequestPriority;
        this.mLowestPermittedRequestLevel = imageRequestBuilder.mLowestPermittedRequestLevel;
        this.mIsDiskCacheEnabled = (!imageRequestBuilder.mDiskCacheEnabled || !UriUtil.isNetworkUri(imageRequestBuilder.mSourceUri)) ? false : z;
        this.mIsMemoryCacheEnabled = imageRequestBuilder.mMemoryCacheEnabled;
        this.mDecodePrefetches = imageRequestBuilder.mDecodePrefetches;
        this.mPostprocessor = imageRequestBuilder.mPostprocessor;
        this.mRequestListener = imageRequestBuilder.mRequestListener;
        this.mResizingAllowedOverride = imageRequestBuilder.mResizingAllowedOverride;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mSourceUri, imageRequest.mSourceUri) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mCacheChoice, imageRequest.mCacheChoice) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mSourceFile, imageRequest.mSourceFile) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mBytesRange, imageRequest.mBytesRange) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mResizeOptions, imageRequest.mResizeOptions) || !AppCompatDelegateImpl.ConfigurationImplApi17.equal(this.mRotationOptions, imageRequest.mRotationOptions)) {
            return false;
        }
        Postprocessor postprocessor = this.mPostprocessor;
        CacheKey cacheKey = null;
        CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        Postprocessor postprocessor2 = imageRequest.mPostprocessor;
        if (postprocessor2 != null) {
            cacheKey = postprocessor2.getPostprocessorCacheKey();
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.equal(postprocessorCacheKey, cacheKey);
    }

    public synchronized File getSourceFile() {
        if (this.mSourceFile == null) {
            this.mSourceFile = new File(this.mSourceUri.getPath());
        }
        return this.mSourceFile;
    }

    public int hashCode() {
        Postprocessor postprocessor = this.mPostprocessor;
        return Arrays.hashCode(new Object[]{this.mCacheChoice, this.mSourceUri, this.mSourceFile, this.mBytesRange, this.mImageDecodeOptions, this.mResizeOptions, this.mRotationOptions, postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null, this.mResizingAllowedOverride});
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = AppCompatDelegateImpl.ConfigurationImplApi17.toStringHelper(this);
        stringHelper.addHolder(NetworkingModule.REQUEST_BODY_KEY_URI, this.mSourceUri);
        stringHelper.addHolder("cacheChoice", this.mCacheChoice);
        stringHelper.addHolder("decodeOptions", this.mImageDecodeOptions);
        stringHelper.addHolder("postprocessor", this.mPostprocessor);
        stringHelper.addHolder("priority", this.mRequestPriority);
        stringHelper.addHolder("resizeOptions", this.mResizeOptions);
        stringHelper.addHolder("rotationOptions", this.mRotationOptions);
        stringHelper.addHolder("bytesRange", this.mBytesRange);
        stringHelper.addHolder("resizingAllowedOverride", this.mResizingAllowedOverride);
        return stringHelper.toString();
    }
}
