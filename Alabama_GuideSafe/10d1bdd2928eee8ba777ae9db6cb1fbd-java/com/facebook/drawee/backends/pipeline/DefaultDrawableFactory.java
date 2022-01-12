package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class DefaultDrawableFactory implements DrawableFactory {
    public final DrawableFactory mAnimatedDrawableFactory;
    public final Resources mResources;

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory) {
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public Drawable createDrawable(CloseableImage closeableImage) {
        try {
            FrescoSystrace.isTracing();
            if (closeableImage instanceof CloseableStaticBitmap) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, closeableStaticBitmap.mBitmap);
                int i = closeableStaticBitmap.mRotationAngle;
                boolean z = true;
                if (!((i == 0 || i == -1) ? false : true)) {
                    int i2 = closeableStaticBitmap.mExifOrientation;
                    if (i2 == 1 || i2 == 0) {
                        z = false;
                    }
                    if (!z) {
                        FrescoSystrace.isTracing();
                        return bitmapDrawable;
                    }
                }
                OrientedDrawable orientedDrawable = new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.mRotationAngle, closeableStaticBitmap.mExifOrientation);
                FrescoSystrace.isTracing();
                return orientedDrawable;
            } else if (this.mAnimatedDrawableFactory == null || !this.mAnimatedDrawableFactory.supportsImageType(closeableImage)) {
                FrescoSystrace.isTracing();
                return null;
            } else {
                Drawable createDrawable = this.mAnimatedDrawableFactory.createDrawable(closeableImage);
                FrescoSystrace.isTracing();
                return createDrawable;
            }
        } catch (Throwable th) {
            FrescoSystrace.isTracing();
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.drawable.DrawableFactory
    public boolean supportsImageType(CloseableImage closeableImage) {
        return true;
    }
}
