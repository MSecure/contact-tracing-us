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
import android.util.Log;
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
import e.i.i.m;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class w extends Spinner {

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f960j = {16843505};
    public final e b;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f961d;

    /* renamed from: e  reason: collision with root package name */
    public SpinnerAdapter f962e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f963f;

    /* renamed from: g  reason: collision with root package name */
    public f f964g;

    /* renamed from: h  reason: collision with root package name */
    public int f965h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f966i = new Rect();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().c()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public class b implements f, DialogInterface.OnClickListener {
        public g b;
        public ListAdapter c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f967d;

        public b() {
        }

        @Override // e.b.f.w.f
        public void b(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // e.b.f.w.f
        public boolean c() {
            g gVar = this.b;
            if (gVar != null) {
                return gVar.isShowing();
            }
            return false;
        }

        @Override // e.b.f.w.f
        public int d() {
            return 0;
        }

        @Override // e.b.f.w.f
        public void dismiss() {
            g gVar = this.b;
            if (gVar != null) {
                gVar.dismiss();
                this.b = null;
            }
        }

        @Override // e.b.f.w.f
        public void e(int i2, int i3) {
            if (this.c != null) {
                g.a aVar = new g.a(w.this.getPopupContext());
                CharSequence charSequence = this.f967d;
                if (charSequence != null) {
                    aVar.a.f27d = charSequence;
                }
                ListAdapter listAdapter = this.c;
                int selectedItemPosition = w.this.getSelectedItemPosition();
                AlertController.b bVar = aVar.a;
                bVar.o = listAdapter;
                bVar.p = this;
                bVar.r = selectedItemPosition;
                bVar.q = true;
                g a = aVar.a();
                this.b = a;
                ListView listView = a.f657d.f21g;
                listView.setTextDirection(i2);
                listView.setTextAlignment(i3);
                this.b.show();
            }
        }

        @Override // e.b.f.w.f
        public int g() {
            return 0;
        }

        @Override // e.b.f.w.f
        public Drawable i() {
            return null;
        }

        @Override // e.b.f.w.f
        public CharSequence j() {
            return this.f967d;
        }

        @Override // e.b.f.w.f
        public void l(CharSequence charSequence) {
            this.f967d = charSequence;
        }

        @Override // e.b.f.w.f
        public void m(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // e.b.f.w.f
        public void n(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // e.b.f.w.f
        public void o(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            w.this.setSelection(i2);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i2, this.c.getItemId(i2));
            }
            g gVar = this.b;
            if (gVar != null) {
                gVar.dismiss();
                this.b = null;
            }
        }

        @Override // e.b.f.w.f
        public void p(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

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
            } else if (spinnerAdapter instanceof u0) {
                u0 u0Var = (u0) spinnerAdapter;
                if (u0Var.getDropDownViewTheme() == null) {
                    u0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class d extends k0 implements f {
        public CharSequence E;
        public ListAdapter F;
        public final Rect G = new Rect();
        public int H;

        public class a implements AdapterView.OnItemClickListener {
            public a(w wVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                w.this.setSelection(i2);
                if (w.this.getOnItemClickListener() != null) {
                    d dVar = d.this;
                    w.this.performItemClick(view, i2, dVar.F.getItemId(i2));
                }
                d.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            public void onGlobalLayout() {
                d dVar = d.this;
                w wVar = w.this;
                Objects.requireNonNull(dVar);
                AtomicInteger atomicInteger = m.a;
                if (!(wVar.isAttachedToWindow() && wVar.getGlobalVisibleRect(dVar.G))) {
                    d.this.dismiss();
                    return;
                }
                d.this.t();
                d.this.a();
            }
        }

        public class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.b = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.b);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2, 0);
            this.q = w.this;
            s(true);
            this.o = 0;
            this.r = new a(w.this);
        }

        @Override // e.b.f.w.f
        public void e(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            t();
            this.A.setInputMethodMode(2);
            a();
            f0 f0Var = this.f912d;
            f0Var.setChoiceMode(1);
            f0Var.setTextDirection(i2);
            f0Var.setTextAlignment(i3);
            int selectedItemPosition = w.this.getSelectedItemPosition();
            f0 f0Var2 = this.f912d;
            if (c() && f0Var2 != null) {
                f0Var2.setListSelectionHidden(false);
                f0Var2.setSelection(selectedItemPosition);
                if (f0Var2.getChoiceMode() != 0) {
                    f0Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!c2 && (viewTreeObserver = w.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                this.A.setOnDismissListener(new c(bVar));
            }
        }

        @Override // e.b.f.w.f
        public CharSequence j() {
            return this.E;
        }

        @Override // e.b.f.w.f
        public void l(CharSequence charSequence) {
            this.E = charSequence;
        }

        @Override // e.b.f.k0, e.b.f.w.f
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.F = listAdapter;
        }

        @Override // e.b.f.w.f
        public void p(int i2) {
            this.H = i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
        public void t() {
            int i2;
            Drawable i3 = i();
            int i4 = 0;
            if (i3 != null) {
                i3.getPadding(w.this.f966i);
                i4 = e1.a(w.this) ? w.this.f966i.right : -w.this.f966i.left;
            } else {
                Rect rect = w.this.f966i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i5 = wVar.f965h;
            if (i5 == -2) {
                int a2 = wVar.a((SpinnerAdapter) this.F, i());
                int i6 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = w.this.f966i;
                int i7 = (i6 - rect2.left) - rect2.right;
                if (a2 > i7) {
                    a2 = i7;
                }
                i2 = Math.max(a2, (width - paddingLeft) - paddingRight);
            } else if (i5 == -1) {
                i2 = (width - paddingLeft) - paddingRight;
            } else {
                r(i5);
                this.f915g = !e1.a(w.this) ? (((width - paddingRight) - this.f914f) - this.H) + i4 : paddingLeft + this.H + i4;
            }
            r(i2);
            this.f915g = !e1.a(w.this) ? (((width - paddingRight) - this.f914f) - this.H) + i4 : paddingLeft + this.H + i4;
        }
    }

    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public boolean b;

        public class a implements Parcelable.Creator<e> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
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

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.b ? (byte) 1 : 0);
        }
    }

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

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r4 != null) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00da  */
    public w(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Throwable th;
        TypedArray typedArray;
        Exception e2;
        t0.a(this, getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Spinner, i2, 0);
        this.b = new e(this);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Spinner_popupTheme, 0);
        if (resourceId != 0) {
            this.c = new e.b.e.c(context, resourceId);
        } else {
            this.c = context;
        }
        TypedArray typedArray2 = null;
        int i3 = -1;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, f960j, i2, 0);
            try {
                if (typedArray.hasValue(0)) {
                    i3 = typedArray.getInt(0, 0);
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e2);
                } catch (Throwable th2) {
                    th = th2;
                    typedArray2 = typedArray;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            typedArray = null;
            Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e2);
        } catch (Throwable th3) {
            th = th3;
            if (typedArray2 != null) {
            }
            throw th;
        }
        typedArray.recycle();
        if (i3 == 0) {
            b bVar = new b();
            this.f964g = bVar;
            bVar.l(obtainStyledAttributes.getString(R$styleable.Spinner_android_prompt));
        } else if (i3 == 1) {
            d dVar = new d(this.c, attributeSet, i2);
            y0 q = y0.q(this.c, attributeSet, R$styleable.Spinner, i2, 0);
            this.f965h = q.k(R$styleable.Spinner_android_dropDownWidth, -2);
            dVar.A.setBackgroundDrawable(q.g(R$styleable.Spinner_android_popupBackground));
            dVar.E = obtainStyledAttributes.getString(R$styleable.Spinner_android_prompt);
            q.b.recycle();
            this.f964g = dVar;
            this.f961d = new v(this, this, dVar);
        }
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(R$styleable.Spinner_android_entries);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(R$layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
        this.f963f = true;
        SpinnerAdapter spinnerAdapter = this.f962e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f962e = null;
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
        drawable.getPadding(this.f966i);
        Rect rect = this.f966i;
        return i3 + rect.left + rect.right;
    }

    public void b() {
        this.f964g.e(getTextDirection(), getTextAlignment());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        f fVar = this.f964g;
        return fVar != null ? fVar.d() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        f fVar = this.f964g;
        return fVar != null ? fVar.g() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.f964g != null ? this.f965h : super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.f964g;
    }

    public Drawable getPopupBackground() {
        f fVar = this.f964g;
        return fVar != null ? fVar.i() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.c;
    }

    public CharSequence getPrompt() {
        f fVar = this.f964g;
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

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f964g;
        if (fVar != null && fVar.c()) {
            this.f964g.dismiss();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f964g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (eVar.b && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.f964g;
        eVar.b = fVar != null && fVar.c();
        return eVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f961d;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        f fVar = this.f964g;
        if (fVar == null) {
            return super.performClick();
        }
        if (fVar.c()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.AbsSpinner, android.widget.Spinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f963f) {
            this.f962e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f964g != null) {
            Context context = this.c;
            if (context == null) {
                context = getContext();
            }
            this.f964g.o(new c(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.f964g;
        if (fVar != null) {
            fVar.p(i2);
            this.f964g.b(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.f964g;
        if (fVar != null) {
            fVar.n(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f964g != null) {
            this.f965h = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f964g;
        if (fVar != null) {
            fVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(e.b.b.a.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f964g;
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
