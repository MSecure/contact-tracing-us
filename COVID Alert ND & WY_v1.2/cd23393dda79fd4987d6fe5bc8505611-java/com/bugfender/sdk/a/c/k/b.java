package com.bugfender.sdk.a.c.k;

import android.view.View;
import com.bugfender.sdk.a.c.k.a;
import java.util.List;

public class b {
    public static <T> boolean a(View view, a<T> aVar) {
        if (view == null || aVar.b() == a.EnumC0020a.NONE || aVar.b() != a.EnumC0020a.NAME) {
            return false;
        }
        String valueOf = String.valueOf(aVar.a());
        String name = view.getClass().getName();
        String name2 = view.getClass().getSuperclass().getName();
        if (name.equalsIgnoreCase(valueOf) || name2.equalsIgnoreCase(valueOf)) {
            return true;
        }
        return false;
    }

    public static <T> boolean a(View view, List<a<T>> list) {
        for (a<T> aVar : list) {
            if (a(view, aVar)) {
                return true;
            }
        }
        return false;
    }
}
