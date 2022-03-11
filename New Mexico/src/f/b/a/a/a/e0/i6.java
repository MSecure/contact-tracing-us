package f.b.a.a.a.e0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.common.ui.NoAutofillTextInputEditText;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import e.b.a.m;
import e.r.t;
import e.r.y;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.w;
import f.b.a.a.a.u.g0;
import f.b.b.a.l;
import f.b.b.a.o;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Locale;
import java.util.Objects;
/* loaded from: classes.dex */
public class i6 extends s5 {
    public static final /* synthetic */ int o0;
    public g0 l0;
    public final TextWatcher k0 = new a();
    public String m0 = null;
    public BroadcastReceiver n0 = null;

    /* loaded from: classes.dex */
    public class a extends w {
        public a() {
            i6.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            g0 g0Var = i6.this.l0;
            g0Var.n.setEnabled(!TextUtils.isEmpty(g0Var.f2424l.getText()));
            if (i6.this.l0.f2424l.getText() == null) {
                str = "";
            } else {
                str = i6.this.l0.f2424l.getText().toString();
            }
            i6 i6Var = i6.this;
            i6Var.l0.f2418f.setDisplayedChild(str.equals(i6Var.m0) ? 1 : 0);
            i6 i6Var2 = i6.this;
            i6Var2.l0.m.setVisibility(str.equals(i6Var2.m0) ? 0 : 8);
            if (str.equals(i6.this.m0)) {
                i6.this.l0.f2422j.setVisibility(8);
                i6.this.b0.E.j("");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        public final /* synthetic */ EditText a;

        public b(i6 i6Var, EditText editText) {
            this.a = editText;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            l<String> c = f.b.a.a.a.t.g0.c(intent.getData());
            if (c.b()) {
                this.a.setText(c.a());
                EditText editText = this.a;
                editText.setSelection(editText.getText().length());
            }
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
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_code, viewGroup, false);
        int i2 = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
        if (linearLayout != null) {
            i2 = R.id.code_help;
            TextView textView = (TextView) inflate.findViewById(R.id.code_help);
            if (textView != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    i2 = R.id.learn_more_button;
                    Button button = (Button) inflate.findViewById(R.id.learn_more_button);
                    if (button != null) {
                        i2 = R.id.share_advance_switcher;
                        ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.share_advance_switcher);
                        if (viewSwitcher != null) {
                            i2 = R.id.share_diagnosis_scroll_view;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                            if (nestedScrollView != null) {
                                i2 = R.id.share_next_button;
                                Button button2 = (Button) inflate.findViewById(R.id.share_next_button);
                                if (button2 != null) {
                                    i2 = R.id.share_previous_button;
                                    Button button3 = (Button) inflate.findViewById(R.id.share_previous_button);
                                    if (button3 != null) {
                                        i2 = R.id.share_test_error;
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.share_test_error);
                                        if (linearLayout2 != null) {
                                            i2 = R.id.share_test_error_text;
                                            TextView textView2 = (TextView) inflate.findViewById(R.id.share_test_error_text);
                                            if (textView2 != null) {
                                                i2 = R.id.share_test_identifier;
                                                NoAutofillTextInputEditText noAutofillTextInputEditText = (NoAutofillTextInputEditText) inflate.findViewById(R.id.share_test_identifier);
                                                if (noAutofillTextInputEditText != null) {
                                                    i2 = R.id.share_test_verified;
                                                    LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.share_test_verified);
                                                    if (linearLayout3 != null) {
                                                        i2 = R.id.share_verify_button;
                                                        Button button4 = (Button) inflate.findViewById(R.id.share_verify_button);
                                                        if (button4 != null) {
                                                            i2 = R.id.share_verify_switcher;
                                                            ViewSwitcher viewSwitcher2 = (ViewSwitcher) inflate.findViewById(R.id.share_verify_switcher);
                                                            if (viewSwitcher2 != null) {
                                                                i2 = R.id.step_x_of_y_text_view;
                                                                TextView textView3 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                                if (textView3 != null) {
                                                                    i2 = R.id.verify_mask;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.verify_mask);
                                                                    if (relativeLayout != null) {
                                                                        i2 = R.id.verify_progress_indicator;
                                                                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) inflate.findViewById(R.id.verify_progress_indicator);
                                                                        if (circularProgressIndicator != null) {
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
                                                                            this.l0 = new g0(relativeLayout2, linearLayout, textView, imageButton, button, viewSwitcher, nestedScrollView, button2, button3, linearLayout2, textView2, noAutofillTextInputEditText, linearLayout3, button4, viewSwitcher2, textView3, relativeLayout, circularProgressIndicator);
                                                                            return relativeLayout2;
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
        this.l0 = null;
    }

    public final void X0() {
        String obj = this.l0.f2424l.getText() == null ? "" : this.l0.f2424l.getText().toString();
        boolean z = false;
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.valueOf(this.l0.f2422j.getVisibility() == 0));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        if (this.l0.m.getVisibility() == 0) {
            z = true;
        }
        shareDiagnosisViewModel.K.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", Boolean.valueOf(z));
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", Integer.valueOf(this.l0.f2418f.getDisplayedChild()));
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.valueOf(this.l0.f2424l.isEnabled()));
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", obj);
        this.b0.K.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", this.m0);
        this.b0.Q = true;
    }

    @Override // e.o.a.m
    public void e0() {
        this.D = true;
        this.l0.f2424l.removeTextChangedListener(this.k0);
        if (this.n0 != null) {
            v0().unregisterReceiver(this.n0);
            this.n0 = null;
        }
    }

    @Override // f.b.a.a.a.e0.e6, e.o.a.m
    public void i0() {
        super.i0();
        this.l0.f2424l.addTextChangedListener(this.k0);
        if (m.e.S0(v0()) && this.n0 == null) {
            NoAutofillTextInputEditText noAutofillTextInputEditText = this.l0.f2424l;
            String lowerCase = "us-nm.en.express".toLowerCase(Locale.ROOT);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.nearby.exposurenotification.ACTION_VERIFICATION_LINK");
            intentFilter.addDataScheme("https");
            intentFilter.addDataAuthority(lowerCase, null);
            this.n0 = new b(this, noAutofillTextInputEditText);
            v0().registerReceiver(this.n0, intentFilter, "com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK", null);
        }
    }

    @Override // f.b.a.a.a.e0.e6, e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putBoolean("STATE_UPDATE_APP_DIALOG_OPEN", this.e0);
        X0();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015f  */
    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void m0(View view, Bundle bundle) {
        String str;
        l5 l5Var;
        int i2;
        RelativeLayout relativeLayout;
        super.m0(view, bundle);
        u0().setTitle(R.string.verify_test_result_title);
        g0 g0Var = this.l0;
        S0(g0Var.f2419g, g0Var.b);
        g0 g0Var2 = this.l0;
        NoAutofillTextInputEditText noAutofillTextInputEditText = g0Var2.f2424l;
        LinearLayout linearLayout = g0Var2.m;
        LinearLayout linearLayout2 = g0Var2.f2422j;
        ViewSwitcher viewSwitcher = g0Var2.f2418f;
        if (g0Var2.f2420h.isAccessibilityFocused()) {
            this.l0.f2420h.sendAccessibilityEvent(32);
        }
        this.l0.n.setEnabled(!TextUtils.isEmpty(noAutofillTextInputEditText.getText()));
        if (k6.SELF_REPORT.equals(this.b0.L)) {
            this.l0.c.setText(G(R.string.enter_code_help, F(R.string.health_authority_name)));
        }
        this.l0.n.setOnClickListener(new View.OnClickListener(view, noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.d0
            public final /* synthetic */ View c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ EditText f2221d;

            {
                this.c = r2;
                this.f2221d = r3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i6 i6Var = i6.this;
                View view3 = this.c;
                EditText editText = this.f2221d;
                m.e.Y0(i6Var.v0(), view3);
                i6Var.b0.v(editText.getText().toString(), false);
            }
        });
        this.b0.o.f(H(), new t() { // from class: f.b.a.a.a.e0.g0
            @Override // e.r.t
            public final void a(Object obj) {
                i6.this.l0.o.setDisplayedChild(((Boolean) obj).booleanValue() ? 1 : 0);
            }
        });
        this.b0.v.f(H(), new t() { // from class: f.b.a.a.a.e0.o0
            @Override // e.r.t
            public final void a(Object obj) {
                i6 i6Var = i6.this;
                Objects.requireNonNull(i6Var);
                if (((Boolean) obj).booleanValue()) {
                    i6Var.l0.q.setVisibility(8);
                    i6Var.l0.r.b();
                }
            }
        });
        this.b0.f().f(H(), new t(linearLayout2, linearLayout, noAutofillTextInputEditText, viewSwitcher, view) { // from class: f.b.a.a.a.e0.k0
            public final /* synthetic */ LinearLayout b;
            public final /* synthetic */ LinearLayout c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ EditText f2225d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ViewSwitcher f2226e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ View f2227f;

            {
                this.b = r2;
                this.c = r3;
                this.f2225d = r4;
                this.f2226e = r5;
                this.f2227f = r6;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006f: INVOKE  
                  (wrap: android.widget.ImageButton : 0x0068: IGET  (r1v2 android.widget.ImageButton A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.g0 : 0x0066: IGET  (r1v1 f.b.a.a.a.u.g0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6) f.b.a.a.a.e0.i6.l0 f.b.a.a.a.u.g0)
                 f.b.a.a.a.u.g0.d android.widget.ImageButton)
                  (wrap: f.b.a.a.a.e0.b0 : 0x006c: CONSTRUCTOR  (r2v1 f.b.a.a.a.e0.b0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6), (r5v0 'view2' android.view.View), (r11v1 'j0Var' f.b.a.a.a.n0.j0) call: f.b.a.a.a.e0.b0.<init>(f.b.a.a.a.e0.i6, android.view.View, f.b.a.a.a.n0.j0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.ImageButton.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.k0.a(java.lang.Object):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.b0, state: NOT_LOADED
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
                    r10 = this;
                    f.b.a.a.a.e0.i6 r0 = f.b.a.a.a.e0.i6.this
                    android.widget.LinearLayout r1 = r10.b
                    android.widget.LinearLayout r2 = r10.c
                    android.widget.EditText r3 = r10.f2225d
                    android.widget.ViewSwitcher r4 = r10.f2226e
                    android.view.View r5 = r10.f2227f
                    f.b.a.a.a.n0.j0 r11 = (f.b.a.a.a.n0.j0) r11
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r6 = r0.b0
                    boolean r7 = r6.Q
                    r8 = 0
                    if (r7 != 0) goto L_0x0064
                    boolean r6 = f.b.a.a.a.e0.o5.b(r11)
                    r7 = 8
                    if (r6 == 0) goto L_0x005d
                    f.b.a.a.a.n0.j0$c r6 = f.b.a.a.a.n0.j0.c.SHARED
                    f.b.a.a.a.n0.j0$c r9 = r11.m()
                    boolean r6 = r6.equals(r9)
                    if (r6 != 0) goto L_0x005d
                    java.lang.String r6 = r11.p()
                    r0.m0 = r6
                    r1.setVisibility(r7)
                    r2.setVisibility(r8)
                    r1 = 2131822446(0x7f11076e, float:1.9277664E38)
                    java.lang.String r1 = r0.F(r1)
                    r2.announceForAccessibility(r1)
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r1 = r0.b0
                    boolean r1 = r1.P
                    r3.setEnabled(r1)
                    java.lang.String r1 = r11.p()
                    r3.setText(r1)
                    android.text.Editable r1 = r3.getText()
                    int r1 = r1.length()
                    r3.setSelection(r1)
                    r1 = 1
                    r4.setDisplayedChild(r1)
                    goto L_0x0066
                L_0x005d:
                    r2.setVisibility(r7)
                    r4.setDisplayedChild(r8)
                    goto L_0x0066
                L_0x0064:
                    r6.Q = r8
                L_0x0066:
                    f.b.a.a.a.u.g0 r1 = r0.l0
                    android.widget.ImageButton r1 = r1.f2416d
                    f.b.a.a.a.e0.b0 r2 = new f.b.a.a.a.e0.b0
                    r2.<init>(r0, r5, r11)
                    r1.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.k0.a(java.lang.Object):void");
            }
        });
        this.l0.f2417e.setOnClickListener(new View.OnClickListener(view) { // from class: f.b.a.a.a.e0.f0
            public final /* synthetic */ View c;

            {
                this.c = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i6 i6Var = i6.this;
                b.a(this.c, i6Var.F(k6.SELF_REPORT.equals(i6Var.b0.L) ? R.string.en_reporting_info_link : R.string.share_verification_code_learn_more_url));
            }
        });
        this.b0.r.f(H(), new t() { // from class: f.b.a.a.a.e0.q0
            @Override // e.r.t
            public final void a(Object obj) {
                m.e.Z0(i6.this.F, (String) obj);
            }
        });
        this.b0.E.f(H(), new t(linearLayout2, linearLayout, noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.p0
            public final /* synthetic */ LinearLayout b;
            public final /* synthetic */ LinearLayout c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ EditText f2233d;

            {
                this.b = r2;
                this.c = r3;
                this.f2233d = r4;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                i6 i6Var = i6.this;
                LinearLayout linearLayout3 = this.b;
                LinearLayout linearLayout4 = this.c;
                EditText editText = this.f2233d;
                String str2 = (String) obj;
                Objects.requireNonNull(i6Var);
                if (TextUtils.isEmpty(str2)) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                linearLayout4.setVisibility(8);
                linearLayout3.setVisibility(0);
                i6Var.l0.f2423k.setText(str2);
                editText.setEnabled(true);
                i6Var.l0.f2418f.setDisplayedChild(0);
            }
        });
        Bundle bundle2 = this.v.f1812g;
        if (bundle2 == null) {
            str = null;
        } else {
            str = bundle2.getString("BaseFragment.CODE_FROM_DEEP_LINK", null);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (f.b.b.a.t.a(str)) {
            l5Var = new l5(true, f.b.b.a.a.b);
        } else if (shareDiagnosisViewModel.O) {
            l5Var = new l5(true, f.b.b.a.a.b);
        } else {
            shareDiagnosisViewModel.O = true;
            shareDiagnosisViewModel.K.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", str);
            shareDiagnosisViewModel.Q = true;
            shareDiagnosisViewModel.v(str, true);
            Objects.requireNonNull(str);
            l5Var = new l5(false, new o(str));
            if (l5Var.b.b()) {
                noAutofillTextInputEditText.setText(l5Var.b.a());
                noAutofillTextInputEditText.setSelection(noAutofillTextInputEditText.getText().length());
            }
            if (!l5Var.a) {
                this.l0.r.b();
                relativeLayout = this.l0.q;
                i2 = 8;
            } else {
                CircularProgressIndicator circularProgressIndicator = this.l0.r;
                if (circularProgressIndicator.f3016f > 0) {
                    circularProgressIndicator.removeCallbacks(circularProgressIndicator.f3022l);
                    circularProgressIndicator.postDelayed(circularProgressIndicator.f3022l, (long) circularProgressIndicator.f3016f);
                } else {
                    circularProgressIndicator.f3022l.run();
                }
                relativeLayout = this.l0.q;
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
            ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.CODE;
            m.e.X0(shareDiagnosisViewModel2.f(), new f4(shareDiagnosisViewModel2, bVar)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.r0
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                      (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                      (wrap: f.b.a.a.a.u.g0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.g0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6) f.b.a.a.a.e0.i6.l0 f.b.a.a.a.u.g0)
                     f.b.a.a.a.u.g0.h android.widget.Button)
                      (wrap: f.b.a.a.a.e0.e0 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.e0 A[REMOVE]) = 
                      (r0v0 'i6Var' f.b.a.a.a.e0.i6)
                      (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.r0 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.r0.b android.view.View)
                      (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                     call: f.b.a.a.a.e0.e0.<init>(f.b.a.a.a.e0.i6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.r0.a(java.lang.Object):void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.e0, state: NOT_LOADED
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
                    	... 9 more
                    */
                @Override // e.r.t
                public final void a(java.lang.Object r5) {
                    /*
                        r4 = this;
                        f.b.a.a.a.e0.i6 r0 = f.b.a.a.a.e0.i6.this
                        android.view.View r1 = r4.b
                        com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                        f.b.a.a.a.u.g0 r2 = r0.l0
                        android.widget.Button r2 = r2.f2420h
                        f.b.a.a.a.e0.e0 r3 = new f.b.a.a.a.e0.e0
                        r3.<init>(r0, r1, r5)
                        r2.setOnClickListener(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.r0.a(java.lang.Object):void");
                }
            });
            ShareDiagnosisViewModel shareDiagnosisViewModel3 = this.b0;
            m.e.X0(shareDiagnosisViewModel3.f(), new t3(shareDiagnosisViewModel3, bVar)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.j0
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                      (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                      (wrap: f.b.a.a.a.u.g0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.g0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6) f.b.a.a.a.e0.i6.l0 f.b.a.a.a.u.g0)
                     f.b.a.a.a.u.g0.i android.widget.Button)
                      (wrap: f.b.a.a.a.e0.h0 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.h0 A[REMOVE]) = 
                      (r0v0 'i6Var' f.b.a.a.a.e0.i6)
                      (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.j0 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.j0.b android.view.View)
                      (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                     call: f.b.a.a.a.e0.h0.<init>(f.b.a.a.a.e0.i6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.j0.a(java.lang.Object):void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.h0, state: NOT_LOADED
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
                    	... 9 more
                    */
                @Override // e.r.t
                public final void a(java.lang.Object r5) {
                    /*
                        r4 = this;
                        f.b.a.a.a.e0.i6 r0 = f.b.a.a.a.e0.i6.this
                        android.view.View r1 = r4.b
                        com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                        f.b.a.a.a.u.g0 r2 = r0.l0
                        android.widget.Button r2 = r2.f2421i
                        f.b.a.a.a.e0.h0 r3 = new f.b.a.a.a.e0.h0
                        r3.<init>(r0, r1, r5)
                        r2.setOnClickListener(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.j0.a(java.lang.Object):void");
                }
            });
            y yVar = this.b0.K;
            Boolean bool = Boolean.FALSE;
            yVar.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool).f(H(), new t(linearLayout2) { // from class: f.b.a.a.a.e0.l0
                public final /* synthetic */ LinearLayout a;

                {
                    this.a = r1;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    LinearLayout linearLayout3 = this.a;
                    int i3 = i6.o0;
                    linearLayout3.setVisibility(((Boolean) obj).booleanValue() ? 0 : 8);
                }
            });
            this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool).f(H(), new t(linearLayout) { // from class: f.b.a.a.a.e0.n0
                public final /* synthetic */ LinearLayout a;

                {
                    this.a = r1;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    LinearLayout linearLayout3 = this.a;
                    int i3 = i6.o0;
                    linearLayout3.setVisibility(((Boolean) obj).booleanValue() ? 0 : 8);
                }
            });
            this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(H(), new t(noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.b
                public final /* synthetic */ EditText a;

                {
                    this.a = r1;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    this.a.setEnabled(((Boolean) obj).booleanValue());
                }
            });
            this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(H(), new t(noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.i0
                public final /* synthetic */ EditText b;

                {
                    this.b = r2;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    i6 i6Var = i6.this;
                    EditText editText = this.b;
                    String str2 = (String) obj;
                    Objects.requireNonNull(i6Var);
                    if (str2 != null) {
                        editText.setText(str2);
                        editText.setSelection(editText.getText().length());
                        i6Var.l0.n.setEnabled(!TextUtils.isEmpty(str2));
                    }
                }
            });
            this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(H(), new t(viewSwitcher) { // from class: f.b.a.a.a.e0.c0
                public final /* synthetic */ ViewSwitcher a;

                {
                    this.a = r1;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    ViewSwitcher viewSwitcher2 = this.a;
                    Integer num = (Integer) obj;
                    int i3 = i6.o0;
                    if (num.intValue() > -1) {
                        viewSwitcher2.setDisplayedChild(num.intValue());
                    }
                }
            });
            this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(H(), new t() { // from class: f.b.a.a.a.e0.m0
                @Override // e.r.t
                public final void a(Object obj) {
                    i6 i6Var = i6.this;
                    String str2 = (String) obj;
                    Objects.requireNonNull(i6Var);
                    if (str2 != null) {
                        i6Var.m0 = str2;
                    }
                }
            });
            this.b0.g().f(H(), new t() { // from class: f.b.a.a.a.e0.s0
                @Override // e.r.t
                public final void a(Object obj) {
                    i6 i6Var = i6.this;
                    Pair pair = (Pair) obj;
                    Objects.requireNonNull(i6Var);
                    i6Var.l0.p.setText(i6Var.G(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
                }
            });
        }
        if (l5Var.b.b()) {
        }
        if (!l5Var.a) {
        }
        relativeLayout.setVisibility(i2);
        ShareDiagnosisViewModel shareDiagnosisViewModel22 = this.b0;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.CODE;
        m.e.X0(shareDiagnosisViewModel22.f(), new f4(shareDiagnosisViewModel22, bVar2)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.r0
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                  (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.g0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.g0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6) f.b.a.a.a.e0.i6.l0 f.b.a.a.a.u.g0)
                 f.b.a.a.a.u.g0.h android.widget.Button)
                  (wrap: f.b.a.a.a.e0.e0 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.e0 A[REMOVE]) = 
                  (r0v0 'i6Var' f.b.a.a.a.e0.i6)
                  (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.r0 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.r0.b android.view.View)
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.e0.<init>(f.b.a.a.a.e0.i6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.r0.a(java.lang.Object):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.e0, state: NOT_LOADED
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
                	... 8 more
                */
            @Override // e.r.t
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    f.b.a.a.a.e0.i6 r0 = f.b.a.a.a.e0.i6.this
                    android.view.View r1 = r4.b
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                    f.b.a.a.a.u.g0 r2 = r0.l0
                    android.widget.Button r2 = r2.f2420h
                    f.b.a.a.a.e0.e0 r3 = new f.b.a.a.a.e0.e0
                    r3.<init>(r0, r1, r5)
                    r2.setOnClickListener(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.r0.a(java.lang.Object):void");
            }
        });
        ShareDiagnosisViewModel shareDiagnosisViewModel32 = this.b0;
        m.e.X0(shareDiagnosisViewModel32.f(), new t3(shareDiagnosisViewModel32, bVar2)).f(H(), new t(view) { // from class: f.b.a.a.a.e0.j0
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                  (wrap: android.widget.Button : 0x0008: IGET  (r2v1 android.widget.Button A[REMOVE]) = 
                  (wrap: f.b.a.a.a.u.g0 : 0x0006: IGET  (r2v0 f.b.a.a.a.u.g0 A[REMOVE]) = (r0v0 'i6Var' f.b.a.a.a.e0.i6) f.b.a.a.a.e0.i6.l0 f.b.a.a.a.u.g0)
                 f.b.a.a.a.u.g0.i android.widget.Button)
                  (wrap: f.b.a.a.a.e0.h0 : 0x000c: CONSTRUCTOR  (r3v0 f.b.a.a.a.e0.h0 A[REMOVE]) = 
                  (r0v0 'i6Var' f.b.a.a.a.e0.i6)
                  (wrap: android.view.View : 0x0002: IGET  (r1v0 android.view.View A[REMOVE]) = (r4v0 'this' f.b.a.a.a.e0.j0 A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.e0.j0.b android.view.View)
                  (wrap: com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b : 0x0004: CHECK_CAST (r5v1 com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b A[REMOVE]) = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b) (r5v0 'obj' java.lang.Object))
                 call: f.b.a.a.a.e0.h0.<init>(f.b.a.a.a.e0.i6, android.view.View, com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: f.b.a.a.a.e0.j0.a(java.lang.Object):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.e0.h0, state: NOT_LOADED
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
                	... 8 more
                */
            @Override // e.r.t
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    f.b.a.a.a.e0.i6 r0 = f.b.a.a.a.e0.i6.this
                    android.view.View r1 = r4.b
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel$b r5 = (com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel.b) r5
                    f.b.a.a.a.u.g0 r2 = r0.l0
                    android.widget.Button r2 = r2.f2421i
                    f.b.a.a.a.e0.h0 r3 = new f.b.a.a.a.e0.h0
                    r3.<init>(r0, r1, r5)
                    r2.setOnClickListener(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.j0.a(java.lang.Object):void");
            }
        });
        y yVar2 = this.b0.K;
        Boolean bool2 = Boolean.FALSE;
        yVar2.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool2).f(H(), new t(linearLayout2) { // from class: f.b.a.a.a.e0.l0
            public final /* synthetic */ LinearLayout a;

            {
                this.a = r1;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                LinearLayout linearLayout3 = this.a;
                int i3 = i6.o0;
                linearLayout3.setVisibility(((Boolean) obj).booleanValue() ? 0 : 8);
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool2).f(H(), new t(linearLayout) { // from class: f.b.a.a.a.e0.n0
            public final /* synthetic */ LinearLayout a;

            {
                this.a = r1;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                LinearLayout linearLayout3 = this.a;
                int i3 = i6.o0;
                linearLayout3.setVisibility(((Boolean) obj).booleanValue() ? 0 : 8);
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(H(), new t(noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.b
            public final /* synthetic */ EditText a;

            {
                this.a = r1;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                this.a.setEnabled(((Boolean) obj).booleanValue());
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(H(), new t(noAutofillTextInputEditText) { // from class: f.b.a.a.a.e0.i0
            public final /* synthetic */ EditText b;

            {
                this.b = r2;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                i6 i6Var = i6.this;
                EditText editText = this.b;
                String str2 = (String) obj;
                Objects.requireNonNull(i6Var);
                if (str2 != null) {
                    editText.setText(str2);
                    editText.setSelection(editText.getText().length());
                    i6Var.l0.n.setEnabled(!TextUtils.isEmpty(str2));
                }
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(H(), new t(viewSwitcher) { // from class: f.b.a.a.a.e0.c0
            public final /* synthetic */ ViewSwitcher a;

            {
                this.a = r1;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                ViewSwitcher viewSwitcher2 = this.a;
                Integer num = (Integer) obj;
                int i3 = i6.o0;
                if (num.intValue() > -1) {
                    viewSwitcher2.setDisplayedChild(num.intValue());
                }
            }
        });
        this.b0.K.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(H(), new t() { // from class: f.b.a.a.a.e0.m0
            @Override // e.r.t
            public final void a(Object obj) {
                i6 i6Var = i6.this;
                String str2 = (String) obj;
                Objects.requireNonNull(i6Var);
                if (str2 != null) {
                    i6Var.m0 = str2;
                }
            }
        });
        this.b0.g().f(H(), new t() { // from class: f.b.a.a.a.e0.s0
            @Override // e.r.t
            public final void a(Object obj) {
                i6 i6Var = i6.this;
                Pair pair = (Pair) obj;
                Objects.requireNonNull(i6Var);
                i6Var.l0.p.setText(i6Var.G(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
            }
        });
    }
}
