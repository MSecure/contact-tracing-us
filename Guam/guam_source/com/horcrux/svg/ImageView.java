package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
public class ImageView extends RenderableView {
    public String mAlign;
    public SVGLength mH;
    public int mImageHeight;
    public int mImageWidth;
    public final AtomicBoolean mLoading = new AtomicBoolean(false);
    public int mMeetOrSlice;
    public SVGLength mW;
    public SVGLength mX;
    public SVGLength mY;
    public String uriString;

    public ImageView(ReactContext reactContext) {
        super(reactContext);
    }

    public final void doRender(Canvas canvas, Paint paint, Bitmap bitmap, float f) {
        if (this.mImageWidth == 0 || this.mImageHeight == 0) {
            this.mImageWidth = bitmap.getWidth();
            this.mImageHeight = bitmap.getHeight();
        }
        RectF rect = getRect();
        RectF rectF = new RectF(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) this.mImageWidth, (float) this.mImageHeight);
        PathParser.getTransform(rectF, rect, this.mAlign, this.mMeetOrSlice).mapRect(rectF);
        canvas.clipPath(getPath(canvas, paint));
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        this.mCTM.mapRect(rectF);
        setClientRect(rectF);
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public void draw(Canvas canvas, Paint paint, float f) {
        Uri uri;
        Bitmap bitmap;
        if (!this.mLoading.get()) {
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            ReactContext reactContext = this.mContext;
            String str = this.uriString;
            try {
                uri = Uri.parse(str);
                if (uri.getScheme() == null) {
                    uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactContext, str);
                }
            } catch (Exception unused) {
                uri = ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(reactContext, str);
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(uri);
            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(uri).build();
            if (imagePipeline != null) {
                CloseableReference<CloseableImage> closeableReference = imagePipeline.mBitmapMemoryCache.get(((DefaultCacheKeyFactory) imagePipeline.mCacheKeyFactory).getBitmapCacheKey(build, null));
                try {
                    boolean isValid = CloseableReference.isValid(closeableReference);
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                    if (isValid) {
                        float f2 = f * this.mOpacity;
                        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = imagePipeline.fetchDecodedImage(build, this.mContext, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, null);
                        try {
                            CloseableReference<CloseableImage> result = fetchDecodedImage.getResult();
                            if (result != null) {
                                try {
                                    CloseableImage closeableImage = result.get();
                                    if ((closeableImage instanceof CloseableBitmap) && (bitmap = ((CloseableStaticBitmap) ((CloseableBitmap) closeableImage)).mBitmap) != null) {
                                        doRender(canvas, paint, bitmap, f2);
                                    }
                                    result.close();
                                } catch (Exception e) {
                                    throw new IllegalStateException(e);
                                } catch (Throwable th) {
                                    result.close();
                                    throw th;
                                }
                            }
                            fetchDecodedImage.close();
                        } catch (Exception e2) {
                            throw new IllegalStateException(e2);
                        } catch (Throwable th2) {
                            fetchDecodedImage.close();
                            throw th2;
                        }
                    } else {
                        this.mLoading.set(true);
                        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage2 = imagePipeline.fetchDecodedImage(build, this.mContext, ImageRequest.RequestLevel.FULL_FETCH, null);
                        AnonymousClass1 r7 = new BaseBitmapDataSubscriber() {
                            /* class com.horcrux.svg.ImageView.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.datasource.DataSource] */
                            @Override // com.facebook.datasource.BaseDataSubscriber
                            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                ImageView.this.mLoading.set(false);
                                Throwable failureCause = dataSource.getFailureCause();
                                Object[] objArr = new Object[0];
                                if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(5)) {
                                    ((FLogDefaultLoggingDelegate) FLog.sHandler).println(5, "ReactNative", FLog.formatString("RNSVG: fetchDecodedImage failed!", objArr), failureCause);
                                }
                            }
                        };
                        if (UiThreadImmediateExecutorService.sInstance == null) {
                            UiThreadImmediateExecutorService.sInstance = new UiThreadImmediateExecutorService();
                        }
                        fetchDecodedImage2.subscribe(r7, UiThreadImmediateExecutorService.sInstance);
                    }
                } catch (Throwable th3) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th3;
                }
            } else {
                throw null;
            }
        }
    }

    @Override // com.horcrux.svg.VirtualView, com.horcrux.svg.RenderableView
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        ((VirtualView) this).mPath = path;
        path.addRect(getRect(), Path.Direction.CW);
        return ((VirtualView) this).mPath;
    }

    public final RectF getRect() {
        double relativeOnWidth = relativeOnWidth(this.mX);
        double relativeOnHeight = relativeOnHeight(this.mY);
        double relativeOnWidth2 = relativeOnWidth(this.mW);
        double relativeOnHeight2 = relativeOnHeight(this.mH);
        if (relativeOnWidth2 == 0.0d) {
            relativeOnWidth2 = (double) (((float) this.mImageWidth) * this.mScale);
        }
        if (relativeOnHeight2 == 0.0d) {
            relativeOnHeight2 = (double) (((float) this.mImageHeight) * this.mScale);
        }
        return new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2));
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)
    public void setHeight(Dynamic dynamic) {
        this.mH = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    @ReactProp(name = "src")
    public void setSrc(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString(NetworkingModule.REQUEST_BODY_KEY_URI);
            this.uriString = string;
            if (string != null && !string.isEmpty()) {
                if (!readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH) || !readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)) {
                    this.mImageWidth = 0;
                    this.mImageHeight = 0;
                } else {
                    this.mImageWidth = readableMap.getInt(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH);
                    this.mImageHeight = readableMap.getInt(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT);
                }
                if (Uri.parse(this.uriString).getScheme() == null) {
                    ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(this.mContext, this.uriString);
                }
            }
        }
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH)
    public void setWidth(Dynamic dynamic) {
        this.mW = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = SVGLength.from(dynamic);
        invalidate();
    }
}
