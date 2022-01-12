package com.facebook.react.uimanager;

import androidx.appcompat.app.AppCompatDelegateImpl;

public class Spacing {
    public static final int[] sFlagsMap = {1, 2, 4, 8, 16, 32, 64, 128, 256};
    public final float mDefaultValue;
    public boolean mHasAliasesSet;
    public final float[] mSpacing;
    public int mValueFlags = 0;

    public Spacing(float f) {
        this.mDefaultValue = f;
        this.mSpacing = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }

    public float get(int i) {
        float f = (i == 4 || i == 5) ? Float.NaN : this.mDefaultValue;
        int i2 = this.mValueFlags;
        if (i2 == 0) {
            return f;
        }
        if ((i2 & sFlagsMap[i]) != 0) {
            return this.mSpacing[i];
        }
        if (this.mHasAliasesSet) {
            char c = (i == 1 || i == 3) ? (char) 7 : 6;
            int i3 = this.mValueFlags;
            int[] iArr = sFlagsMap;
            if ((iArr[c] & i3) != 0) {
                return this.mSpacing[c];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.mSpacing[8];
            }
        }
        return f;
    }

    public boolean set(int i, float f) {
        boolean z = false;
        if (AppCompatDelegateImpl.ConfigurationImplApi17.floatsEqual(this.mSpacing[i], f)) {
            return false;
        }
        this.mSpacing[i] = f;
        if (ReactYogaConfigProvider.isUndefined(f)) {
            this.mValueFlags = (~sFlagsMap[i]) & this.mValueFlags;
        } else {
            this.mValueFlags = sFlagsMap[i] | this.mValueFlags;
        }
        int i2 = this.mValueFlags;
        int[] iArr = sFlagsMap;
        if (!((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (i2 & iArr[6]) == 0)) {
            z = true;
        }
        this.mHasAliasesSet = z;
        return true;
    }
}
