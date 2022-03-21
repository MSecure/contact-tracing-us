package e.x.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import android.view.animation.AnimationUtils;
import e.b.a.m;
import e.i.b.b.h;
import e.i.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

public class d {

    public static class a implements TypeEvaluator<c[]> {
        public c[] a;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public c[] evaluate(float f2, c[] cVarArr, c[] cVarArr2) {
            c[] cVarArr3 = cVarArr;
            c[] cVarArr4 = cVarArr2;
            if (m.h.g(cVarArr3, cVarArr4)) {
                if (!m.h.g(this.a, cVarArr3)) {
                    this.a = m.h.Q(cVarArr3);
                }
                for (int i2 = 0; i2 < cVarArr3.length; i2++) {
                    c cVar = this.a[i2];
                    c cVar2 = cVarArr3[i2];
                    c cVar3 = cVarArr4[i2];
                    Objects.requireNonNull(cVar);
                    cVar.a = cVar2.a;
                    int i3 = 0;
                    while (true) {
                        float[] fArr = cVar2.b;
                        if (i3 >= fArr.length) {
                            break;
                        }
                        cVar.b[i3] = (cVar3.b[i3] * f2) + ((1.0f - f2) * fArr[i3]);
                        i3++;
                    }
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v14, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0326  */
    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) {
        int i3;
        PropertyValuesHolder[] propertyValuesHolderArr;
        int i4;
        String str;
        AttributeSet attributeSet2;
        int i5;
        PropertyValuesHolder propertyValuesHolder;
        int size;
        int i6;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i7 = 3;
            boolean z = false;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i8 = 1;
            if (next == 1) {
                break;
            }
            int i9 = 2;
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    e(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
                    valueAnimator = objectAnimator;
                } else if (name.equals("animator")) {
                    valueAnimator = e(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                } else {
                    if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray e2 = h.e(resources2, theme2, attributeSet, a.f1943h);
                        a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, !h.c(xmlPullParser, "ordering") ? 0 : e2.getInt(0, 0), f2);
                        e2.recycle();
                        i3 = depth;
                        valueAnimator = animatorSet2;
                    } else {
                        String str2 = "propertyValuesHolder";
                        if (name.equals(str2)) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                            ArrayList arrayList2 = null;
                            while (true) {
                                int eventType = xmlPullParser.getEventType();
                                if (eventType == i7 || eventType == i8) {
                                    i3 = depth;
                                } else if (eventType != i9) {
                                    xmlPullParser.next();
                                } else {
                                    if (xmlPullParser.getName().equals(str2)) {
                                        TypedArray e3 = h.e(resources2, theme2, asAttributeSet, a.f1944i);
                                        String b = h.b(e3, xmlPullParser, "propertyName", i7);
                                        int i10 = !h.c(xmlPullParser, "valueType") ? 4 : e3.getInt(i9, 4);
                                        int[] iArr = a.f1945j;
                                        ArrayList arrayList3 = null;
                                        attributeSet2 = asAttributeSet;
                                        int i11 = i10;
                                        str = str2;
                                        while (true) {
                                            int next2 = xmlPullParser.next();
                                            if (next2 == i7 || next2 == 1) {
                                                i4 = depth;
                                            } else {
                                                if (xmlPullParser.getName().equals("keyframe")) {
                                                    if (i11 == 4) {
                                                        TypedArray e4 = h.e(resources2, theme2, Xml.asAttributeSet(xmlPullParser), iArr);
                                                        TypedValue peekValue = !h.c(xmlPullParser, "value") ? null : e4.peekValue(0);
                                                        int i12 = (!(peekValue != null) || !d(peekValue.type)) ? 0 : 3;
                                                        e4.recycle();
                                                        i11 = i12;
                                                    }
                                                    TypedArray e5 = h.e(resources2, theme2, Xml.asAttributeSet(xmlPullParser), iArr);
                                                    float f3 = -1.0f;
                                                    if (h.c(xmlPullParser, "fraction")) {
                                                        f3 = e5.getFloat(3, -1.0f);
                                                    }
                                                    TypedValue peekValue2 = !h.c(xmlPullParser, "value") ? null : e5.peekValue(0);
                                                    i6 = depth;
                                                    boolean z2 = peekValue2 != null;
                                                    int i13 = i11 == 4 ? (!z2 || !d(peekValue2.type)) ? 0 : 3 : i11;
                                                    if (!z2) {
                                                        keyframe = i13 == 0 ? Keyframe.ofFloat(f3) : Keyframe.ofInt(f3);
                                                    } else if (i13 == 0) {
                                                        keyframe = Keyframe.ofFloat(f3, !h.c(xmlPullParser, "value") ? 0.0f : e5.getFloat(0, 0.0f));
                                                    } else if (i13 == 1 || i13 == 3) {
                                                        keyframe = Keyframe.ofInt(f3, !h.c(xmlPullParser, "value") ? 0 : e5.getInt(0, 0));
                                                    } else {
                                                        keyframe = null;
                                                    }
                                                    int resourceId = !h.c(xmlPullParser, "interpolator") ? 0 : e5.getResourceId(1, 0);
                                                    if (resourceId > 0) {
                                                        keyframe.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                                    }
                                                    e5.recycle();
                                                    if (keyframe != null) {
                                                        if (arrayList3 == null) {
                                                            arrayList3 = new ArrayList();
                                                        }
                                                        arrayList3.add(keyframe);
                                                    }
                                                    xmlPullParser.next();
                                                } else {
                                                    i6 = depth;
                                                }
                                                i7 = 3;
                                                resources2 = resources;
                                                theme2 = theme;
                                                depth = i6;
                                            }
                                        }
                                        i4 = depth;
                                        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                            i5 = 3;
                                            propertyValuesHolder = null;
                                        } else {
                                            Keyframe keyframe2 = (Keyframe) arrayList3.get(0);
                                            Keyframe keyframe3 = (Keyframe) arrayList3.get(size - 1);
                                            float fraction = keyframe3.getFraction();
                                            if (fraction < 1.0f) {
                                                if (fraction < 0.0f) {
                                                    keyframe3.setFraction(1.0f);
                                                } else {
                                                    arrayList3.add(arrayList3.size(), b(keyframe3, 1.0f));
                                                    size++;
                                                }
                                            }
                                            float fraction2 = keyframe2.getFraction();
                                            if (fraction2 != 0.0f) {
                                                if (fraction2 < 0.0f) {
                                                    keyframe2.setFraction(0.0f);
                                                } else {
                                                    arrayList3.add(0, b(keyframe2, 0.0f));
                                                    size++;
                                                }
                                            }
                                            Keyframe[] keyframeArr = new Keyframe[size];
                                            arrayList3.toArray(keyframeArr);
                                            int i14 = 0;
                                            while (i14 < size) {
                                                Keyframe keyframe4 = keyframeArr[i14];
                                                float f4 = 0.0f;
                                                if (keyframe4.getFraction() < 0.0f) {
                                                    if (i14 != 0) {
                                                        int i15 = size - 1;
                                                        f4 = 1.0f;
                                                        if (i14 != i15) {
                                                            int i16 = i14 + 1;
                                                            int i17 = i14;
                                                            while (i16 < i15 && keyframeArr[i16].getFraction() < 0.0f) {
                                                                i17 = i16;
                                                                i16++;
                                                            }
                                                            float fraction3 = (keyframeArr[i17 + 1].getFraction() - keyframeArr[i14 - 1].getFraction()) / ((float) ((i17 - i14) + 2));
                                                            int i18 = i14;
                                                            while (i18 <= i17) {
                                                                keyframeArr[i18].setFraction(keyframeArr[i18 - 1].getFraction() + fraction3);
                                                                i18++;
                                                                size = size;
                                                            }
                                                        }
                                                    }
                                                    keyframe4.setFraction(f4);
                                                }
                                                i14++;
                                                size = size;
                                            }
                                            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(b, keyframeArr);
                                            i5 = 3;
                                            if (i11 == 3) {
                                                propertyValuesHolder.setEvaluator(e.a);
                                            }
                                        }
                                        if (propertyValuesHolder == null) {
                                            propertyValuesHolder = c(e3, i10, 0, 1, b);
                                        }
                                        if (propertyValuesHolder != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(propertyValuesHolder);
                                        }
                                        e3.recycle();
                                        i7 = i5;
                                        i8 = 1;
                                    } else {
                                        attributeSet2 = asAttributeSet;
                                        str = str2;
                                        i4 = depth;
                                    }
                                    xmlPullParser.next();
                                    i9 = 2;
                                    resources2 = resources;
                                    theme2 = theme;
                                    asAttributeSet = attributeSet2;
                                    str2 = str;
                                    depth = i4;
                                }
                            }
                            i3 = depth;
                            if (arrayList2 != null) {
                                int size2 = arrayList2.size();
                                propertyValuesHolderArr = new PropertyValuesHolder[size2];
                                for (int i19 = 0; i19 < size2; i19++) {
                                    propertyValuesHolderArr[i19] = (PropertyValuesHolder) arrayList2.get(i19);
                                }
                            } else {
                                propertyValuesHolderArr = null;
                            }
                            if (propertyValuesHolderArr != null && (valueAnimator instanceof ValueAnimator)) {
                                valueAnimator.setValues(propertyValuesHolderArr);
                            }
                            z = true;
                        } else {
                            StringBuilder h2 = f.a.a.a.a.h("Unknown animator name: ");
                            h2.append(xmlPullParser.getName());
                            throw new RuntimeException(h2.toString());
                        }
                    }
                    if (animatorSet != null && !z) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAnimator);
                    }
                    resources2 = resources;
                    theme2 = theme;
                    depth = i3;
                }
                i3 = depth;
                if (arrayList == null) {
                }
                arrayList.add(valueAnimator);
                resources2 = resources;
                theme2 = theme;
                depth = i3;
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i20 = 0;
            while (it.hasNext()) {
                animatorArr[i20] = (Animator) it.next();
                i20++;
            }
            if (i2 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return valueAnimator;
    }

    public static Keyframe b(Keyframe keyframe, float f2) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i5 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i6 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((!z || !d(i5)) && (!z2 || !d(i6))) ? 0 : 3;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            c[] H = m.h.H(string);
            c[] H2 = m.h.H(string2);
            if (H == null && H2 == null) {
                return null;
            }
            if (H != null) {
                a aVar = new a();
                if (H2 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, H);
                } else if (m.h.g(H, H2)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, H, H2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder2;
            } else if (H2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new a(), H2);
            }
        } else {
            e eVar = i2 == 3 ? e.a : null;
            if (z3) {
                if (z) {
                    float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    if (z2) {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                }
            } else if (z) {
                int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : d(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else {
                if (z2) {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : d(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                }
                if (propertyValuesHolder3 == null && eVar != null) {
                    propertyValuesHolder3.setEvaluator(eVar);
                    return propertyValuesHolder3;
                }
            }
            propertyValuesHolder3 = propertyValuesHolder;
            return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
        }
    }

    public static boolean d(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) {
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        TypedArray e2 = h.e(resources, theme, attributeSet, a.f1942g);
        TypedArray e3 = h.e(resources, theme, attributeSet, a.f1946k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i2 = 300;
        if (h.c(xmlPullParser, "duration")) {
            i2 = e2.getInt(1, 300);
        }
        long j2 = (long) i2;
        int i3 = 0;
        long j3 = (long) (!h.c(xmlPullParser, "startOffset") ? 0 : e2.getInt(2, 0));
        int i4 = !h.c(xmlPullParser, "valueType") ? 4 : e2.getInt(7, 4);
        if (h.c(xmlPullParser, "valueFrom") && h.c(xmlPullParser, "valueTo")) {
            if (i4 == 4) {
                TypedValue peekValue = e2.peekValue(5);
                boolean z = peekValue != null;
                int i5 = z ? peekValue.type : 0;
                TypedValue peekValue2 = e2.peekValue(6);
                boolean z2 = peekValue2 != null;
                i4 = ((!z || !d(i5)) && (!z2 || !d(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder c = c(e2, i4, 5, 6, "");
            if (c != null) {
                valueAnimator4.setValues(c);
            }
        }
        valueAnimator4.setDuration(j2);
        valueAnimator4.setStartDelay(j3);
        valueAnimator4.setRepeatCount(!h.c(xmlPullParser, "repeatCount") ? 0 : e2.getInt(3, 0));
        valueAnimator4.setRepeatMode(!h.c(xmlPullParser, "repeatMode") ? 1 : e2.getInt(4, 1));
        if (e3 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String b = h.b(e3, xmlPullParser, "pathData", 1);
            if (b != null) {
                String b2 = h.b(e3, xmlPullParser, "propertyXName", 2);
                String b3 = h.b(e3, xmlPullParser, "propertyYName", 3);
                if (b2 == null && b3 == null) {
                    throw new InflateException(e3.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path J = m.h.J(b);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(J, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                do {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(J, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = e2;
                int i6 = 0;
                float f6 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i3 >= min) {
                        break;
                    }
                    pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i6)).floatValue(), fArr3, null);
                    fArr[i3] = fArr3[0];
                    fArr2[i3] = fArr3[1];
                    f6 += f5;
                    int i7 = i6 + 1;
                    if (i7 < arrayList.size() && f6 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i6 = i7;
                    }
                    i3++;
                    min = min;
                }
                PropertyValuesHolder ofFloat = b2 != null ? PropertyValuesHolder.ofFloat(b2, fArr) : null;
                if (b3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(b3, fArr2);
                }
                if (ofFloat == null) {
                    i3 = 0;
                    objectAnimator.setValues(propertyValuesHolder);
                } else {
                    i3 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator.setValues(ofFloat);
                    } else {
                        objectAnimator.setValues(ofFloat, propertyValuesHolder);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = e2;
                objectAnimator.setPropertyName(h.b(e3, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = e2;
        }
        if (!h.c(xmlPullParser, "interpolator")) {
            typedArray2 = typedArray;
        } else {
            typedArray2 = typedArray;
            i3 = typedArray2.getResourceId(i3, i3);
        }
        if (i3 > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i3));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (e3 != null) {
            e3.recycle();
        }
        return valueAnimator3;
    }
}
