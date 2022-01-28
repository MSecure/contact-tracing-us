package e.i.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        if (r9.hasValue(r12) != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0109  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int i2;
        int i3;
        int attributeCount;
        int i4;
        int i5;
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            boolean z = true;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr = new int[20][];
            int[] iArr2 = new int[20];
            int i6 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == z || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    int[] iArr3 = new int[i6];
                    int[][] iArr4 = new int[i6][];
                    System.arraycopy(iArr2, 0, iArr3, 0, i6);
                    System.arraycopy(iArr, 0, iArr4, 0, i6);
                } else {
                    if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                        int[] iArr5 = R$styleable.ColorStateListItem;
                        TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr5) : theme.obtainStyledAttributes(attributeSet, iArr5, 0, 0);
                        int i7 = R$styleable.ColorStateListItem_android_color;
                        int resourceId = obtainAttributes.getResourceId(i7, -1);
                        if (resourceId != -1) {
                            ThreadLocal<TypedValue> threadLocal = a;
                            TypedValue typedValue = threadLocal.get();
                            if (typedValue == null) {
                                typedValue = new TypedValue();
                                threadLocal.set(typedValue);
                            }
                            resources.getValue(resourceId, typedValue, z);
                            int i8 = typedValue.type;
                            if (!(i8 >= 28 && i8 <= 31)) {
                                try {
                                    i2 = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                                } catch (Exception unused) {
                                    i7 = R$styleable.ColorStateListItem_android_color;
                                }
                                float f2 = 1.0f;
                                i3 = R$styleable.ColorStateListItem_android_alpha;
                                if (!obtainAttributes.hasValue(i3)) {
                                    i3 = R$styleable.ColorStateListItem_alpha;
                                }
                                f2 = obtainAttributes.getFloat(i3, 1.0f);
                                obtainAttributes.recycle();
                                attributeCount = attributeSet.getAttributeCount();
                                int[] iArr6 = new int[attributeCount];
                                int i9 = 0;
                                for (i4 = 0; i4 < attributeCount; i4++) {
                                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                                    if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R$attr.alpha)) {
                                        int i10 = i9 + 1;
                                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                                            attributeNameResource = -attributeNameResource;
                                        }
                                        iArr6[i9] = attributeNameResource;
                                        i9 = i10;
                                    }
                                }
                                int[] trimStateSet = StateSet.trimStateSet(iArr6, i9);
                                int round = (Math.round(((float) Color.alpha(i2)) * f2) << 24) | (i2 & 16777215);
                                i5 = i6 + 1;
                                int i11 = 8;
                                if (i5 > iArr2.length) {
                                    int[] iArr7 = new int[(i6 <= 4 ? 8 : i6 * 2)];
                                    System.arraycopy(iArr2, 0, iArr7, 0, i6);
                                    iArr2 = iArr7;
                                }
                                iArr2[i6] = round;
                                if (i5 > iArr.length) {
                                    Class<?> componentType = iArr.getClass().getComponentType();
                                    if (i6 > 4) {
                                        i11 = i6 * 2;
                                    }
                                    ?? r9 = (Object[]) Array.newInstance(componentType, i11);
                                    System.arraycopy(iArr, 0, r9, 0, i6);
                                    iArr = r9;
                                }
                                iArr[i6] = trimStateSet;
                                iArr = iArr;
                                i6 = i5;
                            }
                        }
                        i2 = obtainAttributes.getColor(i7, -65281);
                        float f22 = 1.0f;
                        i3 = R$styleable.ColorStateListItem_android_alpha;
                        if (!obtainAttributes.hasValue(i3)) {
                        }
                        f22 = obtainAttributes.getFloat(i3, 1.0f);
                        obtainAttributes.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr62 = new int[attributeCount];
                        int i92 = 0;
                        while (i4 < attributeCount) {
                        }
                        int[] trimStateSet2 = StateSet.trimStateSet(iArr62, i92);
                        int round2 = (Math.round(((float) Color.alpha(i2)) * f22) << 24) | (i2 & 16777215);
                        i5 = i6 + 1;
                        int i112 = 8;
                        if (i5 > iArr2.length) {
                        }
                        iArr2[i6] = round2;
                        if (i5 > iArr.length) {
                        }
                        iArr[i6] = trimStateSet2;
                        iArr = iArr;
                        i6 = i5;
                    }
                    z = true;
                }
            }
            int[] iArr32 = new int[i6];
            int[][] iArr42 = new int[i6][];
            System.arraycopy(iArr2, 0, iArr32, 0, i6);
            System.arraycopy(iArr, 0, iArr42, 0, i6);
            return new ColorStateList(iArr42, iArr32);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }
}
