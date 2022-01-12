package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {
    public boolean mBooleanValue;
    public int mColorValue;
    public float mFloatValue;
    public int mIntegerValue;
    public String mName;
    public String mStringValue;
    public AttributeType mType;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        this.mName = str;
        this.mType = attributeType;
        setValue(obj);
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        Object obj;
        AttributeType attributeType;
        AttributeType attributeType2 = AttributeType.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        AttributeType attributeType3 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R$styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R$styleable.CustomAttribute_customBoolean) {
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType3 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R$styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R$styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else {
                    if (index == R$styleable.CustomAttribute_customPixelDimension) {
                        obj2 = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER), context.getResources().getDisplayMetrics()));
                    } else if (index == R$styleable.CustomAttribute_customDimension) {
                        obj2 = Float.valueOf(obtainStyledAttributes.getDimension(index, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
                    } else if (index == R$styleable.CustomAttribute_customFloatValue) {
                        attributeType = AttributeType.FLOAT_TYPE;
                        obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == R$styleable.CustomAttribute_customIntegerValue) {
                        attributeType = AttributeType.INT_TYPE;
                        obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                    } else if (index == R$styleable.CustomAttribute_customStringValue) {
                        attributeType = AttributeType.STRING_TYPE;
                        obj = obtainStyledAttributes.getString(index);
                    }
                    attributeType3 = attributeType2;
                }
                attributeType3 = attributeType;
                obj2 = obj;
            }
        }
        if (!(str == null || obj2 == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType3, obj2));
        }
        obtainStyledAttributes.recycle();
    }

    public void setValue(Object obj) {
        switch (this.mType.ordinal()) {
            case 0:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 1:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.mColorValue = ((Integer) obj).intValue();
                return;
            case 4:
                this.mStringValue = (String) obj;
                return;
            case 5:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }
}
