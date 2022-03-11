package f.b.a.d.l;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class t<S> extends z<S> {
    public int Y;
    public f<S> Z;
    public a a0;

    public class a extends y<S> {
        public a() {
        }

        @Override // f.b.a.d.l.y
        public void a() {
            Iterator<y<S>> it = t.this.X.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // f.b.a.d.l.y
        public void b(S s) {
            Iterator<y<S>> it = t.this.X.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1632g;
        }
        this.Y = bundle.getInt("THEME_RES_ID_KEY");
        this.Z = (f) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.a0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.Z.l(layoutInflater.cloneInContext(new ContextThemeWrapper(k(), this.Y)), viewGroup, bundle, this.a0, new a());
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
    }
}
