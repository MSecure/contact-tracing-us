package c.b.a.a.e.c;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.b.k.i;

public final class x8 implements Parcelable.Creator<w8> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final w8 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        long j = 0;
        long j2 = 0;
        byte[] bArr = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        Uri uri = null;
        int i = 0;
        long j3 = -1;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    j = i.j.S0(parcel, readInt);
                    break;
                case 2:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 3:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) i.j.O(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    j3 = i.j.S0(parcel, readInt);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) i.j.O(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 8:
                    uri = (Uri) i.j.O(parcel, readInt, Uri.CREATOR);
                    break;
                case 9:
                    j2 = i.j.S0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new w8(j, i, bArr, parcelFileDescriptor, str, j3, parcelFileDescriptor2, uri, j2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ w8[] newArray(int i) {
        return new w8[i];
    }
}
