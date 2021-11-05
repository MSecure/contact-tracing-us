package c.a.b.x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f2250e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f2251a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f2252b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f2253c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f2254d;

    public class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i) {
        this.f2254d = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f2252b.size(); i2++) {
            byte[] bArr = this.f2252b.get(i2);
            if (bArr.length >= i) {
                this.f2253c -= bArr.length;
                this.f2252b.remove(i2);
                this.f2251a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2254d) {
                this.f2251a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f2252b, bArr, f2250e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f2252b.add(binarySearch, bArr);
                this.f2253c += bArr.length;
                synchronized (this) {
                    while (this.f2253c > this.f2254d) {
                        byte[] remove = this.f2251a.remove(0);
                        this.f2252b.remove(remove);
                        this.f2253c -= remove.length;
                    }
                }
            }
        }
    }
}
