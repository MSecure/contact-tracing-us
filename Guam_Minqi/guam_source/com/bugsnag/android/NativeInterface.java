package com.bugsnag.android;

import android.annotation.SuppressLint;
import com.bugsnag.android.StateEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public class NativeInterface {
    public static Charset UTF8Charset = Charset.defaultCharset();
    @SuppressLint({"StaticFieldLeak"})
    public static Client client;

    public static void addMetadata(String str, String str2, Object obj) {
        Client client2 = getClient();
        if (str == null || str2 == null) {
            client2.logNull("addMetadata");
            return;
        }
        MetadataState metadataState = client2.metadataState;
        if (metadataState != null) {
            Intrinsics.checkParameterIsNotNull(str, "section");
            Intrinsics.checkParameterIsNotNull(str2, "key");
            metadataState.metadata.addMetadata(str, str2, obj);
            metadataState.notifyMetadataAdded(str, str2, obj);
            return;
        }
        throw null;
    }

    public static void clearMetadata(String str, String str2) {
        if (str2 == null) {
            getClient().clearMetadata(str);
        } else {
            getClient().clearMetadata(str, str2);
        }
    }

    public static Event createEvent(Throwable th, Client client2, HandledState handledState) {
        return new Event(th, client2.immutableConfig, handledState, new Metadata(), client2.logger);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0078 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089 A[Catch:{ Exception -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0095 A[SYNTHETIC, Splitter:B:41:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b7 A[SYNTHETIC, Splitter:B:52:0x00b7] */
    public static void deliverReport(byte[] bArr, byte[] bArr2) {
        String str;
        Client client2;
        EventStore eventStore;
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e;
        String str2;
        Logger logger;
        Exception e2;
        File file;
        if (bArr2 != null) {
            String str3 = new String(bArr2, UTF8Charset);
            BufferedWriter bufferedWriter2 = null;
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr, UTF8Charset);
            }
            client2 = getClient();
            if (str == null || str.length() == 0 || client2.immutableConfig.shouldNotifyForReleaseStage()) {
                eventStore = client2.eventStore;
                if (eventStore.storeDirectory != null) {
                    String filename = eventStore.getFilename(str3);
                    eventStore.discardOldestFileIfNeeded();
                    eventStore.lock.lock();
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
                        try {
                            bufferedWriter.write(str3);
                            try {
                                bufferedWriter.close();
                            } catch (Exception e3) {
                                e = e3;
                                logger = ((FileStore) eventStore).logger;
                                str2 = String.format("Failed to close unsent payload writer (%s) ", filename);
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            try {
                                file = new File(filename);
                                if (((FileStore) eventStore).delegate != null) {
                                }
                                Logger logger2 = ((FileStore) eventStore).logger;
                                try {
                                    if (!file.delete()) {
                                    }
                                } catch (Exception e5) {
                                    logger2.w("Failed to delete file", e5);
                                }
                                if (bufferedWriter != null) {
                                }
                                eventStore.lock.unlock();
                                client2.eventStore.flushAsync();
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter2 = bufferedWriter;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (Exception e6) {
                                        ((FileStore) eventStore).logger.w(String.format("Failed to close unsent payload writer (%s) ", filename), e6);
                                    }
                                }
                                eventStore.lock.unlock();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedWriter != null) {
                            }
                            eventStore.lock.unlock();
                            throw th;
                        }
                    } catch (Exception e7) {
                        bufferedWriter = null;
                        e2 = e7;
                        file = new File(filename);
                        if (((FileStore) eventStore).delegate != null) {
                            ((InternalReportDelegate) ((FileStore) eventStore).delegate).onErrorIOFailure(e2, file, "NDK Crash report copy");
                        }
                        Logger logger22 = ((FileStore) eventStore).logger;
                        if (!file.delete()) {
                            file.deleteOnExit();
                        }
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e8) {
                                e = e8;
                                logger = ((FileStore) eventStore).logger;
                                str2 = String.format("Failed to close unsent payload writer (%s) ", filename);
                            }
                        }
                        eventStore.lock.unlock();
                        client2.eventStore.flushAsync();
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                        }
                        eventStore.lock.unlock();
                        throw th;
                    }
                    eventStore.lock.unlock();
                }
                client2.eventStore.flushAsync();
            }
            return;
        }
        return;
        logger.w(str2, e);
        eventStore.lock.unlock();
        client2.eventStore.flushAsync();
    }

    public static Map<String, Object> getApp() {
        HashMap hashMap = new HashMap();
        AppDataCollector appDataCollector = getClient().appDataCollector;
        AppWithState generateAppWithState = appDataCollector.generateAppWithState();
        hashMap.put("version", generateAppWithState.version);
        hashMap.put("releaseStage", generateAppWithState.releaseStage);
        hashMap.put("id", generateAppWithState.id);
        hashMap.put("type", generateAppWithState.type);
        hashMap.put("buildUUID", generateAppWithState.buildUuid);
        hashMap.put("duration", generateAppWithState.duration);
        hashMap.put("durationInForeground", generateAppWithState.durationInForeground);
        hashMap.put("versionCode", generateAppWithState.versionCode);
        hashMap.put("inForeground", generateAppWithState.inForeground);
        hashMap.put("binaryArch", generateAppWithState.binaryArch);
        hashMap.putAll(appDataCollector.getAppDataMetadata());
        return hashMap;
    }

    public static String getAppVersion() {
        return getClient().immutableConfig.appVersion;
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        Client client2 = getClient();
        if (client2 != null) {
            return new ArrayList(client2.breadcrumbState.getStore());
        }
        throw null;
    }

    public static Client getClient() {
        Client client2 = client;
        if (client2 != null) {
            return client2;
        }
        return Bugsnag.getClient();
    }

    public static String getContext() {
        return getClient().contextState.context;
    }

    public static String[] getCpuAbi() {
        String[] strArr = getClient().deviceDataCollector.buildInfo.cpuAbis;
        return strArr != null ? strArr : new String[0];
    }

    public static Map<String, Object> getDevice() {
        DeviceDataCollector deviceDataCollector = getClient().deviceDataCollector;
        HashMap hashMap = new HashMap(deviceDataCollector.getDeviceMetadata());
        DeviceWithState generateDeviceWithState = deviceDataCollector.generateDeviceWithState(new Date().getTime());
        hashMap.put("freeDisk", generateDeviceWithState.freeDisk);
        hashMap.put("freeMemory", generateDeviceWithState.freeMemory);
        hashMap.put("orientation", generateDeviceWithState.orientation);
        hashMap.put("time", generateDeviceWithState.time);
        hashMap.put("cpuAbi", generateDeviceWithState.cpuAbi);
        hashMap.put("jailbroken", generateDeviceWithState.jailbroken);
        hashMap.put("id", generateDeviceWithState.id);
        hashMap.put("locale", generateDeviceWithState.locale);
        hashMap.put("manufacturer", generateDeviceWithState.manufacturer);
        hashMap.put("model", generateDeviceWithState.model);
        hashMap.put("osName", generateDeviceWithState.osName);
        hashMap.put("osVersion", generateDeviceWithState.osVersion);
        hashMap.put("runtimeVersions", generateDeviceWithState.runtimeVersions);
        hashMap.put("totalMemory", generateDeviceWithState.totalMemory);
        return hashMap;
    }

    public static Collection<String> getEnabledReleaseStages() {
        return getClient().immutableConfig.enabledReleaseStages;
    }

    public static String getEndpoint() {
        return getClient().immutableConfig.endpoints.notify;
    }

    public static Logger getLogger() {
        return getClient().immutableConfig.logger;
    }

    public static Map<String, Object> getMetadata() {
        return getClient().metadataState.metadata.toMap();
    }

    public static String getNativeReportPath() {
        return getClient().appContext.getCacheDir().getAbsolutePath() + "/bugsnag-native/";
    }

    public static String getReleaseStage() {
        return getClient().immutableConfig.releaseStage;
    }

    public static String getSessionEndpoint() {
        return getClient().immutableConfig.endpoints.sessions;
    }

    public static Map<String, String> getUser() {
        HashMap hashMap = new HashMap();
        User user = getClient().userState.user;
        hashMap.put("id", user.id);
        hashMap.put("name", user.name);
        hashMap.put("email", user.email);
        return hashMap;
    }

    public static void leaveBreadcrumb(String str, BreadcrumbType breadcrumbType) {
        if (str != null) {
            getClient().leaveBreadcrumb(str, new HashMap(), breadcrumbType);
        }
    }

    public static void notify(byte[] bArr, byte[] bArr2, Severity severity, StackTraceElement[] stackTraceElementArr) {
        if (bArr != null && bArr2 != null && stackTraceElementArr != null) {
            notify(new String(bArr, UTF8Charset), new String(bArr2, UTF8Charset), severity, stackTraceElementArr);
        }
    }

    public static void registerSession(long j, String str, int i, int i2) {
        Client client2 = getClient();
        User user = client2.userState.user;
        Session session = null;
        Date date = j > 0 ? new Date(j) : null;
        SessionTracker sessionTracker = client2.sessionTracker;
        if (date == null || str == null) {
            sessionTracker.notifyObservers(StateEvent.PauseSession.INSTANCE);
        } else {
            session = new Session(str, date, user, i, i2, sessionTracker.client.notifier, sessionTracker.logger);
            sessionTracker.notifySessionStartObserver(session);
        }
        sessionTracker.currentSession.set(session);
    }

    public static void setBinaryArch(String str) {
        AppDataCollector appDataCollector = getClient().appDataCollector;
        if (appDataCollector != null) {
            Intrinsics.checkParameterIsNotNull(str, "binaryArch");
            appDataCollector.binaryArch = str;
            return;
        }
        throw null;
    }

    public static void setClient(Client client2) {
        client = client2;
    }

    public static void setContext(String str) {
        ContextState contextState = getClient().contextState;
        contextState.context = str;
        contextState.notifyObservers(new StateEvent.UpdateContext(str));
    }

    public static void setUser(String str, String str2, String str3) {
        getClient().userState.setUser(str, str2, str3);
    }

    public static void leaveBreadcrumb(byte[] bArr, BreadcrumbType breadcrumbType) {
        if (bArr != null) {
            getClient().leaveBreadcrumb(new String(bArr, UTF8Charset), new HashMap(), breadcrumbType);
        }
    }

    public static void setUser(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        String str;
        String str2 = null;
        String str3 = bArr == null ? null : new String(bArr, UTF8Charset);
        if (bArr2 == null) {
            str = null;
        } else {
            str = new String(bArr2, UTF8Charset);
        }
        if (bArr3 != null) {
            str2 = new String(bArr3, UTF8Charset);
        }
        setUser(str3, str, str2);
    }

    public static void leaveBreadcrumb(String str, String str2, Map<String, Object> map) {
        getClient().leaveBreadcrumb(str, map, BreadcrumbType.valueOf(str2.toUpperCase(Locale.US)));
    }

    public static void notify(final String str, final String str2, final Severity severity, StackTraceElement[] stackTraceElementArr) {
        RuntimeException runtimeException = new RuntimeException();
        runtimeException.setStackTrace(stackTraceElementArr);
        getClient().notify(runtimeException, new OnErrorCallback() {
            /* class com.bugsnag.android.NativeInterface.AnonymousClass1 */

            @Override // com.bugsnag.android.OnErrorCallback
            public boolean onError(Event event) {
                Severity severity = severity;
                EventInternal eventInternal = event.impl;
                if (eventInternal != null) {
                    Intrinsics.checkParameterIsNotNull(severity, "severity");
                    HandledState handledState = eventInternal.handledState;
                    HandledState newInstance = HandledState.newInstance(handledState.severityReasonType, severity, handledState.attributeValue);
                    Intrinsics.checkExpressionValueIsNotNull(newInstance, "HandledState.newInstance…dledState.attributeValue)");
                    eventInternal.handledState = newInstance;
                    Intrinsics.checkParameterIsNotNull(severity, "value");
                    eventInternal.handledState.currentSeverity = severity;
                    List<Error> list = event.impl.errors;
                    if (list.isEmpty()) {
                        return true;
                    }
                    list.get(0).setErrorClass(str);
                    list.get(0).impl.errorMessage = str2;
                    for (Error error : list) {
                        ErrorType errorType = ErrorType.C;
                        ErrorInternal errorInternal = error.impl;
                        if (errorInternal != null) {
                            Intrinsics.checkParameterIsNotNull(errorType, "<set-?>");
                            errorInternal.type = errorType;
                        } else {
                            throw null;
                        }
                    }
                    return true;
                }
                throw null;
            }
        });
    }
}
