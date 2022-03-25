package f.a.b.w;

import f.a.b.g;
import java.io.InputStream;
import java.util.List;

public final class d {
    public final int a;
    public final List<g> b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f2075d;

    public d(int i2, List<g> list) {
        this.a = i2;
        this.b = list;
        this.c = -1;
        this.f2075d = null;
    }

    public d(int i2, List<g> list, int i3, InputStream inputStream) {
        this.a = i2;
        this.b = list;
        this.c = i3;
        this.f2075d = inputStream;
    }
}
