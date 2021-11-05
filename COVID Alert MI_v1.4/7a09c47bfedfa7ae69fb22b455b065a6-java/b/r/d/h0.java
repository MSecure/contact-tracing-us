package b.r.d;

import android.view.View;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f2346a;

    /* renamed from: b  reason: collision with root package name */
    public a f2347b = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2348a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f2349b;

        /* renamed from: c  reason: collision with root package name */
        public int f2350c;

        /* renamed from: d  reason: collision with root package name */
        public int f2351d;

        /* renamed from: e  reason: collision with root package name */
        public int f2352e;

        public boolean a() {
            int i = this.f2348a;
            if ((i & 7) != 0 && (i & (b(this.f2351d, this.f2349b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f2348a;
            if ((i2 & 112) != 0 && (i2 & (b(this.f2351d, this.f2350c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f2348a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.f2352e, this.f2349b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f2348a;
            return (i4 & 28672) == 0 || (i4 & (b(this.f2352e, this.f2350c) << 12)) != 0;
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

    public h0(b bVar) {
        this.f2346a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int c2 = this.f2346a.c();
        int b2 = this.f2346a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a2 = this.f2346a.a(i);
            int e2 = this.f2346a.e(a2);
            int d2 = this.f2346a.d(a2);
            a aVar = this.f2347b;
            aVar.f2349b = c2;
            aVar.f2350c = b2;
            aVar.f2351d = e2;
            aVar.f2352e = d2;
            if (i3 != 0) {
                aVar.f2348a = 0;
                aVar.f2348a = i3 | 0;
                if (aVar.a()) {
                    return a2;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.f2347b;
                aVar2.f2348a = 0;
                aVar2.f2348a = i4 | 0;
                if (aVar2.a()) {
                    view = a2;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.f2347b;
        int c2 = this.f2346a.c();
        int b2 = this.f2346a.b();
        int e2 = this.f2346a.e(view);
        int d2 = this.f2346a.d(view);
        aVar.f2349b = c2;
        aVar.f2350c = b2;
        aVar.f2351d = e2;
        aVar.f2352e = d2;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.f2347b;
        aVar2.f2348a = 0;
        aVar2.f2348a = 0 | i;
        return aVar2.a();
    }
}
