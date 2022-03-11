package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import e.r.t;
import f.b.a.a.a.u.o0;
import gov.nm.covid19.exposurenotifications.R;
import l.b.a.v.c;
import l.b.a.v.k;
/* loaded from: classes.dex */
public class z6 extends y5 {
    public final c k0 = c.c(k.MEDIUM);
    public o0 l0;

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1
    public boolean I0() {
        L0();
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_view, viewGroup, false);
        int i2 = R.id.button_container;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.button_container);
        if (relativeLayout != null) {
            i2 = R.id.diagnosis_delete_button;
            Button button = (Button) inflate.findViewById(R.id.diagnosis_delete_button);
            if (button != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    i2 = R.id.share_diagnosis_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                    if (nestedScrollView != null) {
                        i2 = R.id.share_review_date;
                        TextView textView = (TextView) inflate.findViewById(R.id.share_review_date);
                        if (textView != null) {
                            i2 = R.id.share_review_status;
                            TextView textView2 = (TextView) inflate.findViewById(R.id.share_review_status);
                            if (textView2 != null) {
                                i2 = R.id.share_review_travel;
                                TextView textView3 = (TextView) inflate.findViewById(R.id.share_review_travel);
                                if (textView3 != null) {
                                    i2 = R.id.share_review_travel_subtitle;
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.share_review_travel_subtitle);
                                    if (textView4 != null) {
                                        LinearLayout linearLayout = (LinearLayout) inflate;
                                        this.l0 = new o0(linearLayout, relativeLayout, button, imageButton, nestedScrollView, textView, textView2, textView3, textView4);
                                        return linearLayout;
                                    }
                                }
                            }
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
        this.l0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.status_shared_detail_title);
        o0 o0Var = this.l0;
        S0(o0Var.f2462e, o0Var.b);
        this.l0.f2461d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z6.this.L0();
            }
        });
        this.b0.f().f(H(), new t() { // from class: f.b.a.a.a.e0.u2
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                  (wrap: android.widget.Button : 0x000d: IGET  (r1v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.o0 : 0x000b: IGET  (r1v0 f.b.a.a.a.u.o0 A[REMOVE]) = (r0v0 'z6Var' f.b.a.a.a.e0.z6) f.b.a.a.a.e0.z6.l0 f.b.a.a.a.u.o0)
                 f.b.a.a.a.u.o0.c android.widget.Button)
                  (wrap: f.b.a.a.a.e0.w2 : 0x0011: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.w2 A[REMOVE]) = (r0v0 'z6Var' f.b.a.a.a.e0.z6), (r12v1 'j0Var' f.b.a.a.a.n0.j0) call: f.b.a.a.a.e0.w2.<init>(f.b.a.a.a.e0.z6, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.u2.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.w2, state: NOT_LOADED
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
            @Override // e.r.t
            /* Code decompiled incorrectly, please refer to instructions dump */
            public final void a(java.lang.Object r12) {
                /*
                    r11 = this;
                    f.b.a.a.a.e0.z6 r0 = f.b.a.a.a.e0.z6.this
                    f.b.a.a.a.n0.j0 r12 = (f.b.a.a.a.n0.j0) r12
                    java.util.Objects.requireNonNull(r0)
                    if (r12 != 0) goto L_0x000b
                    goto L_0x00ef
                L_0x000b:
                    f.b.a.a.a.u.o0 r1 = r0.l0
                    android.widget.Button r1 = r1.c
                    f.b.a.a.a.e0.w2 r2 = new f.b.a.a.a.e0.w2
                    r2.<init>(r0, r12)
                    r1.setOnClickListener(r2)
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r1 = r0.b0
                    boolean r1 = r1.M
                    if (r1 == 0) goto L_0x0020
                    r0.V0(r12)
                L_0x0020:
                    l.b.a.f r1 = r12.k()
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L_0x0050
                    android.content.Context r1 = r0.v0()
                    r4 = 2131822431(0x7f11075f, float:1.9277633E38)
                    java.lang.Object[] r5 = new java.lang.Object[r3]
                    l.b.a.v.c r6 = r0.k0
                    android.content.res.Resources r7 = r0.B()
                    android.content.res.Configuration r7 = r7.getConfiguration()
                    java.util.Locale r7 = r7.locale
                    l.b.a.v.c r6 = r6.g(r7)
                    l.b.a.f r7 = r12.k()
                    java.lang.String r6 = r6.b(r7)
                    r5[r2] = r6
                    java.lang.String r1 = r1.getString(r4, r5)
                    goto L_0x0052
                L_0x0050:
                    java.lang.String r1 = ""
                L_0x0052:
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r4 = r0.b0
                    boolean r4 = r4.i()
                    f.b.a.a.a.u.o0 r0 = r0.l0
                    f.b.a.a.a.t.p0.a r5 = f.b.a.a.a.e0.o5.a
                    android.view.View r0 = r0.a()
                    r5 = 2131362327(0x7f0a0217, float:1.8344431E38)
                    android.view.View r5 = r0.findViewById(r5)
                    android.widget.TextView r5 = (android.widget.TextView) r5
                    r6 = 2131362326(0x7f0a0216, float:1.834443E38)
                    android.view.View r6 = r0.findViewById(r6)
                    android.widget.TextView r6 = (android.widget.TextView) r6
                    r7 = 2131362328(0x7f0a0218, float:1.8344433E38)
                    android.view.View r7 = r0.findViewById(r7)
                    android.widget.TextView r7 = (android.widget.TextView) r7
                    r8 = 2131362329(0x7f0a0219, float:1.8344436E38)
                    android.view.View r0 = r0.findViewById(r8)
                    android.widget.TextView r0 = (android.widget.TextView) r0
                    f.b.a.a.a.n0.j0$d r8 = r12.n()
                    r9 = 2131822435(0x7f110763, float:1.9277641E38)
                    r10 = 2
                    if (r8 == 0) goto L_0x00a6
                    f.b.a.a.a.n0.j0$d r8 = r12.n()
                    int r8 = r8.ordinal()
                    if (r8 == r3) goto L_0x009f
                    if (r8 == r10) goto L_0x009b
                    goto L_0x00a6
                L_0x009b:
                    r8 = 2131822437(0x7f110765, float:1.9277645E38)
                    goto L_0x00a2
                L_0x009f:
                    r8 = 2131822436(0x7f110764, float:1.9277643E38)
                L_0x00a2:
                    r5.setText(r8)
                    goto L_0x00a9
                L_0x00a6:
                    r5.setText(r9)
                L_0x00a9:
                    if (r4 != 0) goto L_0x00d5
                    r7.setVisibility(r2)
                    r0.setVisibility(r2)
                    f.b.a.a.a.n0.j0$e r0 = r12.o()
                    r2 = 2131822441(0x7f110769, float:1.9277654E38)
                    if (r0 == 0) goto L_0x00d2
                    f.b.a.a.a.n0.j0$e r0 = r12.o()
                    int r0 = r0.ordinal()
                    if (r0 == r3) goto L_0x00cb
                    if (r0 == r10) goto L_0x00c7
                    goto L_0x00d2
                L_0x00c7:
                    r0 = 2131822442(0x7f11076a, float:1.9277656E38)
                    goto L_0x00ce
                L_0x00cb:
                    r0 = 2131822440(0x7f110768, float:1.9277651E38)
                L_0x00ce:
                    r7.setText(r0)
                    goto L_0x00d5
                L_0x00d2:
                    r7.setText(r2)
                L_0x00d5:
                    f.b.a.a.a.n0.j0$b r12 = r12.d()
                    int r12 = r12.ordinal()
                    if (r12 == r3) goto L_0x00ec
                    if (r12 == r10) goto L_0x00e5
                    r12 = 2131822432(0x7f110760, float:1.9277635E38)
                    goto L_0x00e8
                L_0x00e5:
                    r12 = 2131822433(0x7f110761, float:1.9277637E38)
                L_0x00e8:
                    r6.setText(r12)
                    goto L_0x00ef
                L_0x00ec:
                    r6.setText(r1)
                L_0x00ef:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.u2.a(java.lang.Object):void");
            }
        });
        this.b0.p.f(H(), new t() { // from class: f.b.a.a.a.e0.v2
            @Override // e.r.t
            public final void a(Object obj) {
                z6 z6Var = z6.this;
                Void r4 = (Void) obj;
                Toast.makeText(z6Var.k(), (int) R.string.delete_test_result_confirmed, 1).show();
                z6Var.L0();
            }
        });
    }
}
