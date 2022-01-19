package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zat implements Parcelable.Creator<zar> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zar createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 == 2) {
                account = (Account) ReactYogaConfigProvider.createParcelable(parcel, readInt, Account.CREATOR);
            } else if (i3 == 3) {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i3 != 4) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) ReactYogaConfigProvider.createParcelable(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zar(i, account, i2, googleSignInAccount);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zar[] newArray(int i) {
        return new zar[i];
    }
}
