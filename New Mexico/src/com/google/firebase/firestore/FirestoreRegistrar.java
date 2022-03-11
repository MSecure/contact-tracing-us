package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.Keep;
import f.b.a.c.b.o.b;
import f.b.c.a;
import f.b.c.f.d;
import f.b.c.f.e;
import f.b.c.f.g;
import f.b.c.f.o;
import f.b.c.k.i;
import f.b.c.k.j;
import f.b.c.k.w.l;
import f.b.c.l.c;
import f.b.c.n.f;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class FirestoreRegistrar implements g {
    public static /* synthetic */ i lambda$getComponents$0(e eVar) {
        return new i((Context) eVar.a(Context.class), (a) eVar.a(a.class), (f.b.c.e.b.a) eVar.a(f.b.c.e.b.a.class), new l(eVar.b(f.class), eVar.b(c.class)));
    }

    @Override // f.b.c.f.g
    @Keep
    public List<d<?>> getComponents() {
        d.b a = d.a(i.class);
        a.a(new o(a.class, 1, 0));
        a.a(new o(Context.class, 1, 0));
        a.a(new o(c.class, 0, 1));
        a.a(new o(f.class, 0, 1));
        a.a(new o(f.b.c.e.b.a.class, 0, 0));
        a.c(j.a);
        return Arrays.asList(a.b(), b.J("fire-fst", "21.6.0"));
    }
}
