package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zac implements Parcelable.Creator<DataHolder> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                int readSize = ReactYogaConfigProvider.readSize(parcel, readInt);
                int dataPosition = parcel.dataPosition();
                if (readSize == 0) {
                    strArr = null;
                } else {
                    String[] createStringArray = parcel.createStringArray();
                    parcel.setDataPosition(dataPosition + readSize);
                    strArr = createStringArray;
                }
            } else if (i4 == 2) {
                cursorWindowArr = (CursorWindow[]) ReactYogaConfigProvider.createTypedArray(parcel, readInt, CursorWindow.CREATOR);
            } else if (i4 == 3) {
                i3 = ReactYogaConfigProvider.readInt(parcel, readInt);
            } else if (i4 == 4) {
                bundle = ReactYogaConfigProvider.createBundle(parcel, readInt);
            } else if (i4 != 1000) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                i2 = ReactYogaConfigProvider.readInt(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.zac = new Bundle();
        int i5 = 0;
        while (true) {
            String[] strArr2 = dataHolder.zab;
            if (i5 >= strArr2.length) {
                break;
            }
            dataHolder.zac.putInt(strArr2[i5], i5);
            i5++;
        }
        dataHolder.zag = new int[dataHolder.zad.length];
        int i6 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.zad;
            if (i >= cursorWindowArr2.length) {
                return dataHolder;
            }
            dataHolder.zag[i] = i6;
            i6 += dataHolder.zad[i].getNumRows() - (i6 - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
