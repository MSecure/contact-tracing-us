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
    public Context f730d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f731e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0014a f732f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f733g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f734h;

    /* renamed from: i  reason: collision with root package name */
    public g f735i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0014a aVar, boolean z) {
        this.f730d = context;
        this.f731e = actionBarContextView;
        this.f732f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f795l = 1;
        this.f735i = gVar;
        gVar.f788e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f732f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f731e.f830e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f734h) {
            this.f734h = true;
            this.f731e.sendAccessibilityEvent(32);
            this.f732f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f733g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f735i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f731e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f731e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f731e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f732f.a(this, this.f735i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f731e.s;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f731e.setCustomView(view);
        this.f733g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f731e.setSubtitle(this.f730d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f731e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f731e.setTitle(this.f730d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f731e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f731e.setTitleOptional(z);
    }
}
