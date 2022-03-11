package e.b.e.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import e.i.d.a.c;

public class s extends o implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    public final c f827e;

    public s(Context context, c cVar) {
        super(context, cVar);
        this.f827e = cVar;
    }

    public void clearHeader() {
        this.f827e.clearHeader();
    }

    public MenuItem getItem() {
        return c(this.f827e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        this.f827e.setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f827e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        this.f827e.setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f827e.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f827e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.f827e.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f827e.setIcon(drawable);
        return this;
    }
}
