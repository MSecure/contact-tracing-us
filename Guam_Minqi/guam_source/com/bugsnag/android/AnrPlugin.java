package com.bugsnag.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnrPlugin.kt */
public final class AnrPlugin implements Plugin {
    @Deprecated
    public static final Companion Companion = new Companion(null);
    public static final String LOAD_ERR_MSG = "Native library could not be linked. Bugsnag will not report ANRs. See https://docs.bugsnag.com/platforms/android/anr-link-errors";
    public Client client;
    public final AnrDetailsCollector collector = new AnrDetailsCollector();
    public final LibraryLoader loader = new LibraryLoader();

    /* compiled from: AnrPlugin.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static final /* synthetic */ Client access$getClient$p(AnrPlugin anrPlugin) {
        Client client2 = anrPlugin.client;
        if (client2 != null) {
            return client2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("client");
        throw null;
    }

    private final native void disableAnrReporting();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void enableAnrReporting(boolean z);

    private final void notifyAnrDetected() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        Thread thread = mainLooper.getThread();
        RuntimeException runtimeException = new RuntimeException();
        Intrinsics.checkExpressionValueIsNotNull(thread, "thread");
        runtimeException.setStackTrace(thread.getStackTrace());
        Client client2 = this.client;
        if (client2 != null) {
            Event createEvent = NativeInterface.createEvent(runtimeException, client2, HandledState.newInstance("anrError"));
            Intrinsics.checkExpressionValueIsNotNull(createEvent, "NativeInterface.createEv…ate.REASON_ANR)\n        )");
            Error error = createEvent.impl.errors.get(0);
            Intrinsics.checkExpressionValueIsNotNull(error, "err");
            error.setErrorClass("ANR");
            error.impl.errorMessage = "Application did not respond to UI input";
            AnrDetailsCollector anrDetailsCollector = this.collector;
            Client client3 = this.client;
            if (client3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("client");
                throw null;
            } else if (anrDetailsCollector != null) {
                Intrinsics.checkParameterIsNotNull(client3, "client");
                Intrinsics.checkParameterIsNotNull(createEvent, "event");
                Handler handler = new Handler(anrDetailsCollector.handlerThread.getLooper());
                handler.post(new AnrDetailsCollector$collectAnrErrorDetails$1(anrDetailsCollector, client3, new AtomicInteger(), handler, createEvent));
            } else {
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("client");
            throw null;
        }
    }

    @Override // com.bugsnag.android.Plugin
    public void load(Client client2) {
        Intrinsics.checkParameterIsNotNull(client2, "client");
        if (this.loader.loadLibrary("bugsnag-plugin-android-anr", client2, AnrPlugin$load$loaded$1.INSTANCE)) {
            new Handler(Looper.getMainLooper()).post(new AnrPlugin$load$1(this, client2));
        } else {
            client2.logger.e(LOAD_ERR_MSG);
        }
    }

    public void unload() {
        disableAnrReporting();
    }
}
