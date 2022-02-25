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
    public final int f2481d;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleSignInAccount f2482e;

    public u(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.b = i2;
        this.c = account;
        this.f2481d = i3;
        this.f2482e = googleSignInAccount;
    }

    public u(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.b = 2;
        this.c = account;
        this.f2481d = i2;
        this.f2482e = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.D1(parcel, 2, this.c, i2, false);
        int i4 = this.f2481d;
        m.h.L1(parcel, 3, 4);
        parcel.writeInt(i4);
        m.h.D1(parcel, 4, this.f2482e, i2, false);
        m.h.M1(parcel, H1);
    }
}
