package c.b.a.b.x;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class r<S> extends x<S> {

    /* renamed from: c  reason: collision with root package name */
    public d<S> f3276c;

    /* renamed from: d  reason: collision with root package name */
    public a f3277d;

    public class a extends w<S> {
        public a() {
        }

        @Override // c.b.a.b.x.w
        public void a(S s) {
            Iterator<w<S>> it = r.this.f3295b.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f3276c = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f3277d = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f3276c.n(layoutInflater, viewGroup, bundle, this.f3277d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f3276c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3277d);
    }
}
