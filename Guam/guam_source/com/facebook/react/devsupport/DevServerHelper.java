package com.facebook.react.devsupport;

import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$integer;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper {
    public static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    public static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static final String PACKAGER_OK_STATUS = "packager-status:running";
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    public final BundleDownloader mBundleDownloader;
    public InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
    public final OkHttpClient mClient;
    public InspectorPackagerConnection mInspectorPackagerConnection;
    public final String mPackageName;
    public JSPackagerClient mPackagerClient;
    public final DevInternalSettings mSettings;

    public enum BundleType {
        BUNDLE("bundle"),
        MAP("map");
        
        public final String mTypeID;

        /* access modifiers changed from: public */
        BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    public interface PackagerCustomCommandProvider {
    }

    public interface SymbolicationListener {
        void onSymbolicationComplete(Iterable<StackFrame> iterable);
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, String str, InspectorPackagerConnection.BundleStatusProvider bundleStatusProvider) {
        this.mSettings = devInternalSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).build();
        this.mClient = build;
        this.mBundleDownloader = new BundleDownloader(build);
        this.mPackageName = str;
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return String.format(Locale.US, "http://%s/%s.%s?platform=android&dev=%s&minify=%s", str2, str, bundleType.typeID(), Boolean.valueOf(getDevMode()), Boolean.valueOf(getJSMinifyMode()));
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public static String createOpenStackFrameURL(String str) {
        return String.format(Locale.US, "http://%s/open-stack-frame", str);
    }

    public static String createPackagerStatusURL(String str) {
        return String.format(Locale.US, "http://%s/status", str);
    }

    public static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", str, str2);
    }

    public static String createSymbolicateURL(String str) {
        return String.format(Locale.US, "http://%s/symbolicate", str);
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private String getHostForJSProxy() {
        String debugServerHost = this.mSettings.getPackagerConnectionSettings().getDebugServerHost();
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(debugServerHost);
        String str = debugServerHost;
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf <= -1) {
            return "localhost";
        }
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("localhost");
        outline15.append(str.substring(lastIndexOf));
        return outline15.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", AndroidInfoHelpers.getServerIpAddress(Integer.valueOf(this.mSettings.getPackagerConnectionSettings().mAppContext.getResources().getInteger(R$integer.react_native_dev_server_port)).intValue()), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName);
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    public void closeInspectorConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass4 */

            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                    DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                    DevServerHelper.this.mInspectorPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass2 */

            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mPackagerClient != null) {
                    ReconnectingWebSocket reconnectingWebSocket = DevServerHelper.this.mPackagerClient.mWebSocket;
                    reconnectingWebSocket.mClosed = true;
                    WebSocket webSocket = reconnectingWebSocket.mWebSocket;
                    if (webSocket != null) {
                        try {
                            webSocket.close(1000, "End of session");
                        } catch (Exception unused) {
                        }
                        reconnectingWebSocket.mWebSocket = null;
                    }
                    reconnectingWebSocket.mMessageCallback = null;
                    ReconnectingWebSocket.ConnectionCallback connectionCallback = reconnectingWebSocket.mConnectionCallback;
                    if (connectionCallback != null) {
                        connectionCallback.onDisconnected();
                    }
                    DevServerHelper.this.mPackagerClient = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void disableDebugger() {
        InspectorPackagerConnection inspectorPackagerConnection = this.mInspectorPackagerConnection;
        if (inspectorPackagerConnection != null) {
            inspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008a, code lost:
        if (r0 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
        throw r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    public File downloadBundleResourceFromUrlSync(String str, File file) {
        Throwable th;
        Sink sink;
        try {
            Response execute = this.mClient.newCall(new Request.Builder().url(createResourceURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost(), str)).build()).execute();
            if (!execute.isSuccessful()) {
                execute.close();
                return null;
            }
            try {
                sink = Okio.sink(file);
                try {
                    BufferedSource source = execute.body().source();
                    Buffer buffer = new Buffer();
                    if (source != null) {
                        while (source.read(buffer, 8192) != -1) {
                            long completeSegmentByteCount = buffer.completeSegmentByteCount();
                            if (completeSegmentByteCount > 0) {
                                sink.write(buffer, completeSegmentByteCount);
                            }
                        }
                        long j = buffer.size;
                        if (j > 0) {
                            sink.write(buffer, j);
                        }
                        r1.close();
                        execute.close();
                        return file;
                    }
                    throw new NullPointerException("source == null");
                } catch (Throwable th2) {
                    th = th2;
                    if (sink != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sink = null;
                if (sink != null) {
                    r1.close();
                }
                throw th;
            }
        } catch (Exception e) {
            FLog.e("ReactNative", "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\"", str, file.getAbsolutePath(), e);
            return null;
        }
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, BundleType.BUNDLE, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, BundleType.BUNDLE);
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        this.mClient.newCall(new Request.Builder().url(createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).build()).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass7 */

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("The packager does not seem to be running as we got an IOException requesting its status: ");
                outline15.append(iOException.getMessage());
                FLog.w("ReactNative", outline15.toString());
                packagerStatusCallback.onPackagerStatusFetched(false);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Got non-success http code from packager when requesting status: ");
                    outline15.append(response.code());
                    FLog.e("ReactNative", outline15.toString());
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                ResponseBody body = response.body();
                if (body == null) {
                    FLog.e("ReactNative", "Got null body response from packager when requesting status");
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                String string = body.string();
                if (!DevServerHelper.PACKAGER_OK_STATUS.equals(string)) {
                    FLog.e("ReactNative", "Got unexpected response from packager when requesting status: " + string);
                    packagerStatusCallback.onPackagerStatusFetched(false);
                    return;
                }
                packagerStatusCallback.onPackagerStatusFetched(true);
            }
        });
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass8 */

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.w("ReactNative", "Inspector connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass3 */

                public Void doInBackground(Void... voidArr) {
                    DevServerHelper devServerHelper = DevServerHelper.this;
                    devServerHelper.mInspectorPackagerConnection = new InspectorPackagerConnection(devServerHelper.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
                    DevServerHelper.this.mInspectorPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.w("ReactNative", "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1 */

                public Void doInBackground(Void... voidArr) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reload", new NotificationOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass1 */

                        @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerReloadCommand();
                        }
                    });
                    hashMap.put("devMenu", new NotificationOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass2 */

                        @Override // com.facebook.react.packagerconnection.NotificationOnlyHandler, com.facebook.react.packagerconnection.RequestHandler
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerDevMenuCommand();
                        }
                    });
                    hashMap.put("captureHeap", new RequestOnlyHandler() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass3 */

                        @Override // com.facebook.react.packagerconnection.RequestHandler, com.facebook.react.packagerconnection.RequestOnlyHandler
                        public void onRequest(Object obj, Responder responder) {
                            packagerCommandListener.onCaptureHeapCommand(responder);
                        }
                    });
                    Map<String, RequestHandler> customCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (customCommandHandlers != null) {
                        hashMap.putAll(customCommandHandlers);
                    }
                    hashMap.putAll(new FileIoHandler().mRequestHandlers);
                    AnonymousClass4 r0 = new ReconnectingWebSocket.ConnectionCallback() {
                        /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass1.AnonymousClass4 */

                        @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                        public void onConnected() {
                            packagerCommandListener.onPackagerConnected();
                        }

                        @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback
                        public void onDisconnected() {
                            packagerCommandListener.onPackagerDisconnected();
                        }
                    };
                    DevServerHelper devServerHelper = DevServerHelper.this;
                    devServerHelper.mPackagerClient = new JSPackagerClient(str, devServerHelper.mSettings.getPackagerConnectionSettings(), hashMap, r0);
                    DevServerHelper.this.mPackagerClient.mWebSocket.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void openStackFrameCall(StackFrame stackFrame) {
        Call newCall = this.mClient.newCall(new Request.Builder().url(createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).post(RequestBody.create(MediaType.parse("application/json"), stackFrame.toJSON().toString())).build());
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(newCall);
        newCall.enqueue(new Callback() {
            /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass6 */

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Got IOException when attempting to open stack frame: ");
                outline15.append(iOException.getMessage());
                FLog.w("ReactNative", outline15.toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public void symbolicateStackTrace(Iterable<StackFrame> iterable, final SymbolicationListener symbolicationListener) {
        try {
            String createSymbolicateURL = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
            JSONArray jSONArray = new JSONArray();
            for (StackFrame stackFrame : iterable) {
                jSONArray.put(stackFrame.toJSON());
            }
            Call newCall = this.mClient.newCall(new Request.Builder().url(createSymbolicateURL).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", jSONArray).toString())).build());
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(newCall);
            newCall.enqueue(new Callback() {
                /* class com.facebook.react.devsupport.DevServerHelper.AnonymousClass5 */

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Got IOException when attempting symbolicate stack trace: ");
                    outline15.append(iOException.getMessage());
                    FLog.w("ReactNative", outline15.toString());
                    symbolicationListener.onSymbolicationComplete(null);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        symbolicationListener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(response.body().string()).getJSONArray("stack"))));
                    } catch (JSONException unused) {
                        symbolicationListener.onSymbolicationComplete(null);
                    }
                }
            });
        } catch (JSONException e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Got JSONException when attempting symbolicate stack trace: ");
            outline15.append(e.getMessage());
            FLog.w("ReactNative", outline15.toString());
        }
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, builder);
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }
}
