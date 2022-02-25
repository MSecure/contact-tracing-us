package e.b0.x.p.c;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import e.b0.a;
import e.b0.c;
import e.b0.d;
import e.b0.l;
import e.b0.m;
import e.b0.s;
import e.b0.x.e;
import e.b0.x.s.g;
import e.b0.x.s.i;
import e.b0.x.s.o;
import e.b0.x.s.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class b implements e {

    /* renamed from: f  reason: collision with root package name */
    public static final String f1080f = l.e("SystemJobScheduler");
    public final Context b;
    public final JobScheduler c;

    /* renamed from: d  reason: collision with root package name */
    public final e.b0.x.l f1081d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1082e;

    public b(Context context, e.b0.x.l lVar) {
        a aVar = new a(context);
        this.b = context;
        this.f1081d = lVar;
        this.c = (JobScheduler) context.getSystemService("jobscheduler");
        this.f1082e = aVar;
    }

    public static void a(JobScheduler jobScheduler, int i2) {
        try {
            jobScheduler.cancel(i2);
        } catch (Throwable th) {
            l.c().b(f1080f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i2)), th);
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
            l.c().b(f1080f, "getAllPendingJobs() is not reliable on this device.", th);
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

    @Override // e.b0.x.e
    public void b(String str) {
        List<Integer> c2 = c(this.b, this.c, str);
        if (!(c2 == null || c2.isEmpty())) {
            for (Integer num : c2) {
                a(this.c, num.intValue());
            }
            ((i) this.f1081d.c.o()).c(str);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // e.b0.x.e
    public void d(o... oVarArr) {
        int i2;
        List<Integer> c2;
        int i3;
        WorkDatabase workDatabase = this.f1081d.c;
        e.b0.x.t.e eVar = new e.b0.x.t.e(workDatabase);
        for (o oVar : oVarArr) {
            workDatabase.c();
            try {
                o i4 = ((q) workDatabase.r()).i(oVar.a);
                if (i4 == null) {
                    l.c().f(f1080f, "Skipping scheduling " + oVar.a + " because it's no longer in the DB", new Throwable[0]);
                } else if (i4.b != s.ENQUEUED) {
                    l.c().f(f1080f, "Skipping scheduling " + oVar.a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    g a = ((i) workDatabase.o()).a(oVar.a);
                    if (a != null) {
                        i2 = a.b;
                    } else {
                        Objects.requireNonNull(this.f1081d.b);
                        i2 = eVar.b(0, this.f1081d.b.f983g);
                    }
                    if (a == null) {
                        ((i) this.f1081d.c.o()).b(new g(oVar.a, i2));
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
                            Objects.requireNonNull(this.f1081d.b);
                            i3 = eVar.b(0, this.f1081d.b.f983g);
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

    @Override // e.b0.x.e
    public boolean f() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (r3 < 26) goto L_0x002e;
     */
    public void h(o oVar, int i2) {
        int i3;
        char c2;
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        a aVar = this.f1082e;
        Objects.requireNonNull(aVar);
        c cVar = oVar.f1119j;
        m mVar = cVar.a;
        int ordinal = mVar.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        i3 = 4;
                        if (ordinal == 4) {
                        }
                    } else if (i5 >= 24) {
                        i3 = 3;
                    }
                    l.c().a(a.b, String.format("API version too low. Cannot convert network type value %s", mVar), new Throwable[0]);
                } else {
                    i3 = 2;
                }
            }
            i3 = 1;
        } else {
            i3 = 0;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", oVar.a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", oVar.c());
        JobInfo.Builder extras = new JobInfo.Builder(i2, aVar.a).setRequiredNetworkType(i3).setRequiresCharging(cVar.b).setRequiresDeviceIdle(cVar.c).setExtras(persistableBundle);
        if (!cVar.c) {
            extras.setBackoffCriteria(oVar.m, oVar.f1121l == a.LINEAR ? 0 : 1);
        }
        long max = Math.max(oVar.a() - System.currentTimeMillis(), 0L);
        if (i5 > 28 && max <= 0) {
            extras.setImportantWhileForeground(true);
        } else {
            extras.setMinimumLatency(max);
        }
        if (i5 >= 24) {
            if (cVar.f990h.a() > 0) {
                for (d.a aVar2 : cVar.f990h.a) {
                    extras.addTriggerContentUri(new JobInfo.TriggerContentUri(aVar2.a, aVar2.b ? 1 : 0));
                }
                extras.setTriggerContentUpdateDelay(cVar.f988f);
                extras.setTriggerContentMaxDelay(cVar.f989g);
            }
        }
        extras.setPersisted(false);
        if (i5 >= 26) {
            extras.setRequiresBatteryNotLow(cVar.f986d);
            extras.setRequiresStorageNotLow(cVar.f987e);
        }
        JobInfo build = extras.build();
        l.c().a(f1080f, String.format("Scheduling work ID %s Job ID %s", oVar.a, Integer.valueOf(i2)), new Throwable[0]);
        try {
            this.c.schedule(build);
        } catch (IllegalStateException e2) {
            List<JobInfo> e3 = e(this.b, this.c);
            int size = e3 != null ? e3.size() : 0;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(size);
            objArr[1] = Integer.valueOf(((ArrayList) ((q) this.f1081d.c.r()).f()).size());
            e.b0.b bVar = this.f1081d.b;
            if (i5 == 23) {
                c2 = 2;
                i4 = bVar.f984h / 2;
            } else {
                c2 = 2;
                i4 = bVar.f984h;
            }
            objArr[c2] = Integer.valueOf(i4);
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", objArr);
            l.c().b(f1080f, format, new Throwable[0]);
            throw new IllegalStateException(format, e2);
        } catch (Throwable th) {
            l.c().b(f1080f, String.format("Unable to schedule %s", oVar), th);
        }
    }
}
