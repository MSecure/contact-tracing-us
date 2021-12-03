package e.b.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import e.b.e.i.f;
import e.b.e.i.g;
import e.b.e.i.i;
import java.lang.reflect.Method;

public class m0 extends k0 implements l0 {
    public static Method F;
    public l0 E;

    public static class a extends f0 {
        public final int o;
        public final int p;
        public l0 q;
        public MenuItem r;

        public a(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.o = 21;
                this.p = 22;
                return;
            }
            this.o = 22;
            this.p = 21;
        }

        @Override // e.b.f.f0
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            int pointToPosition;
            int i3;
            if (this.q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i2 = 0;
                }
                f fVar = (f) adapter;
                i iVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i3 = pointToPosition - i2) >= 0 && i3 < fVar.getCount()) {
                    iVar = fVar.getItem(i3);
                }
                MenuItem menuItem = this.r;
                if (menuItem != iVar) {
                    g gVar = fVar.b;
                    if (menuItem != null) {
                        this.q.h(gVar, menuItem);
                    }
                    this.r = iVar;
                    if (iVar != null) {
                        this.q.f(gVar, iVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.p) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ((f) getAdapter()).b.c(false);
                return true;
            }
        }

        public void setHoverListener(l0 l0Var) {
            this.q = l0Var;
        }

        @Override // e.b.f.f0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                F = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public m0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, null, i2, i3);
    }

    @Override // e.b.f.l0
    public void f(g gVar, MenuItem menuItem) {
        l0 l0Var = this.E;
        if (l0Var != null) {
            l0Var.f(gVar, menuItem);
        }
    }

    @Override // e.b.f.l0
    public void h(g gVar, MenuItem menuItem) {
        l0 l0Var = this.E;
        if (l0Var != null) {
            l0Var.h(gVar, menuItem);
        }
    }

    @Override // e.b.f.k0
    public f0 q(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
