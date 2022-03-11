package f.b.a.f.a.b;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class k0 extends e3 {
    public final String a;
    public final long b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3254d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3255e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f3256f;

    public k0(String str, long j2, int i2, boolean z, boolean z2, byte[] bArr) {
        this.a = str;
        this.b = j2;
        this.c = i2;
        this.f3254d = z;
        this.f3255e = z2;
        this.f3256f = bArr;
    }

    @Override // f.b.a.f.a.b.e3
    public final int a() {
        return this.c;
    }

    @Override // f.b.a.f.a.b.e3
    public final long b() {
        return this.b;
    }

    @Override // f.b.a.f.a.b.e3
    public final String c() {
        return this.a;
    }

    @Override // f.b.a.f.a.b.e3
    public final boolean d() {
        return this.f3255e;
    }

    @Override // f.b.a.f.a.b.e3
    public final boolean e() {
        return this.f3254d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e3) {
            e3 e3Var = (e3) obj;
            String str = this.a;
            if (str != null ? str.equals(e3Var.c()) : e3Var.c() == null) {
                if (this.b == e3Var.b() && this.c == e3Var.a() && this.f3254d == e3Var.e() && this.f3255e == e3Var.d()) {
                    if (Arrays.equals(this.f3256f, e3Var instanceof k0 ? ((k0) e3Var).f3256f : e3Var.f())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // f.b.a.f.a.b.e3
    public final byte[] f() {
        return this.f3256f;
    }

    public final int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.b;
        int i2 = 1237;
        int i3 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (true != this.f3254d ? 1237 : 1231)) * 1000003;
        if (true == this.f3255e) {
            i2 = 1231;
        }
        return ((i3 ^ i2) * 1000003) ^ Arrays.hashCode(this.f3256f);
    }

    public final String toString() {
        String str = this.a;
        long j2 = this.b;
        int i2 = this.c;
        boolean z = this.f3254d;
        boolean z2 = this.f3255e;
        String arrays = Arrays.toString(this.f3256f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j2);
        sb.append(", compressionMethod=");
        sb.append(i2);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
