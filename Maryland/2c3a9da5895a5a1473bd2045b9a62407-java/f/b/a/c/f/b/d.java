package f.b.a.c.f.b;

public enum d {
    ACTIVATED(1),
    INACTIVATED(2),
    BLUETOOTH_DISABLED(4),
    LOCATION_DISABLED(8),
    NO_CONSENT(16),
    NOT_IN_ALLOWLIST(32),
    BLUETOOTH_SUPPORT_UNKNOWN(64),
    HW_NOT_SUPPORT(128),
    FOCUS_LOST(256),
    LOW_STORAGE(512),
    UNKNOWN(1024),
    EN_NOT_SUPPORT(2048),
    USER_PROFILE_NOT_SUPPORT(4096);
    
    public final long b;

    /* access modifiers changed from: public */
    d(long j2) {
        this.b = j2;
    }
}
