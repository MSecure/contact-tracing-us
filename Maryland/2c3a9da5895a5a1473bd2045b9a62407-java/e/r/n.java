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
                        if (a2.f1764i == null) {
                            a2.f1764i = new HashMap<>();
                        }
                        a2.f1764i.put(string, d2);
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
                        if (a2.f1762g == null) {
                            a2.f1762g = new ArrayList<>();
                        }
                        a2.f1762g.add(hVar);
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
                                            d3.a.d(bundle, string5, d3.f1741d);
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
                            if (a2.f1763h == null) {
                                a2.f1763h = new i<>();
                            }
                            a2.f1763h.g(resourceId, cVar);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: e.r.p<float[]> */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:129|130|131) */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r8.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0285, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        r10.c(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x028a, code lost:
        r5 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x028c, code lost:
        r5 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x0282 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x0287 */
    public final d d(TypedArray typedArray, Resources resources, int i2) {
        boolean z;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        Object obj;
        boolean z2;
        int i3;
        p pVar5;
        String str;
        p pVar6 = p.c;
        p pVar7 = p.f1780h;
        p pVar8 = p.f1784l;
        p pVar9 = p.f1782j;
        p pVar10 = p.f1778f;
        p pVar11 = p.f1776d;
        p pVar12 = p.f1777e;
        p pVar13 = p.f1779g;
        p pVar14 = p.f1783k;
        p pVar15 = p.f1781i;
        p pVar16 = p.b;
        boolean z3 = typedArray.getBoolean(R$styleable.NavArgument_nullable, false);
        ThreadLocal<TypedValue> threadLocal = c;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(R$styleable.NavArgument_argType);
        p pVar17 = null;
        if (string != null) {
            pVar2 = pVar10;
            String resourcePackageName = resources.getResourcePackageName(i2);
            if ("integer".equals(string)) {
                pVar = pVar11;
                pVar3 = pVar16;
            } else {
                pVar = pVar11;
                if ("integer[]".equals(string)) {
                    z = z3;
                    pVar3 = pVar;
                } else if ("long".equals(string)) {
                    pVar3 = pVar12;
                } else if ("long[]".equals(string)) {
                    z = z3;
                    pVar3 = pVar2;
                } else if ("boolean".equals(string)) {
                    pVar3 = pVar15;
                } else if ("boolean[]".equals(string)) {
                    z = z3;
                    pVar3 = pVar9;
                } else if ("string".equals(string)) {
                    pVar3 = pVar14;
                } else if ("string[]".equals(string)) {
                    z = z3;
                    pVar3 = pVar8;
                } else if ("float".equals(string)) {
                    pVar3 = pVar13;
                } else if ("float[]".equals(string)) {
                    z = z3;
                    pVar3 = pVar7;
                } else if ("reference".equals(string)) {
                    pVar3 = pVar6;
                } else if (!string.isEmpty()) {
                    try {
                        if (!string.startsWith(".") || resourcePackageName == null) {
                            str = string;
                        } else {
                            str = resourcePackageName + string;
                        }
                        if (string.endsWith("[]")) {
                            z = z3;
                            str = str.substring(0, str.length() - 2);
                            Class<?> cls = Class.forName(str);
                            if (Parcelable.class.isAssignableFrom(cls)) {
                                pVar3 = new p.m(cls);
                            } else if (Serializable.class.isAssignableFrom(cls)) {
                                pVar3 = new p.o(cls);
                            }
                        } else {
                            z = z3;
                            Class<?> cls2 = Class.forName(str);
                            if (Parcelable.class.isAssignableFrom(cls2)) {
                                pVar3 = new p.n(cls2);
                            } else if (Enum.class.isAssignableFrom(cls2)) {
                                pVar3 = new p.l(cls2);
                            } else if (Serializable.class.isAssignableFrom(cls2)) {
                                pVar3 = new p.C0051p(cls2);
                            }
                        }
                        throw new IllegalArgumentException(str + " is not Serializable or Parcelable.");
                    } catch (ClassNotFoundException e2) {
                        throw new RuntimeException(e2);
                    }
                } else {
                    z = z3;
                    pVar3 = pVar14;
                }
            }
            z = z3;
        } else {
            pVar2 = pVar10;
            pVar = pVar11;
            z = z3;
            pVar3 = null;
        }
        int i4 = R$styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i4, typedValue)) {
            if (pVar3 == pVar6) {
                int i5 = typedValue.resourceId;
                if (i5 == 0) {
                    if (typedValue.type == 16 && typedValue.data == 0) {
                        i5 = 0;
                    } else {
                        StringBuilder h2 = a.h("unsupported value '");
                        h2.append((Object) typedValue.string);
                        h2.append("' for ");
                        h2.append(pVar3.b());
                        h2.append(". Must be a reference to a resource.");
                        throw new XmlPullParserException(h2.toString());
                    }
                }
                obj = Integer.valueOf(i5);
            } else {
                int i6 = typedValue.resourceId;
                if (i6 != 0) {
                    if (pVar3 == null) {
                        obj = Integer.valueOf(i6);
                    } else {
                        StringBuilder h3 = a.h("unsupported value '");
                        h3.append((Object) typedValue.string);
                        h3.append("' for ");
                        h3.append(pVar3.b());
                        h3.append(". You must use a \"");
                        throw new XmlPullParserException(a.e(h3, "reference", "\" type to reference other resources."));
                    }
                } else if (pVar3 == pVar14) {
                    obj = typedArray.getString(i4);
                } else {
                    int i7 = typedValue.type;
                    if (i7 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (pVar3 == null) {
                            try {
                                pVar16.c(charSequence);
                                pVar3 = pVar16;
                            } catch (IllegalArgumentException unused) {
                                pVar4 = pVar12;
                                pVar4.c(charSequence);
                                pVar3 = pVar4;
                            }
                        }
                        pVar4 = pVar12;
                        obj = pVar3.c(charSequence);
                    } else if (i7 != 4) {
                        if (i7 == 5) {
                            pVar5 = a(typedValue, pVar3, pVar16, string, "dimension");
                            i3 = (int) typedValue.getDimension(resources.getDisplayMetrics());
                        } else if (i7 == 18) {
                            pVar6 = a(typedValue, pVar3, pVar15, string, "boolean");
                            obj = Boolean.valueOf(typedValue.data != 0);
                        } else if (i7 < 16 || i7 > 31) {
                            StringBuilder h4 = a.h("unsupported argument type ");
                            h4.append(typedValue.type);
                            throw new XmlPullParserException(h4.toString());
                        } else {
                            pVar5 = a(typedValue, pVar3, pVar16, string, "integer");
                            i3 = typedValue.data;
                        }
                        Object valueOf = Integer.valueOf(i3);
                        pVar6 = pVar5;
                        obj = valueOf;
                    } else {
                        pVar6 = a(typedValue, pVar3, pVar13, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    }
                }
                pVar3 = pVar6;
            }
            pVar4 = pVar12;
        } else {
            pVar4 = pVar12;
            obj = null;
        }
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
            obj = null;
        }
        if (pVar3 != null) {
            pVar17 = pVar3;
        }
        if (pVar17 != null) {
            pVar4 = pVar17;
        } else if (obj instanceof Integer) {
            pVar4 = pVar16;
        } else if (obj instanceof int[]) {
            pVar4 = pVar;
        } else if (!(obj instanceof Long)) {
            if (obj instanceof long[]) {
                pVar4 = pVar2;
            } else if (obj instanceof Float) {
                pVar4 = pVar13;
            } else if (obj instanceof float[]) {
                pVar4 = pVar7;
            } else if (obj instanceof Boolean) {
                pVar4 = pVar15;
            } else if (obj instanceof boolean[]) {
                pVar4 = pVar9;
            } else if ((obj instanceof String) || obj == null) {
                pVar4 = pVar14;
            } else if (obj instanceof String[]) {
                pVar4 = pVar8;
            } else if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                pVar4 = new p.m(obj.getClass().getComponentType());
            } else if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                pVar4 = new p.o(obj.getClass().getComponentType());
            } else if (obj instanceof Parcelable) {
                pVar4 = new p.n(obj.getClass());
            } else if (obj instanceof Enum) {
                pVar4 = new p.l(obj.getClass());
            } else if (obj instanceof Serializable) {
                pVar4 = new p.C0051p(obj.getClass());
            } else {
                StringBuilder h5 = a.h("Object of type ");
                h5.append(obj.getClass().getName());
                h5.append(" is not supported for navigation arguments.");
                throw new IllegalArgumentException(h5.toString());
            }
        }
        return new d(pVar4, z, obj, z2);
    }
}
