package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.os.Trace;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationType;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class UIViewOperationQueue {
    public final boolean mAllowViewCommandsQueue;
    public long mCreateViewCount;
    public final Object mDispatchRunnablesLock = new Object();
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    public ArrayList<Runnable> mDispatchUIRunnables = new ArrayList<>();
    public boolean mIsDispatchUIFrameCallbackEnqueued = false;
    public boolean mIsInIllegalUIState = false;
    public boolean mIsProfilingNextBatch = false;
    public final int[] mMeasureBuffer = new int[4];
    public final NativeViewHierarchyManager mNativeViewHierarchyManager;
    public long mNonBatchedExecutionTotalTime;
    public ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque<>();
    public final Object mNonBatchedOperationsLock = new Object();
    public ArrayList<UIOperation> mOperations = new ArrayList<>();
    public long mProfiledBatchBatchedExecutionTime;
    public long mProfiledBatchCommitEndTime;
    public long mProfiledBatchCommitStartTime;
    public long mProfiledBatchDispatchViewUpdatesTime;
    public long mProfiledBatchLayoutTime;
    public long mProfiledBatchNonBatchedExecutionTime;
    public long mProfiledBatchRunEndTime;
    public long mProfiledBatchRunStartTime;
    public final ReactApplicationContext mReactApplicationContext;
    public long mThreadCpuTime;
    public long mUpdatePropertiesOperationCount;
    public ArrayList<DispatchCommandViewOperation> mViewCommandOperations = new ArrayList<>();
    public NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

    public final class ChangeJSResponderOperation extends ViewOperation {
        public final boolean mBlockNativeResponder;
        public final boolean mClearResponder;
        public final int mInitialTag;

        public ChangeJSResponderOperation(int i, int i2, boolean z, boolean z2) {
            super(UIViewOperationQueue.this, i);
            this.mInitialTag = i2;
            this.mClearResponder = z;
            this.mBlockNativeResponder = z2;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            if (!this.mClearResponder) {
                NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                int i = this.mTag;
                int i2 = this.mInitialTag;
                boolean z = this.mBlockNativeResponder;
                synchronized (nativeViewHierarchyManager) {
                    if (!z) {
                        nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, null);
                        return;
                    }
                    View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                    if (i2 == i || !(view instanceof ViewParent)) {
                        if (nativeViewHierarchyManager.mRootTags.get(i)) {
                            SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
                        }
                        nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, view.getParent());
                        return;
                    }
                    nativeViewHierarchyManager.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
                    return;
                }
            }
            JSResponderHandler jSResponderHandler = UIViewOperationQueue.this.mNativeViewHierarchyManager.mJSResponderHandler;
            jSResponderHandler.mCurrentJSResponder = -1;
            ViewParent viewParent = jSResponderHandler.mViewParentBlockingNativeResponder;
            if (viewParent != null) {
                viewParent.requestDisallowInterceptTouchEvent(false);
                jSResponderHandler.mViewParentBlockingNativeResponder = null;
            }
        }
    }

    public class ConfigureLayoutAnimationOperation implements UIOperation {
        public final Callback mAnimationComplete;
        public final ReadableMap mConfig;

        public ConfigureLayoutAnimationOperation(ReadableMap readableMap, Callback callback, AnonymousClass1 r4) {
            this.mConfig = readableMap;
            this.mAnimationComplete = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            ReadableMap readableMap = this.mConfig;
            Callback callback = this.mAnimationComplete;
            LayoutAnimationController layoutAnimationController = nativeViewHierarchyManager.mLayoutAnimator;
            LayoutAnimationType layoutAnimationType = LayoutAnimationType.DELETE;
            LayoutAnimationType layoutAnimationType2 = LayoutAnimationType.UPDATE;
            LayoutAnimationType layoutAnimationType3 = LayoutAnimationType.CREATE;
            if (readableMap == null) {
                layoutAnimationController.reset();
                return;
            }
            int i = 0;
            layoutAnimationController.mShouldAnimateLayout = false;
            if (readableMap.hasKey("duration")) {
                i = readableMap.getInt("duration");
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(layoutAnimationType3))) {
                layoutAnimationController.mLayoutCreateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(layoutAnimationType3)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(layoutAnimationType2))) {
                layoutAnimationController.mLayoutUpdateAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(layoutAnimationType2)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (readableMap.hasKey(LayoutAnimationType.toString(layoutAnimationType))) {
                layoutAnimationController.mLayoutDeleteAnimation.initializeFromConfig(readableMap.getMap(LayoutAnimationType.toString(layoutAnimationType)), i);
                layoutAnimationController.mShouldAnimateLayout = true;
            }
            if (layoutAnimationController.mShouldAnimateLayout && callback != null) {
                layoutAnimationController.mCompletionRunnable = new Runnable(layoutAnimationController, callback) {
                    /* class com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.AnonymousClass1 */
                    public final /* synthetic */ Callback val$completionCallback;

                    {
                        this.val$completionCallback = r2;
                    }

                    public void run() {
                        this.val$completionCallback.invoke(Boolean.TRUE);
                    }
                };
            }
        }
    }

    public final class CreateViewOperation extends ViewOperation {
        public final String mClassName;
        public final ReactStylesDiffMap mInitialProps;
        public final ThemedReactContext mThemedContext;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
            super(UIViewOperationQueue.this, i);
            this.mThemedContext = themedReactContext;
            this.mClassName = str;
            this.mInitialProps = reactStylesDiffMap;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            int i = this.mTag;
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            ThemedReactContext themedReactContext = this.mThemedContext;
            String str = this.mClassName;
            ReactStylesDiffMap reactStylesDiffMap = this.mInitialProps;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
                try {
                    ViewManager viewManager = nativeViewHierarchyManager.mViewManagers.get(str);
                    View createView = viewManager.createView(themedReactContext, null, null, nativeViewHierarchyManager.mJSResponderHandler);
                    nativeViewHierarchyManager.mTagsToViews.put(i, createView);
                    nativeViewHierarchyManager.mTagsToViewManagers.put(i, viewManager);
                    createView.setId(i);
                    if (reactStylesDiffMap != null) {
                        viewManager.updateProperties(createView, reactStylesDiffMap);
                    }
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    public final class DismissPopupMenuOperation implements UIOperation {
        public DismissPopupMenuOperation(AnonymousClass1 r2) {
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            PopupMenu popupMenu = UIViewOperationQueue.this.mNativeViewHierarchyManager.mPopupMenu;
            if (popupMenu != null) {
                popupMenu.dismiss();
            }
        }
    }

    @Deprecated
    public final class DispatchCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        public final ReadableArray mArgs;
        public final int mCommand;
        public int numRetries = 0;

        public DispatchCommandOperation(int i, int i2, ReadableArray readableArray) {
            super(UIViewOperationQueue.this, i);
            this.mCommand = i2;
            this.mArgs = readableArray;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftException.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public int getRetries() {
            return this.numRetries;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public void incrementRetries() {
            this.numRetries++;
        }
    }

    public interface DispatchCommandViewOperation {
        void executeWithExceptions();

        int getRetries();

        void incrementRetries();
    }

    public final class DispatchStringCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        public final ReadableArray mArgs;
        public final String mCommand;
        public int numRetries = 0;

        public DispatchStringCommandOperation(int i, String str, ReadableArray readableArray) {
            super(UIViewOperationQueue.this, i);
            this.mCommand = str;
            this.mArgs = readableArray;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftException.logSoftException("UIViewOperationQueue", new RuntimeException("Error dispatching View Command", th));
            }
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public int getRetries() {
            return this.numRetries;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.DispatchCommandViewOperation
        public void incrementRetries() {
            this.numRetries++;
        }
    }

    public class DispatchUIFrameCallback extends GuardedFrameCallback {
        public final int mMinTimeLeftInFrameForNonBatchedOperationMs;

        public DispatchUIFrameCallback(ReactContext reactContext, int i, AnonymousClass1 r4) {
            super(reactContext);
            this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = android.os.SystemClock.uptimeMillis();
            r1.execute();
            r8.this$0.mNonBatchedExecutionTotalTime = (android.os.SystemClock.uptimeMillis() - r2) + r8.this$0.mNonBatchedExecutionTotalTime;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
            r8.this$0.mIsInIllegalUIState = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
            throw r9;
         */
        public final void dispatchPendingNonBatchedOperations(long j) {
            while (16 - ((System.nanoTime() - j) / 1000000) >= ((long) this.mMinTimeLeftInFrameForNonBatchedOperationMs)) {
                synchronized (UIViewOperationQueue.this.mNonBatchedOperationsLock) {
                    if (!UIViewOperationQueue.this.mNonBatchedOperations.isEmpty()) {
                        UIOperation pollFirst = UIViewOperationQueue.this.mNonBatchedOperations.pollFirst();
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX INFO: finally extract failed */
        @Override // com.facebook.react.uimanager.GuardedFrameCallback
        public void doFrameGuarded(long j) {
            if (UIViewOperationQueue.this.mIsInIllegalUIState) {
                FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Trace.beginSection("dispatchNonBatchedUIOperations");
            try {
                dispatchPendingNonBatchedOperations(j);
                Trace.endSection();
                UIViewOperationQueue.this.flushPendingBatches();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    public final class FindTargetForTouchOperation implements UIOperation {
        public final Callback mCallback;
        public final int mReactTag;
        public final float mTargetX;
        public final float mTargetY;

        public FindTargetForTouchOperation(int i, float f, float f2, Callback callback, AnonymousClass1 r6) {
            this.mReactTag = i;
            this.mTargetX = f;
            this.mTargetY = f2;
            this.mCallback = callback;
        }

        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            int findTargetTagAndCoordinatesForTouch;
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                UIViewOperationQueue uIViewOperationQueue = UIViewOperationQueue.this;
                int[] iArr = uIViewOperationQueue.mMeasureBuffer;
                float f = (float) iArr[0];
                float f2 = (float) iArr[1];
                NativeViewHierarchyManager nativeViewHierarchyManager = uIViewOperationQueue.mNativeViewHierarchyManager;
                int i = this.mReactTag;
                float f3 = this.mTargetX;
                float f4 = this.mTargetY;
                synchronized (nativeViewHierarchyManager) {
                    UiThreadUtil.assertOnUiThread();
                    View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                    if (view != null) {
                        findTargetTagAndCoordinatesForTouch = TouchTargetHelper.findTargetTagAndCoordinatesForTouch(f3, f4, (ViewGroup) view, TouchTargetHelper.mEventCoords, null);
                    } else {
                        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
                    }
                }
                try {
                    UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(findTargetTagAndCoordinatesForTouch, UIViewOperationQueue.this.mMeasureBuffer);
                    float dIPFromPixel = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[0]) - f);
                    float dIPFromPixel2 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[1]) - f2);
                    float dIPFromPixel3 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                    float dIPFromPixel4 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                    this.mCallback.invoke(Integer.valueOf(findTargetTagAndCoordinatesForTouch), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
                } catch (IllegalViewOperationException unused) {
                    this.mCallback.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                this.mCallback.invoke(new Object[0]);
            }
        }
    }

    public final class ManageChildrenOperation extends ViewOperation {
        public final int[] mIndicesToRemove;
        public final int[] mTagsToDelete;
        public final ViewAtIndex[] mViewsToAdd;

        public ManageChildrenOperation(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
            super(UIViewOperationQueue.this, i);
            this.mIndicesToRemove = iArr;
            this.mViewsToAdd = viewAtIndexArr;
            this.mTagsToDelete = iArr2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:91:0x00aa A[SYNTHETIC] */
        @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
        public void execute() {
            int i;
            ViewAtIndex[] viewAtIndexArr;
            int[] iArr;
            boolean z;
            NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
            int i2 = this.mTag;
            int[] iArr2 = this.mIndicesToRemove;
            ViewAtIndex[] viewAtIndexArr2 = this.mViewsToAdd;
            int[] iArr3 = this.mTagsToDelete;
            synchronized (nativeViewHierarchyManager) {
                UiThreadUtil.assertOnUiThread();
                Set<Integer> pendingDeletionsForTag = nativeViewHierarchyManager.getPendingDeletionsForTag(i2);
                ViewGroup viewGroup = (ViewGroup) nativeViewHierarchyManager.mTagsToViews.get(i2);
                ViewGroupManager viewGroupManager = (ViewGroupManager) nativeViewHierarchyManager.resolveViewManager(i2);
                if (viewGroup != null) {
                    int childCount = viewGroupManager.getChildCount(viewGroup);
                    if (iArr2 != null) {
                        int length = iArr2.length - 1;
                        while (length >= 0) {
                            int i3 = iArr2[length];
                            if (i3 < 0) {
                                throw new IllegalViewOperationException("Trying to remove a negative view index:" + i3 + " view tag: " + i2 + "\n detail: " + NativeViewHierarchyManager.constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr2, viewAtIndexArr2, iArr3));
                            } else if (i3 >= viewGroupManager.getChildCount(viewGroup)) {
                                if (!nativeViewHierarchyManager.mRootTags.get(i2) || viewGroupManager.getChildCount(viewGroup) != 0) {
                                    throw new IllegalViewOperationException("Trying to remove a view index above child count " + i3 + " view tag: " + i2 + "\n detail: " + NativeViewHierarchyManager.constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr2, viewAtIndexArr2, iArr3));
                                }
                                return;
                            } else if (i3 < childCount) {
                                View childAt = viewGroupManager.getChildAt(viewGroup, i3);
                                if (nativeViewHierarchyManager.mLayoutAnimationEnabled && nativeViewHierarchyManager.mLayoutAnimator.shouldAnimateLayout(childAt)) {
                                    int id = childAt.getId();
                                    if (iArr3 != null) {
                                        int length2 = iArr3.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length2) {
                                                break;
                                            } else if (iArr3[i4] == id) {
                                                z = true;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                        if (z) {
                                            length--;
                                            childCount = i3;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                viewGroupManager.removeViewAt(viewGroup, i3);
                                length--;
                                childCount = i3;
                            } else {
                                throw new IllegalViewOperationException("Trying to remove an out of order view index:" + i3 + " view tag: " + i2 + "\n detail: " + NativeViewHierarchyManager.constructManageChildrenErrorMessage(viewGroup, viewGroupManager, iArr2, viewAtIndexArr2, iArr3));
                            }
                        }
                    }
                    if (iArr3 != null) {
                        int i5 = 0;
                        while (i5 < iArr3.length) {
                            int i6 = iArr3[i5];
                            View view = nativeViewHierarchyManager.mTagsToViews.get(i6);
                            if (view != null) {
                                if (!nativeViewHierarchyManager.mLayoutAnimationEnabled || !nativeViewHierarchyManager.mLayoutAnimator.shouldAnimateLayout(view)) {
                                    i = i5;
                                    iArr = iArr2;
                                    viewAtIndexArr = viewAtIndexArr2;
                                    nativeViewHierarchyManager.dropView(view);
                                } else {
                                    pendingDeletionsForTag.add(Integer.valueOf(i6));
                                    iArr = iArr2;
                                    viewAtIndexArr = viewAtIndexArr2;
                                    i = i5;
                                    nativeViewHierarchyManager.mLayoutAnimator.deleteView(view, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0142: INVOKE  
                                          (wrap: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController : 0x012b: IGET  (r6v6 com.facebook.react.uimanager.layoutanimation.LayoutAnimationController) = (r9v0 'nativeViewHierarchyManager' com.facebook.react.uimanager.NativeViewHierarchyManager) com.facebook.react.uimanager.NativeViewHierarchyManager.mLayoutAnimator com.facebook.react.uimanager.layoutanimation.LayoutAnimationController)
                                          (r7v6 'view' android.view.View)
                                          (wrap: com.facebook.react.uimanager.NativeViewHierarchyManager$1 : 0x013f: CONSTRUCTOR  (r5v5 com.facebook.react.uimanager.NativeViewHierarchyManager$1) = 
                                          (r9v0 'nativeViewHierarchyManager' com.facebook.react.uimanager.NativeViewHierarchyManager)
                                          (r15v1 'viewGroupManager' com.facebook.react.uimanager.ViewGroupManager)
                                          (r14v1 'viewGroup' android.view.ViewGroup)
                                          (r7v6 'view' android.view.View)
                                          (r13v0 'pendingDeletionsForTag' java.util.Set<java.lang.Integer>)
                                          (r0v1 'i2' int)
                                         call: com.facebook.react.uimanager.NativeViewHierarchyManager.1.<init>(com.facebook.react.uimanager.NativeViewHierarchyManager, com.facebook.react.uimanager.ViewGroupManager, android.view.ViewGroup, android.view.View, java.util.Set, int):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.deleteView(android.view.View, com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener):void in method: com.facebook.react.uimanager.UIViewOperationQueue.ManageChildrenOperation.execute():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x013f: CONSTRUCTOR  (r5v5 com.facebook.react.uimanager.NativeViewHierarchyManager$1) = 
                                          (r9v0 'nativeViewHierarchyManager' com.facebook.react.uimanager.NativeViewHierarchyManager)
                                          (r15v1 'viewGroupManager' com.facebook.react.uimanager.ViewGroupManager)
                                          (r14v1 'viewGroup' android.view.ViewGroup)
                                          (r7v6 'view' android.view.View)
                                          (r13v0 'pendingDeletionsForTag' java.util.Set<java.lang.Integer>)
                                          (r0v1 'i2' int)
                                         call: com.facebook.react.uimanager.NativeViewHierarchyManager.1.<init>(com.facebook.react.uimanager.NativeViewHierarchyManager, com.facebook.react.uimanager.ViewGroupManager, android.view.ViewGroup, android.view.View, java.util.Set, int):void type: CONSTRUCTOR in method: com.facebook.react.uimanager.UIViewOperationQueue.ManageChildrenOperation.execute():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 48 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.uimanager.NativeViewHierarchyManager, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 54 more
                                        */
                                    /* JADX WARNING: Removed duplicated region for block: B:91:0x00aa A[SYNTHETIC] */
                                    /*
                                    // Method dump skipped, instructions count: 556
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.ManageChildrenOperation.execute():void");
                                }
                            }

                            public final class MeasureInWindowOperation implements UIOperation {
                                public final Callback mCallback;
                                public final int mReactTag;

                                public MeasureInWindowOperation(int i, Callback callback, AnonymousClass1 r4) {
                                    this.mReactTag = i;
                                    this.mCallback = callback;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    try {
                                        UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                                        float dIPFromPixel = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                                        float dIPFromPixel2 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                                        float dIPFromPixel3 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                                        float dIPFromPixel4 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                                        this.mCallback.invoke(Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
                                    } catch (NoSuchNativeViewException unused) {
                                        this.mCallback.invoke(new Object[0]);
                                    }
                                }
                            }

                            public final class MeasureOperation implements UIOperation {
                                public final Callback mCallback;
                                public final int mReactTag;

                                public MeasureOperation(int i, Callback callback, AnonymousClass1 r4) {
                                    this.mReactTag = i;
                                    this.mCallback = callback;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    try {
                                        UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                                        float dIPFromPixel = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                                        float dIPFromPixel2 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                                        float dIPFromPixel3 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                                        float dIPFromPixel4 = AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                                        this.mCallback.invoke(0, 0, Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2));
                                    } catch (NoSuchNativeViewException unused) {
                                        this.mCallback.invoke(new Object[0]);
                                    }
                                }
                            }

                            public final class RemoveRootViewOperation extends ViewOperation {
                                public RemoveRootViewOperation(int i) {
                                    super(UIViewOperationQueue.this, i);
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                                    int i = this.mTag;
                                    synchronized (nativeViewHierarchyManager) {
                                        UiThreadUtil.assertOnUiThread();
                                        if (!nativeViewHierarchyManager.mRootTags.get(i)) {
                                            SoftAssertions.assertUnreachable("View with tag " + i + " is not registered as a root view");
                                        }
                                        nativeViewHierarchyManager.dropView(nativeViewHierarchyManager.mTagsToViews.get(i));
                                        nativeViewHierarchyManager.mRootTags.delete(i);
                                    }
                                }
                            }

                            public final class SendAccessibilityEvent extends ViewOperation {
                                public final int mEventType;

                                public SendAccessibilityEvent(int i, int i2, AnonymousClass1 r4) {
                                    super(UIViewOperationQueue.this, i);
                                    this.mEventType = i2;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                                    int i = this.mTag;
                                    int i2 = this.mEventType;
                                    View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                                    if (view != null) {
                                        view.sendAccessibilityEvent(i2);
                                        return;
                                    }
                                    throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline4("Could not find view with tag ", i));
                                }
                            }

                            public class SetLayoutAnimationEnabledOperation implements UIOperation {
                                public final boolean mEnabled;

                                public SetLayoutAnimationEnabledOperation(boolean z, AnonymousClass1 r3) {
                                    this.mEnabled = z;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    UIViewOperationQueue.this.mNativeViewHierarchyManager.mLayoutAnimationEnabled = this.mEnabled;
                                }
                            }

                            public final class ShowPopupMenuOperation extends ViewOperation {
                                public final Callback mError;
                                public final ReadableArray mItems;
                                public final Callback mSuccess;

                                public ShowPopupMenuOperation(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
                                    super(UIViewOperationQueue.this, i);
                                    this.mItems = readableArray;
                                    this.mError = callback;
                                    this.mSuccess = callback2;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                                    int i = this.mTag;
                                    ReadableArray readableArray = this.mItems;
                                    Callback callback = this.mSuccess;
                                    Callback callback2 = this.mError;
                                    synchronized (nativeViewHierarchyManager) {
                                        UiThreadUtil.assertOnUiThread();
                                        View view = nativeViewHierarchyManager.mTagsToViews.get(i);
                                        if (view == null) {
                                            callback2.invoke("Can't display popup. Could not find view with tag " + i);
                                            return;
                                        }
                                        View view2 = nativeViewHierarchyManager.mTagsToViews.get(i);
                                        if (view2 != null) {
                                            PopupMenu popupMenu = new PopupMenu((ThemedReactContext) view2.getContext(), view);
                                            nativeViewHierarchyManager.mPopupMenu = popupMenu;
                                            Menu menu = popupMenu.getMenu();
                                            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                                                menu.add(0, 0, i2, readableArray.getString(i2));
                                            }
                                            NativeViewHierarchyManager.PopupMenuCallbackHandler popupMenuCallbackHandler = new NativeViewHierarchyManager.PopupMenuCallbackHandler(callback, null);
                                            nativeViewHierarchyManager.mPopupMenu.setOnMenuItemClickListener(popupMenuCallbackHandler);
                                            nativeViewHierarchyManager.mPopupMenu.setOnDismissListener(popupMenuCallbackHandler);
                                            nativeViewHierarchyManager.mPopupMenu.show();
                                            return;
                                        }
                                        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
                                    }
                                }
                            }

                            public class UIBlockOperation implements UIOperation {
                                public final UIBlock mBlock;

                                public UIBlockOperation(UIBlock uIBlock) {
                                    this.mBlock = uIBlock;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
                                }
                            }

                            public interface UIOperation {
                                void execute();
                            }

                            public final class UpdateLayoutOperation extends ViewOperation {
                                public final int mHeight;
                                public final int mParentTag;
                                public final int mWidth;
                                public final int mX;
                                public final int mY;

                                public UpdateLayoutOperation(int i, int i2, int i3, int i4, int i5, int i6) {
                                    super(UIViewOperationQueue.this, i2);
                                    this.mParentTag = i;
                                    this.mX = i3;
                                    this.mY = i4;
                                    this.mWidth = i5;
                                    this.mHeight = i6;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    int i = this.mTag;
                                    NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                                    int i2 = this.mParentTag;
                                    int i3 = this.mX;
                                    int i4 = this.mY;
                                    int i5 = this.mWidth;
                                    int i6 = this.mHeight;
                                    synchronized (nativeViewHierarchyManager) {
                                        UiThreadUtil.assertOnUiThread();
                                        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
                                        try {
                                            View resolveView = nativeViewHierarchyManager.resolveView(i);
                                            resolveView.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                                            ViewParent parent = resolveView.getParent();
                                            if (parent instanceof RootView) {
                                                parent.requestLayout();
                                            }
                                            if (!nativeViewHierarchyManager.mRootTags.get(i2)) {
                                                ViewManager viewManager = nativeViewHierarchyManager.mTagsToViewManagers.get(i2);
                                                if (viewManager instanceof IViewManagerWithChildren) {
                                                    IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
                                                    if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                                                        nativeViewHierarchyManager.updateLayout(resolveView, i3, i4, i5, i6);
                                                    }
                                                } else {
                                                    throw new IllegalViewOperationException("Trying to use view with tag " + i2 + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                                                }
                                            } else {
                                                nativeViewHierarchyManager.updateLayout(resolveView, i3, i4, i5, i6);
                                            }
                                        } finally {
                                            Trace.endSection();
                                        }
                                    }
                                }
                            }

                            public final class UpdatePropertiesOperation extends ViewOperation {
                                public final ReactStylesDiffMap mProps;

                                public UpdatePropertiesOperation(int i, ReactStylesDiffMap reactStylesDiffMap, AnonymousClass1 r4) {
                                    super(UIViewOperationQueue.this, i);
                                    this.mProps = reactStylesDiffMap;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
                                }
                            }

                            public final class UpdateViewExtraData extends ViewOperation {
                                public final Object mExtraData;

                                public UpdateViewExtraData(int i, Object obj) {
                                    super(UIViewOperationQueue.this, i);
                                    this.mExtraData = obj;
                                }

                                @Override // com.facebook.react.uimanager.UIViewOperationQueue.UIOperation
                                public void execute() {
                                    NativeViewHierarchyManager nativeViewHierarchyManager = UIViewOperationQueue.this.mNativeViewHierarchyManager;
                                    int i = this.mTag;
                                    Object obj = this.mExtraData;
                                    synchronized (nativeViewHierarchyManager) {
                                        UiThreadUtil.assertOnUiThread();
                                        nativeViewHierarchyManager.resolveViewManager(i).updateExtraData(nativeViewHierarchyManager.resolveView(i), obj);
                                    }
                                }
                            }

                            public abstract class ViewOperation implements UIOperation {
                                public int mTag;

                                public ViewOperation(UIViewOperationQueue uIViewOperationQueue, int i) {
                                    this.mTag = i;
                                }
                            }

                            public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i) {
                                this.mNativeViewHierarchyManager = nativeViewHierarchyManager;
                                this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext, i == -1 ? 8 : i, null);
                                this.mReactApplicationContext = reactApplicationContext;
                                this.mAllowViewCommandsQueue = false;
                            }

                            /* JADX INFO: finally extract failed */
                            public void dispatchViewUpdates(final int i, final long j, final long j2) {
                                final ArrayList<DispatchCommandViewOperation> arrayList;
                                final ArrayList<UIOperation> arrayList2;
                                final ArrayDeque<UIOperation> arrayDeque;
                                SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
                                try {
                                    final long uptimeMillis = SystemClock.uptimeMillis();
                                    final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                                    if (!this.mViewCommandOperations.isEmpty()) {
                                        ArrayList<DispatchCommandViewOperation> arrayList3 = this.mViewCommandOperations;
                                        this.mViewCommandOperations = new ArrayList<>();
                                        arrayList = arrayList3;
                                    } else {
                                        arrayList = null;
                                    }
                                    if (!this.mOperations.isEmpty()) {
                                        ArrayList<UIOperation> arrayList4 = this.mOperations;
                                        this.mOperations = new ArrayList<>();
                                        arrayList2 = arrayList4;
                                    } else {
                                        arrayList2 = null;
                                    }
                                    synchronized (this.mNonBatchedOperationsLock) {
                                        if (!this.mNonBatchedOperations.isEmpty()) {
                                            ArrayDeque<UIOperation> arrayDeque2 = this.mNonBatchedOperations;
                                            this.mNonBatchedOperations = new ArrayDeque<>();
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            arrayDeque = null;
                                        }
                                    }
                                    if (this.mViewHierarchyUpdateDebugListener != null) {
                                        DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector = (DidJSUpdateUiDuringFrameDetector) this.mViewHierarchyUpdateDebugListener;
                                        synchronized (didJSUpdateUiDuringFrameDetector) {
                                            didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
                                        }
                                    }
                                    AnonymousClass1 r0 = new Runnable() {
                                        /* class com.facebook.react.uimanager.UIViewOperationQueue.AnonymousClass1 */

                                        public void run() {
                                            SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
                                            try {
                                                long uptimeMillis = SystemClock.uptimeMillis();
                                                if (arrayList != null) {
                                                    Iterator it = arrayList.iterator();
                                                    while (it.hasNext()) {
                                                        DispatchCommandViewOperation dispatchCommandViewOperation = (DispatchCommandViewOperation) it.next();
                                                        try {
                                                            dispatchCommandViewOperation.executeWithExceptions();
                                                        } catch (RetryableMountingLayerException e) {
                                                            if (dispatchCommandViewOperation.getRetries() == 0) {
                                                                dispatchCommandViewOperation.incrementRetries();
                                                                UIViewOperationQueue.this.mViewCommandOperations.add(dispatchCommandViewOperation);
                                                            } else {
                                                                ReactSoftException.logSoftException("UIViewOperationQueue", new ReactNoCrashSoftException(e));
                                                            }
                                                        } catch (Throwable th) {
                                                            ReactSoftException.logSoftException("UIViewOperationQueue", th);
                                                        }
                                                    }
                                                }
                                                if (arrayDeque != null) {
                                                    Iterator it2 = arrayDeque.iterator();
                                                    while (it2.hasNext()) {
                                                        ((UIOperation) it2.next()).execute();
                                                    }
                                                }
                                                if (arrayList2 != null) {
                                                    Iterator it3 = arrayList2.iterator();
                                                    while (it3.hasNext()) {
                                                        ((UIOperation) it3.next()).execute();
                                                    }
                                                }
                                                if (UIViewOperationQueue.this.mIsProfilingNextBatch && UIViewOperationQueue.this.mProfiledBatchCommitStartTime == 0) {
                                                    UIViewOperationQueue.this.mProfiledBatchCommitStartTime = j;
                                                    UIViewOperationQueue.this.mProfiledBatchCommitEndTime = SystemClock.uptimeMillis();
                                                    UIViewOperationQueue.this.mProfiledBatchLayoutTime = j2;
                                                    UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime = uptimeMillis;
                                                    UIViewOperationQueue.this.mProfiledBatchRunStartTime = uptimeMillis;
                                                    UIViewOperationQueue.this.mProfiledBatchRunEndTime = UIViewOperationQueue.this.mProfiledBatchCommitEndTime;
                                                    UIViewOperationQueue.this.mThreadCpuTime = currentThreadTimeMillis;
                                                    long j = UIViewOperationQueue.this.mProfiledBatchCommitStartTime;
                                                    long j2 = UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime;
                                                    long j3 = UIViewOperationQueue.this.mProfiledBatchDispatchViewUpdatesTime;
                                                    long j4 = UIViewOperationQueue.this.mProfiledBatchRunStartTime;
                                                }
                                                UIViewOperationQueue.this.mNativeViewHierarchyManager.mLayoutAnimator.reset();
                                                if (UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener != null) {
                                                    DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector = (DidJSUpdateUiDuringFrameDetector) UIViewOperationQueue.this.mViewHierarchyUpdateDebugListener;
                                                    synchronized (didJSUpdateUiDuringFrameDetector) {
                                                        didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
                                                    }
                                                }
                                                Trace.endSection();
                                            } catch (Exception e2) {
                                                UIViewOperationQueue.this.mIsInIllegalUIState = true;
                                                throw e2;
                                            } catch (Throwable th2) {
                                                Trace.endSection();
                                                throw th2;
                                            }
                                        }
                                    };
                                    SystraceMessage.NoopBuilder noopBuilder2 = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
                                    synchronized (this.mDispatchRunnablesLock) {
                                        Trace.endSection();
                                        this.mDispatchUIRunnables.add(r0);
                                    }
                                    if (!this.mIsDispatchUIFrameCallbackEnqueued) {
                                        UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mReactApplicationContext) {
                                            /* class com.facebook.react.uimanager.UIViewOperationQueue.AnonymousClass2 */

                                            @Override // com.facebook.react.bridge.GuardedRunnable
                                            public void runGuarded() {
                                                UIViewOperationQueue.this.flushPendingBatches();
                                            }
                                        });
                                    }
                                    Trace.endSection();
                                } catch (Throwable th) {
                                    Trace.endSection();
                                    throw th;
                                }
                            }

                            public void enqueueCreateView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
                                synchronized (this.mNonBatchedOperationsLock) {
                                    this.mCreateViewCount++;
                                    this.mNonBatchedOperations.addLast(new CreateViewOperation(themedReactContext, i, str, reactStylesDiffMap));
                                }
                            }

                            public void enqueueManageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
                                this.mOperations.add(new ManageChildrenOperation(i, iArr, viewAtIndexArr, iArr2));
                            }

                            public void enqueueUpdateExtraData(int i, Object obj) {
                                this.mOperations.add(new UpdateViewExtraData(i, obj));
                            }

                            public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
                                this.mOperations.add(new UpdateLayoutOperation(i, i2, i3, i4, i5, i6));
                            }

                            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
                                r2 = android.os.SystemClock.uptimeMillis();
                                r0 = r1.iterator();
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
                                if (r0.hasNext() == false) goto L_0x0039;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
                                r0.next().run();
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
                                if (r4.mIsProfilingNextBatch == false) goto L_0x004b;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
                                r4.mProfiledBatchBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r2;
                                r4.mProfiledBatchNonBatchedExecutionTime = r4.mNonBatchedExecutionTotalTime;
                                r4.mIsProfilingNextBatch = false;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
                                r4.mNonBatchedExecutionTotalTime = 0;
                             */
                            /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
                                return;
                             */
                            public final void flushPendingBatches() {
                                if (this.mIsInIllegalUIState) {
                                    FLog.w("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                                    return;
                                }
                                synchronized (this.mDispatchRunnablesLock) {
                                    if (!this.mDispatchUIRunnables.isEmpty()) {
                                        ArrayList<Runnable> arrayList = this.mDispatchUIRunnables;
                                        this.mDispatchUIRunnables = new ArrayList<>();
                                    }
                                }
                            }
                        }
