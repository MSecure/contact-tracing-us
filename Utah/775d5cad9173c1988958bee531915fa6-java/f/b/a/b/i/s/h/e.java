package f.b.a.b.i.s.h;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final /* synthetic */ class e implements Runnable {
    public final JobInfoSchedulerService b;
    public final JobParameters c;

    public e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.b = jobInfoSchedulerService;
        this.c = jobParameters;
    }

    public void run() {
        JobInfoSchedulerService jobInfoSchedulerService = this.b;
        JobParameters jobParameters = this.c;
        int i2 = JobInfoSchedulerService.b;
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }
}
