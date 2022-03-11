package e.m.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import e.a.c;
import e.a.e.d;
import e.b.a.m;
import e.i.a.b;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class r extends ComponentActivity implements b.a, b.AbstractC0034b {

    /* renamed from: k  reason: collision with root package name */
    public final a0 f1678k;

    /* renamed from: l  reason: collision with root package name */
    public final k f1679l = new k(this);
    public boolean m;
    public boolean n;
    public boolean o = true;

    public class a extends c0<r> implements d0, c, d, k0 {
        public a() {
            super(r.this);
        }

        @Override // e.p.j
        public g a() {
            return r.this.f1679l;
        }

        @Override // e.m.a.k0
        public void b(f0 f0Var, l lVar) {
            r.this.q();
        }

        @Override // e.a.c
        public OnBackPressedDispatcher c() {
            return r.this.f5h;
        }

        @Override // e.m.a.y
        public View e(int i2) {
            return r.this.findViewById(i2);
        }

        @Override // e.a.e.d
        public ActivityResultRegistry f() {
            return r.this.f7j;
        }

        @Override // e.m.a.y
        public boolean g() {
            Window window = r.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.m.a.c0
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            r.this.dump(str, null, printWriter, strArr);
        }

        @Override // e.p.d0
        public c0 i() {
            return r.this.i();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.m.a.c0
        public r j() {
            return r.this;
        }

        @Override // e.m.a.c0
        public LayoutInflater k() {
            return r.this.getLayoutInflater().cloneInContext(r.this);
        }

        @Override // e.m.a.c0
        public boolean l(l lVar) {
            return !r.this.isFinishing();
        }

        @Override // e.m.a.c0
        public void m() {
            r.this.r();
        }
    }

    public r() {
        a aVar = new a();
        m.h.o(aVar, "callbacks == null");
        this.f1678k = new a0(aVar);
        this.f2e.b.b("android:support:fragments", new p(this));
        q qVar = new q(this);
        e.a.d.a aVar2 = this.c;
        if (aVar2.b != null) {
            qVar.a(aVar2.b);
        }
        aVar2.a.add(qVar);
    }

    public static boolean p(f0 f0Var, g.b bVar) {
        g.b bVar2 = g.b.STARTED;
        boolean z = false;
        for (l lVar : f0Var.N()) {
            if (lVar != null) {
                if (lVar.q() != null) {
                    z |= p(lVar.j(), bVar);
                }
                a1 a1Var = lVar.Q;
                if (a1Var != null) {
                    if (((k) a1Var.a()).b.compareTo(bVar2) >= 0) {
                        k kVar = lVar.Q.b;
                        kVar.d("setCurrentState");
                        kVar.g(bVar);
                        z = true;
                    }
                }
                if (lVar.P.b.compareTo(bVar2) >= 0) {
                    k kVar2 = lVar.P;
                    kVar2.d("setCurrentState");
                    kVar2.g(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // e.i.a.b.AbstractC0034b
    @Deprecated
    public final void b(int i2) {
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.m);
        printWriter.print(" mResumed=");
        printWriter.print(this.n);
        printWriter.print(" mStopped=");
        printWriter.print(this.o);
        if (getApplication() != null) {
            e.q.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1678k.a.f1585e.z(str, fileDescriptor, printWriter, strArr);
    }

    public f0 o() {
        return this.f1678k.a.f1585e;
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f1678k.a();
        super.onActivityResult(i2, i3, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1678k.a();
        this.f1678k.a.f1585e.l(configuration);
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1679l.e(g.a.ON_CREATE);
        this.f1678k.a.f1585e.n();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        a0 a0Var = this.f1678k;
        return onCreatePanelMenu | a0Var.a.f1585e.o(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1678k.a.f1585e.f1606f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1678k.a.f1585e.p();
        this.f1679l.e(g.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f1678k.a.f1585e.q();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1678k.a.f1585e.s(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f1678k.a.f1585e.m(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f1678k.a.f1585e.r(z);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1678k.a();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f1678k.a.f1585e.t(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    public void onPause() {
        super.onPause();
        this.n = false;
        this.f1678k.a.f1585e.x(5);
        this.f1679l.e(g.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f1678k.a.f1585e.v(z);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f1679l.e(g.a.ON_RESUME);
        f0 f0Var = this.f1678k.a.f1585e;
        f0Var.B = false;
        f0Var.C = false;
        f0Var.J.f1628h = false;
        f0Var.x(7);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return super.onPreparePanel(0, view, menu) | this.f1678k.a.f1585e.w(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.b.a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f1678k.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.n = true;
        this.f1678k.a();
        this.f1678k.a.f1585e.D(true);
    }

    public void onStart() {
        super.onStart();
        this.o = false;
        if (!this.m) {
            this.m = true;
            f0 f0Var = this.f1678k.a.f1585e;
            f0Var.B = false;
            f0Var.C = false;
            f0Var.J.f1628h = false;
            f0Var.x(4);
        }
        this.f1678k.a();
        this.f1678k.a.f1585e.D(true);
        this.f1679l.e(g.a.ON_START);
        f0 f0Var2 = this.f1678k.a.f1585e;
        f0Var2.B = false;
        f0Var2.C = false;
        f0Var2.J.f1628h = false;
        f0Var2.x(5);
    }

    public void onStateNotSaved() {
        this.f1678k.a();
    }

    public void onStop() {
        super.onStop();
        this.o = true;
        do {
        } while (p(o(), g.b.CREATED));
        f0 f0Var = this.f1678k.a.f1585e;
        f0Var.C = true;
        f0Var.J.f1628h = true;
        f0Var.x(4);
        this.f1679l.e(g.a.ON_STOP);
    }

    @Deprecated
    public void q() {
    }

    @Deprecated
    public void r() {
        invalidateOptionsMenu();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1678k.a.f1585e.f1606f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
