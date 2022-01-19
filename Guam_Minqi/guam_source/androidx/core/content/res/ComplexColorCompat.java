package androidx.core.content.res;

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
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.R$styleable;
import com.facebook.react.uimanager.BaseViewManager;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    public int mColor;
    public final ColorStateList mColorStateList;
    public final Shader mShader;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014f, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    public static ComplexColorCompat createFromXml(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        float f;
        Shader shader;
        Shader.TileMode tileMode;
        Shader.TileMode tileMode2;
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
            char c = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
            } else if (name.equals("gradient")) {
                c = 1;
            }
            if (c == 0) {
                ColorStateList createFromXmlInner = AppCompatDelegateImpl.ConfigurationImplApi17.createFromXmlInner(resources, xml, asAttributeSet, theme);
                return new ComplexColorCompat(null, createFromXmlInner, createFromXmlInner.getDefaultColor());
            } else if (c == 1) {
                String name2 = xml.getName();
                if (name2.equals("gradient")) {
                    TypedArray obtainAttributes1 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources, theme, asAttributeSet, R$styleable.GradientColor);
                    float namedFloat = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "startX", R$styleable.GradientColor_android_startX, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    float namedFloat2 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "startY", R$styleable.GradientColor_android_startY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    float namedFloat3 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "endX", R$styleable.GradientColor_android_endX, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    float namedFloat4 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "endY", R$styleable.GradientColor_android_endY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    float namedFloat5 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "centerX", R$styleable.GradientColor_android_centerX, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    float namedFloat6 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "centerY", R$styleable.GradientColor_android_centerY, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    int namedInt = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes1, xml, "type", R$styleable.GradientColor_android_type, 0);
                    int namedColor = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedColor(obtainAttributes1, xml, "startColor", R$styleable.GradientColor_android_startColor, 0);
                    boolean hasAttribute = AppCompatDelegateImpl.ConfigurationImplApi17.hasAttribute(xml, "centerColor");
                    int namedColor2 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedColor(obtainAttributes1, xml, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
                    int namedColor3 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedColor(obtainAttributes1, xml, "endColor", R$styleable.GradientColor_android_endColor, 0);
                    int namedInt2 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedInt(obtainAttributes1, xml, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
                    float namedFloat7 = AppCompatDelegateImpl.ConfigurationImplApi17.getNamedFloat(obtainAttributes1, xml, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    obtainAttributes1.recycle();
                    int depth = xml.getDepth() + 1;
                    ArrayList arrayList = new ArrayList(20);
                    ArrayList arrayList2 = new ArrayList(20);
                    Resources resources2 = resources;
                    while (true) {
                        int next2 = xml.next();
                        if (next2 == 1) {
                            f = namedFloat2;
                            break;
                        }
                        int depth2 = xml.getDepth();
                        f = namedFloat2;
                        if (depth2 < depth && next2 == 3) {
                            break;
                        }
                        if (next2 == 2) {
                            if (depth2 <= depth) {
                                if (!xml.getName().equals("item")) {
                                    continue;
                                } else {
                                    TypedArray obtainAttributes12 = AppCompatDelegateImpl.ConfigurationImplApi17.obtainAttributes1(resources2, theme, asAttributeSet, R$styleable.GradientColorItem);
                                    boolean hasValue = obtainAttributes12.hasValue(R$styleable.GradientColorItem_android_color);
                                    boolean hasValue2 = obtainAttributes12.hasValue(R$styleable.GradientColorItem_android_offset);
                                    if (!hasValue || !hasValue2) {
                                    } else {
                                        int color = obtainAttributes12.getColor(R$styleable.GradientColorItem_android_color, 0);
                                        float f2 = obtainAttributes12.getFloat(R$styleable.GradientColorItem_android_offset, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                                        obtainAttributes12.recycle();
                                        arrayList2.add(Integer.valueOf(color));
                                        arrayList.add(Float.valueOf(f2));
                                    }
                                }
                            }
                            resources2 = resources;
                        }
                        namedFloat3 = namedFloat3;
                        namedFloat2 = f;
                    }
                    GradientColorInflaterCompat$ColorStops gradientColorInflaterCompat$ColorStops = arrayList2.size() > 0 ? new GradientColorInflaterCompat$ColorStops(arrayList2, arrayList) : null;
                    if (gradientColorInflaterCompat$ColorStops == null) {
                        if (hasAttribute) {
                            gradientColorInflaterCompat$ColorStops = new GradientColorInflaterCompat$ColorStops(namedColor, namedColor2, namedColor3);
                        } else {
                            gradientColorInflaterCompat$ColorStops = new GradientColorInflaterCompat$ColorStops(namedColor, namedColor3);
                        }
                    }
                    if (namedInt != 1) {
                        if (namedInt != 2) {
                            int[] iArr = gradientColorInflaterCompat$ColorStops.mColors;
                            float[] fArr = gradientColorInflaterCompat$ColorStops.mOffsets;
                            if (namedInt2 == 1) {
                                tileMode2 = Shader.TileMode.REPEAT;
                            } else if (namedInt2 != 2) {
                                tileMode2 = Shader.TileMode.CLAMP;
                            } else {
                                tileMode2 = Shader.TileMode.MIRROR;
                            }
                            shader = new LinearGradient(namedFloat, f, namedFloat3, namedFloat4, iArr, fArr, tileMode2);
                        } else {
                            shader = new SweepGradient(namedFloat5, namedFloat6, gradientColorInflaterCompat$ColorStops.mColors, gradientColorInflaterCompat$ColorStops.mOffsets);
                        }
                    } else if (namedFloat7 > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        int[] iArr2 = gradientColorInflaterCompat$ColorStops.mColors;
                        float[] fArr2 = gradientColorInflaterCompat$ColorStops.mOffsets;
                        if (namedInt2 == 1) {
                            tileMode = Shader.TileMode.REPEAT;
                        } else if (namedInt2 != 2) {
                            tileMode = Shader.TileMode.CLAMP;
                        } else {
                            tileMode = Shader.TileMode.MIRROR;
                        }
                        shader = new RadialGradient(namedFloat5, namedFloat6, namedFloat7, iArr2, fArr2, tileMode);
                    } else {
                        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                    }
                    return new ComplexColorCompat(shader, null, 0);
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
            } else {
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
        } else {
            throw new XmlPullParserException("No start tag found");
        }
    }

    public boolean isGradient() {
        return this.mShader != null;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        return this.mShader == null && (colorStateList = this.mColorStateList) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            ColorStateList colorStateList = this.mColorStateList;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.mColor) {
                this.mColor = colorForState;
                return true;
            }
        }
        return false;
    }
}
