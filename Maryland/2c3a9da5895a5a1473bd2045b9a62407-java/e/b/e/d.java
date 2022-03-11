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
    public Context f733d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f734e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0017a f735f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f736g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f737h;

    /* renamed from: i  reason: collision with root package name */
    public g f738i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0017a aVar, boolean z) {
        this.f733d = context;
        this.f734e = actionBarContextView;
        this.f735f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f798l = 1;
        this.f738i = gVar;
        gVar.f791e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f735f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f734e.f833e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f737h) {
            this.f737h = true;
            this.f734e.sendAccessibilityEvent(32);
            this.f735f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f736g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f738i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f734e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f734e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f734e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f735f.a(this, this.f738i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f734e.s;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f734e.setCustomView(view);
        this.f736g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f734e.setSubtitle(this.f733d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f734e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f734e.setTitle(this.f733d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f734e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f734e.setTitleOptional(z);
    }
}
