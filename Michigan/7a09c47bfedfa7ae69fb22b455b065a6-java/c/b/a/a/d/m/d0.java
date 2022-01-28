package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.c;
import com.google.android.gms.common.api.Scope;

public final class d0 implements Parcelable.Creator<e> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final e createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        c[] cVarArr = null;
        c[] cVarArr2 = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = t.t2(parcel, readInt);
                    break;
                case 2:
                    i2 = t.t2(parcel, readInt);
                    break;
                case 3:
                    i3 = t.t2(parcel, readInt);
                    break;
                case 4:
                    str = t.b0(parcel, readInt);
                    break;
                case 5:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) t.d0(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = t.Q(parcel, readInt);
                    break;
                case 8:
                    account = (Account) t.a0(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    t.O2(parcel, readInt);
                    break;
                case 10:
                    cVarArr = (c[]) t.d0(parcel, readInt, c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c[]) t.d0(parcel, readInt, c.CREATOR);
                    break;
                case 12:
                    z = t.q2(parcel, readInt);
                    break;
                case 13:
                    i4 = t.t2(parcel, readInt);
                    break;
                case 14:
                    z2 = t.q2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new e(i, i2, i3, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z, i4, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ e[] newArray(int i) {
        return new e[i];
    }
}
