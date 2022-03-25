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
    public int f2550d;

    /* renamed from: e  reason: collision with root package name */
    public String f2551e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f2552f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f2553g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f2554h;

    /* renamed from: i  reason: collision with root package name */
    public Account f2555i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f2556j;

    /* renamed from: k  reason: collision with root package name */
    public c[] f2557k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2558l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.b = 5;
        this.f2550d = f.b.a.c.b.e.a;
        this.c = i2;
        this.f2558l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.b = i2;
        this.c = i3;
        this.f2550d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2551e = "com.google.android.gms";
        } else {
            this.f2551e = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                h m2 = h.a.m(iBinder);
                int i6 = a.a;
                if (m2 != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        account2 = m2.f();
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th;
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            this.f2555i = account2;
        } else {
            this.f2552f = iBinder;
            this.f2555i = account;
        }
        this.f2553g = scopeArr;
        this.f2554h = bundle;
        this.f2556j = cVarArr;
        this.f2557k = cVarArr2;
        this.f2558l = z;
        this.m = i5;
        this.n = z2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.b;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.h.M1(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2550d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(i5);
        m.h.F1(parcel, 4, this.f2551e, false);
        m.h.B1(parcel, 5, this.f2552f, false);
        m.h.G1(parcel, 6, this.f2553g, i2, false);
        m.h.y1(parcel, 7, this.f2554h, false);
        m.h.E1(parcel, 8, this.f2555i, i2, false);
        m.h.G1(parcel, 10, this.f2556j, i2, false);
        m.h.G1(parcel, 11, this.f2557k, i2, false);
        boolean z = this.f2558l;
        m.h.M1(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i6 = this.m;
        m.h.M1(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z2 = this.n;
        m.h.M1(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.N1(parcel, I1);
    }
}
