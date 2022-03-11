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
        int v1 = m.h.v1(parcel);
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
        while (parcel.dataPosition() < v1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = m.h.T0(parcel, readInt);
                    break;
                case 2:
                    i3 = m.h.T0(parcel, readInt);
                    break;
                case 3:
                    i4 = m.h.T0(parcel, readInt);
                    break;
                case 4:
                    str = m.h.L(parcel, readInt);
                    break;
                case 5:
                    iBinder = m.h.S0(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) m.h.M(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = m.h.A(parcel, readInt);
                    break;
                case 8:
                    account = (Account) m.h.I(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    m.h.k1(parcel, readInt);
                    break;
                case 10:
                    cVarArr = (c[]) m.h.M(parcel, readInt, c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c[]) m.h.M(parcel, readInt, c.CREATOR);
                    break;
                case 12:
                    z = m.h.P0(parcel, readInt);
                    break;
                case 13:
                    i5 = m.h.T0(parcel, readInt);
                    break;
                case 14:
                    z2 = m.h.P0(parcel, readInt);
                    break;
            }
        }
        m.h.T(parcel, v1);
        return new e(i2, i3, i4, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z, i5, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i2) {
        return new e[i2];
    }
}
