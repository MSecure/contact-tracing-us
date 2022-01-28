package c.b.a.a.g.e;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class g8 implements Parcelable.Creator<h8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        BluetoothDevice bluetoothDevice = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = t.b0(parcel, readInt);
            } else if (i == 2) {
                str2 = t.b0(parcel, readInt);
            } else if (i == 3) {
                str3 = t.b0(parcel, readInt);
            } else if (i == 4) {
                bluetoothDevice = (BluetoothDevice) t.a0(parcel, readInt, BluetoothDevice.CREATOR);
            } else if (i != 5) {
                t.O2(parcel, readInt);
            } else {
                bArr = t.R(parcel, readInt);
            }
        }
        t.i1(parcel, f3);
        return new h8(str, str2, str3, bluetoothDevice, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h8[] newArray(int i) {
        return new h8[i];
    }
}
