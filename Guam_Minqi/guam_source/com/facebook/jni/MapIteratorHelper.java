package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import java.util.Iterator;
import java.util.Map;

@DoNotStrip
public class MapIteratorHelper {
    @DoNotStrip
    public final Iterator<Map.Entry> mIterator;
    @DoNotStrip
    public Object mKey;
    @DoNotStrip
    public Object mValue;

    @DoNotStrip
    public MapIteratorHelper(Map map) {
        this.mIterator = map.entrySet().iterator();
    }

    @DoNotStrip
    public boolean hasNext() {
        if (this.mIterator.hasNext()) {
            Map.Entry next = this.mIterator.next();
            this.mKey = next.getKey();
            this.mValue = next.getValue();
            return true;
        }
        this.mKey = null;
        this.mValue = null;
        return false;
    }
}
