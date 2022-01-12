package com.bugsnag.android.ndk;

import android.os.Build;
import com.bugsnag.android.Logger;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.StateEvent;
import com.facebook.react.bridge.PromiseImpl;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: NativeBridge.kt */
public final class NativeBridge implements Observer {
    public final AtomicBoolean installed = new AtomicBoolean(false);
    public final ReentrantLock lock = new ReentrantLock();
    public final Logger logger;
    public final String reportDirectory;

    public NativeBridge() {
        String nativeReportPath = NativeInterface.getNativeReportPath();
        Intrinsics.checkExpressionValueIsNotNull(nativeReportPath, "NativeInterface.getNativeReportPath()");
        this.reportDirectory = nativeReportPath;
        Logger logger2 = NativeInterface.getLogger();
        Intrinsics.checkExpressionValueIsNotNull(logger2, "NativeInterface.getLogger()");
        this.logger = logger2;
        File file = new File(this.reportDirectory);
        NativeInterface.getLogger();
        if (!file.exists() && !file.mkdirs()) {
            this.logger.w("The native reporting directory cannot be created.");
        }
    }

    private final void deliverPendingReports() {
        this.lock.lock();
        try {
            File file = new File(this.reportDirectory);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        Intrinsics.checkExpressionValueIsNotNull(file2, PromiseImpl.STACK_FRAME_KEY_FILE);
                        String absolutePath = file2.getAbsolutePath();
                        Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                        deliverReportAtPath(absolutePath);
                    }
                }
            } else {
                this.logger.w("Payload directory does not exist, cannot read pending reports");
            }
        } catch (Exception e) {
            this.logger.w("Failed to parse/write pending reports: " + e);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
        this.lock.unlock();
    }

    private final void handleAddMetadata(StateEvent.AddMetadata addMetadata) {
        String str = addMetadata.key;
        if (str != null) {
            Object obj = addMetadata.value;
            if (obj instanceof String) {
                String str2 = addMetadata.section;
                if (str != null) {
                    addMetadataString(str2, str, makeSafe((String) obj));
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            } else if (obj instanceof Boolean) {
                String str3 = addMetadata.section;
                if (str != null) {
                    addMetadataBoolean(str3, str, ((Boolean) obj).booleanValue());
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            } else if (obj instanceof Number) {
                String str4 = addMetadata.section;
                if (str != null) {
                    addMetadataDouble(str4, str, ((Number) obj).doubleValue());
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            }
        }
    }

    private final void handleInstallMessage(StateEvent.Install install) {
        this.lock.lock();
        try {
            if (this.installed.get()) {
                this.logger.w("Received duplicate setup message with arg: " + install);
            } else {
                String str = this.reportDirectory + UUID.randomUUID().toString() + ".crash";
                boolean z = install.autoDetectNdkCrashes;
                int i = Build.VERSION.SDK_INT;
                boolean is32bit = is32bit();
                String str2 = install.appVersion;
                String str3 = "";
                if (str2 == null) {
                    str2 = str3;
                }
                String makeSafe = makeSafe(str2);
                String str4 = install.buildUuid;
                if (str4 == null) {
                    str4 = str3;
                }
                String makeSafe2 = makeSafe(str4);
                String str5 = install.releaseStage;
                if (str5 != null) {
                    str3 = str5;
                }
                install(str, z, i, is32bit, makeSafe, makeSafe2, makeSafe(str3));
                this.installed.set(true);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private final boolean is32bit() {
        String[] cpuAbi = NativeInterface.getCpuAbi();
        Intrinsics.checkExpressionValueIsNotNull(cpuAbi, "NativeInterface.getCpuAbi()");
        List list = MoreExecutors.toList(cpuAbi);
        boolean z = false;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                Intrinsics.checkExpressionValueIsNotNull(str, "it");
                if (StringsKt__StringNumberConversionsKt.contains$default(str, "64", false, 2)) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    private final boolean isInvalidMessage(Object obj) {
        if (!(obj instanceof StateEvent)) {
            return true;
        }
        if (this.installed.get() || (obj instanceof StateEvent.Install)) {
            Logger logger2 = this.logger;
            String format = String.format("Received NDK message %s", Arrays.copyOf(new Object[]{obj}, 1));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            logger2.d(format);
            return false;
        }
        Logger logger3 = this.logger;
        logger3.w("Received message before INSTALL: " + obj);
        return true;
    }

    private final String makeSafe(String str) {
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkExpressionValueIsNotNull(defaultCharset, "Charset.defaultCharset()");
        if (str != null) {
            byte[] bytes = str.getBytes(defaultCharset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return new String(bytes, Charsets.UTF_8);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final native void addBreadcrumb(String str, String str2, String str3, Object obj);

    public final native void addHandledEvent();

    public final native void addMetadataBoolean(String str, String str2, boolean z);

    public final native void addMetadataDouble(String str, String str2, double d);

    public final native void addMetadataString(String str, String str2, String str3);

    public final native void addUnhandledEvent();

    public final native void clearMetadataTab(String str);

    public final native void deliverReportAtPath(String str);

    public final native void install(String str, boolean z, int i, boolean z2, String str2, String str3, String str4);

    public final native void pausedSession();

    public final native void removeMetadata(String str, String str2);

    public final native void startedSession(String str, String str2, int i, int i2);

    public void update(Observable observable, Object obj) {
        Intrinsics.checkParameterIsNotNull(observable, "observable");
        if (!isInvalidMessage(obj)) {
            if (obj != null) {
                StateEvent stateEvent = (StateEvent) obj;
                if (stateEvent instanceof StateEvent.Install) {
                    handleInstallMessage((StateEvent.Install) stateEvent);
                } else if (Intrinsics.areEqual(stateEvent, StateEvent.DeliverPending.INSTANCE)) {
                    deliverPendingReports();
                } else if (stateEvent instanceof StateEvent.AddMetadata) {
                    handleAddMetadata((StateEvent.AddMetadata) stateEvent);
                } else if (stateEvent instanceof StateEvent.ClearMetadataSection) {
                    clearMetadataTab(makeSafe(((StateEvent.ClearMetadataSection) stateEvent).section));
                } else {
                    String str = "";
                    if (stateEvent instanceof StateEvent.ClearMetadataValue) {
                        StateEvent.ClearMetadataValue clearMetadataValue = (StateEvent.ClearMetadataValue) stateEvent;
                        String makeSafe = makeSafe(clearMetadataValue.section);
                        String str2 = clearMetadataValue.key;
                        if (str2 != null) {
                            str = str2;
                        }
                        removeMetadata(makeSafe, makeSafe(str));
                    } else if (stateEvent instanceof StateEvent.AddBreadcrumb) {
                        StateEvent.AddBreadcrumb addBreadcrumb = (StateEvent.AddBreadcrumb) stateEvent;
                        addBreadcrumb(makeSafe(addBreadcrumb.message), makeSafe(addBreadcrumb.type.toString()), makeSafe(addBreadcrumb.timestamp), addBreadcrumb.metadata);
                    } else if (Intrinsics.areEqual(stateEvent, StateEvent.NotifyHandled.INSTANCE)) {
                        addHandledEvent();
                    } else if (Intrinsics.areEqual(stateEvent, StateEvent.NotifyUnhandled.INSTANCE)) {
                        addUnhandledEvent();
                    } else if (Intrinsics.areEqual(stateEvent, StateEvent.PauseSession.INSTANCE)) {
                        pausedSession();
                    } else if (stateEvent instanceof StateEvent.StartSession) {
                        StateEvent.StartSession startSession = (StateEvent.StartSession) stateEvent;
                        startedSession(makeSafe(startSession.id), makeSafe(startSession.startedAt), startSession.handledCount, startSession.unhandledCount);
                    } else if (stateEvent instanceof StateEvent.UpdateContext) {
                        String str3 = ((StateEvent.UpdateContext) stateEvent).context;
                        if (str3 != null) {
                            str = str3;
                        }
                        updateContext(makeSafe(str));
                    } else if (stateEvent instanceof StateEvent.UpdateInForeground) {
                        StateEvent.UpdateInForeground updateInForeground = (StateEvent.UpdateInForeground) stateEvent;
                        boolean z = updateInForeground.inForeground;
                        String str4 = updateInForeground.contextActivity;
                        if (str4 != null) {
                            str = str4;
                        }
                        updateInForeground(z, makeSafe(str));
                    } else if (stateEvent instanceof StateEvent.UpdateOrientation) {
                        String str5 = ((StateEvent.UpdateOrientation) stateEvent).orientation;
                        if (str5 != null) {
                            str = str5;
                        }
                        updateOrientation(str);
                    } else if (stateEvent instanceof StateEvent.UpdateUser) {
                        StateEvent.UpdateUser updateUser = (StateEvent.UpdateUser) stateEvent;
                        String str6 = updateUser.user.id;
                        if (str6 == null) {
                            str6 = str;
                        }
                        updateUserId(makeSafe(str6));
                        String str7 = updateUser.user.name;
                        if (str7 == null) {
                            str7 = str;
                        }
                        updateUserName(makeSafe(str7));
                        String str8 = updateUser.user.email;
                        if (str8 != null) {
                            str = str8;
                        }
                        updateUserEmail(makeSafe(str));
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.bugsnag.android.StateEvent");
            }
        }
    }

    public final native void updateContext(String str);

    public final native void updateInForeground(boolean z, String str);

    public final native void updateOrientation(String str);

    public final native void updateUserEmail(String str);

    public final native void updateUserId(String str);

    public final native void updateUserName(String str);
}
