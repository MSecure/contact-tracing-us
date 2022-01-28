package com.getkeepsafe.relinker;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class MissingLibraryException extends RuntimeException {
    /* JADX WARNING: Illegal instructions before constructor call */
    public MissingLibraryException(String str, String[] strArr, String[] strArr2) {
        super(GeneratedOutlineSupport.outline12(r3, Arrays.toString(strArr2), "."));
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Could not find '", str, "'. Looked for: ");
        outline17.append(Arrays.toString(strArr));
        outline17.append(", but only found: ");
    }
}
