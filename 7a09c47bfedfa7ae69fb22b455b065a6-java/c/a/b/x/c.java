package c.a.b.x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f2863e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f2864a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f2865b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    public int f2866c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f2867d;

    public class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i) {
        this.f2867d = i;
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f2865b.size(); i2++) {
            byte[] bArr = this.f2865b.get(i2);
            if (bArr.length >= i) {
                this.f2866c -= bArr.length;
                this.f2865b.remove(i2);
                this.f2864a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2867d) {
                this.f2864a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f2865b, bArr, f2863e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f2865b.add(binarySearch, bArr);
                this.f2866c += bArr.length;
                synchronized (this) {
                    while (this.f2866c > this.f2867d) {
                        byte[] remove = this.f2864a.remove(0);
                        this.f2865b.remove(remove);
                        this.f2866c -= remove.length;
                    }
                }
            }
        }
    }
}
