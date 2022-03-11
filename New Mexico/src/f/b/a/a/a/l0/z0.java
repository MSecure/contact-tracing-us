package f.b.a.a.a.l0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.r.f0;
import e.r.t;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.b0;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class z0 extends u0 {
    public static final /* synthetic */ int c0;
    public b0 b0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_private_analytics, (ViewGroup) null, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.private_analytics_footer;
            TextView textView = (TextView) inflate.findViewById(R.id.private_analytics_footer);
            if (textView != null) {
                i2 = R.id.private_analytics_switch;
                SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.private_analytics_switch);
                if (switchMaterial != null) {
                    i2 = R.id.watermark;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.watermark);
                    if (textView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) inflate;
                        this.b0 = new b0(frameLayout, imageButton, textView, switchMaterial, textView2, frameLayout);
                        return frameLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.settings_private_analytics_subtitle);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.b0.b.setContentDescription(F(R.string.navigate_up));
        this.b0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.l0.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                z0.this.u0().onBackPressed();
            }
        });
        this.b0.f2394d.setText(F(R.string.private_analytics_subtitle));
        privateAnalyticsViewModel.c.f2314e.f(H(), new t(privateAnalyticsViewModel) { // from class: f.b.a.a.a.l0.w
            public final /* synthetic */ PrivateAnalyticsViewModel b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: INVOKE  
                  (wrap: com.google.android.material.switchmaterial.SwitchMaterial : 0x001b: IGET  (r5v4 com.google.android.material.switchmaterial.SwitchMaterial A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.b0 : 0x0019: IGET  (r5v3 f.b.a.a.a.u.b0 A[REMOVE]) = (r0v0 'z0Var' f.b.a.a.a.l0.z0) f.b.a.a.a.l0.z0.b0 f.b.a.a.a.u.b0)
                 f.b.a.a.a.u.b0.d com.google.android.material.switchmaterial.SwitchMaterial)
                  (wrap: f.b.a.a.a.l0.v : 0x001f: CONSTRUCTOR  (r0v1 f.b.a.a.a.l0.v A[REMOVE]) = (r1v0 'privateAnalyticsViewModel2' com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel) call: f.b.a.a.a.l0.v.<init>(com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.CompoundButton.setOnCheckedChangeListener(android.widget.CompoundButton$OnCheckedChangeListener):void in method: f.b.a.a.a.l0.w.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.l0.v, state: NOT_LOADED
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
                    f.b.a.a.a.l0.z0 r0 = f.b.a.a.a.l0.z0.this
                    com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel r1 = r4.b
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    f.b.a.a.a.u.b0 r2 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r2 = r2.f2394d
                    r3 = 0
                    r2.setOnCheckedChangeListener(r3)
                    f.b.a.a.a.u.b0 r2 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r2 = r2.f2394d
                    boolean r5 = r5.booleanValue()
                    r2.setChecked(r5)
                    f.b.a.a.a.u.b0 r5 = r0.b0
                    com.google.android.material.switchmaterial.SwitchMaterial r5 = r5.f2394d
                    f.b.a.a.a.l0.v r0 = new f.b.a.a.a.l0.v
                    r0.<init>(r1)
                    r5.setOnCheckedChangeListener(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.l0.w.a(java.lang.Object):void");
            }
        });
        String F = F(R.string.private_analytics_footer_learn_more);
        String F2 = F(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.o0.a aVar2 = new f.b.a.a.a.o0.a(F2);
        String G = G(R.string.private_analytics_footer, F);
        SpannableString spannableString = new SpannableString(G);
        int indexOf = G.indexOf(F);
        spannableString.setSpan(aVar2, indexOf, F.length() + indexOf, 33);
        this.b0.c.setText(spannableString);
        this.b0.c.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
