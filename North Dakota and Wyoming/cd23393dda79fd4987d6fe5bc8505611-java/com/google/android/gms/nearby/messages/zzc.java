package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzkm;
import com.google.android.gms.internal.nearby.zzkp;
import com.google.android.gms.nearby.messages.internal.zzac;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzc implements Parcelable.Creator<MessageFilter> {
    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzac.CREATOR);
            } else if (fieldId == 2) {
                arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, zzkp.CREATOR);
            } else if (fieldId == 3) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, zzkm.CREATOR);
            } else if (fieldId == 5) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }
}
