package e.a0.a.a;

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
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<e.j.c.d[]> {
        public e.j.c.d[] a;

        @Override // android.animation.TypeEvaluator
        public e.j.c.d[] evaluate(float f2, e.j.c.d[] dVarArr, e.j.c.d[] dVarArr2) {
            e.j.c.d[] dVarArr3 = dVarArr;
            e.j.c.d[] dVarArr4 = dVarArr2;
            if (m.e.g(dVarArr3, dVarArr4)) {
                if (!m.e.g(this.a, dVarArr3)) {
                    this.a = m.e.U(dVarArr3);
                }
                for (int i2 = 0; i2 < dVarArr3.length; i2++) {
                    e.j.c.d dVar = this.a[i2];
                    e.j.c.d dVar2 = dVarArr3[i2];
                    e.j.c.d dVar3 = dVarArr4[i2];
                    Objects.requireNonNull(dVar);
                    dVar.a = dVar2.a;
                    int i3 = 0;
                    while (true) {
                        float[] fArr = dVar2.b;
                        if (i3 < fArr.length) {
                            dVar.b[i3] = (dVar3.b[i3] * f2) + ((1.0f - f2) * fArr[i3]);
                            i3++;
                        }
                    }
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x034a, code lost:
        if (r26 == null) goto L_0x0374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x034c, code lost:
        if (r13 == null) goto L_0x0374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x034e, code lost:
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x035d, code lost:
        if (r2.hasNext() == false) goto L_0x036b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x035f, code lost:
        r3 = r3 + 1;
        r1[r3] = (android.animation.Animator) r2.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x036b, code lost:
        if (r27 != 0) goto L_0x0371;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x036d, code lost:
        r26.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0371, code lost:
        r26.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0374, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2, float f2) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        String str;
        AttributeSet attributeSet2;
        PropertyValuesHolder propertyValuesHolder;
        int size;
        int i3;
        Keyframe keyframe;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int depth = xmlPullParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i4 = 3;
            boolean z = false;
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                break;
            }
            int i5 = 1;
            if (next == 1) {
                break;
            }
            int i6 = 2;
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
                    TypedArray c1 = m.e.c1(resources2, theme2, attributeSet, a.f658h);
                    a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, !m.e.F0(xmlPullParser2, "ordering") ? 0 : c1.getInt(0, 0), f2);
                    c1.recycle();
                    valueAnimator = animatorSet2;
                } else {
                    String str2 = "propertyValuesHolder";
                    if (name.equals(str2)) {
                        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                        ArrayList arrayList2 = null;
                        while (true) {
                            int eventType = xmlPullParser.getEventType();
                            if (eventType == i4 || eventType == i5) {
                                break;
                            } else if (eventType != i6) {
                                xmlPullParser.next();
                            } else {
                                if (xmlPullParser.getName().equals(str2)) {
                                    TypedArray c12 = m.e.c1(resources2, theme2, asAttributeSet, a.f659i);
                                    String v0 = m.e.v0(c12, xmlPullParser2, "propertyName", i4);
                                    int i7 = !m.e.F0(xmlPullParser2, "valueType") ? 4 : c12.getInt(i6, 4);
                                    ArrayList arrayList3 = null;
                                    attributeSet2 = asAttributeSet;
                                    int i8 = i7;
                                    while (true) {
                                        int next2 = xmlPullParser.next();
                                        if (next2 == i4 || next2 == 1) {
                                            break;
                                        } else if (xmlPullParser.getName().equals("keyframe")) {
                                            if (i8 == 4) {
                                                TypedArray c13 = m.e.c1(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.f660j);
                                                TypedValue peekValue = !m.e.F0(xmlPullParser2, "value") ? null : c13.peekValue(0);
                                                i8 = (!(peekValue != null) || !d(peekValue.type)) ? 0 : 3;
                                                c13.recycle();
                                            }
                                            TypedArray c14 = m.e.c1(resources2, theme2, Xml.asAttributeSet(xmlPullParser), a.f660j);
                                            float f3 = -1.0f;
                                            if (m.e.F0(xmlPullParser2, "fraction")) {
                                                f3 = c14.getFloat(3, -1.0f);
                                            }
                                            TypedValue peekValue2 = !m.e.F0(xmlPullParser2, "value") ? null : c14.peekValue(0);
                                            boolean z2 = peekValue2 != null;
                                            if (i8 == 4) {
                                                i3 = (!z2 || !d(peekValue2.type)) ? 0 : 3;
                                            } else {
                                                i3 = i8;
                                            }
                                            if (!z2) {
                                                keyframe = i3 == 0 ? Keyframe.ofFloat(f3) : Keyframe.ofInt(f3);
                                            } else if (i3 == 0) {
                                                keyframe = Keyframe.ofFloat(f3, !m.e.F0(xmlPullParser2, "value") ? 0.0f : c14.getFloat(0, 0.0f));
                                            } else if (i3 == 1 || i3 == 3) {
                                                keyframe = Keyframe.ofInt(f3, !m.e.F0(xmlPullParser2, "value") ? 0 : c14.getInt(0, 0));
                                            } else {
                                                keyframe = null;
                                            }
                                            int resourceId = !m.e.F0(xmlPullParser2, "interpolator") ? 0 : c14.getResourceId(1, 0);
                                            if (resourceId > 0) {
                                                keyframe.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
                                            }
                                            c14.recycle();
                                            if (keyframe != null) {
                                                if (arrayList3 == null) {
                                                    arrayList3 = new ArrayList();
                                                }
                                                arrayList3.add(keyframe);
                                            }
                                            xmlPullParser.next();
                                            i4 = 3;
                                            resources2 = resources;
                                            theme2 = theme;
                                            str2 = str2;
                                        } else {
                                            resources2 = resources;
                                            theme2 = theme;
                                            i4 = i4;
                                        }
                                    }
                                    str = str2;
                                    if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
                                        i4 = 3;
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
                                        int i9 = 0;
                                        while (i9 < size) {
                                            Keyframe keyframe4 = keyframeArr[i9];
                                            float f4 = 0.0f;
                                            if (keyframe4.getFraction() < 0.0f) {
                                                if (i9 != 0) {
                                                    int i10 = size - 1;
                                                    f4 = 1.0f;
                                                    if (i9 != i10) {
                                                        int i11 = i9 + 1;
                                                        int i12 = i9;
                                                        while (i11 < i10 && keyframeArr[i11].getFraction() < 0.0f) {
                                                            i11++;
                                                            i12 = i11;
                                                        }
                                                        float fraction3 = (keyframeArr[i12 + 1].getFraction() - keyframeArr[i9 - 1].getFraction()) / ((float) ((i12 - i9) + 2));
                                                        int i13 = i9;
                                                        while (i13 <= i12) {
                                                            keyframeArr[i13].setFraction(keyframeArr[i13 - 1].getFraction() + fraction3);
                                                            i13++;
                                                            size = size;
                                                        }
                                                    }
                                                }
                                                keyframe4.setFraction(f4);
                                            }
                                            i9++;
                                            size = size;
                                        }
                                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(v0, keyframeArr);
                                        i4 = 3;
                                        if (i8 == 3) {
                                            propertyValuesHolder.setEvaluator(e.a);
                                        }
                                    }
                                    if (propertyValuesHolder == null) {
                                        propertyValuesHolder = c(c12, i7, 0, 1, v0);
                                    }
                                    if (propertyValuesHolder != null) {
                                        if (arrayList2 == null) {
                                            arrayList2 = new ArrayList();
                                        }
                                        arrayList2.add(propertyValuesHolder);
                                    }
                                    c12.recycle();
                                    i5 = 1;
                                } else {
                                    attributeSet2 = asAttributeSet;
                                    str = str2;
                                }
                                xmlPullParser.next();
                                i6 = 2;
                                resources2 = resources;
                                theme2 = theme;
                                xmlPullParser2 = xmlPullParser;
                                asAttributeSet = attributeSet2;
                                str2 = str;
                            }
                        }
                        if (arrayList2 != null) {
                            int size2 = arrayList2.size();
                            propertyValuesHolderArr = new PropertyValuesHolder[size2];
                            for (int i14 = 0; i14 < size2; i14++) {
                                propertyValuesHolderArr[i14] = (PropertyValuesHolder) arrayList2.get(i14);
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
                xmlPullParser2 = xmlPullParser;
            }
        }
    }

    public static Keyframe b(Keyframe keyframe, float f2) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f2) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f2) : Keyframe.ofObject(f2);
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder propertyValuesHolder;
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
        PropertyValuesHolder propertyValuesHolder2 = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            e.j.c.d[] L = m.e.L(string);
            e.j.c.d[] L2 = m.e.L(string2);
            if (L == null && L2 == null) {
                return null;
            }
            if (L != null) {
                a aVar = new a();
                if (L2 == null) {
                    propertyValuesHolder = PropertyValuesHolder.ofObject(str, aVar, L);
                } else if (m.e.g(L, L2)) {
                    propertyValuesHolder = PropertyValuesHolder.ofObject(str, aVar, L, L2);
                } else {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                return propertyValuesHolder;
            } else if (L2 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), L2);
            } else {
                return null;
            }
        } else {
            e eVar = i2 == 3 ? e.a : null;
            if (z3) {
                if (z) {
                    float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    if (z2) {
                        propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                    } else {
                        propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                }
            } else if (z) {
                int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                if (z2) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : d(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                } else {
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else {
                if (z2) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : d(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
                }
                if (propertyValuesHolder2 == null && eVar != null) {
                    propertyValuesHolder2.setEvaluator(eVar);
                    return propertyValuesHolder2;
                }
            }
            return propertyValuesHolder2 == null ? propertyValuesHolder2 : propertyValuesHolder2;
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
        TypedArray c1 = m.e.c1(resources, theme, attributeSet, a.f657g);
        TypedArray c12 = m.e.c1(resources, theme, attributeSet, a.f661k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i2 = 300;
        if (m.e.F0(xmlPullParser, "duration")) {
            i2 = c1.getInt(1, 300);
        }
        long j2 = (long) i2;
        int i3 = 0;
        long j3 = (long) (!m.e.F0(xmlPullParser, "startOffset") ? 0 : c1.getInt(2, 0));
        int i4 = !m.e.F0(xmlPullParser, "valueType") ? 4 : c1.getInt(7, 4);
        if (m.e.F0(xmlPullParser, "valueFrom") && m.e.F0(xmlPullParser, "valueTo")) {
            if (i4 == 4) {
                TypedValue peekValue = c1.peekValue(5);
                boolean z = peekValue != null;
                int i5 = z ? peekValue.type : 0;
                TypedValue peekValue2 = c1.peekValue(6);
                boolean z2 = peekValue2 != null;
                i4 = ((!z || !d(i5)) && (!z2 || !d(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder c = c(c1, i4, 5, 6, "");
            if (c != null) {
                valueAnimator4.setValues(c);
            }
        }
        valueAnimator4.setDuration(j2);
        valueAnimator4.setStartDelay(j3);
        valueAnimator4.setRepeatCount(!m.e.F0(xmlPullParser, "repeatCount") ? 0 : c1.getInt(3, 0));
        valueAnimator4.setRepeatMode(!m.e.F0(xmlPullParser, "repeatMode") ? 1 : c1.getInt(4, 1));
        if (c12 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String v0 = m.e.v0(c12, xmlPullParser, "pathData", 1);
            if (v0 != null) {
                String v02 = m.e.v0(c12, xmlPullParser, "propertyXName", 2);
                String v03 = m.e.v0(c12, xmlPullParser, "propertyYName", 3);
                if (v02 == null && v03 == null) {
                    throw new InflateException(c12.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path N = m.e.N(v0);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(N, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                do {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(N, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = c1;
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
                PropertyValuesHolder ofFloat = v02 != null ? PropertyValuesHolder.ofFloat(v02, fArr) : null;
                if (v03 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(v03, fArr2);
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
                typedArray = c1;
                objectAnimator.setPropertyName(m.e.v0(c12, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = c1;
        }
        if (!m.e.F0(xmlPullParser, "interpolator")) {
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
        if (c12 != null) {
            c12.recycle();
        }
        return valueAnimator3;
    }
}
