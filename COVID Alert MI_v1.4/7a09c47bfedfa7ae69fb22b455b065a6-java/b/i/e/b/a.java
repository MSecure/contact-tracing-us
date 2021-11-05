package b.i.e.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import b.b.k.i;
import b.i.c;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Shader f1722a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f1723b;

    /* renamed from: c  reason: collision with root package name */
    public int f1724c;

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.f1722a = shader;
        this.f1723b = colorStateList;
        this.f1724c = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014f, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    public static a a(Resources resources, int i, Resources.Theme theme) {
        int next;
        float f2;
        Shader shader;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c2 = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c2 = 0;
                }
            } else if (name.equals("gradient")) {
                c2 = 1;
            }
            if (c2 == 0) {
                ColorStateList r = i.j.r(resources, xml, asAttributeSet, theme);
                return new a(null, r, r.getDefaultColor());
            } else if (c2 == 1) {
                String name2 = xml.getName();
                if (name2.equals("gradient")) {
                    TypedArray S = i.j.S(resources, theme, asAttributeSet, c.GradientColor);
                    float C = i.j.C(S, xml, "startX", c.GradientColor_android_startX, 0.0f);
                    float C2 = i.j.C(S, xml, "startY", c.GradientColor_android_startY, 0.0f);
                    float C3 = i.j.C(S, xml, "endX", c.GradientColor_android_endX, 0.0f);
                    float C4 = i.j.C(S, xml, "endY", c.GradientColor_android_endY, 0.0f);
                    float C5 = i.j.C(S, xml, "centerX", c.GradientColor_android_centerX, 0.0f);
                    float C6 = i.j.C(S, xml, "centerY", c.GradientColor_android_centerY, 0.0f);
                    int D = i.j.D(S, xml, "type", c.GradientColor_android_type, 0);
                    int A = i.j.A(S, xml, "startColor", c.GradientColor_android_startColor, 0);
                    boolean K = i.j.K(xml, "centerColor");
                    i.j.A(S, xml, "centerColor", c.GradientColor_android_centerColor, 0);
                    int A2 = i.j.A(S, xml, "endColor", c.GradientColor_android_endColor, 0);
                    int D2 = i.j.D(S, xml, "tileMode", c.GradientColor_android_tileMode, 0);
                    float C7 = i.j.C(S, xml, "gradientRadius", c.GradientColor_android_gradientRadius, 0.0f);
                    S.recycle();
                    int depth = xml.getDepth() + 1;
                    ArrayList arrayList = new ArrayList(20);
                    ArrayList arrayList2 = new ArrayList(20);
                    Resources resources2 = resources;
                    while (true) {
                        int next2 = xml.next();
                        if (next2 == 1) {
                            f2 = C2;
                            break;
                        }
                        int depth2 = xml.getDepth();
                        f2 = C2;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2) {
                            if (depth2 <= depth) {
                                if (!xml.getName().equals("item")) {
                                    continue;
                                } else {
                                    TypedArray S2 = i.j.S(resources2, theme, asAttributeSet, c.GradientColorItem);
                                    boolean hasValue = S2.hasValue(c.GradientColorItem_android_color);
                                    boolean hasValue2 = S2.hasValue(c.GradientColorItem_android_offset);
                                    if (!hasValue || !hasValue2) {
                                    } else {
                                        int color = S2.getColor(c.GradientColorItem_android_color, 0);
                                        float f3 = S2.getFloat(c.GradientColorItem_android_offset, 0.0f);
                                        S2.recycle();
                                        arrayList2.add(Integer.valueOf(color));
                                        arrayList.add(Float.valueOf(f3));
                                    }
                                }
                            }
                            resources2 = resources;
                        }
                        C3 = C3;
                        C2 = f2;
                    }
                    f fVar = arrayList2.size() > 0 ? new f(arrayList2, arrayList) : null;
                    if (fVar == null) {
                        if (!K) {
                            fVar = new f(A, A2);
                        }
                    }
                    if (D != 1) {
                        if (D != 2) {
                            shader = new LinearGradient(C, f2, C3, C4, fVar.f1735a, fVar.f1736b, D2 != 1 ? D2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
                        } else {
                            shader = new SweepGradient(C5, C6, fVar.f1735a, fVar.f1736b);
                        }
                    } else if (C7 > 0.0f) {
                        shader = new RadialGradient(C5, C6, C7, fVar.f1735a, fVar.f1736b, D2 != 1 ? D2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
                    } else {
                        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                    }
                    return new a(shader, null, 0);
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
            } else {
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        } else {
            throw new XmlPullParserException("No start tag found");
        }
    }

    public boolean b() {
        return this.f1722a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.f1722a == null && (colorStateList = this.f1723b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.f1723b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1724c) {
                this.f1724c = colorForState;
                return true;
            }
        }
        return false;
    }
}
