package b.b.p;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b.b.p.a;
import b.b.p.i.j;
import b.b.p.i.o;
import b.e.h;
import b.i.g.a.b;
import java.util.ArrayList;

public class e extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    public final Context f477a;

    /* renamed from: b  reason: collision with root package name */
    public final a f478b;

    public static class a implements a.AbstractC0009a {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f479a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f480b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f481c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final h<Menu, Menu> f482d = new h<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f480b = context;
            this.f479a = callback;
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean a(a aVar, Menu menu) {
            return this.f479a.onPrepareActionMode(e(aVar), f(menu));
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean b(a aVar, MenuItem menuItem) {
            return this.f479a.onActionItemClicked(e(aVar), new j(this.f480b, (b) menuItem));
        }

        @Override // b.b.p.a.AbstractC0009a
        public boolean c(a aVar, Menu menu) {
            return this.f479a.onCreateActionMode(e(aVar), f(menu));
        }

        @Override // b.b.p.a.AbstractC0009a
        public void d(a aVar) {
            this.f479a.onDestroyActionMode(e(aVar));
        }

        public ActionMode e(a aVar) {
            int size = this.f481c.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f481c.get(i);
                if (eVar != null && eVar.f478b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f480b, aVar);
            this.f481c.add(eVar2);
            return eVar2;
        }

        public final Menu f(Menu menu) {
            Menu orDefault = this.f482d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            o oVar = new o(this.f480b, (b.i.g.a.a) menu);
            this.f482d.put(menu, oVar);
            return oVar;
        }
    }

    public e(Context context, a aVar) {
        this.f477a = context;
        this.f478b = aVar;
    }

    public void finish() {
        this.f478b.c();
    }

    public View getCustomView() {
        return this.f478b.d();
    }

    public Menu getMenu() {
        return new o(this.f477a, (b.i.g.a.a) this.f478b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f478b.f();
    }

    public CharSequence getSubtitle() {
        return this.f478b.g();
    }

    public Object getTag() {
        return this.f478b.f468b;
    }

    public CharSequence getTitle() {
        return this.f478b.h();
    }

    public boolean getTitleOptionalHint() {
        return this.f478b.f469c;
    }

    public void invalidate() {
        this.f478b.i();
    }

    public boolean isTitleOptional() {
        return this.f478b.j();
    }

    public void setCustomView(View view) {
        this.f478b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f478b.l(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f478b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.f478b.f468b = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f478b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f478b.o(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f478b.p(z);
    }
}
