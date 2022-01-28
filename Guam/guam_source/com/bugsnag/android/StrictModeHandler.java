package com.bugsnag.android;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

public class StrictModeHandler {
    @SuppressLint({"UseSparseArrays"})
    public static final Map<Integer, String> POLICY_CODE_MAP;

    static {
        HashMap hashMap = new HashMap();
        POLICY_CODE_MAP = hashMap;
        hashMap.put(1, "DiskWrite");
        POLICY_CODE_MAP.put(2, "DiskRead");
        POLICY_CODE_MAP.put(4, "NetworkOperation");
        POLICY_CODE_MAP.put(8, "CustomSlowCall");
        POLICY_CODE_MAP.put(16, "ResourceMismatch");
        POLICY_CODE_MAP.put(256, "CursorLeak");
        POLICY_CODE_MAP.put(512, "CloseableLeak");
        POLICY_CODE_MAP.put(1024, "ActivityLeak");
        POLICY_CODE_MAP.put(2048, "InstanceLeak");
        POLICY_CODE_MAP.put(4096, "RegistrationLeak");
        POLICY_CODE_MAP.put(8192, "FileUriLeak");
        POLICY_CODE_MAP.put(16384, "CleartextNetwork");
    }

    public final Throwable getRootCause(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null) {
            return th;
        }
        return getRootCause(cause);
    }
}
