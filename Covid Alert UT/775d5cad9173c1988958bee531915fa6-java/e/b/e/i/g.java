package e.b.e.i;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import e.i.b.a;
import e.i.i.d;
import e.i.i.w;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements e.i.d.a.a {
    public static final int[] y = {1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f788d;

    /* renamed from: e  reason: collision with root package name */
    public a f789e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f790f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<i> f791g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f792h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<i> f793i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<i> f794j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f795k;

    /* renamed from: l  reason: collision with root package name */
    public int f796l = 0;
    public CharSequence m;
    public Drawable n;
    public View o;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public ArrayList<i> t = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> u = new CopyOnWriteArrayList<>();
    public i v;
    public boolean w = false;
    public boolean x;

    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        boolean z;
        boolean z2 = false;
        this.a = context;
        Resources resources = context.getResources();
        this.b = resources;
        this.f790f = new ArrayList<>();
        this.f791g = new ArrayList<>();
        this.f792h = true;
        this.f793i = new ArrayList<>();
        this.f794j = new ArrayList<>();
        this.f795k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = w.a;
            if (Build.VERSION.SDK_INT >= 28) {
                z = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z) {
                z2 = true;
            }
        }
        this.f788d = z2;
    }

    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int i5;
        int i6 = (-65536 & i4) >> 16;
        if (i6 >= 0) {
            int[] iArr = y;
            if (i6 < iArr.length) {
                int i7 = (iArr[i6] << 16) | (65535 & i4);
                i iVar = new i(this, i2, i3, i4, i7, charSequence, this.f796l);
                ArrayList<i> arrayList = this.f790f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).f798d <= i7) {
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
        return a(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.b.getString(i5));
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
        PackageManager packageManager = this.a.getPackageManager();
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
        return addSubMenu(0, 0, 0, this.b.getString(i2));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, this.b.getString(i5));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        r rVar = new r(this.a, this, iVar);
        iVar.o = rVar;
        rVar.setHeaderTitle(iVar.f799e);
        return rVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar, Context context) {
        this.u.add(new WeakReference<>(mVar));
        mVar.e(context, this);
        this.f795k = true;
    }

    public final void c(boolean z) {
        if (!this.s) {
            this.s = true;
            Iterator<WeakReference<m>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.u.remove(next);
                } else {
                    mVar.b(this, z);
                }
            }
            this.s = false;
        }
    }

    public void clear() {
        i iVar = this.v;
        if (iVar != null) {
            d(iVar);
        }
        this.f790f.clear();
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
        boolean z = false;
        if (!this.u.isEmpty() && this.v == iVar) {
            z();
            Iterator<WeakReference<m>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.u.remove(next);
                } else {
                    z = mVar.f(this, iVar);
                    if (z) {
                        break;
                    }
                }
            }
            y();
            if (z) {
                this.v = null;
            }
        }
        return z;
    }

    public boolean e(g gVar, MenuItem menuItem) {
        a aVar = this.f789e;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public boolean f(i iVar) {
        boolean z = false;
        if (this.u.isEmpty()) {
            return false;
        }
        z();
        Iterator<WeakReference<m>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.u.remove(next);
            } else {
                z = mVar.g(this, iVar);
                if (z) {
                    break;
                }
            }
        }
        y();
        if (z) {
            this.v = iVar;
        }
        return z;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f790f.get(i3);
            if (iVar.a == i2) {
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
        ArrayList<i> arrayList = this.t;
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
                c2 = iVar.f804j;
            } else {
                c2 = iVar.f802h;
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (n2 && c2 == '\b' && i2 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public MenuItem getItem(int i2) {
        return this.f790f.get(i2);
    }

    public void h(List<i> list, int i2, KeyEvent keyEvent) {
        char c2;
        int i3;
        boolean n2 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.f790f.size();
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = this.f790f.get(i4);
                if (iVar.hasSubMenu()) {
                    iVar.o.h(list, i2, keyEvent);
                }
                if (n2) {
                    c2 = iVar.f804j;
                } else {
                    c2 = iVar.f802h;
                }
                if (n2) {
                    i3 = iVar.f805k;
                } else {
                    i3 = iVar.f803i;
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
        if (this.x) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f790f.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<i> l2 = l();
        if (this.f795k) {
            Iterator<WeakReference<m>> it = this.u.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.u.remove(next);
                } else {
                    z |= mVar.d();
                }
            }
            if (z) {
                this.f793i.clear();
                this.f794j.clear();
                int size = l2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i iVar = l2.get(i2);
                    (iVar.g() ? this.f793i : this.f794j).add(iVar);
                }
            } else {
                this.f793i.clear();
                this.f794j.clear();
                this.f794j.addAll(l());
            }
            this.f795k = false;
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
        if (!this.f792h) {
            return this.f791g;
        }
        this.f791g.clear();
        int size = this.f790f.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.f790f.get(i2);
            if (iVar.isVisible()) {
                this.f791g.add(iVar);
            }
        }
        this.f792h = false;
        this.f795k = true;
        return this.f791g;
    }

    public boolean m() {
        return this.w;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        return this.f788d;
    }

    public void p() {
        this.f795k = true;
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

    public void q(boolean z) {
        if (!this.p) {
            if (z) {
                this.f792h = true;
                this.f795k = true;
            }
            if (!this.u.isEmpty()) {
                z();
                Iterator<WeakReference<m>> it = this.u.iterator();
                while (it.hasNext()) {
                    WeakReference<m> next = it.next();
                    m mVar = next.get();
                    if (mVar == null) {
                        this.u.remove(next);
                    } else {
                        mVar.j(z);
                    }
                }
                y();
                return;
            }
            return;
        }
        this.q = true;
        if (z) {
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
            } else if (this.f790f.get(i3).b == i2) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = this.f790f.size() - i3;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size2 || this.f790f.get(i3).b != i2) {
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
            } else if (this.f790f.get(i3).a == i2) {
                break;
            } else {
                i3++;
            }
        }
        t(i3, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r1 != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        if ((r9 & 1) == 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bf, code lost:
        if (r1 == false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0058  */
    public boolean s(MenuItem menuItem, m mVar, int i2) {
        boolean z;
        i iVar = (i) menuItem;
        boolean z2 = false;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = iVar.p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(iVar)) {
            g gVar = iVar.n;
            if (!gVar.e(gVar, iVar)) {
                Intent intent = iVar.f801g;
                if (intent != null) {
                    try {
                        iVar.n.a.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                }
                d dVar = iVar.A;
                if (dVar == null || !dVar.e()) {
                    z = false;
                    d dVar2 = iVar.A;
                    boolean z3 = dVar2 == null && dVar2.a();
                    if (!iVar.f()) {
                        z |= iVar.expandActionView();
                    } else if (iVar.hasSubMenu() || z3) {
                        if ((i2 & 4) == 0) {
                            c(false);
                        }
                        if (!iVar.hasSubMenu()) {
                            r rVar = new r(this.a, this, iVar);
                            iVar.o = rVar;
                            rVar.setHeaderTitle(iVar.f799e);
                        }
                        r rVar2 = iVar.o;
                        if (z3) {
                            dVar2.f(rVar2);
                        }
                        if (!this.u.isEmpty()) {
                            if (mVar != null) {
                                z2 = mVar.i(rVar2);
                            }
                            Iterator<WeakReference<m>> it = this.u.iterator();
                            while (it.hasNext()) {
                                WeakReference<m> next = it.next();
                                m mVar2 = next.get();
                                if (mVar2 == null) {
                                    this.u.remove(next);
                                } else if (!z2) {
                                    z2 = mVar2.i(rVar2);
                                }
                            }
                        }
                        z |= z2;
                    }
                    c(true);
                    return z;
                }
            }
        }
        z = true;
        d dVar22 = iVar.A;
        if (dVar22 == null) {
        }
        if (!iVar.f()) {
        }
        c(true);
        return z;
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        int size = this.f790f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f790f.get(i3);
            if (iVar.b == i2) {
                iVar.x = (iVar.x & -5) | (z2 ? 4 : 0);
                iVar.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.w = z;
    }

    public void setGroupEnabled(int i2, boolean z) {
        int size = this.f790f.size();
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f790f.get(i3);
            if (iVar.b == i2) {
                iVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z) {
        int size = this.f790f.size();
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            i iVar = this.f790f.get(i3);
            if (iVar.b == i2 && iVar.l(z)) {
                z2 = true;
            }
        }
        if (z2) {
            q(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.c = z;
        q(false);
    }

    public int size() {
        return this.f790f.size();
    }

    public final void t(int i2, boolean z) {
        if (i2 >= 0 && i2 < this.f790f.size()) {
            this.f790f.remove(i2);
            if (z) {
                q(true);
            }
        }
    }

    public void u(m mVar) {
        Iterator<WeakReference<m>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.u.remove(next);
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
        Resources resources = this.b;
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
                Context context = this.a;
                Object obj = e.i.b.a.a;
                this.n = a.b.b(context, i3);
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
