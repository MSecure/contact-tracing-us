package e.b.e.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class r extends g implements SubMenu {
    public i A;
    public g z;

    public r(Context context, g gVar, i iVar) {
        super(context);
        this.z = gVar;
        this.A = iVar;
    }

    @Override // e.b.e.i.g
    public boolean d(i iVar) {
        return this.z.d(iVar);
    }

    @Override // e.b.e.i.g
    public boolean e(g gVar, MenuItem menuItem) {
        return super.e(gVar, menuItem) || this.z.e(gVar, menuItem);
    }

    @Override // e.b.e.i.g
    public boolean f(i iVar) {
        return this.z.f(iVar);
    }

    public MenuItem getItem() {
        return this.A;
    }

    @Override // e.b.e.i.g
    public String j() {
        i iVar = this.A;
        int i2 = iVar != null ? iVar.a : 0;
        if (i2 == 0) {
            return null;
        }
        return "android:menu:actionviewstates" + ":" + i2;
    }

    @Override // e.b.e.i.g
    public g k() {
        return this.z.k();
    }

    @Override // e.b.e.i.g
    public boolean m() {
        return this.z.m();
    }

    @Override // e.b.e.i.g
    public boolean n() {
        return this.z.n();
    }

    @Override // e.b.e.i.g
    public boolean o() {
        return this.z.o();
    }

    @Override // e.b.e.i.g
    public void setGroupDividerEnabled(boolean z2) {
        this.z.setGroupDividerEnabled(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        x(0, null, i2, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        x(i2, null, 0, null, null);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        x(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.A.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // e.b.e.i.g
    public void setQwertyMode(boolean z2) {
        this.z.setQwertyMode(z2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        x(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        x(0, charSequence, 0, null, null);
        return this;
    }
}
