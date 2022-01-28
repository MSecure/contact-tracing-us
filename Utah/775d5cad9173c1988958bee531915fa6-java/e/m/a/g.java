package e.m.a;

import e.m.a.n.a;
import e.m.a.n.b;
import java.nio.ByteBuffer;

public class g {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<a> f1641d = new ThreadLocal<>();
    public final int a;
    public final k b;
    public volatile int c = 0;

    public g(k kVar, int i2) {
        this.b = kVar;
        this.a = i2;
    }

    public int a(int i2) {
        a e2 = e();
        int a2 = e2.a(16);
        if (a2 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = e2.b;
        int i3 = a2 + e2.a;
        return byteBuffer.getInt((i2 * 4) + byteBuffer.getInt(i3) + i3 + 4);
    }

    public int b() {
        a e2 = e();
        int a2 = e2.a(16);
        if (a2 == 0) {
            return 0;
        }
        int i2 = a2 + e2.a;
        return e2.b.getInt(e2.b.getInt(i2) + i2);
    }

    public short c() {
        a e2 = e();
        int a2 = e2.a(14);
        if (a2 != 0) {
            return e2.b.getShort(a2 + e2.a);
        }
        return 0;
    }

    public int d() {
        a e2 = e();
        int a2 = e2.a(4);
        if (a2 != 0) {
            return e2.b.getInt(a2 + e2.a);
        }
        return 0;
    }

    public final a e() {
        ThreadLocal<a> threadLocal = f1641d;
        a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        b bVar = this.b.a;
        int i2 = this.a;
        int a2 = bVar.a(6);
        if (a2 != 0) {
            int i3 = a2 + bVar.a;
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
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(Integer.toHexString(a(i2)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
