package c.b.d;

import c.b.d.j;
import java.util.NoSuchElementException;

public class i extends j.a {

    /* renamed from: b  reason: collision with root package name */
    public int f5311b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f5312c = this.f5313d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j f5313d;

    public i(j jVar) {
        this.f5313d = jVar;
    }

    public byte a() {
        int i = this.f5311b;
        if (i < this.f5312c) {
            this.f5311b = i + 1;
            return this.f5313d.l(i);
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f5311b < this.f5312c;
    }
}
