package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.Map;

public class DefaultImageDecoder implements ImageDecoder {
    public final ImageDecoder mAnimatedGifDecoder;
    public final ImageDecoder mAnimatedWebPDecoder;
    public final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    public final ImageDecoder mDefaultDecoder = new ImageDecoder() {
        /* class com.facebook.imagepipeline.decoder.DefaultImageDecoder.AnonymousClass1 */

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            ImageDecoder imageDecoder;
            encodedImage.parseMetaDataIfNeeded();
            ImageFormat imageFormat = encodedImage.mImageFormat;
            if (imageFormat == DefaultImageFormats.JPEG) {
                DefaultImageDecoder defaultImageDecoder = DefaultImageDecoder.this;
                CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = defaultImageDecoder.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, i, imageDecodeOptions.colorSpace);
                try {
                    defaultImageDecoder.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
                    encodedImage.parseMetaDataIfNeeded();
                    int i2 = encodedImage.mRotationAngle;
                    encodedImage.parseMetaDataIfNeeded();
                    return new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, i2, encodedImage.mExifOrientation);
                } finally {
                    decodeJPEGFromEncodedImageWithColorSpace.close();
                }
            } else if (imageFormat == DefaultImageFormats.GIF) {
                DefaultImageDecoder defaultImageDecoder2 = DefaultImageDecoder.this;
                if (defaultImageDecoder2 != null) {
                    encodedImage.parseMetaDataIfNeeded();
                    if (encodedImage.mWidth != -1) {
                        encodedImage.parseMetaDataIfNeeded();
                        if (encodedImage.mHeight != -1) {
                            if (imageDecodeOptions.forceStaticImage || (imageDecoder = defaultImageDecoder2.mAnimatedGifDecoder) == null) {
                                return defaultImageDecoder2.decodeStaticImage(encodedImage, imageDecodeOptions);
                            }
                            return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
                        }
                    }
                    throw new DecodeException("image width or height is incorrect", encodedImage);
                }
                throw null;
            } else if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                return DefaultImageDecoder.this.mAnimatedWebPDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
            } else {
                if (imageFormat != ImageFormat.UNKNOWN) {
                    return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
        }
    };
    public final PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = null;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
        if (imageDecoder2 != null) {
            return imageDecoder2.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        encodedImage.parseMetaDataIfNeeded();
        ImageFormat imageFormat = encodedImage.mImageFormat;
        if (imageFormat == null || imageFormat == ImageFormat.UNKNOWN) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
            encodedImage.mImageFormat = imageFormat;
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map == null || (imageDecoder = map.get(imageFormat)) == null) {
            return this.mDefaultDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
        }
        return imageDecoder.decode(encodedImage, i, qualityInfo, imageDecodeOptions);
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, null, imageDecodeOptions.colorSpace);
        try {
            maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            QualityInfo qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
            encodedImage.parseMetaDataIfNeeded();
            int i = encodedImage.mRotationAngle;
            encodedImage.parseMetaDataIfNeeded();
            return new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, qualityInfo, i, encodedImage.mExifOrientation);
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public final void maybeApplyTransformation(BitmapTransformation bitmapTransformation, CloseableReference<Bitmap> closeableReference) {
        if (bitmapTransformation != null) {
            Bitmap bitmap = closeableReference.get();
            if (bitmapTransformation.modifiesTransparency()) {
                bitmap.setHasAlpha(true);
            }
            bitmapTransformation.transform(bitmap);
        }
    }
}
