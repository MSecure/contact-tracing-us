package c.b.c.a.j0.a;

import c.b.c.a.j0.a.i;
import java.util.NoSuchElementException;

public class h extends i.a {

    /* renamed from: b  reason: collision with root package name */
    public int f4923b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4924c = this.f4925d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f4925d;

    public h(i iVar) {
        this.f4925d = iVar;
    }

    public byte a() {
        int i = this.f4923b;
        if (i < this.f4924c) {
            this.f4923b = i + 1;
            return this.f4925d.l(i);
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f4923b < this.f4924c;
    }
}
