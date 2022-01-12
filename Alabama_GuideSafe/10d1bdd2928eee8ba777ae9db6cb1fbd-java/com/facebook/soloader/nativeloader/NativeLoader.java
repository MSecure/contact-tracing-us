package com.facebook.soloader.nativeloader;

import com.facebook.soloader.NativeLoaderToSoLoaderDelegate;
import com.facebook.soloader.SoLoader;

public class NativeLoader {
    public static NativeLoaderToSoLoaderDelegate sDelegate;

    public static boolean loadLibrary(String str) {
        synchronized (NativeLoader.class) {
            if (sDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        if (sDelegate != null) {
            return SoLoader.loadLibrary(str, 0);
        }
        throw null;
    }
}
