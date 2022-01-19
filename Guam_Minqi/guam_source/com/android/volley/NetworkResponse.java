package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NetworkResponse {
    public final List<Header> allHeaders;
    public final byte[] data;
    public final Map<String, String> headers;
    public final boolean notModified;

    public NetworkResponse(int i, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j) {
        this.data = bArr;
        this.headers = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.notModified = z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    public NetworkResponse(int i, byte[] bArr, boolean z, long j, List<Header> list) {
        this(i, bArr, r0, list, z, j);
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Header header : list) {
                treeMap.put(header.mName, header.mValue);
            }
        }
    }
}
