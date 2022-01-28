package b.b.k;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;
import b.b.f;
import b.b.q.i0;
import b.i.l.m;

public class e extends o implements DialogInterface {

    /* renamed from: d  reason: collision with root package name */
    public final AlertController f364d = new AlertController(getContext(), this, getWindow());

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AlertController.b f365a;

        /* renamed from: b  reason: collision with root package name */
        public final int f366b;

        public a(Context context) {
            int d2 = e.d(context, 0);
            this.f365a = new AlertController.b(new ContextThemeWrapper(context, e.d(context, d2)));
            this.f366b = d2;
        }

        public a(Context context, int i) {
            this.f365a = new AlertController.b(new ContextThemeWrapper(context, e.d(context, i)));
            this.f366b = i;
        }

        public e a() {
            e eVar = new e(this.f365a.f27a, this.f366b);
            AlertController.b bVar = this.f365a;
            AlertController alertController = eVar.f364d;
            View view = bVar.g;
            if (view != null) {
                alertController.G = view;
            } else {
                CharSequence charSequence = bVar.f;
                if (charSequence != null) {
                    alertController.f23e = charSequence;
                    TextView textView = alertController.E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.f30d;
                if (drawable != null) {
                    alertController.C = drawable;
                    alertController.B = 0;
                    ImageView imageView = alertController.D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.D.setImageDrawable(drawable);
                    }
                }
                int i = bVar.f29c;
                if (i != 0) {
                    alertController.f(i);
                }
                int i2 = bVar.f31e;
                if (i2 != 0) {
                    if (alertController != null) {
                        TypedValue typedValue = new TypedValue();
                        alertController.f19a.getTheme().resolveAttribute(i2, typedValue, true);
                        alertController.f(typedValue.resourceId);
                    } else {
                        throw null;
                    }
                }
            }
            CharSequence charSequence2 = bVar.h;
            if (charSequence2 != null) {
                alertController.f = charSequence2;
                TextView textView2 = alertController.F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.i;
            if (charSequence3 != null) {
                alertController.e(-1, charSequence3, bVar.j, null, null);
            }
            CharSequence charSequence4 = bVar.k;
            if (charSequence4 != null) {
                alertController.e(-2, charSequence4, bVar.l, null, null);
            }
            if (bVar.q != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.f28b.inflate(alertController.L, (ViewGroup) null);
                int i3 = bVar.t ? alertController.N : alertController.O;
                ListAdapter listAdapter = bVar.q;
                if (listAdapter == null) {
                    listAdapter = new AlertController.d(bVar.f27a, i3, 16908308, null);
                }
                alertController.H = listAdapter;
                alertController.I = bVar.u;
                if (bVar.r != null) {
                    recycleListView.setOnItemClickListener(new d(bVar, alertController));
                }
                if (bVar.t) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.g = recycleListView;
            }
            eVar.setCancelable(this.f365a.m);
            if (this.f365a.m) {
                eVar.setCanceledOnTouchOutside(true);
            }
            eVar.setOnCancelListener(this.f365a.n);
            eVar.setOnDismissListener(this.f365a.o);
            DialogInterface.OnKeyListener onKeyListener = this.f365a.p;
            if (onKeyListener != null) {
                eVar.setOnKeyListener(onKeyListener);
            }
            return eVar;
        }
    }

    public e(Context context, int i) {
        super(context, d(context, i));
    }

    public static int d(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.b.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void e(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f364d.e(i, charSequence, onClickListener, null, null);
    }

    public void f(CharSequence charSequence) {
        AlertController alertController = this.f364d;
        alertController.f = charSequence;
        TextView textView = alertController.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02df, code lost:
        if (r4 != null) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02e8, code lost:
        if (r4 != null) goto L_0x02ea;
     */
    @Override // b.b.k.o
    public void onCreate(Bundle bundle) {
        boolean z;
        ListAdapter listAdapter;
        View view;
        View findViewById;
        Button button;
        super.onCreate(bundle);
        AlertController alertController = this.f364d;
        int i = alertController.K;
        if (i == 0 || alertController.Q != 1) {
            i = alertController.J;
        }
        alertController.f20b.setContentView(i);
        View findViewById2 = alertController.f21c.findViewById(f.parentPanel);
        View findViewById3 = findViewById2.findViewById(f.topPanel);
        View findViewById4 = findViewById2.findViewById(f.contentPanel);
        View findViewById5 = findViewById2.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(f.customPanel);
        View view2 = alertController.h;
        int i2 = 0;
        if (view2 == null) {
            view2 = alertController.i != 0 ? LayoutInflater.from(alertController.f19a).inflate(alertController.i, viewGroup, false) : null;
        }
        boolean z2 = view2 != null;
        if (!z2 || !AlertController.a(view2)) {
            alertController.f21c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.f21c.findViewById(f.custom);
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.n) {
                frameLayout.setPadding(alertController.j, alertController.k, alertController.l, alertController.m);
            }
            if (alertController.g != null) {
                ((i0.a) viewGroup.getLayoutParams()).f657a = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(f.topPanel);
        View findViewById7 = viewGroup.findViewById(f.contentPanel);
        View findViewById8 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup d2 = alertController.d(findViewById6, findViewById3);
        ViewGroup d3 = alertController.d(findViewById7, findViewById4);
        ViewGroup d4 = alertController.d(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.f21c.findViewById(f.scrollView);
        alertController.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) d3.findViewById(16908299);
        alertController.F = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.A.removeView(alertController.F);
                if (alertController.g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    d3.setVisibility(8);
                }
            }
        }
        Button button2 = (Button) d4.findViewById(16908313);
        alertController.o = button2;
        button2.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.p) || alertController.r != null) {
            alertController.o.setText(alertController.p);
            Drawable drawable = alertController.r;
            if (drawable != null) {
                int i3 = alertController.f22d;
                drawable.setBounds(0, 0, i3, i3);
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
        button3.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.t) || alertController.v != null) {
            alertController.s.setText(alertController.t);
            Drawable drawable2 = alertController.v;
            if (drawable2 != null) {
                int i4 = alertController.f22d;
                drawable2.setBounds(0, 0, i4, i4);
                alertController.s.setCompoundDrawables(alertController.v, null, null, null);
            }
            alertController.s.setVisibility(0);
            z |= true;
        } else {
            alertController.s.setVisibility(8);
        }
        Button button4 = (Button) d4.findViewById(16908315);
        alertController.w = button4;
        button4.setOnClickListener(alertController.S);
        if (!TextUtils.isEmpty(alertController.x) || alertController.z != null) {
            alertController.w.setText(alertController.x);
            Drawable drawable3 = alertController.z;
            if (drawable3 != null) {
                int i5 = alertController.f22d;
                drawable3.setBounds(0, 0, i5, i5);
                alertController.w.setCompoundDrawables(alertController.z, null, null, null);
            }
            alertController.w.setVisibility(0);
            z |= true;
        } else {
            alertController.w.setVisibility(8);
        }
        Context context = alertController.f19a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(b.b.a.alertDialogCenterButtons, typedValue, true);
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
            alertController.f21c.findViewById(f.title_template).setVisibility(8);
        } else {
            alertController.D = (ImageView) alertController.f21c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.f23e)) || !alertController.P) {
                alertController.f21c.findViewById(f.title_template).setVisibility(8);
                alertController.D.setVisibility(8);
                d2.setVisibility(8);
            } else {
                TextView textView2 = (TextView) alertController.f21c.findViewById(f.alertTitle);
                alertController.E = textView2;
                textView2.setText(alertController.f23e);
                int i6 = alertController.B;
                if (i6 != 0) {
                    alertController.D.setImageResource(i6);
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
        int i7 = (d2 == null || d2.getVisibility() == 8) ? 0 : 1;
        boolean z4 = d4.getVisibility() != 8;
        if (!z4 && (findViewById = d3.findViewById(f.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i7 != 0) {
            NestedScrollView nestedScrollView2 = alertController.A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            view = (alertController.f == null && alertController.g == null) ? null : d2.findViewById(f.titleDividerNoCustom);
        } else {
            view = d3.findViewById(f.textSpacerNoTitle);
        }
        view.setVisibility(0);
        ListView listView = alertController.g;
        if (listView instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) listView;
            if (recycleListView == null) {
                throw null;
            } else if (!z4 || i7 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i7 != 0 ? recycleListView.getPaddingTop() : recycleListView.f24b, recycleListView.getPaddingRight(), z4 ? recycleListView.getPaddingBottom() : recycleListView.f25c);
            }
        }
        if (!z3) {
            View view3 = alertController.g;
            if (view3 == null) {
                view3 = alertController.A;
            }
            if (view3 != null) {
                if (z4) {
                    i2 = 2;
                }
                int i8 = i7 | i2;
                View findViewById9 = alertController.f21c.findViewById(f.scrollIndicatorUp);
                View findViewById10 = alertController.f21c.findViewById(f.scrollIndicatorDown);
                m.d0(view3, i8, 3);
                if (findViewById9 != null) {
                    d3.removeView(findViewById9);
                }
                if (findViewById10 != null) {
                    d3.removeView(findViewById10);
                }
            }
        }
        ListView listView2 = alertController.g;
        if (listView2 != null && (listAdapter = alertController.H) != null) {
            listView2.setAdapter(listAdapter);
            int i9 = alertController.I;
            if (i9 > -1) {
                listView2.setItemChecked(i9, true);
                listView2.setSelection(i9);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f364d.A;
        if (nestedScrollView != null && nestedScrollView.l(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f364d.A;
        if (nestedScrollView != null && nestedScrollView.l(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // b.b.k.o, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f364d;
        alertController.f23e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
