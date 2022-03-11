package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
/* loaded from: classes.dex */
public final class i2 implements Parcelable.Creator<h2> {
    @Override // android.os.Parcelable.Creator
    public final h2 createFromParcel(Parcel parcel) {
        int W1 = m.e.W1(parcel);
        IBinder iBinder = null;
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = null;
        while (parcel.dataPosition() < W1) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                iBinder = m.e.q1(parcel, readInt);
            } else if (i2 != 2) {
                m.e.K1(parcel, readInt);
            } else {
                diagnosisKeysDataMapping = (DiagnosisKeysDataMapping) m.e.M(parcel, readInt, DiagnosisKeysDataMapping.CREATOR);
            }
        }
        m.e.W(parcel, W1);
        return new h2(iBinder, diagnosisKeysDataMapping);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h2[] newArray(int i2) {
        return new h2[i2];
    }
}
