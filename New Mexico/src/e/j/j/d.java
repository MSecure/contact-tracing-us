package e.j.j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public abstract class d {
    public a a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public d(Context context) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h(a aVar) {
        if (this.a != null) {
            getClass().getSimpleName();
        }
        this.a = aVar;
    }
}
