package f.b.a.f.a.b;

import f.b.a.f.a.e.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class g0 extends p {
    public final File b;
    public final File c;

    /* renamed from: d  reason: collision with root package name */
    public final NavigableMap<Long, File> f3226d = new TreeMap();

    public g0(File file, File file2) {
        this.b = file;
        this.c = file2;
        ArrayList arrayList = (ArrayList) a3.a(file, file2);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            long j2 = 0;
            while (it.hasNext()) {
                File file3 = (File) it.next();
                this.f3226d.put(Long.valueOf(j2), file3);
                j2 += file3.length();
            }
            return;
        }
        throw new z0(String.format("Virtualized slice archive empty for %s, %s", file, file2));
    }

    @Override // f.b.a.f.a.e.p
    public final long c() {
        Map.Entry<Long, File> lastEntry = this.f3226d.lastEntry();
        return lastEntry.getValue().length() + lastEntry.getKey().longValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // f.b.a.f.a.e.p
    public final InputStream d(long j2, long j3) {
        if (j2 < 0 || j3 < 0) {
            throw new z0(String.format("Invalid input parameters %s, %s", Long.valueOf(j2), Long.valueOf(j3)));
        }
        long j4 = j2 + j3;
        if (j4 <= c()) {
            Long floorKey = this.f3226d.floorKey(Long.valueOf(j2));
            Long floorKey2 = this.f3226d.floorKey(Long.valueOf(j4));
            if (floorKey.equals(floorKey2)) {
                return new f0(t(j2, floorKey), j3);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(t(j2, floorKey));
            Collection<File> values = this.f3226d.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new c2(Collections.enumeration(values)));
            }
            arrayList.add(new f0(new FileInputStream((File) this.f3226d.get(floorKey2)), j3 - (floorKey2.longValue() - j2)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new z0(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", Long.valueOf(c()), Long.valueOf(j4)));
    }

    public final InputStream t(long j2, Long l2) {
        FileInputStream fileInputStream = new FileInputStream((File) this.f3226d.get(l2));
        if (fileInputStream.skip(j2 - l2.longValue()) == j2 - l2.longValue()) {
            return fileInputStream;
        }
        throw new z0(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", l2));
    }
}
