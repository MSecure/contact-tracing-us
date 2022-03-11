package f.b.a.a.a.v;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.r.f0;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.l;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.n;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class r extends o {
    public n c0;

    @Override // f.b.a.a.a.v.l
    public void M0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        int i2;
        int i3;
        new i0(((ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class)).f(), this.W.f343f).f(this, new l(new i0.a(view2) { // from class: f.b.a.a.a.v.i
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                  (wrap: android.widget.ImageButton : 0x001e: IGET  (r3v5 android.widget.ImageButton A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.n : 0x001c: IGET  (r3v4 f.b.a.a.a.u.n A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.v.r) f.b.a.a.a.v.r.c0 f.b.a.a.a.u.n)
                 f.b.a.a.a.u.n.f android.widget.ImageButton)
                  (wrap: f.b.a.a.a.v.h : 0x0022: CONSTRUCTOR  (r4v2 f.b.a.a.a.v.h A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.v.r) call: f.b.a.a.a.v.h.<init>(f.b.a.a.a.v.r):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.v.i.a(java.lang.Object, java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.v.h, state: NOT_LOADED
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
            @Override // f.b.a.a.a.t.i0.a
            public final void a(java.lang.Object r3, java.lang.Object r4) {
                /*
                    r2 = this;
                    f.b.a.a.a.v.r r0 = f.b.a.a.a.v.r.this
                    android.view.View r1 = r2.b
                    f.b.a.a.a.n0.j0 r3 = (f.b.a.a.a.n0.j0) r3
                    java.lang.Boolean r4 = (java.lang.Boolean) r4
                    java.util.Objects.requireNonNull(r0)
                    boolean r3 = f.b.a.a.a.e0.o5.a(r3)
                    if (r3 == 0) goto L_0x0013
                    r3 = 0
                    goto L_0x0019
                L_0x0013:
                    boolean r3 = r4.booleanValue()
                    r3 = r3 ^ 1
                L_0x0019:
                    r0.P0(r1, r3)
                    f.b.a.a.a.u.n r3 = r0.c0
                    android.widget.ImageButton r3 = r3.f2453f
                    f.b.a.a.a.v.h r4 = new f.b.a.a.a.v.h
                    r4.<init>(r0)
                    r3.setOnClickListener(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.v.i.a(java.lang.Object, java.lang.Object):void");
            }
        }));
        n nVar = this.c0;
        TextView textView = nVar.f2451d;
        TextView textView2 = nVar.c;
        Button button = nVar.b;
        TextView textView3 = nVar.f2452e;
        button.setEnabled(true);
        int ordinal = bVar.ordinal();
        if (ordinal != 0) {
            switch (ordinal) {
                case 5:
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    textView2.setText(R.string.storage_low_warning);
                    button.setText(R.string.manage_storage);
                    textView3.setVisibility(8);
                    J0(button);
                    N0(n.c.LOW_STORAGE_WARNING_SHOWN);
                    return;
                case 6:
                    textView.setText(R.string.en_turndown_title);
                    i3 = R.string.en_turndown_contents;
                    break;
                case 7:
                    textView.setText(R.string.switch_app_for_exposure_notifications);
                    Context v0 = v0();
                    a aVar = m0.a;
                    textView2.setText(G(R.string.focus_lost_warning, v0.getString(R.string.app_title)));
                    i2 = R.string.switch_app_for_exposure_notifications_action;
                    break;
                case 8:
                    String F = F(R.string.device_requirements_link_text);
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    String F2 = F(R.string.device_requirements_link);
                    a aVar2 = b.a;
                    textView2.setText(m0.b(new f.b.a.a.a.o0.a(F2), G(R.string.hw_not_supported_warning, F), F));
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    button.setVisibility(8);
                    return;
                case 9:
                    textView.setText(R.string.en_turndown_for_area_title);
                    i3 = R.string.en_turndown_for_area_contents;
                    break;
                case 10:
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    i3 = R.string.user_profile_not_supported_warning;
                    break;
                default:
                    return;
            }
            textView2.setText(i3);
            button.setVisibility(8);
            textView3.setVisibility(8);
            return;
        }
        textView.setText(R.string.exposure_notifications_are_turned_off);
        textView2.setText(G(R.string.notify_turn_on_exposure_notifications_header, F(R.string.using_en_helps_even_if_vaccinated)));
        i2 = R.string.turn_on_exposure_notifications_action;
        button.setText(i2);
        textView3.setVisibility(8);
        L0(button, z);
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edge_cases_verification, viewGroup, false);
        int i2 = R.id.edgecase_main_button;
        Button button = (Button) inflate.findViewById(R.id.edgecase_main_button);
        if (button != null) {
            i2 = R.id.edgecase_main_text;
            TextView textView = (TextView) inflate.findViewById(R.id.edgecase_main_text);
            if (textView != null) {
                i2 = R.id.edgecase_main_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.edgecase_main_title);
                if (textView2 != null) {
                    i2 = R.id.health_authority_turndown_content;
                    TextView textView3 = (TextView) inflate.findViewById(R.id.health_authority_turndown_content);
                    if (textView3 != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            LinearLayout linearLayout = (LinearLayout) inflate;
                            this.c0 = new f.b.a.a.a.u.n(linearLayout, button, textView, textView2, textView3, imageButton);
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
        this.c0 = null;
    }
}
