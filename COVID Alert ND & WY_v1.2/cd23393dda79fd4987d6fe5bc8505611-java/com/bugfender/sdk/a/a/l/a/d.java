package com.bugfender.sdk.a.a.l.a;

import com.bugfender.sdk.a.a.d.b.b;
import com.bugfender.sdk.a.a.h.c;
import com.bugfender.sdk.a.a.i.a;

public class d implements Runnable {
    private a a;
    private c b;
    private final com.bugfender.sdk.a.a.g.a<String> c;
    private com.bugfender.sdk.a.a.a<com.bugfender.sdk.a.a.h.d> d;

    public d(a aVar, c cVar, com.bugfender.sdk.a.a.g.a<String> aVar2, com.bugfender.sdk.a.a.a<com.bugfender.sdk.a.a.h.d> aVar3) {
        this.a = aVar;
        this.b = cVar;
        this.c = aVar2;
        this.d = aVar3;
    }

    public void run() {
        try {
            com.bugfender.sdk.a.a.h.d a2 = this.a.a(this.b.a(), this.b, this.c.a(true));
            com.bugfender.sdk.a.a.a<com.bugfender.sdk.a.a.h.d> aVar = this.d;
            if (aVar != null) {
                aVar.a(a2);
            }
        } catch (b e) {
            com.bugfender.sdk.a.a.a<com.bugfender.sdk.a.a.h.d> aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(e);
            }
        }
    }
}
