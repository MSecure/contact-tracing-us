package b.b.p.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.e.h;
import b.i.g.a.b;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f690a;

    /* renamed from: b  reason: collision with root package name */
    public h<b, MenuItem> f691b;

    /* renamed from: c  reason: collision with root package name */
    public h<b.i.g.a.c, SubMenu> f692c;

    public c(Context context) {
        this.f690a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f691b == null) {
            this.f691b = new h<>();
        }
        MenuItem orDefault = this.f691b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        j jVar = new j(this.f690a, bVar);
        this.f691b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof b.i.g.a.c)) {
            return subMenu;
        }
        b.i.g.a.c cVar = (b.i.g.a.c) subMenu;
        if (this.f692c == null) {
            this.f692c = new h<>();
        }
        SubMenu subMenu2 = this.f692c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f690a, cVar);
        this.f692c.put(cVar, sVar);
        return sVar;
    }
}
