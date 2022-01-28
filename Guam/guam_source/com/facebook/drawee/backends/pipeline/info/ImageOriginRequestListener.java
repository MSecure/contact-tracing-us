package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;

public class ImageOriginRequestListener extends BaseRequestListener {
    public String mControllerId;
    public final ImageOriginListener mImageOriginLister;

    public ImageOriginRequestListener(String str, ImageOriginListener imageOriginListener) {
        this.mImageOriginLister = imageOriginListener;
        this.mControllerId = str;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onUltimateProducerReached(String str, String str2, boolean z) {
        char c;
        ImageOriginListener imageOriginListener = this.mImageOriginLister;
        if (imageOriginListener != null) {
            String str3 = this.mControllerId;
            int i = 1;
            switch (str2.hashCode()) {
                case -1917159454:
                    if (str2.equals("QualifiedResourceFetchProducer")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1914072202:
                    if (str2.equals("BitmapMemoryCacheGetProducer")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1683996557:
                    if (str2.equals("LocalResourceFetchProducer")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1579985851:
                    if (str2.equals("LocalFileFetchProducer")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1307634203:
                    if (str2.equals("EncodedMemoryCacheProducer")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1224383234:
                    if (str2.equals("NetworkFetchProducer")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 473552259:
                    if (str2.equals("VideoThumbnailProducer")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 656304759:
                    if (str2.equals("DiskCacheProducer")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 957714404:
                    if (str2.equals("BitmapMemoryCacheProducer")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1019542023:
                    if (str2.equals("LocalAssetFetchProducer")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1023071510:
                    if (str2.equals("PostprocessedBitmapMemoryCacheProducer")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1721672898:
                    if (str2.equals("DataFetchProducer")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1793127518:
                    if (str2.equals("LocalContentUriThumbnailFetchProducer")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 2109593398:
                    if (str2.equals("PartialDiskCacheProducer")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2113652014:
                    if (str2.equals("LocalContentUriFetchProducer")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    i = 5;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                case 5:
                    i = 3;
                    break;
                case 6:
                    i = 2;
                    break;
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    i = 6;
                    break;
            }
            imageOriginListener.onImageLoaded(str3, i, z, str2);
        }
    }
}
