package b.g.a.h;

import b.g.a.h.c;
import java.util.ArrayList;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public int f931a;

    /* renamed from: b  reason: collision with root package name */
    public int f932b;

    /* renamed from: c  reason: collision with root package name */
    public int f933c;

    /* renamed from: d  reason: collision with root package name */
    public int f934d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<a> f935e = new ArrayList<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public c f936a;

        /* renamed from: b  reason: collision with root package name */
        public c f937b;

        /* renamed from: c  reason: collision with root package name */
        public int f938c;

        /* renamed from: d  reason: collision with root package name */
        public c.a f939d;

        /* renamed from: e  reason: collision with root package name */
        public int f940e;

        public a(c cVar) {
            this.f936a = cVar;
            this.f937b = cVar.f900d;
            this.f938c = cVar.b();
            this.f939d = cVar.g;
            this.f940e = cVar.h;
        }
    }

    public m(d dVar) {
        this.f931a = dVar.I;
        this.f932b = dVar.J;
        this.f933c = dVar.n();
        this.f934d = dVar.h();
        ArrayList<c> arrayList = dVar.B;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            this.f935e.add(new a(arrayList.get(i)));
        }
    }
}
