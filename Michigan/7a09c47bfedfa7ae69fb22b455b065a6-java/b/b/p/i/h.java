package b.b.p.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import b.b.k.e;
import b.b.p.i.e;
import b.b.p.i.m;

public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: b  reason: collision with root package name */
    public g f729b;

    /* renamed from: c  reason: collision with root package name */
    public e f730c;

    /* renamed from: d  reason: collision with root package name */
    public e f731d;

    public h(g gVar) {
        this.f729b = gVar;
    }

    @Override // b.b.p.i.m.a
    public void b(g gVar, boolean z) {
        e eVar;
        if ((z || gVar == this.f729b) && (eVar = this.f730c) != null) {
            eVar.dismiss();
        }
    }

    @Override // b.b.p.i.m.a
    public boolean c(g gVar) {
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f729b.r(((e.a) this.f731d.a()).getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e eVar = this.f731d;
        g gVar = this.f729b;
        m.a aVar = eVar.i;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f730c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f730c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f729b.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f729b.performShortcut(i, keyEvent, 0);
    }
}
