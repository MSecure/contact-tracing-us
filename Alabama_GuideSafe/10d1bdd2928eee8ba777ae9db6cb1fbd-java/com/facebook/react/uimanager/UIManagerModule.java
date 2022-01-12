package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Trace;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.ArrayMap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaNative;
import com.facebook.yoga.YogaNodeJNIBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = UIManagerModule.NAME)
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    public static final boolean DEBUG = false;
    public static final String NAME = "UIManager";
    public int mBatchId;
    public final Map<String, Object> mCustomDirectEvents;
    public final EventDispatcher mEventDispatcher;
    public final List<UIManagerModuleListener> mListeners;
    public final MemoryTrimCallback mMemoryTrimCallback;
    public final Map<String, Object> mModuleConstants;
    public final UIImplementation mUIImplementation;
    public Map<String, WritableMap> mViewManagerConstantsCache;
    public volatile int mViewManagerConstantsCacheSize;
    public final ViewManagerRegistry mViewManagerRegistry;

    public interface CustomEventNamesResolver {
    }

    public class MemoryTrimCallback implements ComponentCallbacks2 {
        public MemoryTrimCallback(UIManagerModule uIManagerModule, AnonymousClass1 r2) {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                YogaNodePool.get().clear();
            }
        }
    }

    public interface ViewManagerResolver {
    }

    static {
        Printer printer = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, int i) {
        this(reactApplicationContext, viewManagerResolver, new UIImplementationProvider(), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e A[RETURN] */
    private WritableMap computeConstantsForViewManager(String str) {
        ViewManager viewManager;
        if (str != null) {
            ViewManagerRegistry viewManagerRegistry = this.mUIImplementation.mViewManagers;
            viewManager = viewManagerRegistry.mViewManagers.get(str);
            if (viewManager == null) {
                if (viewManagerRegistry.mViewManagerResolver != null) {
                    viewManager = viewManagerRegistry.getViewManagerFromResolver(str);
                }
            }
            if (viewManager != null) {
                return null;
            }
            SystraceMessage.Builder builder = SystraceMessage.NOOP_BUILDER;
            viewManager.getName();
            SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) builder;
            return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.createConstantsForViewManager(viewManager, null, null, null, this.mCustomDirectEvents));
        }
        viewManager = null;
        if (viewManager != null) {
        }
    }

    public static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
        try {
            return UIManagerModuleConstantsHelper.createConstants(viewManagerResolver);
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        Trace.beginSection("UIManagerModule.addRootView");
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(getReactApplicationContext(), t.getContext(), ((ReactRoot) t).getSurfaceID());
        UIImplementation uIImplementation = this.mUIImplementation;
        synchronized (uIImplementation.uiImplementationThreadLock) {
            ReactShadowNodeImpl reactShadowNodeImpl = new ReactShadowNodeImpl();
            if (I18nUtil.getInstance().isRTL(uIImplementation.mReactContext)) {
                YogaNative.jni_YGNodeStyleSetDirectionJNI(((YogaNodeJNIBase) reactShadowNodeImpl.mYogaNode).mNativePointer, YogaDirection.RTL.mIntValue);
            }
            reactShadowNodeImpl.mViewClassName = "Root";
            reactShadowNodeImpl.mReactTag = nextRootViewTag;
            reactShadowNodeImpl.mThemedContext = themedReactContext;
            themedReactContext.runOnNativeModulesQueueThread(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004d: INVOKE  
                  (r0v0 'themedReactContext' com.facebook.react.uimanager.ThemedReactContext)
                  (wrap: com.facebook.react.uimanager.UIImplementation$1 : 0x004a: CONSTRUCTOR  (r3v3 com.facebook.react.uimanager.UIImplementation$1) = 
                  (r9v2 'uIImplementation' com.facebook.react.uimanager.UIImplementation)
                  (r2v3 'reactShadowNodeImpl' com.facebook.react.uimanager.ReactShadowNodeImpl)
                 call: com.facebook.react.uimanager.UIImplementation.1.<init>(com.facebook.react.uimanager.UIImplementation, com.facebook.react.uimanager.ReactShadowNode):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.facebook.react.bridge.ReactContext.runOnNativeModulesQueueThread(java.lang.Runnable):void in method: com.facebook.react.uimanager.UIManagerModule.addRootView(T extends android.view.View, com.facebook.react.bridge.WritableMap, java.lang.String):int, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004a: CONSTRUCTOR  (r3v3 com.facebook.react.uimanager.UIImplementation$1) = 
                  (r9v2 'uIImplementation' com.facebook.react.uimanager.UIImplementation)
                  (r2v3 'reactShadowNodeImpl' com.facebook.react.uimanager.ReactShadowNodeImpl)
                 call: com.facebook.react.uimanager.UIImplementation.1.<init>(com.facebook.react.uimanager.UIImplementation, com.facebook.react.uimanager.ReactShadowNode):void type: CONSTRUCTOR in method: com.facebook.react.uimanager.UIManagerModule.addRootView(T extends android.view.View, com.facebook.react.bridge.WritableMap, java.lang.String):int, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.uimanager.UIImplementation, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                java.lang.String r8 = "UIManagerModule.addRootView"
                android.os.Trace.beginSection(r8)
                int r8 = com.facebook.react.uimanager.ReactRootViewTagGenerator.getNextRootViewTag()
                com.facebook.react.bridge.ReactApplicationContext r9 = r6.getReactApplicationContext()
                com.facebook.react.uimanager.ThemedReactContext r0 = new com.facebook.react.uimanager.ThemedReactContext
                android.content.Context r1 = r7.getContext()
                r2 = r7
                com.facebook.react.uimanager.ReactRoot r2 = (com.facebook.react.uimanager.ReactRoot) r2
                java.lang.String r2 = r2.getSurfaceID()
                r0.<init>(r9, r1, r2)
                com.facebook.react.uimanager.UIImplementation r9 = r6.mUIImplementation
                java.lang.Object r1 = r9.uiImplementationThreadLock
                monitor-enter(r1)
                com.facebook.react.uimanager.ReactShadowNodeImpl r2 = new com.facebook.react.uimanager.ReactShadowNodeImpl     // Catch:{ all -> 0x0061 }
                r2.<init>()     // Catch:{ all -> 0x0061 }
                com.facebook.react.modules.i18nmanager.I18nUtil r3 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance()     // Catch:{ all -> 0x0061 }
                com.facebook.react.bridge.ReactApplicationContext r4 = r9.mReactContext     // Catch:{ all -> 0x0061 }
                boolean r3 = r3.isRTL(r4)     // Catch:{ all -> 0x0061 }
                if (r3 == 0) goto L_0x0040
                com.facebook.yoga.YogaDirection r3 = com.facebook.yoga.YogaDirection.RTL     // Catch:{ all -> 0x0061 }
                com.facebook.yoga.YogaNode r4 = r2.mYogaNode     // Catch:{ all -> 0x0061 }
                com.facebook.yoga.YogaNodeJNIBase r4 = (com.facebook.yoga.YogaNodeJNIBase) r4     // Catch:{ all -> 0x0061 }
                long r4 = r4.mNativePointer     // Catch:{ all -> 0x0061 }
                int r3 = r3.mIntValue     // Catch:{ all -> 0x0061 }
                com.facebook.yoga.YogaNative.jni_YGNodeStyleSetDirectionJNI(r4, r3)     // Catch:{ all -> 0x0061 }
            L_0x0040:
                java.lang.String r3 = "Root"
                r2.mViewClassName = r3     // Catch:{ all -> 0x0061 }
                r2.mReactTag = r8     // Catch:{ all -> 0x0061 }
                r2.mThemedContext = r0     // Catch:{ all -> 0x0061 }
                com.facebook.react.uimanager.UIImplementation$1 r3 = new com.facebook.react.uimanager.UIImplementation$1     // Catch:{ all -> 0x0061 }
                r3.<init>(r2)     // Catch:{ all -> 0x0061 }
                r0.runOnNativeModulesQueueThread(r3)     // Catch:{ all -> 0x0061 }
                com.facebook.react.uimanager.UIViewOperationQueue r9 = r9.mOperationsQueue     // Catch:{ all -> 0x0061 }
                com.facebook.react.uimanager.NativeViewHierarchyManager r9 = r9.mNativeViewHierarchyManager     // Catch:{ all -> 0x0061 }
                monitor-enter(r9)     // Catch:{ all -> 0x0061 }
                r9.addRootViewGroup(r8, r7)     // Catch:{ all -> 0x005e }
                monitor-exit(r9)
                monitor-exit(r1)
                android.os.Trace.endSection()
                return r8
            L_0x005e:
                r7 = move-exception
                monitor-exit(r9)
                throw r7
            L_0x0061:
                r7 = move-exception
                monitor-exit(r1)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIManagerModule.addRootView(android.view.View, com.facebook.react.bridge.WritableMap, java.lang.String):int");
        }

        public void addUIBlock(UIBlock uIBlock) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.UIBlockOperation(uIBlock));
        }

        public void addUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
            this.mListeners.add(uIManagerModuleListener);
        }

        @ReactMethod
        public void clearJSResponder() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.ChangeJSResponderOperation(0, 0, true, false));
        }

        @ReactMethod
        public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.ConfigureLayoutAnimationOperation(readableMap, callback, null));
        }

        @ReactMethod
        public void createView(int i, String str, int i2, ReadableMap readableMap) {
            if (DEBUG) {
                FLog.d("ReactNative", "(UIManager.createView) tag: " + i + ", class: " + str + ", props: " + readableMap);
                Printer printer = PrinterHolder.sPrinter;
                DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
            }
            UIImplementation uIImplementation = this.mUIImplementation;
            synchronized (uIImplementation.uiImplementationThreadLock) {
                ReactShadowNode createShadowNodeInstance = uIImplementation.mViewManagers.get(str).createShadowNodeInstance(uIImplementation.mReactContext);
                ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i2);
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactShadowNode, "Root node with tag " + i2 + " doesn't exist");
                createShadowNodeInstance.setReactTag(i);
                createShadowNodeInstance.setViewClassName(str);
                createShadowNodeInstance.setRootTag(reactShadowNode.getReactTag());
                createShadowNodeInstance.setThemedContext(reactShadowNode.getThemedContext());
                ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
                shadowNodeRegistry2.mThreadAsserter.assertNow();
                shadowNodeRegistry2.mTagsToCSSNodes.put(createShadowNodeInstance.getReactTag(), createShadowNodeInstance);
                ReactStylesDiffMap reactStylesDiffMap = null;
                if (readableMap != null) {
                    reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                    createShadowNodeInstance.updateProperties(reactStylesDiffMap);
                }
                uIImplementation.handleCreateView(createShadowNodeInstance, reactStylesDiffMap);
            }
        }

        @ReactMethod
        public void dismissPopupMenu() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.DismissPopupMenuOperation(null));
        }

        @Override // com.facebook.react.bridge.UIManager
        @Deprecated
        public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
            UIImplementation uIImplementation = this.mUIImplementation;
            uIImplementation.assertViewExists(i, "dispatchViewManagerCommand");
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            UIViewOperationQueue.DispatchCommandOperation dispatchCommandOperation = new UIViewOperationQueue.DispatchCommandOperation(i, i2, readableArray);
            if (uIViewOperationQueue.mAllowViewCommandsQueue) {
                uIViewOperationQueue.mViewCommandOperations.add(dispatchCommandOperation);
            } else {
                uIViewOperationQueue.mOperations.add(dispatchCommandOperation);
            }
        }

        @ReactMethod
        public void dispatchViewManagerCommand(int i, Dynamic dynamic, ReadableArray readableArray) {
            UIManager uIManager = ReactYogaConfigProvider.getUIManager(getReactApplicationContext(), ReactYogaConfigProvider.getUIManagerType(i));
            if (uIManager != null) {
                if (dynamic.getType() == ReadableType.Number) {
                    uIManager.dispatchCommand(i, dynamic.asInt(), readableArray);
                } else if (dynamic.getType() == ReadableType.String) {
                    uIManager.dispatchCommand(i, dynamic.asString(), readableArray);
                }
            }
        }

        @ReactMethod
        public void findSubviewIn(int i, ReadableArray readableArray, Callback callback) {
            UIImplementation uIImplementation = this.mUIImplementation;
            float round = (float) Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableArray.getDouble(0)));
            float round2 = (float) Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(readableArray.getDouble(1)));
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.FindTargetForTouchOperation(i, round, round2, callback, null));
        }

        @Override // com.facebook.react.bridge.BaseJavaModule
        public Map<String, Object> getConstants() {
            return this.mModuleConstants;
        }

        @ReactMethod(isBlockingSynchronousMethod = true)
        public WritableMap getConstantsForViewManager(String str) {
            Map<String, WritableMap> map = this.mViewManagerConstantsCache;
            if (map == null || !map.containsKey(str)) {
                return computeConstantsForViewManager(str);
            }
            WritableMap writableMap = this.mViewManagerConstantsCache.get(str);
            int i = this.mViewManagerConstantsCacheSize - 1;
            this.mViewManagerConstantsCacheSize = i;
            if (i <= 0) {
                this.mViewManagerConstantsCache = null;
            }
            return writableMap;
        }

        @ReactMethod(isBlockingSynchronousMethod = true)
        public WritableMap getDefaultEventTypes() {
            return Arguments.makeNativeMap(AppCompatDelegateImpl.ConfigurationImplApi17.of("bubblingEventTypes", ReactYogaConfigProvider.getBubblingEventTypeConstants(), "directEventTypes", ReactYogaConfigProvider.getDirectEventTypeConstants()));
        }

        public CustomEventNamesResolver getDirectEventNamesResolver() {
            return new CustomEventNamesResolver() {
                /* class com.facebook.react.uimanager.UIManagerModule.AnonymousClass1 */
            };
        }

        @Override // com.facebook.react.bridge.NativeModule
        public String getName() {
            return NAME;
        }

        @Override // com.facebook.react.bridge.PerformanceCounter
        public Map<String, Long> getPerformanceCounters() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            if (uIViewOperationQueue != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("CommitStartTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchCommitStartTime));
                hashMap.put("CommitEndTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchCommitEndTime));
                hashMap.put("LayoutTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchLayoutTime));
                hashMap.put("DispatchViewUpdatesTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchDispatchViewUpdatesTime));
                hashMap.put("RunStartTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchRunStartTime));
                hashMap.put("RunEndTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchRunEndTime));
                hashMap.put("BatchedExecutionTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchBatchedExecutionTime));
                hashMap.put("NonBatchedExecutionTime", Long.valueOf(uIViewOperationQueue.mProfiledBatchNonBatchedExecutionTime));
                hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(uIViewOperationQueue.mThreadCpuTime));
                hashMap.put("CreateViewCount", Long.valueOf(uIViewOperationQueue.mCreateViewCount));
                hashMap.put("UpdatePropsCount", Long.valueOf(uIViewOperationQueue.mUpdatePropertiesOperationCount));
                return hashMap;
            }
            throw null;
        }

        public UIImplementation getUIImplementation() {
            return this.mUIImplementation;
        }

        @Deprecated
        public ViewManagerRegistry getViewManagerRegistry_DO_NOT_USE() {
            return this.mViewManagerRegistry;
        }

        @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.bridge.JSIModule
        public void initialize() {
            getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
            this.mEventDispatcher.mReactEventEmitter.register(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
        }

        public void invalidateNodeLayout(int i) {
            ShadowNodeRegistry shadowNodeRegistry = this.mUIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            if (reactShadowNode == null) {
                FLog.w("ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i);
                return;
            }
            reactShadowNode.dirty();
            this.mUIImplementation.dispatchViewUpdates(-1);
        }

        @ReactMethod
        public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
            if (DEBUG) {
                FLog.d("ReactNative", "(UIManager.manageChildren) tag: " + i + ", moveFrom: " + readableArray + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5);
                Printer printer = PrinterHolder.sPrinter;
                DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
            }
            this.mUIImplementation.manageChildren(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
        }

        @ReactMethod
        public void measure(int i, Callback callback) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.MeasureOperation(i, callback, null));
        }

        @ReactMethod
        public void measureInWindow(int i, Callback callback) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.MeasureInWindowOperation(i, callback, null));
        }

        @ReactMethod
        public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
            UIImplementation uIImplementation = this.mUIImplementation;
            if (uIImplementation != null) {
                try {
                    uIImplementation.measureLayout(i, i2, uIImplementation.mMeasureBuffer);
                    callback2.invoke(Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[0])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[1])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[2])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[3])));
                } catch (IllegalViewOperationException e) {
                    callback.invoke(e.getMessage());
                }
            } else {
                throw null;
            }
        }

        @ReactMethod
        @Deprecated
        public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
            UIImplementation uIImplementation = this.mUIImplementation;
            if (uIImplementation != null) {
                try {
                    uIImplementation.measureLayoutRelativeToParent(i, uIImplementation.mMeasureBuffer);
                    callback2.invoke(Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[0])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[1])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[2])), Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) uIImplementation.mMeasureBuffer[3])));
                } catch (IllegalViewOperationException e) {
                    callback.invoke(e.getMessage());
                }
            } else {
                throw null;
            }
        }

        @Override // com.facebook.react.bridge.OnBatchCompleteListener
        public void onBatchComplete() {
            int i = this.mBatchId;
            this.mBatchId = i + 1;
            SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
            for (UIManagerModuleListener uIManagerModuleListener : this.mListeners) {
                uIManagerModuleListener.willDispatchViewUpdates(this);
            }
            try {
                this.mUIImplementation.dispatchViewUpdates(i);
            } finally {
                Trace.endSection();
            }
        }

        @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.bridge.JSIModule
        public void onCatalystInstanceDestroy() {
            super.onCatalystInstanceDestroy();
            EventDispatcher eventDispatcher = this.mEventDispatcher;
            if (eventDispatcher != null) {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.uimanager.events.EventDispatcher.AnonymousClass2 */

                    public void run() {
                        EventDispatcher.this.stopFrameCallback();
                    }
                });
                getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
                YogaNodePool.get().clear();
                ViewManagerPropertyUpdater.clear();
                return;
            }
            throw null;
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostDestroy() {
            if (this.mUIImplementation == null) {
                throw null;
            }
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mIsDispatchUIFrameCallbackEnqueued = false;
            ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, uIViewOperationQueue.mDispatchUIFrameCallback);
            uIViewOperationQueue.flushPendingBatches();
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mIsDispatchUIFrameCallbackEnqueued = true;
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, uIViewOperationQueue.mDispatchUIFrameCallback);
        }

        @ReactMethod
        @Deprecated
        public void playTouchSound() {
            AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            }
        }

        @Deprecated
        public void preComputeConstantsForViewManager(List<String> list) {
            ArrayMap arrayMap = new ArrayMap();
            for (String str : list) {
                WritableMap computeConstantsForViewManager = computeConstantsForViewManager(str);
                if (computeConstantsForViewManager != null) {
                    arrayMap.put(str, computeConstantsForViewManager);
                }
            }
            this.mViewManagerConstantsCacheSize = list.size();
            this.mViewManagerConstantsCache = Collections.unmodifiableMap(arrayMap);
        }

        public void prependUIBlock(UIBlock uIBlock) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(0, new UIViewOperationQueue.UIBlockOperation(uIBlock));
        }

        @Override // com.facebook.react.bridge.PerformanceCounter
        public void profileNextBatch() {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mIsProfilingNextBatch = true;
            uIViewOperationQueue.mProfiledBatchCommitStartTime = 0;
            uIViewOperationQueue.mCreateViewCount = 0;
            uIViewOperationQueue.mUpdatePropertiesOperationCount = 0;
        }

        @ReactMethod
        public void removeRootView(int i) {
            UIImplementation uIImplementation = this.mUIImplementation;
            synchronized (uIImplementation.uiImplementationThreadLock) {
                uIImplementation.mShadowNodeRegistry.removeRootNode(i);
            }
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.RemoveRootViewOperation(i));
        }

        @ReactMethod
        @Deprecated
        public void removeSubviewsFromContainerWithID(int i) {
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            if (reactShadowNode != null) {
                WritableArray createArray = Arguments.createArray();
                for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
                    createArray.pushInt(i2);
                }
                uIImplementation.manageChildren(i, null, null, null, null, createArray);
                return;
            }
            throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("Trying to remove subviews of an unknown view tag: ", i));
        }

        public void removeUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
            this.mListeners.remove(uIManagerModuleListener);
        }

        @ReactMethod
        @Deprecated
        public void replaceExistingNonRootView(int i, int i2) {
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            if (!shadowNodeRegistry.mRootTags.get(i)) {
                ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
                shadowNodeRegistry2.mThreadAsserter.assertNow();
                if (!shadowNodeRegistry2.mRootTags.get(i2)) {
                    ShadowNodeRegistry shadowNodeRegistry3 = uIImplementation.mShadowNodeRegistry;
                    shadowNodeRegistry3.mThreadAsserter.assertNow();
                    ReactShadowNode reactShadowNode = shadowNodeRegistry3.mTagsToCSSNodes.get(i);
                    if (reactShadowNode != null) {
                        ReactShadowNode parent = reactShadowNode.getParent();
                        if (parent != null) {
                            int indexOf = parent.indexOf(reactShadowNode);
                            if (indexOf >= 0) {
                                WritableArray createArray = Arguments.createArray();
                                createArray.pushInt(i2);
                                WritableArray createArray2 = Arguments.createArray();
                                createArray2.pushInt(indexOf);
                                WritableArray createArray3 = Arguments.createArray();
                                createArray3.pushInt(indexOf);
                                uIImplementation.manageChildren(parent.getReactTag(), null, null, createArray, createArray2, createArray3);
                                return;
                            }
                            throw new IllegalStateException("Didn't find child tag in parent");
                        }
                        throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("Node is not attached to a parent: ", i));
                    }
                    throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("Trying to replace unknown view tag: ", i));
                }
            }
            throw new IllegalViewOperationException("Trying to add or replace a root tag!");
        }

        @Deprecated
        public int resolveRootTagFromReactTag(int i) {
            boolean z = true;
            int i2 = 0;
            if (i % 10 != 1) {
                z = false;
            }
            if (z) {
                return i;
            }
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            if (shadowNodeRegistry.mRootTags.get(i)) {
                return i;
            }
            ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry2.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry2.mTagsToCSSNodes.get(i);
            if (reactShadowNode != null) {
                i2 = reactShadowNode.getRootTag();
            } else {
                FLog.w("ReactNative", "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i);
            }
            return i2;
        }

        public View resolveView(int i) {
            UiThreadUtil.assertOnUiThread();
            return this.mUIImplementation.mOperationsQueue.mNativeViewHierarchyManager.resolveView(i);
        }

        @Override // com.facebook.react.bridge.UIManager
        @ReactMethod
        public void sendAccessibilityEvent(int i, int i2) {
            int uIManagerType = ReactYogaConfigProvider.getUIManagerType(i);
            if (uIManagerType == 2) {
                UIManager uIManager = ReactYogaConfigProvider.getUIManager(getReactApplicationContext(), uIManagerType);
                if (uIManager != null) {
                    uIManager.sendAccessibilityEvent(i, i2);
                    return;
                }
                return;
            }
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.SendAccessibilityEvent(i, i2, null));
        }

        @ReactMethod
        public void setChildren(int i, ReadableArray readableArray) {
            if (DEBUG) {
                FLog.d("ReactNative", "(UIManager.setChildren) tag: " + i + ", children: " + readableArray);
                Printer printer = PrinterHolder.sPrinter;
                DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
            }
            UIImplementation uIImplementation = this.mUIImplementation;
            synchronized (uIImplementation.uiImplementationThreadLock) {
                ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
                shadowNodeRegistry.mThreadAsserter.assertNow();
                ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                for (int i2 = 0; i2 < readableArray.size(); i2++) {
                    ReactShadowNode node = uIImplementation.mShadowNodeRegistry.getNode(readableArray.getInt(i2));
                    if (node != null) {
                        reactShadowNode.addChildAt(node, i2);
                    } else {
                        throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2));
                    }
                }
                NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.mNativeViewHierarchyOptimizer;
                if (nativeViewHierarchyOptimizer != null) {
                    for (int i3 = 0; i3 < readableArray.size(); i3++) {
                        nativeViewHierarchyOptimizer.addNodeToNode(reactShadowNode, nativeViewHierarchyOptimizer.mShadowNodeRegistry.getNode(readableArray.getInt(i3)), i3);
                    }
                } else {
                    throw null;
                }
            }
        }

        @ReactMethod
        public void setJSResponder(int i, boolean z) {
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            if (reactShadowNode != null) {
                while (reactShadowNode.getNativeKind() == NativeKind.NONE) {
                    reactShadowNode = reactShadowNode.getParent();
                }
                UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
                uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.ChangeJSResponderOperation(reactShadowNode.getReactTag(), i, false, z));
            }
        }

        @ReactMethod
        public void setLayoutAnimationEnabledExperimental(boolean z) {
            UIViewOperationQueue uIViewOperationQueue = this.mUIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.SetLayoutAnimationEnabledOperation(z, null));
        }

        public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
            this.mUIImplementation.mOperationsQueue.mViewHierarchyUpdateDebugListener = notThreadSafeViewHierarchyUpdateDebugListener;
        }

        public void setViewLocalData(final int i, final Object obj) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            reactApplicationContext.assertOnUiQueueThread();
            reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
                /* class com.facebook.react.uimanager.UIManagerModule.AnonymousClass2 */

                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    UIImplementation uIImplementation = UIManagerModule.this.mUIImplementation;
                    int i = i;
                    Object obj = obj;
                    ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
                    shadowNodeRegistry.mThreadAsserter.assertNow();
                    ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                    if (reactShadowNode == null) {
                        FLog.w("ReactNative", "Attempt to set local data for view with unknown tag: " + i);
                        return;
                    }
                    reactShadowNode.setLocalData(obj);
                    uIImplementation.dispatchViewUpdatesIfNeeded();
                }
            });
        }

        @ReactMethod
        public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
            UIImplementation uIImplementation = this.mUIImplementation;
            uIImplementation.assertViewExists(i, "showPopupMenu");
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.ShowPopupMenuOperation(i, readableArray, callback, callback2));
        }

        @Override // com.facebook.react.bridge.UIManager
        public void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap) {
            int uIManagerType = ReactYogaConfigProvider.getUIManagerType(i);
            if (uIManagerType == 2) {
                UIManager uIManager = ReactYogaConfigProvider.getUIManager(getReactApplicationContext(), uIManagerType);
                if (uIManager != null) {
                    uIManager.synchronouslyUpdateViewOnUIThread(i, readableMap);
                    return;
                }
                return;
            }
            UIImplementation uIImplementation = this.mUIImplementation;
            ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
            if (uIImplementation != null) {
                UiThreadUtil.assertOnUiThread();
                uIImplementation.mOperationsQueue.mNativeViewHierarchyManager.updateProperties(i, reactStylesDiffMap);
                return;
            }
            throw null;
        }

        public void updateNodeSize(int i, int i2, int i3) {
            getReactApplicationContext().assertOnNativeModulesQueueThread();
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            if (reactShadowNode == null) {
                FLog.w("ReactNative", "Tried to update size of non-existent tag: " + i);
                return;
            }
            reactShadowNode.setStyleWidth((float) i2);
            reactShadowNode.setStyleHeight((float) i3);
            uIImplementation.dispatchViewUpdatesIfNeeded();
        }

        @Override // com.facebook.react.bridge.UIManager
        public void updateRootLayoutSpecs(final int i, final int i2, final int i3) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
                /* class com.facebook.react.uimanager.UIManagerModule.AnonymousClass4 */

                @Override // com.facebook.react.bridge.GuardedRunnable
                public void runGuarded() {
                    UIImplementation uIImplementation = UIManagerModule.this.mUIImplementation;
                    int i = i;
                    int i2 = i2;
                    int i3 = i3;
                    ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
                    shadowNodeRegistry.mThreadAsserter.assertNow();
                    ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
                    if (reactShadowNode == null) {
                        FLog.w("ReactNative", "Tried to update non-existent root tag: " + i);
                    } else {
                        reactShadowNode.setMeasureSpecs(i2, i3);
                    }
                    UIManagerModule.this.mUIImplementation.dispatchViewUpdates(-1);
                }
            });
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
            r0 = com.facebook.react.uimanager.ReactYogaConfigProvider.getUIManager(r7, r0);
         */
        @ReactMethod
        public void updateView(final int i, String str, final ReadableMap readableMap) {
            final UIManager uIManager;
            if (DEBUG) {
                FLog.d("ReactNative", "(UIManager.updateView) tag: " + i + ", class: " + str + ", props: " + readableMap);
                Printer printer = PrinterHolder.sPrinter;
                DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.UI_MANAGER;
            }
            int uIManagerType = ReactYogaConfigProvider.getUIManagerType(i);
            if (uIManagerType == 2) {
                ReactApplicationContext reactApplicationContext = getReactApplicationContext();
                if (reactApplicationContext.hasActiveCatalystInstance() && uIManager != null) {
                    reactApplicationContext.runOnUiQueueThread(new Runnable(this) {
                        /* class com.facebook.react.uimanager.UIManagerModule.AnonymousClass3 */

                        public void run() {
                            uIManager.synchronouslyUpdateViewOnUIThread(i, readableMap);
                        }
                    });
                    return;
                }
                return;
            }
            UIImplementation uIImplementation = this.mUIImplementation;
            uIImplementation.mViewManagers.get(str);
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            if (reactShadowNode == null) {
                throw new IllegalViewOperationException(GeneratedOutlineSupport.outline5("Trying to update non-existent view with tag ", i));
            } else if (readableMap != null) {
                ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                reactShadowNode.updateProperties(reactStylesDiffMap);
                if (!reactShadowNode.isVirtual()) {
                    NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer = uIImplementation.mNativeViewHierarchyOptimizer;
                    if (nativeViewHierarchyOptimizer != null) {
                        if (reactShadowNode.isLayoutOnly() && !NativeViewHierarchyOptimizer.isLayoutOnlyAndCollapsable(reactStylesDiffMap)) {
                            nativeViewHierarchyOptimizer.transitionLayoutOnlyViewToNativeView(reactShadowNode, reactStylesDiffMap);
                        } else if (!reactShadowNode.isLayoutOnly()) {
                            UIViewOperationQueue uIViewOperationQueue = nativeViewHierarchyOptimizer.mUIViewOperationQueue;
                            int reactTag = reactShadowNode.getReactTag();
                            uIViewOperationQueue.mUpdatePropertiesOperationCount++;
                            uIViewOperationQueue.mOperations.add(new UIViewOperationQueue.UpdatePropertiesOperation(reactTag, reactStylesDiffMap, null));
                        }
                    } else {
                        throw null;
                    }
                }
            }
        }

        @ReactMethod
        @Deprecated
        public void viewIsDescendantOf(int i, int i2, Callback callback) {
            UIImplementation uIImplementation = this.mUIImplementation;
            ShadowNodeRegistry shadowNodeRegistry = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode = shadowNodeRegistry.mTagsToCSSNodes.get(i);
            ShadowNodeRegistry shadowNodeRegistry2 = uIImplementation.mShadowNodeRegistry;
            shadowNodeRegistry2.mThreadAsserter.assertNow();
            ReactShadowNode reactShadowNode2 = shadowNodeRegistry2.mTagsToCSSNodes.get(i2);
            if (reactShadowNode == null || reactShadowNode2 == null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            callback.invoke(Boolean.valueOf(reactShadowNode.isDescendantOf(reactShadowNode2)));
        }

        public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i) {
            this(reactApplicationContext, list, new UIImplementationProvider(), i);
        }

        @Override // com.facebook.react.bridge.UIManager
        public EventDispatcher getEventDispatcher() {
            return this.mEventDispatcher;
        }

        @Deprecated
        public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, UIImplementationProvider uIImplementationProvider, int i) {
            super(reactApplicationContext);
            this.mMemoryTrimCallback = new MemoryTrimCallback(this, null);
            this.mListeners = new ArrayList();
            this.mBatchId = 0;
            AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(reactApplicationContext);
            this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
            this.mModuleConstants = createConstants(viewManagerResolver);
            this.mCustomDirectEvents = ReactYogaConfigProvider.getDirectEventTypeConstants();
            ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(viewManagerResolver);
            this.mViewManagerRegistry = viewManagerRegistry;
            EventDispatcher eventDispatcher = this.mEventDispatcher;
            if (uIImplementationProvider != null) {
                this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i);
                reactApplicationContext.addLifecycleEventListener(this);
                return;
            }
            throw null;
        }

        @Override // com.facebook.react.bridge.UIManager
        public void dispatchCommand(int i, String str, ReadableArray readableArray) {
            UIImplementation uIImplementation = this.mUIImplementation;
            uIImplementation.assertViewExists(i, "dispatchViewManagerCommand");
            UIViewOperationQueue uIViewOperationQueue = uIImplementation.mOperationsQueue;
            UIViewOperationQueue.DispatchStringCommandOperation dispatchStringCommandOperation = new UIViewOperationQueue.DispatchStringCommandOperation(i, str, readableArray);
            if (uIViewOperationQueue.mAllowViewCommandsQueue) {
                uIViewOperationQueue.mViewCommandOperations.add(dispatchStringCommandOperation);
            } else {
                uIViewOperationQueue.mOperations.add(dispatchStringCommandOperation);
            }
        }

        public static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
            SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) SystraceMessage.NOOP_BUILDER;
            try {
                return UIManagerModuleConstantsHelper.createConstants(list, map, map2);
            } finally {
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
            }
        }

        @Deprecated
        public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, UIImplementationProvider uIImplementationProvider, int i) {
            super(reactApplicationContext);
            this.mMemoryTrimCallback = new MemoryTrimCallback(this, null);
            this.mListeners = new ArrayList();
            this.mBatchId = 0;
            AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(reactApplicationContext);
            this.mEventDispatcher = new EventDispatcher(reactApplicationContext);
            HashMap hashMap = new HashMap();
            this.mCustomDirectEvents = hashMap;
            this.mModuleConstants = createConstants(list, null, hashMap);
            ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(list);
            this.mViewManagerRegistry = viewManagerRegistry;
            EventDispatcher eventDispatcher = this.mEventDispatcher;
            if (uIImplementationProvider != null) {
                this.mUIImplementation = new UIImplementation(reactApplicationContext, viewManagerRegistry, eventDispatcher, i);
                reactApplicationContext.addLifecycleEventListener(this);
                return;
            }
            throw null;
        }

        public <T extends View> int addRootView(T t) {
            return addRootView(t, null, null);
        }
    }
