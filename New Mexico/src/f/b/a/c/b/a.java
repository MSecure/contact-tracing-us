package f.b.a.c.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.l;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a extends f.b.a.c.b.m.n.a {
    public final int b;
    public final int c;

    /* renamed from: d */
    public final PendingIntent f2667d;

    /* renamed from: e */
    public final String f2668e;
    @RecentlyNonNull

    /* renamed from: f */
    public static final a f2666f = new a(0);
    @RecentlyNonNull
    public static final Parcelable.Creator<a> CREATOR = new q();

    public a(@RecentlyNonNull int i2) {
        this.b = 1;
        this.c = i2;
        this.f2667d = null;
        this.f2668e = null;
    }

    public a(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.b = i2;
        this.c = i3;
        this.f2667d = pendingIntent;
        this.f2668e = str;
    }

    public static String g(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i2);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    @RecentlyNonNull
    public final boolean d() {
        return this.c == 0;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.c == aVar.c && m.e.X(this.f2667d, aVar.f2667d) && m.e.X(this.f2668e, aVar.f2668e);
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), this.f2667d, this.f2668e});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        l lVar = new l(this, null);
        lVar.a("statusCode", g(this.c));
        lVar.a("resolution", this.f2667d);
        lVar.a("message", this.f2668e);
        return lVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i4);
        m.e.f2(parcel, 3, this.f2667d, i2, false);
        m.e.g2(parcel, 4, this.f2668e, false);
        m.e.o2(parcel, j2);
    }

    public a(@RecentlyNonNull int i2, PendingIntent pendingIntent) {
        this.b = 1;
        this.c = i2;
        this.f2667d = pendingIntent;
        this.f2668e = null;
    }
}
