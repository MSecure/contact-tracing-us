package com.facebook.imagepipeline.nativecode;

import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collections;

public class ImagePipelineNativeLoader {
    static {
        Collections.unmodifiableList(new ArrayList());
    }

    public static void load() {
        SoLoader.loadLibrary("imagepipeline");
    }
}
