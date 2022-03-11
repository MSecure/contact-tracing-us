package e.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import e.g.c.d;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    public SparseArray<a> a = new SparseArray<>();
    public SparseArray<d> b = new SparseArray<>();

    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c = -1;

        /* renamed from: d  reason: collision with root package name */
        public d f1359d;

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
                        this.f1359d = dVar;
                        dVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class b {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public float c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f1360d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f1361e = -1;

        /* renamed from: f  reason: collision with root package name */
        public d f1362f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.Variant_constraints) {
                    this.f1361e = obtainStyledAttributes.getResourceId(index, this.f1361e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1361e);
                    context.getResources().getResourceName(this.f1361e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f1362f = dVar;
                        dVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f1361e, (ViewGroup) null));
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f1360d = obtainStyledAttributes.getDimension(index, this.f1360d);
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
    }

    public c(Context context, ConstraintLayout constraintLayout, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c == 0 || c == 1)) {
                        if (c == 2) {
                            aVar = new a(context, xml);
                            this.a.put(aVar.a, aVar);
                        } else if (c == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                            }
                        } else if (c == 4) {
                            a(context, xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d0, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d0, code lost:
        if (r1.equals("PropertySet") != false) goto L_0x00e8;
     */
    public final void a(Context context, XmlPullParser xmlPullParser) {
        d.a aVar;
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            if ("id".equals(xmlPullParser.getAttributeName(i2))) {
                String attributeValue = xmlPullParser.getAttributeValue(i2);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    int eventType = xmlPullParser.getEventType();
                    d.a aVar2 = null;
                    while (eventType != 1) {
                        if (eventType != 0) {
                            char c = 3;
                            if (eventType == 2) {
                                String name = xmlPullParser.getName();
                                switch (name.hashCode()) {
                                    case -2025855158:
                                        if (name.equals("Layout")) {
                                            c = 5;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1984451626:
                                        if (name.equals("Motion")) {
                                            c = 6;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -1269513683:
                                        break;
                                    case -1238332596:
                                        if (name.equals("Transform")) {
                                            c = 4;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case -71750448:
                                        if (name.equals("Guideline")) {
                                            c = 1;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1331510167:
                                        if (name.equals("Barrier")) {
                                            c = 2;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1791837707:
                                        if (name.equals("CustomAttribute")) {
                                            c = 7;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    case 1803088381:
                                        if (name.equals("Constraint")) {
                                            c = 0;
                                            break;
                                        }
                                        c = 65535;
                                        break;
                                    default:
                                        c = 65535;
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        aVar = dVar.d(context, Xml.asAttributeSet(xmlPullParser));
                                        aVar2 = aVar;
                                        break;
                                    case 1:
                                        aVar = dVar.d(context, Xml.asAttributeSet(xmlPullParser));
                                        d.b bVar = aVar.f1365d;
                                        bVar.a = true;
                                        bVar.b = true;
                                        aVar2 = aVar;
                                        break;
                                    case 2:
                                        aVar = dVar.d(context, Xml.asAttributeSet(xmlPullParser));
                                        aVar.f1365d.d0 = 1;
                                        aVar2 = aVar;
                                        break;
                                    case 3:
                                        if (aVar2 != null) {
                                            aVar2.b.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 4:
                                        if (aVar2 != null) {
                                            aVar2.f1366e.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 5:
                                        if (aVar2 != null) {
                                            aVar2.f1365d.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 6:
                                        if (aVar2 != null) {
                                            aVar2.c.a(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 7:
                                        if (aVar2 != null) {
                                            a.a(context, xmlPullParser, aVar2.f1367f);
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                }
                            } else if (eventType != 3) {
                                continue;
                            } else {
                                String name2 = xmlPullParser.getName();
                                if ("ConstraintSet".equals(name2)) {
                                    this.b.put(identifier, dVar);
                                    return;
                                } else if (name2.equalsIgnoreCase("Constraint")) {
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
                this.b.put(identifier, dVar);
                return;
            }
        }
    }
}
