package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e.b.a.m;
/* loaded from: classes.dex */
public final class w implements Parcelable.Creator<u> {
    @Override // android.os.Parcelable.Creator
    public final u createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i4 == 2) {
                account = (Account) m.e.M(parcel, readInt, Account.CREATOR);
            } else if (i4 == 3) {
                i3 = m.e.r1(parcel, readInt);
            } else if (i4 != 4) {
                m.e.K1(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) m.e.M(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new u(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i2) {
        return new u[i2];
    }
}
