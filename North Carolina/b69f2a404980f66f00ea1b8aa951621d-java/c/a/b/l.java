package c.a.b;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f2217a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f2218b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f2219c;

    /* renamed from: d  reason: collision with root package name */
    public final List<h> f2220d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2221e;

    public l(int i, byte[] bArr, Map<String, String> map, List<h> list, boolean z, long j) {
        this.f2217a = i;
        this.f2218b = bArr;
        this.f2219c = map;
        this.f2220d = list == null ? null : Collections.unmodifiableList(list);
        this.f2221e = z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    public l(int i, byte[] bArr, boolean z, long j, List<h> list) {
        this(i, bArr, r0, list, z, j);
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (h hVar : list) {
                treeMap.put(hVar.f2211a, hVar.f2212b);
            }
        }
    }
}
