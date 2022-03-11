package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e.b.a.m;
import f.b.a.c.b.m.n.a;

public final class u extends a {
    public static final Parcelable.Creator<u> CREATOR = new w();
    public final int b;
    public final Account c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2489d;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleSignInAccount f2490e;

    public u(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.b = i2;
        this.c = account;
        this.f2489d = i3;
        this.f2490e = googleSignInAccount;
    }

    public u(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.b = 2;
        this.c = account;
        this.f2489d = i2;
        this.f2490e = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.E1(parcel, 2, this.c, i2, false);
        int i4 = this.f2489d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i4);
        m.h.E1(parcel, 4, this.f2490e, i2, false);
        m.h.N1(parcel, I1);
    }
}
