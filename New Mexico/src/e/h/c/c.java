package e.h.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import e.h.c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c {
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;

    /* renamed from: d */
    public SparseArray<a> f1475d = new SparseArray<>();

    /* renamed from: e */
    public SparseArray<d> f1476e = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c;

        /* renamed from: d */
        public d f1477d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.State_android_id) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == R$styleable.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1477d = dVar;
                        dVar.c((ConstraintLayout) LayoutInflater.from(context).inflate(this.c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public float a;
        public float b;
        public float c;

        /* renamed from: d */
        public float f1478d;

        /* renamed from: e */
        public int f1479e;

        /* renamed from: f */
        public d f1480f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.f1478d = Float.NaN;
            this.f1479e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.Variant_constraints) {
                    this.f1479e = obtainStyledAttributes.getResourceId(index, this.f1479e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1479e);
                    context.getResources().getResourceName(this.f1479e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1480f = dVar;
                        dVar.c((ConstraintLayout) LayoutInflater.from(context).inflate(this.f1479e, (ViewGroup) null));
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f1478d = obtainStyledAttributes.getDimension(index, this.f1478d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.a) && f2 < this.a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f3 < this.b) {
                return false;
            }
            if (Float.isNaN(this.c) || f2 <= this.c) {
                return Float.isNaN(this.f1478d) || f3 <= this.f1478d;
            }
            return false;
        }
    }

    public c(Context context, ConstraintLayout constraintLayout, int i2) {
        this.a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                char c = 1;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 2) {
                            a aVar2 = new a(context, xml);
                            this.f1475d.put(aVar2.a, aVar2);
                            aVar = aVar2;
                        } else if (c == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        } else if (c == 4) {
                            a(context, xml);
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0220, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void a(Context context, XmlPullParser xmlPullParser) {
        int eventType;
        d.a aVar;
        d.a aVar2;
        char c;
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                try {
                    eventType = xmlPullParser.getEventType();
                    aVar = null;
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (XmlPullParserException e3) {
                    e3.printStackTrace();
                }
                while (eventType != 1) {
                    if (eventType != 0) {
                        char c2 = 2;
                        if (eventType == 2) {
                            String name = xmlPullParser.getName();
                            switch (name.hashCode()) {
                                case -2025855158:
                                    if (name.equals("Layout")) {
                                        c2 = 6;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1984451626:
                                    if (name.equals("Motion")) {
                                        c2 = 7;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1962203927:
                                    if (name.equals("ConstraintOverride")) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1269513683:
                                    if (name.equals("PropertySet")) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1238332596:
                                    if (name.equals("Transform")) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -71750448:
                                    if (name.equals("Guideline")) {
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 366511058:
                                    if (name.equals("CustomMethod")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1331510167:
                                    if (name.equals("Barrier")) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1791837707:
                                    if (name.equals("CustomAttribute")) {
                                        c2 = '\b';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 1803088381:
                                    if (name.equals("Constraint")) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    aVar2 = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                    aVar = aVar2;
                                    break;
                                case 1:
                                    aVar2 = dVar.e(context, Xml.asAttributeSet(xmlPullParser), true);
                                    aVar = aVar2;
                                    break;
                                case 2:
                                    aVar2 = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                    d.b bVar = aVar2.f1484d;
                                    bVar.a = true;
                                    bVar.b = true;
                                    aVar = aVar2;
                                    break;
                                case 3:
                                    aVar2 = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                    aVar2.f1484d.h0 = 1;
                                    aVar = aVar2;
                                    break;
                                case 4:
                                    if (aVar != null) {
                                        aVar.b.a(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                    }
                                case 5:
                                    if (aVar != null) {
                                        aVar.f1485e.a(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                    }
                                case 6:
                                    if (aVar != null) {
                                        aVar.f1484d.a(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                    }
                                case 7:
                                    if (aVar != null) {
                                        aVar.c.a(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                    }
                                case '\b':
                                case '\t':
                                    if (aVar != null) {
                                        a.a(context, xmlPullParser, aVar.f1486f);
                                        break;
                                    } else {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                    }
                            }
                        } else if (eventType == 3) {
                            String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                            switch (lowerCase.hashCode()) {
                                case -2075718416:
                                    if (lowerCase.equals("guideline")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -190376483:
                                    if (lowerCase.equals("constraint")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 426575017:
                                    if (lowerCase.equals("constraintoverride")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 2146106725:
                                    if (lowerCase.equals("constraintset")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            if (c == 0) {
                                this.f1476e.put(identifier, dVar);
                                return;
                            } else if (c == 1 || c == 2 || c == 3) {
                                dVar.c.put(Integer.valueOf(aVar.a), aVar);
                                aVar = null;
                            }
                        }
                    } else {
                        xmlPullParser.getName();
                    }
                    eventType = xmlPullParser.next();
                }
                this.f1476e.put(identifier, dVar);
                return;
            }
        }
    }
}
