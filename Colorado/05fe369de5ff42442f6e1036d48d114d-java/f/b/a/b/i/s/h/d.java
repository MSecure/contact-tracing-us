package f.b.a.b.i.s.h;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import e.b.a.m;
import f.b.a.b.i.i;
import f.b.a.b.i.s.h.f;
import f.b.a.b.i.s.i.c;
import f.b.a.b.i.v.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;

public class d implements r {
    public final Context a;
    public final c b;
    public final f c;

    public d(Context context, c cVar, f fVar) {
        this.a = context;
        this.b = cVar;
        this.c = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0092, code lost:
        r7 = false;
     */
    @Override // f.b.a.b.i.s.h.r
    public void a(i iVar, int i2) {
        boolean z;
        boolean z2;
        char c2;
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(iVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(iVar.d())).array());
        if (iVar.c() != null) {
            adler32.update(iVar.c());
        }
        int value = (int) adler32.getValue();
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i3 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == value) {
                if (i3 >= i2) {
                    z = true;
                }
            }
        }
        if (z) {
            m.h.P("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
            return;
        }
        long k2 = this.b.k(iVar);
        f fVar = this.c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        f.b.a.b.d d2 = iVar.d();
        builder.setMinimumLatency(fVar.b(d2, k2, i2));
        Set<f.b> c3 = fVar.c().get(d2).c();
        if (c3.contains(f.b.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
            z2 = true;
        } else {
            z2 = true;
            builder.setRequiredNetworkType(1);
        }
        if (c3.contains(f.b.DEVICE_CHARGING)) {
            builder.setRequiresCharging(z2);
        }
        if (c3.contains(f.b.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(z2);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", iVar.b());
        persistableBundle.putInt("priority", a.a(iVar.d()));
        if (iVar.c() != null) {
            c2 = 0;
            persistableBundle.putString("extras", Base64.encodeToString(iVar.c(), 0));
        } else {
            c2 = 0;
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = new Object[5];
        objArr[c2] = iVar;
        objArr[1] = Integer.valueOf(value);
        objArr[2] = Long.valueOf(this.c.b(iVar.d(), k2, i2));
        objArr[3] = Long.valueOf(k2);
        objArr[4] = Integer.valueOf(i2);
        m.h.s0("JobInfoScheduler");
        String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(builder.build());
    }
}
