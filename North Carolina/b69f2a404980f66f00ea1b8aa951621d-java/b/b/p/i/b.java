package b.b.p.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.p.i.m;
import b.b.p.i.n;
import b.b.q.c;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: b  reason: collision with root package name */
    public Context f510b;

    /* renamed from: c  reason: collision with root package name */
    public Context f511c;

    /* renamed from: d  reason: collision with root package name */
    public g f512d;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f513e;
    public m.a f;
    public int g;
    public int h;
    public n i;

    public b(Context context, int i2, int i3) {
        this.f510b = context;
        this.f513e = LayoutInflater.from(context);
        this.g = i2;
        this.h = i3;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar = view instanceof n.a ? (n.a) view : (n.a) this.f513e.inflate(this.h, viewGroup, false);
        c cVar = (c) this;
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) cVar.i);
        if (cVar.x == null) {
            cVar.x = new c.b();
        }
        actionMenuItemView.setPopupCallback(cVar.x);
        return (View) aVar;
    }

    @Override // b.b.p.i.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.p.i.m
    public boolean g(g gVar, i iVar) {
        return false;
    }

    @Override // b.b.p.i.m
    public void h(m.a aVar) {
        this.f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [b.b.p.i.g] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.b.p.i.m
    public boolean i(r rVar) {
        m.a aVar = this.f;
        r rVar2 = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            rVar2 = this.f512d;
        }
        return aVar.c(rVar2);
    }

    @Override // b.b.p.i.m
    public void j(boolean z) {
        int i2;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup != null) {
            g gVar = this.f512d;
            if (gVar != null) {
                gVar.i();
                ArrayList<i> l = this.f512d.l();
                int size = l.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = l.get(i3);
                    if (iVar.g()) {
                        View childAt = viewGroup.getChildAt(i2);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a2 = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.i).addView(a2, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i2) == ((c) this).j) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i2);
                    z2 = true;
                }
                if (!z2) {
                    i2++;
                }
            }
        }
    }
}
