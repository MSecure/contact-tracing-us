package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayoutStates {
    public final ConstraintLayout mConstraintLayout;
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    public SparseArray<State> mStateList = new SparseArray<>();

    public static class State {
        public int mConstraintID = -1;
        public ConstraintSet mConstraintSet;
        public int mId;
        public ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static class Variant {
        public int mConstraintID = -1;
        public ConstraintSet mConstraintSet;
        public float mMaxHeight = Float.NaN;
        public float mMaxWidth = Float.NaN;
        public float mMinHeight = Float.NaN;
        public float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        this.mConstraintLayout = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            State state = null;
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
                            State state2 = new State(context, xml);
                            this.mStateList.put(state2.mId, state2);
                            state = state2;
                        } else if (c == 3) {
                            Variant variant = new Variant(context, xml);
                            if (state != null) {
                                state.mVariants.add(variant);
                            }
                        } else if (c == 4) {
                            parseConstraintSet(context, xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d2, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d0, code lost:
        if (r1.equals("PropertySet") != false) goto L_0x00e8;
     */
    public final void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if ("id".equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                int identifier = attributeValue.contains(ColorPropConverter.PATH_DELIMITER) ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    int eventType = xmlPullParser.getEventType();
                    ConstraintSet.Constraint constraint2 = null;
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
                                        constraint = constraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        constraint2 = constraint;
                                        break;
                                    case 1:
                                        constraint = constraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        constraint.layout.mIsGuideline = true;
                                        constraint.layout.mApply = true;
                                        constraint2 = constraint;
                                        break;
                                    case 2:
                                        constraint = constraintSet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        constraint.layout.mHelperType = 1;
                                        constraint2 = constraint;
                                        break;
                                    case 3:
                                        if (constraint2 != null) {
                                            constraint2.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 4:
                                        if (constraint2 != null) {
                                            constraint2.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 5:
                                        if (constraint2 != null) {
                                            constraint2.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 6:
                                        if (constraint2 != null) {
                                            constraint2.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                            break;
                                        } else {
                                            throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                        }
                                    case 7:
                                        if (constraint2 != null) {
                                            ConstraintAttribute.parse(context, xmlPullParser, constraint2.mCustomConstraints);
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
                                    this.mConstraintSetMap.put(identifier, constraintSet);
                                    return;
                                } else if (name2.equalsIgnoreCase("Constraint")) {
                                    constraintSet.mConstraints.put(Integer.valueOf(constraint2.mViewId), constraint2);
                                    constraint2 = null;
                                }
                            }
                        } else {
                            xmlPullParser.getName();
                        }
                        eventType = xmlPullParser.next();
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.mConstraintSetMap.put(identifier, constraintSet);
                return;
            }
        }
    }
}
