package e.r;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.common.R$styleable;
import e.e.i;
import e.r.p;
import f.a.a.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class n {
    public static final ThreadLocal<TypedValue> c = new ThreadLocal<>();
    public Context a;
    public r b;

    public n(Context context, r rVar) {
        this.a = context;
        this.b = rVar;
    }

    public static p a(TypedValue typedValue, p pVar, p pVar2, String str, String str2) {
        if (pVar == null || pVar == pVar2) {
            return pVar != null ? pVar : pVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    public final j b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i2) {
        int depth;
        int i3;
        String str;
        j a2 = this.b.c(xmlResourceParser.getName()).a();
        a2.k(this.a, attributeSet);
        int i4 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i4 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return a2;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavArgument);
                    String string = obtainAttributes.getString(R$styleable.NavArgument_android_name);
                    if (string != null) {
                        d d2 = d(obtainAttributes, resources, i2);
                        if (a2.f1580i == null) {
                            a2.f1580i = new HashMap<>();
                        }
                        a2.f1580i.put(string, d2);
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else if ("deepLink".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R$styleable.NavDeepLink);
                    String string2 = obtainAttributes2.getString(R$styleable.NavDeepLink_uri);
                    String string3 = obtainAttributes2.getString(R$styleable.NavDeepLink_action);
                    String string4 = obtainAttributes2.getString(R$styleable.NavDeepLink_mimeType);
                    if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                        String str2 = null;
                        String replace = string2 != null ? string2.replace("${applicationId}", this.a.getPackageName()) : null;
                        if (!TextUtils.isEmpty(string3)) {
                            str = string3.replace("${applicationId}", this.a.getPackageName());
                            if (str.isEmpty()) {
                                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                            }
                        } else {
                            str = null;
                        }
                        if (string4 != null) {
                            str2 = string4.replace("${applicationId}", this.a.getPackageName());
                        }
                        h hVar = new h(replace, str, str2);
                        if (a2.f1578g == null) {
                            a2.f1578g = new ArrayList<>();
                        }
                        a2.f1578g.add(hVar);
                        obtainAttributes2.recycle();
                    } else {
                        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                    }
                } else {
                    if ("action".equals(name)) {
                        TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, R$styleable.NavAction);
                        int resourceId = obtainAttributes3.getResourceId(R$styleable.NavAction_android_id, 0);
                        c cVar = new c(obtainAttributes3.getResourceId(R$styleable.NavAction_destination, 0));
                        obtainAttributes3.getBoolean(R$styleable.NavAction_launchSingleTop, false);
                        obtainAttributes3.getResourceId(R$styleable.NavAction_popUpTo, -1);
                        obtainAttributes3.getBoolean(R$styleable.NavAction_popUpToInclusive, false);
                        obtainAttributes3.getResourceId(R$styleable.NavAction_enterAnim, -1);
                        obtainAttributes3.getResourceId(R$styleable.NavAction_exitAnim, -1);
                        obtainAttributes3.getResourceId(R$styleable.NavAction_popEnterAnim, -1);
                        obtainAttributes3.getResourceId(R$styleable.NavAction_popExitAnim, -1);
                        Bundle bundle = new Bundle();
                        int depth3 = xmlResourceParser.getDepth() + i4;
                        int i5 = i2;
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == i4) {
                                i3 = depth2;
                                break;
                            }
                            int depth4 = xmlResourceParser.getDepth();
                            i3 = depth2;
                            if (depth4 < depth3 && next2 == 3) {
                                break;
                            }
                            if (next2 == 2 && depth4 <= depth3) {
                                if ("argument".equals(xmlResourceParser.getName())) {
                                    TypedArray obtainAttributes4 = resources.obtainAttributes(attributeSet, R$styleable.NavArgument);
                                    String string5 = obtainAttributes4.getString(R$styleable.NavArgument_android_name);
                                    if (string5 != null) {
                                        d d3 = d(obtainAttributes4, resources, i5);
                                        boolean z = d3.c;
                                        if (z && z) {
                                            d3.a.d(bundle, string5, d3.f1557d);
                                        }
                                        obtainAttributes4.recycle();
                                    } else {
                                        throw new XmlPullParserException("Arguments must have a name");
                                    }
                                }
                                i5 = i2;
                            }
                            depth2 = i3;
                            i4 = 1;
                        }
                        bundle.isEmpty();
                        if (!a2.l()) {
                            throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + a2 + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                        } else if (resourceId != 0) {
                            if (a2.f1579h == null) {
                                a2.f1579h = new i<>();
                            }
                            a2.f1579h.g(resourceId, cVar);
                            obtainAttributes3.recycle();
                        } else {
                            throw new IllegalArgumentException("Cannot have an action with actionId 0");
                        }
                    } else {
                        i3 = depth2;
                        if ("include".equals(name) && (a2 instanceof k)) {
                            TypedArray obtainAttributes5 = resources.obtainAttributes(attributeSet, androidx.navigation.R$styleable.NavInclude);
                            ((k) a2).m(c(obtainAttributes5.getResourceId(androidx.navigation.R$styleable.NavInclude_graph, 0)));
                            obtainAttributes5.recycle();
                        } else if (a2 instanceof k) {
                            ((k) a2).m(b(resources, xmlResourceParser, attributeSet, i2));
                        }
                    }
                    depth2 = i3;
                    i4 = 1;
                }
                i3 = depth2;
                depth2 = i3;
                i4 = 1;
            }
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    public k c(int i2) {
        int next;
        Resources resources = this.a.getResources();
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                next = xml.next();
                if (next == 2 || next == 1) {
                    if (next != 2) {
                        String name = xml.getName();
                        j b2 = b(resources, xml, asAttributeSet, i2);
                        if (b2 instanceof k) {
                            k kVar = (k) b2;
                            xml.close();
                            return kVar;
                        }
                        throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e2) {
                throw new RuntimeException("Exception inflating " + resources.getResourceName(i2) + " line " + xml.getLineNumber(), e2);
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
        }
        if (next != 2) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:111|112|113|114|(2:115|116)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:111|112|113|114|115|116) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r2 = e.r.p.f1593e;
        r2.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r2 = e.r.p.f1595g;
        r2.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r2 = e.r.p.f1597i;
        r2.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025a, code lost:
        r2 = e.r.p.f1599k;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x0248 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x024e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0254 */
    public final d d(TypedArray typedArray, Resources resources, int i2) {
        p<Integer> pVar;
        Object obj;
        boolean z;
        p pVar2;
        int i3;
        int i4;
        p pVar3;
        String str;
        p pVar4;
        boolean z2 = typedArray.getBoolean(R$styleable.NavArgument_nullable, false);
        ThreadLocal<TypedValue> threadLocal = c;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(R$styleable.NavArgument_argType);
        if (string != null) {
            String resourcePackageName = resources.getResourcePackageName(i2);
            pVar = p.b;
            if (!"integer".equals(string)) {
                pVar = p.f1592d;
                if (!"integer[]".equals(string)) {
                    pVar = p.f1593e;
                    if (!"long".equals(string)) {
                        pVar = p.f1594f;
                        if (!"long[]".equals(string)) {
                            pVar = p.f1597i;
                            if (!"boolean".equals(string)) {
                                pVar = p.f1598j;
                                if (!"boolean[]".equals(string)) {
                                    pVar = p.f1599k;
                                    if (!"string".equals(string)) {
                                        p pVar5 = p.f1600l;
                                        if (!"string[]".equals(string)) {
                                            pVar5 = p.f1595g;
                                            if (!"float".equals(string)) {
                                                pVar5 = p.f1596h;
                                                if (!"float[]".equals(string)) {
                                                    pVar5 = p.c;
                                                    if (!"reference".equals(string)) {
                                                        if (!string.isEmpty()) {
                                                            try {
                                                                if (!string.startsWith(".") || resourcePackageName == null) {
                                                                    str = string;
                                                                } else {
                                                                    str = resourcePackageName + string;
                                                                }
                                                                if (string.endsWith("[]")) {
                                                                    str = str.substring(0, str.length() - 2);
                                                                    Class<?> cls = Class.forName(str);
                                                                    if (Parcelable.class.isAssignableFrom(cls)) {
                                                                        pVar4 = new p.m(cls);
                                                                    } else {
                                                                        if (Serializable.class.isAssignableFrom(cls)) {
                                                                            pVar4 = new p.o(cls);
                                                                        }
                                                                        throw new IllegalArgumentException(str + " is not Serializable or Parcelable.");
                                                                    }
                                                                } else {
                                                                    Class<?> cls2 = Class.forName(str);
                                                                    if (Parcelable.class.isAssignableFrom(cls2)) {
                                                                        pVar4 = new p.n(cls2);
                                                                    } else if (Enum.class.isAssignableFrom(cls2)) {
                                                                        pVar4 = new p.l(cls2);
                                                                    } else {
                                                                        if (Serializable.class.isAssignableFrom(cls2)) {
                                                                            pVar4 = new p.C0046p(cls2);
                                                                        }
                                                                        throw new IllegalArgumentException(str + " is not Serializable or Parcelable.");
                                                                    }
                                                                }
                                                                pVar = pVar4;
                                                            } catch (ClassNotFoundException e2) {
                                                                throw new RuntimeException(e2);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        pVar = pVar5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            pVar = null;
        }
        int i5 = R$styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i5, typedValue)) {
            p<Integer> pVar6 = p.c;
            if (pVar == pVar6) {
                i3 = typedValue.resourceId;
                if (i3 == 0) {
                    if (typedValue.type == 16 && typedValue.data == 0) {
                        obj = 0;
                    } else {
                        StringBuilder i6 = a.i("unsupported value '");
                        i6.append((Object) typedValue.string);
                        i6.append("' for ");
                        i6.append(pVar.b());
                        i6.append(". Must be a reference to a resource.");
                        throw new XmlPullParserException(i6.toString());
                    }
                }
            } else {
                int i7 = typedValue.resourceId;
                if (i7 != 0) {
                    if (pVar == null) {
                        obj = Integer.valueOf(i7);
                        pVar = pVar6;
                    } else {
                        StringBuilder i8 = a.i("unsupported value '");
                        i8.append((Object) typedValue.string);
                        i8.append("' for ");
                        i8.append(pVar.b());
                        i8.append(". You must use a \"");
                        throw new XmlPullParserException(a.f(i8, "reference", "\" type to reference other resources."));
                    }
                } else if (pVar == p.f1599k) {
                    obj = typedArray.getString(i5);
                } else {
                    int i9 = typedValue.type;
                    if (i9 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (pVar == null) {
                            p pVar7 = p.b;
                            pVar7.c(charSequence);
                            pVar = pVar7;
                        }
                        obj = pVar.c(charSequence);
                    } else if (i9 != 4) {
                        if (i9 == 5) {
                            pVar3 = a(typedValue, pVar, p.b, string, "dimension");
                            i4 = (int) typedValue.getDimension(resources.getDisplayMetrics());
                        } else if (i9 == 18) {
                            pVar = a(typedValue, pVar, p.f1597i, string, "boolean");
                            obj = Boolean.valueOf(typedValue.data != 0);
                        } else if (i9 < 16 || i9 > 31) {
                            StringBuilder i10 = a.i("unsupported argument type ");
                            i10.append(typedValue.type);
                            throw new XmlPullParserException(i10.toString());
                        } else {
                            pVar3 = a(typedValue, pVar, p.b, string, "integer");
                            i4 = typedValue.data;
                        }
                        pVar = pVar3;
                        i3 = i4;
                    } else {
                        pVar = a(typedValue, pVar, p.f1595g, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    }
                }
            }
            obj = Integer.valueOf(i3);
        } else {
            obj = null;
        }
        if (obj != null) {
            z = true;
        } else {
            obj = null;
            z = false;
        }
        if (pVar == null) {
            pVar = null;
        }
        if (pVar == null) {
            if (obj instanceof Integer) {
                pVar2 = p.b;
            } else if (obj instanceof int[]) {
                pVar2 = p.f1592d;
            } else if (obj instanceof Long) {
                pVar2 = p.f1593e;
            } else if (obj instanceof long[]) {
                pVar2 = p.f1594f;
            } else if (obj instanceof Float) {
                pVar2 = p.f1595g;
            } else if (obj instanceof float[]) {
                pVar2 = p.f1596h;
            } else if (obj instanceof Boolean) {
                pVar2 = p.f1597i;
            } else if (obj instanceof boolean[]) {
                pVar2 = p.f1598j;
            } else if ((obj instanceof String) || obj == null) {
                pVar2 = p.f1599k;
            } else if (obj instanceof String[]) {
                pVar2 = p.f1600l;
            } else if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                pVar2 = new p.m(obj.getClass().getComponentType());
            } else if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                pVar2 = new p.o(obj.getClass().getComponentType());
            } else if (obj instanceof Parcelable) {
                pVar2 = new p.n(obj.getClass());
            } else if (obj instanceof Enum) {
                pVar2 = new p.l(obj.getClass());
            } else if (obj instanceof Serializable) {
                pVar2 = new p.C0046p(obj.getClass());
            } else {
                StringBuilder i11 = a.i("Object of type ");
                i11.append(obj.getClass().getName());
                i11.append(" is not supported for navigation arguments.");
                throw new IllegalArgumentException(i11.toString());
            }
            pVar = pVar2;
        }
        return new d(pVar, z2, obj, z);
    }
}
