package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final class o9 implements Parcelable.Creator<k9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final k9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        DiscoveryOptions discoveryOptions = null;
        IBinder iBinder3 = null;
        long j = 0;
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
                    str = t.b0(parcel, readInt);
                    break;
                case 4:
                    j = t.u2(parcel, readInt);
                    break;
                case 5:
                    discoveryOptions = (DiscoveryOptions) t.a0(parcel, readInt, DiscoveryOptions.CREATOR);
                    break;
                case 6:
                    iBinder3 = t.s2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new k9(iBinder, iBinder2, str, j, discoveryOptions, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k9[] newArray(int i) {
        return new k9[i];
    }
}
