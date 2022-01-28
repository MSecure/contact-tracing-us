package c.b.a.b.x;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class r<S> extends x<S> {

    /* renamed from: c  reason: collision with root package name */
    public d<S> f4607c;

    /* renamed from: d  reason: collision with root package name */
    public a f4608d;

    public class a extends w<S> {
        public a() {
        }

        @Override // c.b.a.b.x.w
        public void a(S s) {
            Iterator<w<S>> it = r.this.f4629b.iterator();
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
        this.f4607c = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f4608d = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f4607c.r(layoutInflater, viewGroup, bundle, this.f4608d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f4607c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4608d);
    }
}
