package gov.michigan.MiCovidExposure.nearby;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.b0.o;
import b.b0.y.k;
import b.x.t;
import c.a.a.a.a;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.messages.Strategy;
import e.a.a.d.n;
import e.a.a.d.p;
import g.b.a.c;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.common.NotificationHelper;
import gov.michigan.MiCovidExposure.common.TaskToFutureAdapter;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.storage.ExposureRepository;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StateUpdatedWorker extends ListenableWorker {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "gov.michigan.MiCovidExposure.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    public static final String EXPOSURE_NOTIFICATION_CHANNEL_ID = "ApolloExposureNotificationCallback.EXPOSURE_NOTIFICATION_CHANNEL_ID";
    public static final c GET_WINDOWS_TIMEOUT = c.m(120);
    public static final c MAX_EXPOSURE_DAYS = c.b(t.E2(12, Strategy.TTL_SECONDS_MAX), 0);
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
        return new ListenableWorker.a.C0005a();
    }

    private DailySummariesConfig getDailySummaryConfig() {
        Double[] dArr = {Double.valueOf(1.5d), Double.valueOf(1.0d), Double.valueOf(0.4d), Double.valueOf(0.0d)};
        return new DailySummariesConfig.DailySummariesConfigBuilder().setMinimumWindowScore(0.0d).setDaysSinceExposureThreshold(0).setAttenuationBuckets(new ArrayList(Arrays.asList(55, 63, 70)), new ArrayList(Arrays.asList(dArr))).setInfectiousnessWeight(2, 1.0d).setInfectiousnessWeight(1, 0.3d).setReportTypeWeight(1, 1.0d).setReportTypeWeight(2, 0.0d).setReportTypeWeight(4, 0.0d).setReportTypeWeight(3, 0.0d).build();
    }

    /* access modifiers changed from: private */
    public boolean getDailySummaryScore(List<DailySummary> list) {
        list.size();
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(getApplicationContext());
        long timestampSinceLastExposure = exposureNotificationSharedPreferences.getTimestampSinceLastExposure(0L);
        boolean z = false;
        double d2 = 0.0d;
        for (DailySummary dailySummary : list) {
            long s = c.d((long) dailySummary.getDaysSinceEpoch()).s();
            dailySummary.getDaysSinceEpoch();
            dailySummary.getSummaryData().getWeightedDurationSum();
            c.f(System.currentTimeMillis()).r();
            c.f(System.currentTimeMillis()).r();
            if (Math.abs(c.f(System.currentTimeMillis()).r() - ((long) dailySummary.getDaysSinceEpoch())) < 12) {
                double weightedDurationSum = dailySummary.getSummaryData().getWeightedDurationSum();
                if (weightedDurationSum >= 900.0d) {
                    if (s > timestampSinceLastExposure) {
                        exposureNotificationSharedPreferences.setDisabledNotifications(false);
                        d2 = weightedDurationSum;
                        timestampSinceLastExposure = s;
                    }
                    exposureNotificationSharedPreferences.setTimestampSinceLastExposure(Long.valueOf(timestampSinceLastExposure));
                    setDaysSinceLastExposureTimeStamp(timestampSinceLastExposure);
                    z = true;
                } else if (!z && weightedDurationSum > 0.0d && weightedDurationSum < 900.0d && s > timestampSinceLastExposure) {
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
            CustomUtility.customLogger("A_CW_91009_" + ((int) d2));
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
        StringBuilder h = a.h(str);
        h.append(this.context.getString(R.string.notification_message_tap_to_learn));
        return h.toString();
    }

    public static void runOnce(Context context2, String str) {
        k.b(context2).a(new o.a(StateUpdatedWorker.class).a());
    }

    private void setDaysSinceLastExposureTimeStamp(long j) {
        new ExposureNotificationSharedPreferences(getApplicationContext()).setDaysSinceLastExposure((int) c.f(System.currentTimeMillis() - j).r());
    }

    private void setLastNotificationTimeInMillis(Long l) {
        CustomUtility.customLogger("Setting time since last notification :: " + l);
        new ExposureNotificationSharedPreferences(getApplicationContext()).setLastNotificationTimeInMillis(l);
    }

    public ListenableWorker.a b(Boolean bool) {
        if (bool.booleanValue()) {
            long lastNotificationTimeInMillis = new ExposureNotificationSharedPreferences(this.context).getLastNotificationTimeInMillis(0L);
            boolean disabledNotifications = new ExposureNotificationSharedPreferences(this.context).getDisabledNotifications(false);
            if (Math.abs(System.currentTimeMillis() - lastNotificationTimeInMillis) > 82800000 && !disabledNotifications) {
                CustomUtility.customLogger("A_CW_91001");
                if (!new ExposureNotificationSharedPreferences(this.context).gethasEverReceivedNotification(false)) {
                    new ExposureNotificationSharedPreferences(this.context).sethasEverReceivedNotification(true);
                    CustomUtility.customLogger("A_CW_91201");
                }
                NotificationHelper.showPossibleExposureNotification(this.context);
                setLastNotificationTimeInMillis(Long.valueOf(System.currentTimeMillis()));
            }
        }
        return new ListenableWorker.a.c();
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        return l.s(TaskToFutureAdapter.getFutureWithTimeout(ExposureNotificationClientWrapper.get(this.context).getDailySummary(this.dailySummariesConfig), GET_WINDOWS_TIMEOUT.s(), TimeUnit.MILLISECONDS, AppExecutors.getScheduledExecutor())).t(new p(this), AppExecutors.getBackgroundExecutor()).t(new e.a.a.d.o(this), AppExecutors.getLightweightExecutor()).q(Exception.class, n.f6270a, AppExecutors.getLightweightExecutor());
    }
}
