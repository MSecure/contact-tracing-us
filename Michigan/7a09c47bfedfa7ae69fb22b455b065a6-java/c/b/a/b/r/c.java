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
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class c extends o {

    /* renamed from: d  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f4505d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4506e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4507f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4508g;
    public boolean h;
    public BottomSheetBehavior.d i;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            c cVar = c.this;
            if (cVar.f4507f && cVar.isShowing()) {
                c cVar2 = c.this;
                if (!cVar2.h) {
                    TypedArray obtainStyledAttributes = cVar2.getContext().obtainStyledAttributes(new int[]{16843611});
                    cVar2.f4508g = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                    cVar2.h = true;
                }
                if (cVar2.f4508g) {
                    c.this.cancel();
                }
            }
        }
    }

    public class b extends b.i.l.a {
        public b() {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            boolean z;
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            if (c.this.f4507f) {
                bVar.f1906a.addAction(1048576);
                z = true;
            } else {
                z = false;
            }
            bVar.f1906a.setDismissable(z);
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                c cVar = c.this;
                if (cVar.f4507f) {
                    cVar.cancel();
                    return true;
                }
            }
            return super.g(view, i, bundle);
        }
    }

    /* renamed from: c.b.a.b.r.c$c  reason: collision with other inner class name */
    public class View$OnTouchListenerC0079c implements View.OnTouchListener {
        public View$OnTouchListenerC0079c(c cVar) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class d extends BottomSheetBehavior.d {
        public d() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void a(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public void b(View view, int i) {
            if (i == 5) {
                c.this.cancel();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public c(Context context, int i2) {
        super(context, i2);
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            i2 = context.getTheme().resolveAttribute(c.b.a.b.b.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : k.Theme_Design_Light_BottomSheetDialog;
        }
        this.f4507f = true;
        this.f4508g = true;
        this.i = new d();
        c(1);
    }

    public void cancel() {
        if (this.f4505d == null) {
            d();
        }
        super.cancel();
    }

    public final FrameLayout d() {
        if (this.f4506e == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), h.design_bottom_sheet_dialog, null);
            this.f4506e = frameLayout;
            BottomSheetBehavior<FrameLayout> H = BottomSheetBehavior.H((FrameLayout) frameLayout.findViewById(f.design_bottom_sheet));
            this.f4505d = H;
            BottomSheetBehavior.d dVar = this.i;
            if (!H.G.contains(dVar)) {
                H.G.add(dVar);
            }
            this.f4505d.J(this.f4507f);
        }
        return this.f4506e;
    }

    public final View e(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        d();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f4506e.findViewById(f.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f4506e.findViewById(f.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(f.touch_outside).setOnClickListener(new a());
        m.U(frameLayout, new b());
        frameLayout.setOnTouchListener(new View$OnTouchListenerC0079c(this));
        return this.f4506e;
    }

    @Override // b.b.k.o
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(BleSignal.UNKNOWN_TX_POWER);
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f4505d;
        if (bottomSheetBehavior != null && bottomSheetBehavior.x == 5) {
            bottomSheetBehavior.L(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f4507f != z) {
            this.f4507f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f4505d;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.J(z);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f4507f) {
            this.f4507f = true;
        }
        this.f4508g = z;
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
