package e.h.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class a {
    public boolean a;
    public String b;
    public EnumC0033a c;

    /* renamed from: d  reason: collision with root package name */
    public int f1457d;

    /* renamed from: e  reason: collision with root package name */
    public float f1458e;

    /* renamed from: f  reason: collision with root package name */
    public String f1459f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1460g;

    /* renamed from: h  reason: collision with root package name */
    public int f1461h;

    /* renamed from: e.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0033a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public a(a aVar, Object obj) {
        this.a = false;
        this.b = aVar.b;
        this.c = aVar.c;
        c(obj);
    }

    public a(String str, EnumC0033a aVar, Object obj, boolean z) {
        this.a = false;
        this.b = str;
        this.c = aVar;
        this.a = z;
        c(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        int i2;
        float f2;
        r5 = EnumC0033a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        EnumC0033a aVar = null;
        boolean z = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R$styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar = EnumC0033a.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    aVar = EnumC0033a.COLOR_TYPE;
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = EnumC0033a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == R$styleable.CustomAttribute_customPixelDimension) {
                        f2 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == R$styleable.CustomAttribute_customDimension) {
                        f2 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == R$styleable.CustomAttribute_customFloatValue) {
                        aVar = EnumC0033a.FLOAT_TYPE;
                        obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    } else {
                        if (index == R$styleable.CustomAttribute_customIntegerValue) {
                            aVar = EnumC0033a.INT_TYPE;
                            i2 = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == R$styleable.CustomAttribute_customStringValue) {
                            aVar = EnumC0033a.STRING_TYPE;
                            obj = obtainStyledAttributes.getString(index);
                        } else if (index == R$styleable.CustomAttribute_customReference) {
                            aVar = EnumC0033a.REFERENCE_TYPE;
                            i2 = obtainStyledAttributes.getResourceId(index, -1);
                            if (i2 == -1) {
                                i2 = obtainStyledAttributes.getInt(index, -1);
                            }
                        }
                        obj = Integer.valueOf(i2);
                    }
                    obj = Float.valueOf(f2);
                }
                i2 = obtainStyledAttributes.getColor(index, 0);
                obj = Integer.valueOf(i2);
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new a(str, aVar, obj, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void b(View view, HashMap<String, a> hashMap) {
        Class<?> cls = view.getClass();
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            a aVar = hashMap.get(next);
            if (!aVar.a) {
                next = f.a.a.a.a.x("set", next);
            }
            try {
                switch (aVar.c.ordinal()) {
                    case 0:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1457d));
                        break;
                    case 1:
                        cls.getMethod(next, Float.TYPE).invoke(view, Float.valueOf(aVar.f1458e));
                        break;
                    case 2:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1461h));
                        break;
                    case 3:
                        Method method = cls.getMethod(next, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f1461h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(next, CharSequence.class).invoke(view, aVar.f1459f);
                        break;
                    case 5:
                        cls.getMethod(next, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f1460g));
                        break;
                    case 6:
                        cls.getMethod(next, Float.TYPE).invoke(view, Float.valueOf(aVar.f1458e));
                        break;
                    case 7:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1457d));
                        break;
                }
            } catch (IllegalAccessException e2) {
                cls.getName();
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.getMessage();
                cls.getName();
            } catch (InvocationTargetException e4) {
                cls.getName();
                e4.printStackTrace();
            }
        }
    }

    public void c(Object obj) {
        switch (this.c.ordinal()) {
            case 0:
            case 7:
                this.f1457d = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f1458e = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f1461h = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1459f = (String) obj;
                return;
            case 5:
                this.f1460g = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
