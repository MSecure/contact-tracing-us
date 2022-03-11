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
/* loaded from: classes.dex */
public class d extends a implements g.a {

    /* renamed from: d  reason: collision with root package name */
    public Context f795d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f796e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0017a f797f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f798g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f799h;

    /* renamed from: i  reason: collision with root package name */
    public g f800i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0017a aVar, boolean z) {
        this.f795d = context;
        this.f796e = actionBarContextView;
        this.f797f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f860l = 1;
        this.f800i = gVar;
        gVar.f853e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f797f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f796e.f895e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f799h) {
            this.f799h = true;
            this.f796e.sendAccessibilityEvent(32);
            this.f797f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f798g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f800i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f796e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f796e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f796e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f797f.a(this, this.f800i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f796e.t;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f796e.setCustomView(view);
        this.f798g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f796e.setSubtitle(this.f795d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f796e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f796e.setTitle(this.f795d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f796e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f796e.setTitleOptional(z);
    }
}
