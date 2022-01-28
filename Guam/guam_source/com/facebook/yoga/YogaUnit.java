package com.facebook.yoga;

public enum YogaUnit {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    
    public final int mIntValue;

    /* access modifiers changed from: public */
    YogaUnit(int i) {
        this.mIntValue = i;
    }
}
