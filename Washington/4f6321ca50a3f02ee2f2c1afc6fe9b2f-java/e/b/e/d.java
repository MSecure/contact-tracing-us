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
    public Context f729d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContextView f730e;

    /* renamed from: f  reason: collision with root package name */
    public a.AbstractC0014a f731f;

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<View> f732g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f733h;

    /* renamed from: i  reason: collision with root package name */
    public g f734i;

    public d(Context context, ActionBarContextView actionBarContextView, a.AbstractC0014a aVar, boolean z) {
        this.f729d = context;
        this.f730e = actionBarContextView;
        this.f731f = aVar;
        g gVar = new g(actionBarContextView.getContext());
        gVar.f794l = 1;
        this.f734i = gVar;
        gVar.f787e = this;
    }

    @Override // e.b.e.i.g.a
    public boolean a(g gVar, MenuItem menuItem) {
        return this.f731f.b(this, menuItem);
    }

    @Override // e.b.e.i.g.a
    public void b(g gVar) {
        i();
        c cVar = this.f730e.f829e;
        if (cVar != null) {
            cVar.n();
        }
    }

    @Override // e.b.e.a
    public void c() {
        if (!this.f733h) {
            this.f733h = true;
            this.f730e.sendAccessibilityEvent(32);
            this.f731f.d(this);
        }
    }

    @Override // e.b.e.a
    public View d() {
        WeakReference<View> weakReference = this.f732g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // e.b.e.a
    public Menu e() {
        return this.f734i;
    }

    @Override // e.b.e.a
    public MenuInflater f() {
        return new f(this.f730e.getContext());
    }

    @Override // e.b.e.a
    public CharSequence g() {
        return this.f730e.getSubtitle();
    }

    @Override // e.b.e.a
    public CharSequence h() {
        return this.f730e.getTitle();
    }

    @Override // e.b.e.a
    public void i() {
        this.f731f.a(this, this.f734i);
    }

    @Override // e.b.e.a
    public boolean j() {
        return this.f730e.s;
    }

    @Override // e.b.e.a
    public void k(View view) {
        this.f730e.setCustomView(view);
        this.f732g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // e.b.e.a
    public void l(int i2) {
        this.f730e.setSubtitle(this.f729d.getString(i2));
    }

    @Override // e.b.e.a
    public void m(CharSequence charSequence) {
        this.f730e.setSubtitle(charSequence);
    }

    @Override // e.b.e.a
    public void n(int i2) {
        this.f730e.setTitle(this.f729d.getString(i2));
    }

    @Override // e.b.e.a
    public void o(CharSequence charSequence) {
        this.f730e.setTitle(charSequence);
    }

    @Override // e.b.e.a
    public void p(boolean z) {
        this.c = z;
        this.f730e.setTitleOptional(z);
    }
}
