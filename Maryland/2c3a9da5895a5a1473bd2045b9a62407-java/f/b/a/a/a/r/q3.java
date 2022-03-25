package f.b.a.a.a.r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AlertController;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$id;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.b.a.m;
import e.i.i.d;
import e.m.a.f0;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import e.s.a.k;
import f.b.a.a.a.i.n;
import f.b.a.a.a.j.j;
import f.b.a.d.m.b;
import gov.md.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class q3 extends g3 {
    public static final /* synthetic */ int d0 = 0;
    public n a0;
    public ExposureNotificationViewModel b0;
    public NotifyHomeViewModel c0;

    public class a extends k.g {

        /* renamed from: f  reason: collision with root package name */
        public final ColorDrawable f2260f;

        /* renamed from: g  reason: collision with root package name */
        public final Drawable f2261g;

        /* renamed from: h  reason: collision with root package name */
        public final Paint f2262h;

        /* renamed from: i  reason: collision with root package name */
        public final int f2263i;

        /* renamed from: j  reason: collision with root package name */
        public final int f2264j;

        /* renamed from: k  reason: collision with root package name */
        public f3 f2265k;

        public a(Context context, f3 f3Var) {
            super(0, 4);
            this.f2265k = f3Var;
            ColorDrawable colorDrawable = new ColorDrawable();
            this.f2260f = colorDrawable;
            colorDrawable.setColor(e.i.b.a.a(context, R.color.delete));
            Paint paint = new Paint();
            this.f2262h = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable drawable = context.getDrawable(R.drawable.ic_delete);
            Objects.requireNonNull(drawable);
            this.f2261g = m.h.w1(drawable);
            this.f2263i = (int) q3.this.v().getDimension(R.dimen.delete_icon_height);
            this.f2264j = (int) q3.this.v().getDimension(R.dimen.delete_icon_margin);
        }

        @Override // e.s.a.k.d
        public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f2, float f3, int i2, boolean z) {
            View view = b0Var.a;
            if (z && view.getTag(R$id.item_touch_helper_previous_elevation) == null) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                Float valueOf = Float.valueOf(view.getElevation());
                int childCount = recyclerView.getChildCount();
                float f4 = 0.0f;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    if (childAt != view) {
                        AtomicInteger atomicInteger2 = e.i.i.m.a;
                        float elevation = childAt.getElevation();
                        if (elevation > f4) {
                            f4 = elevation;
                        }
                    }
                }
                view.setElevation(f4 + 1.0f);
                view.setTag(R$id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f2);
            view.setTranslationY(f3);
            View view2 = b0Var.a;
            View findViewById = view2.findViewById(R.id.horizontal_divider_view);
            if (f2 == 0.0f && !z) {
                canvas.drawRect(f2 + ((float) view2.getRight()), (float) view2.getTop(), (float) view2.getRight(), (float) view2.getBottom(), this.f2262h);
                findViewById.setVisibility(0);
                return;
            }
            view2.setBackgroundResource(R.drawable.swipe_to_delete_item_view);
            findViewById.setVisibility(8);
            this.f2260f.setBounds((view2.getRight() - ((int) q3.this.v().getDimension(R.dimen.delete_item_view_corner_radius))) + ((int) f2), view2.getTop(), view2.getRight(), view2.getBottom());
            this.f2260f.draw(canvas);
            int top = view2.getTop();
            int height = view2.getHeight();
            int i4 = this.f2263i;
            int i5 = ((height - i4) / 2) + top;
            this.f2261g.setBounds((view2.getRight() - this.f2264j) - this.f2263i, i5, view2.getRight() - this.f2264j, i4 + i5);
            this.f2261g.draw(canvas);
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_notify_home, viewGroup, false);
        int i2 = R.id.diagnosis_history_container;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.diagnosis_history_container);
        if (linearLayout != null) {
            i2 = R.id.edge_case_fragment;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.edge_case_fragment);
            if (frameLayout != null) {
                i2 = R.id.fragment_notify_share_button;
                Button button = (Button) inflate.findViewById(R.id.fragment_notify_share_button);
                if (button != null) {
                    i2 = R.id.notify_header_banner;
                    ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.notify_header_banner);
                    if (viewFlipper != null) {
                        i2 = R.id.notify_header_flipper;
                        ViewFlipper viewFlipper2 = (ViewFlipper) inflate.findViewById(R.id.notify_header_flipper);
                        if (viewFlipper2 != null) {
                            i2 = R.id.notify_recycler_view;
                            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.notify_recycler_view);
                            if (recyclerView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                this.a0 = new n(linearLayout2, linearLayout, frameLayout, button, viewFlipper, viewFlipper2, recyclerView);
                                return linearLayout2;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.b0.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.b0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        b0.b l2 = l();
        c0 i2 = i();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String t = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            a0 a0Var = i2.a.get(t);
            if (!NotifyHomeViewModel.class.isInstance(a0Var)) {
                a0Var = l2 instanceof b0.c ? ((b0.c) l2).c(t, NotifyHomeViewModel.class) : l2.a(NotifyHomeViewModel.class);
                a0 put = i2.a.put(t, a0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof b0.e) {
                ((b0.e) l2).b(a0Var);
            }
            this.c0 = (NotifyHomeViewModel) a0Var;
            this.b0.f340d.f(B(), new d(this));
            this.a0.c.setOnClickListener(new k(this));
            f3 f3Var = new f3(new h(this), this.c0);
            this.a0.f2117f.setLayoutManager(new LinearLayoutManager(this.X));
            this.a0.f2117f.setAdapter(f3Var);
            k kVar = new k(new a(n0(), f3Var));
            RecyclerView recyclerView = this.a0.f2117f;
            RecyclerView recyclerView2 = kVar.r;
            if (recyclerView2 != recyclerView) {
                if (recyclerView2 != null) {
                    recyclerView2.e0(kVar);
                    RecyclerView recyclerView3 = kVar.r;
                    RecyclerView.q qVar = kVar.A;
                    recyclerView3.q.remove(qVar);
                    if (recyclerView3.r == qVar) {
                        recyclerView3.r = null;
                    }
                    List<RecyclerView.o> list = kVar.r.D;
                    if (list != null) {
                        list.remove(kVar);
                    }
                    for (int size = kVar.p.size() - 1; size >= 0; size--) {
                        kVar.m.a(kVar.p.get(0).f1835e);
                    }
                    kVar.p.clear();
                    kVar.w = null;
                    kVar.x = -1;
                    VelocityTracker velocityTracker = kVar.t;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        kVar.t = null;
                    }
                    k.e eVar = kVar.z;
                    if (eVar != null) {
                        eVar.a = false;
                        kVar.z = null;
                    }
                    if (kVar.y != null) {
                        kVar.y = null;
                    }
                }
                kVar.r = recyclerView;
                if (recyclerView != null) {
                    Resources resources = recyclerView.getResources();
                    kVar.f1827f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
                    kVar.f1828g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
                    kVar.q = ViewConfiguration.get(kVar.r.getContext()).getScaledTouchSlop();
                    kVar.r.g(kVar);
                    kVar.r.q.add(kVar.A);
                    RecyclerView recyclerView4 = kVar.r;
                    if (recyclerView4.D == null) {
                        recyclerView4.D = new ArrayList();
                    }
                    recyclerView4.D.add(kVar);
                    kVar.z = new k.e();
                    kVar.y = new d(kVar.r.getContext(), kVar.z);
                }
            }
            this.c0.f381d.f(B(), new g(this, f3Var));
            this.c0.c.f(B(), new j(this));
            int i3 = this.c0.f384g;
            if (i3 > -1) {
                z0(f3Var, i3);
            }
            f0 j2 = j();
            if (j2.I(R.id.edge_case_fragment) == null) {
                f.b.a.a.a.j.n nVar = new f.b.a.a.a.j.n();
                j.C0(nVar, true, false);
                e.m.a.a aVar = new e.m.a.a(j2);
                aVar.f(R.id.edge_case_fragment, nVar, null);
                aVar.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void z0(f3 f3Var, int i2) {
        this.c0.f384g = i2;
        b bVar = new b(n0());
        bVar.f(R.string.delete_test_result_title);
        bVar.c(R.string.delete_test_result_detail);
        bVar.a.f34k = true;
        bVar.d(R.string.btn_cancel, new f(this, f3Var));
        bVar.e(R.string.btn_delete, new i(f3Var, i2));
        e eVar = new e(this, f3Var);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = eVar;
        bVar2.f35l = new c(this, f3Var);
        bVar.b();
    }
}
