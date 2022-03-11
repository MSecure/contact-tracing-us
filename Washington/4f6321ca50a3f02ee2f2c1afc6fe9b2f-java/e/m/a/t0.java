package e.m.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class t0 extends u0 {

    public class a extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public a(t0 t0Var, Rect rect) {
            this.a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.a;
        }
    }

    public class b implements Transition.TransitionListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ArrayList b;

        public b(t0 t0Var, View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.b.get(i2)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    public class c implements Transition.TransitionListener {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ Object c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1684d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f1685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1686f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.f1684d = arrayList2;
            this.f1685e = obj3;
            this.f1686f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.a;
            if (obj != null) {
                t0.this.p(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                t0.this.p(obj2, this.f1684d, null);
            }
            Object obj3 = this.f1685e;
            if (obj3 != null) {
                t0.this.p(obj3, this.f1686f, null);
            }
        }
    }

    public class d implements Transition.TransitionListener {
        public final /* synthetic */ Runnable a;

        public d(t0 t0Var, Runnable runnable) {
            this.a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public class e extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public e(t0 t0Var, Rect rect) {
            this.a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    public static boolean z(Transition transition) {
        return !u0.k(transition.getTargetIds()) || !u0.k(transition.getTargetNames()) || !u0.k(transition.getTargetTypes());
    }

    @Override // e.m.a.u0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // e.m.a.u0
    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i2 < transitionCount) {
                    b(transitionSet.getTransitionAt(i2), arrayList);
                    i2++;
                }
            } else if (!z(transition) && u0.k(transition.getTargets())) {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.addTarget(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    @Override // e.m.a.u0
    public void c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // e.m.a.u0
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // e.m.a.u0
    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // e.m.a.u0
    public Object l(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    @Override // e.m.a.u0
    public Object m(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // e.m.a.u0
    public void o(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // e.m.a.u0
    public void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i2 < transitionCount) {
                p(transitionSet.getTransitionAt(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!z(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i2 < size) {
                transition.addTarget(arrayList2.get(i2));
                i2++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // e.m.a.u0
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(this, view, arrayList));
    }

    @Override // e.m.a.u0
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // e.m.a.u0
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(this, rect));
        }
    }

    @Override // e.m.a.u0
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(this, rect));
        }
    }

    @Override // e.m.a.u0
    public void u(l lVar, Object obj, e.i.e.a aVar, Runnable runnable) {
        ((Transition) obj).addListener(new d(this, runnable));
    }

    @Override // e.m.a.u0
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            u0.d(targets, arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // e.m.a.u0
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            p(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // e.m.a.u0
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }
}
