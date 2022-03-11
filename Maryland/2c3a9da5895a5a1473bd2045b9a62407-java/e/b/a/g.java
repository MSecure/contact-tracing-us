package e.b.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import e.b.f.i0;
import e.i.i.m;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class g extends r implements DialogInterface {

    /* renamed from: d  reason: collision with root package name */
    public final AlertController f657d = new AlertController(getContext(), this, getWindow());

    public static class a {
        public final AlertController.b a;
        public final int b;

        public a(Context context) {
            int c = g.c(context, 0);
            this.a = new AlertController.b(new ContextThemeWrapper(context, g.c(context, c)));
            this.b = c;
        }

        public a(Context context, int i2) {
            this.a = new AlertController.b(new ContextThemeWrapper(context, g.c(context, i2)));
            this.b = i2;
        }

        public g a() {
            g gVar = new g(this.a.a, this.b);
            AlertController.b bVar = this.a;
            AlertController alertController = gVar.f657d;
            View view = bVar.f28e;
            if (view != null) {
                alertController.G = view;
            } else {
                CharSequence charSequence = bVar.f27d;
                if (charSequence != null) {
                    alertController.f19e = charSequence;
                    TextView textView = alertController.E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.c;
                if (drawable != null) {
                    alertController.C = drawable;
                    alertController.B = 0;
                    ImageView imageView = alertController.D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.D.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = bVar.f29f;
            if (charSequence2 != null) {
                alertController.f20f = charSequence2;
                TextView textView2 = alertController.F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.f30g;
            if (charSequence3 != null) {
                alertController.e(-1, charSequence3, bVar.f31h, null, null);
            }
            CharSequence charSequence4 = bVar.f32i;
            if (charSequence4 != null) {
                alertController.e(-2, charSequence4, bVar.f33j, null, null);
            }
            if (bVar.o != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.b.inflate(alertController.L, (ViewGroup) null);
                int i2 = bVar.q ? alertController.N : alertController.O;
                ListAdapter listAdapter = bVar.o;
                if (listAdapter == null) {
                    listAdapter = new AlertController.d(bVar.a, i2, 16908308, null);
                }
                alertController.H = listAdapter;
                alertController.I = bVar.r;
                if (bVar.p != null) {
                    recycleListView.setOnItemClickListener(new f(bVar, alertController));
                }
                if (bVar.q) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.f21g = recycleListView;
            }
            gVar.setCancelable(this.a.f34k);
            if (this.a.f34k) {
                gVar.setCanceledOnTouchOutside(true);
            }
            gVar.setOnCancelListener(this.a.f35l);
            gVar.setOnDismissListener(this.a.m);
            DialogInterface.OnKeyListener onKeyListener = this.a.n;
            if (onKeyListener != null) {
                gVar.setOnKeyListener(onKeyListener);
            }
            return gVar;
        }

        public g b() {
            g a2 = a();
            a2.show();
            return a2;
        }
    }

    public g(Context context, int i2) {
        super(context, c(context, i2));
    }

    public static int c(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02da, code lost:
        if (r3 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02e3, code lost:
        if (r3 != null) goto L_0x02e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0346, code lost:
        if (r7 != null) goto L_0x039a;
     */
    @Override // e.b.a.r
    public void onCreate(Bundle bundle) {
        boolean z;
        View view;
        ListAdapter listAdapter;
        View view2;
        View view3;
        View findViewById;
        Button button;
        super.onCreate(bundle);
        AlertController alertController = this.f657d;
        int i2 = alertController.K;
        alertController.b.setContentView(alertController.J);
        View findViewById2 = alertController.c.findViewById(R$id.parentPanel);
        int i3 = R$id.topPanel;
        View findViewById3 = findViewById2.findViewById(i3);
        int i4 = R$id.contentPanel;
        View findViewById4 = findViewById2.findViewById(i4);
        int i5 = R$id.buttonPanel;
        View findViewById5 = findViewById2.findViewById(i5);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R$id.customPanel);
        View view4 = alertController.f22h;
        int i6 = 0;
        if (view4 == null) {
            view4 = alertController.f23i != 0 ? LayoutInflater.from(alertController.a).inflate(alertController.f23i, viewGroup, false) : null;
        }
        boolean z2 = view4 != null;
        if (!z2 || !AlertController.a(view4)) {
            alertController.c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.c.findViewById(R$id.custom);
            frameLayout.addView(view4, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.n) {
                frameLayout.setPadding(alertController.f24j, alertController.f25k, alertController.f26l, alertController.m);
            }
            if (alertController.f21g != null) {
                ((LinearLayout.LayoutParams) ((i0.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(i3);
        View findViewById7 = viewGroup.findViewById(i4);
        View findViewById8 = viewGroup.findViewById(i5);
        ViewGroup d2 = alertController.d(findViewById6, findViewById3);
        ViewGroup d3 = alertController.d(findViewById7, findViewById4);
        ViewGroup d4 = alertController.d(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.c.findViewById(R$id.scrollView);
        alertController.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) d3.findViewById(16908299);
        alertController.F = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f20f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.A.removeView(alertController.F);
                if (alertController.f21g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.f21g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    d3.setVisibility(8);
                }
            }
        }
        Button button2 = (Button) d4.findViewById(16908313);
        alertController.o = button2;
        button2.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.p) || alertController.r != null) {
            alertController.o.setText(alertController.p);
            Drawable drawable = alertController.r;
            if (drawable != null) {
                int i7 = alertController.f18d;
                drawable.setBounds(0, 0, i7, i7);
                alertController.o.setCompoundDrawables(alertController.r, null, null, null);
            }
            alertController.o.setVisibility(0);
            z = true;
        } else {
            alertController.o.setVisibility(8);
            z = false;
        }
        Button button3 = (Button) d4.findViewById(16908314);
        alertController.s = button3;
        button3.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.t) || alertController.v != null) {
            alertController.s.setText(alertController.t);
            Drawable drawable2 = alertController.v;
            if (drawable2 != null) {
                int i8 = alertController.f18d;
                drawable2.setBounds(0, 0, i8, i8);
                alertController.s.setCompoundDrawables(alertController.v, null, null, null);
            }
            alertController.s.setVisibility(0);
            z |= true;
        } else {
            alertController.s.setVisibility(8);
        }
        Button button4 = (Button) d4.findViewById(16908315);
        alertController.w = button4;
        button4.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.x) || alertController.z != null) {
            alertController.w.setText(alertController.x);
            Drawable drawable3 = alertController.z;
            if (drawable3 != null) {
                int i9 = alertController.f18d;
                drawable3.setBounds(0, 0, i9, i9);
                view = null;
                alertController.w.setCompoundDrawables(alertController.z, null, null, null);
            } else {
                view = null;
            }
            alertController.w.setVisibility(0);
            z |= true;
        } else {
            alertController.w.setVisibility(8);
            view = null;
        }
        Context context = alertController.a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                button = alertController.o;
            } else if (z) {
                button = alertController.s;
            } else if (z) {
                button = alertController.w;
            }
            alertController.b(button);
        }
        if (!(z)) {
            d4.setVisibility(8);
        }
        if (alertController.G != null) {
            d2.addView(alertController.G, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.c.findViewById(R$id.title_template).setVisibility(8);
        } else {
            alertController.D = (ImageView) alertController.c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.f19e)) || !alertController.P) {
                alertController.c.findViewById(R$id.title_template).setVisibility(8);
                alertController.D.setVisibility(8);
                d2.setVisibility(8);
            } else {
                TextView textView2 = (TextView) alertController.c.findViewById(R$id.alertTitle);
                alertController.E = textView2;
                textView2.setText(alertController.f19e);
                int i10 = alertController.B;
                if (i10 != 0) {
                    alertController.D.setImageResource(i10);
                } else {
                    Drawable drawable4 = alertController.C;
                    if (drawable4 != null) {
                        alertController.D.setImageDrawable(drawable4);
                    } else {
                        alertController.E.setPadding(alertController.D.getPaddingLeft(), alertController.D.getPaddingTop(), alertController.D.getPaddingRight(), alertController.D.getPaddingBottom());
                        alertController.D.setVisibility(8);
                    }
                }
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        int i11 = (d2 == null || d2.getVisibility() == 8) ? 0 : 1;
        boolean z4 = d4.getVisibility() != 8;
        if (!z4 && (findViewById = d3.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = alertController.A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            view3 = (alertController.f20f == null && alertController.f21g == null) ? view : d2.findViewById(R$id.titleDividerNoCustom);
        } else {
            view3 = d3.findViewById(R$id.textSpacerNoTitle);
        }
        view3.setVisibility(0);
        ListView listView = alertController.f21g;
        if (listView instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) listView;
            Objects.requireNonNull(recycleListView);
            if (!z4 || i11 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i11 != 0 ? recycleListView.getPaddingTop() : recycleListView.b, recycleListView.getPaddingRight(), z4 ? recycleListView.getPaddingBottom() : recycleListView.c);
            }
        }
        if (!z3) {
            View view5 = alertController.f21g;
            if (view5 == null) {
                view5 = alertController.A;
            }
            if (view5 != null) {
                if (z4) {
                    i6 = 2;
                }
                int i12 = i11 | i6;
                View findViewById9 = alertController.c.findViewById(R$id.scrollIndicatorUp);
                View findViewById10 = alertController.c.findViewById(R$id.scrollIndicatorDown);
                int i13 = Build.VERSION.SDK_INT;
                if (i13 >= 23) {
                    AtomicInteger atomicInteger = m.a;
                    if (i13 >= 23) {
                        view5.setScrollIndicators(i12, 3);
                    }
                    if (findViewById9 != null) {
                        d3.removeView(findViewById9);
                    }
                } else {
                    if (findViewById9 != null && (i12 & 1) == 0) {
                        d3.removeView(findViewById9);
                        findViewById9 = view;
                    }
                    if (findViewById10 == null || (i12 & 2) != 0) {
                        view2 = findViewById10;
                    } else {
                        d3.removeView(findViewById10);
                        view2 = view;
                    }
                    if (!(findViewById9 == null && view2 == null)) {
                        if (alertController.f20f != null) {
                            alertController.A.setOnScrollChangeListener(new b(alertController, findViewById9, view2));
                            alertController.A.post(new c(alertController, findViewById9, view2));
                        } else {
                            ListView listView2 = alertController.f21g;
                            if (listView2 != null) {
                                listView2.setOnScrollListener(new d(alertController, findViewById9, view2));
                                alertController.f21g.post(new e(alertController, findViewById9, view2));
                            } else {
                                if (findViewById9 != null) {
                                    d3.removeView(findViewById9);
                                }
                                if (view2 != null) {
                                    findViewById10 = view2;
                                }
                            }
                        }
                    }
                }
                d3.removeView(findViewById10);
            }
        }
        ListView listView3 = alertController.f21g;
        if (listView3 != null && (listAdapter = alertController.H) != null) {
            listView3.setAdapter(listAdapter);
            int i14 = alertController.I;
            if (i14 > -1) {
                listView3.setItemChecked(i14, true);
                listView3.setSelection(i14);
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f657d.A;
        if (nestedScrollView != null && nestedScrollView.l(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f657d.A;
        if (nestedScrollView != null && nestedScrollView.l(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Dialog, e.b.a.r
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f657d;
        alertController.f19e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
