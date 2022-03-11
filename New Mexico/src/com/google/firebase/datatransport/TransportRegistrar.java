package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import f.b.c.f.d;
import f.b.c.f.g;
import f.b.c.f.o;
import f.b.c.h.a;
import java.util.Collections;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class TransportRegistrar implements g {
    @Override // f.b.c.f.g
    public List<d<?>> getComponents() {
        d.b a = d.a(f.b.a.b.g.class);
        a.a(new o(Context.class, 1, 0));
        a.c(a.a);
        return Collections.singletonList(a.b());
    }
}
