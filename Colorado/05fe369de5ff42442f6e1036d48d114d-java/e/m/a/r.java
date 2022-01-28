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
import e.p.g0;
import e.p.h;
import e.p.h0;
import e.p.m;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class r extends ComponentActivity implements b.a, b.AbstractC0029b {

    /* renamed from: k  reason: collision with root package name */
    public final z f1493k;

    /* renamed from: l  reason: collision with root package name */
    public final m f1494l = new m(this);
    public boolean m;
    public boolean n;
    public boolean o = true;

    public class a extends b0<r> implements h0, c, d, i0 {
        public a() {
            super(r.this);
        }

        @Override // e.p.l
        public h a() {
            return r.this.f1494l;
        }

        @Override // e.m.a.i0
        public void b(e0 e0Var, m mVar) {
            r.this.r();
        }

        @Override // e.a.c
        public OnBackPressedDispatcher c() {
            return r.this.f5h;
        }

        @Override // e.m.a.x
        public View e(int i2) {
            return r.this.findViewById(i2);
        }

        @Override // e.a.e.d
        public ActivityResultRegistry f() {
            return r.this.f7j;
        }

        @Override // e.m.a.x
        public boolean g() {
            Window window = r.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.m.a.b0
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            r.this.dump(str, null, printWriter, strArr);
        }

        @Override // e.p.h0
        public g0 i() {
            return r.this.i();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.m.a.b0
        public r j() {
            return r.this;
        }

        @Override // e.m.a.b0
        public LayoutInflater k() {
            return r.this.getLayoutInflater().cloneInContext(r.this);
        }

        @Override // e.m.a.b0
        public boolean l(m mVar) {
            return !r.this.isFinishing();
        }

        @Override // e.m.a.b0
        public void m() {
            r.this.s();
        }
    }

    public r() {
        a aVar = new a();
        m.h.o(aVar, "callbacks == null");
        this.f1493k = new z(aVar);
        this.f2e.b.b("android:support:fragments", new p(this));
        q qVar = new q(this);
        e.a.d.a aVar2 = this.c;
        if (aVar2.b != null) {
            qVar.a(aVar2.b);
        }
        aVar2.a.add(qVar);
    }

    public static boolean q(e0 e0Var, h.b bVar) {
        h.b bVar2 = h.b.STARTED;
        boolean z = false;
        for (m mVar : e0Var.c.i()) {
            if (mVar != null) {
                if (mVar.p() != null) {
                    z |= q(mVar.h(), bVar);
                }
                y0 y0Var = mVar.P;
                if (y0Var != null) {
                    if (((e.p.m) y0Var.a()).b.compareTo(bVar2) >= 0) {
                        e.p.m mVar2 = mVar.P.b;
                        mVar2.d("setCurrentState");
                        mVar2.g(bVar);
                        z = true;
                    }
                }
                if (mVar.O.b.compareTo(bVar2) >= 0) {
                    e.p.m mVar3 = mVar.O;
                    mVar3.d("setCurrentState");
                    mVar3.g(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // e.i.a.b.AbstractC0029b
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
        this.f1493k.a.f1408e.y(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f1493k.a();
        super.onActivityResult(i2, i3, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1493k.a();
        this.f1493k.a.f1408e.k(configuration);
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1494l.e(h.a.ON_CREATE);
        this.f1493k.a.f1408e.m();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        z zVar = this.f1493k;
        return onCreatePanelMenu | zVar.a.f1408e.n(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1493k.a.f1408e.f1417f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1493k.a.f1408e.o();
        this.f1494l.e(h.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f1493k.a.f1408e.p();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1493k.a.f1408e.r(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f1493k.a.f1408e.l(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f1493k.a.f1408e.q(z);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1493k.a();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f1493k.a.f1408e.s(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    public void onPause() {
        super.onPause();
        this.n = false;
        this.f1493k.a.f1408e.w(5);
        this.f1494l.e(h.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f1493k.a.f1408e.u(z);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f1494l.e(h.a.ON_RESUME);
        e0 e0Var = this.f1493k.a.f1408e;
        e0Var.B = false;
        e0Var.C = false;
        e0Var.J.f1438h = false;
        e0Var.w(7);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return super.onPreparePanel(0, view, menu) | this.f1493k.a.f1408e.v(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.b.a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f1493k.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.n = true;
        this.f1493k.a();
        this.f1493k.a.f1408e.C(true);
    }

    public void onStart() {
        super.onStart();
        this.o = false;
        if (!this.m) {
            this.m = true;
            e0 e0Var = this.f1493k.a.f1408e;
            e0Var.B = false;
            e0Var.C = false;
            e0Var.J.f1438h = false;
            e0Var.w(4);
        }
        this.f1493k.a();
        this.f1493k.a.f1408e.C(true);
        this.f1494l.e(h.a.ON_START);
        e0 e0Var2 = this.f1493k.a.f1408e;
        e0Var2.B = false;
        e0Var2.C = false;
        e0Var2.J.f1438h = false;
        e0Var2.w(5);
    }

    public void onStateNotSaved() {
        this.f1493k.a();
    }

    public void onStop() {
        super.onStop();
        this.o = true;
        do {
        } while (q(p(), h.b.CREATED));
        e0 e0Var = this.f1493k.a.f1408e;
        e0Var.C = true;
        e0Var.J.f1438h = true;
        e0Var.w(4);
        this.f1494l.e(h.a.ON_STOP);
    }

    public e0 p() {
        return this.f1493k.a.f1408e;
    }

    @Deprecated
    public void r() {
    }

    @Deprecated
    public void s() {
        invalidateOptionsMenu();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1493k.a.f1408e.f1417f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
