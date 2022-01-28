package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.os.Trace;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.systrace.SystraceMessage;
import java.util.Arrays;

public class UIImplementation {
    public final EventDispatcher mEventDispatcher;
    public long mLastCalculateLayoutTime;
    public final int[] mMeasureBuffer;
    public final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
    public final UIViewOperationQueue mOperationsQueue;
    public final ReactApplicationContext mReactContext;
    public final ShadowNodeRegistry mShadowNodeRegistry;
    public final ViewManagerRegistry mViewManagers;
    public Object uiImplementationThreadLock = new Object();

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        UIViewOperationQueue uIViewOperationQueue = new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i);
        ShadowNodeRegistry shadowNodeRegistry = new ShadowNodeRegistry();
        this.mShadowNodeRegistry = shadowNodeRegistry;
        this.mMeasureBuffer = new int[4];
        this.mLastCalculateLayoutTime = 0;
        this.mReactContext = reactApplicationContext;
        this.mViewManagers = viewManagerRegistry;
        this.mOperationsQueue = uIViewOperationQueue;
        this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(uIViewOperationQueue, shadowNodeRegistry);
        this.mEventDispatcher = eventDispatcher;
    }

    public void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f, float f2) {
        if (reactShadowNode.hasUpdates()) {
            Iterable<? extends ReactShadowNode> calculateLayoutOnChildren = reactShadowNode.calculateLayoutOnChildren();
            if (calculateLayoutOnChildren != null) {
                for (ReactShadowNode reactShadowNode2 : calculateLayoutOnChildren) {
                    applyUpdatesRecursive(reactShadowNode2, reactShadowNode.getLayoutX() + f, reactShadowNode.getLayoutY() + f2);
                }
            }
            int reactTag = reactShadowNode.getReactTag();
            if (!this.mShadowNodeRegistry.isRootNode(reactTag) && reactShadowNode.dispatchUpdates(f, f2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer) && reactShadowNode.shouldNotifyOnLayout()) {
                this.mEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(reactTag, reactShadowNode.getScreenX(), reactShadowNode.getScreenY(), reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight()));
            }
            reactShadowNode.markUpdateSeen();
        }
    }

    public final void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode reactShadowNode) {
        ViewManager viewManager = this.mViewManagers.get(reactShadowNode.getViewClass());
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(viewManager);
        ViewManager viewManager2 = viewManager;
        if (!(viewManager2 instanceof IViewManagerWithChildren)) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Trying to use view ");
            outline15.append(reactShadowNode.getViewClass());
            outline15.append(" as a parent, but its Manager doesn't extends ViewGroupManager");
            throw new IllegalViewOperationException(outline15.toString());
        } else if (((IViewManagerWithChildren) viewManager2).needsCustomLayoutForChildren()) {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (");
            outline152.append(reactShadowNode.getViewClass());
            outline152.append("). Use measure instead.");
            throw new IllegalViewOperationException(outline152.toString());
        }
    }

    public final void assertViewExists(int i, String str) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (shadowNodeRegistry.mTagsToCSSNodes.get(i) == null) {
            throw new IllegalViewOperationException("Unable to execute operation " + str + " on view with tag: " + i + ", since the view does not exists");
        }
    }

    public void calculateRootLayout(ReactShadowNode reactShadowNode) {
        float f;
        SystraceMessage.Builder builder = SystraceMessage.NOOP_BUILDER;
        reactShadowNode.getReactTag();
        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) builder;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            int intValue = reactShadowNode.getWidthMeasureSpec().intValue();
            int intValue2 = reactShadowNode.getHeightMeasureSpec().intValue();
            float f2 = Float.NaN;
            if (View.MeasureSpec.getMode(intValue) == 0) {
                f = Float.NaN;
            } else {
                f = (float) View.MeasureSpec.getSize(intValue);
            }
            if (View.MeasureSpec.getMode(intValue2) != 0) {
                f2 = (float) View.MeasureSpec.getSize(intValue2);
            }
            reactShadowNode.calculateLayout(f, f2);
        } finally {
            Trace.endSection();
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    public void dispatchViewUpdates(int i) {
        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            updateViewHierarchy();
            this.mNativeViewHierarchyOptimizer.mTagsWithLayoutVisited.clear();
            this.mOperationsQueue.dispatchViewUpdates(i, uptimeMillis, this.mLastCalculateLayoutTime);
        } finally {
            Trace.endSection();
        }
    }

    public final void dispatchViewUpdatesIfNeeded() {
        UIViewOperationQueue uIViewOperationQueue = this.mOperationsQueue;
        if (uIViewOperationQueue.mOperations.isEmpty() && uIViewOperationQueue.mViewCommandOperations.isEmpty()) {
            dispatchViewUpdates(-1);
        }
    }

    public void handleCreateView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.isVirtual()) {
            NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = this.mNativeViewHierarchyOptimizer;
            ThemedReactContext themedContext = reactShadowNode.getThemedContext();
            if (nativeViewHierarchyOptimizer != null) {
                reactShadowNode.setIsLayoutOnly(reactShadowNode.getViewClass().equals(ReactViewManager.REACT_CLASS) && NativeViewHierarchyOptimizer.isLayoutOnlyAndCollapsable(reactStylesDiffMap));
                if (reactShadowNode.getNativeKind() != NativeKind.NONE) {
                    nativeViewHierarchyOptimizer.mUIViewOperationQueue.enqueueCreateView(themedContext, reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        Throwable th;
        int i2;
        int i3;
        int i4;
        ReadableArray readableArray6 = readableArray;
        synchronized (this.uiImplementationThreadLock) {
            try {
                ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                if (readableArray6 == null) {
                    i2 = 0;
                } else {
                    i2 = readableArray.size();
                }
                if (readableArray3 == null) {
                    i3 = 0;
                } else {
                    i3 = readableArray3.size();
                }
                if (readableArray5 == null) {
                    i4 = 0;
                } else {
                    i4 = readableArray5.size();
                }
                if (i2 != 0) {
                    if (readableArray2 == null || i2 != readableArray2.size()) {
                        throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
                    }
                }
                if (i3 != 0) {
                    if (readableArray4 == null || i3 != readableArray4.size()) {
                        throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
                    }
                }
                int i5 = i2 + i3;
                ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[i5];
                int i6 = i2 + i4;
                int[] iArr = new int[i6];
                try {
                    int[] iArr2 = new int[i6];
                    int[] iArr3 = new int[i4];
                    if (i2 > 0) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray);
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray2);
                        int i7 = 0;
                        while (i7 < i2) {
                            int i8 = readableArray6.getInt(i7);
                            int reactTag = reactShadowNode.getChildAt(i8).getReactTag();
                            viewAtIndexArr[i7] = new ViewAtIndex(reactTag, readableArray2.getInt(i7));
                            iArr[i7] = i8;
                            iArr2[i7] = reactTag;
                            i7++;
                            readableArray6 = readableArray;
                            i6 = i6;
                            iArr3 = iArr3;
                            reactShadowNode = reactShadowNode;
                        }
                    }
                    ReactShadowNode reactShadowNode2 = reactShadowNode;
                    if (i3 > 0) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray3);
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray4);
                        for (int i9 = 0; i9 < i3; i9++) {
                            viewAtIndexArr[i2 + i9] = new ViewAtIndex(readableArray3.getInt(i9), readableArray4.getInt(i9));
                        }
                    }
                    if (i4 > 0) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray5);
                        int i10 = 0;
                        while (i10 < i4) {
                            int i11 = readableArray5.getInt(i10);
                            int reactTag2 = reactShadowNode2.getChildAt(i11).getReactTag();
                            int i12 = i2 + i10;
                            iArr[i12] = i11;
                            iArr2[i12] = reactTag2;
                            iArr3[i10] = reactTag2;
                            i10++;
                            reactShadowNode2 = reactShadowNode2;
                        }
                    }
                    Arrays.sort(viewAtIndexArr, ViewAtIndex.COMPARATOR);
                    Arrays.sort(iArr);
                    int i13 = -1;
                    for (int i14 = i6 - 1; i14 >= 0; i14--) {
                        if (iArr[i14] != i13) {
                            reactShadowNode2.removeChildAt(iArr[i14]);
                            i13 = iArr[i14];
                        } else {
                            throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i);
                        }
                    }
                    int i15 = 0;
                    for (int i16 = i5; i15 < i16; i16 = i16) {
                        ViewAtIndex viewAtIndex = viewAtIndexArr[i15];
                        ReactShadowNode node = this.mShadowNodeRegistry.getNode(viewAtIndex.mTag);
                        if (node != null) {
                            reactShadowNode2.addChildAt(node, viewAtIndex.mIndex);
                            i15++;
                            iArr2 = iArr2;
                        } else {
                            throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag);
                        }
                    }
                    this.mNativeViewHierarchyOptimizer.handleManageChildren(reactShadowNode2, iArr2, viewAtIndexArr, iArr3);
                    for (int i17 = 0; i17 < i4; i17++) {
                        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(iArr3[i17]);
                        removeShadowNodeRecursive(node2);
                        node2.dispose();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public final void measureLayout(int i, int i2, int[] iArr) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        ShadowNodeRegistry shadowNodeRegistry2 = this.mShadowNodeRegistry;
        shadowNodeRegistry2.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode2 = shadowNodeRegistry2.mTagsToCSSNodes.get(i2);
        if (reactShadowNode == null || reactShadowNode2 == null) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Tag ");
            if (reactShadowNode != null) {
                i = i2;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline11(outline15, i, " does not exist"));
        }
        if (reactShadowNode != reactShadowNode2) {
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                if (parent == null) {
                    throw new IllegalViewOperationException("Tag " + i2 + " is not an ancestor of tag " + i);
                }
            }
        }
        measureLayoutRelativeToVerifiedAncestor(reactShadowNode, reactShadowNode2, iArr);
    }

    public final void measureLayoutRelativeToParent(int i, int[] iArr) {
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        shadowNodeRegistry.mThreadAsserter.assertNow();
        ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
        if (reactShadowNode != null) {
            ReactShadowNode parent = reactShadowNode.getParent();
            if (parent != null) {
                measureLayoutRelativeToVerifiedAncestor(reactShadowNode, parent, iArr);
                return;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("View with tag ", i, " doesn't have a parent!"));
        }
        throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("No native view for tag ", i, " exists!"));
    }

    public final void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int i;
        int i2;
        if (reactShadowNode != reactShadowNode2) {
            i2 = Math.round(reactShadowNode.getLayoutX());
            i = Math.round(reactShadowNode.getLayoutY());
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(parent);
                assertNodeDoesNotNeedCustomLayoutForChildren(parent);
                i2 += Math.round(parent.getLayoutX());
                i += Math.round(parent.getLayoutY());
            }
            assertNodeDoesNotNeedCustomLayoutForChildren(reactShadowNode2);
        } else {
            i2 = 0;
            i = 0;
        }
        iArr[0] = i2;
        iArr[1] = i;
        iArr[2] = reactShadowNode.getScreenWidth();
        iArr[3] = reactShadowNode.getScreenHeight();
    }

    public final void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i));
            }
            reactShadowNode.onBeforeLayout(this.mNativeViewHierarchyOptimizer);
        }
    }

    public final void removeShadowNodeRecursive(ReactShadowNode reactShadowNode) {
        reactShadowNode.removeAllNativeChildren();
        ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
        int reactTag = reactShadowNode.getReactTag();
        shadowNodeRegistry.mThreadAsserter.assertNow();
        if (!shadowNodeRegistry.mRootTags.get(reactTag)) {
            shadowNodeRegistry.mTagsToCSSNodes.remove(reactTag);
            int childCount = reactShadowNode.getChildCount();
            while (true) {
                childCount--;
                if (childCount >= 0) {
                    removeShadowNodeRecursive(reactShadowNode.getChildAt(childCount));
                } else {
                    reactShadowNode.removeAndDisposeAllChildren();
                    return;
                }
            }
        } else {
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("Trying to remove root node ", reactTag, " without using removeRootNode!"));
        }
    }

    /* JADX INFO: finally extract failed */
    public void updateViewHierarchy() {
        Trace.beginSection("UIImplementation.updateViewHierarchy");
        int i = 0;
        while (true) {
            try {
                ShadowNodeRegistry shadowNodeRegistry = this.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                if (i < shadowNodeRegistry.mRootTags.size()) {
                    ShadowNodeRegistry shadowNodeRegistry2 = this.mShadowNodeRegistry;
                    shadowNodeRegistry2.mThreadAsserter.assertNow();
                    ReactShadowNode node = this.mShadowNodeRegistry.getNode(shadowNodeRegistry2.mRootTags.keyAt(i));
                    if (!(node.getWidthMeasureSpec() == null || node.getHeightMeasureSpec() == null)) {
                        SystraceMessage.Builder builder = SystraceMessage.NOOP_BUILDER;
                        node.getReactTag();
                        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) builder;
                        try {
                            notifyOnBeforeLayoutRecursive(node);
                            Trace.endSection();
                            calculateRootLayout(node);
                            SystraceMessage.Builder builder2 = SystraceMessage.NOOP_BUILDER;
                            node.getReactTag();
                            SystraceMessage.NoopBuilder noopBuilder2 = (SystraceMessage.NoopBuilder) builder2;
                            try {
                                applyUpdatesRecursive(node, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    }
                    i++;
                } else {
                    Trace.endSection();
                    return;
                }
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
    }
}
