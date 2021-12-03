package f.b.a.c.a.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = m.e.l1(parcel, readInt);
                    break;
                case 2:
                    str = m.e.O(parcel, readInt);
                    break;
                case 3:
                    str2 = m.e.O(parcel, readInt);
                    break;
                case 4:
                    str3 = m.e.O(parcel, readInt);
                    break;
                case 5:
                    str4 = m.e.O(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) m.e.L(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = m.e.O(parcel, readInt);
                    break;
                case 8:
                    j2 = m.e.m1(parcel, readInt);
                    break;
                case 9:
                    str6 = m.e.O(parcel, readInt);
                    break;
                case 10:
                    arrayList = m.e.Q(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = m.e.O(parcel, readInt);
                    break;
                case 12:
                    str8 = m.e.O(parcel, readInt);
                    break;
                default:
                    m.e.C1(parcel, readInt);
                    break;
            }
        }
        m.e.V(parcel, O1);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
