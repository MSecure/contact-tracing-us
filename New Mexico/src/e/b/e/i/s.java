package e.b.e.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import e.j.e.a.c;
/* loaded from: classes.dex */
public class s extends o implements SubMenu {

    /* renamed from: e  reason: collision with root package name */
    public final c f893e;

    public s(Context context, c cVar) {
        super(context, cVar);
        this.f893e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f893e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f893e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i2) {
        this.f893e.setHeaderIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f893e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i2) {
        this.f893e.setHeaderTitle(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f893e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f893e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i2) {
        this.f893e.setIcon(i2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f893e.setIcon(drawable);
        return this;
    }
}
