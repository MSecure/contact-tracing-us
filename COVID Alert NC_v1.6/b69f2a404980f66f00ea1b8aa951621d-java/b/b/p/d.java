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
    public Context f475d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f476e;
    public a.AbstractC0009a f;
    public WeakReference<View> g;
    public boolean h;
    public g i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0009a aVar, boolean z) {
        this.f475d = context;
        this.f476e = actionBarContextView;
        this.f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.l = 1;
        this.i = gVar;
        gVar.f544e = this;
    }

    @Override // b.b.p.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f.b(this, menuItem);
    }

    @Override // b.b.p.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f476e.f581e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // b.b.p.a
    public void c() {
        if (!this.h) {
            this.h = true;
            this.f476e.sendAccessibilityEvent(32);
            this.f.d(this);
        }
    }

    @Override // b.b.p.a
    public View d() {
        WeakReference<View> weakReference = this.g;
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
        return new f(this.f476e.getContext());
    }

    @Override // b.b.p.a
    public CharSequence g() {
        return this.f476e.getSubtitle();
    }

    @Override // b.b.p.a
    public CharSequence h() {
        return this.f476e.getTitle();
    }

    @Override // b.b.p.a
    public void i() {
        this.f.a(this, this.i);
    }

    @Override // b.b.p.a
    public boolean j() {
        return this.f476e.s;
    }

    @Override // b.b.p.a
    public void k(View view) {
        this.f476e.setCustomView(view);
        this.g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // b.b.p.a
    public void l(int i2) {
        this.f476e.setSubtitle(this.f475d.getString(i2));
    }

    @Override // b.b.p.a
    public void m(CharSequence charSequence) {
        this.f476e.setSubtitle(charSequence);
    }

    @Override // b.b.p.a
    public void n(int i2) {
        this.f476e.setTitle(this.f475d.getString(i2));
    }

    @Override // b.b.p.a
    public void o(CharSequence charSequence) {
        this.f476e.setTitle(charSequence);
    }

    @Override // b.b.p.a
    public void p(boolean z) {
        this.f469c = z;
        this.f476e.setTitleOptional(z);
    }
}
