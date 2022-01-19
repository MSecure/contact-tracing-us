package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bugsnag.android.JsonStream;
import com.horcrux.svg.PathParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Metadata.kt */
public final class Metadata implements JsonStream.Streamable {
    public final ObjectJsonStreamer jsonStreamer;
    public final Set<String> redactedKeys;
    public final Map<String, Object> store;

    public Metadata() {
        this(null, null, null, 7);
    }

    public Metadata(Map<String, Object> map, ObjectJsonStreamer objectJsonStreamer, Set<String> set) {
        Intrinsics.checkParameterIsNotNull(map, "store");
        Intrinsics.checkParameterIsNotNull(objectJsonStreamer, "jsonStreamer");
        Intrinsics.checkParameterIsNotNull(set, "redactedKeys");
        this.store = map;
        this.jsonStreamer = objectJsonStreamer;
        this.redactedKeys = set;
    }

    public static final Map<String, Object> mergeMaps$bugsnag_android_core_release(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkParameterIsNotNull(list, BugsnagReactNative.DATA_KEY);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            PathParser.addAll(arrayList, it.next().keySet());
        }
        Set<String> set = CollectionsKt__CollectionsKt.toSet(arrayList);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator<? extends Map<String, ? extends Object>> it2 = list.iterator();
        while (it2.hasNext()) {
            Map map = (Map) it2.next();
            for (String str : set) {
                Object obj = concurrentHashMap.get(str);
                Object obj2 = map.get(str);
                if (obj2 != null) {
                    if (!(obj instanceof Map) || !(obj2 instanceof Map)) {
                        concurrentHashMap.put(str, obj2);
                    } else {
                        concurrentHashMap.put(str, mergeMaps$bugsnag_android_core_release(CollectionsKt__CollectionsKt.listOf((Map) obj, (Map) obj2)));
                    }
                } else if (obj != null) {
                    concurrentHashMap.put(str, obj);
                }
            }
        }
        return concurrentHashMap;
    }

    public void addMetadata(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        Intrinsics.checkParameterIsNotNull(map, "value");
        for (T t : map.entrySet()) {
            addMetadata(str, (String) t.getKey(), t.getValue());
        }
    }

    public void clearMetadata(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        Intrinsics.checkParameterIsNotNull(str2, "key");
        Object obj = this.store.get(str);
        if (TypeIntrinsics.isMutableMap(obj)) {
            Map map = (Map) obj;
            if (map != null) {
                TypeIntrinsics.asMutableMap(map).remove(str2);
                if (map.isEmpty()) {
                    this.store.remove(str);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        }
    }

    public final Metadata copy() {
        Map mutableMap = PathParser.toMutableMap(toMap());
        ObjectJsonStreamer objectJsonStreamer = this.jsonStreamer;
        Set<String> set = this.redactedKeys;
        Intrinsics.checkParameterIsNotNull(mutableMap, "store");
        Intrinsics.checkParameterIsNotNull(objectJsonStreamer, "jsonStreamer");
        Intrinsics.checkParameterIsNotNull(set, "redactedKeys");
        return new Metadata(mutableMap, objectJsonStreamer, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        return Intrinsics.areEqual(this.store, metadata.store) && Intrinsics.areEqual(this.jsonStreamer, metadata.jsonStreamer) && Intrinsics.areEqual(this.redactedKeys, metadata.redactedKeys);
    }

    public int hashCode() {
        Map<String, Object> map = this.store;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        ObjectJsonStreamer objectJsonStreamer = this.jsonStreamer;
        int hashCode2 = (hashCode + (objectJsonStreamer != null ? objectJsonStreamer.hashCode() : 0)) * 31;
        Set<String> set = this.redactedKeys;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setRedactedKeys(Collection<String> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "redactKeys");
        HashSet hashSet = new HashSet(collection);
        this.jsonStreamer.redactedKeys.clear();
        this.jsonStreamer.redactedKeys.addAll(hashSet);
    }

    public final Map<String, Object> toMap() {
        HashMap hashMap = new HashMap(this.store);
        for (T t : this.store.entrySet()) {
            if (t.getValue() instanceof ConcurrentHashMap) {
                Object key = t.getKey();
                Object value = t.getValue();
                if (value != null) {
                    hashMap.put(key, new ConcurrentHashMap((ConcurrentHashMap) value));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<*, *>");
                }
            }
        }
        return hashMap;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        this.jsonStreamer.objectToStream(this.store, jsonStream, true);
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Metadata(store=");
        outline15.append(this.store);
        outline15.append(", jsonStreamer=");
        outline15.append(this.jsonStreamer);
        outline15.append(", redactedKeys=");
        outline15.append(this.redactedKeys);
        outline15.append(")");
        return outline15.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Metadata(Map map, ObjectJsonStreamer objectJsonStreamer, Set set, int i) {
        this(map, r2, (i & 4) != 0 ? r2.redactedKeys : r3);
        map = (i & 1) != 0 ? new ConcurrentHashMap() : map;
        Set<String> set2 = null;
        ObjectJsonStreamer objectJsonStreamer2 = (i & 2) != 0 ? new ObjectJsonStreamer() : null;
    }

    public void addMetadata(String str, String str2, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "section");
        Intrinsics.checkParameterIsNotNull(str2, "key");
        if (obj == null) {
            clearMetadata(str, str2);
            return;
        }
        Object obj2 = this.store.get(str);
        if (!TypeIntrinsics.isMutableMap(obj2)) {
            obj2 = new ConcurrentHashMap();
            this.store.put(str, obj2);
        }
        if (obj2 != null) {
            Map asMutableMap = TypeIntrinsics.asMutableMap(obj2);
            if (TypeIntrinsics.isMutableMap(obj) && (!asMutableMap.isEmpty())) {
                obj = mergeMaps$bugsnag_android_core_release(CollectionsKt__CollectionsKt.listOf(asMutableMap, (Map) obj));
            }
            asMutableMap.put(str2, obj);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
    }
}
