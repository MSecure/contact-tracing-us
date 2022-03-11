package f.b.a.f.a.d;

import com.google.android.play.core.install.InstallState;
import java.util.Objects;
/* loaded from: classes.dex */
public final class c extends InstallState {
    public final int a;
    public final long b;
    public final long c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3354d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3355e;

    public c(int i2, long j2, long j3, int i3, String str) {
        this.a = i2;
        this.b = j2;
        this.c = j3;
        this.f3354d = i3;
        Objects.requireNonNull(str, "Null packageName");
        this.f3355e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.f3354d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.f3355e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.a == installState.c() && this.b == installState.a() && this.c == installState.e() && this.f3354d == installState.b() && this.f3355e.equals(installState.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.a;
        long j2 = this.b;
        long j3 = this.c;
        return ((((((((i2 ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f3354d) * 1000003) ^ this.f3355e.hashCode();
    }

    public final String toString() {
        int i2 = this.a;
        long j2 = this.b;
        long j3 = this.c;
        int i3 = this.f3354d;
        String str = this.f3355e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j2);
        sb.append(", totalBytesToDownload=");
        sb.append(j3);
        sb.append(", installErrorCode=");
        sb.append(i3);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
