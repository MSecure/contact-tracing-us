package f.b.a.c.b.m;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
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
    public int f2470d;

    /* renamed from: e  reason: collision with root package name */
    public String f2471e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f2472f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f2473g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f2474h;

    /* renamed from: i  reason: collision with root package name */
    public Account f2475i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f2476j;

    /* renamed from: k  reason: collision with root package name */
    public c[] f2477k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2478l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.b = 5;
        this.f2470d = f.b.a.c.b.e.a;
        this.c = i2;
        this.f2478l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.b = i2;
        this.c = i3;
        this.f2470d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2471e = "com.google.android.gms";
        } else {
            this.f2471e = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                h n2 = h.a.n(iBinder);
                int i6 = a.a;
                if (n2 != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        account2 = n2.e();
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th;
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            this.f2475i = account2;
        } else {
            this.f2472f = iBinder;
            this.f2475i = account;
        }
        this.f2473g = scopeArr;
        this.f2474h = bundle;
        this.f2476j = cVarArr;
        this.f2477k = cVarArr2;
        this.f2478l = z;
        this.m = i5;
        this.n = z2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.h.L1(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2470d;
        m.h.L1(parcel, 3, 4);
        parcel.writeInt(i5);
        m.h.E1(parcel, 4, this.f2471e, false);
        m.h.A1(parcel, 5, this.f2472f, false);
        m.h.F1(parcel, 6, this.f2473g, i2, false);
        m.h.x1(parcel, 7, this.f2474h, false);
        m.h.D1(parcel, 8, this.f2475i, i2, false);
        m.h.F1(parcel, 10, this.f2476j, i2, false);
        m.h.F1(parcel, 11, this.f2477k, i2, false);
        boolean z = this.f2478l;
        m.h.L1(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i6 = this.m;
        m.h.L1(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z2 = this.n;
        m.h.L1(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.M1(parcel, H1);
    }
}
