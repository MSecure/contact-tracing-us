package e.b.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertController;
import e.b.a.g;
import e.b.a.m;
import e.j.j.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class z extends Spinner {

    /* renamed from: j */
    public static final int[] f1056j = {16843505};
    public final Context c;

    /* renamed from: d */
    public l0 f1057d;

    /* renamed from: e */
    public SpinnerAdapter f1058e;

    /* renamed from: f */
    public final boolean f1059f;

    /* renamed from: g */
    public f f1060g;

    /* renamed from: h */
    public int f1061h;

    /* renamed from: i */
    public final Rect f1062i = new Rect();
    public final e b = new e(this);

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
            z.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!z.this.getInternalPopup().c()) {
                z.this.b();
            }
            ViewTreeObserver viewTreeObserver = z.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f, DialogInterface.OnClickListener {
        public g b;
        public ListAdapter c;

        /* renamed from: d */
        public CharSequence f1063d;

        public b() {
            z.this = r1;
        }

        @Override // e.b.f.z.f
        public void b(int i2) {
        }

        @Override // e.b.f.z.f
        public boolean c() {
            g gVar = this.b;
            if (gVar != null) {
                return gVar.isShowing();
            }
            return false;
        }

        @Override // e.b.f.z.f
        public int d() {
            return 0;
        }

        @Override // e.b.f.z.f
        public void dismiss() {
            g gVar = this.b;
            if (gVar != null) {
                gVar.dismiss();
                this.b = null;
            }
        }

        @Override // e.b.f.z.f
        public void e(int i2, int i3) {
            if (this.c != null) {
                g.a aVar = new g.a(z.this.getPopupContext());
                CharSequence charSequence = this.f1063d;
                if (charSequence != null) {
                    aVar.a.f31d = charSequence;
                }
                ListAdapter listAdapter = this.c;
                int selectedItemPosition = z.this.getSelectedItemPosition();
                AlertController.b bVar = aVar.a;
                bVar.o = listAdapter;
                bVar.p = this;
                bVar.t = selectedItemPosition;
                bVar.s = true;
                g a = aVar.a();
                this.b = a;
                ListView listView = a.f714d.f25g;
                listView.setTextDirection(i2);
                listView.setTextAlignment(i3);
                this.b.show();
            }
        }

        @Override // e.b.f.z.f
        public int g() {
            return 0;
        }

        @Override // e.b.f.z.f
        public Drawable i() {
            return null;
        }

        @Override // e.b.f.z.f
        public CharSequence j() {
            return this.f1063d;
        }

        @Override // e.b.f.z.f
        public void l(CharSequence charSequence) {
            this.f1063d = charSequence;
        }

        @Override // e.b.f.z.f
        public void m(Drawable drawable) {
        }

        @Override // e.b.f.z.f
        public void n(int i2) {
        }

        @Override // e.b.f.z.f
        public void o(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            z.this.setSelection(i2);
            if (z.this.getOnItemClickListener() != null) {
                z.this.performItemClick(null, i2, this.c.getItemId(i2));
            }
            g gVar = this.b;
            if (gVar != null) {
                gVar.dismiss();
                this.b = null;
            }
        }

        @Override // e.b.f.z.f
        public void p(int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class c implements ListAdapter, SpinnerAdapter {
        public SpinnerAdapter b;
        public ListAdapter c;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof y0) {
                y0 y0Var = (y0) spinnerAdapter;
                if (y0Var.getDropDownViewTheme() == null) {
                    y0Var.setDropDownViewTheme(theme);
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i2) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends o0 implements f {
        public CharSequence E;
        public ListAdapter F;
        public final Rect G = new Rect();
        public int H;

        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {
            public a(z zVar) {
                d.this = r1;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                z.this.setSelection(i2);
                if (z.this.getOnItemClickListener() != null) {
                    d dVar = d.this;
                    z.this.performItemClick(view, i2, dVar.F.getItemId(i2));
                }
                d.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
                d.this = r1;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                d dVar = d.this;
                z zVar = z.this;
                Objects.requireNonNull(dVar);
                AtomicInteger atomicInteger = v.a;
                if (!(v.g.b(zVar) && zVar.getGlobalVisibleRect(dVar.G))) {
                    d.this.dismiss();
                    return;
                }
                d.this.t();
                d.this.a();
            }
        }

        /* loaded from: classes.dex */
        public class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                d.this = r1;
                this.b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = z.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2, 0);
            z.this = r2;
            this.q = r2;
            s(true);
            this.o = 0;
            this.r = new a(r2);
        }

        @Override // e.b.f.z.f
        public void e(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            t();
            this.A.setInputMethodMode(2);
            a();
            j0 j0Var = this.f1004d;
            j0Var.setChoiceMode(1);
            j0Var.setTextDirection(i2);
            j0Var.setTextAlignment(i3);
            int selectedItemPosition = z.this.getSelectedItemPosition();
            j0 j0Var2 = this.f1004d;
            if (c() && j0Var2 != null) {
                j0Var2.setListSelectionHidden(false);
                j0Var2.setSelection(selectedItemPosition);
                if (j0Var2.getChoiceMode() != 0) {
                    j0Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!c2 && (viewTreeObserver = z.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                this.A.setOnDismissListener(new c(bVar));
            }
        }

        @Override // e.b.f.z.f
        public CharSequence j() {
            return this.E;
        }

        @Override // e.b.f.z.f
        public void l(CharSequence charSequence) {
            this.E = charSequence;
        }

        @Override // e.b.f.o0, e.b.f.z.f
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.F = listAdapter;
        }

        @Override // e.b.f.z.f
        public void p(int i2) {
            this.H = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void t() {
            int i2;
            Drawable i3 = i();
            int i4 = 0;
            if (i3 != null) {
                i3.getPadding(z.this.f1062i);
                i4 = i1.a(z.this) ? z.this.f1062i.right : -z.this.f1062i.left;
            } else {
                Rect rect = z.this.f1062i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = z.this.getPaddingLeft();
            int paddingRight = z.this.getPaddingRight();
            int width = z.this.getWidth();
            z zVar = z.this;
            int i5 = zVar.f1061h;
            if (i5 == -2) {
                int a2 = zVar.a((SpinnerAdapter) this.F, i());
                int i6 = z.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = z.this.f1062i;
                int i7 = (i6 - rect2.left) - rect2.right;
                if (a2 > i7) {
                    a2 = i7;
                }
                i2 = Math.max(a2, (width - paddingLeft) - paddingRight);
            } else if (i5 == -1) {
                i2 = (width - paddingLeft) - paddingRight;
            } else {
                r(i5);
                this.f1007g = !i1.a(z.this) ? (((width - paddingRight) - this.f1006f) - this.H) + i4 : paddingLeft + this.H + i4;
            }
            r(i2);
            this.f1007g = !i1.a(z.this) ? (((width - paddingRight) - this.f1006f) - this.H) + i4 : paddingLeft + this.H + i4;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public boolean b;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e(Parcel parcel) {
            super(parcel);
            this.b = parcel.readByte() != 0;
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.b ? (byte) 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void b(int i2);

        boolean c();

        int d();

        void dismiss();

        void e(int i2, int i3);

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(Drawable drawable);

        void n(int i2);

        void o(ListAdapter listAdapter);

        void p(int i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r4 == null) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public z(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        Throwable th;
        x0.a(this, getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Spinner, i2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Spinner_popupTheme, 0);
        if (resourceId != 0) {
            this.c = new e.b.e.c(context, resourceId);
        } else {
            this.c = context;
        }
        TypedArray typedArray2 = null;
        int i3 = -1;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, f1056j, i2, 0);
        } catch (Exception unused) {
            typedArray = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (typedArray.hasValue(0)) {
                i3 = typedArray.getInt(0, 0);
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            typedArray2 = typedArray;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArray.recycle();
        if (i3 == 0) {
            b bVar = new b();
            this.f1060g = bVar;
            bVar.l(obtainStyledAttributes.getString(R$styleable.Spinner_android_prompt));
        } else if (i3 == 1) {
            d dVar = new d(this.c, attributeSet, i2);
            c1 q = c1.q(this.c, attributeSet, R$styleable.Spinner, i2, 0);
            this.f1061h = q.k(R$styleable.Spinner_android_dropDownWidth, -2);
            dVar.A.setBackgroundDrawable(q.g(R$styleable.Spinner_android_popupBackground));
            dVar.E = obtainStyledAttributes.getString(R$styleable.Spinner_android_prompt);
            q.b.recycle();
            this.f1060g = dVar;
            this.f1057d = new y(this, this, dVar);
        }
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(R$styleable.Spinner_android_entries);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(R$layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
        this.f1059f = true;
        SpinnerAdapter spinnerAdapter = this.f1058e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f1058e = null;
        }
        this.b.d(attributeSet, i2);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f1062i);
        Rect rect = this.f1062i;
        return i3 + rect.left + rect.right;
    }

    public void b() {
        this.f1060g.e(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.f1060g;
        return fVar != null ? fVar.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.f1060g;
        return fVar != null ? fVar.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1060g != null ? this.f1061h : super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.f1060g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.f1060g;
        return fVar != null ? fVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.f1060g;
        return fVar != null ? fVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.view.View, android.widget.AdapterView, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f1060g;
        if (fVar != null && fVar.c()) {
            this.f1060g.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1060g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (eVar.b && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.f1060g;
        eVar.b = fVar != null && fVar.c();
        return eVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        l0 l0Var = this.f1057d;
        if (l0Var == null || !l0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        f fVar = this.f1060g;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.c()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1059f) {
            this.f1058e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1060g != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            this.f1060g.o(new c(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.f1060g;
        if (fVar != null) {
            fVar.p(i2);
            this.f1060g.b(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.f1060g;
        if (fVar != null) {
            fVar.n(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i2) {
        if (this.f1060g != null) {
            this.f1061h = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f1060g;
        if (fVar != null) {
            fVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(m.e.i0(getPopupContext(), i2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f1060g;
        if (fVar != null) {
            fVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }
}
