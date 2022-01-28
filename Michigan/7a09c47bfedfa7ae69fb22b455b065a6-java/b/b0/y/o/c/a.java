package b.b0.y.o.c;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import b.b0.m;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f1158b = m.e("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f1159a;

    public a(Context context) {
        this.f1159a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
