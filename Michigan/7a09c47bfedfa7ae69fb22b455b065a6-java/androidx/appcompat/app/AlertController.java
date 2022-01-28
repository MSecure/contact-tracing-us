package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import b.b.j;
import b.b.k.o;
import java.lang.ref.WeakReference;

public class AlertController {
    public NestedScrollView A;
    public int B = 0;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int I = -1;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public int Q = 0;
    public Handler R;
    public final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Context f49a;

    /* renamed from: b  reason: collision with root package name */
    public final o f50b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f51c;

    /* renamed from: d  reason: collision with root package name */
    public final int f52d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f53e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f54f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f55g;
    public View h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n = false;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;

    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        public final int f56b;

        /* renamed from: c  reason: collision with root package name */
        public final int f57c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.f57c = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.f56b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view != alertController.o || (message3 = alertController.q) == null) {
                AlertController alertController2 = AlertController.this;
                if (view != alertController2.s || (message3 = alertController2.u) == null) {
                    AlertController alertController3 = AlertController.this;
                    message = (view != alertController3.w || (message2 = alertController3.y) == null) ? null : Message.obtain(message2);
                    if (message != null) {
                        message.sendToTarget();
                    }
                    AlertController alertController4 = AlertController.this;
                    alertController4.R.obtainMessage(1, alertController4.f50b).sendToTarget();
                }
            }
            message = Message.obtain(message3);
            if (message != null) {
            }
            AlertController alertController42 = AlertController.this;
            alertController42.R.obtainMessage(1, alertController42.f50b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f59a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f60b;

        /* renamed from: c  reason: collision with root package name */
        public int f61c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f62d;

        /* renamed from: e  reason: collision with root package name */
        public int f63e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f64f;

        /* renamed from: g  reason: collision with root package name */
        public View f65g;
        public CharSequence h;
        public CharSequence i;
        public DialogInterface.OnClickListener j;
        public CharSequence k;
        public DialogInterface.OnClickListener l;
        public boolean m;
        public DialogInterface.OnCancelListener n;
        public DialogInterface.OnDismissListener o;
        public DialogInterface.OnKeyListener p;
        public ListAdapter q;
        public DialogInterface.OnClickListener r;
        public int s;
        public View t;
        public boolean u = false;
        public boolean v;
        public int w = -1;

        public b(Context context) {
            this.f59a = context;
            this.m = true;
            this.f60b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    public static final class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<DialogInterface> f66a;

        public c(DialogInterface dialogInterface) {
            this.f66a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f66a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, (Object[]) null);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, o oVar, Window window) {
        this.f49a = context;
        this.f50b = oVar;
        this.f51c = window;
        this.R = new c(oVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, b.b.a.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.f52d = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        oVar.c(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void c(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public final ViewGroup d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public void e(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Message obtainMessage = onClickListener != null ? this.R.obtainMessage(i2, onClickListener) : null;
        if (i2 == -3) {
            this.x = charSequence;
            this.y = obtainMessage;
            this.z = null;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = obtainMessage;
            this.v = null;
        } else if (i2 == -1) {
            this.p = charSequence;
            this.q = obtainMessage;
            this.r = null;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void f(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }
}
