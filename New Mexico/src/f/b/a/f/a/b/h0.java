package f.b.a.f.a.b;
/* loaded from: classes.dex */
public final class h0 extends b {
    public final String a;
    public final String b;

    public h0(int i2, String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // f.b.a.f.a.b.b
    public final String a() {
        return this.b;
    }

    @Override // f.b.a.f.a.b.b
    public final int b() {
        return 0;
    }

    @Override // f.b.a.f.a.b.b
    public final String c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.b() == 0 && ((str = this.a) != null ? str.equals(bVar.c()) : bVar.c() == null)) {
                String str2 = this.b;
                String a = bVar.a();
                if (str2 != null ? str2.equals(a) : a == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ -721379959) * 1000003;
        String str2 = this.b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(0);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
