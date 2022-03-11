package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public final class u extends a {
    public static final Parcelable.Creator<u> CREATOR = new w();
    public final int b;
    public final Account c;

    /* renamed from: d */
    public final int f2753d;

    /* renamed from: e */
    public final GoogleSignInAccount f2754e;

    public u(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.b = i2;
        this.c = account;
        this.f2753d = i3;
        this.f2754e = googleSignInAccount;
    }

    public u(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.b = 2;
        this.c = account;
        this.f2753d = i2;
        this.f2754e = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.f2(parcel, 2, this.c, i2, false);
        int i4 = this.f2753d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i4);
        m.e.f2(parcel, 4, this.f2754e, i2, false);
        m.e.o2(parcel, j2);
    }
}
