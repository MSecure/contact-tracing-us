package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class y implements Parcelable.Creator<w> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final w createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = t.t2(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) t.a0(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = t.t2(parcel, readInt);
            } else if (i3 != 4) {
                t.O2(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) t.a0(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new w(i, account, i2, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w[] newArray(int i) {
        return new w[i];
    }
}
