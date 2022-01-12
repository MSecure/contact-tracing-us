package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return AppCompatDelegateImpl.ConfigurationImplApi17.isImageBigEnough(512, 512, resizeOptions);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        RequestListener listener = producerContext.getListener();
        String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final AnonymousClass1 r7 = new StatefulProducerRunnable<EncodedImage>(consumer, listener, "LocalExifThumbnailProducer", id) {
            /* class com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.AnonymousClass1 */

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public void disposeResult(Object obj) {
                EncodedImage.closeSafely((EncodedImage) obj);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map getExtraMapOnSuccess(Object obj) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(((EncodedImage) obj) != null));
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0089  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x00d6  */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Object getResult() throws Exception {
                String str;
                ExifInterface exifInterface;
                Throwable th;
                int columnIndex;
                Uri uri = imageRequest.mSourceUri;
                ContentResolver contentResolver = LocalExifThumbnailProducer.this.mContentResolver;
                int i = -1;
                EncodedImage encodedImage = null;
                Cursor cursor = null;
                encodedImage = null;
                if (UriUtil.isLocalContentUri(uri)) {
                    try {
                        Cursor query = contentResolver.query(uri, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_data")) != -1) {
                                    str = query.getString(columnIndex);
                                    if (query != null) {
                                        query.close();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = query;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                        str = null;
                        if (query != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    str = UriUtil.isLocalFileUri(uri) ? uri.getPath() : null;
                }
                boolean z = false;
                if (str != null) {
                    try {
                        File file = new File(str);
                        if (file.exists() && file.canRead()) {
                            z = true;
                        }
                    } catch (IOException unused) {
                    } catch (StackOverflowError unused2) {
                        FLog.e(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
                    }
                }
                if (z) {
                    exifInterface = new ExifInterface(str);
                    if (exifInterface != null && exifInterface.hasThumbnail()) {
                        PooledByteBuffer newByteBuffer = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(exifInterface.getThumbnail());
                        if (LocalExifThumbnailProducer.this == null) {
                            Pair<Integer, Integer> decodeDimensions = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(newByteBuffer));
                            int autoRotateAngleFromOrientation = AppCompatDelegateImpl.ConfigurationImplApi17.getAutoRotateAngleFromOrientation(Integer.parseInt(exifInterface.getAttribute("Orientation")));
                            int intValue = decodeDimensions != null ? ((Integer) decodeDimensions.first).intValue() : -1;
                            if (decodeDimensions != null) {
                                i = ((Integer) decodeDimensions.second).intValue();
                            }
                            CloseableReference of = CloseableReference.of(newByteBuffer);
                            try {
                                encodedImage = new EncodedImage(of);
                                encodedImage.mImageFormat = DefaultImageFormats.JPEG;
                                encodedImage.mRotationAngle = autoRotateAngleFromOrientation;
                                encodedImage.mWidth = intValue;
                                encodedImage.mHeight = i;
                            } finally {
                                if (of != null) {
                                    of.close();
                                }
                            }
                        } else {
                            throw null;
                        }
                    }
                    return encodedImage;
                }
                exifInterface = null;
                PooledByteBuffer newByteBuffer2 = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(exifInterface.getThumbnail());
                if (LocalExifThumbnailProducer.this == null) {
                }
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks(this) {
            /* class com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.AnonymousClass2 */

            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                r7.cancel();
            }
        });
        this.mExecutor.execute(r7);
    }
}
