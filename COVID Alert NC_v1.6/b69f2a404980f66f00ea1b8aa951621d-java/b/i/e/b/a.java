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
    public final Shader f1026a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f1027b;

    /* renamed from: c  reason: collision with root package name */
    public int f1028c;

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.f1026a = shader;
        this.f1027b = colorStateList;
        this.f1028c = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014f, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    public static a a(Resources resources, int i, Resources.Theme theme) {
        int next;
        float f;
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
                ColorStateList I = i.j.I(resources, xml, asAttributeSet, theme);
                return new a(null, I, I.getDefaultColor());
            } else if (c2 == 1) {
                String name2 = xml.getName();
                if (name2.equals("gradient")) {
                    TypedArray C0 = i.j.C0(resources, theme, asAttributeSet, c.GradientColor);
                    float g0 = i.j.g0(C0, xml, "startX", c.GradientColor_android_startX, 0.0f);
                    float g02 = i.j.g0(C0, xml, "startY", c.GradientColor_android_startY, 0.0f);
                    float g03 = i.j.g0(C0, xml, "endX", c.GradientColor_android_endX, 0.0f);
                    float g04 = i.j.g0(C0, xml, "endY", c.GradientColor_android_endY, 0.0f);
                    float g05 = i.j.g0(C0, xml, "centerX", c.GradientColor_android_centerX, 0.0f);
                    float g06 = i.j.g0(C0, xml, "centerY", c.GradientColor_android_centerY, 0.0f);
                    int h0 = i.j.h0(C0, xml, "type", c.GradientColor_android_type, 0);
                    int e0 = i.j.e0(C0, xml, "startColor", c.GradientColor_android_startColor, 0);
                    boolean q0 = i.j.q0(xml, "centerColor");
                    i.j.e0(C0, xml, "centerColor", c.GradientColor_android_centerColor, 0);
                    int e02 = i.j.e0(C0, xml, "endColor", c.GradientColor_android_endColor, 0);
                    int h02 = i.j.h0(C0, xml, "tileMode", c.GradientColor_android_tileMode, 0);
                    float g07 = i.j.g0(C0, xml, "gradientRadius", c.GradientColor_android_gradientRadius, 0.0f);
                    C0.recycle();
                    int depth = xml.getDepth() + 1;
                    ArrayList arrayList = new ArrayList(20);
                    ArrayList arrayList2 = new ArrayList(20);
                    Resources resources2 = resources;
                    while (true) {
                        int next2 = xml.next();
                        if (next2 == 1) {
                            f = g02;
                            break;
                        }
                        int depth2 = xml.getDepth();
                        f = g02;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2) {
                            if (depth2 <= depth) {
                                if (!xml.getName().equals("item")) {
                                    continue;
                                } else {
                                    TypedArray C02 = i.j.C0(resources2, theme, asAttributeSet, c.GradientColorItem);
                                    boolean hasValue = C02.hasValue(c.GradientColorItem_android_color);
                                    boolean hasValue2 = C02.hasValue(c.GradientColorItem_android_offset);
                                    if (!hasValue || !hasValue2) {
                                    } else {
                                        int color = C02.getColor(c.GradientColorItem_android_color, 0);
                                        float f2 = C02.getFloat(c.GradientColorItem_android_offset, 0.0f);
                                        C02.recycle();
                                        arrayList2.add(Integer.valueOf(color));
                                        arrayList.add(Float.valueOf(f2));
                                    }
                                }
                            }
                            resources2 = resources;
                        }
                        g03 = g03;
                        g02 = f;
                    }
                    f fVar = arrayList2.size() > 0 ? new f(arrayList2, arrayList) : null;
                    if (fVar == null) {
                        if (!q0) {
                            fVar = new f(e0, e02);
                        }
                    }
                    if (h0 != 1) {
                        if (h0 != 2) {
                            shader = new LinearGradient(g0, f, g03, g04, fVar.f1038a, fVar.f1039b, h02 != 1 ? h02 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
                        } else {
                            shader = new SweepGradient(g05, g06, fVar.f1038a, fVar.f1039b);
                        }
                    } else if (g07 > 0.0f) {
                        shader = new RadialGradient(g05, g06, g07, fVar.f1038a, fVar.f1039b, h02 != 1 ? h02 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
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
        return this.f1026a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.f1026a == null && (colorStateList = this.f1027b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.f1027b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1028c) {
                this.f1028c = colorForState;
                return true;
            }
        }
        return false;
    }
}
