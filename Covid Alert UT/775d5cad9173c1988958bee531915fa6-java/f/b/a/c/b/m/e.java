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
    public int f2693d;

    /* renamed from: e  reason: collision with root package name */
    public String f2694e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f2695f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f2696g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f2697h;

    /* renamed from: i  reason: collision with root package name */
    public Account f2698i;

    /* renamed from: j  reason: collision with root package name */
    public c[] f2699j;

    /* renamed from: k  reason: collision with root package name */
    public c[] f2700k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2701l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.b = 5;
        this.f2693d = f.b.a.c.b.e.a;
        this.c = i2;
        this.f2701l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.b = i2;
        this.c = i3;
        this.f2693d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2694e = "com.google.android.gms";
        } else {
            this.f2694e = str;
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
            this.f2698i = account2;
        } else {
            this.f2695f = iBinder;
            this.f2698i = account;
        }
        this.f2696g = scopeArr;
        this.f2697h = bundle;
        this.f2699j = cVarArr;
        this.f2700k = cVarArr2;
        this.f2701l = z;
        this.m = i5;
        this.n = z2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int b2 = m.e.b2(parcel, 20293);
        int i3 = this.b;
        m.e.f2(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.e.f2(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2693d;
        m.e.f2(parcel, 3, 4);
        parcel.writeInt(i5);
        m.e.Y1(parcel, 4, this.f2694e, false);
        m.e.U1(parcel, 5, this.f2695f, false);
        m.e.Z1(parcel, 6, this.f2696g, i2, false);
        m.e.R1(parcel, 7, this.f2697h, false);
        m.e.X1(parcel, 8, this.f2698i, i2, false);
        m.e.Z1(parcel, 10, this.f2699j, i2, false);
        m.e.Z1(parcel, 11, this.f2700k, i2, false);
        boolean z = this.f2701l;
        m.e.f2(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i6 = this.m;
        m.e.f2(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z2 = this.n;
        m.e.f2(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.e.g2(parcel, b2);
    }
}
