package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.common.ui.NoAutofillTextInputEditText;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.t.w;
import f.b.a.a.a.u.h0;
import f.b.a.e.l.q;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class n6 extends e6 {
    public final TextWatcher i0 = new a();
    public final TextWatcher j0 = new b();
    public h0 k0;

    /* loaded from: classes.dex */
    public class a extends w {
        public a() {
            n6.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            n6.this.k0.f2429h.setVisibility(8);
            n6 n6Var = n6.this;
            n6Var.Y0(n6Var.k0.o.isChecked());
        }
    }

    /* loaded from: classes.dex */
    public class b extends w {
        public b() {
            n6.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            n6 n6Var = n6.this;
            n6Var.Y0(n6Var.k0.o.isChecked());
        }
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1
    public boolean I0() {
        super.I0();
        X0();
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_get_code, viewGroup, false);
        int i2 = R.id.btn_previous;
        Button button = (Button) inflate.findViewById(R.id.btn_previous);
        if (button != null) {
            i2 = R.id.btn_send_code;
            Button button2 = (Button) inflate.findViewById(R.id.btn_send_code);
            if (button2 != null) {
                i2 = R.id.button_container;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
                if (linearLayout != null) {
                    i2 = 16908332;
                    ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                    if (imageButton != null) {
                        i2 = R.id.learn_more_button;
                        Button button3 = (Button) inflate.findViewById(R.id.learn_more_button);
                        if (button3 != null) {
                            i2 = R.id.phone_number;
                            NoAutofillTextInputEditText noAutofillTextInputEditText = (NoAutofillTextInputEditText) inflate.findViewById(R.id.phone_number);
                            if (noAutofillTextInputEditText != null) {
                                i2 = R.id.phone_number_error;
                                TextView textView = (TextView) inflate.findViewById(R.id.phone_number_error);
                                if (textView != null) {
                                    i2 = R.id.phone_number_help;
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.phone_number_help);
                                    if (textView2 != null) {
                                        i2 = R.id.send_code_switcher;
                                        ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.send_code_switcher);
                                        if (viewSwitcher != null) {
                                            i2 = R.id.share_diagnosis_scroll_view;
                                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                                            if (nestedScrollView != null) {
                                                i2 = R.id.step_x_of_y_text_view;
                                                TextView textView3 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                if (textView3 != null) {
                                                    i2 = R.id.test_date;
                                                    NoAutofillTextInputEditText noAutofillTextInputEditText2 = (NoAutofillTextInputEditText) inflate.findViewById(R.id.test_date);
                                                    if (noAutofillTextInputEditText2 != null) {
                                                        i2 = R.id.test_date_help;
                                                        TextView textView4 = (TextView) inflate.findViewById(R.id.test_date_help);
                                                        if (textView4 != null) {
                                                            i2 = R.id.tested_for_covid_checkbox;
                                                            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.tested_for_covid_checkbox);
                                                            if (checkBox != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                                                this.k0 = new h0(linearLayout2, button, button2, linearLayout, imageButton, button3, noAutofillTextInputEditText, textView, textView2, viewSwitcher, nestedScrollView, textView3, noAutofillTextInputEditText2, textView4, checkBox);
                                                                return linearLayout2;
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

    public final void X0() {
        String str = "";
        String obj = this.k0.f2428g.getText() == null ? str : this.k0.f2428g.getText().toString();
        if (this.k0.m.getText() != null) {
            str = this.k0.m.getText().toString();
        }
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", obj);
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", str);
    }

    public final void Y0(boolean z) {
        h0 h0Var = this.k0;
        h0Var.c.setEnabled(z && !TextUtils.isEmpty(h0Var.m.getText()) && !TextUtils.isEmpty(this.k0.f2428g.getText()));
    }

    @Override // e.o.a.m
    public void e0() {
        this.D = true;
        this.k0.f2428g.removeTextChangedListener(this.i0);
        this.k0.m.removeTextChangedListener(this.j0);
    }

    @Override // f.b.a.a.a.e0.e6, e.o.a.m
    public void i0() {
        super.i0();
        this.k0.f2428g.addTextChangedListener(this.i0);
        this.k0.m.addTextChangedListener(this.j0);
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.get_verification_code_title);
        h0 h0Var = this.k0;
        S0(h0Var.f2432k, h0Var.f2425d);
        if (!TextUtils.isEmpty(F(R.string.self_report_phone_number))) {
            this.k0.f2430i.setText(R.string.self_report_phone_number);
        }
        if (!TextUtils.isEmpty(F(R.string.self_report_test_date))) {
            this.k0.n.setText(R.string.self_report_test_date);
        }
        if (!TextUtils.isEmpty(F(R.string.self_report_checkbox))) {
            this.k0.o.setText(R.string.self_report_checkbox);
        }
        this.k0.f2428g.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: f.b.a.a.a.e0.e1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                n6 n6Var = n6.this;
                Objects.requireNonNull(n6Var);
                if (i2 != 6) {
                    return false;
                }
                n6Var.k0.f2428g.clearFocus();
                m.e.Y0(n6Var.v0(), n6Var.k0.f2428g);
                return true;
            }
        });
        this.k0.m.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                n6 n6Var = n6.this;
                if (n6Var.N0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG") == null) {
                    q<Long> M0 = n6Var.M0(n6Var.f0.c());
                    M0.m0.add(new f1(n6Var));
                    M0.K0(n6Var.w(), "ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
                }
            }
        });
        this.k0.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: f.b.a.a.a.e0.z0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                n6.this.Y0(z);
            }
        });
        this.k0.c.setOnClickListener(new View.OnClickListener(view) { // from class: f.b.a.a.a.e0.h1
            public final /* synthetic */ View c;

            {
                this.c = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x010e: INVOKE  (r1v15 'y' f.b.b.f.a.l) = 
                  (wrap: f.b.b.f.a.l : 0x0103: INVOKE  (r1v14 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00f8: INVOKE  (r1v13 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00ed: INVOKE  (r1v12 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00e2: INVOKE  (r1v11 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u<l.b.a.e> : 0x00de: INVOKE  (r1v10 f.b.b.f.a.u<l.b.a.e> A[REMOVE]) = 
                  (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$e : 0x00dc: SGET  (r1v9 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$e A[REMOVE]) =  com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.S com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$e)
                 type: VIRTUAL call: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.d(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$e):f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.y4 : 0x00e8: CONSTRUCTOR  (r2v14 f.b.a.a.a.e0.y4 A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.y4.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00eb: IGET  (r3v5 java.util.concurrent.ExecutorService A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.c3 : 0x00f3: CONSTRUCTOR  (r2v15 f.b.a.a.a.e0.c3 A[REMOVE]) = 
                  (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (r0v20 'a3' f.b.a.a.a.z.i0)
                 call: f.b.a.a.a.e0.c3.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel, f.b.a.a.a.z.i0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00f6: IGET  (r3v6 java.util.concurrent.ExecutorService A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.m3 : 0x00fe: CONSTRUCTOR  (r2v16 f.b.a.a.a.e0.m3 A[REMOVE]) = 
                  (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel)
                  (r0v20 'a3' f.b.a.a.a.z.i0)
                 call: f.b.a.a.a.e0.m3.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel, f.b.a.a.a.z.i0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0101: IGET  (r3v7 java.util.concurrent.ExecutorService A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.e0.i4 : 0x0109: CONSTRUCTOR  (r2v17 f.b.a.a.a.e0.i4 A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) call: f.b.a.a.a.e0.i4.<init>(com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x010c: IGET  (r3v8 java.util.concurrent.ExecutorService A[REMOVE]) = (r10v2 'shareDiagnosisViewModel' com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel) com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.z java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.e0.h1.onClick(android.view.View):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.y4, state: NOT_LOADED
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
                	... 28 more
                */
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View r10) {
                /*
                // Method dump skipped, instructions count: 400
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.h1.onClick(android.view.View):void");
            }
        });
        this.k0.f2427f.setOnClickListener(new View.OnClickListener(view) { // from class: f.b.a.a.a.e0.k1
            public final /* synthetic */ View c;

            {
                this.c = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.a(this.c, n6.this.F(R.string.en_reporting_info_link));
            }
        });
        this.b0.f().f(H(), new t() { // from class: f.b.a.a.a.e0.c1
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                  (wrap: android.widget.ImageButton : 0x0006: IGET  (r1v1 android.widget.ImageButton A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.h0 : 0x0004: IGET  (r1v0 f.b.a.a.a.u.h0 A[REMOVE]) = (r0v0 'n6Var' f.b.a.a.a.e0.n6) f.b.a.a.a.e0.n6.k0 f.b.a.a.a.u.h0)
                 f.b.a.a.a.u.h0.e android.widget.ImageButton)
                  (wrap: f.b.a.a.a.e0.d1 : 0x000a: CONSTRUCTOR  (r2v0 f.b.a.a.a.e0.d1 A[REMOVE]) = 
                  (r0v0 'n6Var' f.b.a.a.a.e0.n6)
                  (wrap: f.b.a.a.a.n0.j0 : 0x0002: CHECK_CAST (r4v1 f.b.a.a.a.n0.j0 A[REMOVE]) = (f.b.a.a.a.n0.j0) (r4v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.d1.<init>(f.b.a.a.a.e0.n6, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.c1.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.d1, state: NOT_LOADED
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
                    f.b.a.a.a.e0.n6 r0 = f.b.a.a.a.e0.n6.this
                    f.b.a.a.a.n0.j0 r4 = (f.b.a.a.a.n0.j0) r4
                    f.b.a.a.a.u.h0 r1 = r0.k0
                    android.widget.ImageButton r1 = r1.f2426e
                    f.b.a.a.a.e0.d1 r2 = new f.b.a.a.a.e0.d1
                    r2.<init>(r0, r4)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.c1.a(java.lang.Object):void");
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        m.e.X0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.GET_CODE)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.j1
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                  (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.h0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.h0 A[REMOVE]) = (r0v0 'n6Var' f.b.a.a.a.e0.n6) f.b.a.a.a.e0.n6.k0 f.b.a.a.a.u.h0)
                 f.b.a.a.a.u.h0.b android.widget.Button)
                  (wrap: f.b.a.a.a.e0.y0 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.y0 A[REMOVE]) = 
                  (r0v0 'n6Var' f.b.a.a.a.e0.n6)
                  (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.j1 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.j1.b android.view.View)
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.y0.<init>(f.b.a.a.a.e0.n6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.j1.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.y0, state: NOT_LOADED
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
                    f.b.a.a.a.e0.n6 r0 = f.b.a.a.a.e0.n6.this
                    android.view.View r1 = r4.b
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                    f.b.a.a.a.u.h0 r2 = r0.k0
                    android.widget.Button r2 = r2.b
                    f.b.a.a.a.e0.y0 r3 = new f.b.a.a.a.e0.y0
                    r3.<init>(r0, r1, r5)
                    r2.setOnClickListener(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.j1.a(java.lang.Object):void");
            }
        });
        this.b0.o.f(H(), new t() { // from class: f.b.a.a.a.e0.b1
            @Override // e.r.t
            public final void a(Object obj) {
                n6.this.k0.f2431j.setDisplayedChild(((Boolean) obj).booleanValue() ? 1 : 0);
            }
        });
        this.b0.G.f(H(), new t() { // from class: f.b.a.a.a.e0.x0
            @Override // e.r.t
            public final void a(Object obj) {
                n6 n6Var = n6.this;
                String str = (String) obj;
                Objects.requireNonNull(n6Var);
                if (!TextUtils.isEmpty(str)) {
                    String F = n6Var.F(R.string.learn_more);
                    if (str.contains(F)) {
                        TextView textView = n6Var.k0.f2429h;
                        String F2 = n6Var.F(R.string.en_reporting_info_link);
                        a aVar = b.a;
                        textView.setText(m0.b(new f.b.a.a.a.o0.a(F2), str, F));
                        n6Var.k0.f2429h.setMovementMethod(LinkMovementMethod.getInstance());
                    } else {
                        n6Var.k0.f2429h.setText(str);
                    }
                    n6Var.k0.f2429h.setVisibility(0);
                    n6Var.k0.c.setEnabled(false);
                    return;
                }
                n6Var.k0.f2429h.setVisibility(8);
            }
        });
        this.b0.F.f(H(), new t() { // from class: f.b.a.a.a.e0.w0
            @Override // e.r.t
            public final void a(Object obj) {
                m.e.Z0(n6.this.F, (String) obj);
            }
        });
        q<Long> N0 = N0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
        if (N0 != null) {
            N0.m0.clear();
            N0.m0.add(new f1(this));
        }
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", null).f(H(), new t() { // from class: f.b.a.a.a.e0.i1
            @Override // e.r.t
            public final void a(Object obj) {
                n6 n6Var = n6.this;
                String str = (String) obj;
                Objects.requireNonNull(n6Var);
                if (str != null) {
                    n6Var.k0.f2428g.setText(str);
                }
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", null).f(H(), new t() { // from class: f.b.a.a.a.e0.a1
            @Override // e.r.t
            public final void a(Object obj) {
                n6 n6Var = n6.this;
                String str = (String) obj;
                Objects.requireNonNull(n6Var);
                if (str != null) {
                    n6Var.k0.m.setText(str);
                }
            }
        });
        this.b0.g().f(H(), new t() { // from class: f.b.a.a.a.e0.l1
            @Override // e.r.t
            public final void a(Object obj) {
                n6 n6Var = n6.this;
                Pair pair = (Pair) obj;
                Objects.requireNonNull(n6Var);
                n6Var.k0.f2433l.setText(n6Var.G(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
            }
        });
    }
}
