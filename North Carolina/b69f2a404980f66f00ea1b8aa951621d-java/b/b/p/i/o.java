package b.b.p.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import b.e.h;
import b.i.g.a.a;
import b.i.g.a.b;
import b.i.g.a.c;

public class o extends c implements Menu {

    /* renamed from: d  reason: collision with root package name */
    public final a f571d;

    public o(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f571d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return c(this.f571d.add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return c(this.f571d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return c(this.f571d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f571d.add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f571d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = c(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return d(this.f571d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return d(this.f571d.addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return d(this.f571d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f571d.addSubMenu(charSequence));
    }

    public void clear() {
        h<b, MenuItem> hVar = this.f515b;
        if (hVar != null) {
            hVar.clear();
        }
        h<c, SubMenu> hVar2 = this.f516c;
        if (hVar2 != null) {
            hVar2.clear();
        }
        this.f571d.clear();
    }

    public void close() {
        this.f571d.close();
    }

    public MenuItem findItem(int i) {
        return c(this.f571d.findItem(i));
    }

    public MenuItem getItem(int i) {
        return c(this.f571d.getItem(i));
    }

    public boolean hasVisibleItems() {
        return this.f571d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f571d.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.f571d.performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f571d.performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        if (this.f515b != null) {
            int i2 = 0;
            while (true) {
                h<b, MenuItem> hVar = this.f515b;
                if (i2 >= hVar.f829d) {
                    break;
                }
                if (hVar.h(i2).getGroupId() == i) {
                    this.f515b.i(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.f571d.removeGroup(i);
    }

    public void removeItem(int i) {
        if (this.f515b != null) {
            int i2 = 0;
            while (true) {
                h<b, MenuItem> hVar = this.f515b;
                if (i2 >= hVar.f829d) {
                    break;
                } else if (hVar.h(i2).getItemId() == i) {
                    this.f515b.i(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.f571d.removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f571d.setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.f571d.setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        this.f571d.setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        this.f571d.setQwertyMode(z);
    }

    public int size() {
        return this.f571d.size();
    }
}
