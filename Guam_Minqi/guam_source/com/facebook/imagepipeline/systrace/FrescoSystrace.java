package com.facebook.imagepipeline.systrace;

public class FrescoSystrace {
    public static volatile Systrace sInstance;

    public interface Systrace {
    }

    public static Systrace getInstance() {
        if (sInstance == null) {
            synchronized (FrescoSystrace.class) {
                if (sInstance == null) {
                    sInstance = new DefaultFrescoSystrace();
                }
            }
        }
        return sInstance;
    }

    public static boolean isTracing() {
        if (((DefaultFrescoSystrace) getInstance()) != null) {
            return false;
        }
        throw null;
    }
}
