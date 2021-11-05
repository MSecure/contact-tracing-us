package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

public final class n8 implements Parcelable.Creator<o8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final o8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        PayloadTransferUpdate payloadTransferUpdate = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i != 2) {
                i.j.g1(parcel, readInt);
            } else {
                payloadTransferUpdate = (PayloadTransferUpdate) i.j.O(parcel, readInt, PayloadTransferUpdate.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new o8(str, payloadTransferUpdate);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o8[] newArray(int i) {
        return new o8[i];
    }
}
