package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bugsnag.android.BugsnagReactNative;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.RNCWebViewModule;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    public static final String BLANK_URL = "about:blank";
    public static final int COMMAND_CLEAR_CACHE = 1001;
    public static final int COMMAND_CLEAR_FORM_DATA = 1000;
    public static final int COMMAND_CLEAR_HISTORY = 1002;
    public static final int COMMAND_FOCUS = 8;
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_LOAD_URL = 7;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    public static final String HTML_ENCODING = "UTF-8";
    public static final String HTML_MIME_TYPE = "text/html";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    public static final String REACT_CLASS = "RNCWebView";
    public static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    public static final String TAG = "RNCWebViewManager";
    public boolean mAllowsFullscreenVideo;
    public String mUserAgent;
    public String mUserAgentWithApplicationName;
    public RNCWebChromeClient mWebChromeClient;
    public WebViewConfig mWebViewConfig;

    public static class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
        public static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
        public WebChromeClient.CustomViewCallback mCustomViewCallback;
        public ReactContext mReactContext;
        public View mVideoView;
        public View mWebView;
        public RNCWebView.ProgressChangedFilter progressChangedFilter = null;

        public RNCWebChromeClient(ReactContext reactContext, WebView webView) {
            this.mReactContext = reactContext;
            this.mWebView = webView;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebView.WebViewTransport) message.obj).setWebView(new WebView(webView.getContext()));
            message.sendToTarget();
            return true;
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostDestroy() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
            View view = this.mVideoView;
            if (view != null && view.getSystemUiVisibility() != 7942) {
                this.mVideoView.setSystemUiVisibility(7942);
            }
        }

        @TargetApi(21)
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            String[] resources = permissionRequest.getResources();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < resources.length; i++) {
                if (resources[i].equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    arrayList.add("android.permission.RECORD_AUDIO");
                } else if (resources[i].equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    arrayList.add("android.permission.CAMERA");
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (ContextCompat.checkSelfPermission(this.mReactContext, (String) arrayList.get(i2)) == 0) {
                    if (((String) arrayList.get(i2)).equals("android.permission.RECORD_AUDIO")) {
                        arrayList2.add("android.webkit.resource.AUDIO_CAPTURE");
                    } else if (((String) arrayList.get(i2)).equals("android.permission.CAMERA")) {
                        arrayList2.add("android.webkit.resource.VIDEO_CAPTURE");
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                permissionRequest.deny();
            } else {
                permissionRequest.grant((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            String url = webView.getUrl();
            if (!this.progressChangedFilter.waitingForCommandLoadUrl) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("target", (double) webView.getId());
                createMap.putString(DialogModule.KEY_TITLE, webView.getTitle());
                createMap.putString("url", url);
                createMap.putBoolean("canGoBack", webView.canGoBack());
                createMap.putBoolean("canGoForward", webView.canGoForward());
                createMap.putDouble(ReactProgressBarViewManager.PROP_PROGRESS, (double) (((float) i) / 100.0f));
                RNCWebViewManager.dispatchEvent(webView, new TopLoadingProgressEvent(webView.getId(), createMap));
            }
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            boolean z = true;
            if (fileChooserParams.getMode() != 1) {
                z = false;
            }
            return RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, acceptTypes, z);
        }
    }

    public static class RNCWebView extends WebView implements LifecycleEventListener {
        public boolean hasScrollEvent = false;
        public String injectedJS;
        public String injectedJSBeforeContentLoaded;
        public CatalystInstance mCatalystInstance;
        public OnScrollDispatchHelper mOnScrollDispatchHelper;
        public RNCWebViewClient mRNCWebViewClient;
        public WebChromeClient mWebChromeClient;
        public boolean messagingEnabled = false;
        public String messagingModuleName;
        public ProgressChangedFilter progressChangedFilter;
        public boolean sendContentSizeChangeEvents = false;

        public static class ProgressChangedFilter {
            public boolean waitingForCommandLoadUrl = false;
        }

        public class RNCWebViewBridge {
            public RNCWebView mContext;

            public RNCWebViewBridge(RNCWebView rNCWebView) {
                this.mContext = rNCWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                RNCWebView rNCWebView = this.mContext;
                ReactContext reactContext = (ReactContext) rNCWebView.getContext();
                if (rNCWebView.mRNCWebViewClient != null) {
                    rNCWebView.post(new Runnable(rNCWebView, str, rNCWebView) {
                        /* class com.reactnativecommunity.webview.RNCWebViewManager.RNCWebView.AnonymousClass1 */
                        public final /* synthetic */ RNCWebView val$mContext;
                        public final /* synthetic */ String val$message;
                        public final /* synthetic */ WebView val$webView;

                        {
                            this.val$webView = r2;
                            this.val$message = r3;
                            this.val$mContext = r4;
                        }

                        public void run() {
                            RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                            if (rNCWebViewClient != null) {
                                WebView webView = this.val$webView;
                                WritableMap createWebViewEvent = rNCWebViewClient.createWebViewEvent(webView, webView.getUrl());
                                createWebViewEvent.putString(BugsnagReactNative.DATA_KEY, this.val$message);
                                if (RNCWebView.this.mCatalystInstance != null) {
                                    this.val$mContext.sendDirectMessage("onMessage", createWebViewEvent);
                                    return;
                                }
                                WebView webView2 = this.val$webView;
                                RNCWebViewManager.dispatchEvent(webView2, new TopMessageEvent(webView2.getId(), createWebViewEvent));
                            }
                        }
                    });
                    return;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString(BugsnagReactNative.DATA_KEY, str);
                if (rNCWebView.mCatalystInstance != null) {
                    rNCWebView.sendDirectMessage("onMessage", createMap);
                } else {
                    RNCWebViewManager.dispatchEvent(rNCWebView, new TopMessageEvent(rNCWebView.getId(), createMap));
                }
            }
        }

        public RNCWebView(ThemedReactContext themedReactContext) {
            super(themedReactContext);
            ReactContext reactContext = (ReactContext) getContext();
            if (reactContext != null) {
                this.mCatalystInstance = reactContext.getCatalystInstance();
            }
            this.progressChangedFilter = new ProgressChangedFilter();
        }

        public void destroy() {
            WebChromeClient webChromeClient = this.mWebChromeClient;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
            super.destroy();
        }

        public RNCWebViewClient getRNCWebViewClient() {
            return this.mRNCWebViewClient;
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostDestroy() {
            setWebViewClient(null);
            destroy();
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostPause() {
        }

        @Override // com.facebook.react.bridge.LifecycleEventListener
        public void onHostResume() {
        }

        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.hasScrollEvent) {
                if (this.mOnScrollDispatchHelper == null) {
                    this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
                }
                if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                    int id = getId();
                    ScrollEventType scrollEventType = ScrollEventType.SCROLL;
                    OnScrollDispatchHelper onScrollDispatchHelper = this.mOnScrollDispatchHelper;
                    RNCWebViewManager.dispatchEvent(this, ScrollEvent.obtain(id, scrollEventType, i, i2, onScrollDispatchHelper.mXFlingVelocity, onScrollDispatchHelper.mYFlingVelocity, computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
                }
            }
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.sendContentSizeChangeEvents) {
                RNCWebViewManager.dispatchEvent(this, new ContentSizeChangeEvent(getId(), i, i2));
            }
        }

        public void sendDirectMessage(String str, WritableMap writableMap) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putMap("nativeEvent", writableMap);
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.pushMap(writableNativeMap);
            this.mCatalystInstance.callFunction(this.messagingModuleName, str, writableNativeArray);
        }

        public void setHasScrollEvent(boolean z) {
            this.hasScrollEvent = z;
        }

        public void setIgnoreErrFailedForThisURL(String str) {
            this.mRNCWebViewClient.ignoreErrFailedForThisURL = str;
        }

        public void setInjectedJavaScript(String str) {
            this.injectedJS = str;
        }

        public void setInjectedJavaScriptBeforeContentLoaded(String str) {
            this.injectedJSBeforeContentLoaded = str;
        }

        public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(boolean z) {
        }

        public void setInjectedJavaScriptForMainFrameOnly(boolean z) {
        }

        @SuppressLint({"AddJavascriptInterface"})
        public void setMessagingEnabled(boolean z) {
            if (this.messagingEnabled != z) {
                this.messagingEnabled = z;
                if (z) {
                    addJavascriptInterface(new RNCWebViewBridge(this), RNCWebViewManager.JAVASCRIPT_INTERFACE);
                } else {
                    removeJavascriptInterface(RNCWebViewManager.JAVASCRIPT_INTERFACE);
                }
            }
        }

        public void setMessagingModuleName(String str) {
            this.messagingModuleName = str;
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.sendContentSizeChangeEvents = z;
        }

        public void setWebChromeClient(WebChromeClient webChromeClient) {
            this.mWebChromeClient = webChromeClient;
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof RNCWebChromeClient) {
                ((RNCWebChromeClient) webChromeClient).progressChangedFilter = this.progressChangedFilter;
            }
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            if (webViewClient instanceof RNCWebViewClient) {
                RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
                this.mRNCWebViewClient = rNCWebViewClient;
                rNCWebViewClient.progressChangedFilter = this.progressChangedFilter;
            }
        }
    }

    public RNCWebViewManager() {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = new WebViewConfig(this) {
            /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass1 */
        };
    }

    public static void dispatchEvent(WebView webView, Event event) {
        ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
    }

    public static RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }

    public RNCWebView createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        return new RNCWebView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("goBack", 1);
        builder.put("goForward", 2);
        builder.put("reload", 3);
        builder.put("stopLoading", 4);
        builder.put("postMessage", 5);
        builder.put("injectJavaScript", 6);
        builder.put("loadUrl", 7);
        builder.put("requestFocus", 8);
        builder.put("clearFormData", Integer.valueOf((int) COMMAND_CLEAR_FORM_DATA));
        builder.put("clearCache", 1001);
        builder.put("clearHistory", Integer.valueOf((int) COMMAND_CLEAR_HISTORY));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.put("topLoadingProgress", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put("topShouldStartLoadWithRequest", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put("topHttpError", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put("topRenderProcessGone", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onRenderProcessGone"));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return "RNCWebView";
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        webView.getSettings().setAllowFileAccess(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(WebView webView, Boolean bool) {
        this.mAllowsFullscreenVideo = bool != null && bool.booleanValue();
        setupWebChromeClient((ReactContext) webView.getContext(), webView);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgentWithApplicationName = GeneratedOutlineSupport.outline11(WebSettings.getDefaultUserAgent(webView.getContext()), " ", str);
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(webView);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            Context context = webView.getContext();
            if (context != null) {
                webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @ReactProp(name = "cacheMode")
    public void setCacheMode(WebView webView, String str) {
        boolean z;
        Integer num;
        switch (str.hashCode()) {
            case -2059164003:
                if (str.equals("LOAD_NO_CACHE")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1215135800:
                if (str.equals("LOAD_DEFAULT")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -873877826:
                if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1548620642:
                if (str.equals("LOAD_CACHE_ONLY")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            num = 3;
        } else if (z) {
            num = 1;
        } else if (!z) {
            num = -1;
        } else {
            num = 2;
        }
        webView.getSettings().setCacheMode(num.intValue());
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView.getSettings().setGeolocationEnabled(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(1, null);
        }
    }

    @ReactProp(name = "incognito")
    public void setIncognito(WebView webView, boolean z) {
        if (z) {
            CookieManager.getInstance().removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            webView.getSettings().setAppCacheEnabled(false);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoaded(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(z);
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptForMainFrameOnly(z);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    @ReactProp(name = "androidLayerType")
    public void setLayerType(WebView webView, String str) {
        char c;
        int hashCode = str.hashCode();
        int i = 0;
        if (hashCode != 116909544) {
            if (hashCode == 1319330215 && str.equals("software")) {
                c = 1;
                if (c == 0) {
                    i = 2;
                } else if (c == 1) {
                    i = 1;
                }
                webView.setLayerType(i, null);
            }
        } else if (str.equals("hardware")) {
            c = 0;
            if (c == 0) {
            }
            webView.setLayerType(i, null);
        }
        c = 65535;
        if (c == 0) {
        }
        webView.setLayerType(i, null);
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    @TargetApi(17)
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((RNCWebView) webView).setMessagingEnabled(z);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(WebView webView, String str) {
        ((RNCWebView) webView).setMessagingModuleName(str);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (str == null || "never".equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if ("always".equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((RNCWebView) webView).setSendContentSizeChangeEvents(z);
    }

    @ReactProp(name = "onScroll")
    public void setOnScroll(WebView webView, boolean z) {
        ((RNCWebView) webView).setHasScrollEvent(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(WebView webView, String str) {
        char c;
        Integer num;
        int hashCode = str.hashCode();
        if (hashCode != -1414557169) {
            if (hashCode != 104712844) {
                if (hashCode == 951530617 && str.equals("content")) {
                    c = 1;
                    if (c != 0) {
                        num = 2;
                    } else if (c != 1) {
                        num = 0;
                    } else {
                        num = 1;
                    }
                    webView.setOverScrollMode(num.intValue());
                }
            } else if (str.equals("never")) {
                c = 0;
                if (c != 0) {
                }
                webView.setOverScrollMode(num.intValue());
            }
        } else if (str.equals("always")) {
            c = 2;
            if (c != 0) {
            }
            webView.setOverScrollMode(num.intValue());
        }
        c = 65535;
        if (c != 0) {
        }
        webView.setOverScrollMode(num.intValue());
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "source")
    public void setSource(WebView webView, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                webView.loadDataWithBaseURL(readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "", readableMap.getString("html"), HTML_MIME_TYPE, HTML_ENCODING, null);
                return;
            } else if (readableMap.hasKey(NetworkingModule.REQUEST_BODY_KEY_URI)) {
                String string = readableMap.getString(NetworkingModule.REQUEST_BODY_KEY_URI);
                String url = webView.getUrl();
                if (url != null && url.equals(string)) {
                    return;
                }
                if (!readableMap.hasKey("method") || !readableMap.getString("method").equalsIgnoreCase(HTTP_METHOD_POST)) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        ReadableMap map = readableMap.getMap("headers");
                        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            if (!NetworkingModule.USER_AGENT_HEADER_NAME.equals(nextKey.toLowerCase(Locale.ENGLISH))) {
                                hashMap.put(nextKey, map.getString(nextKey));
                            } else if (webView.getSettings() != null) {
                                webView.getSettings().setUserAgentString(map.getString(nextKey));
                            }
                        }
                    }
                    webView.loadUrl(string, hashMap);
                    return;
                }
                byte[] bArr = null;
                if (readableMap.hasKey("body")) {
                    String string2 = readableMap.getString("body");
                    try {
                        bArr = string2.getBytes(HTML_ENCODING);
                    } catch (UnsupportedEncodingException unused) {
                        bArr = string2.getBytes();
                    }
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                webView.postUrl(string, bArr);
                return;
            }
        }
        webView.loadUrl(BLANK_URL);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSupportMultipleWindows(WebView webView, boolean z) {
        webView.getSettings().setSupportMultipleWindows(z);
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(WebView webView, int i) {
        webView.getSettings().setTextZoom(i);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
    }

    @ReactProp(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        ((RNCWebView) webView).getRNCWebViewClient();
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgent = str;
        } else {
            this.mUserAgent = null;
        }
        setUserAgentString(webView);
    }

    public void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public void setupWebChromeClient(ReactContext reactContext, WebView webView) {
        if (this.mAllowsFullscreenVideo) {
            final int requestedOrientation = reactContext.getCurrentActivity().getRequestedOrientation();
            AnonymousClass3 r1 = new RNCWebChromeClient(this, reactContext, webView) {
                /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass3 */

                public Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
                }

                public void onHideCustomView() {
                    View view = this.mVideoView;
                    if (view != null) {
                        view.setVisibility(8);
                        ((ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290)).removeView(this.mVideoView);
                        this.mCustomViewCallback.onCustomViewHidden();
                        this.mVideoView = null;
                        this.mCustomViewCallback = null;
                        this.mWebView.setVisibility(0);
                        this.mReactContext.getCurrentActivity().getWindow().clearFlags(512);
                        this.mReactContext.getCurrentActivity().setRequestedOrientation(requestedOrientation);
                        this.mReactContext.removeLifecycleEventListener(this);
                    }
                }

                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    if (this.mVideoView != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.mVideoView = view;
                    this.mCustomViewCallback = customViewCallback;
                    this.mReactContext.getCurrentActivity().setRequestedOrientation(-1);
                    this.mVideoView.setSystemUiVisibility(7942);
                    this.mReactContext.getCurrentActivity().getWindow().setFlags(512, 512);
                    this.mVideoView.setBackgroundColor(-16777216);
                    ((ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290)).addView(this.mVideoView, RNCWebChromeClient.FULLSCREEN_LAYOUT_PARAMS);
                    this.mWebView.setVisibility(8);
                    this.mReactContext.addLifecycleEventListener(this);
                }
            };
            this.mWebChromeClient = r1;
            webView.setWebChromeClient(r1);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient = this.mWebChromeClient;
        if (rNCWebChromeClient != null) {
            rNCWebChromeClient.onHideCustomView();
        }
        AnonymousClass4 r0 = new RNCWebChromeClient(this, reactContext, webView) {
            /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass4 */

            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
            }
        };
        this.mWebChromeClient = r0;
        webView.setWebChromeClient(r0);
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new RNCWebViewClient());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @TargetApi(21)
    public WebView createViewInstance(final ThemedReactContext themedReactContext) {
        final RNCWebView createRNCWebViewInstance = createRNCWebViewInstance(themedReactContext);
        setupWebChromeClient(themedReactContext, createRNCWebViewInstance);
        themedReactContext.mReactApplicationContext.addLifecycleEventListener(createRNCWebViewInstance);
        if (((AnonymousClass1) this.mWebViewConfig) != null) {
            WebSettings settings = createRNCWebViewInstance.getSettings();
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setDomStorageEnabled(true);
            settings.setSupportMultipleWindows(true);
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
            setMixedContentMode(createRNCWebViewInstance, "never");
            createRNCWebViewInstance.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            createRNCWebViewInstance.setDownloadListener(new DownloadListener(this) {
                /* class com.reactnativecommunity.webview.RNCWebViewManager.AnonymousClass2 */

                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    createRNCWebViewInstance.setIgnoreErrFailedForThisURL(str);
                    RNCWebViewModule module = RNCWebViewManager.getModule(themedReactContext);
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                    String guessFileName = URLUtil.guessFileName(str, str3, str4);
                    String outline10 = GeneratedOutlineSupport.outline10("Downloading ", guessFileName);
                    try {
                        URL url = new URL(str);
                        request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
                    } catch (MalformedURLException e) {
                        PrintStream printStream = System.out;
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Error getting cookie for DownloadManager: ");
                        outline17.append(e.toString());
                        printStream.println(outline17.toString());
                        e.printStackTrace();
                    }
                    request.addRequestHeader("User-Agent", str2);
                    request.setTitle(guessFileName);
                    request.setDescription(outline10);
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
                    module.setDownloadRequest(request);
                    if (module.grantFileDownloaderPermissions()) {
                        module.downloadFile();
                    }
                }
            });
            return createRNCWebViewInstance;
        }
        throw null;
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance((View) webView);
        RNCWebView rNCWebView = (RNCWebView) webView;
        ((ThemedReactContext) webView.getContext()).mReactApplicationContext.removeLifecycleEventListener(rNCWebView);
        rNCWebView.setWebViewClient(null);
        rNCWebView.destroy();
        this.mWebChromeClient = null;
    }

    public void receiveCommand(WebView webView, int i, ReadableArray readableArray) {
        boolean z = false;
        switch (i) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BugsnagReactNative.DATA_KEY, readableArray.getString(0));
                    ((RNCWebView) webView).evaluateJavascript("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();", null);
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            case 6:
                ((RNCWebView) webView).evaluateJavascript(readableArray.getString(0), null);
                return;
            case 7:
                if (readableArray != null) {
                    ((RNCWebView) webView).progressChangedFilter.waitingForCommandLoadUrl = false;
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            case 8:
                webView.requestFocus();
                return;
            default:
                switch (i) {
                    case COMMAND_CLEAR_FORM_DATA /*{ENCODED_INT: 1000}*/:
                        webView.clearFormData();
                        return;
                    case 1001:
                        if (readableArray != null && readableArray.getBoolean(0)) {
                            z = true;
                        }
                        webView.clearCache(z);
                        return;
                    case COMMAND_CLEAR_HISTORY /*{ENCODED_INT: 1002}*/:
                        webView.clearHistory();
                        return;
                    default:
                        return;
                }
        }
    }

    public RNCWebViewManager(WebViewConfig webViewConfig) {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = webViewConfig;
    }

    public static class RNCWebViewClient extends WebViewClient {
        public String ignoreErrFailedForThisURL = null;
        public boolean mLastLoadFailed = false;
        public RNCWebView.ProgressChangedFilter progressChangedFilter = null;

        public WritableMap createWebViewEvent(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", (double) webView.getId());
            createMap.putString("url", str);
            createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
            createMap.putString(DialogModule.KEY_TITLE, webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        public void onPageFinished(WebView webView, String str) {
            String str2;
            super.onPageFinished(webView, str);
            if (!this.mLastLoadFailed) {
                RNCWebView rNCWebView = (RNCWebView) webView;
                if (rNCWebView.getSettings().getJavaScriptEnabled() && (str2 = rNCWebView.injectedJS) != null && !TextUtils.isEmpty(str2)) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("(function() {\n");
                    outline17.append(rNCWebView.injectedJS);
                    outline17.append(";\n})();");
                    rNCWebView.evaluateJavascript(outline17.toString(), null);
                }
                RNCWebViewManager.dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            String str2;
            super.onPageStarted(webView, str, bitmap);
            this.mLastLoadFailed = false;
            RNCWebView rNCWebView = (RNCWebView) webView;
            if (rNCWebView.getSettings().getJavaScriptEnabled() && (str2 = rNCWebView.injectedJSBeforeContentLoaded) != null && !TextUtils.isEmpty(str2)) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("(function() {\n");
                outline17.append(rNCWebView.injectedJSBeforeContentLoaded);
                outline17.append(";\n})();");
                rNCWebView.evaluateJavascript(outline17.toString(), null);
            }
            RNCWebViewManager.dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = this.ignoreErrFailedForThisURL;
            if (str3 == null || !str2.equals(str3) || i != -1 || !str.equals("net::ERR_FAILED")) {
                super.onReceivedError(webView, i, str, str2);
                this.mLastLoadFailed = true;
                RNCWebViewManager.dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str2)));
                WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
                createWebViewEvent.putDouble(PromiseImpl.ERROR_MAP_KEY_CODE, (double) i);
                createWebViewEvent.putString("description", str);
                RNCWebViewManager.dispatchEvent(webView, new TopLoadingErrorEvent(webView.getId(), createWebViewEvent));
                return;
            }
            this.ignoreErrFailedForThisURL = null;
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
                createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
                createWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
                RNCWebViewManager.dispatchEvent(webView, new TopHttpErrorEvent(webView.getId(), createWebViewEvent));
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String url = webView.getUrl();
            String url2 = sslError.getUrl();
            sslErrorHandler.cancel();
            if (!url.equalsIgnoreCase(url2)) {
                Log.w(RNCWebViewManager.TAG, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
                return;
            }
            int primaryError = sslError.getPrimaryError();
            onReceivedError(webView, primaryError, GeneratedOutlineSupport.outline10("SSL error: ", primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid"), url2);
        }

        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (renderProcessGoneDetail.didCrash()) {
                Log.e(RNCWebViewManager.TAG, "The WebView rendering process crashed.");
            } else {
                Log.w(RNCWebViewManager.TAG, "The WebView rendering process was killed by the system.");
            }
            if (webView == null) {
                return true;
            }
            WritableMap createWebViewEvent = createWebViewEvent(webView, webView.getUrl());
            createWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
            RNCWebViewManager.dispatchEvent(webView, new TopRenderProcessGoneEvent(webView.getId(), createWebViewEvent));
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
            if (r6.get() != com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0089, code lost:
            com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock.removeLock(java.lang.Integer.valueOf(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0092, code lost:
            return r3;
         */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AtomicReference<RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState> atomicReference;
            Integer valueOf;
            RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState shouldOverrideCallbackState = RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED;
            RNCWebView rNCWebView = (RNCWebView) webView;
            boolean z = true;
            if ((((ReactContext) webView.getContext()).getJavaScriptContextHolder().get() == 0) || rNCWebView.mCatalystInstance == null) {
                FLog.w(RNCWebViewManager.TAG, "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load.");
                this.progressChangedFilter.waitingForCommandLoadUrl = true;
                RNCWebViewManager.dispatchEvent(webView, new TopShouldStartLoadWithRequestEvent(webView.getId(), createWebViewEvent(webView, str)));
                return true;
            }
            RNCWebViewModule.ShouldOverrideUrlLoadingLock shouldOverrideUrlLoadingLock = RNCWebViewModule.shouldOverrideUrlLoadingLock;
            synchronized (shouldOverrideUrlLoadingLock) {
                int i = shouldOverrideUrlLoadingLock.nextLockIdentifier;
                shouldOverrideUrlLoadingLock.nextLockIdentifier = i + 1;
                atomicReference = new AtomicReference<>(shouldOverrideCallbackState);
                shouldOverrideUrlLoadingLock.shouldOverrideLocks.put(Integer.valueOf(i), atomicReference);
                valueOf = Integer.valueOf(i);
            }
            int intValue = valueOf.intValue();
            WritableMap createWebViewEvent = createWebViewEvent(webView, str);
            createWebViewEvent.putInt("lockIdentifier", intValue);
            rNCWebView.sendDirectMessage("onShouldStartLoadWithRequest", createWebViewEvent);
            try {
                synchronized (atomicReference) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    while (atomicReference.get() == shouldOverrideCallbackState) {
                        if (SystemClock.elapsedRealtime() - elapsedRealtime > 250) {
                            FLog.w(RNCWebViewManager.TAG, "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading.");
                            RNCWebViewModule.shouldOverrideUrlLoadingLock.removeLock(Integer.valueOf(intValue));
                            return false;
                        }
                        atomicReference.wait(250);
                    }
                }
            } catch (InterruptedException e) {
                FLog.e(RNCWebViewManager.TAG, "shouldOverrideUrlLoading was interrupted while waiting for result.", e);
                RNCWebViewModule.shouldOverrideUrlLoadingLock.removeLock(Integer.valueOf(intValue));
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }
    }
}
