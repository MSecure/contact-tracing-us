package c.b.d;

import c.b.d.j;
import java.util.NoSuchElementException;

public class i extends j.a {

    /* renamed from: b  reason: collision with root package name */
    public int f3903b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f3904c = this.f3905d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ j f3905d;

    public i(j jVar) {
        this.f3905d = jVar;
    }

    public byte a() {
        int i = this.f3903b;
        if (i < this.f3904c) {
            this.f3903b = i + 1;
            return this.f3905d.m(i);
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.f3903b < this.f3904c;
    }
}
