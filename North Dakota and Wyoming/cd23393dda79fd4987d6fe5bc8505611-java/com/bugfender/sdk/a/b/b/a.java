package com.bugfender.sdk.a.b.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a {
    private final Executor a = Executors.newSingleThreadExecutor();

    /* renamed from: com.bugfender.sdk.a.b.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0016a {
        void a(List<View> list);
    }

    /* access modifiers changed from: private */
    public class b implements Runnable {
        private View a;
        private AbstractC0016a b;

        public b(View view, AbstractC0016a aVar) {
            this.a = view;
            this.b = aVar;
        }

        private List<View> a(View view) {
            if (!(view instanceof ViewGroup) || (view instanceof AdapterView)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(view);
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList2.addAll(a(viewGroup.getChildAt(i)));
            }
            return arrayList2;
        }

        public void run() {
            List<View> a2 = a(this.a);
            AbstractC0016a aVar = this.b;
            if (aVar != null) {
                aVar.a(a2);
            }
            this.b = null;
        }
    }

    public void a(View view, AbstractC0016a aVar) {
        this.a.execute(new b(view, aVar));
    }
}
