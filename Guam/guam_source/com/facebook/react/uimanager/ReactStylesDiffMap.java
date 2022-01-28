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
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("{ ");
        outline15.append(ReactStylesDiffMap.class.getSimpleName());
        outline15.append(": ");
        outline15.append(this.mBackingMap.toString());
        outline15.append(" }");
        return outline15.toString();
    }
}
