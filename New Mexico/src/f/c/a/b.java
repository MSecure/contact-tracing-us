package f.c.a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import l.b.a.y.c;
import l.b.a.y.h;
import l.b.a.y.i;
/* loaded from: classes.dex */
public final class b extends h {
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4003d;

    public b(Context context, String str) {
        this.c = context;
        this.f4003d = str;
    }

    @Override // l.b.a.y.h
    public void a() {
        InputStream inputStream;
        try {
            inputStream = null;
            try {
                inputStream = this.c.getAssets().open(this.f4003d);
                i.d(new c(inputStream));
            } catch (IOException e2) {
                throw new IllegalStateException(this.f4003d + " missing from assets", e2);
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}
