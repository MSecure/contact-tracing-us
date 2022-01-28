package c.c.a;

import android.content.Context;
import g.b.a.x.c;
import g.b.a.x.h;
import g.b.a.x.i;
import java.io.IOException;
import java.io.InputStream;

public final class b extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Context f5968c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5969d;

    public b(Context context, String str) {
        this.f5968c = context;
        this.f5969d = str;
    }

    @Override // g.b.a.x.h
    public void a() {
        InputStream inputStream = null;
        try {
            inputStream = this.f5968c.getAssets().open(this.f5969d);
            c cVar = new c(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            i.b(cVar);
        } catch (IOException e2) {
            throw new IllegalStateException(this.f5969d + " missing from assets", e2);
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
