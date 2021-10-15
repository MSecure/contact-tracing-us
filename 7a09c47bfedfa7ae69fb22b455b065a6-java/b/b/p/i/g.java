package b.b.p.i;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import b.b.p.i.j;
import b.i.l.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements b.i.g.a.a {
    public static final int[] z = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    public final Context f722a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f723b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f724c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f725d;

    /* renamed from: e  reason: collision with root package name */
    public a f726e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f727f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<i> f728g;
    public boolean h;
    public ArrayList<i> i;
    public ArrayList<i> j;
    public boolean k;
    public int l = 0;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public ArrayList<i> u = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> v = new CopyOnWriteArrayList<>();
    public i w;
    public boolean x = false;
    public boolean y;

    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        boolean z2 = false;
        this.f722a = context;
        this.f723b = context.getResources();
        this.f727f = new ArrayList<>();
        this.f728g = new ArrayList<>();
        this.h = true;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = true;
        if (this.f723b.getConfiguration().keyboard != 1 && q.d(ViewConfiguration.get(this.f722a), this.f722a)) {
            z2 = true;
        }
        this.f725d = z2;
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = (-65536 & i4) >> 16;
        if (i6 >= 0) {
            int[] iArr = z;
            if (i6 < iArr.length) {
                int i7 = (iArr[i6] << 16) | (65535 & i4);
                i iVar = new i(this, i2, i3, i4, i7, charSequence, this.l);
                ArrayList<i> arrayList = this.f727f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).f735d <= i7) {
                            i5 = size + 1;
                            break;
                        }
                    } else {
                        i5 = 0;
                        break;
                    }
                }
                arrayList.add(i5, iVar);
                q(true);
                return iVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f723b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f723b.getString(i5));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f722a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            i iVar = (i) a(i2, i3, i4, resolveInfo.loadLabel(packageManager));
            iVar.setIcon(resolveInfo.loadIcon(packageManager));
            iVar.setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = iVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, this.f723b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.f723b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.f722a, this, iVar);
        iVar.o = rVar;
        rVar.setHeaderTitle(iVar.f736e);
        return rVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar, Context context) {
        this.v.add(new WeakReference<>(mVar));
        mVar.e(context, this);
        this.k = true;
    }

    public final void c(boolean z2) {
        if (!this.t) {
            this.t = true;
            Iterator<WeakReference<m>> it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    mVar.b(this, z2);
                }
            }
            this.t = false;
        }
    }

    public void clear() {
        i iVar = this.w;
        if (iVar != null) {
            d(iVar);
        }
        this.f727f.clear();
        q(true);
    }

    public void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        q(false);
    }

    public void close() {
        c(true);
    }

    public boolean d(i iVar) {
        boolean z2 = false;
        if (!this.v.isEmpty() && this.w == iVar) {
            z();
            Iterator<WeakReference<m>> it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    z2 = mVar.f(this, iVar);
                    if (z2) {
                        break;
                    }
                }
            }
            y();
            if (z2) {
                this.w = null;
            }
        }
        return z2;
    }

    public boolean e(g gVar, MenuItem menuItem) {
        a aVar = this.f726e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public boolean f(i iVar) {
        boolean z2 = false;
        if (this.v.isEmpty()) {
            return false;
        }
        z();
        Iterator<WeakReference<m>> it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.v.remove(next);
            } else {
                z2 = mVar.g(this, iVar);
                if (z2) {
                    break;
                }
            }
        }
        y();
        if (z2) {
            this.w = iVar;
        }
        return z2;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f727f.get(i3);
            if (iVar.f732a == i2) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.o.findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public i g(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<i> arrayList = this.u;
        arrayList.clear();
        h(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean n2 = n();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = arrayList.get(i3);
            if (n2) {
                c2 = iVar.j;
            } else {
                c2 = iVar.h;
            }
            if ((c2 == keyData.meta[0] && (metaState & 2) == 0) || ((c2 == keyData.meta[2] && (metaState & 2) != 0) || (n2 && c2 == '\b' && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public MenuItem getItem(int i2) {
        return this.f727f.get(i2);
    }

    public void h(List<i> list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean n2 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f727f.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = this.f727f.get(i4);
                if (iVar.hasSubMenu()) {
                    iVar.o.h(list, i2, keyEvent);
                }
                if (n2) {
                    c2 = iVar.j;
                } else {
                    c2 = iVar.h;
                }
                if (n2) {
                    i3 = iVar.k;
                } else {
                    i3 = iVar.i;
                }
                if (((modifiers & 69647) == (i3 & 69647)) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (n2 && c2 == '\b' && i2 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f727f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<i> l2 = l();
        if (this.k) {
            Iterator<WeakReference<m>> it = this.v.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    z2 |= mVar.d();
                }
            }
            if (z2) {
                this.i.clear();
                this.j.clear();
                int size = l2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = l2.get(i2);
                    (iVar.g() ? this.i : this.j).add(iVar);
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(l());
            }
            this.k = false;
        }
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return g(i2, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public g k() {
        return this;
    }

    public ArrayList<i> l() {
        if (!this.h) {
            return this.f728g;
        }
        this.f728g.clear();
        int size = this.f727f.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f727f.get(i2);
            if (iVar.isVisible()) {
                this.f728g.add(iVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.f728g;
    }

    public boolean m() {
        return this.x;
    }

    public boolean n() {
        return this.f724c;
    }

    public boolean o() {
        return this.f725d;
    }

    public void p() {
        this.k = true;
        q(true);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return r(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        i g2 = g(i2, keyEvent);
        boolean s2 = g2 != null ? s(g2, null, i3) : false;
        if ((i3 & 2) != 0) {
            c(true);
        }
        return s2;
    }

    public void q(boolean z2) {
        if (!this.p) {
            if (z2) {
                this.h = true;
                this.k = true;
            }
            if (!this.v.isEmpty()) {
                z();
                Iterator<WeakReference<m>> it = this.v.iterator();
                while (it.hasNext()) {
                    WeakReference<m> next = it.next();
                    m mVar = next.get();
                    if (mVar == null) {
                        this.v.remove(next);
                    } else {
                        mVar.j(z2);
                    }
                }
                y();
                return;
            }
            return;
        }
        this.q = true;
        if (z2) {
            this.r = true;
        }
    }

    public boolean r(MenuItem menuItem, int i2) {
        return s(menuItem, null, i2);
    }

    public void removeGroup(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f727f.get(i3).f733b == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.f727f.size() - i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size2 || this.f727f.get(i3).f733b != i2) {
                    q(true);
                } else {
                    t(i3, false);
                    i4 = i5;
                }
            }
            q(true);
        }
    }

    public void removeItem(int i2) {
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (this.f727f.get(i3).f732a == i2) {
                break;
            } else {
                i3++;
            }
        }
        t(i3, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r1 != false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        if ((r9 & 1) == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d1, code lost:
        if (r1 == false) goto L_0x00d3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060  */
    public boolean s(MenuItem menuItem, m mVar, int i2) {
        boolean z2;
        i iVar = (i) menuItem;
        boolean z3 = false;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = iVar.p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(iVar)) {
            g gVar = iVar.n;
            if (!gVar.e(gVar, iVar)) {
                Intent intent = iVar.f738g;
                if (intent != null) {
                    try {
                        iVar.n.f722a.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                }
                b.i.l.b bVar = iVar.A;
                if (bVar == null || !((j.a) bVar).f742b.onPerformDefaultAction()) {
                    z2 = false;
                    b.i.l.b bVar2 = iVar.A;
                    boolean z4 = bVar2 == null && ((j.a) bVar2).f742b.hasSubMenu();
                    if (!iVar.f()) {
                        z2 |= iVar.expandActionView();
                    } else if (iVar.hasSubMenu() || z4) {
                        if ((i2 & 4) == 0) {
                            c(false);
                        }
                        if (!iVar.hasSubMenu()) {
                            r rVar = new r(this.f722a, this, iVar);
                            iVar.o = rVar;
                            rVar.setHeaderTitle(iVar.f736e);
                        }
                        r rVar2 = iVar.o;
                        if (z4) {
                            j.a aVar = (j.a) bVar2;
                            aVar.f742b.onPrepareSubMenu(j.this.d(rVar2));
                        }
                        if (!this.v.isEmpty()) {
                            if (mVar != null) {
                                z3 = mVar.i(rVar2);
                            }
                            Iterator<WeakReference<m>> it = this.v.iterator();
                            while (it.hasNext()) {
                                WeakReference<m> next = it.next();
                                m mVar2 = next.get();
                                if (mVar2 == null) {
                                    this.v.remove(next);
                                } else if (!z3) {
                                    z3 = mVar2.i(rVar2);
                                }
                            }
                        }
                        z2 |= z3;
                    }
                    c(true);
                    return z2;
                }
            }
        }
        z2 = true;
        b.i.l.b bVar22 = iVar.A;
        if (bVar22 == null) {
        }
        if (!iVar.f()) {
        }
        c(true);
        return z2;
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.f727f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f727f.get(i3);
            if (iVar.f733b == i2) {
                iVar.x = (iVar.x & -5) | (z3 ? 4 : 0);
                iVar.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.x = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.f727f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f727f.get(i3);
            if (iVar.f733b == i2) {
                iVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.f727f.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f727f.get(i3);
            if (iVar.f733b == i2 && iVar.l(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            q(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f724c = z2;
        q(false);
    }

    public int size() {
        return this.f727f.size();
    }

    public final void t(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.f727f.size()) {
            this.f727f.remove(i2);
            if (z2) {
                q(true);
            }
        }
    }

    public void u(m mVar) {
        Iterator<WeakReference<m>> it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.v.remove(next);
            }
        }
    }

    public void v(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).v(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void w(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).w(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void x(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources resources = this.f723b;
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (i2 > 0) {
                this.m = resources.getText(i2);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i3 > 0) {
                this.n = b.i.e.a.c(this.f722a, i3);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        q(false);
    }

    public void y() {
        this.p = false;
        if (this.q) {
            this.q = false;
            q(this.r);
        }
    }

    public void z() {
        if (!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }
}
