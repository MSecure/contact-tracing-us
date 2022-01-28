package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.c;
import com.google.android.gms.common.api.Scope;

public final class b0 implements Parcelable.Creator<f> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final f createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        c[] cVarArr = null;
        c[] cVarArr2 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 2:
                    i2 = i.j.R0(parcel, readInt);
                    break;
                case 3:
                    i3 = i.j.R0(parcel, readInt);
                    break;
                case 4:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 5:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) i.j.R(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = i.j.E(parcel, readInt);
                    break;
                case 8:
                    account = (Account) i.j.O(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    i.j.g1(parcel, readInt);
                    break;
                case 10:
                    cVarArr = (c[]) i.j.R(parcel, readInt, c.CREATOR);
                    break;
                case 11:
                    cVarArr2 = (c[]) i.j.R(parcel, readInt, c.CREATOR);
                    break;
                case 12:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 13:
                    i4 = i.j.R0(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new f(i, i2, i3, str, iBinder, scopeArr, bundle, account, cVarArr, cVarArr2, z, i4);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ f[] newArray(int i) {
        return new f[i];
    }
}
