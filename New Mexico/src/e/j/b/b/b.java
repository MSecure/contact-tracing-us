package e.j.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R$styleable;
import e.b.a.m;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class b {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public b(Shader shader, ColorStateList colorStateList, int i2) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0200, code lost:
        if (r6 == 1) goto L_0x020a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0202, code lost:
        if (r6 == 2) goto L_0x0207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0204, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0207, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x020a, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020c, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r14 == true ? 1.0f : 0.0f, (float) r15, r4, r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x021d, code lost:
        r3 = new android.graphics.SweepGradient((float) r7, (float) r8, r0.a, r0.b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0232, code lost:
        if (r0 <= 0.0f) goto L_0x0261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0234, code lost:
        r1 = r0.a;
        r0 = r0.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x023b, code lost:
        if (r6 == 1) goto L_0x0246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x023e, code lost:
        if (r6 == 2) goto L_0x0243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0240, code lost:
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0243, code lost:
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0246, code lost:
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0248, code lost:
        r3 = new android.graphics.RadialGradient((float) r7, (float) r8, (float) r0, r1, (float[]) r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0260, code lost:
        return new e.j.b.b.b(r3, null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0268, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01dc, code lost:
        if (r8.size() <= 0) goto L_0x01e4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01de, code lost:
        r0 = new e.j.b.b.g((java.util.List<java.lang.Integer>) r8, (java.util.List<java.lang.Float>) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e4, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01e5, code lost:
        if (r0 == 0) goto L_0x01e9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01eb, code lost:
        if (r18 == false) goto L_0x01f1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ed, code lost:
        r0 = new e.j.b.b.g(r5, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f1, code lost:
        r0 = new e.j.b.b.g(r5, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f5, code lost:
        if (r9 == 1) goto L_0x022b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f8, code lost:
        if (r9 == 2) goto L_0x021d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fa, code lost:
        r4 = r0.a;
        r0 = r0.b;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [e.j.b.b.g] */
    /* JADX WARN: Type inference failed for: r0v12, types: [e.j.b.b.g] */
    /* JADX WARN: Type inference failed for: r0v13, types: [e.j.b.b.g, float] */
    /* JADX WARN: Type inference failed for: r0v16, types: [float[], float] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List, float, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.List, float, java.util.ArrayList] */
    /* JADX WARN: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static b a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        float f2;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            name.hashCode();
            if (name.equals("gradient")) {
                String name2 = xml.getName();
                if (name2.equals("gradient")) {
                    TypedArray c1 = m.e.c1(resources, theme, asAttributeSet, R$styleable.GradientColor);
                    float f3 = !m.e.F0(xml, "startX") ? 0.0f : c1.getFloat(R$styleable.GradientColor_android_startX, 0.0f);
                    float f4 = !m.e.F0(xml, "startY") ? 0.0f : c1.getFloat(R$styleable.GradientColor_android_startY, 0.0f);
                    int i3 = R$styleable.GradientColor_android_endX;
                    if (m.e.F0(xml, "endX")) {
                        c1.getFloat(i3, 0.0f);
                    }
                    int i4 = R$styleable.GradientColor_android_endY;
                    if (m.e.F0(xml, "endY")) {
                        c1.getFloat(i4, 0.0f);
                    }
                    int i5 = R$styleable.GradientColor_android_centerX;
                    if (m.e.F0(xml, "centerX")) {
                        c1.getFloat(i5, 0.0f);
                    }
                    int i6 = R$styleable.GradientColor_android_centerY;
                    if (m.e.F0(xml, "centerY")) {
                        c1.getFloat(i6, 0.0f);
                    }
                    int i7 = !m.e.F0(xml, "type") ? 0 : c1.getInt(R$styleable.GradientColor_android_type, 0);
                    int color = !m.e.F0(xml, "startColor") ? 0 : c1.getColor(R$styleable.GradientColor_android_startColor, 0);
                    boolean F0 = m.e.F0(xml, "centerColor");
                    int color2 = !m.e.F0(xml, "centerColor") ? 0 : c1.getColor(R$styleable.GradientColor_android_centerColor, 0);
                    int color3 = !m.e.F0(xml, "endColor") ? 0 : c1.getColor(R$styleable.GradientColor_android_endColor, 0);
                    int i8 = !m.e.F0(xml, "tileMode") ? 0 : c1.getInt(R$styleable.GradientColor_android_tileMode, 0);
                    int i9 = R$styleable.GradientColor_android_gradientRadius;
                    if (m.e.F0(xml, "gradientRadius")) {
                        c1.getFloat(i9, 0.0f);
                    }
                    c1.recycle();
                    int depth = xml.getDepth() + 1;
                    ?? arrayList = new ArrayList(20);
                    ?? arrayList2 = new ArrayList(20);
                    Resources resources2 = resources;
                    while (true) {
                        int next2 = xml.next();
                        int i10 = 1;
                        if (next2 == 1) {
                            f2 = f4;
                            break;
                        }
                        i10 = xml.getDepth();
                        f2 = f4;
                        if (i10 < depth && next2 == 3) {
                            break;
                        }
                        i10 = i10;
                        if (next2 == 2) {
                            if (i10 <= depth) {
                                i10 = "item";
                                if (!xml.getName().equals(i10)) {
                                    continue;
                                } else {
                                    TypedArray c12 = m.e.c1(resources2, theme, asAttributeSet, R$styleable.GradientColorItem);
                                    int i11 = R$styleable.GradientColorItem_android_color;
                                    boolean hasValue = c12.hasValue(i11);
                                    int i12 = R$styleable.GradientColorItem_android_offset;
                                    boolean hasValue2 = c12.hasValue(i12);
                                    if (!hasValue || !hasValue2) {
                                        break;
                                    }
                                    int color4 = c12.getColor(i11, 0);
                                    i10 = 0;
                                    float f5 = c12.getFloat(i12, 0.0f);
                                    c12.recycle();
                                    arrayList2.add(Integer.valueOf(color4));
                                    arrayList.add(Float.valueOf(f5));
                                }
                            }
                            resources2 = resources;
                        }
                        boolean z = i10 == true ? 1 : 0;
                        f4 = f2;
                    }
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
            } else if (name.equals("selector")) {
                ColorStateList b = a.b(resources, xml, asAttributeSet, theme);
                return new b(null, b, b.getDefaultColor());
            } else {
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        } else {
            throw new XmlPullParserException("No start tag found");
        }
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.c) {
                this.c = colorForState;
                return true;
            }
        }
        return false;
    }
}
