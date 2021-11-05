package b.q.d;

import android.view.View;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f1496a;

    /* renamed from: b  reason: collision with root package name */
    public a f1497b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1498a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f1499b;

        /* renamed from: c  reason: collision with root package name */
        public int f1500c;

        /* renamed from: d  reason: collision with root package name */
        public int f1501d;

        /* renamed from: e  reason: collision with root package name */
        public int f1502e;

        public boolean a() {
            int i = this.f1498a;
            if ((i & 7) != 0 && (i & (b(this.f1501d, this.f1499b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f1498a;
            if ((i2 & 112) != 0 && (i2 & (b(this.f1501d, this.f1500c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f1498a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.f1502e, this.f1499b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f1498a;
            return (i4 & 28672) == 0 || (i4 & (b(this.f1502e, this.f1500c) << 12)) != 0;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    public interface b {
        View a(int i);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    public f0(b bVar) {
        this.f1496a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int c2 = this.f1496a.c();
        int b2 = this.f1496a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f1496a.a(i);
            int e2 = this.f1496a.e(a2);
            int d2 = this.f1496a.d(a2);
            a aVar = this.f1497b;
            aVar.f1499b = c2;
            aVar.f1500c = b2;
            aVar.f1501d = e2;
            aVar.f1502e = d2;
            if (i3 != 0) {
                aVar.f1498a = 0;
                aVar.f1498a = i3 | 0;
                if (aVar.a()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.f1497b;
                aVar2.f1498a = 0;
                aVar2.f1498a = i4 | 0;
                if (aVar2.a()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.f1497b;
        int c2 = this.f1496a.c();
        int b2 = this.f1496a.b();
        int e2 = this.f1496a.e(view);
        int d2 = this.f1496a.d(view);
        aVar.f1499b = c2;
        aVar.f1500c = b2;
        aVar.f1501d = e2;
        aVar.f1502e = d2;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.f1497b;
        aVar2.f1498a = 0;
        aVar2.f1498a = 0 | i;
        return aVar2.a();
    }
}
