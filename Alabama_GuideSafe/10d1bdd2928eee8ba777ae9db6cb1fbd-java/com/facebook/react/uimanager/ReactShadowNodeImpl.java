package com.facebook.react.uimanager;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.yoga.YogaConfigJNIBase;
import com.facebook.yoga.YogaConfigJNIFinalizer;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeJNIBase;
import com.facebook.yoga.YogaNodeJNIFinalizer;
import com.facebook.yoga.YogaValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    public static final YogaConfigJNIBase sYogaConfig = ReactYogaConfigProvider.YOGA_CONFIG;
    public ArrayList<ReactShadowNodeImpl> mChildren;
    public final Spacing mDefaultPadding = new Spacing(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    public Integer mHeightMeasureSpec;
    public boolean mIsLayoutOnly;
    public ReactShadowNodeImpl mLayoutParent;
    public ArrayList<ReactShadowNodeImpl> mNativeChildren;
    public ReactShadowNodeImpl mNativeParent;
    public boolean mNodeUpdated = true;
    public final float[] mPadding = new float[9];
    public final boolean[] mPaddingIsPercent = new boolean[9];
    public ReactShadowNodeImpl mParent;
    public int mReactTag;
    public int mRootTag;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mScreenX;
    public int mScreenY;
    public boolean mShouldNotifyOnLayout;
    public ThemedReactContext mThemedContext;
    public int mTotalNativeChildren = 0;
    public String mViewClassName;
    public Integer mWidthMeasureSpec;
    public YogaNode mYogaNode;

    static {
        if (ReactYogaConfigProvider.YOGA_CONFIG == null) {
            YogaConfigJNIFinalizer yogaConfigJNIFinalizer = new YogaConfigJNIFinalizer();
            ReactYogaConfigProvider.YOGA_CONFIG = yogaConfigJNIFinalizer;
            YogaNative.jni_YGConfigSetPointScaleFactorJNI(yogaConfigJNIFinalizer.mNativePointer, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
            YogaNative.jni_YGConfigSetUseLegacyStretchBehaviourJNI(ReactYogaConfigProvider.YOGA_CONFIG.mNativePointer, true);
        }
    }

    public ReactShadowNodeImpl() {
        if (!isVirtual()) {
            YogaNode acquire = YogaNodePool.get().acquire();
            acquire = acquire == null ? new YogaNodeJNIFinalizer(sYogaConfig) : acquire;
            this.mYogaNode = acquire;
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) acquire;
            Arrays.fill(this.mPadding, Float.NaN);
            return;
        }
        this.mYogaNode = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode, int] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void addNativeChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        ReactShadowNodeImpl reactShadowNodeImpl2 = reactShadowNodeImpl;
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(getNativeKind() == NativeKind.PARENT);
        if (reactShadowNodeImpl2.getNativeKind() == NativeKind.NONE) {
            z = false;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(z);
        if (this.mNativeChildren == null) {
            this.mNativeChildren = new ArrayList<>(4);
        }
        this.mNativeChildren.add(i, reactShadowNodeImpl2);
        reactShadowNodeImpl2.mNativeParent = this;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void calculateLayout() {
        calculateLayout(Float.NaN, Float.NaN);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (isVirtualAnchor()) {
            return null;
        }
        return this.mChildren;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void dirty() {
        if (!isVirtual()) {
            YogaNative.jni_YGNodeMarkDirtyJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
            return;
        }
        ReactShadowNodeImpl reactShadowNodeImpl = this.mParent;
        if (reactShadowNodeImpl != null) {
            reactShadowNodeImpl.dirty();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean dispatchUpdates(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNodeUpdated) {
            onCollectExtraUpdates(uIViewOperationQueue);
        }
        if (!hasNewLayout()) {
            return false;
        }
        float layoutX = getLayoutX();
        float layoutY = getLayoutY();
        float f3 = f + layoutX;
        int round = Math.round(f3);
        float f4 = f2 + layoutY;
        int round2 = Math.round(f4);
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        boolean z = true;
        float f5 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        int round3 = Math.round(f3 + (fArr != null ? fArr[1] : 0.0f));
        float[] fArr2 = ((YogaNodeJNIBase) this.mYogaNode).arr;
        if (fArr2 != null) {
            f5 = fArr2[2];
        }
        int round4 = Math.round(f4 + f5);
        int round5 = Math.round(layoutX);
        int round6 = Math.round(layoutY);
        int i = round3 - round;
        int i2 = round4 - round2;
        if (round5 == this.mScreenX && round6 == this.mScreenY && i == this.mScreenWidth && i2 == this.mScreenHeight) {
            z = false;
        }
        this.mScreenX = round5;
        this.mScreenY = round6;
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        if (z) {
            if (nativeViewHierarchyOptimizer != null) {
                nativeViewHierarchyOptimizer.applyLayoutBase(this);
            } else {
                uIViewOperationQueue.enqueueUpdateLayout(this.mParent.mReactTag, this.mReactTag, round5, round6, i, i2);
            }
        }
        return z;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void dispose() {
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            yogaNodeJNIBase.mMeasureFunction = null;
            yogaNodeJNIBase.mBaselineFunction = null;
            yogaNodeJNIBase.arr = null;
            yogaNodeJNIBase.mHasNewLayout = true;
            yogaNodeJNIBase.mLayoutDirection = 0;
            YogaNative.jni_YGNodeResetJNI(yogaNodeJNIBase.mNativePointer);
            YogaNodePool.get().release(this.mYogaNode);
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Integer getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutHeight() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        return fArr != null ? fArr[2] : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    /* Return type fixed from 'com.facebook.react.uimanager.ReactShadowNode' to match base method */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl getLayoutParent() {
        ReactShadowNodeImpl reactShadowNodeImpl = this.mLayoutParent;
        return reactShadowNodeImpl != null ? reactShadowNodeImpl : this.mNativeParent;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutWidth() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        return fArr != null ? fArr[1] : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutX() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        return fArr != null ? fArr[3] : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final float getLayoutY() {
        float[] fArr = ((YogaNodeJNIBase) this.mYogaNode).arr;
        return fArr != null ? fArr[4] : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getNativeChildCount() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public NativeKind getNativeKind() {
        if (isVirtual() || this.mIsLayoutOnly) {
            return NativeKind.NONE;
        }
        return hoistNativeChildren() ? NativeKind.LEAF : NativeKind.PARENT;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getNativeOffsetForChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        ReactShadowNodeImpl reactShadowNodeImpl2 = reactShadowNodeImpl;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= getChildCount()) {
                break;
            }
            ReactShadowNodeImpl childAt = getChildAt(i);
            if (reactShadowNodeImpl2 == childAt) {
                z = true;
                break;
            }
            i2 += childAt.getTotalNativeNodeContributionToParent();
            i++;
        }
        if (z) {
            return i2;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Child ");
        outline17.append(reactShadowNodeImpl2.mReactTag);
        outline17.append(" was not a child of ");
        outline17.append(this.mReactTag);
        throw new RuntimeException(outline17.toString());
    }

    /* Return type fixed from 'com.facebook.react.uimanager.ReactShadowNode' to match base method */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl getNativeParent() {
        return this.mNativeParent;
    }

    public final float getPadding(int i) {
        YogaNode yogaNode = this.mYogaNode;
        YogaEdge fromInt = YogaEdge.fromInt(i);
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
        YogaDirection yogaDirection = YogaDirection.RTL;
        float[] fArr = yogaNodeJNIBase.arr;
        if (fArr != null) {
            int i2 = 0;
            if ((((int) fArr[0]) & 2) == 2) {
                if ((((int) fArr[0]) & 1) != 1) {
                    i2 = 4;
                }
                int i3 = 10 - i2;
                int ordinal = fromInt.ordinal();
                if (ordinal == 0) {
                    return yogaNodeJNIBase.arr[i3];
                }
                if (ordinal == 1) {
                    return yogaNodeJNIBase.arr[i3 + 1];
                }
                if (ordinal == 2) {
                    return yogaNodeJNIBase.arr[i3 + 2];
                }
                if (ordinal == 3) {
                    return yogaNodeJNIBase.arr[i3 + 3];
                }
                if (ordinal == 4) {
                    return yogaNodeJNIBase.getLayoutDirection() == yogaDirection ? yogaNodeJNIBase.arr[i3 + 2] : yogaNodeJNIBase.arr[i3];
                }
                if (ordinal == 5) {
                    return yogaNodeJNIBase.getLayoutDirection() == yogaDirection ? yogaNodeJNIBase.arr[i3] : yogaNodeJNIBase.arr[i3 + 2];
                }
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
            }
        }
        return BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    }

    /* Return type fixed from 'com.facebook.react.uimanager.ReactShadowNode' to match base method */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl getParent() {
        return this.mParent;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getReactTag() {
        return this.mReactTag;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final int getRootTag() {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mRootTag != 0);
        return this.mRootTag;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenX() {
        return this.mScreenX;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int getScreenY() {
        return this.mScreenY;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaValue getStyleHeight() {
        long jni_YGNodeStyleGetHeightJNI = YogaNative.jni_YGNodeStyleGetHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
        return new YogaValue(Float.intBitsToFloat((int) jni_YGNodeStyleGetHeightJNI), (int) (jni_YGNodeStyleGetHeightJNI >> 32));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final YogaValue getStyleWidth() {
        long jni_YGNodeStyleGetWidthJNI = YogaNative.jni_YGNodeStyleGetWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer);
        return new YogaValue(Float.intBitsToFloat((int) jni_YGNodeStyleGetWidthJNI), (int) (jni_YGNodeStyleGetWidthJNI >> 32));
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ThemedReactContext getThemedContext() {
        ThemedReactContext themedReactContext = this.mThemedContext;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(themedReactContext);
        return themedReactContext;
    }

    public final int getTotalNativeNodeContributionToParent() {
        NativeKind nativeKind = getNativeKind();
        if (nativeKind == NativeKind.NONE) {
            return this.mTotalNativeChildren;
        }
        if (nativeKind == NativeKind.LEAF) {
            return 1 + this.mTotalNativeChildren;
        }
        return 1;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final String getViewClass() {
        String str = this.mViewClassName;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        return str;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public Integer getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public final boolean hasNewLayout() {
        boolean z;
        YogaNode yogaNode = this.mYogaNode;
        if (yogaNode != null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            float[] fArr = yogaNodeJNIBase.arr;
            if (fArr != null) {
                z = (((int) fArr[0]) & 16) == 16;
            } else {
                z = yogaNodeJNIBase.mHasNewLayout;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean hasUpdates() {
        if (!this.mNodeUpdated && !hasNewLayout()) {
            YogaNode yogaNode = this.mYogaNode;
            if (!(yogaNode != null && YogaNative.jni_YGNodeIsDirtyJNI(((YogaNodeJNIBase) yogaNode).mNativePointer))) {
                return false;
            }
        }
        return true;
    }

    public boolean hoistNativeChildren() {
        return false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int indexOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        ReactShadowNodeImpl reactShadowNodeImpl2 = reactShadowNodeImpl;
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(reactShadowNodeImpl2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public int indexOfNativeChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mNativeChildren);
        return this.mNativeChildren.indexOf(reactShadowNodeImpl);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isDescendantOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        ReactShadowNodeImpl reactShadowNodeImpl2 = reactShadowNodeImpl;
        for (ReactShadowNodeImpl reactShadowNodeImpl3 = this.mParent; reactShadowNodeImpl3 != null; reactShadowNodeImpl3 = reactShadowNodeImpl3.mParent) {
            if (reactShadowNodeImpl3 == reactShadowNodeImpl2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean isLayoutOnly() {
        return this.mIsLayoutOnly;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public boolean isYogaLeafNode() {
        return ((YogaNodeJNIBase) this.mYogaNode).mMeasureFunction != null;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void markUpdateSeen() {
        YogaNode yogaNode;
        this.mNodeUpdated = false;
        if (hasNewLayout() && (yogaNode = this.mYogaNode) != null) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) yogaNode;
            float[] fArr = yogaNodeJNIBase.arr;
            if (fArr != null) {
                fArr[0] = (float) (((int) fArr[0]) & -17);
            }
            yogaNodeJNIBase.mHasNewLayout = false;
        }
    }

    public void markUpdated() {
        if (!this.mNodeUpdated) {
            this.mNodeUpdated = true;
            ReactShadowNodeImpl reactShadowNodeImpl = this.mParent;
            if (reactShadowNodeImpl != null) {
                reactShadowNodeImpl.markUpdated();
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void removeAllNativeChildren() {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mNativeChildren;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mNativeChildren.get(size).mNativeParent = null;
            }
            this.mNativeChildren.clear();
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void removeAndDisposeAllChildren() {
        if (getChildCount() != 0) {
            int i = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (this.mYogaNode != null && !isYogaLeafNode()) {
                    this.mYogaNode.removeChildAt(childCount);
                }
                ReactShadowNodeImpl childAt = getChildAt(childCount);
                childAt.mParent = null;
                i += childAt.getTotalNativeNodeContributionToParent();
                childAt.dispose();
            }
            ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(arrayList);
            arrayList.clear();
            markUpdated();
            this.mTotalNativeChildren -= i;
            updateNativeChildrenCountInParent(-i);
        }
    }

    /* Return type fixed from 'com.facebook.react.uimanager.ReactShadowNode' to match base method */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl removeChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            ReactShadowNodeImpl remove = arrayList.remove(i);
            remove.mParent = null;
            if (this.mYogaNode != null && !isYogaLeafNode()) {
                this.mYogaNode.removeChildAt(i);
            }
            markUpdated();
            int totalNativeNodeContributionToParent = remove.getTotalNativeNodeContributionToParent();
            this.mTotalNativeChildren -= totalNativeNodeContributionToParent;
            updateNativeChildrenCountInParent(-totalNativeNodeContributionToParent);
            return remove;
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline6("Index ", i, " out of bounds: node has no children"));
    }

    /* Return type fixed from 'com.facebook.react.uimanager.ReactShadowNode' to match base method */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public ReactShadowNodeImpl removeNativeChildAt(int i) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mNativeChildren);
        ReactShadowNodeImpl remove = this.mNativeChildren.remove(i);
        remove.mNativeParent = null;
        return remove;
    }

    public void setDefaultPadding(int i, float f) {
        this.mDefaultPadding.set(i, f);
        updatePadding();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setIsLayoutOnly(boolean z) {
        boolean z2 = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mParent == null, "Must remove from no opt parent first");
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mNativeParent == null, "Must remove from native parent first");
        if (getNativeChildCount() != 0) {
            z2 = false;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(z2, "Must remove all native children first");
        this.mIsLayoutOnly = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.react.uimanager.ReactShadowNode] */
    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setLayoutParent(ReactShadowNodeImpl reactShadowNodeImpl) {
        this.mLayoutParent = reactShadowNodeImpl;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object obj) {
    }

    public void setMargin(int i, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, YogaEdge.fromInt(i).mIntValue, f);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
        yogaNodeJNIBase.mMeasureFunction = yogaMeasureFunction;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(yogaNodeJNIBase.mNativePointer, yogaMeasureFunction != null);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setMeasureSpecs(int i, int i2) {
        this.mWidthMeasureSpec = Integer.valueOf(i);
        this.mHeightMeasureSpec = Integer.valueOf(i2);
    }

    public void setPadding(int i, float f) {
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setReactTag(int i) {
        this.mReactTag = i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setRootTag(int i) {
        this.mRootTag = i;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleHeight(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setStyleWidth(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(((YogaNodeJNIBase) this.mYogaNode).mNativePointer, f);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void setViewClassName(String str) {
        this.mViewClassName = str;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnLayout;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("[");
        outline17.append(this.mViewClassName);
        outline17.append(" ");
        return GeneratedOutlineSupport.outline13(outline17, this.mReactTag, "]");
    }

    public final void updateNativeChildrenCountInParent(int i) {
        NativeKind nativeKind = NativeKind.PARENT;
        if (getNativeKind() != nativeKind) {
            for (ReactShadowNodeImpl reactShadowNodeImpl = this.mParent; reactShadowNodeImpl != null; reactShadowNodeImpl = reactShadowNodeImpl.mParent) {
                reactShadowNodeImpl.mTotalNativeChildren += i;
                if (reactShadowNodeImpl.getNativeKind() == nativeKind) {
                    return;
                }
            }
        }
    }

    public final void updatePadding() {
        for (int i = 0; i <= 8; i++) {
            if (i == 0 || i == 2 || i == 4 || i == 5) {
                if (ReactYogaConfigProvider.isUndefined(this.mPadding[i]) && ReactYogaConfigProvider.isUndefined(this.mPadding[6]) && ReactYogaConfigProvider.isUndefined(this.mPadding[8])) {
                    YogaNode yogaNode = this.mYogaNode;
                    YogaEdge fromInt = YogaEdge.fromInt(i);
                    YogaNative.jni_YGNodeStyleSetPaddingJNI(((YogaNodeJNIBase) yogaNode).mNativePointer, fromInt.mIntValue, this.mDefaultPadding.mSpacing[i]);
                }
            } else if (i == 1 || i == 3) {
                if (ReactYogaConfigProvider.isUndefined(this.mPadding[i]) && ReactYogaConfigProvider.isUndefined(this.mPadding[7]) && ReactYogaConfigProvider.isUndefined(this.mPadding[8])) {
                    YogaNode yogaNode2 = this.mYogaNode;
                    YogaEdge fromInt2 = YogaEdge.fromInt(i);
                    YogaNative.jni_YGNodeStyleSetPaddingJNI(((YogaNodeJNIBase) yogaNode2).mNativePointer, fromInt2.mIntValue, this.mDefaultPadding.mSpacing[i]);
                }
            } else if (ReactYogaConfigProvider.isUndefined(this.mPadding[i])) {
                YogaNode yogaNode3 = this.mYogaNode;
                YogaEdge fromInt3 = YogaEdge.fromInt(i);
                YogaNative.jni_YGNodeStyleSetPaddingJNI(((YogaNodeJNIBase) yogaNode3).mNativePointer, fromInt3.mIntValue, this.mDefaultPadding.mSpacing[i]);
            }
            if (this.mPaddingIsPercent[i]) {
                YogaNode yogaNode4 = this.mYogaNode;
                YogaEdge fromInt4 = YogaEdge.fromInt(i);
                YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(((YogaNodeJNIBase) yogaNode4).mNativePointer, fromInt4.mIntValue, this.mPadding[i]);
            } else {
                YogaNode yogaNode5 = this.mYogaNode;
                YogaEdge fromInt5 = YogaEdge.fromInt(i);
                YogaNative.jni_YGNodeStyleSetPaddingJNI(((YogaNodeJNIBase) yogaNode5).mNativePointer, fromInt5.mIntValue, this.mPadding[i]);
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final void updateProperties(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, reactStylesDiffMap);
    }

    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList<>(4);
        }
        this.mChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
        if (this.mYogaNode != null && !isYogaLeafNode()) {
            YogaNode yogaNode = reactShadowNodeImpl.mYogaNode;
            if (yogaNode != null) {
                YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
                if (yogaNodeJNIBase != null) {
                    YogaNodeJNIBase yogaNodeJNIBase2 = (YogaNodeJNIBase) yogaNode;
                    if (yogaNodeJNIBase2.mOwner == null) {
                        if (yogaNodeJNIBase.mChildren == null) {
                            yogaNodeJNIBase.mChildren = new ArrayList(4);
                        }
                        yogaNodeJNIBase.mChildren.add(i, yogaNodeJNIBase2);
                        yogaNodeJNIBase2.mOwner = yogaNodeJNIBase;
                        YogaNative.jni_YGNodeInsertChildJNI(yogaNodeJNIBase.mNativePointer, yogaNodeJNIBase2.mNativePointer, i);
                    } else {
                        throw new IllegalStateException("Child already has a parent, it must be removed first.");
                    }
                } else {
                    throw null;
                }
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '");
                outline17.append(reactShadowNodeImpl.toString());
                outline17.append("' to a '");
                outline17.append(toString());
                outline17.append("')");
                throw new RuntimeException(outline17.toString());
            }
        }
        markUpdated();
        int totalNativeNodeContributionToParent = reactShadowNodeImpl.getTotalNativeNodeContributionToParent();
        this.mTotalNativeChildren += totalNativeNodeContributionToParent;
        updateNativeChildrenCountInParent(totalNativeNodeContributionToParent);
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public void calculateLayout(float f, float f2) {
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) this.mYogaNode;
        if (yogaNodeJNIBase != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(yogaNodeJNIBase);
            for (int i = 0; i < arrayList.size(); i++) {
                List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).mChildren;
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
            YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
            long[] jArr = new long[yogaNodeJNIBaseArr.length];
            for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
                jArr[i2] = yogaNodeJNIBaseArr[i2].mNativePointer;
            }
            YogaNative.jni_YGNodeCalculateLayoutJNI(yogaNodeJNIBase.mNativePointer, f, f2, jArr, yogaNodeJNIBaseArr);
            return;
        }
        throw null;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNode
    public final ReactShadowNodeImpl getChildAt(int i) {
        ArrayList<ReactShadowNodeImpl> arrayList = this.mChildren;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        throw new ArrayIndexOutOfBoundsException(GeneratedOutlineSupport.outline6("Index ", i, " out of bounds: node has no children"));
    }
}
