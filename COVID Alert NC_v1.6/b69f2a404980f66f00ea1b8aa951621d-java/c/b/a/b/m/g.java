package c.b.a.b.m;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import b.e.h;
import c.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final h<String, h> f3121a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public final h<String, PropertyValuesHolder[]> f3122b = new h<>();

    public static g a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static g b(Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception unused) {
            Integer.toHexString(i);
            return null;
        }
    }

    public static g c(List<Animator> list) {
        g gVar = new g();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                gVar.f3122b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = a.f3109b;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = a.f3110c;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = a.f3111d;
                }
                h hVar = new h(startDelay, duration, interpolator);
                hVar.f3126d = objectAnimator.getRepeatCount();
                hVar.f3127e = objectAnimator.getRepeatMode();
                gVar.f3121a.put(propertyName, hVar);
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return gVar;
    }

    public h d(String str) {
        if (this.f3121a.getOrDefault(str, null) != null) {
            return this.f3121a.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f3121a.equals(((g) obj).f3121a);
    }

    public int hashCode() {
        return this.f3121a.hashCode();
    }

    public String toString() {
        StringBuilder f = a.f('\n');
        f.append(g.class.getName());
        f.append('{');
        f.append(Integer.toHexString(System.identityHashCode(this)));
        f.append(" timings: ");
        f.append(this.f3121a);
        f.append("}\n");
        return f.toString();
    }
}
