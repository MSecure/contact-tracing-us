package b.z.y.o.c;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import b.z.m;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2021b = m.e("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f2022a;

    public a(Context context) {
        this.f2022a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
