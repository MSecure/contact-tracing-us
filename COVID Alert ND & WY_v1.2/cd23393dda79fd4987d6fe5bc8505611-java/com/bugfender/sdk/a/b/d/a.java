package com.bugfender.sdk.a.b.d;

import android.util.Log;
import com.bugfender.sdk.a.a.b;

public abstract class a implements g {
    public static final String d = "Interaction";
    private final boolean a;
    private final boolean b;
    private b c;

    public a(b bVar, boolean z, boolean z2) {
        this.c = bVar;
        this.a = z;
        this.b = z2;
    }

    public void a(String str) {
        if (c()) {
            Log.d(d, str);
        }
        if (this.b) {
            b().a(d, str);
        }
    }

    public b b() {
        return this.c;
    }

    public boolean c() {
        return this.a;
    }

    @Override // com.bugfender.sdk.a.b.d.g
    public void a() {
        this.c = null;
    }
}
