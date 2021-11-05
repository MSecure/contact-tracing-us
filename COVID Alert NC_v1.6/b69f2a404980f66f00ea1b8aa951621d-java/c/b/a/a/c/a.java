package c.b.a.a.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.o;
import java.util.Arrays;

public final class a extends c.b.a.a.c.l.s.a {
    public static final Parcelable.Creator<a> CREATOR = new p();
    public static final a f = new a(0);

    /* renamed from: b  reason: collision with root package name */
    public final int f2280b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2281c;

    /* renamed from: d  reason: collision with root package name */
    public final PendingIntent f2282d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2283e;

    public a(int i) {
        this.f2280b = 1;
        this.f2281c = i;
        this.f2282d = null;
        this.f2283e = null;
    }

    public a(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f2280b = i;
        this.f2281c = i2;
        this.f2282d = pendingIntent;
        this.f2283e = str;
    }

    public static String s(int i) {
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
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2281c == aVar.f2281c && i.j.X(this.f2282d, aVar.f2282d) && i.j.X(this.f2283e, aVar.f2283e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2281c), this.f2282d, this.f2283e});
    }

    public final boolean p() {
        return (this.f2281c == 0 || this.f2282d == null) ? false : true;
    }

    public final boolean q() {
        return this.f2281c == 0;
    }

    public final String toString() {
        o j1 = i.j.j1(this);
        j1.a("statusCode", s(this.f2281c));
        j1.a("resolution", this.f2282d);
        j1.a("message", this.f2283e);
        return j1.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2280b);
        i.j.u1(parcel, 2, this.f2281c);
        i.j.y1(parcel, 3, this.f2282d, i, false);
        i.j.z1(parcel, 4, this.f2283e, false);
        i.j.F1(parcel, e2);
    }

    public a(int i, PendingIntent pendingIntent) {
        this.f2280b = 1;
        this.f2281c = i;
        this.f2282d = pendingIntent;
        this.f2283e = null;
    }

    public a(int i, PendingIntent pendingIntent, String str) {
        this.f2280b = 1;
        this.f2281c = i;
        this.f2282d = null;
        this.f2283e = str;
    }
}
