package gov.nc.dhhs.exposurenotification.nearby;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.z.o;
import b.z.y.k;
import c.a.a.a.a;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.messages.Strategy;
import d.a.a.a.f.n;
import d.a.a.a.f.p;
import e.c.a.c;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.common.NotificationHelper;
import gov.nc.dhhs.exposurenotification.common.TaskToFutureAdapter;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.storage.ExposureRepository;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StateUpdatedWorker extends ListenableWorker {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "gov.nc.dhhs.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    public static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";
    public static final c GET_WINDOWS_TIMEOUT = c.k(120);
    public static final c MAX_EXPOSURE_DAYS = c.b(c.b.a.a.c.n.c.Z1(12, Strategy.TTL_SECONDS_MAX), 0);
    public static final String TAG = "StateUpdatedWorker";
    public final Context context;
    public final DailySummariesConfig dailySummariesConfig = getDailySummaryConfig();
    public final ExposureRepository exposureRepository;

    public StateUpdatedWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        this.context = context2;
        this.exposureRepository = new ExposureRepository(context2);
    }

    public static ListenableWorker.a d(Exception exc) {
        return new ListenableWorker.a.C0004a();
    }

    private DailySummariesConfig getDailySummaryConfig() {
        Double valueOf = Double.valueOf(1.0d);
        Double[] dArr = {valueOf, valueOf, Double.valueOf(0.5d), Double.valueOf(0.0d)};
        return new DailySummariesConfig.DailySummariesConfigBuilder().setMinimumWindowScore(0.0d).setDaysSinceExposureThreshold(0).setAttenuationBuckets(new ArrayList(Arrays.asList(46, 55, 63)), new ArrayList(Arrays.asList(dArr))).setInfectiousnessWeight(2, 1.0d).setInfectiousnessWeight(1, 0.0d).setReportTypeWeight(1, 1.0d).setReportTypeWeight(2, 0.0d).setReportTypeWeight(4, 0.0d).setReportTypeWeight(3, 0.0d).build();
    }

    /* access modifiers changed from: private */
    public boolean getDailySummaryScore(List<DailySummary> list) {
        list.size();
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(getApplicationContext());
        long timestampSinceLastExposure = exposureNotificationSharedPreferences.getTimestampSinceLastExposure(0L);
        double d2 = 0.0d;
        boolean z = false;
        for (DailySummary dailySummary : list) {
            long p = c.d((long) dailySummary.getDaysSinceEpoch()).p();
            dailySummary.getDaysSinceEpoch();
            dailySummary.getSummaryData().getWeightedDurationSum();
            c.f(System.currentTimeMillis()).o();
            c.f(System.currentTimeMillis()).o();
            if (Math.abs(c.f(System.currentTimeMillis()).o() - ((long) dailySummary.getDaysSinceEpoch())) < 14) {
                double weightedDurationSum = dailySummary.getSummaryData().getWeightedDurationSum();
                if (weightedDurationSum >= 900.0d) {
                    if (p > timestampSinceLastExposure) {
                        exposureNotificationSharedPreferences.setDisabledNotifications(false);
                        timestampSinceLastExposure = p;
                        d2 = weightedDurationSum;
                    }
                    exposureNotificationSharedPreferences.setTimestampSinceLastExposure(Long.valueOf(timestampSinceLastExposure));
                    setDaysSinceLastExposureTimeStamp(timestampSinceLastExposure);
                    z = true;
                } else if (!z && weightedDurationSum > 0.0d && weightedDurationSum < 900.0d && p > timestampSinceLastExposure) {
                    d2 = weightedDurationSum;
                }
            }
        }
        if (z) {
            exposureNotificationSharedPreferences.setPossibleExposureFound(true);
            return true;
        } else if (exposureNotificationSharedPreferences.getTestExposure(false)) {
            exposureNotificationSharedPreferences.setPossibleExposureFound(true);
            exposureNotificationSharedPreferences.setTimestampSinceLastExposure(Long.valueOf(System.currentTimeMillis() - 259200000));
            exposureNotificationSharedPreferences.setDaysSinceLastExposure(3);
            return true;
        } else {
            exposureNotificationSharedPreferences.setPossibleExposureFound(false);
            if (d2 > 0.0d) {
                StringBuilder g = a.g("A_CW_91009_");
                g.append((int) d2);
                g.append("    : Total weighted risk :: ");
                g.append(d2);
                CustomUtility.customLogger(g.toString());
            }
            return false;
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private String getNotificationMsg(int i) {
        String str;
        if (i == 0) {
            str = this.context.getString(R.string.notification_message_zero_days);
        } else {
            Context context2 = this.context;
            if (i == 1) {
                str = context2.getString(R.string.notification_message_one_day, Integer.valueOf(i));
            } else {
                str = context2.getString(R.string.notification_message_two_days, Integer.valueOf(i));
            }
        }
        StringBuilder g = a.g(str);
        g.append(this.context.getString(R.string.notification_message_tap_to_learn));
        return g.toString();
    }

    public static void runOnce(Context context2, String str) {
        k.b(context2).a(new o.a(StateUpdatedWorker.class).a());
    }

    private void setDaysSinceLastExposureTimeStamp(long j) {
        new ExposureNotificationSharedPreferences(getApplicationContext()).setDaysSinceLastExposure((int) c.f(System.currentTimeMillis() - j).o());
    }

    private void setLastNotificationTimeInMillis(Long l) {
        CustomUtility.customLogger("Setting time since last notification :: " + l);
        new ExposureNotificationSharedPreferences(getApplicationContext()).setLastNotificationTimeInMillis(l);
    }

    public ListenableWorker.a b(Boolean bool) {
        if (bool.booleanValue()) {
            int abs = ((int) Math.abs(System.currentTimeMillis() - new ExposureNotificationSharedPreferences(this.context).getTimestampSinceLastExposure(0L))) / 86400000;
            long lastNotificationTimeInMillis = new ExposureNotificationSharedPreferences(this.context).getLastNotificationTimeInMillis(0L);
            boolean disabledNotifications = new ExposureNotificationSharedPreferences(this.context).getDisabledNotifications(false);
            if (Math.abs(System.currentTimeMillis() - lastNotificationTimeInMillis) > 82800000 && !disabledNotifications && abs != 5) {
                CustomUtility.customLogger("A_CW_91001 Exposure Found and Notif shown");
                NotificationHelper.showPossibleExposureNotification(this.context);
            } else if (Math.abs(System.currentTimeMillis() - lastNotificationTimeInMillis) > 82800000 && abs == 5) {
                NotificationHelper.showGetTestedNotification(this.context);
            }
            setLastNotificationTimeInMillis(Long.valueOf(System.currentTimeMillis()));
        }
        return new ListenableWorker.a.c();
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        return l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(this.context).getDailySummary(this.dailySummariesConfig), GET_WINDOWS_TIMEOUT.p(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).t(new p(this), AppExecutors.getBackgroundExecutor()).t(new n(this), AppExecutors.getLightweightExecutor()).q(Exception.class, d.a.a.a.f.o.f4659a, AppExecutors.getLightweightExecutor());
    }
}
