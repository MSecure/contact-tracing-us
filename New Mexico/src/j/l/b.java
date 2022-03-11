package j.l;

import j.i.e;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class b extends e {
    public final int b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public int f4572d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4573e;

    public b(int i2, int i3, int i4) {
        this.f4573e = i4;
        this.b = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.c = z;
        this.f4572d = !z ? i3 : i2;
    }

    @Override // j.i.e
    public int b() {
        int i2 = this.f4572d;
        if (i2 != this.b) {
            this.f4572d = this.f4573e + i2;
        } else if (this.c) {
            this.c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
