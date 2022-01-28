package org.matomo.sdk.dispatcher;

public enum DispatchMode {
    ALWAYS("always"),
    WIFI_ONLY("wifi_only"),
    EXCEPTION("exception");
    
    public final String key;

    /* access modifiers changed from: public */
    DispatchMode(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }
}
