package e.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class a {
    public String a;
    public EnumC0029a b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public float f1331d;

    /* renamed from: e  reason: collision with root package name */
    public String f1332e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1333f;

    /* renamed from: g  reason: collision with root package name */
    public int f1334g;

    /* renamed from: e.g.c.a$a  reason: collision with other inner class name */
    public enum EnumC0029a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public a(a aVar, Object obj) {
        this.a = aVar.a;
        this.b = aVar.b;
        b(obj);
    }

    public a(String str, EnumC0029a aVar, Object obj) {
        this.a = str;
        this.b = aVar;
        b(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        Object obj;
        EnumC0029a aVar;
        int i2;
        float f2;
        EnumC0029a aVar2 = EnumC0029a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        EnumC0029a aVar3 = null;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar3 = EnumC0029a.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    aVar = EnumC0029a.COLOR_TYPE;
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = EnumC0029a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == R$styleable.CustomAttribute_customPixelDimension) {
                        f2 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == R$styleable.CustomAttribute_customDimension) {
                        f2 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else {
                        if (index == R$styleable.CustomAttribute_customFloatValue) {
                            aVar = EnumC0029a.FLOAT_TYPE;
                            obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        } else if (index == R$styleable.CustomAttribute_customIntegerValue) {
                            aVar = EnumC0029a.INT_TYPE;
                            i2 = obtainStyledAttributes.getInteger(index, -1);
                            obj = Integer.valueOf(i2);
                        } else if (index == R$styleable.CustomAttribute_customStringValue) {
                            aVar = EnumC0029a.STRING_TYPE;
                            obj = obtainStyledAttributes.getString(index);
                        }
                        aVar3 = aVar;
                        obj2 = obj;
                    }
                    obj2 = Float.valueOf(f2);
                    aVar3 = aVar2;
                }
                i2 = obtainStyledAttributes.getColor(index, 0);
                obj = Integer.valueOf(i2);
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
        switch (this.b.ordinal()) {
            case 0:
                this.c = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f1331d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f1334g = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1332e = (String) obj;
                return;
            case 5:
                this.f1333f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
