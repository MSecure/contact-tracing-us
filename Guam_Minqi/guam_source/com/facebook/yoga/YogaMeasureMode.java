package com.facebook.yoga;

import com.android.tools.r8.GeneratedOutlineSupport;

public enum YogaMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    /* access modifiers changed from: public */
    YogaMeasureMode(int i) {
    }

    public static YogaMeasureMode fromInt(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("Unknown enum value: ", i));
    }
}
