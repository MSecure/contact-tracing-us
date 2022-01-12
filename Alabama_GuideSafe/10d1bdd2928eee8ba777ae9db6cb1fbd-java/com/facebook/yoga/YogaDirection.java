package com.facebook.yoga;

public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    public final int mIntValue;

    /* access modifiers changed from: public */
    YogaDirection(int i) {
        this.mIntValue = i;
    }
}
