package b.b.p.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b.e.h;
import b.i.g.a.b;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f514a;

    /* renamed from: b  reason: collision with root package name */
    public h<b, MenuItem> f515b;

    /* renamed from: c  reason: collision with root package name */
    public h<b.i.g.a.c, SubMenu> f516c;

    public c(Context context) {
        this.f514a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f515b == null) {
            this.f515b = new h<>();
        }
        MenuItem orDefault = this.f515b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        j jVar = new j(this.f514a, bVar);
        this.f515b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof b.i.g.a.c)) {
            return subMenu;
        }
        b.i.g.a.c cVar = (b.i.g.a.c) subMenu;
        if (this.f516c == null) {
            this.f516c = new h<>();
        }
        SubMenu subMenu2 = this.f516c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.f514a, cVar);
        this.f516c.put(cVar, sVar);
        return sVar;
    }
}
