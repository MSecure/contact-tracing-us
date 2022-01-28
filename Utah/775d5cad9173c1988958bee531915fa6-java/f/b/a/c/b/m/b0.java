package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.c;

public final class b0 implements Parcelable.Creator<e> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e createFromParcel(Parcel parcel) {
        int O1 = m.e.O1(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        c[] cVarArr = null;
        c[] cVarArr2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < O1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = m.e.l1(parcel, readInt);
                    break;
                case 2:
                    i3 = m.e.l1(parcel, readInt);
                    break;
                case 3:
                    i4 = m.e.l1(parcel, readInt);
                    break;
                case 4:
                    str = m.e.O(parcel, readInt);
                    break;
                case 5:
                    iBinder = m.e.k1(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) m.e.P(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = m.e.E(parcel, readInt);
                    break;
                case 8:
                    account = (Account) m.e.L(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    m.e.C1(parcel, readInt);
                    break;
                case 10:
                    cVarArr = (c[]) m.e.P(parcel, readInt, c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c[]) m.e.P(parcel, readInt, c.CREATOR);
                    break;
                case 12:
                    z = m.e.h1(parcel, readInt);
                    break;
                case 13:
                    i5 = m.e.l1(parcel, readInt);
                    break;
                case 14:
                    z2 = m.e.h1(parcel, readInt);
                    break;
            }
        }
        m.e.V(parcel, O1);
        return new e(i2, i3, i4, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z, i5, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
