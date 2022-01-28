package e.z.a.a;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

public class d {

    public static class a implements TypeEvaluator<e.i.c.d[]> {
        public e.i.c.d[] a;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public e.i.c.d[] evaluate(float f2, e.i.c.d[] dVarArr, e.i.c.d[] dVarArr2) {
            e.i.c.d[] dVarArr3 = dVarArr;
            e.i.c.d[] dVarArr4 = dVarArr2;
            if (m.e.g(dVarArr3, dVarArr4)) {
                if (!m.e.g(this.a, dVarArr3)) {
                    this.a = m.e.T(dVarArr3);
                }
                for (int i2 = 0; i2 < dVarArr3.length; i2++) {
                    e.i.c.d dVar = this.a[i2];
                    e.i.c.d dVar2 = dVarArr3[i2];
                    e.i.c.d dVar3 = dVarArr4[i2];
                    Objects.requireNonNull(dVar);
                    dVar.a = dVar2.a;
                    int i3 = 0;
                    while (true) {
                        float[] fArr = dVar2.b;
                        if (i3 >= fArr.length) {
                            break;
                        }
                        dVar.b[i3] = (dVar3.b[i3] * f2) + ((1.0f - f2) * fArr[i3]);
                        i3++;
                    }
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v16, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x030f  */
    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        String str;
        AttributeSet attributeSet2;
        PropertyValuesHolder propertyValuesHolder;
        int size;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i3 = 3;
            boolean z = false;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i4 = 1;
            if (next == 1) {
                break;
            }
            int i5 = 2;
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    e(context, resources, theme, attributeSet, objectAnimator, f2, xmlPullParser);
                    valueAnimator = objectAnimator;
                } else if (name.equals("animator")) {
                    valueAnimator = e(context, resources, theme, attributeSet, null, f2, xmlPullParser);
                } else if (name.equals("set")) {
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    TypedArray W0 = m.e.W0(resources2, theme2, attributeSet, a.f2069h);
                    a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, !m.e.D0(xmlPullParser2, "ordering") ? 0 : W0.getInt(0, 0), f2);
                    W0.recycle();
                    valueAnimator = animatorSet2;
                } else {
                    String str2 = "propertyValuesHolder";
                    if (name.equals(str2)) {
                        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                        ArrayList arrayList2 = null;
                        while (true) {
                            int eventType = xmlPullParser.getEventType();
                            if (eventType == i3 || eventType == i4) {
                                if (arrayList2 == null) {
                                    int size2 = arrayList2.size();
                                    propertyValuesHolderArr = new PropertyValuesHolder[size2];
                                    for (int i6 = 0; i6 < size2; i6++) {
                                        propertyValuesHolderArr[i6] = (PropertyValuesHolder) arrayList2.get(i6);
                                    }
                                } else {
                                    propertyValuesHolderArr = null;
                                }
                            } else if (eventType != i5) {
                                xmlPullParser.next();
                            } else {
                                if (xmlPullParser.getName().equals(str2)) {
                                    TypedArray W02 = m.e.W0(resources2, theme2, asAttributeSet, a.f2070i);
                                    String t0 = m.e.t0(W02, xmlPullParser2, "propertyName", i3);
                                    int i7 = !m.e.D0(xmlPullParser2, "valueType") ? 4 : W02.getInt(i5, 4);
                                    ArrayList arrayList3 = null;
                                    attributeSet2 = asAttributeSet;
                                    int i8 = i7;
                                    while (true) {
                                        int next2 = xmlPullParser.next();
                                        if (next2 == i3 || next2 == 1) {
                                            str = str2;
                                        } else if (xmlPullParser.getName().equals("keyframe")) {
                                            if (i8 == 4) {
                                                TypedArray W03 = m.e.W0(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.f2071j);
                                                TypedValue peekValue = !m.e.D0(xmlPullParser2, "value") ? null : W03.peekValue(0);
                                                i8 = (!(peekValue != null) || !d(peekValue.type)) ? 0 : 3;
                                                W03.recycle();
                                            }
                                            TypedArray W04 = m.e.W0(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.f2071j);
                                            float f3 = -1.0f;
                                            if (m.e.D0(xmlPullParser2, "fraction")) {
                                                f3 = W04.getFloat(3, -1.0f);
                                            }
                                            TypedValue peekValue2 = !m.e.D0(xmlPullParser2, "value") ? null : W04.peekValue(0);
                                            boolean z2 = peekValue2 != null;
                                            int i9 = i8 == 4 ? (!z2 || !d(peekValue2.type)) ? 0 : 3 : i8;
                                            if (!z2) {
                                                keyframe = i9 == 0 ? Keyframe.ofFloat(f3) : Keyframe.ofInt(f3);
                                            } else if (i9 == 0) {
                                                keyframe = Keyframe.ofFloat(f3, !m.e.D0(xmlPullParser2, "value") ? 0.0f : W04.getFloat(0, 0.0f));
                                            } else if (i9 == 1 || i9 == 3) {
                                                keyframe = Keyframe.ofInt(f3, !m.e.D0(xmlPullParser2, "value") ? 0 : W04.getInt(0, 0));
                                            } else {
                                                keyframe = null;
                                            }
                                            int resourceId = !m.e.D0(xmlPullParser2, "interpolator") ? 0 : W04.getResourceId(1, 0);
                                            if (resourceId > 0) {
                                                keyframe.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                            }
                                            W04.recycle();
                                            if (keyframe != null) {
                                                if (arrayList3 == null) {
                                                    arrayList3 = new ArrayList();
                                                }
                                                arrayList3.add(keyframe);
                                            }
                                            xmlPullParser.next();
                                            i3 = 3;
                                            resources2 = resources;
                                            theme2 = theme;
                                            str2 = str2;
                                        } else {
                                            resources2 = resources;
                                            theme2 = theme;
                                            i3 = i3;
                                        }
                                    }
                                    str = str2;
                                    if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                        i3 = 3;
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
                                        int i10 = 0;
                                        while (i10 < size) {
                                            Keyframe keyframe4 = keyframeArr[i10];
                                            float f4 = 0.0f;
                                            if (keyframe4.getFraction() < 0.0f) {
                                                if (i10 != 0) {
                                                    int i11 = size - 1;
                                                    f4 = 1.0f;
                                                    if (i10 != i11) {
                                                        int i12 = i10 + 1;
                                                        int i13 = i10;
                                                        while (i12 < i11 && keyframeArr[i12].getFraction() < 0.0f) {
                                                            i13 = i12;
                                                            i12++;
                                                        }
                                                        float fraction3 = (keyframeArr[i13 + 1].getFraction() - keyframeArr[i10 - 1].getFraction()) / ((float) ((i13 - i10) + 2));
                                                        int i14 = i10;
                                                        while (i14 <= i13) {
                                                            keyframeArr[i14].setFraction(keyframeArr[i14 - 1].getFraction() + fraction3);
                                                            i14++;
                                                            size = size;
                                                        }
                                                    }
                                                }
                                                keyframe4.setFraction(f4);
                                            }
                                            i10++;
                                            size = size;
                                        }
                                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(t0, keyframeArr);
                                        i3 = 3;
                                        if (i8 == 3) {
                                            propertyValuesHolder.setEvaluator(e.a);
                                        }
                                    }
                                    if (propertyValuesHolder == null) {
                                        propertyValuesHolder = c(W02, i7, 0, 1, t0);
                                    }
                                    if (propertyValuesHolder != null) {
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        arrayList2.add(propertyValuesHolder);
                                    }
                                    W02.recycle();
                                    i4 = 1;
                                } else {
                                    attributeSet2 = asAttributeSet;
                                    str = str2;
                                }
                                xmlPullParser.next();
                                i5 = 2;
                                resources2 = resources;
                                theme2 = theme;
                                xmlPullParser2 = xmlPullParser;
                                asAttributeSet = attributeSet2;
                                str2 = str;
                            }
                        }
                        if (arrayList2 == null) {
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
                xmlPullParser2 = xmlPullParser;
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i15 = 0;
            while (it.hasNext()) {
                animatorArr[i15] = (Animator) it.next();
                i15++;
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
            e.i.c.d[] K = m.e.K(string);
            e.i.c.d[] K2 = m.e.K(string2);
            if (K == null && K2 == null) {
                return null;
            }
            if (K != null) {
                a aVar = new a();
                if (K2 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, K);
                } else if (m.e.g(K, K2)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, aVar, K, K2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder2;
            } else if (K2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new a(), K2);
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
        TypedArray W0 = m.e.W0(resources, theme, attributeSet, a.f2068g);
        TypedArray W02 = m.e.W0(resources, theme, attributeSet, a.f2072k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i2 = 300;
        if (m.e.D0(xmlPullParser, "duration")) {
            i2 = W0.getInt(1, 300);
        }
        long j2 = (long) i2;
        int i3 = 0;
        long j3 = (long) (!m.e.D0(xmlPullParser, "startOffset") ? 0 : W0.getInt(2, 0));
        int i4 = !m.e.D0(xmlPullParser, "valueType") ? 4 : W0.getInt(7, 4);
        if (m.e.D0(xmlPullParser, "valueFrom") && m.e.D0(xmlPullParser, "valueTo")) {
            if (i4 == 4) {
                TypedValue peekValue = W0.peekValue(5);
                boolean z = peekValue != null;
                int i5 = z ? peekValue.type : 0;
                TypedValue peekValue2 = W0.peekValue(6);
                boolean z2 = peekValue2 != null;
                i4 = ((!z || !d(i5)) && (!z2 || !d(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder c = c(W0, i4, 5, 6, "");
            if (c != null) {
                valueAnimator4.setValues(c);
            }
        }
        valueAnimator4.setDuration(j2);
        valueAnimator4.setStartDelay(j3);
        valueAnimator4.setRepeatCount(!m.e.D0(xmlPullParser, "repeatCount") ? 0 : W0.getInt(3, 0));
        valueAnimator4.setRepeatMode(!m.e.D0(xmlPullParser, "repeatMode") ? 1 : W0.getInt(4, 1));
        if (W02 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String t0 = m.e.t0(W02, xmlPullParser, "pathData", 1);
            if (t0 != null) {
                String t02 = m.e.t0(W02, xmlPullParser, "propertyXName", 2);
                String t03 = m.e.t0(W02, xmlPullParser, "propertyYName", 3);
                if (t02 == null && t03 == null) {
                    throw new InflateException(W02.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path M = m.e.M(t0);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(M, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                do {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(M, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = W0;
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
                PropertyValuesHolder ofFloat = t02 != null ? PropertyValuesHolder.ofFloat(t02, fArr) : null;
                if (t03 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(t03, fArr2);
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
                typedArray = W0;
                objectAnimator.setPropertyName(m.e.t0(W02, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = W0;
        }
        if (!m.e.D0(xmlPullParser, "interpolator")) {
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
        if (W02 != null) {
            W02.recycle();
        }
        return valueAnimator3;
    }
}
