package com.bugsnag.android;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateEvent.kt */
public abstract class StateEvent {

    /* compiled from: StateEvent.kt */
    public static final class AddBreadcrumb extends StateEvent {
        public final String message;
        public final Map<String, Object> metadata;
        public final String timestamp;
        public final BreadcrumbType type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddBreadcrumb(String str, BreadcrumbType breadcrumbType, String str2, Map<String, Object> map) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "message");
            Intrinsics.checkParameterIsNotNull(breadcrumbType, "type");
            Intrinsics.checkParameterIsNotNull(str2, "timestamp");
            Intrinsics.checkParameterIsNotNull(map, "metadata");
            this.message = str;
            this.type = breadcrumbType;
            this.timestamp = str2;
            this.metadata = map;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class AddMetadata extends StateEvent {
        public final String key;
        public final String section;
        public final Object value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddMetadata(String str, String str2, Object obj) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "section");
            this.section = str;
            this.key = str2;
            this.value = obj;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class ClearMetadataSection extends StateEvent {
        public final String section;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearMetadataSection(String str) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "section");
            this.section = str;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class ClearMetadataValue extends StateEvent {
        public final String key;
        public final String section;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearMetadataValue(String str, String str2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "section");
            this.section = str;
            this.key = str2;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class DeliverPending extends StateEvent {
        public static final DeliverPending INSTANCE = new DeliverPending();

        public DeliverPending() {
            super(null);
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class Install extends StateEvent {
        public final String appVersion;
        public final boolean autoDetectNdkCrashes;
        public final String buildUuid;
        public final String releaseStage;

        public Install(boolean z, String str, String str2, String str3) {
            super(null);
            this.autoDetectNdkCrashes = z;
            this.appVersion = str;
            this.buildUuid = str2;
            this.releaseStage = str3;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class NotifyHandled extends StateEvent {
        public static final NotifyHandled INSTANCE = new NotifyHandled();

        public NotifyHandled() {
            super(null);
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class NotifyUnhandled extends StateEvent {
        public static final NotifyUnhandled INSTANCE = new NotifyUnhandled();

        public NotifyUnhandled() {
            super(null);
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class PauseSession extends StateEvent {
        public static final PauseSession INSTANCE = new PauseSession();

        public PauseSession() {
            super(null);
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class StartSession extends StateEvent {
        public final int handledCount;
        public final String id;
        public final String startedAt;
        public final int unhandledCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartSession(String str, String str2, int i, int i2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(str2, "startedAt");
            this.id = str;
            this.startedAt = str2;
            this.handledCount = i;
            this.unhandledCount = i2;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class UpdateContext extends StateEvent {
        public final String context;

        public UpdateContext(String str) {
            super(null);
            this.context = str;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class UpdateInForeground extends StateEvent {
        public final String contextActivity;
        public final boolean inForeground;

        public UpdateInForeground(boolean z, String str) {
            super(null);
            this.inForeground = z;
            this.contextActivity = str;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class UpdateOrientation extends StateEvent {
        public final String orientation;

        public UpdateOrientation(String str) {
            super(null);
            this.orientation = str;
        }
    }

    /* compiled from: StateEvent.kt */
    public static final class UpdateUser extends StateEvent {
        public final User user;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateUser(User user2) {
            super(null);
            Intrinsics.checkParameterIsNotNull(user2, "user");
            this.user = user2;
        }
    }

    public StateEvent() {
    }

    public StateEvent(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
