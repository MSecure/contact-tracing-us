package com.getkeepsafe.relinker;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class MissingLibraryException extends RuntimeException {
    /* JADX WARNING: Illegal instructions before constructor call */
    public MissingLibraryException(String str, String[] strArr, String[] strArr2) {
        super(GeneratedOutlineSupport.outline14(r3, Arrays.toString(strArr2), "."));
        StringBuilder outline20 = GeneratedOutlineSupport.outline20("Could not find '", str, "'. Looked for: ");
        outline20.append(Arrays.toString(strArr));
        outline20.append(", but only found: ");
    }
}
