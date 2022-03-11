package f.b.a.f.a.a;

import android.app.PendingIntent;
/* loaded from: classes.dex */
public class a {
    public final int a;
    public final long b;
    public final long c;

    /* renamed from: d */
    public final PendingIntent f3160d;

    /* renamed from: e */
    public final PendingIntent f3161e;

    /* renamed from: f */
    public final PendingIntent f3162f;

    /* renamed from: g */
    public final PendingIntent f3163g;

    /* renamed from: h */
    public boolean f3164h = false;

    public a(String str, int i2, int i3, int i4, Integer num, int i5, long j2, long j3, long j4, long j5, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        this.a = i3;
        this.b = j4;
        this.c = j5;
        this.f3160d = pendingIntent;
        this.f3161e = pendingIntent2;
        this.f3162f = pendingIntent3;
        this.f3163g = pendingIntent4;
    }

    public final PendingIntent a(c cVar) {
        if (cVar.b() == 0) {
            PendingIntent pendingIntent = this.f3161e;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (b(cVar)) {
                return this.f3163g;
            }
            return null;
        }
        if (cVar.b() == 1) {
            PendingIntent pendingIntent2 = this.f3160d;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (b(cVar)) {
                return this.f3162f;
            }
        }
        return null;
    }

    public final boolean b(c cVar) {
        return cVar.a() && this.b <= this.c;
    }
}
