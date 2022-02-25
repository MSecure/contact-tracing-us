package e.k.b;

import android.graphics.Rect;
import e.k.b.a;
import java.util.Comparator;

public class d<T> implements Comparator<T> {
    public final Rect a = new Rect();
    public final Rect b = new Rect();
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final b<T> f1532d;

    public d(boolean z, b<T> bVar) {
        this.c = z;
        this.f1532d = bVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.a;
        Rect rect2 = this.b;
        ((a.C0040a) this.f1532d).a(t, rect);
        ((a.C0040a) this.f1532d).a(t2, rect2);
        int i2 = rect.top;
        int i3 = rect2.top;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        int i4 = rect.left;
        int i5 = rect2.left;
        if (i4 < i5) {
            return this.c ? 1 : -1;
        }
        if (i4 > i5) {
            return this.c ? -1 : 1;
        }
        int i6 = rect.bottom;
        int i7 = rect2.bottom;
        if (i6 < i7) {
            return -1;
        }
        if (i6 > i7) {
            return 1;
        }
        int i8 = rect.right;
        int i9 = rect2.right;
        if (i8 < i9) {
            return this.c ? 1 : -1;
        }
        if (i8 > i9) {
            return this.c ? -1 : 1;
        }
        return 0;
    }
}
