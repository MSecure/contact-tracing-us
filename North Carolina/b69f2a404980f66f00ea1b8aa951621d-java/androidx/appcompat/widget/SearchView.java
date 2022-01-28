package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.b.q.e1;
import b.b.q.i0;
import b.b.q.r0;
import b.b.q.y0;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends i0 implements b.b.p.b {
    public static final n r0 = (Build.VERSION.SDK_INT < 29 ? new n() : null);
    public Rect A;
    public Rect B;
    public int[] C;
    public int[] D;
    public final ImageView E;
    public final Drawable F;
    public final int G;
    public final int H;
    public final Intent I;
    public final Intent J;
    public final CharSequence K;
    public l L;
    public k M;
    public View.OnFocusChangeListener N;
    public m O;
    public View.OnClickListener P;
    public boolean Q;
    public boolean R;
    public b.j.a.a S;
    public boolean T;
    public CharSequence U;
    public boolean V;
    public boolean W;
    public int a0;
    public boolean b0;
    public CharSequence c0;
    public CharSequence d0;
    public boolean e0;
    public int f0;
    public SearchableInfo g0;
    public Bundle h0;
    public final Runnable i0;
    public Runnable j0;
    public final WeakHashMap<String, Drawable.ConstantState> k0;
    public final View.OnClickListener l0;
    public View.OnKeyListener m0;
    public final TextView.OnEditorActionListener n0;
    public final AdapterView.OnItemClickListener o0;
    public final AdapterView.OnItemSelectedListener p0;
    public final SearchAutoComplete q;
    public TextWatcher q0;
    public final View r;
    public final View s;
    public final View t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final View y;
    public p z;

    public static class SearchAutoComplete extends b.b.q.d {

        /* renamed from: e  reason: collision with root package name */
        public int f65e = getThreshold();
        public SearchView f;
        public boolean g;
        public final Runnable h = new a();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.g) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.g = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, b.b.a.autoCompleteTextViewStyle);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return RecyclerView.d0.FLAG_TMP_DETACHED;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            n nVar = SearchView.r0;
            if (nVar != null) {
                n.a();
                Method method = nVar.f79c;
                if (method != null) {
                    try {
                        method.invoke(this, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            } else {
                throw null;
            }
        }

        public boolean enoughToFilter() {
            return this.f65e <= 0 || super.enoughToFilter();
        }

        @Override // b.b.q.d
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                removeCallbacks(this.h);
                post(this.h);
            }
            return onCreateInputConnection;
        }

        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.f;
            searchView.I(searchView.R);
            searchView.post(searchView.i0);
            if (searchView.q.hasFocus()) {
                searchView.t();
            }
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f.hasFocus() && getVisibility() == 0) {
                this.g = true;
                if (SearchView.u(getContext())) {
                    a();
                }
            }
        }

        public void performCompletion() {
        }

        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.g = true;
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f65e = i;
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.q.getText();
            searchView.d0 = text;
            boolean z = !TextUtils.isEmpty(text);
            searchView.H(z);
            searchView.J(!z);
            searchView.D();
            searchView.G();
            if (searchView.L != null && !TextUtils.equals(charSequence, searchView.c0)) {
                searchView.L.a(charSequence.toString());
            }
            searchView.c0 = charSequence.toString();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            SearchView.this.E();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            b.j.a.a aVar = SearchView.this.S;
            if (aVar instanceof r0) {
                aVar.b(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView searchView = SearchView.this;
            if (searchView.y.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.s.getPaddingLeft();
                Rect rect = new Rect();
                boolean a2 = e1.a(searchView);
                int dimensionPixelSize = searchView.Q ? resources.getDimensionPixelSize(b.b.d.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(b.b.d.abc_dropdownitem_icon_width) : 0;
                searchView.q.getDropDownBackground().getPadding(rect);
                searchView.q.setDropDownHorizontalOffset(a2 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                searchView.q.setDropDownWidth((((searchView.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.u) {
                searchView.A();
            } else if (view == searchView.w) {
                searchView.w();
            } else if (view == searchView.v) {
                searchView.B();
            } else if (view == searchView.x) {
                SearchableInfo searchableInfo = searchView.g0;
                if (searchableInfo != null) {
                    try {
                        if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                            Intent intent = new Intent(searchView.I);
                            ComponentName searchActivity = searchableInfo.getSearchActivity();
                            intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                            searchView.getContext().startActivity(intent);
                        } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            searchView.getContext().startActivity(searchView.s(searchView.J, searchableInfo));
                        }
                    } catch (ActivityNotFoundException unused) {
                    }
                }
            } else if (view == searchView.q) {
                searchView.t();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.g0 == null) {
                return false;
            }
            if (searchView.q.isPopupShowing() && SearchView.this.q.getListSelection() != -1) {
                return SearchView.this.C(i, keyEvent);
            }
            if ((TextUtils.getTrimmedLength(SearchView.this.q.getText()) == 0) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.v(0, null, searchView2.q.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.B();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.x(i);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.y(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public interface k {
        boolean a();
    }

    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    public interface m {
        boolean a(int i);

        boolean b(int i);
    }

    public static class n {

        /* renamed from: a  reason: collision with root package name */
        public Method f77a = null;

        /* renamed from: b  reason: collision with root package name */
        public Method f78b = null;

        /* renamed from: c  reason: collision with root package name */
        public Method f79c = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public n() {
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f77a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f78b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f79c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    public static class o extends b.k.a.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public boolean f80d;

        public class a implements Parcelable.ClassLoaderCreator<o> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new o[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f80d = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("SearchView.SavedState{");
            g.append(Integer.toHexString(System.identityHashCode(this)));
            g.append(" isIconified=");
            g.append(this.f80d);
            g.append("}");
            return g.toString();
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeValue(Boolean.valueOf(this.f80d));
        }
    }

    public static class p extends TouchDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final View f81a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f82b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public final Rect f83c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        public final Rect f84d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        public final int f85e;
        public boolean f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f85e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.f81a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f82b.set(rect);
            this.f84d.set(rect);
            Rect rect3 = this.f84d;
            int i = this.f85e;
            rect3.inset(-i, -i);
            this.f83c.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int i;
            float f2;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.f84d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                        if (z3) {
                            return false;
                        }
                        if (!z || this.f83c.contains(x, y)) {
                            Rect rect = this.f83c;
                            f2 = (float) (x - rect.left);
                            i = y - rect.top;
                        } else {
                            f2 = (float) (this.f81a.getWidth() / 2);
                            i = this.f81a.getHeight() / 2;
                        }
                        motionEvent.setLocation(f2, (float) i);
                        return this.f81a.dispatchTouchEvent(motionEvent);
                    }
                } else if (action == 3) {
                    z2 = this.f;
                    this.f = false;
                }
                z3 = z2;
                z = true;
                if (z3) {
                }
            } else if (this.f82b.contains(x, y)) {
                this.f = true;
                z = true;
                if (z3) {
                }
            }
            z = true;
            z3 = false;
            if (z3) {
            }
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.i0 = new b();
        this.j0 = new c();
        this.k0 = new WeakHashMap<>();
        this.l0 = new f();
        this.m0 = new g();
        this.n0 = new h();
        this.o0 = new i();
        this.p0 = new j();
        this.q0 = new a();
        y0 y0Var = new y0(context, context.obtainStyledAttributes(attributeSet, b.b.j.SearchView, i2, 0));
        LayoutInflater.from(context).inflate(y0Var.l(b.b.j.SearchView_layout, b.b.g.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(b.b.f.search_src_text);
        this.q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.r = findViewById(b.b.f.search_edit_frame);
        this.s = findViewById(b.b.f.search_plate);
        this.t = findViewById(b.b.f.submit_area);
        this.u = (ImageView) findViewById(b.b.f.search_button);
        this.v = (ImageView) findViewById(b.b.f.search_go_btn);
        this.w = (ImageView) findViewById(b.b.f.search_close_btn);
        this.x = (ImageView) findViewById(b.b.f.search_voice_btn);
        this.E = (ImageView) findViewById(b.b.f.search_mag_icon);
        b.i.l.m.W(this.s, y0Var.g(b.b.j.SearchView_queryBackground));
        this.t.setBackground(y0Var.g(b.b.j.SearchView_submitBackground));
        this.u.setImageDrawable(y0Var.g(b.b.j.SearchView_searchIcon));
        this.v.setImageDrawable(y0Var.g(b.b.j.SearchView_goIcon));
        this.w.setImageDrawable(y0Var.g(b.b.j.SearchView_closeIcon));
        this.x.setImageDrawable(y0Var.g(b.b.j.SearchView_voiceIcon));
        this.E.setImageDrawable(y0Var.g(b.b.j.SearchView_searchIcon));
        this.F = y0Var.g(b.b.j.SearchView_searchHintIcon);
        i.j.e1(this.u, getResources().getString(b.b.h.abc_searchview_description_search));
        this.G = y0Var.l(b.b.j.SearchView_suggestionRowLayout, b.b.g.abc_search_dropdown_item_icons_2line);
        this.H = y0Var.l(b.b.j.SearchView_commitIcon, 0);
        this.u.setOnClickListener(this.l0);
        this.w.setOnClickListener(this.l0);
        this.v.setOnClickListener(this.l0);
        this.x.setOnClickListener(this.l0);
        this.q.setOnClickListener(this.l0);
        this.q.addTextChangedListener(this.q0);
        this.q.setOnEditorActionListener(this.n0);
        this.q.setOnItemClickListener(this.o0);
        this.q.setOnItemSelectedListener(this.p0);
        this.q.setOnKeyListener(this.m0);
        this.q.setOnFocusChangeListener(new d());
        setIconifiedByDefault(y0Var.a(b.b.j.SearchView_iconifiedByDefault, true));
        int f2 = y0Var.f(b.b.j.SearchView_android_maxWidth, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.K = y0Var.n(b.b.j.SearchView_defaultQueryHint);
        this.U = y0Var.n(b.b.j.SearchView_queryHint);
        int j2 = y0Var.j(b.b.j.SearchView_android_imeOptions, -1);
        if (j2 != -1) {
            setImeOptions(j2);
        }
        int j3 = y0Var.j(b.b.j.SearchView_android_inputType, -1);
        if (j3 != -1) {
            setInputType(j3);
        }
        setFocusable(y0Var.a(b.b.j.SearchView_android_focusable, true));
        y0Var.f759b.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        this.I.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById = findViewById(this.q.getDropDownAnchor());
        this.y = findViewById;
        if (findViewById != null) {
            findViewById.addOnLayoutChangeListener(new e());
        }
        I(this.Q);
        F();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(b.b.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(b.b.d.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public static boolean u(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public void A() {
        I(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void B() {
        Editable text = this.q.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            l lVar = this.L;
            if (lVar == null || !lVar.b(text.toString())) {
                if (this.g0 != null) {
                    v(0, null, text.toString());
                }
                this.q.setImeVisibility(false);
                this.q.dismissDropDown();
            }
        }
    }

    public boolean C(int i2, KeyEvent keyEvent) {
        if (this.g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return x(this.q.getListSelection());
            }
            if (i2 == 21 || i2 == 22) {
                this.q.setSelection(i2 == 21 ? 0 : this.q.length());
                this.q.setListSelection(0);
                this.q.clearListSelection();
                this.q.a();
                return true;
            } else if (i2 != 19 || this.q.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    public final void D() {
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.q.getText());
        int i2 = 0;
        if (!z3 && (!this.Q || this.e0)) {
            z2 = false;
        }
        ImageView imageView = this.w;
        if (!z2) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z3 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void E() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void F() {
        SpannableStringBuilder queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.Q && this.F != null) {
            int textSize = (int) (((double) this.q.getTextSize()) * 1.25d);
            this.F.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void G() {
        int i2 = 0;
        if (!((this.T || this.b0) && !this.R) || !(this.v.getVisibility() == 0 || this.x.getVisibility() == 0)) {
            i2 = 8;
        }
        this.t.setVisibility(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r2.b0 == false) goto L_0x0023;
     */
    public final void H(boolean z2) {
        boolean z3 = this.T;
        int i2 = 0;
        if (z3) {
            if ((z3 || this.b0) && !this.R) {
                if (hasFocus()) {
                    if (!z2) {
                    }
                    this.v.setVisibility(i2);
                }
            }
        }
        i2 = 8;
        this.v.setVisibility(i2);
    }

    public final void I(boolean z2) {
        this.R = z2;
        int i2 = 0;
        int i3 = z2 ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(i3);
        H(z3);
        this.r.setVisibility(z2 ? 8 : 0);
        if (this.E.getDrawable() == null || this.Q) {
            i2 = 8;
        }
        this.E.setVisibility(i2);
        D();
        J(!z3);
        G();
    }

    public final void J(boolean z2) {
        int i2 = 8;
        if (this.b0 && !this.R && z2) {
            this.v.setVisibility(8);
            i2 = 0;
        }
        this.x.setVisibility(i2);
    }

    @Override // b.b.p.b
    public void c() {
        if (!this.e0) {
            this.e0 = true;
            int imeOptions = this.q.getImeOptions();
            this.f0 = imeOptions;
            this.q.setImeOptions(imeOptions | 33554432);
            this.q.setText("");
            setIconified(false);
        }
    }

    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.W = false;
    }

    @Override // b.b.p.b
    public void f() {
        this.q.setText("");
        SearchAutoComplete searchAutoComplete = this.q;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.d0 = "";
        clearFocus();
        I(true);
        this.q.setImeOptions(this.f0);
        this.e0 = false;
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.a0;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.g0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.g0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    public int getSuggestionRowLayout() {
        return this.G;
    }

    public b.j.a.a getSuggestionsAdapter() {
        return this.S;
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.i0);
        post(this.j0);
        super.onDetachedFromWindow();
    }

    @Override // b.b.q.i0
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            SearchAutoComplete searchAutoComplete = this.q;
            Rect rect = this.A;
            searchAutoComplete.getLocationInWindow(this.C);
            getLocationInWindow(this.D);
            int[] iArr = this.C;
            int i6 = iArr[1];
            int[] iArr2 = this.D;
            int i7 = i6 - iArr2[1];
            int i8 = iArr[0] - iArr2[0];
            rect.set(i8, i7, searchAutoComplete.getWidth() + i8, searchAutoComplete.getHeight() + i7);
            Rect rect2 = this.B;
            Rect rect3 = this.A;
            rect2.set(rect3.left, 0, rect3.right, i5 - i3);
            p pVar = this.z;
            if (pVar == null) {
                p pVar2 = new p(this.B, this.A, this.q);
                this.z = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.B, this.A);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r0 <= 0) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    @Override // b.b.q.i0
    public void onMeasure(int i2, int i3) {
        int mode;
        int i4;
        if (this.R) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size = this.a0;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            } else if (mode2 == 1073741824) {
                i4 = this.a0;
            }
            mode = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode != Integer.MIN_VALUE) {
                size2 = Math.min(getPreferredHeight(), size2);
            } else if (mode == 0) {
                size2 = getPreferredHeight();
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        i4 = this.a0;
        if (i4 <= 0) {
            i4 = getPreferredWidth();
        }
        size = Math.min(i4, size);
        mode = View.MeasureSpec.getMode(i3);
        int size22 = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size22, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.f1231b);
        I(oVar.f80d);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f80d = this.R;
        return oVar;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        post(this.i0);
    }

    public final Intent r(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.g0.getSearchActivity());
        return intent;
    }

    public boolean requestFocus(int i2, Rect rect) {
        if (this.W || !isFocusable()) {
            return false;
        }
        if (this.R) {
            return super.requestFocus(i2, rect);
        }
        boolean requestFocus = this.q.requestFocus(i2, rect);
        if (requestFocus) {
            I(false);
        }
        return requestFocus;
    }

    public final Intent s(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public void setAppSearchData(Bundle bundle) {
        this.h0 = bundle;
    }

    public void setIconified(boolean z2) {
        if (z2) {
            w();
        } else {
            A();
        }
    }

    public void setIconifiedByDefault(boolean z2) {
        if (this.Q != z2) {
            this.Q = z2;
            I(z2);
            F();
        }
    }

    public void setImeOptions(int i2) {
        this.q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.a0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.M = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.L = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.O = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        F();
    }

    public void setQueryRefinementEnabled(boolean z2) {
        this.V = z2;
        b.j.a.a aVar = this.S;
        if (aVar instanceof r0) {
            ((r0) aVar).s = z2 ? 2 : 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        if (getContext().getPackageManager().resolveActivity(r2, 65536) != null) goto L_0x00a0;
     */
    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.g0 = searchableInfo;
        boolean z2 = true;
        Intent intent = null;
        if (searchableInfo != null) {
            this.q.setThreshold(searchableInfo.getSuggestThreshold());
            this.q.setImeOptions(this.g0.getImeOptions());
            int inputType = this.g0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.g0.getSuggestAuthority() != null) {
                    inputType = inputType | 65536 | 524288;
                }
            }
            this.q.setInputType(inputType);
            b.j.a.a aVar = this.S;
            if (aVar != null) {
                aVar.b(null);
            }
            if (this.g0.getSuggestAuthority() != null) {
                r0 r0Var = new r0(getContext(), this, this.g0, this.k0);
                this.S = r0Var;
                this.q.setAdapter(r0Var);
                ((r0) this.S).s = this.V ? 2 : 1;
            }
            F();
        }
        SearchableInfo searchableInfo2 = this.g0;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.g0.getVoiceSearchLaunchWebSearch()) {
                intent = this.I;
            } else if (this.g0.getVoiceSearchLaunchRecognizer()) {
                intent = this.J;
            }
            if (intent != null) {
            }
        }
        z2 = false;
        this.b0 = z2;
        if (z2) {
            this.q.setPrivateImeOptions("nm");
        }
        I(this.R);
    }

    public void setSubmitButtonEnabled(boolean z2) {
        this.T = z2;
        I(this.R);
    }

    public void setSuggestionsAdapter(b.j.a.a aVar) {
        this.S = aVar;
        this.q.setAdapter(aVar);
    }

    public void t() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.q.refreshAutoCompleteResults();
            return;
        }
        n nVar = r0;
        SearchAutoComplete searchAutoComplete = this.q;
        if (nVar != null) {
            n.a();
            Method method = nVar.f77a;
            if (method != null) {
                try {
                    method.invoke(searchAutoComplete, new Object[0]);
                } catch (Exception unused) {
                }
            }
            n nVar2 = r0;
            SearchAutoComplete searchAutoComplete2 = this.q;
            if (nVar2 != null) {
                n.a();
                Method method2 = nVar2.f78b;
                if (method2 != null) {
                    try {
                        method2.invoke(searchAutoComplete2, new Object[0]);
                    } catch (Exception unused2) {
                    }
                }
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }

    public void v(int i2, String str, String str2) {
        getContext().startActivity(r("android.intent.action.SEARCH", null, null, str2, i2, null));
    }

    public void w() {
        if (!TextUtils.isEmpty(this.q.getText())) {
            this.q.setText("");
            this.q.requestFocus();
            this.q.setImeVisibility(true);
        } else if (this.Q) {
            k kVar = this.M;
            if (kVar == null || !kVar.a()) {
                clearFocus();
                I(true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.getPosition();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x008a */
    public boolean x(int i2) {
        String i3;
        m mVar = this.O;
        if (mVar != null && mVar.b(i2)) {
            return false;
        }
        Cursor cursor = this.S.f1225d;
        if (cursor != null && cursor.moveToPosition(i2)) {
            Intent intent = null;
            String e2 = r0.e(cursor, "suggest_intent_action");
            if (e2 == null) {
                e2 = this.g0.getSuggestIntentAction();
            }
            if (e2 == null) {
                e2 = "android.intent.action.SEARCH";
            }
            String i4 = r0.i(cursor, cursor.getColumnIndex("suggest_intent_data"));
            if (i4 == null) {
                i4 = this.g0.getSuggestIntentData();
            }
            if (!(i4 == null || (i3 = r0.i(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) == null)) {
                i4 = i4 + "/" + Uri.encode(i3);
            }
            intent = r(e2, i4 == null ? null : Uri.parse(i4), r0.i(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), r0.i(cursor, cursor.getColumnIndex("suggest_intent_query")), 0, null);
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException unused) {
                    String str = "Failed launch activity: " + intent;
                }
            }
        }
        this.q.setImeVisibility(false);
        this.q.dismissDropDown();
        return true;
    }

    public boolean y(int i2) {
        CharSequence c2;
        m mVar = this.O;
        if (mVar != null && mVar.a(i2)) {
            return false;
        }
        Editable text = this.q.getText();
        Cursor cursor = this.S.f1225d;
        if (cursor == null) {
            return true;
        }
        if (!cursor.moveToPosition(i2) || (c2 = this.S.c(cursor)) == null) {
            setQuery(text);
            return true;
        }
        setQuery(c2);
        return true;
    }

    public void z(CharSequence charSequence) {
        setQuery(charSequence);
    }
}
