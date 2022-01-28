package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zab implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 2:
                    str = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 3:
                    str2 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 4:
                    str3 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 5:
                    str4 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) ReactYogaConfigProvider.createParcelable(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 8:
                    j = ReactYogaConfigProvider.readLong(parcel, readInt);
                    break;
                case 9:
                    str6 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 10:
                    arrayList = ReactYogaConfigProvider.createTypedList(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 12:
                    str8 = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                default:
                    ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
