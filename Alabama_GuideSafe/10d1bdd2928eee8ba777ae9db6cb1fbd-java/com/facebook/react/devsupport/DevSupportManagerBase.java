package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.R$string;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class DevSupportManagerBase implements DevSupportManager, DevServerHelper.PackagerCommandListener, DevInternalSettings.Listener {
    public static final String EMOJI_FACE_WITH_NO_GOOD_GESTURE = " 🙅";
    public static final String EMOJI_HUNDRED_POINTS_SYMBOL = " 💯";
    public static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
    public static final int JAVA_ERROR_COOKIE = -1;
    public static final int JSEXCEPTION_ERROR_COOKIE = -1;
    public static final String JS_BUNDLE_FILE_NAME = "ReactNativeDevBundle.js";
    public static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    public final Context mApplicationContext;
    public DevBundleDownloadListener mBundleDownloadListener;
    public InspectorPackagerConnection.BundleStatus mBundleStatus;
    public ReactContext mCurrentContext;
    public final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions;
    public Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    public DebugOverlayController mDebugOverlayController;
    public final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
    public final DevLoadingViewController mDevLoadingViewController;
    public boolean mDevLoadingViewVisible;
    public AlertDialog mDevOptionsDialog;
    public final DevServerHelper mDevServerHelper;
    public DevInternalSettings mDevSettings;
    public List<ErrorCustomizer> mErrorCustomizers;
    public final List<ExceptionLogger> mExceptionLoggers;
    public boolean mIsDevSupportEnabled;
    public boolean mIsReceiverRegistered;
    public boolean mIsSamplingProfilerEnabled;
    public boolean mIsShakeDetectorStarted;
    public final String mJSAppBundleName;
    public final File mJSBundleTempFile;
    public int mLastErrorCookie;
    public StackFrame[] mLastErrorStack;
    public String mLastErrorTitle;
    public ErrorType mLastErrorType;
    public DevSupportManager.PackagerLocationCustomizer mPackagerLocationCustomizer;
    public final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;
    public RedBoxDialog mRedBoxDialog;
    public RedBoxHandler mRedBoxHandler;
    public final BroadcastReceiver mReloadAppBroadcastReceiver;
    public final ShakeDetector mShakeDetector;

    public interface BundleLoadCallback {
        void onSuccess();
    }

    public enum ErrorType {
        JS,
        NATIVE
    }

    public interface ExceptionLogger {
        void log(Exception exc);
    }

    public class JSExceptionLogger implements ExceptionLogger {
        public JSExceptionLogger() {
        }

        @Override // com.facebook.react.devsupport.DevSupportManagerBase.ExceptionLogger
        public void log(Exception exc) {
            StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
            for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                sb.append("\n\n");
                sb.append(cause.getMessage());
            }
            if (exc instanceof JSException) {
                FLog.e("ReactNative", "Exception in native call from JS", exc);
                String stack = ((JSException) exc).getStack();
                sb.append("\n\n");
                sb.append(stack);
                DevSupportManagerBase.this.showNewError(sb.toString(), new StackFrame[0], -1, ErrorType.JS);
                return;
            }
            DevSupportManagerBase.this.showNewJavaError(sb.toString(), exc);
        }
    }

    public DevSupportManagerBase(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, int i) {
        this(context, reactInstanceManagerDevHelper, str, z, null, null, i, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass23 */

            @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
            public void onFailure(Throwable th) {
                DevSupportManagerBase.this.mDevLoadingViewController.hide();
                DevSupportManagerBase.this.mDevLoadingViewVisible = false;
                FLog.e("ReactNative", "Failed to connect to debugger!", th);
                SimpleSettableFuture simpleSettableFuture = simpleSettableFuture;
                IOException iOException = new IOException(DevSupportManagerBase.this.mApplicationContext.getString(R$string.catalyst_debug_error), th);
                simpleSettableFuture.checkNotSet();
                simpleSettableFuture.mException = iOException;
                simpleSettableFuture.mReadyLatch.countDown();
            }

            @Override // com.facebook.react.devsupport.WebsocketJavaScriptExecutor.JSExecutorConnectCallback
            public void onSuccess() {
                simpleSettableFuture.set(Boolean.TRUE);
                DevSupportManagerBase.this.mDevLoadingViewController.hide();
                DevSupportManagerBase.this.mDevLoadingViewVisible = false;
            }
        };
    }

    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + RELOAD_APP_ACTION_SUFFIX;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleCaptureHeap(final Responder responder) {
        ReactContext reactContext = this.mCurrentContext;
        if (reactContext != null) {
            ((JSCHeapCapture) reactContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass21 */

                @Override // com.facebook.react.devsupport.JSCHeapCapture.CaptureCallback
                public void onFailure(JSCHeapCapture.CaptureException captureException) {
                    ((JSPackagerClient.ResponderImpl) responder).error(captureException.toString());
                }

                @Override // com.facebook.react.devsupport.JSCHeapCapture.CaptureCallback
                public void onSuccess(File file) {
                    ((JSPackagerClient.ResponderImpl) responder).respond(file.toString());
                }
            });
        }
    }

    private void hideDevOptionsDialog() {
        AlertDialog alertDialog = this.mDevOptionsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        List<ErrorCustomizer> list = this.mErrorCustomizers;
        if (list == null) {
            return pair;
        }
        for (ErrorCustomizer errorCustomizer : list) {
            Pair<String, StackFrame[]> customizeErrorInfo = errorCustomizer.customizeErrorInfo(pair);
            if (customizeErrorInfo != null) {
                pair = customizeErrorInfo;
            }
        }
        return pair;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                ShakeDetector shakeDetector = this.mShakeDetector;
                SensorManager sensorManager = (SensorManager) this.mApplicationContext.getSystemService("sensor");
                if (shakeDetector != null) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(sensorManager);
                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                    if (defaultSensor != null) {
                        shakeDetector.mSensorManager = sensorManager;
                        shakeDetector.mLastTimestamp = -1;
                        sensorManager.registerListener(shakeDetector, defaultSensor, 2);
                        shakeDetector.mLastShakeTimestamp = 0;
                        shakeDetector.reset();
                    }
                    this.mIsShakeDetectorStarted = true;
                } else {
                    throw null;
                }
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, intentFilter);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewController.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
            return;
        }
        DebugOverlayController debugOverlayController2 = this.mDebugOverlayController;
        if (debugOverlayController2 != null) {
            debugOverlayController2.setFpsDebugViewVisible(false);
        }
        if (this.mIsShakeDetectorStarted) {
            ShakeDetector shakeDetector2 = this.mShakeDetector;
            SensorManager sensorManager2 = shakeDetector2.mSensorManager;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(shakeDetector2);
                shakeDetector2.mSensorManager = null;
            }
            this.mIsShakeDetectorStarted = false;
        }
        if (this.mIsReceiverRegistered) {
            this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
            this.mIsReceiverRegistered = false;
        }
        hideRedboxDialog();
        hideDevOptionsDialog();
        this.mDevLoadingViewController.hide();
        this.mDevServerHelper.closePackagerConnection();
    }

    private void reloadJSInProxyMode() {
        this.mDevServerHelper.launchJSDevtools();
        this.mReactInstanceManagerHelper.onReloadWithJSDebugger(new JavaJSExecutor.Factory() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass22 */

            @Override // com.facebook.react.bridge.JavaJSExecutor.Factory
            public JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(DevSupportManagerBase.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerBase.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e) {
                    throw ((Exception) e.getCause());
                } catch (InterruptedException | TimeoutException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    private void resetCurrentContext(ReactContext reactContext) {
        if (this.mCurrentContext != reactContext) {
            this.mCurrentContext = reactContext;
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(false);
            }
            if (reactContext != null) {
                this.mDebugOverlayController = new DebugOverlayController(reactContext);
            }
            if (this.mCurrentContext != null) {
                try {
                    URL url = new URL(getSourceUrl());
                    ((HMRClient) this.mCurrentContext.getJSModule(HMRClient.class)).setup("android", url.getPath().substring(1), url.getHost(), url.getPort(), this.mDevSettings.isHotModuleReplacementEnabled());
                } catch (MalformedURLException e) {
                    showNewJavaError(e.getMessage(), e);
                }
            }
            reloadSettings();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showNewError(final String str, final StackFrame[] stackFrameArr, final int i, final ErrorType errorType) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass5 */

            public void run() {
                if (DevSupportManagerBase.this.mRedBoxDialog == null) {
                    Activity currentActivity = DevSupportManagerBase.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
                        outline17.append(str);
                        FLog.e("ReactNative", outline17.toString());
                        return;
                    }
                    DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                    DevSupportManagerBase devSupportManagerBase2 = DevSupportManagerBase.this;
                    devSupportManagerBase.mRedBoxDialog = new RedBoxDialog(currentActivity, devSupportManagerBase2, devSupportManagerBase2.mRedBoxHandler);
                }
                if (!DevSupportManagerBase.this.mRedBoxDialog.isShowing()) {
                    Pair processErrorCustomizers = DevSupportManagerBase.this.processErrorCustomizers(Pair.create(str, stackFrameArr));
                    DevSupportManagerBase.this.mRedBoxDialog.setExceptionDetails((String) processErrorCustomizers.first, (StackFrame[]) processErrorCustomizers.second);
                    DevSupportManagerBase.this.updateLastErrorInfo(str, stackFrameArr, i, errorType);
                    if (DevSupportManagerBase.this.mRedBoxHandler != null && errorType == ErrorType.NATIVE) {
                        DevSupportManagerBase.this.mRedBoxHandler.handleRedbox(str, stackFrameArr, RedBoxHandler.ErrorType.NATIVE);
                    }
                    DevSupportManagerBase.this.mRedBoxDialog.resetReporting();
                    DevSupportManagerBase.this.mRedBoxDialog.show();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r1 = r7.mApplicationContext;
        android.widget.Toast.makeText(r1, r0.toString() + " does not support Sampling Profiler", 1).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        r7.mIsSamplingProfilerEnabled = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0020 */
    private void toggleJSSamplingProfiler() {
        JavaScriptExecutorFactory javaScriptExecutorFactory;
        javaScriptExecutorFactory = this.mReactInstanceManagerHelper.getJavaScriptExecutorFactory();
        if (!this.mIsSamplingProfilerEnabled) {
            javaScriptExecutorFactory.startSamplingProfiler();
            Toast.makeText(this.mApplicationContext, "Starting Sampling Profiler", 0).show();
            this.mIsSamplingProfilerEnabled = true;
            return;
        }
        try {
            String path = File.createTempFile("sampling-profiler-trace", ".cpuprofile", this.mApplicationContext.getCacheDir()).getPath();
            javaScriptExecutorFactory.stopSamplingProfiler(path);
            Context context = this.mApplicationContext;
            Toast.makeText(context, "Saved results from Profiler to " + path, 1).show();
        } catch (IOException unused) {
            FLog.e("ReactNative", "Could not create temporary file for saving results from Sampling Profiler");
        } catch (UnsupportedOperationException unknown) {
            Context context2 = this.mApplicationContext;
            Toast.makeText(context2, javaScriptExecutorFactory.toString() + "does not support Sampling Profiler", 1).show();
        } catch (Throwable th) {
            this.mIsSamplingProfilerEnabled = false;
            throw th;
        }
        Context context22 = this.mApplicationContext;
        Toast.makeText(context22, javaScriptExecutorFactory.toString() + "does not support Sampling Profiler", 1).show();
        this.mIsSamplingProfilerEnabled = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateLastErrorInfo(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public View createRootView(String str) {
        return this.mReactInstanceManagerHelper.createRootView(str);
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public Map<String, RequestHandler> customCommandHandlers() {
        return this.mCustomPackagerCommandHandlers;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void destroyRootView(View view) {
        this.mReactInstanceManagerHelper.destroyRootView(view);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getDownloadedJSBundleFile() {
        return this.mJSBundleTempFile.getAbsolutePath();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getJSBundleURLForRemoteDebugging() {
        DevServerHelper devServerHelper = this.mDevServerHelper;
        String str = this.mJSAppBundleName;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        return devServerHelper.getJSBundleURLForRemoteDebugging(str);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getSourceMapUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        DevServerHelper devServerHelper = this.mDevServerHelper;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        return devServerHelper.getSourceMapUrl(str);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public String getSourceUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        DevServerHelper devServerHelper = this.mDevServerHelper;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        return devServerHelper.getSourceUrl(str);
    }

    @Override // com.facebook.react.bridge.NativeModuleCallExceptionHandler
    public void handleException(Exception exc) {
        if (this.mIsDevSupportEnabled) {
            for (ExceptionLogger exceptionLogger : this.mExceptionLoggers) {
                exceptionLogger.log(exc);
            }
            return;
        }
        this.mDefaultNativeModuleCallExceptionHandler.handleException(exc);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, this.mDevSettings.getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (this.mDevSettings.isRemoteJSDebugEnabled()) {
            Printer printer = PrinterHolder.sPrinter;
            DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.RN_CORE;
            this.mDevLoadingViewController.showForRemoteJSEnabled();
            this.mDevLoadingViewVisible = true;
            reloadJSInProxyMode();
            return;
        }
        Printer printer2 = PrinterHolder.sPrinter;
        DebugOverlayTag debugOverlayTag2 = ReactDebugOverlayTags.RN_CORE;
        DevServerHelper devServerHelper = this.mDevServerHelper;
        String str = this.mJSAppBundleName;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        reloadJSFromServer(devServerHelper.getDevServerBundleURL(str));
    }

    public boolean hasBundleInAssets(String str) {
        String[] list;
        try {
            for (String str2 : this.mApplicationContext.getAssets().list("")) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        } catch (IOException unused) {
            FLog.e("ReactNative", "Error while loading assets list");
        }
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public boolean hasUpToDateJSBundleInCache() {
        if (this.mIsDevSupportEnabled && this.mJSBundleTempFile.exists()) {
            try {
                String packageName = this.mApplicationContext.getPackageName();
                if (this.mJSBundleTempFile.lastModified() > this.mApplicationContext.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, EXOPACKAGE_LOCATION_FORMAT, packageName));
                    if (!file.exists()) {
                        return true;
                    }
                    if (this.mJSBundleTempFile.lastModified() > file.lastModified()) {
                        return true;
                    }
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                FLog.e("ReactNative", "DevSupport is unable to get current app info");
            }
        }
        return false;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hideRedboxDialog() {
        RedBoxDialog redBoxDialog = this.mRedBoxDialog;
        if (redBoxDialog != null) {
            redBoxDialog.dismiss();
            this.mRedBoxDialog = null;
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        AnonymousClass17 r0 = new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass17 */

            public void run() {
                DevSupportManagerBase.this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
            }
        };
        DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer = this.mPackagerLocationCustomizer;
        if (packagerLocationCustomizer != null) {
            packagerLocationCustomizer.run(r0);
        } else {
            r0.run();
        }
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public void onCaptureHeapCommand(final Responder responder) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass20 */

            public void run() {
                DevSupportManagerBase.this.handleCaptureHeap(responder);
            }
        });
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
    public void onInternalSettingsChanged() {
        reloadSettings();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public void onPackagerConnected() {
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public void onPackagerDevMenuCommand() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass19 */

            public void run() {
                DevSupportManagerBase.this.showDevOptionsDialog();
            }
        });
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public void onPackagerDisconnected() {
    }

    @Override // com.facebook.react.devsupport.DevServerHelper.PackagerCommandListener
    public void onPackagerReloadCommand() {
        this.mDevServerHelper.disableDebugger();
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass18 */

            public void run() {
                DevSupportManagerBase.this.handleReloadJS();
            }
        });
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentContext) {
            resetCurrentContext(null);
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void reloadJSFromServer(String str) {
        reloadJSFromServer(str, new BundleLoadCallback() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass24 */

            @Override // com.facebook.react.devsupport.DevSupportManagerBase.BundleLoadCallback
            public void onSuccess() {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass24.AnonymousClass1 */

                    public void run() {
                        DevSupportManagerBase.this.mReactInstanceManagerHelper.onJSBundleLoadedFromServer();
                    }
                });
            }
        });
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass16 */

                public void run() {
                    DevSupportManagerBase.this.reload();
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setFpsDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass28 */

                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setFpsDebugEnabled(z);
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setHotModuleReplacementEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass26 */

                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setPackagerLocationCustomizer(DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer) {
        this.mPackagerLocationCustomizer = packagerLocationCustomizer;
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void setRemoteJSDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass27 */

                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(z);
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showDevOptionsDialog() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.mDevOptionsDialog == null && this.mIsDevSupportEnabled && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.mApplicationContext.getString(R$string.catalyst_reload), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass6 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    if (!DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled() && DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled()) {
                        Toast.makeText(DevSupportManagerBase.this.mApplicationContext, DevSupportManagerBase.this.mApplicationContext.getString(R$string.catalyst_hot_reloading_auto_disable), 1).show();
                        DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(false);
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                str = this.mApplicationContext.getString(R$string.catalyst_debug_stop);
            } else {
                str = this.mApplicationContext.getString(R$string.catalyst_debug);
            }
            linkedHashMap.put(str, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass7 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(!DevSupportManagerBase.this.mDevSettings.isRemoteJSDebugEnabled());
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R$string.catalyst_change_bundle_location), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass8 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    Activity currentActivity = DevSupportManagerBase.this.mReactInstanceManagerHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e("ReactNative", "Unable to launch change bundle location because react activity is not available");
                        return;
                    }
                    final EditText editText = new EditText(currentActivity);
                    editText.setHint("localhost:8081");
                    new AlertDialog.Builder(currentActivity).setTitle(DevSupportManagerBase.this.mApplicationContext.getString(R$string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                        /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass8.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            DevSupportManagerBase.this.mDevSettings.getPackagerConnectionSettings().mPreferences.edit().putString("debug_http_host", editText.getText().toString()).apply();
                            DevSupportManagerBase.this.handleReloadJS();
                        }
                    }).create().show();
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R$string.catalyst_inspector), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass9 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    DevSupportManagerBase.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerBase.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerBase.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
            if (this.mDevSettings.isHotModuleReplacementEnabled()) {
                str2 = this.mApplicationContext.getString(R$string.catalyst_hot_reloading_stop);
            } else {
                str2 = this.mApplicationContext.getString(R$string.catalyst_hot_reloading);
            }
            linkedHashMap.put(str2, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass10 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    boolean z = !DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled();
                    DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    if (DevSupportManagerBase.this.mCurrentContext != null) {
                        if (z) {
                            ((HMRClient) DevSupportManagerBase.this.mCurrentContext.getJSModule(HMRClient.class)).enable();
                        } else {
                            ((HMRClient) DevSupportManagerBase.this.mCurrentContext.getJSModule(HMRClient.class)).disable();
                        }
                    }
                    if (z && !DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled()) {
                        Toast.makeText(DevSupportManagerBase.this.mApplicationContext, DevSupportManagerBase.this.mApplicationContext.getString(R$string.catalyst_hot_reloading_auto_enable), 1).show();
                        DevSupportManagerBase.this.mDevSettings.setJSDevModeEnabled(true);
                        DevSupportManagerBase.this.handleReloadJS();
                    }
                }
            });
            if (this.mIsSamplingProfilerEnabled) {
                str3 = this.mApplicationContext.getString(R$string.catalyst_sample_profiler_disable);
            } else {
                str3 = this.mApplicationContext.getString(R$string.catalyst_sample_profiler_enable);
            }
            linkedHashMap.put(str3, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass11 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    DevSupportManagerBase.this.toggleJSSamplingProfiler();
                }
            });
            if (this.mDevSettings.isFpsDebugEnabled()) {
                str4 = this.mApplicationContext.getString(R$string.catalyst_perf_monitor_stop);
            } else {
                str4 = this.mApplicationContext.getString(R$string.catalyst_perf_monitor);
            }
            linkedHashMap.put(str4, new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass12 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    if (!DevSupportManagerBase.this.mDevSettings.isFpsDebugEnabled()) {
                        Activity currentActivity = DevSupportManagerBase.this.mReactInstanceManagerHelper.getCurrentActivity();
                        if (currentActivity == null) {
                            FLog.e("ReactNative", "Unable to get reference to react activity");
                        } else {
                            DebugOverlayController.requestPermission(currentActivity);
                        }
                    }
                    DevSupportManagerBase.this.mDevSettings.setFpsDebugEnabled(!DevSupportManagerBase.this.mDevSettings.isFpsDebugEnabled());
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R$string.catalyst_settings), new DevOptionHandler() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass13 */

                @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
                public void onOptionSelected() {
                    Intent intent = new Intent(DevSupportManagerBase.this.mApplicationContext, DevSettingsActivity.class);
                    intent.setFlags(268435456);
                    DevSupportManagerBase.this.mApplicationContext.startActivity(intent);
                }
            });
            if (this.mCustomDevOptions.size() > 0) {
                linkedHashMap.putAll(this.mCustomDevOptions);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity currentActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
            if (currentActivity == null || currentActivity.isFinishing()) {
                FLog.e("ReactNative", "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            AlertDialog create = new AlertDialog.Builder(currentActivity).setItems((CharSequence[]) linkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass15 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    devOptionHandlerArr[i].onOptionSelected();
                    DevSupportManagerBase.this.mDevOptionsDialog = null;
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass14 */

                public void onCancel(DialogInterface dialogInterface) {
                    DevSupportManagerBase.this.mDevOptionsDialog = null;
                }
            }).create();
            this.mDevOptionsDialog = create;
            create.show();
            ReactContext reactContext = this.mCurrentContext;
            if (reactContext != null) {
                ((RCTNativeAppEventEmitter) reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit("RCTDevMenuShown", null);
            }
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJavaError(String str, Throwable th) {
        FLog.e("ReactNative", "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), -1, ErrorType.NATIVE);
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void toggleElementInspector() {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass29 */

                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerBase.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerBase.this.mReactInstanceManagerHelper.toggleElementInspector();
                }
            });
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void updateJSError(final String str, final ReadableArray readableArray, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass4 */

            public void run() {
                if (DevSupportManagerBase.this.mRedBoxDialog != null && DevSupportManagerBase.this.mRedBoxDialog.isShowing() && i == DevSupportManagerBase.this.mLastErrorCookie) {
                    StackFrame[] convertJsStackTrace = StackTraceHelper.convertJsStackTrace(readableArray);
                    Pair processErrorCustomizers = DevSupportManagerBase.this.processErrorCustomizers(Pair.create(str, convertJsStackTrace));
                    DevSupportManagerBase.this.mRedBoxDialog.setExceptionDetails((String) processErrorCustomizers.first, (StackFrame[]) processErrorCustomizers.second);
                    DevSupportManagerBase.this.updateLastErrorInfo(str, convertJsStackTrace, i, ErrorType.JS);
                    if (DevSupportManagerBase.this.mRedBoxHandler != null) {
                        DevSupportManagerBase.this.mRedBoxHandler.handleRedbox(str, convertJsStackTrace, RedBoxHandler.ErrorType.JS);
                        DevSupportManagerBase.this.mRedBoxDialog.resetReporting();
                    }
                    DevSupportManagerBase.this.mRedBoxDialog.show();
                }
            }
        });
    }

    public DevSupportManagerBase(Context context, ReactInstanceManagerDevHelper reactInstanceManagerDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map) {
        this.mIsSamplingProfilerEnabled = false;
        this.mExceptionLoggers = new ArrayList();
        this.mCustomDevOptions = new LinkedHashMap<>();
        this.mDevLoadingViewVisible = false;
        this.mIsReceiverRegistered = false;
        this.mIsShakeDetectorStarted = false;
        this.mIsDevSupportEnabled = false;
        this.mLastErrorCookie = 0;
        this.mReactInstanceManagerHelper = reactInstanceManagerDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        this.mDevSettings = new DevInternalSettings(context, this);
        this.mBundleStatus = new InspectorPackagerConnection.BundleStatus();
        this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName(), new InspectorPackagerConnection.BundleStatusProvider() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass1 */

            @Override // com.facebook.react.devsupport.InspectorPackagerConnection.BundleStatusProvider
            public InspectorPackagerConnection.BundleStatus getBundleStatus() {
                return DevSupportManagerBase.this.mBundleStatus;
            }
        });
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass2 */

            @Override // com.facebook.react.common.ShakeDetector.ShakeListener
            public void onShake() {
                DevSupportManagerBase.this.showDevOptionsDialog();
            }
        }, i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new BroadcastReceiver() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass3 */

            public void onReceive(Context context, Intent intent) {
                if (DevSupportManagerBase.getReloadAppAction(context).equals(intent.getAction())) {
                    if (intent.getBooleanExtra(DevServerHelper.RELOAD_APP_EXTRA_JS_PROXY, false)) {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(true);
                        DevSupportManagerBase.this.mDevServerHelper.launchJSDevtools();
                    } else {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(false);
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                }
            }
        };
        this.mJSBundleTempFile = new File(context.getFilesDir(), JS_BUNDLE_FILE_NAME);
        this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewController = new DevLoadingViewController(context, reactInstanceManagerDevHelper);
        this.mExceptionLoggers.add(new JSExceptionLogger());
        if (!this.mDevSettings.isStartSamplingProfilerOnInit()) {
            return;
        }
        if (!this.mIsSamplingProfilerEnabled) {
            toggleJSSamplingProfiler();
        } else {
            Toast.makeText(this.mApplicationContext, "JS Sampling Profiler was already running, so did not start the sampling profiler", 1).show();
        }
    }

    public void reloadJSFromServer(String str, final BundleLoadCallback bundleLoadCallback) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        this.mDevLoadingViewController.showForUrl(str);
        this.mDevLoadingViewVisible = true;
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
            /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass25 */

            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onFailure(final Exception exc) {
                DevSupportManagerBase.this.mDevLoadingViewController.hide();
                DevSupportManagerBase.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerBase.this) {
                    DevSupportManagerBase.this.mBundleStatus.isLastDownloadSucess = Boolean.FALSE;
                }
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onFailure(exc);
                }
                FLog.e("ReactNative", "Unable to download JS bundle", exc);
                UiThreadUtil.runOnUiThread(new Runnable() {
                    /* class com.facebook.react.devsupport.DevSupportManagerBase.AnonymousClass25.AnonymousClass1 */

                    public void run() {
                        Exception exc = exc;
                        if (exc instanceof DebugServerException) {
                            DevSupportManagerBase.this.showNewJavaError(((DebugServerException) exc).getMessage(), exc);
                            return;
                        }
                        DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                        devSupportManagerBase.showNewJavaError(devSupportManagerBase.mApplicationContext.getString(R$string.catalyst_reload_error), exc);
                    }
                });
            }

            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onProgress(String str, Integer num, Integer num2) {
                DevSupportManagerBase.this.mDevLoadingViewController.updateProgress(str, num, num2);
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onProgress(str, num, num2);
                }
            }

            @Override // com.facebook.react.devsupport.interfaces.DevBundleDownloadListener
            public void onSuccess() {
                DevSupportManagerBase.this.mDevLoadingViewController.hide();
                DevSupportManagerBase.this.mDevLoadingViewVisible = false;
                synchronized (DevSupportManagerBase.this) {
                    DevSupportManagerBase.this.mBundleStatus.isLastDownloadSucess = Boolean.TRUE;
                    DevSupportManagerBase.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
                }
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onSuccess();
                }
                ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                bundleLoadCallback.onSuccess();
            }
        }, this.mJSBundleTempFile, str, bundleInfo);
    }
}
