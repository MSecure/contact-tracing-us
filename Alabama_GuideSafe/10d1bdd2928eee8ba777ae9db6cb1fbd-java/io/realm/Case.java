package io.realm;

public enum Case {
    SENSITIVE(true),
    INSENSITIVE(false);
    
    public final boolean value;

    /* access modifiers changed from: public */
    Case(boolean z) {
        this.value = z;
    }
}
