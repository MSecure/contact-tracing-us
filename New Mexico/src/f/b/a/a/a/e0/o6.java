package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.r.t;
import e.v.i;
import e.v.p.c;
import f.b.a.a.a.n0.b0;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.n0.x;
import f.b.a.a.a.u.i0;
import gov.nm.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;
import l.b.a.d;
/* loaded from: classes.dex */
public class o6 extends u5 {
    public i0 k0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_is_code_needed, viewGroup, false);
        int i2 = R.id.btn_i_have_code;
        Button button = (Button) inflate.findViewById(R.id.btn_i_have_code);
        if (button != null) {
            i2 = R.id.btn_i_need_code;
            Button button2 = (Button) inflate.findViewById(R.id.btn_i_need_code);
            if (button2 != null) {
                i2 = R.id.button_container;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
                if (linearLayout != null) {
                    i2 = R.id.do_you_have_code_content;
                    TextView textView = (TextView) inflate.findViewById(R.id.do_you_have_code_content);
                    if (textView != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.share_diagnosis_scroll_view;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                            if (nestedScrollView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                this.k0 = new i0(linearLayout2, button, button2, linearLayout, textView, imageButton, nestedScrollView);
                                return linearLayout2;
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
        this.k0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        String str;
        super.m0(view, bundle);
        u0().setTitle(F(R.string.do_you_have_code_title));
        i0 i0Var = this.k0;
        S0(i0Var.f2438g, i0Var.f2435d);
        if (!TextUtils.isEmpty(F(R.string.self_report_intro))) {
            this.k0.f2436e.setText(R.string.self_report_intro);
        }
        this.b0.f().f(H(), new t() { // from class: f.b.a.a.a.e0.n1
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (wrap: android.widget.ImageButton : 0x0006: IGET  (r1v1 android.widget.ImageButton A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.i0 : 0x0004: IGET  (r1v0 f.b.a.a.a.u.i0 A[REMOVE]) = (r0v0 'o6Var' f.b.a.a.a.e0.o6) f.b.a.a.a.e0.o6.k0 f.b.a.a.a.u.i0)
                 f.b.a.a.a.u.i0.f android.widget.ImageButton)
                  (wrap: f.b.a.a.a.e0.p1 : 0x000a: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.p1 A[REMOVE]) = 
                  (r0v0 'o6Var' f.b.a.a.a.e0.o6)
                  (wrap: f.b.a.a.a.n0.j0 : 0x0002: CHECK_CAST (r4v1 f.b.a.a.a.n0.j0 A[REMOVE]) = (f.b.a.a.a.n0.j0) (r4v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.p1.<init>(f.b.a.a.a.e0.o6, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.n1.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.p1, state: NOT_LOADED
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
                    f.b.a.a.a.e0.o6 r0 = f.b.a.a.a.e0.o6.this
                    f.b.a.a.a.n0.j0 r4 = (f.b.a.a.a.n0.j0) r4
                    f.b.a.a.a.u.i0 r1 = r0.k0
                    android.widget.ImageButton r1 = r1.f2437f
                    f.b.a.a.a.e0.p1 r2 = new f.b.a.a.a.e0.p1
                    r2.<init>(r0, r4)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.n1.a(java.lang.Object):void");
            }
        });
        this.k0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                o6 o6Var = o6.this;
                o6Var.b0.r(k6.DEFAULT);
                o6Var.b0.k(ShareDiagnosisViewModel.b.CODE);
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        long G = shareDiagnosisViewModel.f412j.c().w(d.f(90)).G();
        x xVar = shareDiagnosisViewModel.c.a;
        List<j0.d> list = k0.f2369f;
        List<j0.c> list2 = k0.f2368e;
        d0 d0Var = (d0) xVar;
        Objects.requireNonNull(d0Var);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM DiagnosisEntity WHERE testResult IN (");
        int size = list.size();
        c.a(sb, size);
        sb.append(") AND sharedStatus IN (");
        int size2 = list2.size();
        c.a(sb, size2);
        sb.append(") AND lastUpdatedTimestampMs > ");
        sb.append("?");
        sb.append(" ORDER BY lastUpdatedTimestampMs DESC LIMIT 1");
        int i2 = 1;
        int i3 = size + 1;
        int i4 = size2 + i3;
        i t = i.t(sb.toString(), i4);
        for (j0.d dVar : list) {
            if (dVar == null) {
                str = null;
            } else {
                str = dVar.name();
            }
            if (str == null) {
                t.J(i2);
            } else {
                t.L(i2, str);
            }
            i2++;
        }
        for (j0.c cVar : list2) {
            String d0 = m.e.d0(cVar);
            if (d0 == null) {
                t.J(i3);
            } else {
                t.L(i3, d0);
            }
            i3++;
        }
        t.x(i4, G);
        d0Var.a.f2062e.b(new String[]{"DiagnosisEntity"}, false, new b0(d0Var, t)).f(H(), new t() { // from class: f.b.a.a.a.e0.m1
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (wrap: android.widget.Button : 0x0006: IGET  (r1v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.i0 : 0x0004: IGET  (r1v0 f.b.a.a.a.u.i0 A[REMOVE]) = (r0v0 'o6Var' f.b.a.a.a.e0.o6) f.b.a.a.a.e0.o6.k0 f.b.a.a.a.u.i0)
                 f.b.a.a.a.u.i0.c android.widget.Button)
                  (wrap: f.b.a.a.a.e0.o1 : 0x000a: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.o1 A[REMOVE]) = 
                  (r0v0 'o6Var' f.b.a.a.a.e0.o6)
                  (wrap: f.b.b.a.l : 0x0002: CHECK_CAST (r4v1 f.b.b.a.l A[REMOVE]) = (f.b.b.a.l) (r4v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.o1.<init>(f.b.a.a.a.e0.o6, f.b.b.a.l):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.m1.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.o1, state: NOT_LOADED
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
                    f.b.a.a.a.e0.o6 r0 = f.b.a.a.a.e0.o6.this
                    f.b.b.a.l r4 = (f.b.b.a.l) r4
                    f.b.a.a.a.u.i0 r1 = r0.k0
                    android.widget.Button r1 = r1.c
                    f.b.a.a.a.e0.o1 r2 = new f.b.a.a.a.e0.o1
                    r2.<init>(r0, r4)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.m1.a(java.lang.Object):void");
            }
        });
    }
}
