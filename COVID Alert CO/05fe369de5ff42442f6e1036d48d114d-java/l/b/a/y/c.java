package l.b.a.y;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c extends i {
    public List<String> c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentNavigableMap<String, a> f4481d = new ConcurrentSkipListMap();

    public static class a {
        public final String a;
        public final String[] b;
        public final short[] c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f4482d;

        public a(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.f4482d = atomicReferenceArray;
            this.a = str;
            this.b = strArr;
            this.c = sArr;
        }

        public String toString() {
            return this.a;
        }
    }

    public c(InputStream inputStream) {
        new CopyOnWriteArraySet();
        try {
            e(inputStream);
        } catch (Exception e2) {
            throw new g("Unable to load TZDB time-zone rules", e2);
        }
    }

    @Override // l.b.a.y.i
    public f b(String str, boolean z) {
        f fVar;
        g.b.a.c.c.c.u(str, "zoneId");
        a value = this.f4481d.lastEntry().getValue();
        int binarySearch = Arrays.binarySearch(value.b, str);
        if (binarySearch < 0) {
            fVar = null;
        } else {
            try {
                short s = value.c[binarySearch];
                Object obj = value.f4482d.get(s);
                if (obj instanceof byte[]) {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
                    obj = a.b(dataInputStream.readByte(), dataInputStream);
                    value.f4482d.set(s, obj);
                }
                fVar = (f) obj;
            } catch (Exception e2) {
                StringBuilder k2 = f.a.a.a.a.k("Invalid binary time-zone data: TZDB:", str, ", version: ");
                k2.append(value.a);
                throw new g(k2.toString(), e2);
            }
        }
        if (fVar != null) {
            return fVar;
        }
        throw new g(f.a.a.a.a.c("Unknown time-zone ID: ", str));
    }

    @Override // l.b.a.y.i
    public Set<String> c() {
        return new HashSet(this.c);
    }

    public final boolean e(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        } else if ("TZDB".equals(dataInputStream.readUTF())) {
            int readShort = dataInputStream.readShort();
            String[] strArr = new String[readShort];
            boolean z = false;
            for (int i2 = 0; i2 < readShort; i2++) {
                strArr[i2] = dataInputStream.readUTF();
            }
            int readShort2 = dataInputStream.readShort();
            String[] strArr2 = new String[readShort2];
            for (int i3 = 0; i3 < readShort2; i3++) {
                strArr2[i3] = dataInputStream.readUTF();
            }
            this.c = Arrays.asList(strArr2);
            int readShort3 = dataInputStream.readShort();
            Object[] objArr = new Object[readShort3];
            for (int i4 = 0; i4 < readShort3; i4++) {
                byte[] bArr = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr);
                objArr[i4] = bArr;
            }
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
            HashSet hashSet = new HashSet(readShort);
            for (int i5 = 0; i5 < readShort; i5++) {
                int readShort4 = dataInputStream.readShort();
                String[] strArr3 = new String[readShort4];
                short[] sArr = new short[readShort4];
                for (int i6 = 0; i6 < readShort4; i6++) {
                    strArr3[i6] = strArr2[dataInputStream.readShort()];
                    sArr[i6] = dataInputStream.readShort();
                }
                hashSet.add(new a(strArr[i5], strArr3, sArr, atomicReferenceArray));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                a putIfAbsent = this.f4481d.putIfAbsent(aVar.a, aVar);
                if (putIfAbsent == null || putIfAbsent.a.equals(aVar.a)) {
                    z = true;
                } else {
                    StringBuilder i7 = f.a.a.a.a.i("Data already loaded for TZDB time-zone rules version: ");
                    i7.append(aVar.a);
                    throw new g(i7.toString());
                }
            }
            return z;
        } else {
            throw new StreamCorruptedException("File format not recognised");
        }
    }

    public String toString() {
        return "TZDB";
    }
}
