package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.EncodedImage;

public class DecodeException extends RuntimeException {
    public final EncodedImage mEncodedImage;

    public DecodeException(String str, EncodedImage encodedImage) {
        super(str);
        this.mEncodedImage = encodedImage;
    }
}
