package e.n.a;

import e.n.a.n.a;
import e.n.a.n.b;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g {

    /* renamed from: d */
    public static final ThreadLocal<a> f1726d = new ThreadLocal<>();
    public final int a;
    public final k b;
    public volatile int c = 0;

    public g(k kVar, int i2) {
        this.b = kVar;
        this.a = i2;
    }

    public int a(int i2) {
        a e2 = e();
        int a = e2.a(16);
        if (a == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = e2.b;
        int i3 = a + e2.a;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public int b() {
        a e2 = e();
        int a = e2.a(16);
        if (a == 0) {
            return 0;
        }
        int i2 = a + e2.a;
        return e2.b.getInt(e2.b.getInt(i2) + i2);
    }

    public short c() {
        a e2 = e();
        int a = e2.a(14);
        if (a != 0) {
            return e2.b.getShort(a + e2.a);
        }
        return 0;
    }

    public int d() {
        a e2 = e();
        int a = e2.a(4);
        if (a != 0) {
            return e2.b.getInt(a + e2.a);
        }
        return 0;
    }

    public final a e() {
        ThreadLocal<a> threadLocal = f1726d;
        a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        b bVar = this.b.a;
        int i2 = this.a;
        int a = bVar.a(6);
        if (a != 0) {
            int i3 = a + bVar.a;
            int i4 = (i2 * 4) + bVar.b.getInt(i3) + i3 + 4;
            aVar.b(bVar.b.getInt(i4) + i4, bVar.b);
        }
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(d()));
        sb.append(", codepoints:");
        int b = b();
        for (int i2 = 0; i2 < b; i2++) {
            sb.append(Integer.toHexString(a(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
