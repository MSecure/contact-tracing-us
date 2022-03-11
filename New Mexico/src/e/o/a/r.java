package e.o.a;

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
import e.a.e.d;
import e.b.a.m;
import e.j.a.c;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class r extends ComponentActivity implements c.a, c.b {

    /* renamed from: k */
    public final z f1851k;
    public boolean m;
    public boolean n;

    /* renamed from: l */
    public final m f1852l = new m(this);
    public boolean o = true;

    /* loaded from: classes.dex */
    public class a extends b0<r> implements h0, e.a.c, d, i0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(r1);
            r.this = r1;
        }

        @Override // e.r.l
        public h a() {
            return r.this.f1852l;
        }

        @Override // e.o.a.i0
        public void b(e0 e0Var, m mVar) {
            r.this.s();
        }

        @Override // e.a.c
        public OnBackPressedDispatcher c() {
            return r.this.f5h;
        }

        @Override // e.o.a.x
        public View e(int i2) {
            return r.this.findViewById(i2);
        }

        @Override // e.a.e.d
        public ActivityResultRegistry f() {
            return r.this.f7j;
        }

        @Override // e.o.a.x
        public boolean g() {
            Window window = r.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.o.a.b0
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            r.this.dump(str, null, printWriter, strArr);
        }

        @Override // e.r.h0
        public g0 i() {
            return r.this.i();
        }

        @Override // e.o.a.b0
        public r j() {
            return r.this;
        }

        @Override // e.o.a.b0
        public LayoutInflater k() {
            return r.this.getLayoutInflater().cloneInContext(r.this);
        }

        @Override // e.o.a.b0
        public boolean l(m mVar) {
            return !r.this.isFinishing();
        }

        @Override // e.o.a.b0
        public void m() {
            r.this.t();
        }
    }

    public r() {
        a aVar = new a();
        m.e.q(aVar, "callbacks == null");
        this.f1851k = new z(aVar);
        this.f2e.b.b("android:support:fragments", new p(this));
        n(new q(this));
    }

    public static boolean r(e0 e0Var, h.b bVar) {
        h.b bVar2 = h.b.STARTED;
        boolean z = false;
        for (m mVar : e0Var.c.i()) {
            if (mVar != null) {
                if (mVar.s() != null) {
                    z |= r(mVar.j(), bVar);
                }
                y0 y0Var = mVar.P;
                if (y0Var != null) {
                    y0Var.e();
                    if (y0Var.f1887e.b.compareTo(bVar2) >= 0) {
                        e.r.m mVar2 = mVar.P.f1887e;
                        mVar2.d("setCurrentState");
                        mVar2.g(bVar);
                        z = true;
                    }
                }
                if (mVar.O.b.compareTo(bVar2) >= 0) {
                    e.r.m mVar3 = mVar.O;
                    mVar3.d("setCurrentState");
                    mVar3.g(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // e.j.a.c.b
    @Deprecated
    public final void b(int i2) {
    }

    @Override // android.app.Activity
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
            e.s.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1851k.a.f1765e.y(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f1851k.a();
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f1851k.a();
        super.onConfigurationChanged(configuration);
        this.f1851k.a.f1765e.k(configuration);
    }

    @Override // androidx.activity.ComponentActivity, e.j.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1852l.e(h.a.ON_CREATE);
        this.f1851k.a.f1765e.m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        z zVar = this.f1851k;
        return onCreatePanelMenu | zVar.a.f1765e.n(menu, getMenuInflater());
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1851k.a.f1765e.f1775f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1851k.a.f1765e.o();
        this.f1852l.e(h.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f1851k.a.f1765e.p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1851k.a.f1765e.r(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f1851k.a.f1765e.l(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f1851k.a.f1765e.q(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f1851k.a();
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f1851k.a.f1765e.s(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.n = false;
        this.f1851k.a.f1765e.w(5);
        this.f1852l.e(h.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f1851k.a.f1765e.u(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f1852l.e(h.a.ON_RESUME);
        e0 e0Var = this.f1851k.a.f1765e;
        e0Var.B = false;
        e0Var.C = false;
        e0Var.J.f1796h = false;
        e0Var.w(7);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return super.onPreparePanel(0, view, menu) | this.f1851k.a.f1765e.v(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f1851k.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f1851k.a();
        super.onResume();
        this.n = true;
        this.f1851k.a.f1765e.C(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.f1851k.a();
        super.onStart();
        this.o = false;
        if (!this.m) {
            this.m = true;
            e0 e0Var = this.f1851k.a.f1765e;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1796h = false;
            e0Var.w(4);
        }
        this.f1851k.a.f1765e.C(true);
        this.f1852l.e(h.a.ON_START);
        e0 e0Var2 = this.f1851k.a.f1765e;
        e0Var2.B = false;
        e0Var2.C = false;
        e0Var2.J.f1796h = false;
        e0Var2.w(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f1851k.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.o = true;
        do {
        } while (r(q(), h.b.CREATED));
        e0 e0Var = this.f1851k.a.f1765e;
        e0Var.C = true;
        e0Var.J.f1796h = true;
        e0Var.w(4);
        this.f1852l.e(h.a.ON_STOP);
    }

    public e0 q() {
        return this.f1851k.a.f1765e;
    }

    @Deprecated
    public void s() {
    }

    @Deprecated
    public void t() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1851k.a.f1765e.f1775f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
