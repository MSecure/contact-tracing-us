package e.c0.a0.p.c;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;
import e.c0.n;
/* loaded from: classes.dex */
public class a {
    public static final String b = n.e("SystemJobInfoConverter");
    public final ComponentName a;

    public a(Context context) {
        this.a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
