package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class p extends a {
    public static final Parcelable.Creator<p> CREATOR = new x();

    /* renamed from: b  reason: collision with root package name */
    public final int f2474b;

    /* renamed from: c  reason: collision with root package name */
    public final Account f2475c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2476d;

    /* renamed from: e  reason: collision with root package name */
    public final GoogleSignInAccount f2477e;

    public p(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f2474b = i;
        this.f2475c = account;
        this.f2476d = i2;
        this.f2477e = googleSignInAccount;
    }

    public p(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.f2474b = 2;
        this.f2475c = account;
        this.f2476d = i;
        this.f2477e = googleSignInAccount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2474b);
        i.j.y1(parcel, 2, this.f2475c, i, false);
        i.j.u1(parcel, 3, this.f2476d);
        i.j.y1(parcel, 4, this.f2477e, i, false);
        i.j.F1(parcel, e2);
    }
}
