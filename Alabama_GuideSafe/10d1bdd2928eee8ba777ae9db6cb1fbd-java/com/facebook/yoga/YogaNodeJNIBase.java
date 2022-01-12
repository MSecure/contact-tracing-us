package com.facebook.yoga;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;

@DoNotStrip
public abstract class YogaNodeJNIBase extends YogaNode implements Cloneable {
    @DoNotStrip
    public float[] arr;
    public YogaBaselineFunction mBaselineFunction;
    public List<YogaNodeJNIBase> mChildren;
    public boolean mHasNewLayout;
    @DoNotStrip
    public int mLayoutDirection;
    public YogaMeasureFunction mMeasureFunction;
    public long mNativePointer;
    public YogaNodeJNIBase mOwner;

    public YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j != 0) {
            this.mNativePointer = j;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    @DoNotStrip
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            list.remove(i);
            this.mChildren.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            return yogaNodeJNIBase.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    @DoNotStrip
    public final float baseline(float f, float f2) {
        return this.mBaselineFunction.baseline(this, f, f2);
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaDirection getLayoutDirection() {
        float[] fArr = this.arr;
        int i = fArr != null ? (int) fArr[5] : this.mLayoutDirection;
        if (i == 0) {
            return YogaDirection.INHERIT;
        }
        if (i == 1) {
            return YogaDirection.LTR;
        }
        if (i == 2) {
            return YogaDirection.RTL;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("Unknown enum value: ", i));
    }

    @DoNotStrip
    public final long measure(float f, int i, float f2, int i2) {
        if (this.mMeasureFunction != null) {
            return this.mMeasureFunction.measure(this, f, YogaMeasureMode.fromInt(i), f2, YogaMeasureMode.fromInt(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.facebook.yoga.YogaNode
    public YogaNode removeChildAt(int i) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i);
            remove.mOwner = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }
}
