package f.b.a.f.a.b;

import android.content.ComponentName;
import android.content.Context;
import f.b.a.c.b.o.b;
import f.b.a.f.a.e.u;
import java.util.Objects;
/* loaded from: classes.dex */
public final class p3 implements u<Object> {
    public final u<i3> a;
    public final u<Context> b;

    public p3(u<i3> uVar, u<Context> uVar2) {
        this.a = uVar;
        this.b = uVar2;
    }

    @Override // f.b.a.f.a.e.u
    public final Object a() {
        i3 a = this.a.a();
        Context b = ((r3) this.b).b();
        i3 i3Var = a;
        b.J1(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        b.J1(b.getPackageManager(), new ComponentName(b.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService"), 4);
        Objects.requireNonNull(i3Var, "Cannot return null from a non-@Nullable @Provides method");
        return i3Var;
    }
}
