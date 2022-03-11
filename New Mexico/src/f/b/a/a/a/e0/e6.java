package f.b.a.a.a.e0;

import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.R$string;
import e.a.e.c;
import e.a.e.e;
import e.b.a.m;
import e.o.a.m;
import e.r.f0;
import e.r.t;
import e.v.n.d;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.e0;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.s.g;
import f.b.a.e.l.a;
import f.b.a.e.l.a0;
import f.b.a.e.l.q;
import f.b.a.e.l.u;
import f.b.a.e.m.b;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import gov.nm.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.f;
import l.b.a.r;
import l.b.a.v.k;
/* loaded from: classes.dex */
public abstract class e6 extends q5 {
    public static final /* synthetic */ int h0;
    public ShareDiagnosisViewModel b0;
    public c<e> c0;
    public f.b.a.a.a.t.q0.a f0;
    public l<Boolean> d0 = f.b.b.a.a.b;
    public boolean e0 = false;
    public final a.c g0 = new a();

    /* loaded from: classes.dex */
    public class a implements a.c {
        public a() {
            e6.this = r1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // f.b.a.e.l.a.c
        public boolean f(long j2) {
            return o5.c(e6.this.f0, j2);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
        }
    }

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        boolean z;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        shareDiagnosisViewModel.j();
        boolean z2 = false;
        if (shareDiagnosisViewModel.D.isEmpty()) {
            z = false;
        } else {
            shareDiagnosisViewModel.C.j(shareDiagnosisViewModel.D.peek());
            z = true;
        }
        if (!z) {
            l6 l6Var = (l6) this.v;
            if (l6Var != null && l6Var.e0) {
                z2 = true;
            }
            Q0(z2);
        }
        return true;
    }

    public void L0() {
        if (!this.v.w().Z()) {
            this.v.u0().finish();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0053, code lost:
        if (f.b.a.e.l.q.d.a(r7, r1) != false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public q<Long> M0(l.b.a.e eVar) {
        u uVar;
        a0 a0Var = new a0();
        a.b bVar = new a.b();
        bVar.b = System.currentTimeMillis();
        bVar.f2927d = this.g0;
        f.b.a.e.l.a a2 = bVar.a();
        Long valueOf = Long.valueOf(eVar.G());
        int i2 = R$string.mtrl_picker_date_header_title;
        if (valueOf != null) {
            a0Var.d(valueOf);
        }
        if (a2.f2922e == null) {
            if (!((ArrayList) a0Var.m()).isEmpty()) {
                uVar = u.q(((Long) ((ArrayList) a0Var.m()).iterator().next()).longValue());
            }
            uVar = u.r();
            if (!q.d.a(uVar, a2)) {
                uVar = a2.b;
            }
            a2.f2922e = uVar;
        }
        q<Long> qVar = new q<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", 0);
        bundle.putParcelable("DATE_SELECTOR_KEY", a0Var);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a2);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", i2);
        bundle.putCharSequence("TITLE_TEXT_KEY", null);
        bundle.putInt("INPUT_MODE_KEY", 0);
        qVar.A0(bundle);
        return qVar;
    }

    public q<Long> N0(String str) {
        m I = w().I(str);
        if (I == null) {
            return null;
        }
        return (q) I;
    }

    public l.b.a.v.c O0() {
        return l.b.a.v.c.c(k.MEDIUM).g(B().getConfiguration().locale);
    }

    public boolean P0(String str, g<Long, Boolean> gVar) {
        if (str.isEmpty()) {
            return false;
        }
        try {
            return gVar.a(Long.valueOf(f.T(str, O0()).A(r.f4641g).w().G())).booleanValue();
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public void Q0(boolean z) {
        if (z) {
            U0();
        } else {
            L0();
        }
    }

    public void R0(String str) {
        View view;
        String str2;
        if (!TextUtils.isEmpty(str) && !P0(str, new g() { // from class: f.b.a.a.a.e0.t
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                f.b.a.a.a.t.q0.a aVar = e6.this.f0;
                long longValue = ((Long) obj).longValue();
                f.b.a.a.a.t.p0.a aVar2 = o5.a;
                return Boolean.valueOf(longValue <= aVar.a());
            }
        })) {
            view = this.F;
            str2 = F(R.string.input_error_onset_date_future);
        } else if (!TextUtils.isEmpty(str) && !P0(str, new g() { // from class: f.b.a.a.a.e0.m
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                return Boolean.valueOf(o5.c(e6.this.f0, ((Long) obj).longValue()));
            }
        })) {
            view = this.F;
            str2 = G(R.string.input_error_onset_date_past, "14");
        } else {
            return;
        }
        m.e.Z0(view, str2);
    }

    public void S0(NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b(nestedScrollView, viewGroup) { // from class: f.b.a.a.a.e0.v
            public final /* synthetic */ NestedScrollView b;
            public final /* synthetic */ ViewGroup c;

            {
                this.b = r2;
                this.c = r3;
            }

            @Override // androidx.core.widget.NestedScrollView.b
            public final void a(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                e6 e6Var = e6.this;
                NestedScrollView nestedScrollView3 = this.b;
                ViewGroup viewGroup2 = this.c;
                Objects.requireNonNull(e6Var);
                if (nestedScrollView3.getChildAt(0).getBottom() <= nestedScrollView3.getScrollY() + nestedScrollView3.getHeight()) {
                    e6Var.W0(viewGroup2, true);
                } else {
                    e6Var.W0(viewGroup2, false);
                }
            }
        });
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(nestedScrollView, viewGroup) { // from class: f.b.a.a.a.e0.g
            public final /* synthetic */ NestedScrollView c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ ViewGroup f2223d;

            {
                this.c = r2;
                this.f2223d = r3;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                e6 e6Var = e6.this;
                NestedScrollView nestedScrollView2 = this.c;
                ViewGroup viewGroup2 = this.f2223d;
                Objects.requireNonNull(e6Var);
                if (nestedScrollView2.getMeasuredHeight() >= nestedScrollView2.getChildAt(0).getHeight()) {
                    e6Var.W0(viewGroup2, true);
                }
            }
        });
    }

    public final void T0() {
        this.e0 = true;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.update_app_dialog_title);
        bVar.c(R.string.update_app_dialog_content);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.e0.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e6.this.e0 = false;
                dialogInterface.cancel();
            }
        });
        bVar.e(R.string.btn_update, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.e0.o
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  (r5v4 'z' f.b.b.f.a.b) = 
                  (wrap: f.b.b.f.a.l<f.b.a.f.a.a.a> : 0x000b: INVOKE  (r1v0 f.b.b.f.a.l<f.b.a.f.a.a.a> A[REMOVE]) = (r0v0 'gVar' f.b.a.a.a.s.g) type: VIRTUAL call: f.b.a.a.a.s.g.a():f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.s.a : 0x0011: CONSTRUCTOR  (r2v0 f.b.a.a.a.s.a A[REMOVE]) = (r0v0 'gVar' f.b.a.a.a.s.g), (r5v2 'cVar' e.a.e.c<e.a.e.e>) call: f.b.a.a.a.s.a.<init>(f.b.a.a.a.s.g, e.a.e.c):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0014: IGET  (r5v3 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'gVar' f.b.a.a.a.s.g) f.b.a.a.a.s.g.b java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.e0.o.onClick(android.content.DialogInterface, int):void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.s.a, state: NOT_LOADED
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
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(android.content.DialogInterface r5, int r6) {
                /*
                    r4 = this;
                    f.b.a.a.a.e0.e6 r5 = f.b.a.a.a.e0.e6.this
                    r6 = 0
                    r5.e0 = r6
                    com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel r6 = r5.b0
                    e.a.e.c<e.a.e.e> r5 = r5.c0
                    f.b.a.a.a.s.g r0 = r6.I
                    f.b.b.f.a.l r1 = r0.a()
                    f.b.a.a.a.s.a r2 = new f.b.a.a.a.s.a
                    r2.<init>(r0, r5)
                    java.util.concurrent.ExecutorService r5 = r0.b
                    f.b.b.f.a.l r5 = r1.z(r2, r5)
                    java.lang.Class<android.content.IntentSender$SendIntentException> r1 = android.content.IntentSender.SendIntentException.class
                    f.b.a.a.a.s.d r2 = f.b.a.a.a.s.d.a
                    java.util.concurrent.ExecutorService r0 = r0.b
                    f.b.b.f.a.a$a r3 = new f.b.b.f.a.a$a
                    r3.<init>(r5, r1, r2)
                    java.util.concurrent.Executor r0 = f.b.a.c.b.o.b.k1(r0, r3)
                    f.b.b.f.a.l$a r5 = (f.b.b.f.a.l.a) r5
                    r5.a(r3, r0)
                    f.b.b.f.a.l r5 = f.b.b.f.a.l.x(r3)
                    f.b.a.a.a.e0.q4 r0 = new f.b.a.a.a.e0.q4
                    r0.<init>(r6)
                    java.util.concurrent.ExecutorService r1 = r6.z
                    f.b.b.f.a.l r5 = r5.z(r0, r1)
                    java.lang.Class<f.b.a.a.a.s.g$a> r0 = f.b.a.a.a.s.g.a.class
                    f.b.a.a.a.e0.n4 r1 = new f.b.a.a.a.e0.n4
                    r1.<init>(r6)
                    java.util.concurrent.ExecutorService r6 = r6.z
                    f.b.b.f.a.a$a r2 = new f.b.b.f.a.a$a
                    r2.<init>(r5, r0, r1)
                    java.util.concurrent.Executor r6 = f.b.a.c.b.o.b.k1(r6, r2)
                    f.b.b.f.a.l$a r5 = (f.b.b.f.a.l.a) r5
                    r5.a(r2, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.e0.o.onClick(android.content.DialogInterface, int):void");
            }
        });
        bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.e0.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e6.this.e0 = false;
            }
        };
        bVar.b();
    }

    public void U0() {
        this.b0.N = true;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.share_close_title);
        bVar.c(R.string.share_close_detail);
        bVar.e(R.string.btn_resume_later, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.e0.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e6 e6Var = e6.this;
                e6Var.b0.N = false;
                e6Var.L0();
            }
        });
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.e0.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e6.this.b0.N = false;
                dialogInterface.dismiss();
            }
        });
        bVar.a.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.e0.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e6.this.b0.N = false;
            }
        };
        bVar.b();
    }

    public void V0(j0 j0Var) {
        this.b0.M = true;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f38k = true;
        bVar.e(R.string.btn_delete, new DialogInterface.OnClickListener(j0Var) { // from class: f.b.a.a.a.e0.k
            public final /* synthetic */ j0 c;

            {
                this.c = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e6 e6Var = e6.this;
                j0 j0Var2 = this.c;
                ShareDiagnosisViewModel shareDiagnosisViewModel = e6Var.b0;
                shareDiagnosisViewModel.M = false;
                k0 k0Var = shareDiagnosisViewModel.c;
                long e2 = j0Var2.e();
                d0 d0Var = (d0) k0Var.a;
                f.b.b.f.a.u a2 = d.a(d0Var.a, true, new e0(d0Var, e2));
                b7 b7Var = new b7(shareDiagnosisViewModel);
                ExecutorService executorService = shareDiagnosisViewModel.z;
                ((e.g.a.a) a2).a(new f.b.b.f.a.q(a2, b7Var), executorService);
            }
        });
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener() { // from class: f.b.a.a.a.e0.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                e6.this.b0.M = false;
            }
        });
        n nVar = new DialogInterface.OnDismissListener() { // from class: f.b.a.a.a.e0.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                e6.this.b0.M = false;
            }
        };
        AlertController.b bVar2 = bVar.a;
        bVar2.m = nVar;
        bVar2.f39l = new DialogInterface.OnCancelListener() { // from class: f.b.a.a.a.e0.i
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                e6.this.b0.M = false;
            }
        };
        bVar.b();
    }

    public final void W0(ViewGroup viewGroup, boolean z) {
        if (!this.d0.b() || this.d0.a().booleanValue() != z) {
            this.d0 = l.c(Boolean.valueOf(z));
            viewGroup.setElevation(z ? 0.0f : B().getDimension(R.dimen.bottom_button_container_elevation));
        }
    }

    @Override // e.o.a.m
    public void i0() {
        this.D = true;
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        f.b.b.f.a.l z = shareDiagnosisViewModel.I.a().z(new i(this.c0) { // from class: f.b.a.a.a.e0.p3
            public final /* synthetic */ c b;

            {
                this.b = r2;
            }

            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel2 = ShareDiagnosisViewModel.this;
                c cVar = this.b;
                f.b.a.f.a.a.a aVar = (f.b.a.f.a.a.a) obj;
                Objects.requireNonNull(shareDiagnosisViewModel2.I);
                if (!(aVar.a == 3)) {
                    return f.b.a.c.b.o.b.R0(Boolean.TRUE);
                }
                f.b.a.a.a.s.g gVar = shareDiagnosisViewModel2.I;
                Objects.requireNonNull(gVar);
                try {
                    return f.b.a.c.b.o.b.R0(Boolean.valueOf(gVar.a.b(aVar, 1, new f.b.a.a.a.s.b(cVar), 4444)));
                } catch (IntentSender.SendIntentException e2) {
                    return new s.a(new g.a(e2));
                }
            }
        }, shareDiagnosisViewModel.z).z(new i() { // from class: f.b.a.a.a.e0.t4
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel2 = ShareDiagnosisViewModel.this;
                Objects.requireNonNull(shareDiagnosisViewModel2);
                if (!((Boolean) obj).booleanValue()) {
                    shareDiagnosisViewModel2.H.j(shareDiagnosisViewModel2.J.getResources().getString(R.string.try_again_later_error_message));
                }
                return s.c;
            }
        }, shareDiagnosisViewModel.z);
        z2 z2Var = new i() { // from class: f.b.a.a.a.e0.z2
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(Object obj) {
                ShareDiagnosisViewModel shareDiagnosisViewModel2 = ShareDiagnosisViewModel.this;
                g.a aVar = (g.a) obj;
                shareDiagnosisViewModel2.H.j(shareDiagnosisViewModel2.J.getResources().getString(R.string.try_again_later_error_message));
                return s.c;
            }
        };
        ExecutorService executorService = shareDiagnosisViewModel.z;
        a.C0110a aVar = new a.C0110a(z, g.a.class, z2Var);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putBoolean("STATE_UPDATE_APP_DIALOG_OPEN", this.e0);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        if (bundle != null) {
            this.e0 = bundle.getBoolean("STATE_UPDATE_APP_DIALOG_OPEN", false);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class);
        this.b0 = shareDiagnosisViewModel;
        if (shareDiagnosisViewModel.N) {
            U0();
        }
        this.c0 = t0(new e.a.e.f.d(), new e.a.e.b(view) { // from class: f.b.a.a.a.e0.u
            public final /* synthetic */ View b;

            {
                this.b = r2;
            }

            @Override // e.a.e.b
            public final void a(Object obj) {
                e6 e6Var = e6.this;
                View view2 = this.b;
                Objects.requireNonNull(e6Var);
                int i2 = ((e.a.e.a) obj).b;
                if (i2 != 0 && i2 != -1) {
                    m.e.Z0(view2, e6Var.B().getString(R.string.try_again_later_error_message));
                }
            }
        });
        this.b0.q.f(H(), new t() { // from class: f.b.a.a.a.e0.s
            @Override // e.r.t
            public final void a(Object obj) {
                Void r2 = (Void) obj;
                e6.this.T0();
            }
        });
        this.b0.H.f(H(), new t(view) { // from class: f.b.a.a.a.e0.l
            public final /* synthetic */ View a;

            {
                this.a = r1;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                int i2 = e6.h0;
                m.e.Z0(this.a, (String) obj);
            }
        });
        if (this.e0) {
            T0();
        }
    }
}
