package f.b.a.a.a.e0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.card.MaterialCardView;
import e.a.e.a;
import e.a.e.c;
import e.a.e.e;
import e.a.e.f.d;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.u.g;
import f.b.a.a.a.u.k0;
import f.b.b.a.l;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class s6 extends e6 {
    public k0 i0;

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1
    public boolean I0() {
        L0();
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_pre_auth, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.pre_auth_layout);
        if (findViewById != null) {
            int i2 = R.id.learn_more_button;
            Button button = (Button) findViewById.findViewById(R.id.learn_more_button);
            if (button != null) {
                i2 = R.id.no_thanks_button;
                Button button2 = (Button) findViewById.findViewById(R.id.no_thanks_button);
                if (button2 != null) {
                    i2 = R.id.pre_auth_card_content;
                    TextView textView = (TextView) findViewById.findViewById(R.id.pre_auth_card_content);
                    if (textView != null) {
                        i2 = R.id.yes_button;
                        Button button3 = (Button) findViewById.findViewById(R.id.yes_button);
                        if (button3 != null) {
                            LinearLayout linearLayout = (LinearLayout) inflate;
                            this.i0 = new k0(linearLayout, new g((MaterialCardView) findViewById, button, button2, textView, button3));
                            return linearLayout;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.pre_auth_layout)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.i0 = null;
    }

    public final void X0(l<ShareDiagnosisViewModel.b> lVar) {
        if (lVar.b()) {
            this.b0.l(lVar.a());
        } else {
            L0();
        }
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.share_confirm_title);
        this.i0.b.f2414d.setText(G(R.string.notify_others_if_result_updated_content, F(R.string.health_authority_name)));
        this.i0.b.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.a(view2, s6.this.F(R.string.en_reporting_info_link));
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.PRE_AUTH;
        LiveData X0 = m.e.X0(shareDiagnosisViewModel.f(), new f4(shareDiagnosisViewModel, bVar));
        g4 g4Var = g4.a;
        m.e.X0(X0, g4Var).f(H(), new t() { // from class: f.b.a.a.a.e0.y1
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                  (wrap: android.widget.Button : 0x0008: IGET  (r1v2 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.g : 0x0006: IGET  (r1v1 f.b.a.a.a.u.g A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.k0 : 0x0004: IGET  (r1v0 f.b.a.a.a.u.k0 A[REMOVE]) = (r0v0 's6Var' f.b.a.a.a.e0.s6) f.b.a.a.a.e0.s6.i0 f.b.a.a.a.u.k0)
                 f.b.a.a.a.u.k0.b f.b.a.a.a.u.g)
                 f.b.a.a.a.u.g.c android.widget.Button)
                  (wrap: f.b.a.a.a.e0.w1 : 0x000c: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.w1 A[REMOVE]) = 
                  (r0v0 's6Var' f.b.a.a.a.e0.s6)
                  (wrap: f.b.b.a.l : 0x0002: CHECK_CAST (r4v1 f.b.b.a.l A[REMOVE]) = (f.b.b.a.l) (r4v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.w1.<init>(f.b.a.a.a.e0.s6, f.b.b.a.l):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.y1.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.w1, state: NOT_LOADED
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
                    f.b.a.a.a.e0.s6 r0 = f.b.a.a.a.e0.s6.this
                    f.b.b.a.l r4 = (f.b.b.a.l) r4
                    f.b.a.a.a.u.k0 r1 = r0.i0
                    f.b.a.a.a.u.g r1 = r1.b
                    android.widget.Button r1 = r1.c
                    f.b.a.a.a.e0.w1 r2 = new f.b.a.a.a.e0.w1
                    r2.<init>(r0, r4)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.y1.a(java.lang.Object):void");
            }
        });
        this.i0.b.f2415e.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.t1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                s6.this.b0.n();
            }
        });
        c t0 = t0(new d(), new e.a.e.b() { // from class: f.b.a.a.a.e0.s1
            @Override // e.a.e.b
            public final void a(Object obj) {
                s6 s6Var = s6.this;
                Objects.requireNonNull(s6Var);
                if (((a) obj).b == -1) {
                    s6Var.b0.n();
                } else {
                    s6Var.b0.w.j(Boolean.TRUE);
                }
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
        new i0(m.e.X0(m.e.X0(shareDiagnosisViewModel2.f(), new f4(shareDiagnosisViewModel2, bVar)), g4Var), this.b0.w).n(H(), new i0.a() { // from class: f.b.a.a.a.e0.v1
            @Override // f.b.a.a.a.t.i0.a
            public final void a(Object obj, Object obj2) {
                s6 s6Var = s6.this;
                l<ShareDiagnosisViewModel.b> lVar = (l) obj;
                Objects.requireNonNull(s6Var);
                if (((Boolean) obj2).booleanValue()) {
                    s6Var.X0(lVar);
                }
            }
        });
        this.b0.t.f(H(), new t(t0) { // from class: f.b.a.a.a.e0.u1
            public final /* synthetic */ c b;

            {
                this.b = r2;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                s6 s6Var = s6.this;
                c<e> cVar = this.b;
                s6Var.b0.u((f.b.a.c.b.l.b) obj, cVar);
            }
        });
    }
}
