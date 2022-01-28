package c.b.a.a.e.c;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class g8 implements Parcelable.Creator<h8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        BluetoothDevice bluetoothDevice = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                str = i.j.Q(parcel, readInt);
            } else if (i == 2) {
                str2 = i.j.Q(parcel, readInt);
            } else if (i == 3) {
                str3 = i.j.Q(parcel, readInt);
            } else if (i == 4) {
                bluetoothDevice = (BluetoothDevice) i.j.O(parcel, readInt, BluetoothDevice.CREATOR);
            } else if (i != 5) {
                i.j.g1(parcel, readInt);
            } else {
                bArr = i.j.F(parcel, readInt);
            }
        }
        i.j.W(parcel, m1);
        return new h8(str, str2, str3, bluetoothDevice, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h8[] newArray(int i) {
        return new h8[i];
    }
}
