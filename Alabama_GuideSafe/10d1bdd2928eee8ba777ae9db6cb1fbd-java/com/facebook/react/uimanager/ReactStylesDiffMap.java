package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;

public class ReactStylesDiffMap {
    public final ReadableMap mBackingMap;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.mBackingMap = readableMap;
    }

    public int getInt(String str, int i) {
        return this.mBackingMap.isNull(str) ? i : this.mBackingMap.getInt(str);
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("{ ");
        outline17.append(ReactStylesDiffMap.class.getSimpleName());
        outline17.append(": ");
        outline17.append(this.mBackingMap.toString());
        outline17.append(" }");
        return outline17.toString();
    }
}
