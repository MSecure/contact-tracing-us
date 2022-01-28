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
    public final Context f645a;

    /* renamed from: b  reason: collision with root package name */
    public final a f646b;

    public static class a implements a.AbstractC0012a {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f647a;

        /* renamed from: b  reason: collision with root package name */
        public final Context f648b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<e> f649c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final h<Menu, Menu> f650d = new h<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f648b = context;
            this.f647a = callback;
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean a(a aVar, Menu menu) {
            return this.f647a.onPrepareActionMode(e(aVar), f(menu));
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean b(a aVar, MenuItem menuItem) {
            return this.f647a.onActionItemClicked(e(aVar), new j(this.f648b, (b) menuItem));
        }

        @Override // b.b.p.a.AbstractC0012a
        public boolean c(a aVar, Menu menu) {
            return this.f647a.onCreateActionMode(e(aVar), f(menu));
        }

        @Override // b.b.p.a.AbstractC0012a
        public void d(a aVar) {
            this.f647a.onDestroyActionMode(e(aVar));
        }

        public ActionMode e(a aVar) {
            int size = this.f649c.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f649c.get(i);
                if (eVar != null && eVar.f646b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f648b, aVar);
            this.f649c.add(eVar2);
            return eVar2;
        }

        public final Menu f(Menu menu) {
            Menu orDefault = this.f650d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            o oVar = new o(this.f648b, (b.i.g.a.a) menu);
            this.f650d.put(menu, oVar);
            return oVar;
        }
    }

    public e(Context context, a aVar) {
        this.f645a = context;
        this.f646b = aVar;
    }

    public void finish() {
        this.f646b.c();
    }

    public View getCustomView() {
        return this.f646b.d();
    }

    public Menu getMenu() {
        return new o(this.f645a, (b.i.g.a.a) this.f646b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.f646b.f();
    }

    public CharSequence getSubtitle() {
        return this.f646b.g();
    }

    public Object getTag() {
        return this.f646b.f634b;
    }

    public CharSequence getTitle() {
        return this.f646b.h();
    }

    public boolean getTitleOptionalHint() {
        return this.f646b.f635c;
    }

    public void invalidate() {
        this.f646b.i();
    }

    public boolean isTitleOptional() {
        return this.f646b.j();
    }

    public void setCustomView(View view) {
        this.f646b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f646b.l(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f646b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.f646b.f634b = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f646b.n(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f646b.o(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f646b.p(z);
    }
}
