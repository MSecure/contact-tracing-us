package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceManagerDevHelper;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReactInstanceManager {
    public final Context mApplicationContext;
    public final Set<ReactRoot> mAttachedReactRoots = Collections.synchronizedSet(new HashSet());
    public final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    public final JSBundleLoader mBundleLoader;
    public volatile Thread mCreateReactContextThread;
    public Activity mCurrentActivity;
    public volatile ReactContext mCurrentReactContext;
    public DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    public final DevSupportManager mDevSupportManager;
    public volatile boolean mHasStartedCreatingInitialContext = false;
    public volatile Boolean mHasStartedDestroying = Boolean.FALSE;
    public final JSIModulePackage mJSIModulePackage;
    public final String mJSMainModulePath;
    public final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    public volatile LifecycleState mLifecycleState;
    public final MemoryPressureRouter mMemoryPressureRouter;
    public final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    public final List<ReactPackage> mPackages;
    public ReactContextInitParams mPendingReactContextInitParams;
    public final Object mReactContextLock = new Object();
    public final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
    public final boolean mUseDeveloperSupport;
    public List<ViewManager> mViewManagers;

    public class ReactContextInitParams {
        public final JSBundleLoader mJsBundleLoader;
        public final JavaScriptExecutorFactory mJsExecutorFactory;

        public ReactContextInitParams(ReactInstanceManager reactInstanceManager, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(javaScriptExecutorFactory);
            this.mJsExecutorFactory = javaScriptExecutorFactory;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(jSBundleLoader);
            this.mJsBundleLoader = jSBundleLoader;
        }
    }

    public interface ReactInstanceEventListener {
        void onReactContextInitialized(ReactContext reactContext);
    }

    public ReactInstanceManager(Context context, Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<ReactPackage> list, boolean z, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, UIImplementationProvider uIImplementationProvider, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, RedBoxHandler redBoxHandler, boolean z2, DevBundleDownloadListener devBundleDownloadListener, int i, int i2, JSIModulePackage jSIModulePackage, Map<String, RequestHandler> map) {
        FLog.d("ReactInstanceManager", "ReactInstanceManager.ctor()");
        SoLoader.init(context, false);
        AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context;
        this.mCurrentActivity = null;
        this.mDefaultBackButtonImpl = null;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        this.mJSMainModulePath = str;
        this.mPackages = new ArrayList();
        this.mUseDeveloperSupport = z;
        Trace.beginSection("ReactInstanceManager.initDevSupportManager");
        this.mDevSupportManager = DevSupportManagerFactory.create(context, new ReactInstanceManagerDevHelper() {
            /* class com.facebook.react.ReactInstanceManager.AnonymousClass2 */

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public View createRootView(String str) {
                Activity activity = ReactInstanceManager.this.mCurrentActivity;
                if (activity == null) {
                    return null;
                }
                ReactRootView reactRootView = new ReactRootView(activity);
                reactRootView.startReactApplication(ReactInstanceManager.this, str, null);
                return reactRootView;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public void destroyRootView(View view) {
                FLog.e("ReactInstanceManager", "destroyRootView called");
                if (view instanceof ReactRootView) {
                    FLog.e("ReactInstanceManager", "destroyRootView called, unmountReactApplication");
                    ((ReactRootView) view).unmountReactApplication();
                }
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public Activity getCurrentActivity() {
                return ReactInstanceManager.this.mCurrentActivity;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
                return ReactInstanceManager.this.mJavaScriptExecutorFactory;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public void onJSBundleLoadedFromServer() {
                ReactInstanceManager.access$200(ReactInstanceManager.this);
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
                ReactInstanceManager reactInstanceManager = ReactInstanceManager.this;
                if (reactInstanceManager != null) {
                    FLog.d("ReactNative", "ReactInstanceManager.onReloadWithJSDebugger()");
                    reactInstanceManager.recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(factory), JSBundleLoader.createRemoteDebuggerBundleLoader(reactInstanceManager.mDevSupportManager.getJSBundleURLForRemoteDebugging(), reactInstanceManager.mDevSupportManager.getSourceUrl()));
                    return;
                }
                throw null;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceManagerDevHelper
            public void toggleElementInspector() {
                ReactContext currentReactContext = ReactInstanceManager.this.getCurrentReactContext();
                if (currentReactContext == null || !currentReactContext.hasActiveCatalystInstance()) {
                    ReactSoftException.logSoftException("ReactInstanceManager", new ReactNoCrashSoftException("Cannot toggleElementInspector, CatalystInstance not available"));
                } else {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
                }
            }
        }, this.mJSMainModulePath, z, redBoxHandler, null, i, null);
        Trace.endSection();
        this.mBridgeIdleDebugListener = null;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context);
        this.mNativeModuleCallExceptionHandler = null;
        synchronized (this.mPackages) {
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
            this.mPackages.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass1 */

                @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
                public void invokeDefaultOnBackPressed() {
                    ReactInstanceManager.this.invokeDefaultOnBackPressed();
                }
            }, z2, i2));
            if (this.mUseDeveloperSupport) {
                this.mPackages.add(new DebugCorePackage());
            }
            this.mPackages.addAll(list);
        }
        this.mJSIModulePackage = jSIModulePackage;
        if (ReactChoreographer.sInstance == null) {
            ReactChoreographer.sInstance = new ReactChoreographer();
        }
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.startInspector();
        }
    }

    /* JADX INFO: finally extract failed */
    public static ReactApplicationContext access$1100(ReactInstanceManager reactInstanceManager, JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        if (reactInstanceManager != null) {
            FLog.d("ReactNative", "ReactInstanceManager.createReactContext()");
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
            ReactApplicationContext reactApplicationContext = new ReactApplicationContext(reactInstanceManager.mApplicationContext);
            NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = reactInstanceManager.mNativeModuleCallExceptionHandler;
            if (nativeModuleCallExceptionHandler == null) {
                nativeModuleCallExceptionHandler = reactInstanceManager.mDevSupportManager;
            }
            reactApplicationContext.setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
            List<ReactPackage> list = reactInstanceManager.mPackages;
            NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext, reactInstanceManager);
            ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
            synchronized (reactInstanceManager.mPackages) {
                for (ReactPackage reactPackage : list) {
                    Trace.beginSection("createAndProcessCustomReactPackage");
                    try {
                        reactInstanceManager.processPackage(reactPackage, nativeModuleRegistryBuilder);
                    } finally {
                        Trace.endSection();
                    }
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
            Trace.beginSection("buildNativeModuleRegistry");
            try {
                NativeModuleRegistry nativeModuleRegistry = new NativeModuleRegistry(nativeModuleRegistryBuilder.mReactApplicationContext, nativeModuleRegistryBuilder.mModules);
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
                CatalystInstanceImpl.Builder nativeModuleCallExceptionHandler2 = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(nativeModuleRegistry).setJSBundleLoader(jSBundleLoader).setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
                Trace.beginSection("createCatalystInstance");
                try {
                    CatalystInstanceImpl build = nativeModuleCallExceptionHandler2.build();
                    Trace.endSection();
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                    reactApplicationContext.initializeWithInstance(build);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ReactInstanceManager.createReactContext: mJSIModulePackage ");
                    sb.append(reactInstanceManager.mJSIModulePackage != null ? "not null" : "null");
                    FLog.e("ReactNative", sb.toString());
                    JSIModulePackage jSIModulePackage = reactInstanceManager.mJSIModulePackage;
                    if (jSIModulePackage != null) {
                        build.addJSIModules(jSIModulePackage.getJSIModules(reactApplicationContext, build.getJavaScriptContextHolder()));
                        FLog.e("ReactNative", "ReactInstanceManager.createReactContext: ReactFeatureFlags.useTurboModules == " + "false");
                    }
                    NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = reactInstanceManager.mBridgeIdleDebugListener;
                    if (notThreadSafeBridgeIdleDebugListener != null) {
                        build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
                    }
                    ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
                    Trace.beginSection("runJSBundle");
                    build.runJSBundle();
                    Trace.endSection();
                    return reactApplicationContext;
                } catch (Throwable th) {
                    Trace.endSection();
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                    throw th;
                }
            } catch (Throwable th2) {
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
                throw th2;
            }
        } else {
            throw null;
        }
    }

    public static void access$1500(ReactInstanceManager reactInstanceManager, final ReactApplicationContext reactApplicationContext) {
        if (reactInstanceManager != null) {
            FLog.d("ReactNative", "ReactInstanceManager.setupReactContext()");
            ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
            ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
            Trace.beginSection("setupReactContext");
            synchronized (reactInstanceManager.mAttachedReactRoots) {
                synchronized (reactInstanceManager.mReactContextLock) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactApplicationContext);
                    reactInstanceManager.mCurrentReactContext = reactApplicationContext;
                }
                CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(catalystInstance);
                catalystInstance.initialize();
                reactInstanceManager.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
                reactInstanceManager.mMemoryPressureRouter.mListeners.add(catalystInstance);
                synchronized (reactInstanceManager) {
                    if (reactInstanceManager.mLifecycleState == LifecycleState.RESUMED) {
                        reactInstanceManager.moveToResumedLifecycleState(true);
                    }
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
                for (ReactRoot reactRoot : reactInstanceManager.mAttachedReactRoots) {
                    reactInstanceManager.attachRootViewToInstance(reactRoot);
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
            }
            final ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) reactInstanceManager.mReactInstanceEventListeners.toArray(new ReactInstanceEventListener[reactInstanceManager.mReactInstanceEventListeners.size()]);
            UiThreadUtil.runOnUiThread(new Runnable(reactInstanceManager) {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass6 */

                public void run() {
                    ReactInstanceEventListener[] reactInstanceEventListenerArr = reactInstanceEventListenerArr;
                    for (ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
                        if (reactInstanceEventListener != null) {
                            reactInstanceEventListener.onReactContextInitialized(reactApplicationContext);
                        }
                    }
                }
            });
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
            reactApplicationContext.runOnJSQueueThread(new Runnable(reactInstanceManager) {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass7 */

                public void run() {
                    Process.setThreadPriority(0);
                    ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
                }
            });
            reactApplicationContext.runOnNativeModulesQueueThread(new Runnable(reactInstanceManager) {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass8 */

                public void run() {
                    Process.setThreadPriority(0);
                }
            });
            return;
        }
        throw null;
    }

    public static void access$200(ReactInstanceManager reactInstanceManager) {
        if (reactInstanceManager != null) {
            FLog.d("ReactNative", "ReactInstanceManager.onJSBundleLoadedFromServer()");
            reactInstanceManager.recreateReactContextInBackground(reactInstanceManager.mJavaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(reactInstanceManager.mDevSupportManager.getSourceUrl(), reactInstanceManager.mDevSupportManager.getDownloadedJSBundleFile()));
            return;
        }
        throw null;
    }

    public final void attachRootViewToInstance(final ReactRoot reactRoot) {
        WritableMap writableMap;
        FLog.e("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
        Trace.beginSection("attachRootViewToInstance");
        UIManager uIManager = ReactYogaConfigProvider.getUIManager(this.mCurrentReactContext, reactRoot.getUIManagerType());
        if (uIManager != null) {
            Bundle appProperties = reactRoot.getAppProperties();
            ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
            if (appProperties == null) {
                writableMap = new WritableNativeMap();
            } else {
                writableMap = Arguments.fromBundle(appProperties);
            }
            final int addRootView = uIManager.addRootView(rootViewGroup, writableMap, reactRoot.getInitialUITemplate());
            reactRoot.setRootViewTag(addRootView);
            if (reactRoot.getUIManagerType() == 2) {
                uIManager.updateRootLayoutSpecs(addRootView, reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                reactRoot.runApplication();
            }
            UiThreadUtil.runOnUiThread(new Runnable(this) {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass9 */

                public void run() {
                    reactRoot.onStage(101);
                }
            });
            Trace.endSection();
            return;
        }
        throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
    }

    public void createReactContextInBackground() {
        FLog.d("ReactInstanceManager", "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (!this.mHasStartedCreatingInitialContext) {
            this.mHasStartedCreatingInitialContext = true;
            FLog.d("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundInner()");
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
            UiThreadUtil.assertOnUiThread();
            if (!this.mUseDeveloperSupport || this.mJSMainModulePath == null) {
                FLog.d("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
                Printer printer2 = PrinterHolder.sPrinter;
                DebugOverlayTag debugOverlayTag2 = ReactDebugOverlayTags.RN_CORE;
                recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
                return;
            }
            final DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
            if (this.mBundleLoader == null) {
                this.mDevSupportManager.handleReloadJS();
            } else {
                this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback() {
                    /* class com.facebook.react.ReactInstanceManager.AnonymousClass3 */

                    @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
                    public void onPackagerStatusFetched(final boolean z) {
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            /* class com.facebook.react.ReactInstanceManager.AnonymousClass3.AnonymousClass1 */

                            public void run() {
                                if (z) {
                                    ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                                } else if (!ReactInstanceManager.this.mDevSupportManager.hasUpToDateJSBundleInCache() || devSettings.isRemoteJSDebugEnabled()) {
                                    devSettings.setRemoteJSDebugEnabled(false);
                                    ReactInstanceManager reactInstanceManager = ReactInstanceManager.this;
                                    if (reactInstanceManager != null) {
                                        FLog.d("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
                                        Printer printer = PrinterHolder.sPrinter;
                                        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
                                        reactInstanceManager.recreateReactContextInBackground(reactInstanceManager.mJavaScriptExecutorFactory, reactInstanceManager.mBundleLoader);
                                        return;
                                    }
                                    throw null;
                                } else {
                                    ReactInstanceManager.access$200(ReactInstanceManager.this);
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public final void detachViewFromInstance(ReactRoot reactRoot, CatalystInstance catalystInstance) {
        FLog.d("ReactNative", "ReactInstanceManager.detachViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getUIManagerType() == 2) {
            ((ReactFabric) catalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(reactRoot.getRootViewTag());
        } else {
            ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
        }
    }

    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            reactContext = this.mCurrentReactContext;
        }
        return reactContext;
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> list;
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Trace.beginSection("createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        this.mViewManagers = new ArrayList();
                        for (ReactPackage reactPackage : this.mPackages) {
                            this.mViewManagers.addAll(reactPackage.createViewManagers(reactApplicationContext));
                        }
                        list = this.mViewManagers;
                    }
                }
                return list;
            }
            list = this.mViewManagers;
            return list;
        } finally {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
        }
    }

    public final void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    public final synchronized void moveToResumedLifecycleState(boolean z) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (z || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
            currentReactContext.onHostResume(this.mCurrentActivity);
        }
        this.mLifecycleState = LifecycleState.RESUMED;
    }

    public final void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        Iterable<ModuleHolder> iterable;
        List<NativeModule> list;
        SystraceMessage.Builder builder = SystraceMessage.NOOP_BUILDER;
        reactPackage.getClass().getSimpleName();
        SystraceMessage.NoopBuilder noopBuilder = (SystraceMessage.NoopBuilder) builder;
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        if (reactPackage instanceof LazyReactPackage) {
            LazyReactPackage lazyReactPackage = (LazyReactPackage) reactPackage;
            ReactApplicationContext reactApplicationContext = nativeModuleRegistryBuilder.mReactApplicationContext;
            iterable = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: CONSTRUCTOR  (r4v13 'iterable' java.lang.Iterable) = 
                  (r1v11 'lazyReactPackage' com.facebook.react.LazyReactPackage)
                  (wrap: java.util.List<com.facebook.react.bridge.ModuleSpec> : 0x0026: INVOKE  (r2v6 java.util.List<com.facebook.react.bridge.ModuleSpec>) = 
                  (r1v11 'lazyReactPackage' com.facebook.react.LazyReactPackage)
                  (r2v5 'reactApplicationContext' com.facebook.react.bridge.ReactApplicationContext)
                 type: VIRTUAL call: com.facebook.react.LazyReactPackage.getNativeModules(com.facebook.react.bridge.ReactApplicationContext):java.util.List)
                  (wrap: java.util.Map<java.lang.String, com.facebook.react.module.model.ReactModuleInfo> : 0x0022: INVOKE  (r3v11 java.util.Map<java.lang.String, com.facebook.react.module.model.ReactModuleInfo>) = 
                  (wrap: com.facebook.react.module.model.ReactModuleInfoProvider : 0x001e: INVOKE  (r3v10 com.facebook.react.module.model.ReactModuleInfoProvider) = (r1v11 'lazyReactPackage' com.facebook.react.LazyReactPackage) type: VIRTUAL call: com.facebook.react.LazyReactPackage.getReactModuleInfoProvider():com.facebook.react.module.model.ReactModuleInfoProvider)
                 type: INTERFACE call: com.facebook.react.module.model.ReactModuleInfoProvider.getReactModuleInfos():java.util.Map)
                 call: com.facebook.react.LazyReactPackage.2.<init>(com.facebook.react.LazyReactPackage, java.util.List, java.util.Map):void type: CONSTRUCTOR in method: com.facebook.react.ReactInstanceManager.processPackage(com.facebook.react.ReactPackage, com.facebook.react.NativeModuleRegistryBuilder):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.LazyReactPackage, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                */
            /*
            // Method dump skipped, instructions count: 226
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.processPackage(com.facebook.react.ReactPackage, com.facebook.react.NativeModuleRegistryBuilder):void");
        }

        public final void recreateReactContextInBackground(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            FLog.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
            UiThreadUtil.assertOnUiThread();
            ReactContextInitParams reactContextInitParams = new ReactContextInitParams(this, javaScriptExecutorFactory, jSBundleLoader);
            if (this.mCreateReactContextThread == null) {
                runCreateReactContextOnNewThread(reactContextInitParams);
            } else {
                this.mPendingReactContextInitParams = reactContextInitParams;
            }
        }

        public final void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
            FLog.d("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
            UiThreadUtil.assertOnUiThread();
            synchronized (this.mAttachedReactRoots) {
                synchronized (this.mReactContextLock) {
                    if (this.mCurrentReactContext != null) {
                        tearDownReactContext(this.mCurrentReactContext);
                        this.mCurrentReactContext = null;
                    }
                }
            }
            this.mCreateReactContextThread = new Thread(null, new Runnable() {
                /* class com.facebook.react.ReactInstanceManager.AnonymousClass5 */

                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000a */
                /* JADX WARNING: Removed duplicated region for block: B:2:0x000a A[LOOP:0: B:2:0x000a->B:16:0x000a, LOOP_START, SYNTHETIC] */
                public void run() {
                    ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
                    synchronized (ReactInstanceManager.this.mHasStartedDestroying) {
                        while (ReactInstanceManager.this.mHasStartedDestroying.booleanValue()) {
                            ReactInstanceManager.this.mHasStartedDestroying.wait();
                        }
                    }
                    ReactInstanceManager.this.mHasStartedCreatingInitialContext = true;
                    try {
                        Process.setThreadPriority(-4);
                        ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
                        final ReactApplicationContext access$1100 = ReactInstanceManager.access$1100(ReactInstanceManager.this, reactContextInitParams.mJsExecutorFactory.create(), reactContextInitParams.mJsBundleLoader);
                        ReactInstanceManager.this.mCreateReactContextThread = null;
                        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
                        AnonymousClass1 r1 = new Runnable() {
                            /* class com.facebook.react.ReactInstanceManager.AnonymousClass5.AnonymousClass1 */

                            public void run() {
                                ReactInstanceManager reactInstanceManager = ReactInstanceManager.this;
                                ReactContextInitParams reactContextInitParams = reactInstanceManager.mPendingReactContextInitParams;
                                if (reactContextInitParams != null) {
                                    reactInstanceManager.runCreateReactContextOnNewThread(reactContextInitParams);
                                    ReactInstanceManager.this.mPendingReactContextInitParams = null;
                                }
                            }
                        };
                        access$1100.runOnNativeModulesQueueThread(new Runnable() {
                            /* class com.facebook.react.ReactInstanceManager.AnonymousClass5.AnonymousClass2 */

                            public void run() {
                                try {
                                    ReactInstanceManager.access$1500(ReactInstanceManager.this, access$1100);
                                } catch (Exception e) {
                                    FLog.e("ReactNative", "ReactInstanceManager caught exception in setupReactContext", e);
                                    ReactInstanceManager.this.mDevSupportManager.handleException(e);
                                }
                            }
                        });
                        UiThreadUtil.runOnUiThread(r1);
                    } catch (Exception e) {
                        ReactInstanceManager.this.mDevSupportManager.handleException(e);
                    }
                }
            }, "create_react_context");
            ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
            this.mCreateReactContextThread.start();
        }

        public final void tearDownReactContext(ReactContext reactContext) {
            FLog.d("ReactNative", "ReactInstanceManager.tearDownReactContext()");
            UiThreadUtil.assertOnUiThread();
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                reactContext.onHostPause();
            }
            synchronized (this.mAttachedReactRoots) {
                for (ReactRoot reactRoot : this.mAttachedReactRoots) {
                    reactRoot.getRootViewGroup().removeAllViews();
                    reactRoot.getRootViewGroup().setId(-1);
                }
            }
            MemoryPressureRouter memoryPressureRouter = this.mMemoryPressureRouter;
            memoryPressureRouter.mListeners.remove(reactContext.getCatalystInstance());
            reactContext.destroy();
            this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
        }
    }
