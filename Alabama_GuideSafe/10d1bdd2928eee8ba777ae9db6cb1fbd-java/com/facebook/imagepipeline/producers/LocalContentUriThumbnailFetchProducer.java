package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    public static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
    public static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
    public static final String[] PROJECTION = {"_id", "_data"};
    public static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
    public static final String[] THUMBNAIL_PROJECTION = {"_data"};
    public final ContentResolver mContentResolver;

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    public static int getRotationAngle(String str) {
        if (str != null) {
            try {
                return AppCompatDelegateImpl.ConfigurationImplApi17.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                Class<?> cls = TAG;
                Object[] objArr = {str};
                if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(6)) {
                    ((FLogDefaultLoggingDelegate) FLog.sHandler).println(6, cls.getSimpleName(), FLog.formatString("Unable to retrieve thumbnail rotation for %s", objArr), e);
                }
            }
        }
        return 0;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return AppCompatDelegateImpl.ConfigurationImplApi17.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[RETURN] */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        EncodedImage encodedImage;
        Uri uri = imageRequest.mSourceUri;
        if (UriUtil.isLocalCameraUri(uri)) {
            ResizeOptions resizeOptions = imageRequest.mResizeOptions;
            Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (!(resizeOptions == null || (encodedImage = getThumbnail(resizeOptions, query.getInt(query.getColumnIndex("_id")))) == null)) {
                            encodedImage.mRotationAngle = getRotationAngle(string);
                            query.close();
                            if (encodedImage == null) {
                                return encodedImage;
                            }
                        }
                    }
                } finally {
                    query.close();
                }
            }
            encodedImage = null;
            if (encodedImage == null) {
                return null;
            }
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082  */
    public final EncodedImage getThumbnail(ResizeOptions resizeOptions, int i) throws IOException {
        int i2;
        Throwable th;
        int i3;
        if (AppCompatDelegateImpl.ConfigurationImplApi17.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), resizeOptions)) {
            i2 = 3;
        } else {
            i2 = AppCompatDelegateImpl.ConfigurationImplApi17.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions) ? 1 : 0;
        }
        Cursor cursor = null;
        if (i2 == 0) {
            return null;
        }
        try {
            Cursor queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, (long) i, i2, THUMBNAIL_PROJECTION);
            if (queryMiniThumbnail == null) {
                if (queryMiniThumbnail != null) {
                    queryMiniThumbnail.close();
                }
                return null;
            }
            try {
                queryMiniThumbnail.moveToFirst();
                if (queryMiniThumbnail.getCount() > 0) {
                    String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        FileInputStream fileInputStream = new FileInputStream(string);
                        if (string == null) {
                            i3 = -1;
                        } else {
                            i3 = (int) new File(string).length();
                        }
                        EncodedImage byteBufferBackedEncodedImage = getByteBufferBackedEncodedImage(fileInputStream, i3);
                        queryMiniThumbnail.close();
                        return byteBufferBackedEncodedImage;
                    }
                }
                queryMiniThumbnail.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = queryMiniThumbnail;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
    }
}
