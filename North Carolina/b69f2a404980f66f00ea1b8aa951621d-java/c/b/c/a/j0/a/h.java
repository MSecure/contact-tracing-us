package c.b.c.a.j0.a;

import c.b.c.a.j0.a.i;
import java.util.NoSuchElementException;

public class h extends i.a {

    /* renamed from: b  reason: collision with root package name */
    public int f3554b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f3555c = this.f3556d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ i f3556d;

    public h(i iVar) {
        this.f3556d = iVar;
    }

    public byte a() {
        int i = this.f3554b;
        if (i < this.f3555c) {
            this.f3554b = i + 1;
            return this.f3556d.o(i);
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f3554b < this.f3555c;
    }
}
