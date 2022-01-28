package com.bugsnag.android;

import android.app.ActivityManager;
import com.bugsnag.android.StateEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

public class SessionTracker extends BaseObservable {
    public final CallbackState callbackState;
    public final Client client;
    public final ImmutableConfig configuration;
    public final AtomicReference<Session> currentSession = new AtomicReference<>();
    public final Semaphore flushingRequest = new Semaphore(1);
    public final Collection<String> foregroundActivities = new ConcurrentLinkedQueue();
    public final ForegroundDetector foregroundDetector;
    public final AtomicLong lastEnteredForegroundMs = new AtomicLong(0);
    public final AtomicLong lastExitedForegroundMs = new AtomicLong(0);
    public final Logger logger;
    public final SessionStore sessionStore;
    public final long timeoutMs;

    public SessionTracker(ImmutableConfig immutableConfig, CallbackState callbackState2, Client client2, SessionStore sessionStore2, Logger logger2) {
        this.configuration = immutableConfig;
        this.callbackState = callbackState2;
        this.client = client2;
        this.timeoutMs = 30000;
        this.sessionStore = sessionStore2;
        this.foregroundDetector = new ForegroundDetector(client2.appContext);
        this.logger = logger2;
        notifyNdkInForeground();
    }

    public DeliveryStatus deliverSessionPayload(Session session) {
        ImmutableConfig immutableConfig = this.configuration;
        String str = immutableConfig.endpoints.sessions;
        HashMap hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "1.0");
        hashMap.put("Bugsnag-Api-Key", immutableConfig.apiKey);
        String iso8601 = DateUtils.toIso8601(new Date());
        Intrinsics.checkExpressionValueIsNotNull(iso8601, "DateUtils.toIso8601(Date())");
        hashMap.put("Bugsnag-Sent-At", iso8601);
        return this.configuration.delivery.deliver(session, new DeliveryParams(str, hashMap));
    }

    public void flushStoredSession(File file) {
        Session session = new Session(file, this.client.notifier, this.logger);
        if (!session.isV2Payload()) {
            AppDataCollector appDataCollector = this.client.appDataCollector;
            session.app = new App(appDataCollector.config, appDataCollector.binaryArch, appDataCollector.packageName, appDataCollector.releaseStage, appDataCollector.versionName, appDataCollector.codeBundleId);
            session.device = this.client.deviceDataCollector.generateDevice();
        }
        int ordinal = deliverSessionPayload(session).ordinal();
        if (ordinal == 0) {
            this.sessionStore.deleteStoredFiles(Collections.singletonList(file));
        } else if (ordinal == 1) {
            this.sessionStore.cancelQueuedFiles(Collections.singletonList(file));
            this.logger.w("Leaving session payload for future delivery");
        } else if (ordinal == 2) {
            this.logger.w("Deleting invalid session tracking payload");
            this.sessionStore.deleteStoredFiles(Collections.singletonList(file));
        }
    }

    public String getContextActivity() {
        if (this.foregroundActivities.isEmpty()) {
            return null;
        }
        int size = this.foregroundActivities.size();
        return ((String[]) this.foregroundActivities.toArray(new String[size]))[size - 1];
    }

    public Boolean isInForeground() {
        if (this.foregroundDetector != null) {
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                return Boolean.valueOf(runningAppProcessInfo.importance <= 100);
            } catch (RuntimeException unused) {
                return null;
            }
        } else {
            throw null;
        }
    }

    public final void notifyNdkInForeground() {
        Boolean isInForeground = isInForeground();
        notifyObservers(new StateEvent.UpdateInForeground(isInForeground != null ? isInForeground.booleanValue() : false, getContextActivity()));
    }

    public final void notifySessionStartObserver(Session session) {
        notifyObservers(new StateEvent.StartSession(session.id, DateUtils.toIso8601(session.startedAt), session.handledCount.intValue(), session.unhandledCount.intValue()));
    }

    public Session startNewSession(Date date, User user, boolean z) {
        boolean z2;
        final Session session = new Session(UUID.randomUUID().toString(), date, user, z, this.client.notifier, this.logger);
        this.currentSession.set(session);
        boolean shouldNotifyForReleaseStage = this.configuration.shouldNotifyForReleaseStage();
        AppDataCollector appDataCollector = this.client.appDataCollector;
        session.app = new App(appDataCollector.config, appDataCollector.binaryArch, appDataCollector.packageName, appDataCollector.releaseStage, appDataCollector.versionName, appDataCollector.codeBundleId);
        session.device = this.client.deviceDataCollector.generateDevice();
        CallbackState callbackState2 = this.callbackState;
        Logger logger2 = this.logger;
        if (callbackState2 != null) {
            Intrinsics.checkParameterIsNotNull(session, "session");
            Intrinsics.checkParameterIsNotNull(logger2, "logger");
            Iterator<T> it = callbackState2.onSessionTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                try {
                    if (!it.next().onSession(session)) {
                        z2 = false;
                        break;
                    }
                } catch (Throwable th) {
                    logger2.w("OnSessionCallback threw an Exception", th);
                }
            }
            if (z2 && shouldNotifyForReleaseStage && ((this.configuration.autoTrackSessions || !session.isAutoCaptured()) && session.tracked.compareAndSet(false, true))) {
                notifySessionStartObserver(session);
                try {
                    Async.EXECUTOR.execute(new Runnable() {
                        /* class com.bugsnag.android.SessionTracker.AnonymousClass1 */

                        public void run() {
                            SessionTracker sessionTracker = SessionTracker.this;
                            if (sessionTracker.flushingRequest.tryAcquire(1)) {
                                try {
                                    Iterator it = ((ArrayList) sessionTracker.sessionStore.findStoredFiles()).iterator();
                                    while (it.hasNext()) {
                                        sessionTracker.flushStoredSession((File) it.next());
                                    }
                                } finally {
                                    sessionTracker.flushingRequest.release(1);
                                }
                            }
                            try {
                                int ordinal = SessionTracker.this.deliverSessionPayload(session).ordinal();
                                if (ordinal == 1) {
                                    SessionTracker.this.logger.w("Storing session payload for future delivery");
                                    SessionTracker.this.sessionStore.write(session);
                                } else if (ordinal == 2) {
                                    SessionTracker.this.logger.w("Dropping invalid session tracking payload");
                                }
                            } catch (Exception e) {
                                SessionTracker.this.logger.w("Session tracking payload failed", e);
                            }
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    this.sessionStore.write(session);
                }
            }
            return session;
        }
        throw null;
    }

    public void updateForegroundTracker(String str, boolean z, long j) {
        if (z) {
            long j2 = j - this.lastExitedForegroundMs.get();
            if (this.foregroundActivities.isEmpty()) {
                this.lastEnteredForegroundMs.set(j);
                if (j2 >= this.timeoutMs && this.configuration.autoTrackSessions) {
                    startNewSession(new Date(j), this.client.userState.user, true);
                }
            }
            this.foregroundActivities.add(str);
        } else {
            this.foregroundActivities.remove(str);
            if (this.foregroundActivities.isEmpty()) {
                this.lastExitedForegroundMs.set(j);
            }
        }
        notifyNdkInForeground();
    }
}
