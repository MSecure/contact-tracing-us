package f.b.a.a.a.d0;

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
import e.i.b.a;
import e.i.i.g;
import e.i.i.v;
import e.q.e0;
import e.q.f0;
import e.q.g0;
import e.t.a.k;
import f.b.a.a.a.t.m0;
import f.b.a.e.m.b;
import g.b.a.c.b.d;
import gov.ut.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class o6 extends l5 {
    public static final /* synthetic */ int d0 = 0;
    public m0 b0;
    public NotifyHomeViewModel c0;

    public class a extends k.g {

        /* renamed from: f  reason: collision with root package name */
        public final ColorDrawable f2183f;

        /* renamed from: g  reason: collision with root package name */
        public final Drawable f2184g;

        /* renamed from: h  reason: collision with root package name */
        public final Paint f2185h;

        /* renamed from: i  reason: collision with root package name */
        public final int f2186i;

        /* renamed from: j  reason: collision with root package name */
        public final int f2187j;

        /* renamed from: k  reason: collision with root package name */
        public final z4 f2188k;

        public a(Context context, z4 z4Var) {
            super(0, 4);
            this.f2188k = z4Var;
            ColorDrawable colorDrawable = new ColorDrawable();
            this.f2183f = colorDrawable;
            colorDrawable.setColor(e.i.b.a.a(context, R.color.delete));
            Paint paint = new Paint();
            this.f2185h = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable b = a.b.b(context, R.drawable.ic_delete);
            Objects.requireNonNull(b);
            this.f2184g = m.e.P1(b);
            this.f2186i = (int) o6.this.A().getDimension(R.dimen.delete_icon_height);
            this.f2187j = (int) o6.this.A().getDimension(R.dimen.delete_icon_margin);
        }

        @Override // e.t.a.k.d
        public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f2, float f3, int i2, boolean z) {
            View view = b0Var.a;
            int i3 = 0;
            if (z && view.getTag(R$id.item_touch_helper_previous_elevation) == null) {
                AtomicInteger atomicInteger = v.a;
                Float valueOf = Float.valueOf(v.i.i(view));
                int childCount = recyclerView.getChildCount();
                float f4 = 0.0f;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = recyclerView.getChildAt(i4);
                    if (childAt != view) {
                        AtomicInteger atomicInteger2 = v.a;
                        float i5 = v.i.i(childAt);
                        if (i5 > f4) {
                            f4 = i5;
                        }
                    }
                }
                v.i.s(view, f4 + 1.0f);
                view.setTag(R$id.item_touch_helper_previous_elevation, valueOf);
            }
            view.setTranslationX(f2);
            view.setTranslationY(f3);
            View view2 = b0Var.a;
            View findViewById = view2.findViewById(R.id.horizontal_divider_view);
            int e2 = b0Var.e();
            if (f2 == 0.0f && !z) {
                canvas.drawRect(f2 + ((float) view2.getRight()), (float) view2.getTop(), (float) view2.getRight(), (float) view2.getBottom(), this.f2185h);
                if (e2 == this.f2188k.a() - 1) {
                    i3 = 8;
                }
                findViewById.setVisibility(i3);
                return;
            }
            view2.setBackgroundResource(R.drawable.swipe_to_delete_item_view);
            findViewById.setVisibility(8);
            this.f2183f.setBounds((view2.getRight() - ((int) o6.this.A().getDimension(R.dimen.delete_item_view_corner_radius))) + ((int) f2), view2.getTop(), view2.getRight(), view2.getBottom());
            this.f2183f.draw(canvas);
            int top = view2.getTop();
            int height = view2.getHeight();
            int i6 = this.f2186i;
            int i7 = ((height - i6) / 2) + top;
            this.f2184g.setBounds((view2.getRight() - this.f2187j) - this.f2186i, i7, view2.getRight() - this.f2187j, i6 + i7);
            this.f2184g.draw(canvas);
        }
    }

    @Override // f.b.a.a.a.w.z0
    public boolean F0() {
        v().W();
        return true;
    }

    public final void I0(z4 z4Var, int i2) {
        this.c0.f398g = i2;
        b bVar = new b(t0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new q4(this, z4Var));
        bVar.e(R.string.btn_delete, new s4(z4Var, i2));
        p4 p4Var = new p4(this, z4Var);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = p4Var;
        bVar2.f39l = new u4(this, z4Var);
        bVar.b();
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.b0 = new m0(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String w = f.a.a.a.a.w("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = i2.a.get(w);
            if (!NotifyHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(w, NotifyHomeViewModel.class) : ((d) l2).a(NotifyHomeViewModel.class);
                e0 put = i2.a.put(w, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.c0 = (NotifyHomeViewModel) e0Var;
            this.b0.c.setOnClickListener(new t4(this));
            z4 z4Var = new z4(new r4(this), this.c0);
            t0();
            this.b0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.b0.b.setAdapter(z4Var);
            k kVar = new k(new a(t0(), z4Var));
            RecyclerView recyclerView = this.b0.b;
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
                        kVar.m.a(kVar.p.get(0).f1926e);
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
                    kVar.f1918f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
                    kVar.f1919g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
                    kVar.q = ViewConfiguration.get(kVar.r.getContext()).getScaledTouchSlop();
                    kVar.r.g(kVar);
                    kVar.r.q.add(kVar.A);
                    RecyclerView recyclerView4 = kVar.r;
                    if (recyclerView4.D == null) {
                        recyclerView4.D = new ArrayList();
                    }
                    recyclerView4.D.add(kVar);
                    kVar.z = new k.e();
                    kVar.y = new g(kVar.r.getContext(), kVar.z);
                }
            }
            this.c0.f395d.f(G(), new v4(this, z4Var));
            this.c0.c.f(this, new w4(this));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
