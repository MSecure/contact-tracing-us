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
/* loaded from: classes.dex */
public class e extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<e> CREATOR = new b0();
    public final int b;
    public final int c;

    /* renamed from: d */
    public int f2734d;

    /* renamed from: e */
    public String f2735e;

    /* renamed from: f */
    public IBinder f2736f;

    /* renamed from: g */
    public Scope[] f2737g;

    /* renamed from: h */
    public Bundle f2738h;

    /* renamed from: i */
    public Account f2739i;

    /* renamed from: j */
    public c[] f2740j;

    /* renamed from: k */
    public c[] f2741k;

    /* renamed from: l */
    public boolean f2742l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.b = 5;
        this.f2734d = f.b.a.c.b.e.a;
        this.c = i2;
        this.f2742l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.b = i2;
        this.c = i3;
        this.f2734d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2735e = "com.google.android.gms";
        } else {
            this.f2735e = str;
        }
        if (i2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                h z3 = h.a.z(iBinder);
                int i6 = a.a;
                if (z3 != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        account2 = z3.a();
                    } catch (RemoteException unused) {
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        throw th;
                    }
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            this.f2739i = account2;
        } else {
            this.f2736f = iBinder;
            this.f2739i = account;
        }
        this.f2737g = scopeArr;
        this.f2738h = bundle;
        this.f2740j = cVarArr;
        this.f2741k = cVarArr2;
        this.f2742l = z;
        this.m = i5;
        this.n = z2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = this.f2734d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(i5);
        m.e.g2(parcel, 4, this.f2735e, false);
        m.e.c2(parcel, 5, this.f2736f, false);
        m.e.h2(parcel, 6, this.f2737g, i2, false);
        m.e.Z1(parcel, 7, this.f2738h, false);
        m.e.f2(parcel, 8, this.f2739i, i2, false);
        m.e.h2(parcel, 10, this.f2740j, i2, false);
        m.e.h2(parcel, 11, this.f2741k, i2, false);
        boolean z = this.f2742l;
        m.e.n2(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i6 = this.m;
        m.e.n2(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z2 = this.n;
        m.e.n2(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.e.o2(parcel, j2);
    }
}
