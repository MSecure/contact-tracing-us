package f.c.a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import l.b.a.y.c;
import l.b.a.y.h;
import l.b.a.y.i;

public final class b extends h {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3748d;

    public b(Context context, String str) {
        this.c = context;
        this.f3748d = str;
    }

    @Override // l.b.a.y.h
    public void a() {
        InputStream inputStream = null;
        try {
            inputStream = this.c.getAssets().open(this.f3748d);
            c cVar = new c(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            i.d(cVar);
        } catch (IOException e2) {
            throw new IllegalStateException(this.f3748d + " missing from assets", e2);
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
