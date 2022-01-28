package e.c.a.x;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class c extends i {

    /* renamed from: c  reason: collision with root package name */
    public List<String> f5200c;

    /* renamed from: d  reason: collision with root package name */
    public final ConcurrentNavigableMap<String, a> f5201d = new ConcurrentSkipListMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f5202a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f5203b;

        /* renamed from: c  reason: collision with root package name */
        public final short[] f5204c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceArray<Object> f5205d;

        public a(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.f5205d = atomicReferenceArray;
            this.f5202a = str;
            this.f5203b = strArr;
            this.f5204c = sArr;
        }

        public String toString() {
            return this.f5202a;
        }
    }

    public c(InputStream inputStream) {
        new CopyOnWriteArraySet();
        try {
            c(inputStream);
        } catch (Exception e2) {
            throw new g("Unable to load TZDB time-zone rules", e2);
        }
    }

    public final boolean c(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        } else if ("TZDB".equals(dataInputStream.readUTF())) {
            int readShort = dataInputStream.readShort();
            String[] strArr = new String[readShort];
            boolean z = false;
            for (int i = 0; i < readShort; i++) {
                strArr[i] = dataInputStream.readUTF();
            }
            int readShort2 = dataInputStream.readShort();
            String[] strArr2 = new String[readShort2];
            for (int i2 = 0; i2 < readShort2; i2++) {
                strArr2[i2] = dataInputStream.readUTF();
            }
            this.f5200c = Arrays.asList(strArr2);
            int readShort3 = dataInputStream.readShort();
            Object[] objArr = new Object[readShort3];
            for (int i3 = 0; i3 < readShort3; i3++) {
                byte[] bArr = new byte[dataInputStream.readShort()];
                dataInputStream.readFully(bArr);
                objArr[i3] = bArr;
            }
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
            HashSet hashSet = new HashSet(readShort);
            for (int i4 = 0; i4 < readShort; i4++) {
                int readShort4 = dataInputStream.readShort();
                String[] strArr3 = new String[readShort4];
                short[] sArr = new short[readShort4];
                for (int i5 = 0; i5 < readShort4; i5++) {
                    strArr3[i5] = strArr2[dataInputStream.readShort()];
                    sArr[i5] = dataInputStream.readShort();
                }
                hashSet.add(new a(strArr[i4], strArr3, sArr, atomicReferenceArray));
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                a putIfAbsent = this.f5201d.putIfAbsent(aVar.f5202a, aVar);
                if (putIfAbsent == null || putIfAbsent.f5202a.equals(aVar.f5202a)) {
                    z = true;
                } else {
                    StringBuilder g = c.a.a.a.a.g("Data already loaded for TZDB time-zone rules version: ");
                    g.append(aVar.f5202a);
                    throw new g(g.toString());
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
