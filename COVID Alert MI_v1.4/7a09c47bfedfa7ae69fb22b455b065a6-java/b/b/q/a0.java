package b.b.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class a0 {
    public static final RectF l = new RectF();
    public static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public int f777a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f778b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f779c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f780d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f781e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f782f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f783g = false;
    public TextPaint h;
    public final TextView i;
    public final Context j;
    public final c k;

    public static class a extends c {
        @Override // b.b.q.a0.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) a0.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class b extends a {
        @Override // b.b.q.a0.c, b.b.q.a0.a
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // b.b.q.a0.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class c {
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        public boolean b(TextView textView) {
            return ((Boolean) a0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public a0(TextView textView) {
        this.i = textView;
        this.j = textView.getContext();
        this.k = Build.VERSION.SDK_INT >= 29 ? new b() : new a();
    }

    public static Method d(String str) {
        try {
            Method method = m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                m.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        return r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static <T> T e(Object obj, String str, T t) {
        return (T) d(str).invoke(obj, new Object[0]);
    }

    public void a() {
        if (i() && this.f777a != 0) {
            if (this.f778b) {
                if (this.i.getMeasuredHeight() > 0 && this.i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.k.b(this.i) ? 1048576 : (this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft()) - this.i.getTotalPaddingRight();
                    int height = (this.i.getHeight() - this.i.getCompoundPaddingBottom()) - this.i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (l) {
                            l.setEmpty();
                            l.right = (float) measuredWidth;
                            l.bottom = (float) height;
                            float c2 = (float) c(l);
                            if (c2 != this.i.getTextSize()) {
                                f(0, c2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f778b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f782f.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                int i6 = this.f782f[i5];
                CharSequence text = this.i.getText();
                TransformationMethod transformationMethod = this.i.getTransformationMethod();
                if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.i)) == null)) {
                    text = transformation;
                }
                int maxLines = this.i.getMaxLines();
                TextPaint textPaint = this.h;
                if (textPaint == null) {
                    this.h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.h.set(this.i.getPaint());
                this.h.setTextSize((float) i6);
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, 0, text.length(), this.h, Math.round(rectF.right));
                obtain.setAlignment((Layout.Alignment) e(this.i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL)).setLineSpacing(this.i.getLineSpacingExtra(), this.i.getLineSpacingMultiplier()).setIncludePad(this.i.getIncludeFontPadding()).setBreakStrategy(this.i.getBreakStrategy()).setHyphenationFrequency(this.i.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                try {
                    this.k.a(obtain, this.i);
                } catch (ClassCastException unused) {
                }
                StaticLayout build = obtain.build();
                if ((maxLines == -1 || (build.getLineCount() <= maxLines && build.getLineEnd(build.getLineCount() - 1) == text.length())) && ((float) build.getHeight()) <= rectF.bottom) {
                    int i7 = i5 + 1;
                    i4 = i3;
                    i3 = i7;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f782f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public void f(int i2, float f2) {
        Context context = this.j;
        float applyDimension = TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        if (applyDimension != this.i.getPaint().getTextSize()) {
            this.i.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.i.isInLayout();
            if (this.i.getLayout() != null) {
                this.f778b = false;
                try {
                    Method d2 = d("nullLayouts");
                    if (d2 != null) {
                        d2.invoke(this.i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!isInLayout) {
                    this.i.requestLayout();
                } else {
                    this.i.forceLayout();
                }
                this.i.invalidate();
            }
        }
    }

    public final boolean g() {
        if (!i() || this.f777a != 1) {
            this.f778b = false;
        } else {
            if (!this.f783g || this.f782f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f781e - this.f780d) / this.f779c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round((((float) i2) * this.f779c) + this.f780d);
                }
                this.f782f = b(iArr);
            }
            this.f778b = true;
        }
        return this.f778b;
    }

    public final boolean h() {
        int length = this.f782f.length;
        boolean z = length > 0;
        this.f783g = z;
        if (z) {
            this.f777a = 1;
            int[] iArr = this.f782f;
            this.f780d = (float) iArr[0];
            this.f781e = (float) iArr[length - 1];
            this.f779c = -1.0f;
        }
        return this.f783g;
    }

    public final boolean i() {
        return !(this.i instanceof k);
    }

    public final void j(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f777a = 1;
            this.f780d = f2;
            this.f781e = f3;
            this.f779c = f4;
            this.f783g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }
}
