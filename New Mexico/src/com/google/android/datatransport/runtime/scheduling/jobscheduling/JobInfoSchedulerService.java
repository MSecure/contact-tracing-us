package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.m;
import f.b.a.b.i.s.h.g;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.v.a;
/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int b;

    @Override // android.app.job.JobService
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
            ((b.C0078b) a).b = Base64.decode(string2, 0);
        }
        l lVar = m.a().f2627d;
        lVar.f2648e.execute(new g(lVar, a.a(), i3, new Runnable(this, jobParameters) { // from class: f.b.a.b.i.s.h.e
            public final JobInfoSchedulerService b;
            public final JobParameters c;

            {
                this.b = r1;
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JobInfoSchedulerService jobInfoSchedulerService = this.b;
                JobParameters jobParameters2 = this.c;
                int i4 = JobInfoSchedulerService.b;
                jobInfoSchedulerService.jobFinished(jobParameters2, false);
            }
        }));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
