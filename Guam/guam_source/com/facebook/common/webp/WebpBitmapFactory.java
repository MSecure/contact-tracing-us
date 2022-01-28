package com.facebook.common.webp;

public interface WebpBitmapFactory {

    public interface WebpErrorLogger {
    }

    void setBitmapCreator(BitmapCreator bitmapCreator);

    void setWebpErrorLogger(WebpErrorLogger webpErrorLogger);
}
