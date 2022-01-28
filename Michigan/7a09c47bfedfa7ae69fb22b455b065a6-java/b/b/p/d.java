package b.b.p;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import b.b.p.a;
import b.b.p.i.g;
import b.b.q.c;
import java.lang.ref.WeakReference;

public class d extends a implements g.a {

    /* renamed from: d  reason: collision with root package name */
    public Context f641d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f642e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0012a f643f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f644g;
    public boolean h;
    public g i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0012a aVar, boolean z) {
        this.f641d = context;
        this.f642e = actionBarContextView;
        this.f643f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.l = 1;
        this.i = gVar;
        gVar.f726e = this;
    }

    @Override // b.b.p.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f643f.b(this, menuItem);
    }

    @Override // b.b.p.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f642e.f771e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // b.b.p.a
    public void c() {
        if (!this.h) {
            this.h = true;
            this.f642e.sendAccessibilityEvent(32);
            this.f643f.d(this);
        }
    }

    @Override // b.b.p.a
    public View d() {
        WeakReference<View> weakReference = this.f644g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // b.b.p.a
    public Menu e() {
        return this.i;
    }

    @Override // b.b.p.a
    public MenuInflater f() {
        return new f(this.f642e.getContext());
    }

    @Override // b.b.p.a
    public CharSequence g() {
        return this.f642e.getSubtitle();
    }

    @Override // b.b.p.a
    public CharSequence h() {
        return this.f642e.getTitle();
    }

    @Override // b.b.p.a
    public void i() {
        this.f643f.a(this, this.i);
    }

    @Override // b.b.p.a
    public boolean j() {
        return this.f642e.s;
    }

    @Override // b.b.p.a
    public void k(View view) {
        this.f642e.setCustomView(view);
        this.f644g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // b.b.p.a
    public void l(int i2) {
        this.f642e.setSubtitle(this.f641d.getString(i2));
    }

    @Override // b.b.p.a
    public void m(CharSequence charSequence) {
        this.f642e.setSubtitle(charSequence);
    }

    @Override // b.b.p.a
    public void n(int i2) {
        this.f642e.setTitle(this.f641d.getString(i2));
    }

    @Override // b.b.p.a
    public void o(CharSequence charSequence) {
        this.f642e.setTitle(charSequence);
    }

    @Override // b.b.p.a
    public void p(boolean z) {
        this.f635c = z;
        this.f642e.setTitleOptional(z);
    }
}
