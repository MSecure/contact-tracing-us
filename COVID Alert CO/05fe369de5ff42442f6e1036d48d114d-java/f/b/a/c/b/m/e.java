package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.c;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.n.a;

public class e extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<e> CREATOR = new b0();
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2639d;

    /* renamed from: e  reason: collision with root package name */
    public String f2640e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f2641f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f2642g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f2643h;

    /* renamed from: i  reason: collision with root package name */
    public Account f2644i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f2645j;

    /* renamed from: k  reason: collision with root package name */
    public c[] f2646k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2647l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.b = 5;
        this.f2639d = f.b.a.c.b.e.a;
        this.c = i2;
        this.f2647l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.b = i2;
        this.c = i3;
        this.f2639d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2640e = "com.google.android.gms";
        } else {
            this.f2640e = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                h q = h.a.q(iBinder);
                int i6 = a.a;
                if (q != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        account2 = q.f();
                    } catch (RemoteException unused) {
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th;
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            this.f2644i = account2;
        } else {
            this.f2641f = iBinder;
            this.f2644i = account;
        }
        this.f2642g = scopeArr;
        this.f2643h = bundle;
        this.f2645j = cVarArr;
        this.f2646k = cVarArr2;
        this.f2647l = z;
        this.m = i5;
        this.n = z2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int O1 = m.h.O1(parcel, 20293);
        int i3 = this.b;
        m.h.S1(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.h.S1(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2639d;
        m.h.S1(parcel, 3, 4);
        parcel.writeInt(i5);
        m.h.L1(parcel, 4, this.f2640e, false);
        m.h.H1(parcel, 5, this.f2641f, false);
        m.h.M1(parcel, 6, this.f2642g, i2, false);
        m.h.E1(parcel, 7, this.f2643h, false);
        m.h.K1(parcel, 8, this.f2644i, i2, false);
        m.h.M1(parcel, 10, this.f2645j, i2, false);
        m.h.M1(parcel, 11, this.f2646k, i2, false);
        boolean z = this.f2647l;
        m.h.S1(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i6 = this.m;
        m.h.S1(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z2 = this.n;
        m.h.S1(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.T1(parcel, O1);
    }
}
