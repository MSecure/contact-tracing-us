package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zar> CREATOR = new zat();
    public final int zaa;
    public final Account zab;
    public final int zac;
    public final GoogleSignInAccount zad;

    public zar(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.zaa = i;
        this.zab = account;
        this.zac = i2;
        this.zad = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zaa);
        ReactYogaConfigProvider.writeParcelable(parcel, 2, this.zab, i, false);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zac);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, this.zad, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zar(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this.zaa = 2;
        this.zab = account;
        this.zac = i;
        this.zad = googleSignInAccount;
    }
}
