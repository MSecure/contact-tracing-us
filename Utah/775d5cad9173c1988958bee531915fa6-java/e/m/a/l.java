package e.m.a;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import e.b.a.m;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class l extends SpannableStringBuilder {
    public final Class<?> b;
    public final List<a> c = new ArrayList();

    public static class a implements TextWatcher, SpanWatcher {
        public final Object b;
        public final AtomicInteger c = new AtomicInteger(0);

        public a(Object obj) {
            this.b = obj;
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.b).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.b).beforeTextChanged(charSequence, i2, i3, i4);
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
            if (this.c.get() <= 0 || !(obj instanceof i)) {
                ((SpanWatcher) this.b).onSpanAdded(spannable, obj, i2, i3);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
            if (this.c.get() <= 0 || !(obj instanceof i)) {
                ((SpanWatcher) this.b).onSpanChanged(spannable, obj, i2, i3, i4, i5);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
            if (this.c.get() <= 0 || !(obj instanceof i)) {
                ((SpanWatcher) this.b).onSpanRemoved(spannable, obj, i2, i3);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ((TextWatcher) this.b).onTextChanged(charSequence, i2, i3, i4);
        }
    }

    public l(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        m.e.q(cls, "watcherClass cannot be null");
        this.b = cls;
    }

    public l(Class<?> cls, CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
        m.e.q(cls, "watcherClass cannot be null");
        this.b = cls;
    }

    public final void a() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).c.incrementAndGet();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    public Editable append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public SpannableStringBuilder m6append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public SpannableStringBuilder m7append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public SpannableStringBuilder m8append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i2) {
        super.append(charSequence, obj, i2);
        return this;
    }

    public void b() {
        f();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            ((TextWatcher) this.c.get(i2).b).onTextChanged(this, 0, length(), length());
        }
    }

    public final a c(Object obj) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            a aVar = this.c.get(i2);
            if (aVar.b == obj) {
                return aVar;
            }
        }
        return null;
    }

    public final boolean d(Class<?> cls) {
        return this.b == cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    public Editable delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    /* renamed from: delete  reason: collision with other method in class */
    public SpannableStringBuilder m12delete(int i2, int i3) {
        super.delete(i2, i3);
        return this;
    }

    public final boolean e(Object obj) {
        return obj != null && d(obj.getClass());
    }

    public final void f() {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).c.decrementAndGet();
        }
    }

    public int getSpanEnd(Object obj) {
        a c2;
        if (e(obj) && (c2 = c(obj)) != null) {
            obj = c2;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        a c2;
        if (e(obj) && (c2 = c(obj)) != null) {
            obj = c2;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        a c2;
        if (e(obj) && (c2 = c(obj)) != null) {
            obj = c2;
        }
        return super.getSpanStart(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (!(this.b == cls)) {
            return (T[]) super.getSpans(i2, i3, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i2, i3, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            tArr[i4] = aVarArr[i4].b;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    public Editable insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    /* renamed from: insert  reason: collision with other method in class */
    public SpannableStringBuilder m13insert(int i2, CharSequence charSequence) {
        super.insert(i2, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    /* renamed from: insert  reason: collision with other method in class */
    public SpannableStringBuilder m14insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if ((r1.b == r4) != false) goto L_0x000b;
     */
    public int nextSpanTransition(int i2, int i3, Class cls) {
        if (cls != null) {
        }
        cls = a.class;
        return super.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        a aVar;
        if (e(obj)) {
            aVar = c(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.c.remove(aVar);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    public Editable replace(int i2, int i3, CharSequence charSequence) {
        a();
        super.replace(i2, i3, charSequence);
        f();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    /* renamed from: replace  reason: collision with other method in class */
    public SpannableStringBuilder m15replace(int i2, int i3, CharSequence charSequence) {
        a();
        super.replace(i2, i3, charSequence);
        f();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    /* renamed from: replace  reason: collision with other method in class */
    public SpannableStringBuilder m16replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        a();
        super.replace(i2, i3, charSequence, i4, i5);
        f();
        return this;
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (e(obj)) {
            a aVar = new a(obj);
            this.c.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i2, i3, i4);
    }

    public CharSequence subSequence(int i2, int i3) {
        return new l(this.b, this, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    public Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    public Editable insert(int i2, CharSequence charSequence, int i3, int i4) {
        super.insert(i2, charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder
    public Editable replace(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        a();
        super.replace(i2, i3, charSequence, i4, i5);
        f();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    public Editable append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m9append(char c2) {
        super.append(c2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m10append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, android.text.SpannableStringBuilder, java.lang.Appendable, android.text.Editable, android.text.Editable
    /* renamed from: append  reason: collision with other method in class */
    public Appendable m11append(CharSequence charSequence, int i2, int i3) {
        super.append(charSequence, i2, i3);
        return this;
    }
}
