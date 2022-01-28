package c.b.a.b.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.k.o;
import b.i.l.m;
import c.b.a.b.f;
import c.b.a.b.h;
import c.b.a.b.k;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class b extends o {

    /* renamed from: d  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f3192d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f3193e;
    public boolean f;
    public boolean g;
    public boolean h;
    public BottomSheetBehavior.d i;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            b bVar = b.this;
            if (bVar.f && bVar.isShowing()) {
                b bVar2 = b.this;
                if (!bVar2.h) {
                    TypedArray obtainStyledAttributes = bVar2.getContext().obtainStyledAttributes(new int[]{16843611});
                    bVar2.g = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                    bVar2.h = true;
                }
                if (bVar2.g) {
                    b.this.cancel();
                }
            }
        }
    }

    /* renamed from: c.b.a.b.r.b$b  reason: collision with other inner class name */
    public class C0070b extends b.i.l.a {
        public C0070b() {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            boolean z;
            this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
            if (b.this.f) {
                bVar.f1195a.addAction(1048576);
                z = true;
            } else {
                z = false;
            }
            bVar.f1195a.setDismissable(z);
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                b bVar = b.this;
                if (bVar.f) {
                    bVar.cancel();
                    return true;
                }
            }
            return super.g(view, i, bundle);
        }
    }

    public class c implements View.OnTouchListener {
        public c(b bVar) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class d extends BottomSheetBehavior.d {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void a(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(View view, int i) {
            if (i == 5) {
                b.this.cancel();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public b(Context context, int i2) {
        super(context, i2);
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            i2 = context.getTheme().resolveAttribute(c.b.a.b.b.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : k.Theme_Design_Light_BottomSheetDialog;
        }
        this.f = true;
        this.g = true;
        this.i = new d();
        c(1);
    }

    public void cancel() {
        if (this.f3192d == null) {
            d();
        }
        super.cancel();
    }

    public final FrameLayout d() {
        if (this.f3193e == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), h.design_bottom_sheet_dialog, null);
            this.f3193e = frameLayout;
            BottomSheetBehavior<FrameLayout> H = BottomSheetBehavior.H((FrameLayout) frameLayout.findViewById(f.design_bottom_sheet));
            this.f3192d = H;
            BottomSheetBehavior.d dVar = this.i;
            if (!H.G.contains(dVar)) {
                H.G.add(dVar);
            }
            this.f3192d.J(this.f);
        }
        return this.f3193e;
    }

    public final View e(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        d();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f3193e.findViewById(f.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f3193e.findViewById(f.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.touch_outside).setOnClickListener(new a());
        m.T(frameLayout, new C0070b());
        frameLayout.setOnTouchListener(new c(this));
        return this.f3193e;
    }

    @Override // b.b.k.o
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f3192d;
        if (bottomSheetBehavior != null && bottomSheetBehavior.x == 5) {
            bottomSheetBehavior.L(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f != z) {
            this.f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f3192d;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.J(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f) {
            this.f = true;
        }
        this.g = z;
        this.h = true;
    }

    @Override // b.b.k.o, android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(e(i2, null, null));
    }

    @Override // b.b.k.o, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(e(0, view, null));
    }

    @Override // b.b.k.o
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(e(0, view, layoutParams));
    }
}
