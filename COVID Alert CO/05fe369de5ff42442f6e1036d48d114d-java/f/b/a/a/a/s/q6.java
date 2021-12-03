package f.b.a.a.a.s;

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
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$id;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.b.a.m;
import e.i.i.d;
import e.p.e0;
import e.p.f0;
import e.p.g0;
import e.s.a.k;
import f.b.a.a.a.j.m0;
import f.b.a.e.l.b;
import gov.co.cdphe.exposurenotifications.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class q6 extends l5 {
    public static final /* synthetic */ int c0 = 0;
    public m0 a0;
    public NotifyHomeViewModel b0;

    public class a extends k.g {

        /* renamed from: f  reason: collision with root package name */
        public final ColorDrawable f2387f;

        /* renamed from: g  reason: collision with root package name */
        public final Drawable f2388g;

        /* renamed from: h  reason: collision with root package name */
        public final Paint f2389h;

        /* renamed from: i  reason: collision with root package name */
        public final int f2390i;

        /* renamed from: j  reason: collision with root package name */
        public final int f2391j;

        /* renamed from: k  reason: collision with root package name */
        public final z4 f2392k;

        public a(Context context, z4 z4Var) {
            super(0, 4);
            this.f2392k = z4Var;
            ColorDrawable colorDrawable = new ColorDrawable();
            this.f2387f = colorDrawable;
            colorDrawable.setColor(e.i.b.a.b(context, R.color.delete));
            Paint paint = new Paint();
            this.f2389h = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable drawable = context.getDrawable(R.drawable.ic_delete);
            Objects.requireNonNull(drawable);
            this.f2388g = m.h.C1(drawable);
            this.f2390i = (int) q6.this.w().getDimension(R.dimen.delete_icon_height);
            this.f2391j = (int) q6.this.w().getDimension(R.dimen.delete_icon_margin);
        }

        @Override // e.s.a.k.d
        public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f2, float f3, int i2, boolean z) {
            View view = b0Var.a;
            int i3 = 0;
            if (z && view.getTag(R$id.item_touch_helper_previous_elevation) == null) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                Float valueOf = Float.valueOf(view.getElevation());
                int childCount = recyclerView.getChildCount();
                float f4 = 0.0f;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = recyclerView.getChildAt(i4);
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
            int e2 = b0Var.e();
            if (f2 == 0.0f && !z) {
                canvas.drawRect(f2 + ((float) view2.getRight()), (float) view2.getTop(), (float) view2.getRight(), (float) view2.getBottom(), this.f2389h);
                if (e2 == this.f2392k.a() - 1) {
                    i3 = 8;
                }
                findViewById.setVisibility(i3);
                return;
            }
            view2.setBackgroundResource(R.drawable.swipe_to_delete_item_view);
            findViewById.setVisibility(8);
            this.f2387f.setBounds((view2.getRight() - ((int) q6.this.w().getDimension(R.dimen.delete_item_view_corner_radius))) + ((int) f2), view2.getTop(), view2.getRight(), view2.getBottom());
            this.f2387f.draw(canvas);
            int top = view2.getTop();
            int height = view2.getHeight();
            int i5 = this.f2390i;
            int i6 = ((height - i5) / 2) + top;
            this.f2388g.setBounds((view2.getRight() - this.f2391j) - this.f2390i, i6, view2.getRight() - this.f2391j, i5 + i6);
            this.f2388g.draw(canvas);
        }
    }

    @Override // f.b.a.a.a.m.z0
    public boolean A0() {
        u().W();
        return true;
    }

    public final void C0(z4 z4Var, int i2) {
        this.b0.f402g = i2;
        b bVar = new b(p0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f37k = true;
        bVar.d(R.string.btn_cancel, new q4(this, z4Var));
        bVar.e(R.string.btn_delete, new s4(z4Var, i2));
        p4 p4Var = new p4(this, z4Var);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = p4Var;
        bVar2.f38l = new u4(this, z4Var);
        bVar.b();
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sharing_history, viewGroup, false);
        int i2 = R.id.diagnoses_recycler_view;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.diagnoses_recycler_view);
        if (recyclerView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                i2 = R.id.no_sharing_history;
                TextView textView = (TextView) inflate.findViewById(R.id.no_sharing_history);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    this.a0 = new m0(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String c = f.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = i2.a.get(c);
            if (!NotifyHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(c, NotifyHomeViewModel.class) : l2.a(NotifyHomeViewModel.class);
                e0 put = i2.a.put(c, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.b0 = (NotifyHomeViewModel) e0Var;
            this.a0.c.setOnClickListener(new t4(this));
            z4 z4Var = new z4(new r4(this), this.b0);
            p0();
            this.a0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.a0.b.setAdapter(z4Var);
            k kVar = new k(new a(p0(), z4Var));
            RecyclerView recyclerView = this.a0.b;
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
                        kVar.m.a(kVar.p.get(0).f1651e);
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
                    kVar.f1643f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
                    kVar.f1644g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
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
            this.b0.f399d.f(C(), new v4(this, z4Var));
            this.b0.c.f(this, new w4(this));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
