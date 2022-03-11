package f.b.a.a.a.l0;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.o.a.e0;
import e.r.t;
import f.b.a.a.a.u.o;
import f.b.a.a.a.v.j;
import f.b.a.a.a.v.l;
import f.b.a.e.m.b;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class o0 extends s0 {
    public o b0;
    public ExposureNotificationViewModel.b c0;
    public boolean d0 = false;
    public boolean e0 = false;
    public final CompoundButton.OnCheckedChangeListener f0 = new a();

    /* loaded from: classes.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
            o0.this = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            compoundButton.setOnCheckedChangeListener(null);
            compoundButton.setChecked(!z);
            compoundButton.setOnCheckedChangeListener(o0.this.f0);
            o0 o0Var = o0.this;
            if (!z) {
                o0Var.M0();
            } else if (o0Var.c0 == ExposureNotificationViewModel.b.STORAGE_LOW) {
                o0Var.L0();
            } else {
                o0Var.W.f();
            }
        }
    }

    public final void L0() {
        this.e0 = true;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.onboarding_free_up_storage_title);
        bVar.c(R.string.storage_low_warning);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.l0.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o0.this.e0 = false;
                dialogInterface.cancel();
            }
        });
        bVar.e(R.string.manage_storage, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.l0.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o0 o0Var = o0.this;
                o0Var.e0 = false;
                m.e.U0(o0Var.v0());
            }
        });
        bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.l0.m
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                o0.this.e0 = false;
            }
        };
        bVar.b();
    }

    public final void M0() {
        this.d0 = true;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.exposure_turn_off_title);
        bVar.c(R.string.exposure_turn_off_detail);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.l0.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                o0.this.d0 = false;
                dialogInterface.cancel();
            }
        });
        bVar.e(R.string.btn_turn_off, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.l0.q
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: INVOKE  
                  (wrap: f.b.a.c.i.h : 0x002b: INVOKE  (r3v7 f.b.a.c.i.h A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h : 0x0022: INVOKE  (r3v6 f.b.a.c.i.h A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h<TContinuationResult> : 0x0019: INVOKE  (r3v5 f.b.a.c.i.h<TContinuationResult> A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h<java.lang.Boolean> : 0x0010: INVOKE  (r3v4 f.b.a.c.i.h<java.lang.Boolean> A[REMOVE]) = 
                  (wrap: f.b.a.a.a.c0.q1 : 0x000e: IGET  (r3v3 f.b.a.a.a.c0.q1 A[REMOVE]) = (r2v2 'exposureNotificationViewModel' com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel) com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel.q f.b.a.a.a.c0.q1)
                 type: VIRTUAL call: f.b.a.a.a.c0.q1.c():f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.x.o : 0x0016: CONSTRUCTOR  (r0v1 f.b.a.a.a.x.o A[REMOVE]) = (r2v2 'exposureNotificationViewModel' com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel) call: f.b.a.a.a.x.o.<init>(com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.i(f.b.a.c.i.a):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.x.d : 0x001f: CONSTRUCTOR  (r0v2 f.b.a.a.a.x.d A[REMOVE]) = (r2v2 'exposureNotificationViewModel' com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel) call: f.b.a.a.a.x.d.<init>(com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.f(f.b.a.c.i.f):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.x.k : 0x0028: CONSTRUCTOR  (r0v3 f.b.a.a.a.x.k A[REMOVE]) = (r2v2 'exposureNotificationViewModel' com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel) call: f.b.a.a.a.x.k.<init>(com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.d(f.b.a.c.i.e):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.x.q : 0x0031: CONSTRUCTOR  (r0v4 f.b.a.a.a.x.q A[REMOVE]) = (r2v2 'exposureNotificationViewModel' com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel) call: f.b.a.a.a.x.q.<init>(com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.a(f.b.a.c.i.c):f.b.a.c.i.h in method: f.b.a.a.a.l0.q.onClick(android.content.DialogInterface, int):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.x.o, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(android.content.DialogInterface r2, int r3) {
                /*
                    r1 = this;
                    f.b.a.a.a.l0.o0 r2 = f.b.a.a.a.l0.o0.this
                    r3 = 0
                    r2.d0 = r3
                    com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel r2 = r2.W
                    e.r.s<java.lang.Boolean> r3 = r2.f341d
                    java.lang.Boolean r0 = java.lang.Boolean.TRUE
                    r3.l(r0)
                    f.b.a.a.a.c0.q1 r3 = r2.q
                    f.b.a.c.i.h r3 = r3.c()
                    f.b.a.a.a.x.o r0 = new f.b.a.a.a.x.o
                    r0.<init>(r2)
                    f.b.a.c.i.h r3 = r3.i(r0)
                    f.b.a.a.a.x.d r0 = new f.b.a.a.a.x.d
                    r0.<init>(r2)
                    f.b.a.c.i.h r3 = r3.f(r0)
                    f.b.a.a.a.x.k r0 = new f.b.a.a.a.x.k
                    r0.<init>(r2)
                    f.b.a.c.i.h r3 = r3.d(r0)
                    f.b.a.a.a.x.q r0 = new f.b.a.a.a.x.q
                    r0.<init>(r2)
                    r3.a(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.l0.q.onClick(android.content.DialogInterface, int):void");
            }
        });
        bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.l0.g
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                o0.this.d0 = false;
            }
        };
        bVar.b();
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_exposure_about, (ViewGroup) null, false);
        int i2 = R.id.edge_case_fragment;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
        if (frameLayout != null) {
            i2 = R.id.exposure_about_detail;
            TextView textView = (TextView) inflate.findViewById(R.id.exposure_about_detail);
            if (textView != null) {
                i2 = R.id.exposure_about_detail_layout;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.exposure_about_detail_layout);
                if (linearLayout != null) {
                    i2 = R.id.exposure_about_settings_button;
                    Button button = (Button) inflate.findViewById(R.id.exposure_about_settings_button);
                    if (button != null) {
                        i2 = R.id.exposure_notification_toggle;
                        SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.exposure_notification_toggle);
                        if (switchMaterial != null) {
                            i2 = 16908332;
                            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                            if (imageButton != null) {
                                FrameLayout frameLayout2 = (FrameLayout) inflate;
                                this.b0 = new o(frameLayout2, frameLayout, textView, linearLayout, button, switchMaterial, imageButton);
                                return frameLayout2;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void W() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putBoolean("STATE_TURN_OFF_OPEN", this.d0);
        bundle.putBoolean("STATE_MANAGE_STORAGE_OPEN", this.e0);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        if (bundle != null) {
            this.d0 = bundle.getBoolean("STATE_TURN_OFF_OPEN", false);
            this.e0 = bundle.getBoolean("STATE_MANAGE_STORAGE_OPEN", false);
        }
        if (this.d0) {
            M0();
        }
        if (this.e0) {
            L0();
        }
        this.W.c.f(H(), new t() { // from class: f.b.a.a.a.l0.i
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
                o0Var.c0 = bVar;
                LinearLayout linearLayout = o0Var.b0.c;
                if (bVar == ExposureNotificationViewModel.b.ENABLED || bVar == ExposureNotificationViewModel.b.DISABLED || bVar == ExposureNotificationViewModel.b.FOCUS_LOST) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                    if ((bVar == ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST || bVar == ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_USER_PROFILE_NOT_SUPPORT || bVar == ExposureNotificationViewModel.b.PAUSED_HW_NOT_SUPPORT) && !o0Var.b0.f2459e.isChecked()) {
                        o0Var.b0.f2459e.setEnabled(false);
                        return;
                    }
                }
                o0Var.b0.f2459e.setEnabled(true);
            }
        });
        this.W.f343f.f(H(), new t() { // from class: f.b.a.a.a.l0.f
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                o0Var.b0.f2459e.setOnCheckedChangeListener(null);
                o0Var.b0.f2459e.setChecked(booleanValue);
                o0Var.b0.f2459e.setOnCheckedChangeListener(o0Var.f0);
            }
        });
        this.W.f349l.f(this, new t() { // from class: f.b.a.a.a.l0.n
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                Void r3 = (Void) obj;
                Snackbar.j(o0Var.w0(), o0Var.F(R.string.generic_error_message), 0).l();
            }
        });
        this.W.m.f(this, new t() { // from class: f.b.a.a.a.l0.l
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: INVOKE  
                  (r1v1 'K' com.google.android.material.snackbar.Snackbar)
                  (wrap: int : ?: SGET   gov.nm.covid19.exposurenotifications.R.string.learn_more int)
                  (wrap: f.b.a.a.a.l0.k : 0x0016: CONSTRUCTOR  (r3v0 f.b.a.a.a.l0.k A[REMOVE]) = (r0v0 'o0Var' f.b.a.a.a.l0.o0), (r5v3 'frameLayout' android.widget.FrameLayout) call: f.b.a.a.a.l0.k.<init>(f.b.a.a.a.l0.o0, android.view.View):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.google.android.material.snackbar.Snackbar.k(int, android.view.View$OnClickListener):com.google.android.material.snackbar.Snackbar in method: f.b.a.a.a.l0.l.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.l0.k, state: NOT_LOADED
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
                    f.b.a.a.a.l0.o0 r0 = f.b.a.a.a.l0.o0.this
                    java.lang.Void r5 = (java.lang.Void) r5
                    f.b.a.a.a.u.o r5 = r0.b0
                    android.widget.FrameLayout r5 = r5.a
                    if (r5 == 0) goto L_0x001f
                    r1 = 2131820937(0x7f110189, float:1.9274603E38)
                    com.google.android.material.snackbar.Snackbar r1 = e.b.a.m.e.K(r5, r1)
                    r2 = 2131820957(0x7f11019d, float:1.9274644E38)
                    f.b.a.a.a.l0.k r3 = new f.b.a.a.a.l0.k
                    r3.<init>(r0, r5)
                    r1.k(r2, r3)
                    r1.l()
                L_0x001f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.l0.l.a(java.lang.Object):void");
            }
        });
        this.b0.b.setText(G(R.string.exposure_about_detail, F(R.string.exposure_about_agency)));
        this.b0.f2460f.setContentDescription(F(R.string.navigate_up));
        this.b0.f2460f.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o0.this.u0().onBackPressed();
            }
        });
        this.b0.f2458d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o0 o0Var = o0.this;
                Objects.requireNonNull(o0Var);
                o0Var.F0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
            }
        });
        e0 j2 = j();
        if (j2.H(R.id.edge_case_fragment) == null) {
            j jVar = new j();
            l.O0(jVar, false, false);
            e.o.a.a aVar = new e.o.a.a(j2);
            aVar.g(R.id.edge_case_fragment, jVar, null);
            aVar.d();
        }
    }
}
