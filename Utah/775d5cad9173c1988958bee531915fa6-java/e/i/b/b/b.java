package e.i.b.b;

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

public final class b {
    public final Shader a;
    public final ColorStateList b;
    public int c;

    public b(Shader shader, ColorStateList colorStateList, int i2) {
        this.a = shader;
        this.b = colorStateList;
        this.c = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0204, code lost:
        r1 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0207, code lost:
        r1 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x020a, code lost:
        r1 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020c, code lost:
        r3 = new android.graphics.LinearGradient(r12, r26, r14, r15, r4, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x021d, code lost:
        r3 = new android.graphics.SweepGradient(r7, r8, r0.a, r0.b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0232, code lost:
        if (r0 <= 0.0f) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0234, code lost:
        r1 = r0.a;
        r0 = r0.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x023b, code lost:
        if (r6 == 1) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x023e, code lost:
        if (r6 == 2) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0240, code lost:
        r2 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0243, code lost:
        r2 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0246, code lost:
        r2 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0248, code lost:
        r3 = new android.graphics.RadialGradient(r7, r8, r0, r1, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0260, code lost:
        return new e.i.b.b.b(r3, null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0268, code lost:
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01dc, code lost:
        if (r8.size() <= 0) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01de, code lost:
        r0 = new e.i.b.b.g(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e4, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e5, code lost:
        if (r0 == null) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01eb, code lost:
        if (r18 == false) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f1, code lost:
        r0 = new e.i.b.b.g(r5, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f5, code lost:
        if (r9 == 1) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f8, code lost:
        if (r9 == 2) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01fa, code lost:
        r4 = r0.a;
        r0 = r0.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0200, code lost:
        if (r6 == 1) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0202, code lost:
        if (r6 == 2) goto L_0x0207;
     */
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
                    TypedArray W0 = m.e.W0(resources, theme, asAttributeSet, R$styleable.GradientColor);
                    float f3 = !m.e.D0(xml, "startX") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_startX, 0.0f);
                    float f4 = !m.e.D0(xml, "startY") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_startY, 0.0f);
                    float f5 = !m.e.D0(xml, "endX") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_endX, 0.0f);
                    float f6 = !m.e.D0(xml, "endY") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_endY, 0.0f);
                    float f7 = !m.e.D0(xml, "centerX") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_centerX, 0.0f);
                    float f8 = !m.e.D0(xml, "centerY") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_centerY, 0.0f);
                    int i3 = !m.e.D0(xml, "type") ? 0 : W0.getInt(R$styleable.GradientColor_android_type, 0);
                    int color = !m.e.D0(xml, "startColor") ? 0 : W0.getColor(R$styleable.GradientColor_android_startColor, 0);
                    boolean D0 = m.e.D0(xml, "centerColor");
                    int color2 = !m.e.D0(xml, "centerColor") ? 0 : W0.getColor(R$styleable.GradientColor_android_centerColor, 0);
                    int color3 = !m.e.D0(xml, "endColor") ? 0 : W0.getColor(R$styleable.GradientColor_android_endColor, 0);
                    int i4 = !m.e.D0(xml, "tileMode") ? 0 : W0.getInt(R$styleable.GradientColor_android_tileMode, 0);
                    float f9 = !m.e.D0(xml, "gradientRadius") ? 0.0f : W0.getFloat(R$styleable.GradientColor_android_gradientRadius, 0.0f);
                    W0.recycle();
                    int depth = xml.getDepth() + 1;
                    ArrayList arrayList = new ArrayList(20);
                    ArrayList arrayList2 = new ArrayList(20);
                    Resources resources2 = resources;
                    while (true) {
                        int next2 = xml.next();
                        if (next2 == 1) {
                            f2 = f4;
                            break;
                        }
                        int depth2 = xml.getDepth();
                        f2 = f4;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2) {
                            if (depth2 <= depth) {
                                if (!xml.getName().equals("item")) {
                                    continue;
                                } else {
                                    TypedArray W02 = m.e.W0(resources2, theme, asAttributeSet, R$styleable.GradientColorItem);
                                    int i5 = R$styleable.GradientColorItem_android_color;
                                    boolean hasValue = W02.hasValue(i5);
                                    int i6 = R$styleable.GradientColorItem_android_offset;
                                    boolean hasValue2 = W02.hasValue(i6);
                                    if (!hasValue || !hasValue2) {
                                    } else {
                                        int color4 = W02.getColor(i5, 0);
                                        float f10 = W02.getFloat(i6, 0.0f);
                                        W02.recycle();
                                        arrayList2.add(Integer.valueOf(color4));
                                        arrayList.add(Float.valueOf(f10));
                                    }
                                }
                            }
                            resources2 = resources;
                        }
                        f5 = f5;
                        f4 = f2;
                    }
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
            } else if (name.equals("selector")) {
                ColorStateList b2 = a.b(resources, xml, asAttributeSet, theme);
                return new b(null, b2, b2.getDefaultColor());
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
