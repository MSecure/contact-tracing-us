package f.b.a.f.a.b;

import com.google.android.play.core.assetpacks.AssetPackState;
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ y b;
    public final /* synthetic */ AssetPackState c;

    public /* synthetic */ x(y yVar, AssetPackState assetPackState) {
        this.b = yVar;
        this.c = assetPackState;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c(this.c);
    }
}
