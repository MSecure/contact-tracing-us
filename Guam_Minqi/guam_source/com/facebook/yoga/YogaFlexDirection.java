package com.facebook.yoga;

public enum YogaFlexDirection {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);
    
    public final int mIntValue;

    /* access modifiers changed from: public */
    YogaFlexDirection(int i) {
        this.mIntValue = i;
    }
}
