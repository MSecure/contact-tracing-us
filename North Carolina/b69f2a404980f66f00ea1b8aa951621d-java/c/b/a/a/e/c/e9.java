package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final class e9 implements Parcelable.Creator<a9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder4 = null;
        byte[] bArr2 = null;
        ConnectionOptions connectionOptions = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                case 3:
                    iBinder3 = i.j.Q0(parcel, readInt);
                    break;
                case 4:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 5:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 7:
                    iBinder4 = i.j.Q0(parcel, readInt);
                    break;
                case 8:
                    bArr2 = i.j.F(parcel, readInt);
                    break;
                case 9:
                    connectionOptions = (ConnectionOptions) i.j.O(parcel, readInt, ConnectionOptions.CREATOR);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new a9(iBinder, iBinder2, iBinder3, str, str2, bArr, iBinder4, bArr2, connectionOptions);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a9[] newArray(int i) {
        return new a9[i];
    }
}
