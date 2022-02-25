package e.m.a;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import e.e.h;
import e.i.i.k;
import e.i.i.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class u0 {

    public class a implements Runnable {
        public final /* synthetic */ int b;
        public final /* synthetic */ ArrayList c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1688d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1689e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1690f;

        public a(u0 u0Var, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.b = i2;
            this.c = arrayList;
            this.f1688d = arrayList2;
            this.f1689e = arrayList3;
            this.f1690f = arrayList4;
        }

        public void run() {
            for (int i2 = 0; i2 < this.b; i2++) {
                AtomicInteger atomicInteger = l.a;
                ((View) this.c.get(i2)).setTransitionName((String) this.f1688d.get(i2));
                ((View) this.f1689e.get(i2)).setTransitionName((String) this.f1690f.get(i2));
            }
        }
    }

    public static void d(List<View> list, View view) {
        int size = list.size();
        if (!h(list, view, size)) {
            list.add(view);
            for (int i2 = size; i2 < list.size(); i2++) {
                View view2 = list.get(i2);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (!h(list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static boolean h(List<View> list, View view, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (list.get(i3) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.ArrayList<android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    public void f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z = view instanceof ViewGroup;
            ViewGroup viewGroup = view;
            if (z) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                boolean isTransitionGroup = viewGroup2.isTransitionGroup();
                viewGroup = viewGroup2;
                if (!isTransitionGroup) {
                    int childCount = viewGroup2.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        f(arrayList, viewGroup2.getChildAt(i2));
                    }
                    return;
                }
            }
            arrayList.add(viewGroup == 1 ? 1 : 0);
        }
    }

    public abstract Object g(Object obj);

    public void i(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            AtomicInteger atomicInteger = l.a;
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    i(map, viewGroup.getChildAt(i2));
                }
            }
        }
    }

    public void j(View view, Rect rect) {
        AtomicInteger atomicInteger = l.a;
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object l(Object obj, Object obj2, Object obj3);

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public ArrayList<String> n(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            AtomicInteger atomicInteger = l.a;
            arrayList2.add(view.getTransitionName());
            view.setTransitionName(null);
        }
        return arrayList2;
    }

    public abstract void o(Object obj, View view);

    public abstract void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void q(Object obj, View view, ArrayList<View> arrayList);

    public abstract void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void s(Object obj, Rect rect);

    public abstract void t(Object obj, View view);

    public void u(l lVar, Object obj, e.i.e.a aVar, Runnable runnable) {
        runnable.run();
    }

    public void v(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = arrayList.get(i2);
            AtomicInteger atomicInteger = l.a;
            String transitionName = view2.getTransitionName();
            arrayList4.add(transitionName);
            if (transitionName != null) {
                view2.setTransitionName(null);
                String str = (String) ((h) map).getOrDefault(transitionName, null);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i3))) {
                        arrayList2.get(i3).setTransitionName(transitionName);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        k.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void w(Object obj, View view, ArrayList<View> arrayList);

    public abstract void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object y(Object obj);
}
