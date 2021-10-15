package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class w extends a {
    public static final Parcelable.Creator<w> CREATOR = new y();

    /* renamed from: b  reason: collision with root package name */
    public final int f3160b;

    /* renamed from: c  reason: collision with root package name */
    public final Account f3161c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3162d;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleSignInAccount f3163e;

    public w(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f3160b = i;
        this.f3161c = account;
        this.f3162d = i2;
        this.f3163e = googleSignInAccount;
    }

    public w(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.f3160b = 2;
        this.f3161c = account;
        this.f3162d = i;
        this.f3163e = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3160b);
        t.v3(parcel, 2, this.f3161c, i, false);
        t.q3(parcel, 3, this.f3162d);
        t.v3(parcel, 4, this.f3163e, i, false);
        t.w4(parcel, m);
    }
}
