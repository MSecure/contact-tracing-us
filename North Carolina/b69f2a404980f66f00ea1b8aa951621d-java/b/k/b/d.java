package b.k.b;

import android.graphics.Rect;
import b.k.b.a;
import java.util.Comparator;

public class d<T> implements Comparator<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Rect f1235b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1236c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1237d;

    /* renamed from: e  reason: collision with root package name */
    public final b<T> f1238e;

    public d(boolean z, b<T> bVar) {
        this.f1237d = z;
        this.f1238e = bVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.f1235b;
        Rect rect2 = this.f1236c;
        ((a.C0030a) this.f1238e).a(t, rect);
        ((a.C0030a) this.f1238e).a(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.f1237d ? 1 : -1;
        }
        if (i3 > i4) {
            return this.f1237d ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return this.f1237d ? 1 : -1;
        }
        if (i7 > i8) {
            return this.f1237d ? -1 : 1;
        }
        return 0;
    }
}
