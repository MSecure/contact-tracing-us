package e.i.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
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
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r20 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0026, code lost:
        if (r20 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9 A[ADDED_TO_REGION] */
    public static Typeface d(Context context, int i2, TypedValue typedValue, int i3, g gVar, Handler handler, boolean z) {
        String str;
        StringBuilder sb;
        Throwable e2;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                Typeface a2 = d.b.a(d.c(resources, i2, i3));
                if (a2 == null) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            b H0 = m.h.H0(resources.getXml(i2), resources);
                            if (H0 == null) {
                                Log.e("ResourcesCompat", "Failed to find font-family tag");
                                if (gVar != null) {
                                    gVar.a(-3, handler);
                                }
                            } else {
                                typeface = d.a(context, H0, resources, i2, i3, gVar, handler, z);
                            }
                            if (typeface == null || gVar != null) {
                                return typeface;
                            }
                            StringBuilder h2 = f.a.a.a.a.h("Font resource ID #0x");
                            h2.append(Integer.toHexString(i2));
                            h2.append(" could not be retrieved.");
                            throw new Resources.NotFoundException(h2.toString());
                        }
                        a2 = d.b(context, resources, i2, charSequence2, i3);
                        if (gVar != null) {
                            if (a2 != null) {
                                gVar.b(a2, handler);
                            } else {
                                gVar.a(-3, handler);
                            }
                        }
                    } catch (XmlPullParserException e3) {
                        e2 = e3;
                        sb = new StringBuilder();
                        str = "Failed to parse xml resource ";
                        sb.append(str);
                        sb.append(charSequence2);
                        Log.e("ResourcesCompat", sb.toString(), e2);
                    } catch (IOException e4) {
                        e2 = e4;
                        sb = new StringBuilder();
                        str = "Failed to read xml resource ";
                        sb.append(str);
                        sb.append(charSequence2);
                        Log.e("ResourcesCompat", sb.toString(), e2);
                    }
                } else if (gVar != null) {
                    gVar.b(a2, handler);
                }
                typeface = a2;
                if (typeface == null) {
                }
                return typeface;
            }
            gVar.a(-3, handler);
            if (typeface == null) {
            }
            return typeface;
        }
        StringBuilder h3 = f.a.a.a.a.h("Resource \"");
        h3.append(resources.getResourceName(i2));
        h3.append("\" (");
        h3.append(Integer.toHexString(i2));
        h3.append(") is not a Font: ");
        h3.append(typedValue);
        throw new Resources.NotFoundException(h3.toString());
    }

    public static TypedArray e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
