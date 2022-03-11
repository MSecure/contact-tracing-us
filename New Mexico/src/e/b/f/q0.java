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
/* loaded from: classes.dex */
public class q0 extends o0 implements p0 {
    public static Method F;
    public p0 E;

    /* loaded from: classes.dex */
    public static class a extends j0 {
        public final int o;
        public final int p;
        public p0 q;
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

        @Override // e.b.f.j0, android.view.View
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

        @Override // android.widget.ListView, android.view.KeyEvent.Callback, android.widget.AbsListView, android.view.View
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
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((f) adapter).b.c(false);
                return true;
            }
        }

        public void setHoverListener(p0 p0Var) {
            this.q = p0Var;
        }

        @Override // e.b.f.j0, android.widget.AbsListView
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

    public q0(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, null, i2, i3);
    }

    @Override // e.b.f.p0
    public void f(g gVar, MenuItem menuItem) {
        p0 p0Var = this.E;
        if (p0Var != null) {
            p0Var.f(gVar, menuItem);
        }
    }

    @Override // e.b.f.p0
    public void h(g gVar, MenuItem menuItem) {
        p0 p0Var = this.E;
        if (p0Var != null) {
            p0Var.h(gVar, menuItem);
        }
    }

    @Override // e.b.f.o0
    public j0 q(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
