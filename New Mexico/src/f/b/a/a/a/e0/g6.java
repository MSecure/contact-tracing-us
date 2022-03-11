package f.b.a.a.a.e0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.l;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.e0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class g6 extends r5 {
    public e0 k0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
        int i2 = R.id.button_container;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.button_container);
        if (relativeLayout != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                i2 = R.id.share_diagnosis_scroll_view;
                NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                if (nestedScrollView != null) {
                    i2 = R.id.share_next_button;
                    Button button = (Button) inflate.findViewById(R.id.share_next_button);
                    if (button != null) {
                        i2 = R.id.share_test_result_title_text_view;
                        TextView textView = (TextView) inflate.findViewById(R.id.share_test_result_title_text_view);
                        if (textView != null) {
                            LinearLayout linearLayout = (LinearLayout) inflate;
                            this.k0 = new e0(linearLayout, relativeLayout, imageButton, nestedScrollView, button, textView);
                            return linearLayout;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.k0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.share_begin_title);
        TextView textView = this.k0.f2413f;
        Context v0 = v0();
        a aVar = m0.a;
        textView.setText(G(R.string.share_diagnosis_share_test_result_title, v0.getString(R.string.app_title)));
        e0 e0Var = this.k0;
        S0(e0Var.f2411d, e0Var.b);
        this.b0.f().f(H(), new t() { // from class: f.b.a.a.a.e0.w
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (wrap: android.widget.ImageButton : 0x0006: IGET  (r1v1 android.widget.ImageButton A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.e0 : 0x0004: IGET  (r1v0 f.b.a.a.a.u.e0 A[REMOVE]) = (r0v0 'g6Var' f.b.a.a.a.e0.g6) f.b.a.a.a.e0.g6.k0 f.b.a.a.a.u.e0)
                 f.b.a.a.a.u.e0.c android.widget.ImageButton)
                  (wrap: f.b.a.a.a.e0.x : 0x000a: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.x A[REMOVE]) = 
                  (r0v0 'g6Var' f.b.a.a.a.e0.g6)
                  (wrap: f.b.a.a.a.n0.j0 : 0x0002: CHECK_CAST (r4v1 f.b.a.a.a.n0.j0 A[REMOVE]) = (f.b.a.a.a.n0.j0) (r4v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.x.<init>(f.b.a.a.a.e0.g6, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.w.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.x, state: NOT_LOADED
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
                	... 10 more
                */
            @Override // e.r.t
            public final void a(java.lang.Object r4) {
                /*
                    r3 = this;
                    f.b.a.a.a.e0.g6 r0 = f.b.a.a.a.e0.g6.this
                    f.b.a.a.a.n0.j0 r4 = (f.b.a.a.a.n0.j0) r4
                    f.b.a.a.a.u.e0 r1 = r0.k0
                    android.widget.ImageButton r1 = r1.c
                    f.b.a.a.a.e0.x r2 = new f.b.a.a.a.e0.x
                    r2.<init>(r0, r4)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.w.a(java.lang.Object):void");
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        new i0(m.e.X0(shareDiagnosisViewModel.f(), new f4(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.BEGIN)), this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.FALSE)).f(this, new l(new i0.a() { // from class: f.b.a.a.a.e0.a0
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE  
                  (wrap: android.widget.Button : 0x0011: IGET  (r3v3 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.e0 : 0x000f: IGET  (r3v2 f.b.a.a.a.u.e0 A[REMOVE]) = (r0v0 'g6Var' f.b.a.a.a.e0.g6) f.b.a.a.a.e0.g6.k0 f.b.a.a.a.u.e0)
                 f.b.a.a.a.u.e0.e android.widget.Button)
                  (wrap: f.b.a.a.a.e0.z : 0x0015: CONSTRUCTOR  (r4v5 f.b.a.a.a.e0.z A[REMOVE]) = (r0v0 'g6Var' f.b.a.a.a.e0.g6) call: f.b.a.a.a.e0.z.<init>(f.b.a.a.a.e0.g6):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.a0.a(java.lang.Object, java.lang.Object):void, file: classes.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.z, state: NOT_LOADED
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
                	... 16 more
                */
            @Override // f.b.a.a.a.t.i0.a
            public final void a(java.lang.Object r3, java.lang.Object r4) {
                /*
                    r2 = this;
                    f.b.a.a.a.e0.g6 r0 = f.b.a.a.a.e0.g6.this
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r3 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r3
                    java.lang.Boolean r4 = (java.lang.Boolean) r4
                    java.util.Objects.requireNonNull(r0)
                    boolean r4 = r4.booleanValue()
                    if (r4 == 0) goto L_0x001c
                    f.b.a.a.a.u.e0 r3 = r0.k0
                    android.widget.Button r3 = r3.f2412e
                    f.b.a.a.a.e0.z r4 = new f.b.a.a.a.e0.z
                    r4.<init>(r0)
                    r3.setOnClickListener(r4)
                    goto L_0x0028
                L_0x001c:
                    f.b.a.a.a.u.e0 r4 = r0.k0
                    android.widget.Button r4 = r4.f2412e
                    f.b.a.a.a.e0.y r1 = new f.b.a.a.a.e0.y
                    r1.<init>(r0, r3)
                    r4.setOnClickListener(r1)
                L_0x0028:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.a0.a(java.lang.Object, java.lang.Object):void");
            }
        }));
    }
}
