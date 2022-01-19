package io.realm;

public enum Sort {
    ASCENDING(true),
    DESCENDING(false);
    
    public final boolean value;

    /* access modifiers changed from: public */
    Sort(boolean z) {
        this.value = z;
    }
}
