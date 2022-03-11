package f.b.a.f.a.b;

import com.google.android.play.core.assetpacks.AssetPackState;
import java.util.Objects;
/* loaded from: classes.dex */
public final class i0 extends AssetPackState {
    public final String a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3236d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3237e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3238f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3239g;

    /* renamed from: h  reason: collision with root package name */
    public final String f3240h;

    /* renamed from: i  reason: collision with root package name */
    public final String f3241i;

    public i0(String str, int i2, int i3, long j2, long j3, int i4, int i5, String str2, String str3) {
        Objects.requireNonNull(str, "Null name");
        this.a = str;
        this.b = i2;
        this.c = i3;
        this.f3236d = j2;
        this.f3237e = j3;
        this.f3238f = i4;
        this.f3239g = i5;
        Objects.requireNonNull(str2, "Null availableVersionTag");
        this.f3240h = str2;
        Objects.requireNonNull(str3, "Null installedVersionTag");
        this.f3241i = str3;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long a() {
        return this.f3236d;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String c() {
        return this.a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int d() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long e() {
        return this.f3237e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            if (this.a.equals(assetPackState.c()) && this.b == assetPackState.d() && this.c == assetPackState.b() && this.f3236d == assetPackState.a() && this.f3237e == assetPackState.e() && this.f3238f == assetPackState.f() && this.f3239g == assetPackState.g() && this.f3240h.equals(assetPackState.j()) && this.f3241i.equals(assetPackState.k())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int f() {
        return this.f3238f;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int g() {
        return this.f3239g;
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode();
        int i2 = this.b;
        int i3 = this.c;
        long j2 = this.f3236d;
        long j3 = this.f3237e;
        return ((((((((((((((((hashCode ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f3238f) * 1000003) ^ this.f3239g) * 1000003) ^ this.f3240h.hashCode()) * 1000003) ^ this.f3241i.hashCode();
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String j() {
        return this.f3240h;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String k() {
        return this.f3241i;
    }

    public final String toString() {
        String str = this.a;
        int i2 = this.b;
        int i3 = this.c;
        long j2 = this.f3236d;
        long j3 = this.f3237e;
        int i4 = this.f3238f;
        int i5 = this.f3239g;
        String str2 = this.f3240h;
        String str3 = this.f3241i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 261 + str2.length() + str3.length());
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", transferProgressPercentage=");
        sb.append(i4);
        sb.append(", updateAvailability=");
        sb.append(i5);
        sb.append(", availableVersionTag=");
        sb.append(str2);
        sb.append(", installedVersionTag=");
        sb.append(str3);
        sb.append("}");
        return sb.toString();
    }
}
