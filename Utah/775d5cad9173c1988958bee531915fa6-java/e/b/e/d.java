package e.b.e;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import e.b.e.a;
import e.b.e.i.g;
import e.b.f.c;
import java.lang.ref.WeakReference;

public class d extends a implements g.a {

    /* renamed from: d  reason: collision with root package name */
    public Context f731d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f732e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0015a f733f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f734g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f735h;

    /* renamed from: i  reason: collision with root package name */
    public g f736i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0015a aVar, boolean z) {
        this.f731d = context;
        this.f732e = actionBarContextView;
        this.f733f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f796l = 1;
        this.f736i = gVar;
        gVar.f789e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f733f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f732e.f831e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f735h) {
            this.f735h = true;
            this.f732e.sendAccessibilityEvent(32);
            this.f733f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f734g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f736i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f732e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f732e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f732e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f733f.a(this, this.f736i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f732e.t;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f732e.setCustomView(view);
        this.f734g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f732e.setSubtitle(this.f731d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f732e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f732e.setTitle(this.f731d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f732e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f732e.setTitleOptional(z);
    }
}
