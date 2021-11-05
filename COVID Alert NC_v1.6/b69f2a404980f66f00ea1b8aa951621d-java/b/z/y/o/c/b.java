package b.z.y.o.c;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import b.r.j;
import b.z.a;
import b.z.c;
import b.z.d;
import b.z.m;
import b.z.n;
import b.z.u;
import b.z.y.e;
import b.z.y.k;
import b.z.y.r.g;
import b.z.y.r.i;
import b.z.y.r.p;
import b.z.y.r.q;
import b.z.y.r.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class b implements e {
    public static final String f = m.e("SystemJobScheduler");

    /* renamed from: b  reason: collision with root package name */
    public final Context f2023b;

    /* renamed from: c  reason: collision with root package name */
    public final JobScheduler f2024c;

    /* renamed from: d  reason: collision with root package name */
    public final k f2025d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2026e;

    public b(Context context, k kVar) {
        a aVar = new a(context);
        this.f2023b = context;
        this.f2025d = kVar;
        this.f2024c = (JobScheduler) context.getSystemService("jobscheduler");
        this.f2026e = aVar;
    }

    public static void a(Context context) {
        List<JobInfo> g;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (g = g(context, jobScheduler)) == null || g.isEmpty())) {
            for (JobInfo jobInfo : g) {
                c(jobScheduler, jobInfo.getId());
            }
        }
    }

    public static void c(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            m.c().b(f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static List<Integer> e(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> g = g(context, jobScheduler);
        if (g == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : g) {
            if (str.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static List<JobInfo> g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            m.c().b(f, "getAllPendingJobs() is not reliable on this device.", th);
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

    public static String h(JobInfo jobInfo) {
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

    public static boolean i(Context context, k kVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> g = g(context, jobScheduler);
        i iVar = (i) kVar.f1971c.e();
        if (iVar != null) {
            boolean z = false;
            j d2 = j.d("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
            iVar.f2078a.assertNotSuspendingTransaction();
            Cursor b2 = b.r.q.b.b(iVar.f2078a, d2, false, null);
            try {
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(b2.getString(0));
                }
                HashSet hashSet = new HashSet(g != null ? g.size() : 0);
                if (g != null && !g.isEmpty()) {
                    for (JobInfo jobInfo : g) {
                        String h = h(jobInfo);
                        if (!TextUtils.isEmpty(h)) {
                            hashSet.add(h);
                        } else {
                            c(jobScheduler, jobInfo.getId());
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!hashSet.contains((String) it.next())) {
                            m.c().a(f, "Reconciling jobs", new Throwable[0]);
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    WorkDatabase workDatabase = kVar.f1971c;
                    workDatabase.beginTransaction();
                    try {
                        q h2 = workDatabase.h();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((r) h2).l((String) it2.next(), -1);
                        }
                        workDatabase.setTransactionSuccessful();
                    } finally {
                        workDatabase.endTransaction();
                    }
                }
                return z;
            } finally {
                b2.close();
                d2.h();
            }
        } else {
            throw null;
        }
    }

    @Override // b.z.y.e
    public void b(String str) {
        List<Integer> e2 = e(this.f2023b, this.f2024c, str);
        if (!(e2 == null || e2.isEmpty())) {
            for (Integer num : e2) {
                c(this.f2024c, num.intValue());
            }
            ((i) this.f2025d.f1971c.e()).c(str);
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // b.z.y.e
    public void d(p... pVarArr) {
        int i;
        List<Integer> e2;
        int i2;
        WorkDatabase workDatabase = this.f2025d.f1971c;
        b.z.y.s.e eVar = new b.z.y.s.e(workDatabase);
        for (p pVar : pVarArr) {
            workDatabase.beginTransaction();
            try {
                p i3 = ((r) workDatabase.h()).i(pVar.f2091a);
                if (i3 == null) {
                    m.c().f(f, "Skipping scheduling " + pVar.f2091a + " because it's no longer in the DB", new Throwable[0]);
                } else if (i3.f2092b != u.ENQUEUED) {
                    m.c().f(f, "Skipping scheduling " + pVar.f2091a + " because it is no longer enqueued", new Throwable[0]);
                } else {
                    g a2 = ((i) workDatabase.e()).a(pVar.f2091a);
                    if (a2 != null) {
                        i = a2.f2077b;
                    } else {
                        i = eVar.b(this.f2025d.f1970b.i, this.f2025d.f1970b.j);
                    }
                    if (a2 == null) {
                        ((i) this.f2025d.f1971c.e()).b(new g(pVar.f2091a, i));
                    }
                    j(pVar, i);
                    if (Build.VERSION.SDK_INT == 23 && (e2 = e(this.f2023b, this.f2024c, pVar.f2091a)) != null) {
                        int indexOf = e2.indexOf(Integer.valueOf(i));
                        if (indexOf >= 0) {
                            e2.remove(indexOf);
                        }
                        if (!e2.isEmpty()) {
                            i2 = e2.get(0).intValue();
                        } else {
                            i2 = eVar.b(this.f2025d.f1970b.i, this.f2025d.f1970b.j);
                        }
                        j(pVar, i2);
                    }
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // b.z.y.e
    public boolean f() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (android.os.Build.VERSION.SDK_INT < 26) goto L_0x002f;
     */
    public void j(p pVar, int i) {
        int i2;
        a aVar = this.f2026e;
        if (aVar != null) {
            c cVar = pVar.j;
            n nVar = cVar.f1898a;
            int ordinal = nVar.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            i2 = 4;
                            if (ordinal == 4) {
                            }
                        } else if (Build.VERSION.SDK_INT >= 24) {
                            i2 = 3;
                        }
                        m.c().a(a.f2021b, String.format("API version too low. Cannot convert network type value %s", nVar), new Throwable[0]);
                    } else {
                        i2 = 2;
                    }
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("EXTRA_WORK_SPEC_ID", pVar.f2091a);
            persistableBundle.putBoolean("EXTRA_IS_PERIODIC", pVar.c());
            JobInfo.Builder extras = new JobInfo.Builder(i, aVar.f2022a).setRequiredNetworkType(i2).setRequiresCharging(cVar.f1899b).setRequiresDeviceIdle(cVar.f1900c).setExtras(persistableBundle);
            if (!cVar.f1900c) {
                extras.setBackoffCriteria(pVar.m, pVar.l == a.LINEAR ? 0 : 1);
            }
            long max = Math.max(pVar.a() - System.currentTimeMillis(), 0L);
            if (Build.VERSION.SDK_INT > 28 && max <= 0) {
                extras.setImportantWhileForeground(true);
            } else {
                extras.setMinimumLatency(max);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if ((cVar.h.a() > 0 ? 1 : null) != null) {
                    for (d.a aVar2 : cVar.h.f1908a) {
                        extras.addTriggerContentUri(new JobInfo.TriggerContentUri(aVar2.f1909a, aVar2.f1910b ? 1 : 0));
                    }
                    extras.setTriggerContentUpdateDelay(cVar.f);
                    extras.setTriggerContentMaxDelay(cVar.g);
                }
            }
            extras.setPersisted(false);
            if (Build.VERSION.SDK_INT >= 26) {
                extras.setRequiresBatteryNotLow(cVar.f1901d);
                extras.setRequiresStorageNotLow(cVar.f1902e);
            }
            JobInfo build = extras.build();
            m.c().a(f, String.format("Scheduling work ID %s Job ID %s", pVar.f2091a, Integer.valueOf(i)), new Throwable[0]);
            try {
                this.f2024c.schedule(build);
            } catch (IllegalStateException e2) {
                List<JobInfo> g = g(this.f2023b, this.f2024c);
                int size = g != null ? g.size() : 0;
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(((ArrayList) ((r) this.f2025d.f1971c.h()).f()).size());
                b.z.b bVar = this.f2025d.f1970b;
                int i3 = Build.VERSION.SDK_INT;
                int i4 = bVar.k;
                if (i3 == 23) {
                    i4 /= 2;
                }
                objArr[2] = Integer.valueOf(i4);
                String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", objArr);
                m.c().b(f, format, new Throwable[0]);
                throw new IllegalStateException(format, e2);
            } catch (Throwable th) {
                m.c().b(f, String.format("Unable to schedule %s", pVar), th);
            }
        } else {
            throw null;
        }
    }
}
