package e.g.c;

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

public class a {
    public boolean a = false;
    public String b;
    public EnumC0030a c;

    /* renamed from: d  reason: collision with root package name */
    public int f1373d;

    /* renamed from: e  reason: collision with root package name */
    public float f1374e;

    /* renamed from: f  reason: collision with root package name */
    public String f1375f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1376g;

    /* renamed from: h  reason: collision with root package name */
    public int f1377h;

    /* renamed from: e.g.c.a$a  reason: collision with other inner class name */
    public enum EnumC0030a {
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
        this.b = aVar.b;
        this.c = aVar.c;
        c(obj);
    }

    public a(String str, EnumC0030a aVar, Object obj, boolean z) {
        this.b = str;
        this.c = aVar;
        this.a = z;
        c(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        Object obj;
        EnumC0030a aVar;
        int i2;
        float f2;
        EnumC0030a aVar2 = EnumC0030a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        EnumC0030a aVar3 = null;
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
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar3 = EnumC0030a.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    aVar = EnumC0030a.COLOR_TYPE;
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    aVar = EnumC0030a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == R$styleable.CustomAttribute_customPixelDimension) {
                        f2 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == R$styleable.CustomAttribute_customDimension) {
                        f2 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else {
                        if (index == R$styleable.CustomAttribute_customFloatValue) {
                            aVar = EnumC0030a.FLOAT_TYPE;
                            obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        } else {
                            if (index == R$styleable.CustomAttribute_customIntegerValue) {
                                aVar = EnumC0030a.INT_TYPE;
                                i2 = obtainStyledAttributes.getInteger(index, -1);
                            } else if (index == R$styleable.CustomAttribute_customStringValue) {
                                aVar = EnumC0030a.STRING_TYPE;
                                obj = obtainStyledAttributes.getString(index);
                            } else if (index == R$styleable.CustomAttribute_customReference) {
                                aVar = EnumC0030a.REFERENCE_TYPE;
                                i2 = obtainStyledAttributes.getResourceId(index, -1);
                                if (i2 == -1) {
                                    i2 = obtainStyledAttributes.getInt(index, -1);
                                }
                            }
                            obj = Integer.valueOf(i2);
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
            hashMap.put(str, new a(str, aVar3, obj2, z));
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
                next = f.a.a.a.a.w("set", next);
            }
            try {
                switch (aVar.c.ordinal()) {
                    case 0:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1373d));
                        continue;
                    case 1:
                        cls.getMethod(next, Float.TYPE).invoke(view, Float.valueOf(aVar.f1374e));
                        continue;
                    case 2:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1377h));
                        continue;
                    case 3:
                        Method method = cls.getMethod(next, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(aVar.f1377h);
                        method.invoke(view, colorDrawable);
                        continue;
                    case 4:
                        cls.getMethod(next, CharSequence.class).invoke(view, aVar.f1375f);
                        continue;
                    case 5:
                        cls.getMethod(next, Boolean.TYPE).invoke(view, Boolean.valueOf(aVar.f1376g));
                        continue;
                    case 6:
                        cls.getMethod(next, Float.TYPE).invoke(view, Float.valueOf(aVar.f1374e));
                        continue;
                    case 7:
                        cls.getMethod(next, Integer.TYPE).invoke(view, Integer.valueOf(aVar.f1373d));
                        continue;
                    default:
                        continue;
                }
            } catch (NoSuchMethodException e2) {
                e2.getMessage();
                cls.getName();
            } catch (IllegalAccessException e3) {
                cls.getName();
                e3.printStackTrace();
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
                this.f1373d = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f1374e = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f1377h = ((Integer) obj).intValue();
                return;
            case 4:
                this.f1375f = (String) obj;
                return;
            case 5:
                this.f1376g = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
