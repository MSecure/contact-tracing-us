package e.i.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import e.b.a.m;
import e.i.c.d;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {

    public static class a {
        public static final Object a = new Object();
        public static Method b;
        public static boolean c;
    }

    public static a a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        a aVar;
        if (c(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new a(null, null, typedValue.data);
            }
            try {
                aVar = a.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception unused) {
                aVar = null;
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return new a(null, null, i3);
    }

    public static String b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!c(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        if (r17 == null) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
        if (r17 != null) goto L_0x007a;
     */
    public static Typeface d(Context context, int i2, TypedValue typedValue, int i3, g gVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface a2 = d.b.a(d.c(resources, i2, i3));
                if (a2 != null) {
                    if (gVar != null) {
                        gVar.b(a2, handler);
                    }
                    typeface = a2;
                } else {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            b N0 = m.h.N0(resources.getXml(i2), resources);
                            if (N0 != null) {
                                typeface = d.a(context, N0, resources, i2, i3, gVar, handler, z);
                            } else if (gVar != null) {
                                gVar.a(-3, handler);
                            }
                        } else {
                            Typeface b = d.b(context, resources, i2, charSequence2, i3);
                            if (gVar != null) {
                                if (b != null) {
                                    gVar.b(b, handler);
                                } else {
                                    gVar.a(-3, handler);
                                }
                            }
                            typeface = b;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                    }
                }
                if (typeface == null || gVar != null) {
                    return typeface;
                }
                StringBuilder i4 = f.a.a.a.a.i("Font resource ID #0x");
                i4.append(Integer.toHexString(i2));
                i4.append(" could not be retrieved.");
                throw new Resources.NotFoundException(i4.toString());
            }
            gVar.a(-3, handler);
            if (typeface == null) {
            }
            return typeface;
        }
        StringBuilder i5 = f.a.a.a.a.i("Resource \"");
        i5.append(resources.getResourceName(i2));
        i5.append("\" (");
        i5.append(Integer.toHexString(i2));
        i5.append(") is not a Font: ");
        i5.append(typedValue);
        throw new Resources.NotFoundException(i5.toString());
    }

    public static TypedArray e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
