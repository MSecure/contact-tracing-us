package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.annotation.KeepName;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder extends a implements Closeable {
    @RecentlyNonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new c.b.a.a.d.l.a();

    /* renamed from: b  reason: collision with root package name */
    public final int f5987b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f5988c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f5989d;

    /* renamed from: e  reason: collision with root package name */
    public final CursorWindow[] f5990e;

    /* renamed from: f  reason: collision with root package name */
    public final int f5991f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f5992g;
    public int[] h;
    public boolean i = false;
    public boolean j = true;

    static {
        t.C(new String[0]);
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f5987b = i2;
        this.f5988c = strArr;
        this.f5990e = cursorWindowArr;
        this.f5991f = i3;
        this.f5992g = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                for (int i2 = 0; i2 < this.f5990e.length; i2++) {
                    this.f5990e[i2].close();
                }
            }
        }
    }

    @Override // java.lang.Object
    public final void finalize() {
        boolean z;
        try {
            if (this.j && this.f5990e.length > 0) {
                synchronized (this) {
                    z = this.i;
                }
                if (!z) {
                    close();
                    String.valueOf(toString()).length();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int m = t.m(parcel);
        t.x3(parcel, 1, this.f5988c, false);
        t.y3(parcel, 2, this.f5990e, i2, false);
        t.q3(parcel, 3, this.f5991f);
        t.k3(parcel, 4, this.f5992g, false);
        t.q3(parcel, 1000, this.f5987b);
        t.w4(parcel, m);
        if ((i2 & 1) != 0) {
            close();
        }
    }
}
