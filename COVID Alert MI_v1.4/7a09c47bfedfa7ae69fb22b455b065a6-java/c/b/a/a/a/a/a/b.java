package c.b.a.a.a.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public final class b implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
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
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    str = t.b0(parcel, readInt);
                    break;
                case 3:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 4:
                    str3 = t.b0(parcel, readInt);
                    break;
                case 5:
                    str4 = t.b0(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) t.a0(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = t.b0(parcel, readInt);
                    break;
                case 8:
                    j = t.u2(parcel, readInt);
                    break;
                case 9:
                    str6 = t.b0(parcel, readInt);
                    break;
                case 10:
                    arrayList = t.e0(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = t.b0(parcel, readInt);
                    break;
                case 12:
                    str8 = t.b0(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
