package b.g.a.h;

import java.util.HashSet;
import java.util.Iterator;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public HashSet<l> f929a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    public int f930b = 0;

    public void a() {
        this.f930b = 1;
        Iterator<l> it = this.f929a.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public void b() {
        this.f930b = 0;
        Iterator<l> it = this.f929a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public boolean c() {
        return this.f930b == 1;
    }

    public void d() {
    }
}
