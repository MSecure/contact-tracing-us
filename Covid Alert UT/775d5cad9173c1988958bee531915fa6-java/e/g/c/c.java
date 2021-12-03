package e.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import e.g.c.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<a> f1391d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d> f1392e = new SparseArray<>();

    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public d f1393d;

        public a(Context context, XmlPullParser xmlPullParser) {
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
                        this.f1393d = dVar;
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

    public static class b {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f1394d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f1395e = -1;

        /* renamed from: f  reason: collision with root package name */
        public d f1396f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.Variant_constraints) {
                    this.f1395e = obtainStyledAttributes.getResourceId(index, this.f1395e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1395e);
                    context.getResources().getResourceName(this.f1395e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1396f = dVar;
                        dVar.c((ConstraintLayout) LayoutInflater.from(context).inflate(this.f1395e, (ViewGroup) null));
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f1394d = obtainStyledAttributes.getDimension(index, this.f1394d);
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
                return Float.isNaN(this.f1394d) || f3 <= this.f1394d;
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
                char c2 = 1;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 == 2) {
                            a aVar2 = new a(context, xml);
                            this.f1391d.put(aVar2.a, aVar2);
                            aVar = aVar2;
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        } else if (c2 == 4) {
                            a(context, xml);
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0220, code lost:
        continue;
     */
    public final void a(Context context, XmlPullParser xmlPullParser) {
        d.a aVar;
        char c2;
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
                    int eventType = xmlPullParser.getEventType();
                    d.a aVar2 = null;
                    while (eventType != 1) {
                        if (eventType != 0) {
                            char c3 = 2;
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                switch (name.hashCode()) {
                                    case -2025855158:
                                        if (name.equals("Layout")) {
                                            c3 = 6;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case -1984451626:
                                        if (name.equals("Motion")) {
                                            c3 = 7;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case -1962203927:
                                        if (name.equals("ConstraintOverride")) {
                                            c3 = 1;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case -1269513683:
                                        if (name.equals("PropertySet")) {
                                            c3 = 4;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case -1238332596:
                                        if (name.equals("Transform")) {
                                            c3 = 5;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case -71750448:
                                        if (name.equals("Guideline")) {
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 366511058:
                                        if (name.equals("CustomMethod")) {
                                            c3 = '\t';
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 1331510167:
                                        if (name.equals("Barrier")) {
                                            c3 = 3;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 1791837707:
                                        if (name.equals("CustomAttribute")) {
                                            c3 = '\b';
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    case 1803088381:
                                        if (name.equals("Constraint")) {
                                            c3 = 0;
                                            break;
                                        }
                                        c3 = 65535;
                                        break;
                                    default:
                                        c3 = 65535;
                                        break;
                                }
                                switch (c3) {
                                    case 0:
                                        aVar = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                        aVar2 = aVar;
                                        break;
                                    case 1:
                                        aVar = dVar.e(context, Xml.asAttributeSet(xmlPullParser), true);
                                        aVar2 = aVar;
                                        break;
                                    case 2:
                                        aVar = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                        d.b bVar = aVar.f1400d;
                                        bVar.a = true;
                                        bVar.b = true;
                                        aVar2 = aVar;
                                        break;
                                    case 3:
                                        aVar = dVar.e(context, Xml.asAttributeSet(xmlPullParser), false);
                                        aVar.f1400d.h0 = 1;
                                        aVar2 = aVar;
                                        break;
                                    case 4:
                                        if (aVar2 != null) {
                                            aVar2.b.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 5:
                                        if (aVar2 != null) {
                                            aVar2.f1401e.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 6:
                                        if (aVar2 != null) {
                                            aVar2.f1400d.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 7:
                                        if (aVar2 != null) {
                                            aVar2.c.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case '\b':
                                    case '\t':
                                        if (aVar2 != null) {
                                            a.a(context, xmlPullParser, aVar2.f1402f);
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
                                            c2 = 3;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -190376483:
                                        if (lowerCase.equals("constraint")) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 426575017:
                                        if (lowerCase.equals("constraintoverride")) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 2146106725:
                                        if (lowerCase.equals("constraintset")) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                if (c2 == 0) {
                                    this.f1392e.put(identifier, dVar);
                                    return;
                                } else if (c2 == 1 || c2 == 2 || c2 == 3) {
                                    dVar.c.put(Integer.valueOf(aVar2.a), aVar2);
                                    aVar2 = null;
                                }
                            }
                        } else {
                            xmlPullParser.getName();
                        }
                        eventType = xmlPullParser.next();
                    }
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.f1392e.put(identifier, dVar);
                return;
            }
        }
    }
}
