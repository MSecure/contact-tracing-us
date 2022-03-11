package f.b.a.f.a.b;

import android.os.Bundle;
import f.b.a.f.a.e.g0;
import f.b.a.f.a.h.n;
import java.util.List;
/* loaded from: classes.dex */
public class k<T> extends g0 {
    public final n<T> a;
    public final /* synthetic */ s b;

    public k(s sVar, n<T> nVar) {
        this.b = sVar;
        this.a = nVar;
    }

    @Override // f.b.a.f.a.e.h0
    public void B(Bundle bundle) {
        this.b.f3289d.c(this.a);
        int i2 = bundle.getInt("error_code");
        s.f3287g.b("onError(%d)", Integer.valueOf(i2));
        this.a.a(new a(i2));
    }

    @Override // f.b.a.f.a.e.h0
    public void h(Bundle bundle, Bundle bundle2) {
        this.b.f3289d.c(this.a);
        s.f3287g.d("onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // f.b.a.f.a.e.h0
    public void n(List<Bundle> list) {
        this.b.f3289d.c(this.a);
        s.f3287g.d("onGetSessionStates", new Object[0]);
    }

    @Override // f.b.a.f.a.e.h0
    public void v(Bundle bundle, Bundle bundle2) {
        this.b.f3289d.c(this.a);
        s.f3287g.d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }
}
