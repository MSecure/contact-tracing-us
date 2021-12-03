package e.b.f;

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

public class e0 {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f862l = new RectF();
    public static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();
    public int a = 0;
    public boolean b = false;
    public float c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f863d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f864e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f865f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f866g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f867h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f868i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f869j;

    /* renamed from: k  reason: collision with root package name */
    public final c f870k;

    public static class a extends c {
        @Override // e.b.f.e0.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) e0.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class b extends a {
        @Override // e.b.f.e0.a, e.b.f.e0.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // e.b.f.e0.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class c {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) e0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public e0(TextView textView) {
        this.f868i = textView;
        this.f869j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        this.f870k = i2 >= 29 ? new b() : i2 >= 23 ? new a() : new c();
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
        if (i() && this.a != 0) {
            if (this.b) {
                if (this.f868i.getMeasuredHeight() > 0 && this.f868i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f870k.b(this.f868i) ? 1048576 : (this.f868i.getMeasuredWidth() - this.f868i.getTotalPaddingLeft()) - this.f868i.getTotalPaddingRight();
                    int height = (this.f868i.getHeight() - this.f868i.getCompoundPaddingBottom()) - this.f868i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f862l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) measuredWidth;
                            rectF.bottom = (float) height;
                            float c2 = (float) c(rectF);
                            if (c2 != this.f868i.getTextSize()) {
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
            this.b = true;
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00fc, code lost:
        if (r7.getLineEnd(r7.getLineCount() - 1) != r8.length()) goto L_0x010d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011d  */
    public final int c(RectF rectF) {
        StaticLayout staticLayout;
        int i2;
        int i3;
        boolean z;
        CharSequence transformation;
        int length = this.f865f.length;
        if (length != 0) {
            int i4 = length - 1;
            int i5 = 0;
            int i6 = 1;
            int i7 = 0;
            while (i6 <= i4) {
                int i8 = (i6 + i4) / 2;
                int i9 = this.f865f[i8];
                CharSequence text = this.f868i.getText();
                TransformationMethod transformationMethod = this.f868i.getTransformationMethod();
                if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f868i)) == null)) {
                    text = transformation;
                }
                int i10 = Build.VERSION.SDK_INT;
                int maxLines = this.f868i.getMaxLines();
                TextPaint textPaint = this.f867h;
                if (textPaint == null) {
                    this.f867h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f867h.set(this.f868i.getPaint());
                this.f867h.setTextSize((float) i9);
                Layout.Alignment alignment = (Layout.Alignment) e(this.f868i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
                int round = Math.round(rectF.right);
                if (i10 >= 23) {
                    StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, i5, text.length(), this.f867h, round);
                    obtain.setAlignment(alignment).setLineSpacing(this.f868i.getLineSpacingExtra(), this.f868i.getLineSpacingMultiplier()).setIncludePad(this.f868i.getIncludeFontPadding()).setBreakStrategy(this.f868i.getBreakStrategy()).setHyphenationFrequency(this.f868i.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                    try {
                        this.f870k.a(obtain, this.f868i);
                    } catch (ClassCastException unused) {
                    }
                    staticLayout = obtain.build();
                    i3 = maxLines;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i3 = maxLines;
                    staticLayout = new StaticLayout(text, this.f867h, round, alignment, this.f868i.getLineSpacingMultiplier(), this.f868i.getLineSpacingExtra(), this.f868i.getIncludeFontPadding());
                }
                if (i3 != i2) {
                    if (staticLayout.getLineCount() <= i3) {
                    }
                    z = false;
                    if (z) {
                        int i11 = i8 + 1;
                        i5 = 0;
                        i7 = i6;
                        i6 = i11;
                    } else {
                        i7 = i8 - 1;
                        i4 = i7;
                        i5 = 0;
                    }
                }
                if (((float) staticLayout.getHeight()) <= rectF.bottom) {
                    z = true;
                    if (z) {
                    }
                }
                z = false;
                if (z) {
                }
            }
            return this.f865f[i7];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public void f(int i2, float f2) {
        Context context = this.f869j;
        float applyDimension = TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        if (applyDimension != this.f868i.getPaint().getTextSize()) {
            this.f868i.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.f868i.isInLayout();
            if (this.f868i.getLayout() != null) {
                this.b = false;
                try {
                    Method d2 = d("nullLayouts");
                    if (d2 != null) {
                        d2.invoke(this.f868i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (!isInLayout) {
                    this.f868i.requestLayout();
                } else {
                    this.f868i.forceLayout();
                }
                this.f868i.invalidate();
            }
        }
    }

    public final boolean g() {
        if (!i() || this.a != 1) {
            this.b = false;
        } else {
            if (!this.f866g || this.f865f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f864e - this.f863d) / this.c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round((((float) i2) * this.c) + this.f863d);
                }
                this.f865f = b(iArr);
            }
            this.b = true;
        }
        return this.b;
    }

    public final boolean h() {
        int[] iArr = this.f865f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f866g = z;
        if (z) {
            this.a = 1;
            this.f863d = (float) iArr[0];
            this.f864e = (float) iArr[length - 1];
            this.c = -1.0f;
        }
        return z;
    }

    public final boolean i() {
        return !(this.f868i instanceof l);
    }

    public final void j(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.a = 1;
            this.f863d = f2;
            this.f864e = f3;
            this.c = f4;
            this.f866g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }
}
