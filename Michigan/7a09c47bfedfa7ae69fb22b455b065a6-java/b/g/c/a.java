package b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f1569a;

    /* renamed from: b  reason: collision with root package name */
    public EnumC0026a f1570b;

    /* renamed from: c  reason: collision with root package name */
    public int f1571c;

    /* renamed from: d  reason: collision with root package name */
    public float f1572d;

    /* renamed from: e  reason: collision with root package name */
    public String f1573e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1574f;

    /* renamed from: g  reason: collision with root package name */
    public int f1575g;

    /* renamed from: b.g.c.a$a  reason: collision with other inner class name */
    public enum EnumC0026a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public a(a aVar, Object obj) {
        this.f1569a = aVar.f1569a;
        this.f1570b = aVar.f1570b;
        b(obj);
    }

    public a(String str, EnumC0026a aVar, Object obj) {
        this.f1569a = str;
        this.f1570b = aVar;
        b(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        Object obj;
        EnumC0026a aVar;
        int i;
        float f2;
        EnumC0026a aVar2 = EnumC0026a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        EnumC0026a aVar3 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == i.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == i.CustomAttribute_customBoolean) {
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar3 = EnumC0026a.BOOLEAN_TYPE;
            } else {
                if (index == i.CustomAttribute_customColorValue) {
                    aVar = EnumC0026a.COLOR_TYPE;
                } else if (index == i.CustomAttribute_customColorDrawableValue) {
                    aVar = EnumC0026a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == i.CustomAttribute_customPixelDimension) {
                        f2 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == i.CustomAttribute_customDimension) {
                        f2 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else {
                        if (index == i.CustomAttribute_customFloatValue) {
                            aVar = EnumC0026a.FLOAT_TYPE;
                            obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        } else if (index == i.CustomAttribute_customIntegerValue) {
                            aVar = EnumC0026a.INT_TYPE;
                            i = obtainStyledAttributes.getInteger(index, -1);
                            obj = Integer.valueOf(i);
                        } else if (index == i.CustomAttribute_customStringValue) {
                            aVar = EnumC0026a.STRING_TYPE;
                            obj = obtainStyledAttributes.getString(index);
                        }
                        aVar3 = aVar;
                        obj2 = obj;
                    }
                    obj2 = Float.valueOf(f2);
                    aVar3 = aVar2;
                }
                i = obtainStyledAttributes.getColor(index, 0);
                obj = Integer.valueOf(i);
                aVar3 = aVar;
                obj2 = obj;
            }
        }
        if (!(str == null || obj2 == null)) {
            hashMap.put(str, new a(str, aVar3, obj2));
        }
        obtainStyledAttributes.recycle();
    }

    public void b(Object obj) {
        switch (this.f1570b.ordinal()) {
            case 0:
                this.f1571c = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f1572d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f1575g = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1573e = (String) obj;
                return;
            case 5:
                this.f1574f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
