package e.b.e;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import e.b.e.a;
import e.b.e.i.j;
import e.b.e.i.o;
import e.e.h;
import e.i.d.a.b;
import java.util.ArrayList;

public class e extends ActionMode {
    public final Context a;
    public final a b;

    public static class a implements a.AbstractC0014a {
        public final ActionMode.Callback a;
        public final Context b;
        public final ArrayList<e> c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final h<Menu, Menu> f735d = new h<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // e.b.e.a.AbstractC0014a
        public boolean a(a aVar, Menu menu) {
            return this.a.onPrepareActionMode(e(aVar), f(menu));
        }

        @Override // e.b.e.a.AbstractC0014a
        public boolean b(a aVar, MenuItem menuItem) {
            return this.a.onActionItemClicked(e(aVar), new j(this.b, (b) menuItem));
        }

        @Override // e.b.e.a.AbstractC0014a
        public boolean c(a aVar, Menu menu) {
            return this.a.onCreateActionMode(e(aVar), f(menu));
        }

        @Override // e.b.e.a.AbstractC0014a
        public void d(a aVar) {
            this.a.onDestroyActionMode(e(aVar));
        }

        public ActionMode e(a aVar) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.c.get(i2);
                if (eVar != null && eVar.b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.b, aVar);
            this.c.add(eVar2);
            return eVar2;
        }

        public final Menu f(Menu menu) {
            Menu orDefault = this.f735d.getOrDefault(menu, null);
            if (orDefault != null) {
                return orDefault;
            }
            o oVar = new o(this.b, (e.i.d.a.a) menu);
            this.f735d.put(menu, oVar);
            return oVar;
        }
    }

    public e(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public void finish() {
        this.b.c();
    }

    public View getCustomView() {
        return this.b.d();
    }

    public Menu getMenu() {
        return new o(this.a, (e.i.d.a.a) this.b.e());
    }

    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    public CharSequence getSubtitle() {
        return this.b.g();
    }

    public Object getTag() {
        return this.b.b;
    }

    public CharSequence getTitle() {
        return this.b.h();
    }

    public boolean getTitleOptionalHint() {
        return this.b.c;
    }

    public void invalidate() {
        this.b.i();
    }

    public boolean isTitleOptional() {
        return this.b.j();
    }

    public void setCustomView(View view) {
        this.b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i2) {
        this.b.l(i2);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.m(charSequence);
    }

    public void setTag(Object obj) {
        this.b.b = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(int i2) {
        this.b.n(i2);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.o(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.b.p(z);
    }
}
