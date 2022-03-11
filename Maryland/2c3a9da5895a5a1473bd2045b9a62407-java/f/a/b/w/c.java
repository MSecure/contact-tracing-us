package f.a.b.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final Comparator<byte[]> f2073e = new a();
    public final List<byte[]> a = new ArrayList();
    public final List<byte[]> b = new ArrayList(64);
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final int f2074d;

    public class a implements Comparator<byte[]> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i2) {
        this.f2074d = i2;
    }

    public synchronized byte[] a(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            byte[] bArr = this.b.get(i3);
            if (bArr.length >= i2) {
                this.c -= bArr.length;
                this.b.remove(i3);
                this.a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2074d) {
                this.a.add(bArr);
                int binarySearch = Collections.binarySearch(this.b, bArr, f2073e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.b.add(binarySearch, bArr);
                this.c += bArr.length;
                synchronized (this) {
                    while (this.c > this.f2074d) {
                        byte[] remove = this.a.remove(0);
                        this.b.remove(remove);
                        this.c -= remove.length;
                    }
                }
            }
        }
    }
}
