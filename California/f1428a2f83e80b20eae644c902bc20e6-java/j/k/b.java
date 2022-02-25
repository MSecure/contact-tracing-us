package j.k;

import j.h.e;
import java.util.NoSuchElementException;

public final class b extends e {
    public final int b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public int f3993d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3994e;

    public b(int i2, int i3, int i4) {
        this.f3994e = i4;
        this.b = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.c = z;
        this.f3993d = !z ? i3 : i2;
    }

    @Override // j.h.e
    public int b() {
        int i2 = this.f3993d;
        if (i2 != this.b) {
            this.f3993d = this.f3994e + i2;
        } else if (this.c) {
            this.c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    public boolean hasNext() {
        return this.c;
    }
}
