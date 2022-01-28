package com.bugfender.sdk.a.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bugfender.sdk.a.a.b;
import com.bugfender.sdk.a.b.b.a;
import com.bugfender.sdk.a.b.d.g;
import com.bugfender.sdk.a.b.d.h;
import com.bugfender.sdk.a.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a implements Application.ActivityLifecycleCallbacks {
    private static final String g = "UI";
    public final b a;
    private final d b;
    private final boolean c;
    private final boolean d;
    private final Map<String, List<g>> e = new HashMap();
    private com.bugfender.sdk.a.b.b.a f;

    /* access modifiers changed from: package-private */
    /* renamed from: com.bugfender.sdk.a.b.a$a  reason: collision with other inner class name */
    public class C0014a implements a.AbstractC0016a {
        final /* synthetic */ Activity a;

        /* renamed from: com.bugfender.sdk.a.b.a$a$a  reason: collision with other inner class name */
        class RunnableC0015a implements Runnable {
            final /* synthetic */ List a;

            RunnableC0015a(List list) {
                this.a = list;
            }

            public void run() {
                if (this.a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (View view : this.a) {
                        a aVar = a.this;
                        g a2 = h.a(view, aVar.a, aVar.c, a.this.d);
                        if (a2 != null) {
                            a2.a(view);
                            arrayList.add(a2);
                        }
                    }
                    Map map = a.this.e;
                    C0014a aVar2 = C0014a.this;
                    map.put(a.this.b((a) aVar2.a), arrayList);
                }
            }
        }

        C0014a(Activity activity) {
            this.a = activity;
        }

        @Override // com.bugfender.sdk.a.b.b.a.AbstractC0016a
        public void a(List<View> list) {
            a.this.b.a(new RunnableC0015a(list));
        }
    }

    public a(b bVar, d dVar, boolean z, boolean z2) {
        this.a = bVar;
        this.b = dVar;
        this.c = z;
        this.d = z2;
        this.f = new com.bugfender.sdk.a.b.b.a();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        String c2 = c(activity);
        c("Activity created: " + c2);
    }

    public void onActivityDestroyed(Activity activity) {
        String c2 = c(activity);
        c("Activity destroyed: " + c2);
        a(b(activity));
    }

    public void onActivityPaused(Activity activity) {
        String c2 = c(activity);
        c("Activity paused: " + c2);
    }

    public void onActivityResumed(Activity activity) {
        String c2 = c(activity);
        c("Activity resumed: " + c2);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        String c2 = c(activity);
        c("Activity save instance state: " + c2);
    }

    public void onActivityStarted(Activity activity) {
        String c2 = c(activity);
        c("Activity started: " + c2);
        if (!d(activity)) {
            a(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        String c2 = c(activity);
        c("Activity stopped: " + c2);
    }

    private void b(String str) {
        if (this.c) {
            Log.d(g, str);
        }
    }

    private void c(String str) {
        d(str);
        b(str);
    }

    private boolean d(Activity activity) {
        return this.e.containsKey(b(activity));
    }

    private void a(Activity activity) {
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        if (childAt instanceof ViewGroup) {
            this.f.a((ViewGroup) childAt, new C0014a(activity));
        }
    }

    private void d(String str) {
        if (this.d) {
            this.a.a(g, str);
        }
    }

    private String c(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String b(Activity activity) {
        return activity.getClass().getCanonicalName() + "@" + System.identityHashCode(activity);
    }

    private void a(String str) {
        List<g> list = this.e.get(str);
        if (list != null) {
            for (g gVar : list) {
                gVar.a();
            }
            list.clear();
        }
        this.e.remove(str);
    }
}
