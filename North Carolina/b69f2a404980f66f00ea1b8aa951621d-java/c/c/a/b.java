package c.c.a;

import android.content.Context;
import e.c.a.x.c;
import e.c.a.x.h;
import e.c.a.x.i;
import java.io.IOException;
import java.io.InputStream;

public final class b extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Context f4422c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4423d;

    public b(Context context, String str) {
        this.f4422c = context;
        this.f4423d = str;
    }

    @Override // e.c.a.x.h
    public void a() {
        InputStream inputStream = null;
        try {
            inputStream = this.f4422c.getAssets().open(this.f4423d);
            c cVar = new c(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            i.b(cVar);
        } catch (IOException e2) {
            throw new IllegalStateException(this.f4423d + " missing from assets", e2);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }
}
