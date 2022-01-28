package com.bugfender.sdk.a.a.c.f;

import com.bugfender.sdk.a.a.e.b;
import com.bugfender.sdk.a.a.h.h;
import java.io.File;
import java.io.IOException;

public class a implements com.bugfender.sdk.a.a.c.a<File, h> {
    private com.bugfender.sdk.a.a.c.a<h, String> a;

    public a(com.bugfender.sdk.a.a.c.a<h, String> aVar) {
        this.a = aVar;
    }

    /* renamed from: a */
    public h b(File file) {
        try {
            return this.a.a(b.c(file));
        } catch (IOException unused) {
            return null;
        }
    }

    public File a(h hVar) {
        throw new UnsupportedOperationException("from(Session value) not supported");
    }
}
