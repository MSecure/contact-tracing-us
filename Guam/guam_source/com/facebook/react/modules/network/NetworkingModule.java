package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.CookieManager;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.StandardCharsets;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.GzipSource;
import okio.RealBufferedSource;

@ReactModule(name = NetworkingModule.NAME)
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    public static final int CHUNK_TIMEOUT_NS = 100000000;
    public static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    public static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    public static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    public static final String REQUEST_BODY_KEY_BASE64 = "base64";
    public static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    public static final String REQUEST_BODY_KEY_STRING = "string";
    public static final String REQUEST_BODY_KEY_URI = "uri";
    public static final String TAG = "NetworkingModule";
    public static final String USER_AGENT_HEADER_NAME = "user-agent";
    public static CustomClientBuilder customClientBuilder;
    public final OkHttpClient mClient;
    public final ForwardingCookieHandler mCookieHandler;
    public final CookieJarContainer mCookieJarContainer;
    public final String mDefaultUserAgent;
    public final List<RequestBodyHandler> mRequestBodyHandlers;
    public final Set<Integer> mRequestIds;
    public final List<ResponseHandler> mResponseHandlers;
    public boolean mShuttingDown;
    public final List<UriHandler> mUriHandlers;

    public interface CustomClientBuilder {
        void apply(OkHttpClient.Builder builder);
    }

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        RequestBody toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ResponseBody responseBody) throws IOException;
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri) throws IOException;

        boolean supports(Uri uri, String str);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient, List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            for (NetworkInterceptorCreator networkInterceptorCreator : list) {
                newBuilder.addNetworkInterceptor(networkInterceptorCreator.create());
            }
            okHttpClient = newBuilder.build();
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    public static void applyCustomBuilder(OkHttpClient.Builder builder) {
        CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply(builder);
        }
    }

    private synchronized void cancelAllRequests() {
        for (Integer num : this.mRequestIds) {
            cancelRequest(num.intValue());
        }
        this.mRequestIds.clear();
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                OkHttpClient okHttpClient = NetworkingModule.this.mClient;
                Integer valueOf = Integer.valueOf(i);
                for (Call call : okHttpClient.dispatcher().queuedCalls()) {
                    if (valueOf.equals(call.request().tag())) {
                        call.cancel();
                        return;
                    }
                }
                for (Call call2 : okHttpClient.dispatcher().runningCalls()) {
                    if (valueOf.equals(call2.request().tag())) {
                        call2.cancel();
                        return;
                    }
                }
            }
        }.execute(new Void[0]);
    }

    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i) {
        MediaType mediaType;
        DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("constructMultipartBody");
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), null);
            if (extractHeaders == null) {
                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Unrecognized FormData part.", null);
            } else if (mediaType == null) {
                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", null);
                return null;
            } else {
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream fileInputStream = AppCompatDelegateImpl.ConfigurationImplApi17.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + string, null);
                    return null;
                }
                builder.addPart(extractHeaders, new RequestBodyUtil$1(mediaType, fileInputStream));
            }
        }
        return builder;
    }

    private Headers extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            ReadableArray array = readableArray.getArray(i2);
            if (array != null && array.size() == 2) {
                String string = array.getString(i);
                StringBuilder sb = new StringBuilder(string.length());
                int length = string.length();
                int i3 = i;
                int i4 = i3;
                while (i3 < length) {
                    char charAt = string.charAt(i3);
                    if (charAt <= ' ' || charAt >= 127) {
                        i4 = 1;
                    } else {
                        sb.append(charAt);
                    }
                    i3++;
                }
                if (i4 != 0) {
                    string = sb.toString();
                }
                String string2 = array.getString(1);
                StringBuilder sb2 = new StringBuilder(string2.length());
                int length2 = string2.length();
                boolean z = false;
                for (int i5 = 0; i5 < length2; i5++) {
                    char charAt2 = string2.charAt(i5);
                    if ((charAt2 <= 31 || charAt2 >= 127) && charAt2 != '\t') {
                        z = true;
                    } else {
                        sb2.append(charAt2);
                    }
                }
                if (z) {
                    string2 = sb2.toString();
                }
                if (!(string == null || string2 == null)) {
                    builder.add(string, string2);
                    i2++;
                    i = 0;
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null) {
            String str = this.mDefaultUserAgent;
            if (str != null) {
                builder.add(USER_AGENT_HEADER_NAME, str);
            }
        }
        if (!(readableMap != null && readableMap.hasKey(REQUEST_BODY_KEY_STRING))) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    private DeviceEventManagerModule.RCTDeviceEventEmitter getEventEmitter(String str) {
        if (getReactApplicationContextIfActiveOrWarn() != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void readWithProgress(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, int i, ResponseBody responseBody) throws IOException {
        long j;
        Charset charset;
        long j2 = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j = progressResponseBody.mTotalBytesRead;
            try {
                j2 = progressResponseBody.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    String decodeNext = progressiveStringDecoder.decodeNext(bArr, read);
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i);
                    createArray.pushString(decodeNext);
                    createArray.pushInt((int) j);
                    createArray.pushInt((int) j2);
                    if (rCTDeviceEventEmitter != null) {
                        rCTDeviceEventEmitter.emit("didReceiveNetworkIncrementalData", createArray);
                    }
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    public static void setCustomClientBuilder(CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    public static boolean shouldDispatch(long j, long j2) {
        return j2 + 100000000 < j;
    }

    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, final DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        if (requestBody == null) {
            return null;
        }
        return new ProgressRequestBody(requestBody, new ProgressListener(this) {
            /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass3 */
            public long last = System.nanoTime();

            @Override // com.facebook.react.modules.network.ProgressListener
            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = rCTDeviceEventEmitter;
                    int i = i;
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i);
                    createArray.pushInt((int) j);
                    createArray.pushInt((int) j2);
                    if (rCTDeviceEventEmitter != null) {
                        rCTDeviceEventEmitter.emit("didSendNetworkData", createArray);
                    }
                    this.last = nanoTime;
                }
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void abortRequest(double d) {
        int i = (int) d;
        cancelRequest(i);
        removeRequest(i);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void addListener(String str) {
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    @ReactMethod
    public void clearCookies(Callback callback) {
        ForwardingCookieHandler forwardingCookieHandler = this.mCookieHandler;
        CookieManager cookieManager = forwardingCookieHandler.getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (r1v0 'cookieManager' android.webkit.CookieManager)
                  (wrap: com.facebook.react.modules.network.ForwardingCookieHandler$2 : 0x000a: CONSTRUCTOR  (r2v0 com.facebook.react.modules.network.ForwardingCookieHandler$2) = 
                  (r0v0 'forwardingCookieHandler' com.facebook.react.modules.network.ForwardingCookieHandler)
                  (r4v0 'callback' com.facebook.react.bridge.Callback)
                 call: com.facebook.react.modules.network.ForwardingCookieHandler.2.<init>(com.facebook.react.modules.network.ForwardingCookieHandler, com.facebook.react.bridge.Callback):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.webkit.CookieManager.removeAllCookies(android.webkit.ValueCallback):void in method: com.facebook.react.modules.network.NetworkingModule.clearCookies(com.facebook.react.bridge.Callback):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r2v0 com.facebook.react.modules.network.ForwardingCookieHandler$2) = 
                  (r0v0 'forwardingCookieHandler' com.facebook.react.modules.network.ForwardingCookieHandler)
                  (r4v0 'callback' com.facebook.react.bridge.Callback)
                 call: com.facebook.react.modules.network.ForwardingCookieHandler.2.<init>(com.facebook.react.modules.network.ForwardingCookieHandler, com.facebook.react.bridge.Callback):void type: CONSTRUCTOR in method: com.facebook.react.modules.network.NetworkingModule.clearCookies(com.facebook.react.bridge.Callback):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.modules.network.ForwardingCookieHandler, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
                this = this;
                com.facebook.react.modules.network.ForwardingCookieHandler r0 = r3.mCookieHandler
                android.webkit.CookieManager r1 = r0.getCookieManager()
                if (r1 == 0) goto L_0x0010
                com.facebook.react.modules.network.ForwardingCookieHandler$2 r2 = new com.facebook.react.modules.network.ForwardingCookieHandler$2
                r2.<init>(r4)
                r1.removeAllCookies(r2)
            L_0x0010:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.clearCookies(com.facebook.react.bridge.Callback):void");
        }

        @Override // com.facebook.react.bridge.NativeModule
        public String getName() {
            return NAME;
        }

        @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
        public void initialize() {
            this.mCookieJarContainer.setCookieJar(new JavaNetCookieJar(this.mCookieHandler));
        }

        @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
        public void onCatalystInstanceDestroy() {
            this.mShuttingDown = true;
            cancelAllRequests();
            if (this.mCookieHandler != null) {
                this.mCookieJarContainer.removeCookieJar();
                this.mRequestBodyHandlers.clear();
                this.mResponseHandlers.clear();
                this.mUriHandlers.clear();
                return;
            }
            throw null;
        }

        @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
        public void removeListeners(double d) {
        }

        public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
            this.mRequestBodyHandlers.remove(requestBodyHandler);
        }

        public void removeResponseHandler(ResponseHandler responseHandler) {
            this.mResponseHandlers.remove(responseHandler);
        }

        public void removeUriHandler(UriHandler uriHandler) {
            this.mUriHandlers.remove(uriHandler);
        }

        @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
        public void sendRequest(String str, String str2, double d, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d2, boolean z2) {
            int i = (int) d;
            try {
                sendRequestInternal(str, str2, i, readableArray, readableMap, str3, z, (int) d2, z2);
            } catch (Throwable th) {
                FLog.e(TAG, "Failed to send url request: " + str2, th);
                DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequest error");
                if (eventEmitter != null) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, th.getMessage(), th);
                }
            }
        }

        public void sendRequestInternal(String str, String str2, final int i, ReadableArray readableArray, ReadableMap readableMap, final String str3, final boolean z, int i2, boolean z2) {
            RequestBodyHandler requestBodyHandler;
            RequestBody requestBody;
            final DeviceEventManagerModule.RCTDeviceEventEmitter eventEmitter = getEventEmitter("sendRequestInternal");
            try {
                Uri parse = Uri.parse(str2);
                for (UriHandler uriHandler : this.mUriHandlers) {
                    if (uriHandler.supports(parse, str3)) {
                        WritableMap fetch = uriHandler.fetch(parse);
                        WritableArray createArray = Arguments.createArray();
                        createArray.pushInt(i);
                        createArray.pushMap(fetch);
                        if (eventEmitter != null) {
                            eventEmitter.emit("didReceiveNetworkData", createArray);
                        }
                        AppCompatDelegateImpl.ConfigurationImplApi17.onRequestSuccess(eventEmitter, i);
                        return;
                    }
                }
                try {
                    Request.Builder url = new Request.Builder().url(str2);
                    if (i != 0) {
                        url.tag(Integer.valueOf(i));
                    }
                    OkHttpClient.Builder newBuilder = this.mClient.newBuilder();
                    applyCustomBuilder(newBuilder);
                    if (!z2) {
                        newBuilder.cookieJar(CookieJar.NO_COOKIES);
                    }
                    if (z) {
                        newBuilder.addNetworkInterceptor(new Interceptor(this) {
                            /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass1 */

                            @Override // okhttp3.Interceptor
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Response proceed = chain.proceed(chain.request());
                                return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), new ProgressListener() {
                                    /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass1.AnonymousClass1 */
                                    public long last = System.nanoTime();

                                    @Override // com.facebook.react.modules.network.ProgressListener
                                    public void onProgress(long j, long j2, boolean z) {
                                        long nanoTime = System.nanoTime();
                                        if ((z || NetworkingModule.shouldDispatch(nanoTime, this.last)) && !str3.equals("text")) {
                                            AnonymousClass1 r9 = AnonymousClass1.this;
                                            DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = eventEmitter;
                                            int i = i;
                                            WritableArray createArray = Arguments.createArray();
                                            createArray.pushInt(i);
                                            createArray.pushInt((int) j);
                                            createArray.pushInt((int) j2);
                                            if (rCTDeviceEventEmitter != null) {
                                                rCTDeviceEventEmitter.emit("didReceiveNetworkDataProgress", createArray);
                                            }
                                            this.last = nanoTime;
                                        }
                                    }
                                })).build();
                            }
                        });
                    }
                    if (i2 != this.mClient.connectTimeoutMillis()) {
                        newBuilder.connectTimeout((long) i2, TimeUnit.MILLISECONDS);
                    }
                    OkHttpClient build = newBuilder.build();
                    Headers extractHeaders = extractHeaders(readableArray, readableMap);
                    if (extractHeaders == null) {
                        AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Unrecognized headers format", null);
                        return;
                    }
                    String str4 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                    String str5 = extractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                    url.headers(extractHeaders);
                    if (readableMap != null) {
                        Iterator<RequestBodyHandler> it = this.mRequestBodyHandlers.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            requestBodyHandler = it.next();
                            if (requestBodyHandler.supports(readableMap)) {
                                break;
                            }
                        }
                    }
                    requestBodyHandler = null;
                    if (readableMap == null || str.toLowerCase().equals("get") || str.toLowerCase().equals("head")) {
                        requestBody = AppCompatDelegateImpl.ConfigurationImplApi17.getEmptyBody(str);
                    } else if (requestBodyHandler != null) {
                        requestBody = requestBodyHandler.toRequestBody(readableMap, str4);
                    } else if (readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
                        if (str4 == null) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                            return;
                        }
                        String string = readableMap.getString(REQUEST_BODY_KEY_STRING);
                        MediaType parse2 = MediaType.parse(str4);
                        if ("gzip".equalsIgnoreCase(str5)) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(string.getBytes());
                                gZIPOutputStream.close();
                                requestBody = RequestBody.create(parse2, byteArrayOutputStream.toByteArray());
                            } catch (IOException unused) {
                                requestBody = null;
                            }
                            if (requestBody == null) {
                                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Failed to gzip request body", null);
                                return;
                            }
                        } else {
                            Charset charset = StandardCharsets.UTF_8;
                            if (parse2 != null) {
                                charset = parse2.charset(charset);
                            }
                            requestBody = RequestBody.create(parse2, string.getBytes(charset));
                        }
                    } else if (readableMap.hasKey(REQUEST_BODY_KEY_BASE64)) {
                        if (str4 == null) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                            return;
                        }
                        requestBody = RequestBody.create(MediaType.parse(str4), ByteString.decodeBase64(readableMap.getString(REQUEST_BODY_KEY_BASE64)));
                    } else if (readableMap.hasKey(REQUEST_BODY_KEY_URI)) {
                        if (str4 == null) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                            return;
                        }
                        String string2 = readableMap.getString(REQUEST_BODY_KEY_URI);
                        InputStream fileInputStream = AppCompatDelegateImpl.ConfigurationImplApi17.getFileInputStream(getReactApplicationContext(), string2);
                        if (fileInputStream == null) {
                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, "Could not retrieve file for uri " + string2, null);
                            return;
                        }
                        requestBody = new RequestBodyUtil$1(MediaType.parse(str4), fileInputStream);
                    } else if (readableMap.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                        if (str4 == null) {
                            str4 = "multipart/form-data";
                        }
                        MultipartBody.Builder constructMultipartBody = constructMultipartBody(readableMap.getArray(REQUEST_BODY_KEY_FORMDATA), str4, i);
                        if (constructMultipartBody != null) {
                            requestBody = constructMultipartBody.build();
                        } else {
                            return;
                        }
                    } else {
                        requestBody = AppCompatDelegateImpl.ConfigurationImplApi17.getEmptyBody(str);
                    }
                    url.method(str, wrapRequestBodyWithProgressEmitter(requestBody, eventEmitter, i));
                    addRequest(i);
                    build.newCall(url.build()).enqueue(new okhttp3.Callback() {
                        /* class com.facebook.react.modules.network.NetworkingModule.AnonymousClass2 */

                        @Override // okhttp3.Callback
                        public void onFailure(Call call, IOException iOException) {
                            String str;
                            if (!NetworkingModule.this.mShuttingDown) {
                                NetworkingModule.this.removeRequest(i);
                                if (iOException.getMessage() != null) {
                                    str = iOException.getMessage();
                                } else {
                                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Error while executing request: ");
                                    outline15.append(iOException.getClass().getSimpleName());
                                    str = outline15.toString();
                                }
                                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, str, iOException);
                            }
                        }

                        @Override // okhttp3.Callback
                        public void onResponse(Call call, Response response) throws IOException {
                            ResponseHandler responseHandler;
                            if (!NetworkingModule.this.mShuttingDown) {
                                NetworkingModule.this.removeRequest(i);
                                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = eventEmitter;
                                int i = i;
                                int code = response.code();
                                WritableMap translateHeaders = NetworkingModule.translateHeaders(response.headers());
                                String httpUrl = response.request().url().toString();
                                WritableArray createArray = Arguments.createArray();
                                createArray.pushInt(i);
                                createArray.pushInt(code);
                                createArray.pushMap(translateHeaders);
                                createArray.pushString(httpUrl);
                                if (rCTDeviceEventEmitter != null) {
                                    rCTDeviceEventEmitter.emit("didReceiveNetworkResponse", createArray);
                                }
                                try {
                                    ResponseBody body = response.body();
                                    if ("gzip".equalsIgnoreCase(response.header("Content-Encoding")) && body != null) {
                                        GzipSource gzipSource = new GzipSource(body.source());
                                        String header = response.header("Content-Type");
                                        body = ResponseBody.create(header != null ? MediaType.parse(header) : null, -1, new RealBufferedSource(gzipSource));
                                    }
                                    Iterator it = NetworkingModule.this.mResponseHandlers.iterator();
                                    do {
                                        if (it.hasNext()) {
                                            responseHandler = (ResponseHandler) it.next();
                                        } else if (!z || !str3.equals("text")) {
                                            String str = "";
                                            if (str3.equals("text")) {
                                                try {
                                                    str = body.string();
                                                } catch (IOException e) {
                                                    if (!response.request().method().equalsIgnoreCase("HEAD")) {
                                                        AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, e.getMessage(), e);
                                                    }
                                                }
                                            } else if (str3.equals(NetworkingModule.REQUEST_BODY_KEY_BASE64)) {
                                                str = Base64.encodeToString(body.bytes(), 2);
                                            }
                                            DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter2 = eventEmitter;
                                            int i2 = i;
                                            WritableArray createArray2 = Arguments.createArray();
                                            createArray2.pushInt(i2);
                                            createArray2.pushString(str);
                                            if (rCTDeviceEventEmitter2 != null) {
                                                rCTDeviceEventEmitter2.emit("didReceiveNetworkData", createArray2);
                                            }
                                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestSuccess(eventEmitter, i);
                                            return;
                                        } else {
                                            NetworkingModule.this.readWithProgress(eventEmitter, i, body);
                                            AppCompatDelegateImpl.ConfigurationImplApi17.onRequestSuccess(eventEmitter, i);
                                            return;
                                        }
                                    } while (!responseHandler.supports(str3));
                                    WritableMap responseData = responseHandler.toResponseData(body);
                                    DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter3 = eventEmitter;
                                    int i3 = i;
                                    WritableArray createArray3 = Arguments.createArray();
                                    createArray3.pushInt(i3);
                                    createArray3.pushMap(responseData);
                                    if (rCTDeviceEventEmitter3 != null) {
                                        rCTDeviceEventEmitter3.emit("didReceiveNetworkData", createArray3);
                                    }
                                    AppCompatDelegateImpl.ConfigurationImplApi17.onRequestSuccess(eventEmitter, i);
                                } catch (IOException e2) {
                                    AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, e2.getMessage(), e2);
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, e.getMessage(), null);
                }
            } catch (IOException e2) {
                AppCompatDelegateImpl.ConfigurationImplApi17.onRequestError(eventEmitter, i, e2.getMessage(), e2);
            }
        }

        public NetworkingModule(ReactApplicationContext reactApplicationContext, String str, OkHttpClient okHttpClient) {
            this(reactApplicationContext, str, okHttpClient, null);
        }

        public NetworkingModule(ReactApplicationContext reactApplicationContext) {
            this(reactApplicationContext, null, AppCompatDelegateImpl.ConfigurationImplApi17.createClient(reactApplicationContext), null);
        }

        public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
            this(reactApplicationContext, null, AppCompatDelegateImpl.ConfigurationImplApi17.createClient(reactApplicationContext), list);
        }

        public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
            this(reactApplicationContext, str, AppCompatDelegateImpl.ConfigurationImplApi17.createClient(reactApplicationContext), null);
        }
    }
