package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class x implements Parcelable.Creator<p> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final p createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = i.j.R0(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) i.j.O(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = i.j.R0(parcel, readInt);
            } else if (i3 != 4) {
                i.j.g1(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) i.j.O(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new p(i, account, i2, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ p[] newArray(int i) {
        return new p[i];
    }
}
