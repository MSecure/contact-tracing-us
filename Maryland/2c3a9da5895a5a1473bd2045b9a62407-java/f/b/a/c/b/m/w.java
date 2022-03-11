package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e.b.a.m;

public final class w implements Parcelable.Creator<u> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final u createFromParcel(Parcel parcel) {
        int v1 = m.h.v1(parcel);
        int i2 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = m.h.T0(parcel, readInt);
            } else if (i4 == 2) {
                account = (Account) m.h.I(parcel, readInt, Account.CREATOR);
            } else if (i4 == 3) {
                i3 = m.h.T0(parcel, readInt);
            } else if (i4 != 4) {
                m.h.k1(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) m.h.I(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        m.h.T(parcel, v1);
        return new u(i2, account, i3, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ u[] newArray(int i2) {
        return new u[i2];
    }
}
