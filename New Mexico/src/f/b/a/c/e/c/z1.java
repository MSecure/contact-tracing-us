package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import f.b.a.c.f.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class z1 implements Parcelable.Creator<y1> {
    @Override // android.os.Parcelable.Creator
    public final y1 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        b bVar = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = m.e.R(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = m.e.q1(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = m.e.R(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    bVar = (b) m.e.M(parcel, readInt, b.CREATOR);
                    break;
                case 5:
                    str = m.e.P(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = m.e.q1(parcel, readInt);
                    break;
                default:
                    m.e.K1(parcel, readInt);
                    break;
            }
        }
        m.e.W(parcel, W1);
        return new y1(arrayList, iBinder, arrayList2, bVar, str, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ y1[] newArray(int i2) {
        return new y1[i2];
    }
}
