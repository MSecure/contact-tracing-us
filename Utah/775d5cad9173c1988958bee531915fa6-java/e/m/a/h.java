package e.m.a;

import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.KeyEvent;
import e.i.c.c;
import e.m.a.e;
import e.m.a.k;
import java.util.Objects;

public final class h {
    public final e.i a;
    public final k b;
    public e.d c;

    public static class a implements e.d {
        public static final ThreadLocal<StringBuilder> b = new ThreadLocal<>();
        public final TextPaint a;

        public a() {
            TextPaint textPaint = new TextPaint();
            this.a = textPaint;
            textPaint.setTextSize(10.0f);
        }
    }

    public static final class b {
        public int a = 1;
        public final k.a b;
        public k.a c;

        /* renamed from: d  reason: collision with root package name */
        public k.a f1642d;

        /* renamed from: e  reason: collision with root package name */
        public int f1643e;

        /* renamed from: f  reason: collision with root package name */
        public int f1644f;

        public b(k.a aVar, boolean z, int[] iArr) {
            this.b = aVar;
            this.c = aVar;
        }

        public int a(int i2) {
            SparseArray<k.a> sparseArray = this.c.a;
            k.a aVar = sparseArray == null ? null : sparseArray.get(i2);
            int i3 = 3;
            if (this.a != 2) {
                if (aVar != null) {
                    this.a = 2;
                    this.c = aVar;
                    this.f1644f = 1;
                }
                b();
                i3 = 1;
                this.f1643e = i2;
                return i3;
            } else if (aVar != null) {
                this.c = aVar;
                this.f1644f++;
            } else {
                boolean z = false;
                if (!(i2 == 65038)) {
                    if (i2 == 65039) {
                        z = true;
                    }
                    if (!z) {
                        k.a aVar2 = this.c;
                        if (aVar2.b != null) {
                            if (this.f1644f == 1) {
                                if (c()) {
                                    aVar2 = this.c;
                                }
                            }
                            this.f1642d = aVar2;
                            b();
                            this.f1643e = i2;
                            return i3;
                        }
                    }
                }
                b();
                i3 = 1;
                this.f1643e = i2;
                return i3;
            }
            i3 = 2;
            this.f1643e = i2;
            return i3;
        }

        public final int b() {
            this.a = 1;
            this.c = this.b;
            this.f1644f = 0;
            return 1;
        }

        public final boolean c() {
            e.m.a.n.a e2 = this.c.b.e();
            int a2 = e2.a(6);
            if ((a2 == 0 || e2.b.get(a2 + e2.a) == 0) ? false : true) {
                return true;
            }
            return this.f1643e == 65039;
        }
    }

    public h(k kVar, e.i iVar, e.d dVar, boolean z, int[] iArr) {
        this.a = iVar;
        this.b = kVar;
        this.c = dVar;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        i[] iVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!(selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        if (r6 >= r7) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0107  */
    public final boolean b(CharSequence charSequence, int i2, int i3, g gVar) {
        boolean z;
        if (gVar.c == 0) {
            e.d dVar = this.c;
            e.m.a.n.a e2 = gVar.e();
            int a2 = e2.a(8);
            short s = a2 != 0 ? e2.b.getShort(a2 + e2.a) : 0;
            a aVar = (a) dVar;
            Objects.requireNonNull(aVar);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 23 || s <= i4) {
                ThreadLocal<StringBuilder> threadLocal = a.b;
                if (threadLocal.get() == null) {
                    threadLocal.set(new StringBuilder());
                }
                StringBuilder sb = threadLocal.get();
                sb.setLength(0);
                while (i2 < i3) {
                    sb.append(charSequence.charAt(i2));
                    i2++;
                }
                TextPaint textPaint = aVar.a;
                String sb2 = sb.toString();
                ThreadLocal<e.i.h.b<Rect, Rect>> threadLocal2 = c.a;
                if (Build.VERSION.SDK_INT >= 23) {
                    z = textPaint.hasGlyph(sb2);
                } else {
                    int length = sb2.length();
                    if (length != 1 || !Character.isWhitespace(sb2.charAt(0))) {
                        float measureText = textPaint.measureText("󟿽");
                        float measureText2 = textPaint.measureText("m");
                        float measureText3 = textPaint.measureText(sb2);
                        float f2 = 0.0f;
                        if (measureText3 != 0.0f) {
                            if (sb2.codePointCount(0, sb2.length()) > 1) {
                                if (measureText3 <= measureText2 * 2.0f) {
                                    int i5 = 0;
                                    while (i5 < length) {
                                        int charCount = Character.charCount(sb2.codePointAt(i5)) + i5;
                                        f2 += textPaint.measureText(sb2, i5, charCount);
                                        i5 = charCount;
                                    }
                                }
                            }
                            if (measureText3 == measureText) {
                                ThreadLocal<e.i.h.b<Rect, Rect>> threadLocal3 = c.a;
                                e.i.h.b<Rect, Rect> bVar = threadLocal3.get();
                                if (bVar == null) {
                                    bVar = new e.i.h.b<>(new Rect(), new Rect());
                                    threadLocal3.set(bVar);
                                } else {
                                    bVar.a.setEmpty();
                                    bVar.b.setEmpty();
                                }
                                textPaint.getTextBounds("󟿽", 0, 2, (Rect) bVar.a);
                                textPaint.getTextBounds(sb2, 0, length, (Rect) bVar.b);
                                z = !bVar.a.equals(bVar.b);
                            }
                        }
                    }
                    z = true;
                }
                gVar.c = !z ? 2 : 1;
            }
            z = false;
            gVar.c = !z ? 2 : 1;
        }
        if (gVar.c == 2) {
            return true;
        }
        return false;
    }
}
