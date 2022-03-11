package f.a.b;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class k {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;

    /* renamed from: d */
    public final List<g> f2163d;

    /* renamed from: e */
    public final boolean f2164e;

    public k(int i2, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j2) {
        this.a = i2;
        this.b = bArr;
        this.c = map;
        this.f2163d = list == null ? null : Collections.unmodifiableList(list);
        this.f2164e = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public k(int i2, byte[] bArr, boolean z, long j2, List<g> list) {
        this(i2, bArr, r0, list, z, j2);
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (g gVar : list) {
                treeMap.put(gVar.a, gVar.b);
            }
        }
    }
}
