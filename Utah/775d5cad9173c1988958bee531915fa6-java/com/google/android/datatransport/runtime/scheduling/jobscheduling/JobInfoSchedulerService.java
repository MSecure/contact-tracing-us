package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.m;
import f.b.a.b.i.s.h.e;
import f.b.a.b.i.s.h.g;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.v.a;

public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int b = 0;

    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i2 = jobParameters.getExtras().getInt("priority");
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        m.b(getApplicationContext());
        i.a a = i.a();
        a.b(string);
        a.c(a.b(i2));
        if (string2 != null) {
            ((b.C0076b) a).b = Base64.decode(string2, 0);
        }
        l lVar = m.a().f2586d;
        lVar.f2607e.execute(new g(lVar, a.a(), i3, new e(this, jobParameters)));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
