package f.b.a.a.a.l0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.r.f0;
import e.r.t;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.u.k;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class m0 extends r0 {
    public static final /* synthetic */ int c0;
    public k b0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_app_analytics, (ViewGroup) null, false);
        int i2 = R.id.app_analytics_learn_mode;
        Button button = (Button) inflate.findViewById(R.id.app_analytics_learn_mode);
        if (button != null) {
            i2 = R.id.app_analytics_switch;
            SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.app_analytics_switch);
            if (switchMaterial != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    this.b0 = new k(frameLayout, button, switchMaterial, imageButton);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.app_analytics_title);
        AppAnalyticsViewModel appAnalyticsViewModel = (AppAnalyticsViewModel) new f0(this).a(AppAnalyticsViewModel.class);
        this.b0.f2439d.setContentDescription(F(R.string.navigate_up));
        this.b0.f2439d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m0.this.u0().onBackPressed();
            }
        });
        appAnalyticsViewModel.c.f2313d.f(H(), new t(appAnalyticsViewModel) { // from class: f.b.a.a.a.l0.e
            public final /* synthetic */ AppAnalyticsViewModel b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: INVOKE  
                  (wrap: com.google.android.material.switchmaterial.SwitchMaterial : 0x001b: IGET  (r5v4 com.google.android.material.switchmaterial.SwitchMaterial A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.k : 0x0019: IGET  (r5v3 f.b.a.a.a.u.k A[REMOVE]) = (r0v0 'm0Var' f.b.a.a.a.l0.m0) f.b.a.a.a.l0.m0.b0 f.b.a.a.a.u.k)
                 f.b.a.a.a.u.k.c com.google.android.material.switchmaterial.SwitchMaterial)
                  (wrap: f.b.a.a.a.l0.b : 0x001f: CONSTRUCTOR  (r0v1 f.b.a.a.a.l0.b A[REMOVE]) = (r1v0 'appAnalyticsViewModel2' com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel) call: f.b.a.a.a.l0.b.<init>(com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.CompoundButton.setOnCheckedChangeListener(android.widget.CompoundButton$OnCheckedChangeListener):void in method: f.b.a.a.a.l0.e.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.l0.b, state: NOT_LOADED
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
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    f.b.a.a.a.l0.m0 r0 = f.b.a.a.a.l0.m0.this
                    com.google.android.apps.exposurenotification.settings.AppAnalyticsViewModel r1 = r4.b
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    f.b.a.a.a.u.k r2 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r2 = r2.c
                    r3 = 0
                    r2.setOnCheckedChangeListener(r3)
                    f.b.a.a.a.u.k r2 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r2 = r2.c
                    boolean r5 = r5.booleanValue()
                    r2.setChecked(r5)
                    f.b.a.a.a.u.k r5 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r5 = r5.c
                    f.b.a.a.a.l0.b r0 = new f.b.a.a.a.l0.b
                    r0.<init>(r1)
                    r5.setOnCheckedChangeListener(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.l0.e.a(java.lang.Object):void");
            }
        });
        this.b0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m0 m0Var = m0.this;
                b.a(m0Var.b0.a, m0Var.F(R.string.app_analytics_link));
            }
        });
    }
}
