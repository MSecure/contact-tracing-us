package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class Session implements JsonStream.Streamable {
    public App app;
    public final AtomicBoolean autoCaptured;
    public Device device;
    public final File file;
    public final AtomicInteger handledCount;
    public String id;
    public final AtomicBoolean isPaused;
    public final Logger logger;
    public final Notifier notifier;
    public Date startedAt;
    public final AtomicBoolean tracked;
    public final AtomicInteger unhandledCount;
    public User user;

    public Session(String str, Date date, User user2, boolean z, Notifier notifier2, Logger logger2) {
        this.autoCaptured = new AtomicBoolean(false);
        this.unhandledCount = new AtomicInteger();
        this.handledCount = new AtomicInteger();
        this.tracked = new AtomicBoolean(false);
        this.isPaused = new AtomicBoolean(false);
        this.id = str;
        this.startedAt = new Date(date.getTime());
        this.user = user2;
        this.logger = logger2;
        this.autoCaptured.set(z);
        this.file = null;
        this.notifier = notifier2;
    }

    public static Session copySession(Session session) {
        Session session2 = new Session(session.id, session.startedAt, session.user, session.unhandledCount.get(), session.handledCount.get(), session.notifier, session.logger);
        session2.tracked.set(session.tracked.get());
        session2.autoCaptured.set(session.isAutoCaptured());
        return session2;
    }

    public boolean isAutoCaptured() {
        return this.autoCaptured.get();
    }

    public boolean isV2Payload() {
        File file2 = this.file;
        return file2 != null && file2.getName().endsWith("_v2.json");
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        if (this.file == null) {
            jsonStream.beginObject();
            jsonStream.name("notifier");
            jsonStream.value(this.notifier);
            jsonStream.name("app");
            jsonStream.value(this.app);
            jsonStream.name("device");
            jsonStream.value(this.device);
            jsonStream.name("sessions");
            jsonStream.beginArray();
            jsonStream.beginObject();
            jsonStream.name("id");
            jsonStream.value(this.id);
            jsonStream.name("startedAt");
            jsonStream.value(DateUtils.toIso8601(this.startedAt));
            jsonStream.name("user");
            jsonStream.value(this.user);
            jsonStream.endObject();
            jsonStream.endArray();
            jsonStream.endObject();
        } else if (isV2Payload()) {
            jsonStream.value(this.file);
        } else {
            jsonStream.beginObject();
            jsonStream.name("notifier");
            jsonStream.value(this.notifier);
            jsonStream.name("app");
            jsonStream.value(this.app);
            jsonStream.name("device");
            jsonStream.value(this.device);
            jsonStream.name("sessions");
            jsonStream.beginArray();
            jsonStream.value(this.file);
            jsonStream.endArray();
            jsonStream.endObject();
        }
    }

    public Session(String str, Date date, User user2, int i, int i2, Notifier notifier2, Logger logger2) {
        this(str, date, user2, false, notifier2, logger2);
        this.unhandledCount.set(i);
        this.handledCount.set(i2);
        this.tracked.set(true);
    }

    public Session(File file2, Notifier notifier2, Logger logger2) {
        this.autoCaptured = new AtomicBoolean(false);
        this.unhandledCount = new AtomicInteger();
        this.handledCount = new AtomicInteger();
        this.tracked = new AtomicBoolean(false);
        this.isPaused = new AtomicBoolean(false);
        this.file = file2;
        this.logger = logger2;
        this.notifier = notifier2;
    }
}
