package b.b.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.app.AlertController;
import b.b.g;
import b.b.j;
import b.b.k.e;
import b.i.l.m;

public class w extends Spinner {
    public static final int[] j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    public final e f727b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f728c;

    /* renamed from: d  reason: collision with root package name */
    public h0 f729d;

    /* renamed from: e  reason: collision with root package name */
    public SpinnerAdapter f730e;
    public final boolean f;
    public f g;
    public int h;
    public final Rect i = new Rect();

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

        /* renamed from: b  reason: collision with root package name */
        public b.b.k.e f732b;

        /* renamed from: c  reason: collision with root package name */
        public ListAdapter f733c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f734d;

        public b() {
        }

        @Override // b.b.q.w.f
        public void b(int i) {
        }

        @Override // b.b.q.w.f
        public boolean c() {
            b.b.k.e eVar = this.f732b;
            if (eVar != null) {
                return eVar.isShowing();
            }
            return false;
        }

        @Override // b.b.q.w.f
        public int d() {
            return 0;
        }

        @Override // b.b.q.w.f
        public void dismiss() {
            b.b.k.e eVar = this.f732b;
            if (eVar != null) {
                eVar.dismiss();
                this.f732b = null;
            }
        }

        @Override // b.b.q.w.f
        public void e(int i, int i2) {
            if (this.f733c != null) {
                e.a aVar = new e.a(w.this.getPopupContext());
                CharSequence charSequence = this.f734d;
                if (charSequence != null) {
                    aVar.f365a.f = charSequence;
                }
                ListAdapter listAdapter = this.f733c;
                int selectedItemPosition = w.this.getSelectedItemPosition();
                AlertController.b bVar = aVar.f365a;
                bVar.q = listAdapter;
                bVar.r = this;
                bVar.u = selectedItemPosition;
                bVar.t = true;
                b.b.k.e a2 = aVar.a();
                this.f732b = a2;
                ListView listView = a2.f364d.g;
                listView.setTextDirection(i);
                listView.setTextAlignment(i2);
                this.f732b.show();
            }
        }

        @Override // b.b.q.w.f
        public int g() {
            return 0;
        }

        @Override // b.b.q.w.f
        public Drawable i() {
            return null;
        }

        @Override // b.b.q.w.f
        public CharSequence j() {
            return this.f734d;
        }

        @Override // b.b.q.w.f
        public void l(CharSequence charSequence) {
            this.f734d = charSequence;
        }

        @Override // b.b.q.w.f
        public void m(Drawable drawable) {
        }

        @Override // b.b.q.w.f
        public void n(int i) {
        }

        @Override // b.b.q.w.f
        public void o(ListAdapter listAdapter) {
            this.f733c = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            w.this.setSelection(i);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i, this.f733c.getItemId(i));
            }
            b.b.k.e eVar = this.f732b;
            if (eVar != null) {
                eVar.dismiss();
                this.f732b = null;
            }
        }

        @Override // b.b.q.w.f
        public void p(int i) {
        }
    }

    public static class c implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public SpinnerAdapter f736b;

        /* renamed from: c  reason: collision with root package name */
        public ListAdapter f737c;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f736b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f737c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
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
            ListAdapter listAdapter = this.f737c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f736b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f737c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f736b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class d extends k0 implements f {
        public CharSequence G;
        public ListAdapter H;
        public final Rect I = new Rect();
        public int J;

        public class a implements AdapterView.OnItemClickListener {
            public a(w wVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.this.setSelection(i);
                if (w.this.getOnItemClickListener() != null) {
                    d dVar = d.this;
                    w.this.performItemClick(view, i, dVar.H.getItemId(i));
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
                if (dVar != null) {
                    if (!(m.A(wVar) && wVar.getGlobalVisibleRect(dVar.I))) {
                        d.this.dismiss();
                        return;
                    }
                    d.this.u();
                    d.super.a();
                    return;
                }
                throw null;
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f740b;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f740b = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f740b);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i, 0);
            this.s = w.this;
            s(true);
            this.q = 0;
            this.t = new a(w.this);
        }

        @Override // b.b.q.w.f
        public void e(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            u();
            this.C.setInputMethodMode(2);
            super.a();
            f0 f0Var = this.f670d;
            f0Var.setChoiceMode(1);
            f0Var.setTextDirection(i);
            f0Var.setTextAlignment(i2);
            int selectedItemPosition = w.this.getSelectedItemPosition();
            f0 f0Var2 = this.f670d;
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
                this.C.setOnDismissListener(new c(bVar));
            }
        }

        @Override // b.b.q.w.f
        public CharSequence j() {
            return this.G;
        }

        @Override // b.b.q.w.f
        public void l(CharSequence charSequence) {
            this.G = charSequence;
        }

        @Override // b.b.q.k0, b.b.q.w.f
        public void o(ListAdapter listAdapter) {
            super.o(listAdapter);
            this.H = listAdapter;
        }

        @Override // b.b.q.w.f
        public void p(int i) {
            this.J = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0096  */
        public void u() {
            int i;
            Drawable i2 = i();
            int i3 = 0;
            if (i2 != null) {
                i2.getPadding(w.this.i);
                i3 = e1.a(w.this) ? w.this.i.right : -w.this.i.left;
            } else {
                Rect rect = w.this.i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i4 = wVar.h;
            if (i4 == -2) {
                int a2 = wVar.a((SpinnerAdapter) this.H, i());
                int i5 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = w.this.i;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (a2 > i6) {
                    a2 = i6;
                }
                i = Math.max(a2, (width - paddingLeft) - paddingRight);
            } else if (i4 == -1) {
                i = (width - paddingLeft) - paddingRight;
            } else {
                r(i4);
                this.g = !e1.a(w.this) ? (((width - paddingRight) - this.f) - this.J) + i3 : paddingLeft + this.J + i3;
            }
            r(i);
            this.g = !e1.a(w.this) ? (((width - paddingRight) - this.f) - this.J) + i3 : paddingLeft + this.J + i3;
        }
    }

    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public boolean f742b;

        public class a implements Parcelable.Creator<e> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f742b = parcel.readByte() != 0;
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f742b ? (byte) 1 : 0);
        }
    }

    public interface f {
        void b(int i);

        boolean c();

        int d();

        void dismiss();

        void e(int i, int i2);

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(Drawable drawable);

        void n(int i);

        void o(ListAdapter listAdapter);

        void p(int i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r4 != null) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    public w(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        Throwable th;
        t0.a(this, getContext());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.Spinner, i2, 0);
        this.f727b = new e(this);
        int resourceId = obtainStyledAttributes.getResourceId(j.Spinner_popupTheme, 0);
        if (resourceId != 0) {
            this.f728c = new b.b.p.c(context, resourceId);
        } else {
            this.f728c = context;
        }
        TypedArray typedArray2 = null;
        int i3 = -1;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, j, i2, 0);
            try {
                if (typedArray.hasValue(0)) {
                    i3 = typedArray.getInt(0, 0);
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                typedArray2 = typedArray;
                if (typedArray2 != null) {
                    typedArray2.recycle();
                }
                throw th;
            }
        } catch (Exception unused2) {
            typedArray = null;
        } catch (Throwable th3) {
            th = th3;
            if (typedArray2 != null) {
            }
            throw th;
        }
        typedArray.recycle();
        if (i3 == 0) {
            b bVar = new b();
            this.g = bVar;
            bVar.l(obtainStyledAttributes.getString(j.Spinner_android_prompt));
        } else if (i3 == 1) {
            d dVar = new d(this.f728c, attributeSet, i2);
            y0 q = y0.q(this.f728c, attributeSet, j.Spinner, i2, 0);
            this.h = q.k(j.Spinner_android_dropDownWidth, -2);
            dVar.C.setBackgroundDrawable(q.g(j.Spinner_android_popupBackground));
            dVar.G = obtainStyledAttributes.getString(j.Spinner_android_prompt);
            q.f759b.recycle();
            this.g = dVar;
            this.f729d = new v(this, this, dVar);
        }
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(j.Spinner_android_entries);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(g.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
        this.f = true;
        SpinnerAdapter spinnerAdapter = this.f730e;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.f730e = null;
        }
        this.f727b.d(attributeSet, i2);
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
        drawable.getPadding(this.i);
        Rect rect = this.i;
        return i3 + rect.left + rect.right;
    }

    public void b() {
        this.g.e(getTextDirection(), getTextAlignment());
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f727b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        f fVar = this.g;
        return fVar != null ? fVar.d() : super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        f fVar = this.g;
        return fVar != null ? fVar.g() : super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        return this.g != null ? this.h : super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.g;
    }

    public Drawable getPopupBackground() {
        f fVar = this.g;
        return fVar != null ? fVar.i() : super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f728c;
    }

    public CharSequence getPrompt() {
        f fVar = this.g;
        return fVar != null ? fVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f727b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f727b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.g;
        if (fVar != null && fVar.c()) {
            this.g.dismiss();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (eVar.f742b && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.g;
        eVar.f742b = fVar != null && fVar.c();
        return eVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f729d;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        f fVar = this.g;
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
        if (!this.f) {
            this.f730e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            Context context = this.f728c;
            if (context == null) {
                context = getContext();
            }
            this.g.o(new c(spinnerAdapter, context.getTheme()));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f727b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f727b;
        if (eVar != null) {
            eVar.f(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.g;
        if (fVar != null) {
            fVar.p(i2);
            this.g.b(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.g;
        if (fVar != null) {
            fVar.n(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.g != null) {
            this.h = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.g;
        if (fVar != null) {
            fVar.m(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(b.b.l.a.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        f fVar = this.g;
        if (fVar != null) {
            fVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f727b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f727b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }
}
