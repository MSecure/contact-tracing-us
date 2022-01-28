package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.connection.ConnectionOptions;

public final class e9 implements Parcelable.Creator<a9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        IBinder iBinder4 = null;
        byte[] bArr2 = null;
        ConnectionOptions connectionOptions = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = t.s2(parcel, readInt);
                    break;
                case 3:
                    iBinder3 = t.s2(parcel, readInt);
                    break;
                case 4:
                    str = t.b0(parcel, readInt);
                    break;
                case 5:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 6:
                    bArr = t.R(parcel, readInt);
                    break;
                case 7:
                    iBinder4 = t.s2(parcel, readInt);
                    break;
                case 8:
                    bArr2 = t.R(parcel, readInt);
                    break;
                case 9:
                    connectionOptions = (ConnectionOptions) t.a0(parcel, readInt, ConnectionOptions.CREATOR);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new a9(iBinder, iBinder2, iBinder3, str, str2, bArr, iBinder4, bArr2, connectionOptions);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a9[] newArray(int i) {
        return new a9[i];
    }
}
