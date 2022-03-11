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
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class a0 {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f838l = new RectF();
    public static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();
    public int a = 0;
    public boolean b = false;
    public float c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f839d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f840e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f841f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f842g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f843h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f844i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f845j;

    /* renamed from: k  reason: collision with root package name */
    public final c f846k;

    public static class a extends c {
        @Override // e.b.f.a0.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) a0.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class b extends a {
        @Override // e.b.f.a0.c, e.b.f.a0.a
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // e.b.f.a0.c
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class c {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) a0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public a0(TextView textView) {
        this.f844i = textView;
        this.f845j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        this.f846k = i2 >= 29 ? new b() : i2 >= 23 ? new a() : new c();
    }

    public static Method d(String str) {
        try {
            Method method = m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                m.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    public static <T> T e(Object obj, String str, T t) {
        try {
            return (T) d(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    public void a() {
        if (i() && this.a != 0) {
            if (this.b) {
                if (this.f844i.getMeasuredHeight() > 0 && this.f844i.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f846k.b(this.f844i) ? 1048576 : (this.f844i.getMeasuredWidth() - this.f844i.getTotalPaddingLeft()) - this.f844i.getTotalPaddingRight();
                    int height = (this.f844i.getHeight() - this.f844i.getCompoundPaddingBottom()) - this.f844i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f838l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) measuredWidth;
                            rectF.bottom = (float) height;
                            float c2 = (float) c(rectF);
                            if (c2 != this.f844i.getTextSize()) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0104, code lost:
        if (r7.getLineEnd(r7.getLineCount() - 1) != r8.length()) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    public final int c(RectF rectF) {
        StaticLayout staticLayout;
        int i2;
        int i3;
        boolean z;
        CharSequence transformation;
        int length = this.f841f.length;
        if (length != 0) {
            int i4 = length - 1;
            int i5 = 0;
            int i6 = 1;
            int i7 = 0;
            while (i6 <= i4) {
                int i8 = (i6 + i4) / 2;
                int i9 = this.f841f[i8];
                CharSequence text = this.f844i.getText();
                TransformationMethod transformationMethod = this.f844i.getTransformationMethod();
                if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f844i)) == null)) {
                    text = transformation;
                }
                int i10 = Build.VERSION.SDK_INT;
                int maxLines = this.f844i.getMaxLines();
                TextPaint textPaint = this.f843h;
                if (textPaint == null) {
                    this.f843h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f843h.set(this.f844i.getPaint());
                this.f843h.setTextSize((float) i9);
                Layout.Alignment alignment = (Layout.Alignment) e(this.f844i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
                int round = Math.round(rectF.right);
                if (i10 >= 23) {
                    StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, i5, text.length(), this.f843h, round);
                    obtain.setAlignment(alignment).setLineSpacing(this.f844i.getLineSpacingExtra(), this.f844i.getLineSpacingMultiplier()).setIncludePad(this.f844i.getIncludeFontPadding()).setBreakStrategy(this.f844i.getBreakStrategy()).setHyphenationFrequency(this.f844i.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                    try {
                        this.f846k.a(obtain, this.f844i);
                    } catch (ClassCastException unused) {
                        Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
                    }
                    staticLayout = obtain.build();
                    i3 = maxLines;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i3 = maxLines;
                    staticLayout = new StaticLayout(text, this.f843h, round, alignment, this.f844i.getLineSpacingMultiplier(), this.f844i.getLineSpacingExtra(), this.f844i.getIncludeFontPadding());
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
            return this.f841f[i7];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public void f(int i2, float f2) {
        Context context = this.f845j;
        float applyDimension = TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        if (applyDimension != this.f844i.getPaint().getTextSize()) {
            this.f844i.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.f844i.isInLayout();
            if (this.f844i.getLayout() != null) {
                this.b = false;
                try {
                    Method d2 = d("nullLayouts");
                    if (d2 != null) {
                        d2.invoke(this.f844i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f844i.requestLayout();
                } else {
                    this.f844i.forceLayout();
                }
                this.f844i.invalidate();
            }
        }
    }

    public final boolean g() {
        if (!i() || this.a != 1) {
            this.b = false;
        } else {
            if (!this.f842g || this.f841f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f840e - this.f839d) / this.c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round((((float) i2) * this.c) + this.f839d);
                }
                this.f841f = b(iArr);
            }
            this.b = true;
        }
        return this.b;
    }

    public final boolean h() {
        int[] iArr = this.f841f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f842g = z;
        if (z) {
            this.a = 1;
            this.f839d = (float) iArr[0];
            this.f840e = (float) iArr[length - 1];
            this.c = -1.0f;
        }
        return z;
    }

    public final boolean i() {
        return !(this.f844i instanceof k);
    }

    public final void j(float f2, float f3, float f4) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.a = 1;
            this.f839d = f2;
            this.f840e = f3;
            this.c = f4;
            this.f842g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }
}
