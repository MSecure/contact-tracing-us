package f.b.a.a.a.e0;

import android.content.Context;
import android.content.DialogInterface;
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
import e.j.b.a;
import e.j.j.g;
import e.j.j.v;
import e.r.f0;
import e.r.g0;
import e.r.t;
import e.u.a.k;
import e.v.n.d;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.e0;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.u.p0;
import f.b.a.e.m.b;
import f.b.b.a.l;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import gov.nm.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c7 extends z5 {
    public static final /* synthetic */ int d0;
    public p0 b0;
    public NotifyHomeViewModel c0;

    /* loaded from: classes.dex */
    public class a extends k.g {

        /* renamed from: f */
        public final ColorDrawable f2214f;

        /* renamed from: g */
        public final Drawable f2215g;

        /* renamed from: h */
        public final Paint f2216h;

        /* renamed from: i */
        public final int f2217i;

        /* renamed from: j */
        public final int f2218j;

        /* renamed from: k */
        public final n5 f2219k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, n5 n5Var) {
            super(0, 4);
            c7.this = r3;
            this.f2219k = n5Var;
            ColorDrawable colorDrawable = new ColorDrawable();
            this.f2214f = colorDrawable;
            colorDrawable.setColor(e.j.b.a.a(context, R.color.delete));
            Paint paint = new Paint();
            this.f2216h = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Drawable b = a.b.b(context, R.drawable.ic_delete);
            Objects.requireNonNull(b);
            this.f2215g = m.e.X1(b);
            this.f2217i = (int) r3.B().getDimension(R.dimen.delete_icon_height);
            this.f2218j = (int) r3.B().getDimension(R.dimen.delete_icon_margin);
        }

        @Override // e.u.a.k.d
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
                canvas.drawRect(f2 + ((float) view2.getRight()), (float) view2.getTop(), (float) view2.getRight(), (float) view2.getBottom(), this.f2216h);
                if (e2 == this.f2219k.a() - 1) {
                    i3 = 8;
                }
                findViewById.setVisibility(i3);
                return;
            }
            view2.setBackgroundResource(R.drawable.swipe_to_delete_item_view);
            findViewById.setVisibility(8);
            this.f2214f.setBounds((view2.getRight() - ((int) c7.this.B().getDimension(R.dimen.delete_item_view_corner_radius))) + ((int) f2), view2.getTop(), view2.getRight(), view2.getBottom());
            this.f2214f.draw(canvas);
            int top = view2.getTop();
            int height = view2.getHeight();
            int i6 = this.f2217i;
            int i7 = ((height - i6) / 2) + top;
            this.f2215g.setBounds((view2.getRight() - this.f2218j) - this.f2217i, i7, view2.getRight() - this.f2218j, i6 + i7);
            this.f2215g.draw(canvas);
        }
    }

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        w().X();
        return true;
    }

    public final void L0(n5 n5Var, int i2) {
        this.c0.f405g = i2;
        b bVar = new b(v0(), R.style.ExposureNotificationAlertDialogTheme);
        bVar.f(R.string.delete_test_result_title);
        bVar.a.f38k = true;
        bVar.d(R.string.btn_cancel, new DialogInterface.OnClickListener(n5Var) { // from class: f.b.a.a.a.e0.e5
            public final /* synthetic */ n5 c;

            {
                this.c = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c7 c7Var = c7.this;
                n5 n5Var2 = this.c;
                Objects.requireNonNull(c7Var);
                dialogInterface.cancel();
                c7Var.c0.f405g = -1;
                n5Var2.a.b();
            }
        });
        bVar.e(R.string.btn_delete, new DialogInterface.OnClickListener(i2) { // from class: f.b.a.a.a.e0.g5
            public final /* synthetic */ int c;

            {
                this.c = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                n5 n5Var2 = n5.this;
                int i4 = this.c;
                int i5 = c7.d0;
                NotifyHomeViewModel notifyHomeViewModel = n5Var2.c;
                k0 k0Var = notifyHomeViewModel.f403e;
                long e2 = n5Var2.f2232e.remove(i4).e();
                d0 d0Var = (d0) k0Var.a;
                u a2 = d.a(d0Var.a, true, new e0(d0Var, e2));
                a6 a6Var = new a6(notifyHomeViewModel);
                ExecutorService executorService = notifyHomeViewModel.f404f;
                ((e.g.a.a) a2).a(new q(a2, a6Var), executorService);
                n5Var2.a.b();
            }
        });
        d5 d5Var = new DialogInterface.OnDismissListener(n5Var) { // from class: f.b.a.a.a.e0.d5
            public final /* synthetic */ n5 c;

            {
                this.c = r2;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                c7 c7Var = c7.this;
                n5 n5Var2 = this.c;
                c7Var.c0.f405g = -1;
                n5Var2.a.b();
            }
        };
        AlertController.b bVar2 = bVar.a;
        bVar2.m = d5Var;
        bVar2.f39l = new DialogInterface.OnCancelListener(n5Var) { // from class: f.b.a.a.a.e0.i5
            public final /* synthetic */ n5 c;

            {
                this.c = r2;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                c7 c7Var = c7.this;
                n5 n5Var2 = this.c;
                c7Var.c0.f405g = -1;
                n5Var2.a.b();
            }
        };
        bVar.b();
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.b0 = new p0(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String x = f.a.a.a.a.x("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e.r.e0 e0Var = i2.a.get(x);
            if (!NotifyHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(x, NotifyHomeViewModel.class) : l2.a(NotifyHomeViewModel.class);
                e.r.e0 put = i2.a.put(x, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.c0 = (NotifyHomeViewModel) e0Var;
            this.b0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.h5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c7.this.w().X();
                }
            });
            n5 n5Var = new n5(new f5(this), this.c0);
            v0();
            this.b0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.b0.b.setAdapter(n5Var);
            k kVar = new k(new a(v0(), n5Var));
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
                        kVar.m.a(kVar.p.get(0).f2011e);
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
                    kVar.f2003f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
                    kVar.f2004g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
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
            this.c0.f402d.f(H(), new t(n5Var) { // from class: f.b.a.a.a.e0.j5
                public final /* synthetic */ n5 b;

                {
                    this.b = r2;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    c7 c7Var = c7.this;
                    n5 n5Var2 = this.b;
                    List<j0> list2 = (List) obj;
                    int i3 = 0;
                    c7Var.b0.f2464d.setVisibility(list2.isEmpty() ? 0 : 8);
                    RecyclerView recyclerView5 = c7Var.b0.b;
                    if (list2.isEmpty()) {
                        i3 = 8;
                    }
                    recyclerView5.setVisibility(i3);
                    n5Var2.f2232e = list2;
                    n5Var2.a.b();
                    int i4 = c7Var.c0.f405g;
                    l c = i4 > -1 ? l.c(Integer.valueOf(i4)) : f.b.b.a.a.b;
                    if (c.b()) {
                        c7Var.L0(n5Var2, ((Integer) c.a()).intValue());
                    }
                }
            });
            this.c0.c.f(this, new t() { // from class: f.b.a.a.a.e0.k5
                @Override // e.r.t
                public final void a(Object obj) {
                    c7 c7Var = c7.this;
                    Void r3 = (Void) obj;
                    m.e.Z0(c7Var.F, c7Var.F(R.string.delete_test_result_confirmed));
                }
            });
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
