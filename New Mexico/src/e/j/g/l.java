package e.j.g;

import android.net.Uri;
import java.util.Objects;
/* loaded from: classes.dex */
public class l {
    public final Uri a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1596d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1597e;

    @Deprecated
    public l(Uri uri, int i2, int i3, boolean z, int i4) {
        Objects.requireNonNull(uri);
        this.a = uri;
        this.b = i2;
        this.c = i3;
        this.f1596d = z;
        this.f1597e = i4;
    }
}
