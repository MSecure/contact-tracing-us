package e.b.e.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import e.e.h;
import e.i.d.a.b;

public abstract class c {
    public final Context a;
    public h<b, MenuItem> b;
    public h<e.i.d.a.c, SubMenu> c;

    public c(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.b == null) {
            this.b = new h<>();
        }
        MenuItem orDefault = this.b.getOrDefault(menuItem, null);
        if (orDefault != null) {
            return orDefault;
        }
        j jVar = new j(this.a, bVar);
        this.b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof e.i.d.a.c)) {
            return subMenu;
        }
        e.i.d.a.c cVar = (e.i.d.a.c) subMenu;
        if (this.c == null) {
            this.c = new h<>();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.a, cVar);
        this.c.put(cVar, sVar);
        return sVar;
    }
}
