package com.bugsnag.android;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bugsnag.android.StateEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BugsnagReactNative.kt */
public final class BugsnagReactNative extends ReactContextBaseJavaModule {
    public static final Companion Companion = new Companion(null);
    public static final String DATA_KEY = "data";
    public static final String SYNC_KEY = "bugsnag::sync";
    public static final String UPDATE_CONTEXT = "ContextUpdate";
    public static final String UPDATE_METADATA = "MetadataUpdate";
    public static final String UPDATE_USER = "UserUpdate";
    public DeviceEventManagerModule.RCTDeviceEventEmitter bridge;
    public Logger logger;
    public BugsnagReactNativePlugin plugin;
    public final ReactApplicationContext reactContext;

    /* compiled from: BugsnagReactNative.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BugsnagReactNative(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public final void addMetadata(String str, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(str, "section");
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            HashMap<String, Object> hashMap = null;
            if (bugsnagReactNativePlugin != null) {
                if (readableMap != null) {
                    hashMap = readableMap.toHashMap();
                }
                bugsnagReactNativePlugin.addMetadata(str, hashMap);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            throw null;
        } catch (Throwable th) {
            logFailure("addMetadata", th);
        }
    }

    @ReactMethod
    public final void clearMetadata(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "section");
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin == null) {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            } else if (bugsnagReactNativePlugin != null) {
                Intrinsics.checkParameterIsNotNull(str, "section");
                if (str2 == null) {
                    Client client = bugsnagReactNativePlugin.client;
                    if (client != null) {
                        client.clearMetadata(str);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        throw null;
                    }
                } else {
                    Client client2 = bugsnagReactNativePlugin.client;
                    if (client2 != null) {
                        client2.clearMetadata(str, str2);
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        } catch (Throwable th) {
            logFailure("clearMetadata", th);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final WritableMap configure(ReadableMap readableMap) {
        Plugin plugin2;
        Intrinsics.checkNotNullParameter(readableMap, "env");
        try {
            Client client = Bugsnag.getClient();
            Intrinsics.checkNotNullExpressionValue(client, "try {\n            Bugsna…tion subclass\")\n        }");
            try {
                JavaScriptModule jSModule = this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                Intrinsics.checkNotNullExpressionValue(jSModule, "reactContext.getJSModule…EventEmitter::class.java)");
                this.bridge = (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
                Logger logger2 = client.logger;
                Intrinsics.checkNotNullExpressionValue(logger2, "client.logger");
                this.logger = logger2;
                Iterator<Plugin> it = client.pluginClient.plugins.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        plugin2 = null;
                        break;
                    }
                    plugin2 = it.next();
                    if (plugin2.getClass().equals(BugsnagReactNativePlugin.class)) {
                        break;
                    }
                }
                Intrinsics.checkNotNull(plugin2);
                BugsnagReactNativePlugin bugsnagReactNativePlugin = (BugsnagReactNativePlugin) plugin2;
                this.plugin = bugsnagReactNativePlugin;
                if (bugsnagReactNativePlugin != null) {
                    BugsnagReactNative$configure$1 bugsnagReactNative$configure$1 = new BugsnagReactNative$configure$1(this);
                    if (bugsnagReactNativePlugin != null) {
                        Intrinsics.checkParameterIsNotNull(bugsnagReactNative$configure$1, "cb");
                        bugsnagReactNativePlugin.jsCallback = bugsnagReactNative$configure$1;
                        Client client2 = bugsnagReactNativePlugin.client;
                        if (client2 != null) {
                            client2.syncInitialState();
                            BugsnagReactNativePlugin bugsnagReactNativePlugin2 = this.plugin;
                            if (bugsnagReactNativePlugin2 != null) {
                                return AppCompatDelegateImpl.ConfigurationImplApi17.toWritableMap(bugsnagReactNativePlugin2.configure(readableMap.toHashMap()));
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("plugin");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("client");
                        throw null;
                    }
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            } catch (Throwable th) {
                logFailure("configure", th);
                return new WritableNativeMap();
            }
        } catch (IllegalStateException unused) {
            throw new IllegalStateException("Failed to initialise the native Bugsnag Android client, please check you have added Bugsnag.start() in the onCreate() method of your Application subclass");
        }
    }

    @ReactMethod
    public final void configureAsync(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "env");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.resolve(configure(readableMap));
    }

    @ReactMethod
    public final void dispatch(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "payload");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                bugsnagReactNativePlugin.dispatch(readableMap.toHashMap());
                promise.resolve(Boolean.TRUE);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            throw null;
        } catch (Throwable th) {
            logFailure("dispatch", th);
            promise.resolve(Boolean.FALSE);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e  */
    public final void emitEvent(MessageEvent messageEvent) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        Intrinsics.checkNotNullParameter(messageEvent, "event");
        Logger logger2 = this.logger;
        if (logger2 != null) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Received MessageEvent: ");
            outline17.append(messageEvent.type);
            logger2.d(outline17.toString());
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", messageEvent.type);
            String str = messageEvent.type;
            int hashCode = str.hashCode();
            if (hashCode != -656234348) {
                if (hashCode != 773999416) {
                    if (hashCode == 1070992632 && str.equals(UPDATE_METADATA)) {
                        createMap.putMap(DATA_KEY, Arguments.makeNativeMap((Map) messageEvent.data));
                        rCTDeviceEventEmitter = this.bridge;
                        if (rCTDeviceEventEmitter == null) {
                            rCTDeviceEventEmitter.emit(SYNC_KEY, createMap);
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("bridge");
                            throw null;
                        }
                    }
                } else if (str.equals(UPDATE_CONTEXT)) {
                    createMap.putString(DATA_KEY, (String) messageEvent.data);
                    rCTDeviceEventEmitter = this.bridge;
                    if (rCTDeviceEventEmitter == null) {
                    }
                }
            } else if (str.equals(UPDATE_USER)) {
                createMap.putMap(DATA_KEY, Arguments.makeNativeMap((Map) messageEvent.data));
                rCTDeviceEventEmitter = this.bridge;
                if (rCTDeviceEventEmitter == null) {
                }
            }
            Logger logger3 = this.logger;
            if (logger3 != null) {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("Received unknown message event ");
                outline172.append(messageEvent.type);
                outline172.append(", ignoring");
                logger3.w(outline172.toString());
                rCTDeviceEventEmitter = this.bridge;
                if (rCTDeviceEventEmitter == null) {
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("logger");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            throw null;
        }
    }

    public final DeviceEventManagerModule.RCTDeviceEventEmitter getBridge() {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = this.bridge;
        if (rCTDeviceEventEmitter != null) {
            return rCTDeviceEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bridge");
        throw null;
    }

    public final Logger getLogger() {
        Logger logger2 = this.logger;
        if (logger2 != null) {
            return logger2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        throw null;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BugsnagReactNative";
    }

    @ReactMethod
    public final void getPayloadInfo(ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(readableMap, "payload");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            boolean z = readableMap.getBoolean("unhandled");
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                promise.resolve(Arguments.makeNativeMap(bugsnagReactNativePlugin.getPayloadInfo(z)));
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            }
        } catch (Throwable th) {
            logFailure("getPayloadInfo", th);
        }
    }

    public final BugsnagReactNativePlugin getPlugin() {
        BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
        if (bugsnagReactNativePlugin != null) {
            return bugsnagReactNativePlugin;
        }
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
        throw null;
    }

    @ReactMethod
    public final void leaveBreadcrumb(ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(readableMap, "map");
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                bugsnagReactNativePlugin.leaveBreadcrumb(readableMap.toHashMap());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            }
        } catch (Throwable th) {
            logFailure("leaveBreadcrumb", th);
        }
    }

    public final void logFailure(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(th, "exc");
        Logger logger2 = this.logger;
        if (logger2 != null) {
            logger2.e("Failed to call " + str + " on bugsnag-plugin-react-native, continuing", th);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        throw null;
    }

    @ReactMethod
    public final void pauseSession() {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                Client client = bugsnagReactNativePlugin.client;
                if (client != null) {
                    SessionTracker sessionTracker = client.sessionTracker;
                    Session session = sessionTracker.currentSession.get();
                    if (session != null) {
                        session.isPaused.set(true);
                        sessionTracker.notifyObservers(StateEvent.PauseSession.INSTANCE);
                        return;
                    }
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            throw null;
        } catch (Throwable th) {
            logFailure("pauseSession", th);
        }
    }

    @ReactMethod
    public final void resumeSession() {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                bugsnagReactNativePlugin.resumeSession();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            }
        } catch (Throwable th) {
            logFailure("resumeSession", th);
        }
    }

    public final void setBridge(DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTDeviceEventEmitter, "<set-?>");
        this.bridge = rCTDeviceEventEmitter;
    }

    public final void setLogger(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "<set-?>");
        this.logger = logger2;
    }

    public final void setPlugin(BugsnagReactNativePlugin bugsnagReactNativePlugin) {
        Intrinsics.checkNotNullParameter(bugsnagReactNativePlugin, "<set-?>");
        this.plugin = bugsnagReactNativePlugin;
    }

    @ReactMethod
    public final void startSession() {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                Client client = bugsnagReactNativePlugin.client;
                if (client != null) {
                    SessionTracker sessionTracker = client.sessionTracker;
                    if (sessionTracker != null) {
                        sessionTracker.startNewSession(new Date(), sessionTracker.client.userState.user, false);
                        return;
                    }
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            throw null;
        } catch (Throwable th) {
            logFailure("startSession", th);
        }
    }

    @ReactMethod
    public final void updateCodeBundleId(String str) {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                Client client = bugsnagReactNativePlugin.client;
                if (client != null) {
                    client.appDataCollector.codeBundleId = str;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            }
        } catch (Throwable th) {
            logFailure("updateCodeBundleId", th);
        }
    }

    @ReactMethod
    public final void updateContext(String str) {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                Client client = bugsnagReactNativePlugin.client;
                if (client != null) {
                    ContextState contextState = client.contextState;
                    contextState.context = str;
                    contextState.notifyObservers(new StateEvent.UpdateContext(str));
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("plugin");
            throw null;
        } catch (Throwable th) {
            logFailure("updateContext", th);
        }
    }

    @ReactMethod
    public final void updateUser(String str, String str2, String str3) {
        try {
            BugsnagReactNativePlugin bugsnagReactNativePlugin = this.plugin;
            if (bugsnagReactNativePlugin != null) {
                Client client = bugsnagReactNativePlugin.client;
                if (client != null) {
                    client.userState.setUser(str, str2, str3);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("plugin");
                throw null;
            }
        } catch (Throwable th) {
            logFailure("updateUser", th);
        }
    }
}
