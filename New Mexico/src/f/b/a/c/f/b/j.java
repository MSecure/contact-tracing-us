package f.b.a.c.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j implements Parcelable.Creator<DiagnosisKeysDataMapping> {
    @Override // android.os.Parcelable.Creator
    public final DiagnosisKeysDataMapping createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        int i2 = 0;
        ArrayList<Integer> arrayList = null;
        int i3 = 0;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                arrayList = m.e.I(parcel, readInt);
            } else if (i4 == 2) {
                i2 = m.e.r1(parcel, readInt);
            } else if (i4 != 3) {
                m.e.K1(parcel, readInt);
            } else {
                i3 = m.e.r1(parcel, readInt);
            }
        }
        m.e.W(parcel, W1);
        return new DiagnosisKeysDataMapping(arrayList, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DiagnosisKeysDataMapping[] newArray(int i2) {
        return new DiagnosisKeysDataMapping[i2];
    }
}
