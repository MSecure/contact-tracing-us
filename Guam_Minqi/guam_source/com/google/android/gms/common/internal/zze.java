package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zze implements Parcelable.Creator<GetServiceRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GetServiceRequest createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 2:
                    i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 3:
                    i3 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 4:
                    str = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 5:
                    iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = ReactYogaConfigProvider.createBundle(parcel, readInt);
                    break;
                case 8:
                    account = (Account) ReactYogaConfigProvider.createParcelable(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
                    break;
                case 10:
                    featureArr = (Feature[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, Feature.CREATOR);
                    break;
                case 12:
                    z = ReactYogaConfigProvider.readBoolean(parcel, readInt);
                    break;
                case 13:
                    i4 = ReactYogaConfigProvider.readInt(parcel, readInt);
                    break;
                case 14:
                    z2 = ReactYogaConfigProvider.readBoolean(parcel, readInt);
                    break;
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
