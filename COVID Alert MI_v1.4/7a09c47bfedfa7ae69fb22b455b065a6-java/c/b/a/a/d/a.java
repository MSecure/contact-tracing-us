package c.b.a.a.d;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.m.m;
import java.util.Arrays;

public final class a extends c.b.a.a.d.m.o.a {
    @RecentlyNonNull
    public static final Parcelable.Creator<a> CREATOR = new q();
    @RecentlyNonNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f2916f = new a(0);

    /* renamed from: b  reason: collision with root package name */
    public final int f2917b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2918c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f2919d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2920e;

    public a(@RecentlyNonNull int i) {
        this.f2917b = 1;
        this.f2918c = i;
        this.f2919d = null;
        this.f2920e = null;
    }

    public a(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f2917b = i;
        this.f2918c = i2;
        this.f2919d = pendingIntent;
        this.f2920e = str;
    }

    public static String y(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
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
                switch (i) {
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
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2918c == aVar.f2918c && t.j1(this.f2919d, aVar.f2919d) && t.j1(this.f2920e, aVar.f2920e);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2918c), this.f2919d, this.f2920e});
    }

    @RecentlyNonNull
    public final boolean t() {
        return (this.f2918c == 0 || this.f2919d == null) ? false : true;
    }

    @RecentlyNonNull
    public final String toString() {
        m a3 = t.a3(this);
        a3.a("statusCode", y(this.f2918c));
        a3.a("resolution", this.f2919d);
        a3.a("message", this.f2920e);
        return a3.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f2917b);
        t.q3(parcel, 2, this.f2918c);
        t.v3(parcel, 3, this.f2919d, i, false);
        t.w3(parcel, 4, this.f2920e, false);
        t.w4(parcel, m);
    }

    @RecentlyNonNull
    public final boolean x() {
        return this.f2918c == 0;
    }

    public a(@RecentlyNonNull int i, PendingIntent pendingIntent) {
        this.f2917b = 1;
        this.f2918c = i;
        this.f2919d = pendingIntent;
        this.f2920e = null;
    }

    public a(@RecentlyNonNull int i, PendingIntent pendingIntent, String str) {
        this.f2917b = 1;
        this.f2918c = i;
        this.f2919d = null;
        this.f2920e = str;
    }
}
