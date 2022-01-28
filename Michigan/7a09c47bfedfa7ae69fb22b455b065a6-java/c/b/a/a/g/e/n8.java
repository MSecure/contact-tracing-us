package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

public final class n8 implements Parcelable.Creator<o8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final o8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        PayloadTransferUpdate payloadTransferUpdate = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = t.b0(parcel, readInt);
            } else if (i != 2) {
                t.O2(parcel, readInt);
            } else {
                payloadTransferUpdate = (PayloadTransferUpdate) t.a0(parcel, readInt, PayloadTransferUpdate.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new o8(str, payloadTransferUpdate);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ o8[] newArray(int i) {
        return new o8[i];
    }
}
