package f.b.a.f.a.a;
/* loaded from: classes.dex */
public final class s extends c {
    public final int a;
    public final boolean b;

    public /* synthetic */ s(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    @Override // f.b.a.f.a.a.c
    public final boolean a() {
        return this.b;
    }

    @Override // f.b.a.f.a.a.c
    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a == cVar.b() && this.b == cVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231);
    }

    public final String toString() {
        int i2 = this.a;
        boolean z = this.b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i2);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
