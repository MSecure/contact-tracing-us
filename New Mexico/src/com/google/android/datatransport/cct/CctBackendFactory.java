package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import f.b.a.b.h.e;
import f.b.a.b.i.p.d;
import f.b.a.b.i.p.h;
import f.b.a.b.i.p.m;
@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements d {
    @Override // f.b.a.b.i.p.d
    public m create(h hVar) {
        return new e(hVar.a(), hVar.d(), hVar.c());
    }
}
