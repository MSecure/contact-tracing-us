package com.facebook.yoga;

import com.android.tools.r8.GeneratedOutlineSupport;

public class YogaValue {
    public final YogaUnit unit;
    public final float value;

    public YogaValue(float f, int i) {
        YogaUnit yogaUnit;
        if (i == 0) {
            yogaUnit = YogaUnit.UNDEFINED;
        } else if (i == 1) {
            yogaUnit = YogaUnit.POINT;
        } else if (i == 2) {
            yogaUnit = YogaUnit.PERCENT;
        } else if (i == 3) {
            yogaUnit = YogaUnit.AUTO;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Unknown enum value: ", i));
        }
        this.value = f;
        this.unit = yogaUnit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YogaValue)) {
            return false;
        }
        YogaValue yogaValue = (YogaValue) obj;
        YogaUnit yogaUnit = this.unit;
        if (yogaUnit != yogaValue.unit) {
            return false;
        }
        if (yogaUnit == YogaUnit.UNDEFINED || yogaUnit == YogaUnit.AUTO || Float.compare(this.value, yogaValue.value) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value) + this.unit.mIntValue;
    }

    public String toString() {
        int ordinal = this.unit.ordinal();
        if (ordinal == 0) {
            return "undefined";
        }
        if (ordinal == 1) {
            return Float.toString(this.value);
        }
        if (ordinal == 2) {
            return this.value + "%";
        } else if (ordinal == 3) {
            return "auto";
        } else {
            throw new IllegalStateException();
        }
    }
}
