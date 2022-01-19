package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    public static String access$000(LocalVideoThumbnailProducer localVideoThumbnailProducer, ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri uri;
        String str2 = null;
        if (localVideoThumbnailProducer != null) {
            Uri uri2 = imageRequest.mSourceUri;
            if (UriUtil.isLocalFileUri(uri2)) {
                return imageRequest.getSourceFile().getPath();
            }
            if (!UriUtil.isLocalContentUri(uri2)) {
                return null;
            }
            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                String documentId = DocumentsContract.getDocumentId(uri2);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(ColorPropConverter.PACKAGE_DELIMITER)[1]};
            } else {
                str = null;
                strArr = null;
                uri = uri2;
            }
            Cursor query = localVideoThumbnailProducer.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndexOrThrow("_data"));
                        query.close();
                        return str2;
                    }
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            if (query == null) {
                return null;
            }
            query.close();
            return str2;
        }
        throw null;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final RequestListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final AnonymousClass1 r9 = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, "VideoThumbnailProducer", listener, id) {
            /* class com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void disposeResult(Object obj) {
                CloseableReference.closeSafely((CloseableReference) obj);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map getExtraMapOnSuccess(Object obj) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(((CloseableReference) obj) != null));
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Object getResult() throws Exception {
                String str;
                Bitmap bitmap;
                int i;
                try {
                    str = LocalVideoThumbnailProducer.access$000(LocalVideoThumbnailProducer.this, imageRequest);
                } catch (IllegalArgumentException unused) {
                    str = null;
                }
                if (str != null) {
                    ImageRequest imageRequest = imageRequest;
                    ResizeOptions resizeOptions = imageRequest.mResizeOptions;
                    int i2 = 2048;
                    if ((resizeOptions != null ? resizeOptions.width : 2048) <= 96) {
                        ResizeOptions resizeOptions2 = imageRequest.mResizeOptions;
                        if (resizeOptions2 != null) {
                            i2 = resizeOptions2.height;
                        }
                        if (i2 <= 96) {
                            i = 3;
                            bitmap = ThumbnailUtils.createVideoThumbnail(str, i);
                        }
                    }
                    i = 1;
                    bitmap = ThumbnailUtils.createVideoThumbnail(str, i);
                } else {
                    try {
                        ParcelFileDescriptor openFileDescriptor = LocalVideoThumbnailProducer.this.mContentResolver.openFileDescriptor(imageRequest.mSourceUri, "r");
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                        bitmap = mediaMetadataRetriever.getFrameAtTime(-1);
                    } catch (FileNotFoundException unused2) {
                        bitmap = null;
                    }
                }
                if (bitmap == null) {
                    return null;
                }
                return CloseableReference.of(new CloseableStaticBitmap(bitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                listener.onUltimateProducerReached(id, "VideoThumbnailProducer", false);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void onSuccess(Object obj) {
                CloseableReference closeableReference = (CloseableReference) obj;
                super.onSuccess(closeableReference);
                listener.onUltimateProducerReached(id, "VideoThumbnailProducer", closeableReference != null);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks(this) {
            /* class com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.AnonymousClass2 */

            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                r9.cancel();
            }
        });
        this.mExecutor.execute(r9);
    }
}
