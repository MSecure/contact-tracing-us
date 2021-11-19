package com.bugfender.sdk.a.a.d.a;

import com.bugfender.sdk.a.a.d.b.c;
import com.bugfender.sdk.a.a.d.b.d;
import com.bugfender.sdk.a.a.d.b.e;
import com.bugfender.sdk.a.a.i.c.a.a;

public final class b implements a<a> {
    public com.bugfender.sdk.a.a.d.b.b a(a aVar) {
        try {
            int a = aVar.a();
            if (a == -1007) {
                return new c(aVar.getMessage());
            }
            if (a != -1004) {
                return new d(aVar);
            }
            return new com.bugfender.sdk.a.a.d.b.a(aVar.getMessage());
        } catch (Exception e) {
            return new e(e);
        }
    }
}
