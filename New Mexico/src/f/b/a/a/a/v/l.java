package f.b.a.a.a.v;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.c;
import e.a.e.f.d;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.x.a1;
import f.b.a.c.b.l.b;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class l extends a1 {
    public static final a X = a.e("MainEdgeCaseFragment");

    public static l O0(l lVar, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handleApiErrorLiveEvents", z);
        bundle.putBoolean("handleResolutions", z2);
        lVar.A0(bundle);
        return lVar;
    }

    public void J0(Button button) {
        int i2 = 0;
        if (!(m.e.O(k()) != null)) {
            i2 = 8;
        }
        button.setVisibility(i2);
        button.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.v.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.e.U0(l.this.k());
            }
        });
    }

    public void K0(Button button) {
        button.setVisibility(0);
        button.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.v.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l lVar = l.this;
                Objects.requireNonNull(lVar);
                lVar.F0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
            }
        });
    }

    public void L0(Button button, boolean z) {
        button.setVisibility(0);
        button.setEnabled(!z);
        button.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.v.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.this.W.f();
            }
        });
    }

    public abstract void M0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z);

    public void N0(n.c cVar) {
        this.W.s.a(cVar);
    }

    public void P0(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        boolean z;
        super.m0(view, bundle);
        this.W.f348k.n(H(), new i0.a() { // from class: f.b.a.a.a.v.g
            @Override // f.b.a.a.a.t.i0.a
            public final void a(Object obj, Object obj2) {
                l lVar = l.this;
                ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                a aVar = l.X;
                View view2 = lVar.F;
                if (view2 != null && bVar != null) {
                    lVar.M0(view2, (View) view2.getParent(), bVar, booleanValue);
                }
            }
        });
        Bundle bundle2 = this.f1812g;
        boolean z2 = true;
        if (bundle2 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
            z = true;
        } else {
            z = bundle2.getBoolean("handleApiErrorLiveEvents", true);
        }
        if (z) {
            this.W.f349l.f(H(), new t() { // from class: f.b.a.a.a.v.f
                @Override // e.r.t
                public final void a(Object obj) {
                    l lVar = l.this;
                    Void r3 = (Void) obj;
                    m.e.Z0(lVar.F, lVar.F(R.string.generic_error_message));
                }
            });
            this.W.m.f(H(), new t(view) { // from class: f.b.a.a.a.v.e
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: INVOKE  
                      (r5v3 'K' com.google.android.material.snackbar.Snackbar)
                      (wrap: int : ?: SGET   gov.nm.covid19.exposurenotifications.R.string.learn_more int)
                      (wrap: f.b.a.a.a.v.c : 0x0016: CONSTRUCTOR  (r3v0 f.b.a.a.a.v.c A[REMOVE]) = (r0v0 'lVar' f.b.a.a.a.v.l), (r1v0 'view2' android.view.View) call: f.b.a.a.a.v.c.<init>(f.b.a.a.a.v.l, android.view.View):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.google.android.material.snackbar.Snackbar.k(int, android.view.View$OnClickListener):com.google.android.material.snackbar.Snackbar in method: f.b.a.a.a.v.e.a(java.lang.Object):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.v.c, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 18 more
                    */
                @Override // e.r.t
                public final void a(java.lang.Object r5) {
                    /*
                        r4 = this;
                        f.b.a.a.a.v.l r0 = f.b.a.a.a.v.l.this
                        android.view.View r1 = r4.b
                        java.lang.Void r5 = (java.lang.Void) r5
                        android.view.View r5 = r0.F
                        if (r5 == 0) goto L_0x001f
                        r2 = 2131820937(0x7f110189, float:1.9274603E38)
                        com.google.android.material.snackbar.Snackbar r5 = e.b.a.m.e.K(r5, r2)
                        r2 = 2131820957(0x7f11019d, float:1.9274644E38)
                        f.b.a.a.a.v.c r3 = new f.b.a.a.a.v.c
                        r3.<init>(r0, r1)
                        r5.k(r2, r3)
                        r5.l()
                    L_0x001f:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.v.e.a(java.lang.Object):void");
                }
            });
        }
        Bundle bundle3 = this.f1812g;
        if (bundle3 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
        } else {
            z2 = bundle3.getBoolean("handleResolutions", true);
        }
        if (z2) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.W;
            Objects.requireNonNull(exposureNotificationViewModel);
            exposureNotificationViewModel.o.f(this, new t(t0(new d(), new f.b.a.a.a.x.a(exposureNotificationViewModel))) { // from class: f.b.a.a.a.x.m
                public final /* synthetic */ c b;

                {
                    this.b = r2;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    ExposureNotificationViewModel.this.g((b) obj, this.b);
                }
            });
        }
    }
}
