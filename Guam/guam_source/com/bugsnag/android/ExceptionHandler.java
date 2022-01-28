package com.bugsnag.android;

import android.os.StrictMode;
import android.text.TextUtils;
import java.lang.Thread;
import java.util.Locale;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    public final Client client;
    public final Logger logger;
    public final Thread.UncaughtExceptionHandler originalHandler;
    public final StrictModeHandler strictModeHandler = new StrictModeHandler();

    public ExceptionHandler(Client client2, Logger logger2) {
        this.client = client2;
        this.logger = logger2;
        this.originalHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Throwable th2;
        String str;
        String str2;
        StrictModeHandler strictModeHandler2 = this.strictModeHandler;
        if (strictModeHandler2 != null) {
            Throwable cause = th.getCause();
            if (cause == null) {
                th2 = th;
            } else {
                th2 = strictModeHandler2.getRootCause(cause);
            }
            boolean startsWith = th2.getClass().getName().toLowerCase(Locale.US).startsWith("android.os.strictmode");
            Metadata metadata = new Metadata();
            if (startsWith) {
                StrictModeHandler strictModeHandler3 = this.strictModeHandler;
                String message = th.getMessage();
                if (strictModeHandler3 == null) {
                    throw null;
                } else if (!TextUtils.isEmpty(message)) {
                    int lastIndexOf = message.lastIndexOf("violation=");
                    if (lastIndexOf != -1) {
                        String replace = message.substring(lastIndexOf).replace("violation=", "");
                        if (TextUtils.isDigitsOnly(replace)) {
                            str2 = StrictModeHandler.POLICY_CODE_MAP.get(Integer.valueOf(replace));
                            Metadata metadata2 = new Metadata();
                            metadata2.addMetadata("StrictMode", "Violation", str2);
                            str = str2;
                            metadata = metadata2;
                        }
                    }
                    str2 = null;
                    Metadata metadata22 = new Metadata();
                    metadata22.addMetadata("StrictMode", "Violation", str2);
                    str = str2;
                    metadata = metadata22;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                str = null;
            }
            String str3 = startsWith ? "strictMode" : "unhandledException";
            if (startsWith) {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                this.client.notifyUnhandledException(th, metadata, str3, str);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                this.client.notifyUnhandledException(th, metadata, str3, null);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.originalHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            System.err.printf("Exception in thread \"%s\" ", thread.getName());
            this.logger.w("Exception", th);
            return;
        }
        throw null;
    }
}
