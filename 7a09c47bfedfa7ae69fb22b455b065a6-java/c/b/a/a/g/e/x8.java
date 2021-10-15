package c.b.a.a.g.e;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.x.t;

public final class x8 implements Parcelable.Creator<w8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final w8 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        long j = 0;
        long j2 = 0;
        byte[] bArr = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        Uri uri = null;
        int i = 0;
        long j3 = -1;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = t.u2(parcel, readInt);
                    break;
                case 2:
                    i = t.t2(parcel, readInt);
                    break;
                case 3:
                    bArr = t.R(parcel, readInt);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) t.a0(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    str = t.b0(parcel, readInt);
                    break;
                case 6:
                    j3 = t.u2(parcel, readInt);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) t.a0(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 8:
                    uri = (Uri) t.a0(parcel, readInt, Uri.CREATOR);
                    break;
                case 9:
                    j2 = t.u2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new w8(j, i, bArr, parcelFileDescriptor, str, j3, parcelFileDescriptor2, uri, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w8[] newArray(int i) {
        return new w8[i];
    }
}
