package f.b.a.e.k;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class t<S> extends z<S> {
    public int X;
    public f<S> Y;
    public a Z;

    public class a extends y<S> {
        public a() {
        }

        @Override // f.b.a.e.k.y
        public void a() {
            Iterator<y<S>> it = t.this.W.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // f.b.a.e.k.y
        public void b(S s) {
            Iterator<y<S>> it = t.this.W.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @Override // e.m.a.m
    public void M(Bundle bundle) {
        super.M(bundle);
        if (bundle == null) {
            bundle = this.f1454g;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (f) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.Z = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.Y.l(layoutInflater.cloneInContext(new ContextThemeWrapper(j(), this.X)), viewGroup, bundle, this.Z, new a());
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
    }
}
