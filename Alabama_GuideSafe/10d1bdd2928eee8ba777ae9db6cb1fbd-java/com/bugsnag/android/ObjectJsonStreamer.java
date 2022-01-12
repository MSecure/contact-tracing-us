package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: ObjectJsonStreamer.kt */
public final class ObjectJsonStreamer {
    public final Set<String> redactedKeys;

    public ObjectJsonStreamer() {
        String[] strArr = {"password"};
        Intrinsics.checkNotNullParameter(strArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MoreExecutors.mapCapacity(1));
        MoreExecutors.toCollection(strArr, linkedHashSet);
        this.redactedKeys = linkedHashSet;
    }

    public final void objectToStream(Object obj, JsonStream jsonStream, boolean z) throws IOException {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        if (obj == null) {
            jsonStream.nullValue();
        } else if (obj instanceof String) {
            jsonStream.writeDeferredName();
            jsonStream.beforeValue();
            jsonStream.string((String) obj);
        } else if (obj instanceof Number) {
            jsonStream.value((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonStream.value(((Boolean) obj).booleanValue());
        } else if (obj instanceof JsonStream.Streamable) {
            ((JsonStream.Streamable) obj).toStream(jsonStream);
        } else if (obj instanceof Map) {
            jsonStream.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    String str = (String) key;
                    jsonStream.name(str);
                    if (z) {
                        Set<String> set = this.redactedKeys;
                        if (!(set instanceof Collection) || !set.isEmpty()) {
                            Iterator<T> it = set.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (StringsKt__StringNumberConversionsKt.contains$default(str, it.next(), false, 2)) {
                                        z2 = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                            jsonStream.writeDeferredName();
                            jsonStream.beforeValue();
                            jsonStream.string("[REDACTED]");
                        }
                    }
                    objectToStream(entry.getValue(), jsonStream, z);
                }
            }
            jsonStream.endObject();
        } else if (obj instanceof Collection) {
            jsonStream.beginArray();
            for (Object obj2 : (Collection) obj) {
                objectToStream(obj2, jsonStream, false);
            }
            jsonStream.endArray();
        } else if (obj.getClass().isArray()) {
            jsonStream.beginArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                objectToStream(Array.get(obj, i), jsonStream, false);
            }
            jsonStream.endArray();
        } else {
            jsonStream.writeDeferredName();
            jsonStream.beforeValue();
            jsonStream.string("[OBJECT]");
        }
    }
}
