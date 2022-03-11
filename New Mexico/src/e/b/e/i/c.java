package e.b.e.i;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import e.f.h;
import e.j.e.a.b;
/* loaded from: classes.dex */
public abstract class c {
    public final Context a;
    public h<b, MenuItem> b;
    public h<e.j.e.a.c, SubMenu> c;

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
        if (!(subMenu instanceof e.j.e.a.c)) {
            return subMenu;
        }
        e.j.e.a.c cVar = (e.j.e.a.c) subMenu;
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
