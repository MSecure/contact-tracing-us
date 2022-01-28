package c.b.a.a.d.l;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.common.data.DataHolder;

public final class a implements Parcelable.Creator<DataHolder> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                strArr = t.c0(parcel, readInt);
            } else if (i4 == 2) {
                cursorWindowArr = (CursorWindow[]) t.d0(parcel, readInt, CursorWindow.CREATOR);
            } else if (i4 == 3) {
                i3 = t.t2(parcel, readInt);
            } else if (i4 == 4) {
                bundle = t.Q(parcel, readInt);
            } else if (i4 != 1000) {
                t.O2(parcel, readInt);
            } else {
                i2 = t.t2(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.f5989d = new Bundle();
        int i5 = 0;
        while (true) {
            String[] strArr2 = dataHolder.f5988c;
            if (i5 >= strArr2.length) {
                break;
            }
            dataHolder.f5989d.putInt(strArr2[i5], i5);
            i5++;
        }
        dataHolder.h = new int[dataHolder.f5990e.length];
        int i6 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.f5990e;
            if (i >= cursorWindowArr2.length) {
                return dataHolder;
            }
            dataHolder.h[i] = i6;
            i6 += dataHolder.f5990e[i].getNumRows() - (i6 - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
