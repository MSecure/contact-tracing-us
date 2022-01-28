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
    public Context f723d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f724e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0016a f725f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f726g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f727h;

    /* renamed from: i  reason: collision with root package name */
    public g f728i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0016a aVar, boolean z) {
        this.f723d = context;
        this.f724e = actionBarContextView;
        this.f725f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f788l = 1;
        this.f728i = gVar;
        gVar.f781e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f725f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f724e.f823e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f727h) {
            this.f727h = true;
            this.f724e.sendAccessibilityEvent(32);
            this.f725f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f726g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f728i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f724e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f724e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f724e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f725f.a(this, this.f728i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f724e.s;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f724e.setCustomView(view);
        this.f726g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f724e.setSubtitle(this.f723d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f724e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f724e.setTitle(this.f723d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f724e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f724e.setTitleOptional(z);
    }
}
