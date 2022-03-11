package f.b.a.a.a.e0;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import e.a.e.b;
import e.a.e.c;
import e.a.e.e;
import e.a.e.f.d;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.m0;
import f.b.a.e.l.q;
import f.b.b.a.l;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class w6 extends x5 {
    public static final a l0 = a.e("ShareDiagnosisUploadFragment");
    public m0 k0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_upload, viewGroup, false);
        int i2 = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
        if (linearLayout != null) {
            i2 = R.id.has_symptom_chip_group;
            ChipGroup chipGroup = (ChipGroup) inflate.findViewById(R.id.has_symptom_chip_group);
            if (chipGroup != null) {
                i2 = R.id.has_symptom_confirmed_selected_date_choice;
                Chip chip = (Chip) inflate.findViewById(R.id.has_symptom_confirmed_selected_date_choice);
                if (chip != null) {
                    i2 = R.id.has_symptoms_date_fixed_description;
                    TextView textView = (TextView) inflate.findViewById(R.id.has_symptoms_date_fixed_description);
                    if (textView != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.no_travel_choice;
                            Chip chip2 = (Chip) inflate.findViewById(R.id.no_travel_choice);
                            if (chip2 != null) {
                                i2 = R.id.share_button;
                                Button button = (Button) inflate.findViewById(R.id.share_button);
                                if (button != null) {
                                    i2 = R.id.share_diagnosis_scroll_view;
                                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                                    if (nestedScrollView != null) {
                                        i2 = R.id.share_previous_button;
                                        Button button2 = (Button) inflate.findViewById(R.id.share_previous_button);
                                        if (button2 != null) {
                                            i2 = R.id.share_progress_bar;
                                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.share_progress_bar);
                                            if (progressBar != null) {
                                                i2 = R.id.share_upload_status;
                                                TextView textView2 = (TextView) inflate.findViewById(R.id.share_upload_status);
                                                if (textView2 != null) {
                                                    i2 = R.id.share_upload_test_result_description;
                                                    TextView textView3 = (TextView) inflate.findViewById(R.id.share_upload_test_result_description);
                                                    if (textView3 != null) {
                                                        i2 = R.id.share_upload_travel_subtitle;
                                                        TextView textView4 = (TextView) inflate.findViewById(R.id.share_upload_travel_subtitle);
                                                        if (textView4 != null) {
                                                            i2 = R.id.skip_symptom_date_choice;
                                                            Chip chip3 = (Chip) inflate.findViewById(R.id.skip_symptom_date_choice);
                                                            if (chip3 != null) {
                                                                i2 = R.id.skip_travel_history_choice;
                                                                Chip chip4 = (Chip) inflate.findViewById(R.id.skip_travel_history_choice);
                                                                if (chip4 != null) {
                                                                    i2 = R.id.step_x_of_y_text_view;
                                                                    TextView textView5 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                                    if (textView5 != null) {
                                                                        i2 = R.id.travel_confirmed_choice;
                                                                        Chip chip5 = (Chip) inflate.findViewById(R.id.travel_confirmed_choice);
                                                                        if (chip5 != null) {
                                                                            i2 = R.id.travel_history_chip_group;
                                                                            ChipGroup chipGroup2 = (ChipGroup) inflate.findViewById(R.id.travel_history_chip_group);
                                                                            if (chipGroup2 != null) {
                                                                                i2 = R.id.travel_history_layout;
                                                                                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.travel_history_layout);
                                                                                if (linearLayout2 != null) {
                                                                                    LinearLayout linearLayout3 = (LinearLayout) inflate;
                                                                                    this.k0 = new m0(linearLayout3, linearLayout, chipGroup, chip, textView, imageButton, chip2, button, nestedScrollView, button2, progressBar, textView2, textView3, textView4, chip3, chip4, textView5, chip5, chipGroup2, linearLayout2);
                                                                                    return linearLayout3;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
        this.k0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.verify_test_result_title);
        m0 m0Var = this.k0;
        S0(m0Var.f2447i, m0Var.b);
        this.k0.f2444f.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w6.this.U0();
            }
        });
        this.b0.g().f(H(), new t() { // from class: f.b.a.a.a.e0.m2
            @Override // e.r.t
            public final void a(Object obj) {
                w6 w6Var = w6.this;
                Pair pair = (Pair) obj;
                Objects.requireNonNull(w6Var);
                w6Var.k0.p.setText(w6Var.G(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
            }
        });
        TextView textView = this.k0.m;
        Context v0 = v0();
        a aVar = f.b.a.a.a.t.m0.a;
        textView.setText(G(R.string.share_upload_test_result_source_description, v0.getString(R.string.health_authority_name)));
        this.k0.c.setOnCheckedChangeListener(new ChipGroup.d() { // from class: f.b.a.a.a.e0.p2
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: INVOKE  
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel : 0x0002: IGET  (r2v2 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel A[REMOVE]) = 
                  (wrap: f.b.a.a.a.e0.w6 : 0x0000: IGET  (r2v1 f.b.a.a.a.e0.w6 A[REMOVE]) = (r1v0 'this' f.b.a.a.a.e0.p2 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.p2.a f.b.a.a.a.e0.w6)
                 f.b.a.a.a.e0.e6.b0 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (wrap: f.b.a.a.a.e0.r3 : 0x0018: CONSTRUCTOR  (r0v1 f.b.a.a.a.e0.r3 A[REMOVE]) = 
                  (wrap: f.b.a.a.a.n0.j0$b : ?: TERNARY(r3v1 f.b.a.a.a.n0.j0$b A[REMOVE]) = ((r3v0 'i2' int) != (wrap: int : ?: SGET   gov.nm.covid19.exposurenotifications.R.id.has_symptom_confirmed_selected_date_choice int)) ? (wrap: f.b.a.a.a.n0.j0$b : ?: TERNARY(r3v4 f.b.a.a.a.n0.j0$b A[REMOVE]) = ((r3v0 'i2' int) != (wrap: int : ?: SGET   gov.nm.covid19.exposurenotifications.R.id.skip_symptom_date_choice int)) ? (wrap: f.b.a.a.a.n0.j0$b : 0x000e: SGET  (r3v4 f.b.a.a.a.n0.j0$b A[REMOVE]) =  f.b.a.a.a.n0.j0.b.b f.b.a.a.a.n0.j0$b) : (wrap: f.b.a.a.a.n0.j0$b : 0x0011: SGET  (r3v3 f.b.a.a.a.n0.j0$b A[REMOVE]) =  f.b.a.a.a.n0.j0.b.e f.b.a.a.a.n0.j0$b)) : (wrap: f.b.a.a.a.n0.j0$b : 0x0014: SGET  (r3v2 f.b.a.a.a.n0.j0$b A[REMOVE]) =  f.b.a.a.a.n0.j0.b.c f.b.a.a.a.n0.j0$b))
                 call: f.b.a.a.a.e0.r3.<init>(f.b.a.a.a.n0.j0$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.p(f.b.b.a.g):f.b.b.f.a.u in method: f.b.a.a.a.e0.p2.a(com.google.android.material.chip.ChipGroup, int):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.r3, state: NOT_LOADED
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
            @Override // com.google.android.material.chip.ChipGroup.d
            public final void a(com.google.android.material.chip.ChipGroup r2, int r3) {
                /*
                    r1 = this;
                    f.b.a.a.a.e0.w6 r2 = f.b.a.a.a.e0.w6.this
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r2 = r2.b0
                    r0 = 2131362074(0x7f0a011a, float:1.8343918E38)
                    if (r3 == r0) goto L_0x0014
                    r0 = 2131362350(0x7f0a022e, float:1.8344478E38)
                    if (r3 == r0) goto L_0x0011
                    f.b.a.a.a.n0.j0$b r3 = f.b.a.a.a.n0.j0.b.UNSET
                    goto L_0x0016
                L_0x0011:
                    f.b.a.a.a.n0.j0$b r3 = f.b.a.a.a.n0.j0.b.WITHHELD
                    goto L_0x0016
                L_0x0014:
                    f.b.a.a.a.n0.j0$b r3 = f.b.a.a.a.n0.j0.b.YES
                L_0x0016:
                    f.b.a.a.a.e0.r3 r0 = new f.b.a.a.a.e0.r3
                    r0.<init>(r3)
                    r2.p(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.p2.a(com.google.android.material.chip.ChipGroup, int):void");
            }
        });
        this.k0.f2442d.addTextChangedListener(new v6(this));
        if (!this.b0.i()) {
            this.k0.s.setVisibility(0);
        }
        q<Long> N0 = N0("ShareDiagnosisUploadFragment.DATE_PICKER_TAG");
        if (N0 != null) {
            N0.m0.clear();
            N0.m0.add(new j2(this));
        }
        this.k0.r.setOnCheckedChangeListener(new ChipGroup.d() { // from class: f.b.a.a.a.e0.o2
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel : 0x002a: IGET  (r2v2 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel A[REMOVE]) = (r2v1 'w6Var' f.b.a.a.a.e0.w6) f.b.a.a.a.e0.e6.b0 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (wrap: f.b.a.a.a.e0.g3 : 0x002e: CONSTRUCTOR  (r0v1 f.b.a.a.a.e0.g3 A[REMOVE]) = (r3v1 'eVar' f.b.a.a.a.n0.j0$e) call: f.b.a.a.a.e0.g3.<init>(f.b.a.a.a.n0.j0$e):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.p(f.b.b.a.g):f.b.b.f.a.u in method: f.b.a.a.a.e0.o2.a(com.google.android.material.chip.ChipGroup, int):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.g3, state: NOT_LOADED
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
            @Override // com.google.android.material.chip.ChipGroup.d
            public final void a(com.google.android.material.chip.ChipGroup r2, int r3) {
                /*
                    r1 = this;
                    f.b.a.a.a.e0.w6 r2 = f.b.a.a.a.e0.w6.this
                    java.util.Objects.requireNonNull(r2)
                    r0 = -1
                    if (r3 == r0) goto L_0x0028
                    r0 = 2131362215(0x7f0a01a7, float:1.8344204E38)
                    if (r3 == r0) goto L_0x0025
                    r0 = 2131362351(0x7f0a022f, float:1.834448E38)
                    if (r3 == r0) goto L_0x0022
                    r0 = 2131362437(0x7f0a0285, float:1.8344655E38)
                    if (r3 != r0) goto L_0x001a
                    f.b.a.a.a.n0.j0$e r3 = f.b.a.a.a.n0.j0.e.TRAVELED
                    goto L_0x002a
                L_0x001a:
                    java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                    java.lang.String r3 = "Failed to map checked button to travel status"
                    r2.<init>(r3)
                    throw r2
                L_0x0022:
                    f.b.a.a.a.n0.j0$e r3 = f.b.a.a.a.n0.j0.e.NO_ANSWER
                    goto L_0x002a
                L_0x0025:
                    f.b.a.a.a.n0.j0$e r3 = f.b.a.a.a.n0.j0.e.NOT_TRAVELED
                    goto L_0x002a
                L_0x0028:
                    f.b.a.a.a.n0.j0$e r3 = f.b.a.a.a.n0.j0.e.NOT_ATTEMPTED
                L_0x002a:
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r2 = r2.b0
                    f.b.a.a.a.e0.g3 r0 = new f.b.a.a.a.e0.g3
                    r0.<init>(r3)
                    r2.p(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.o2.a(com.google.android.material.chip.ChipGroup, int):void");
            }
        });
        this.k0.f2446h.setEnabled(false);
        this.k0.f2446h.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w6 w6Var = w6.this;
                if (w6Var.b0.m.a()) {
                    w6.l0.a("Submitting diagnosis keys...");
                    w6Var.b0.w();
                    return;
                }
                m.e.Z0(w6Var.F, w6Var.F(R.string.share_error_no_internet));
            }
        });
        this.b0.o.f(H(), new t() { // from class: f.b.a.a.a.e0.e2
            @Override // e.r.t
            public final void a(Object obj) {
                boolean z;
                w6 w6Var = w6.this;
                Objects.requireNonNull(w6Var);
                if (((Boolean) obj).booleanValue()) {
                    w6Var.k0.f2446h.setText("");
                    z = false;
                    w6Var.k0.f2446h.setEnabled(false);
                    w6Var.k0.f2449k.setVisibility(0);
                } else {
                    z = true;
                    w6Var.k0.f2446h.setEnabled(true);
                    w6Var.k0.f2446h.setText(R.string.btn_share);
                    w6Var.k0.f2449k.setVisibility(4);
                }
                w6Var.k0.f2442d.setEnabled(z);
                w6Var.k0.n.setEnabled(z);
                w6Var.k0.q.setEnabled(z);
                w6Var.k0.f2445g.setEnabled(z);
                w6Var.k0.o.setEnabled(z);
            }
        });
        new i0(this.b0.f(), this.b0.u).n(H(), new i0.a() { // from class: f.b.a.a.a.e0.f2
            @Override // f.b.a.a.a.t.i0.a
            public final void a(Object obj, Object obj2) {
                w6 w6Var = w6.this;
                j0 j0Var = (j0) obj;
                Boolean bool = (Boolean) obj2;
                Objects.requireNonNull(w6Var);
                if (bool != null) {
                    ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.UPLOAD;
                    ShareDiagnosisViewModel shareDiagnosisViewModel = w6Var.b0;
                    k6 k6Var = shareDiagnosisViewModel.L;
                    boolean s = shareDiagnosisViewModel.s(w6Var.B());
                    boolean booleanValue = bool.booleanValue();
                    w6Var.b0.l(m.e.x0(bVar, j0Var, k6Var, s, l.c(Boolean.valueOf(booleanValue)), w6Var.v0()));
                }
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        m.e.X0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.UPLOAD)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.a2
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                  (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.m0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.m0 A[REMOVE]) = (r0v0 'w6Var' f.b.a.a.a.e0.w6) f.b.a.a.a.e0.w6.k0 f.b.a.a.a.u.m0)
                 f.b.a.a.a.u.m0.j android.widget.Button)
                  (wrap: f.b.a.a.a.e0.n2 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.n2 A[REMOVE]) = 
                  (r0v0 'w6Var' f.b.a.a.a.e0.w6)
                  (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.a2 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.a2.b android.view.View)
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.n2.<init>(f.b.a.a.a.e0.w6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.a2.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.n2, state: NOT_LOADED
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
                    f.b.a.a.a.e0.w6 r0 = f.b.a.a.a.e0.w6.this
                    android.view.View r1 = r4.b
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                    f.b.a.a.a.u.m0 r2 = r0.k0
                    android.widget.Button r2 = r2.f2448j
                    f.b.a.a.a.e0.n2 r3 = new f.b.a.a.a.e0.n2
                    r3.<init>(r0, r1, r5)
                    r2.setOnClickListener(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.a2.a(java.lang.Object):void");
            }
        });
        this.b0.r.f(H(), new t() { // from class: f.b.a.a.a.e0.l2
            @Override // e.r.t
            public final void a(Object obj) {
                m.e.Z0(w6.this.F, (String) obj);
            }
        });
        this.b0.s.f(H(), new t(t0(new d(), new b() { // from class: f.b.a.a.a.e0.b2
            @Override // e.a.e.b
            public final void a(Object obj) {
                w6 w6Var = w6.this;
                Objects.requireNonNull(w6Var);
                if (((e.a.e.a) obj).b == -1) {
                    w6Var.b0.w();
                    return;
                }
                ShareDiagnosisViewModel shareDiagnosisViewModel2 = w6Var.b0;
                shareDiagnosisViewModel2.p(new b5(shareDiagnosisViewModel2, j0.c.NOT_ATTEMPTED));
            }
        })) { // from class: f.b.a.a.a.e0.k2
            public final /* synthetic */ c b;

            {
                this.b = r2;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                w6 w6Var = w6.this;
                c<e> cVar = this.b;
                w6Var.b0.u((f.b.a.c.b.l.b) obj, cVar);
            }
        });
        this.b0.f().f(H(), new t() { // from class: f.b.a.a.a.e0.c2
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00cf: INVOKE  
                  (wrap: com.google.android.material.chip.Chip : 0x00c8: IGET  (r2v4 com.google.android.material.chip.Chip A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.m0 : 0x00c6: IGET  (r2v3 f.b.a.a.a.u.m0 A[REMOVE]) = (r0v0 'w6Var' f.b.a.a.a.e0.w6) f.b.a.a.a.e0.w6.k0 f.b.a.a.a.u.m0)
                 f.b.a.a.a.u.m0.d com.google.android.material.chip.Chip)
                  (wrap: f.b.a.a.a.e0.g2 : 0x00cc: CONSTRUCTOR  (r3v4 f.b.a.a.a.e0.g2 A[REMOVE]) = (r0v0 'w6Var' f.b.a.a.a.e0.w6), (r11v1 'j0Var' f.b.a.a.a.n0.j0) call: f.b.a.a.a.e0.g2.<init>(f.b.a.a.a.e0.w6, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.CheckBox.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.c2.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.g2, state: NOT_LOADED
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
            public final void a(java.lang.Object r11) {
                /*
                // Method dump skipped, instructions count: 343
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.c2.a(java.lang.Object):void");
            }
        });
    }
}
