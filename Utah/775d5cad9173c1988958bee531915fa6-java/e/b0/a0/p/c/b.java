package e.b0.a0.p.c;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import e.b.a.m;
import e.b0.a;
import e.b0.a0.e;
import e.b0.a0.l;
import e.b0.a0.s.g;
import e.b0.a0.s.i;
import e.b0.a0.s.o;
import e.b0.a0.s.q;
import e.b0.a0.t.f;
import e.b0.c;
import e.b0.d;
import e.b0.e;
import e.b0.n;
import e.b0.r;
import e.b0.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class b implements e {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1079f = n.e("SystemJobScheduler");
    public final Context b;
    public final JobScheduler c;

    /* renamed from: d  reason: collision with root package name */
    public final l f1080d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1081e;

    public b(Context context, l lVar) {
        a aVar = new a(context);
        this.b = context;
        this.f1080d = lVar;
        this.c = (JobScheduler) context.getSystemService("jobscheduler");
        this.f1081e = aVar;
    }

    public static void a(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            n.c().b(f1079f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
        }
    }

    public static List<Integer> c(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> e2 = e(context, jobScheduler);
        if (e2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : e2) {
            if (str.equals(g(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> e(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            n.c().b(f1079f, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static String g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // e.b0.a0.e
    public void b(String str) {
        List<Integer> c2 = c(this.b, this.c, str);
        if (!(c2 == null || c2.isEmpty())) {
            for (Integer num : c2) {
                a(this.c, num.intValue());
            }
            ((i) this.f1080d.c.o()).c(str);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.a0.e
    public void d(o... oVarArr) {
        int i2;
        List<Integer> c2;
        int i3;
        WorkDatabase workDatabase = this.f1080d.c;
        f fVar = new f(workDatabase);
        for (o oVar : oVarArr) {
            workDatabase.c();
            try {
                o i4 = ((q) workDatabase.r()).i(oVar.a);
                if (i4 == null) {
                    n.c().f(f1079f, "Skipping scheduling " + oVar.a + " because it's no longer in the DB", new Throwable[0]);
                } else if (i4.b != v.ENQUEUED) {
                    n.c().f(f1079f, "Skipping scheduling " + oVar.a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    g a = ((i) workDatabase.o()).a(oVar.a);
                    if (a != null) {
                        i2 = a.b;
                    } else {
                        Objects.requireNonNull(this.f1080d.b);
                        i2 = fVar.b(0, this.f1080d.b.f1159g);
                    }
                    if (a == null) {
                        ((i) this.f1080d.c.o()).b(new g(oVar.a, i2));
                    }
                    h(oVar, i2);
                    if (Build.VERSION.SDK_INT == 23 && (c2 = c(this.b, this.c, oVar.a)) != null) {
                        int indexOf = c2.indexOf(Integer.valueOf(i2));
                        if (indexOf >= 0) {
                            c2.remove(indexOf);
                        }
                        if (!c2.isEmpty()) {
                            i3 = c2.get(0).intValue();
                        } else {
                            Objects.requireNonNull(this.f1080d.b);
                            i3 = fVar.b(0, this.f1080d.b.f1159g);
                        }
                        h(oVar, i3);
                    }
                }
                workDatabase.l();
                workDatabase.g();
            } catch (Throwable th) {
                workDatabase.g();
                throw th;
            }
        }
    }

    @Override // e.b0.a0.e
    public boolean f() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0070, code lost:
        if (r5 < 26) goto L_0x0077;
     */
    public void h(o oVar, int i2) {
        char c2;
        int i3;
        a aVar = this.f1081e;
        Objects.requireNonNull(aVar);
        d dVar = oVar.f1118j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", oVar.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", oVar.c());
        JobInfo.Builder extras = new JobInfo.Builder(i2, aVar.a).setRequiresCharging(dVar.b).setRequiresDeviceIdle(dVar.c).setExtras(persistableBundle);
        e.b0.o oVar2 = dVar.a;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 30 || oVar2 != e.b0.o.TEMPORARILY_UNMETERED) {
            int ordinal = oVar2.ordinal();
            int i5 = 4;
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal == 4) {
                            }
                        } else if (i4 >= 24) {
                            i5 = 3;
                        }
                        n.c().a(a.b, String.format("API version too low. Cannot convert network type value %s", oVar2), new Throwable[0]);
                    } else {
                        i5 = 2;
                    }
                }
                i5 = 1;
            } else {
                i5 = 0;
            }
            extras.setRequiredNetworkType(i5);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!dVar.c) {
            extras.setBackoffCriteria(oVar.m, oVar.f1120l == a.LINEAR ? 0 : 1);
        }
        long max = Math.max(oVar.a() - System.currentTimeMillis(), 0L);
        if (i4 <= 28 || max > 0) {
            extras.setMinimumLatency(max);
        } else if (!oVar.q) {
            extras.setImportantWhileForeground(true);
        }
        if (i4 >= 24 && dVar.a()) {
            for (e.a aVar2 : dVar.f1166h.a) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(aVar2.a, aVar2.b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(dVar.f1164f);
            extras.setTriggerContentMaxDelay(dVar.f1165g);
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(dVar.f1162d);
            extras.setRequiresStorageNotLow(dVar.f1163e);
        }
        boolean z = oVar.f1119k > 0;
        if (m.e.I0() && oVar.q && !z) {
            extras.setExpedited(true);
        }
        JobInfo build = extras.build();
        n c3 = n.c();
        String str = f1079f;
        c3.a(str, String.format("Scheduling work ID %s Job ID %s", oVar.a, Integer.valueOf(i2)), new Throwable[0]);
        try {
            if (this.c.schedule(build) == 0) {
                n.c().f(str, String.format("Unable to schedule work ID %s", oVar.a), new Throwable[0]);
                if (oVar.q && oVar.r == r.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    oVar.q = false;
                    n.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", oVar.a), new Throwable[0]);
                    h(oVar, i2);
                }
            }
        } catch (IllegalStateException e2) {
            List<JobInfo> e3 = e(this.b, this.c);
            int size = e3 != null ? e3.size() : 0;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(size);
            objArr[1] = Integer.valueOf(((ArrayList) ((q) this.f1080d.c.r()).f()).size());
            c cVar = this.f1080d.b;
            if (Build.VERSION.SDK_INT == 23) {
                c2 = 2;
                i3 = cVar.f1160h / 2;
            } else {
                c2 = 2;
                i3 = cVar.f1160h;
            }
            objArr[c2] = Integer.valueOf(i3);
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", objArr);
            n.c().b(f1079f, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            n.c().b(f1079f, String.format("Unable to schedule %s", oVar), th);
        }
    }
}
