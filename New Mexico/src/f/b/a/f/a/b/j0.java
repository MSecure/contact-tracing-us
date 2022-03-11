package f.b.a.f.a.b;
/* loaded from: classes.dex */
public final class j0 extends x2 {
    public final int a;
    public final String b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3245d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3246e;

    public j0(int i2, String str, long j2, long j3, int i3) {
        this.a = i2;
        this.b = str;
        this.c = j2;
        this.f3245d = j3;
        this.f3246e = i3;
    }

    @Override // f.b.a.f.a.b.x2
    public final int a() {
        return this.a;
    }

    @Override // f.b.a.f.a.b.x2
    public final int b() {
        return this.f3246e;
    }

    @Override // f.b.a.f.a.b.x2
    public final long c() {
        return this.c;
    }

    @Override // f.b.a.f.a.b.x2
    public final long d() {
        return this.f3245d;
    }

    @Override // f.b.a.f.a.b.x2
    public final String e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x2) {
            x2 x2Var = (x2) obj;
            if (this.a == x2Var.a() && ((str = this.b) != null ? str.equals(x2Var.e()) : x2Var.e() == null) && this.c == x2Var.c() && this.f3245d == x2Var.d() && this.f3246e == x2Var.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.c;
        long j3 = this.f3245d;
        return ((((((i2 ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f3246e;
    }

    public final String toString() {
        int i2 = this.a;
        String str = this.b;
        long j2 = this.c;
        long j3 = this.f3245d;
        int i3 = this.f3246e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i2);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j2);
        sb.append(", remainingBytes=");
        sb.append(j3);
        sb.append(", previousChunk=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
