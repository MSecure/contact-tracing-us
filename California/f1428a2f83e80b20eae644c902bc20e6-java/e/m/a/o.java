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
import e.a.c;
import e.a.e.d;
import e.a.e.e;
import e.b.a.m;
import e.p.c0;
import e.p.d0;
import e.p.g;
import e.p.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class o extends ComponentActivity {

    /* renamed from: j  reason: collision with root package name */
    public final x f1651j;

    /* renamed from: k  reason: collision with root package name */
    public final k f1652k = new k(this);

    /* renamed from: l  reason: collision with root package name */
    public boolean f1653l;
    public boolean m;
    public boolean n = true;

    public class a extends z<o> implements d0, c, e, h0 {
        public a() {
            super(o.this);
        }

        @Override // e.p.j
        public g a() {
            return o.this.f1652k;
        }

        @Override // e.a.c
        public OnBackPressedDispatcher b() {
            return o.this.f5h;
        }

        @Override // e.m.a.h0
        public void d(c0 c0Var, l lVar) {
            o.this.p();
        }

        @Override // e.a.e.e
        public d e() {
            return o.this.f6i;
        }

        @Override // e.m.a.v
        public View f(int i2) {
            return o.this.findViewById(i2);
        }

        @Override // e.m.a.v
        public boolean g() {
            Window window = o.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // e.p.d0
        public c0 h() {
            return o.this.h();
        }

        @Override // e.m.a.z
        public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            o.this.dump(str, null, printWriter, strArr);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // e.m.a.z
        public o j() {
            return o.this;
        }

        @Override // e.m.a.z
        public LayoutInflater k() {
            return o.this.getLayoutInflater().cloneInContext(o.this);
        }

        @Override // e.m.a.z
        public boolean l(l lVar) {
            return !o.this.isFinishing();
        }

        @Override // e.m.a.z
        public void m() {
            o.this.q();
        }
    }

    public o() {
        a aVar = new a();
        m.h.o(aVar, "callbacks == null");
        this.f1651j = new x(aVar);
        this.f2e.b.b("android:support:fragments", new m(this));
        n nVar = new n(this);
        e.a.d.a aVar2 = this.c;
        if (aVar2.b != null) {
            nVar.a(aVar2.b);
        }
        aVar2.a.add(nVar);
    }

    public static boolean o(c0 c0Var, g.b bVar) {
        g.b bVar2 = g.b.STARTED;
        boolean z = false;
        for (l lVar : c0Var.N()) {
            if (lVar != null) {
                if (lVar.q() != null) {
                    z |= o(lVar.j(), bVar);
                }
                x0 x0Var = lVar.Q;
                if (x0Var != null) {
                    if (((k) x0Var.a()).b.compareTo(bVar2) >= 0) {
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

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f1653l);
        printWriter.print(" mResumed=");
        printWriter.print(this.m);
        printWriter.print(" mStopped=");
        printWriter.print(this.n);
        if (getApplication() != null) {
            e.q.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f1651j.a.f1694e.z(str, fileDescriptor, printWriter, strArr);
    }

    public c0 n() {
        return this.f1651j.a.f1694e;
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f1651j.a();
        super.onActivityResult(i2, i3, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1651j.a();
        this.f1651j.a.f1694e.l(configuration);
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.f
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1652k.e(g.a.ON_CREATE);
        this.f1651j.a.f1694e.n();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        x xVar = this.f1651j;
        return onCreatePanelMenu | xVar.a.f1694e.o(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1651j.a.f1694e.f1573f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f1651j.a.f1694e.p();
        this.f1652k.e(g.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f1651j.a.f1694e.q();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.f1651j.a.f1694e.s(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.f1651j.a.f1694e.m(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.f1651j.a.f1694e.r(z);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f1651j.a();
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.f1651j.a.f1694e.t(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    public void onPause() {
        super.onPause();
        this.m = false;
        this.f1651j.a.f1694e.x(5);
        this.f1652k.e(g.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.f1651j.a.f1694e.v(z);
    }

    public void onPostResume() {
        super.onPostResume();
        this.f1652k.e(g.a.ON_RESUME);
        c0 c0Var = this.f1651j.a.f1694e;
        c0Var.B = false;
        c0Var.C = false;
        c0Var.J.f1600h = false;
        c0Var.x(7);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return super.onPreparePanel(0, view, menu) | this.f1651j.a.f1694e.w(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    @Override // androidx.activity.ComponentActivity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.f1651j.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.m = true;
        this.f1651j.a();
        this.f1651j.a.f1694e.D(true);
    }

    public void onStart() {
        super.onStart();
        this.n = false;
        if (!this.f1653l) {
            this.f1653l = true;
            c0 c0Var = this.f1651j.a.f1694e;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.f1600h = false;
            c0Var.x(4);
        }
        this.f1651j.a();
        this.f1651j.a.f1694e.D(true);
        this.f1652k.e(g.a.ON_START);
        c0 c0Var2 = this.f1651j.a.f1694e;
        c0Var2.B = false;
        c0Var2.C = false;
        c0Var2.J.f1600h = false;
        c0Var2.x(5);
    }

    public void onStateNotSaved() {
        this.f1651j.a();
    }

    public void onStop() {
        super.onStop();
        this.n = true;
        do {
        } while (o(n(), g.b.CREATED));
        c0 c0Var = this.f1651j.a.f1694e;
        c0Var.C = true;
        c0Var.J.f1600h = true;
        c0Var.x(4);
        this.f1652k.e(g.a.ON_STOP);
    }

    @Deprecated
    public void p() {
    }

    @Deprecated
    public void q() {
        invalidateOptionsMenu();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.f1651j.a.f1694e.f1573f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
