package org.pathcheck.covidsafepaths.exposurenotifications.nearby;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.zzg;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.horcrux.svg.PathParser;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;

/* compiled from: ExposureConfigurations.kt */
public final class ExposureConfigurations {
    public static final List<Double> DEFAULT_ATTENUATION_BUCKET_WEIGHTS;
    public static final List<Integer> DEFAULT_ATTENUATION_DURATION_THRESHOLDS = CollectionsKt__CollectionsKt.listOf(40, 53, 60);
    public static final Map<Integer, Integer> DEFAULT_DAYS_SINCE_ONSET_TO_INFECTIOUSNESS = PathParser.mapOf(new Pair(-2, 1), new Pair(-1, 1), new Pair(0, 1), new Pair(1, 1), new Pair(2, 1), new Pair(3, 1), new Pair(4, 1), new Pair(5, 1), new Pair(6, 1), new Pair(7, 1), new Pair(8, 1), new Pair(9, 1), new Pair(10, 1), new Pair(11, 1), new Pair(12, 1), new Pair(13, 1), new Pair(14, 1));
    public static final List<Double> DEFAULT_INFECTIOUSNESS_WEIGHT;
    public static final List<Double> DEFAULT_REPORT_TYPE_WEIGHTS;
    public static final Uri configurationUri = Uri.parse(BuildConfig.EXPOSURE_CONFIGURATION_JSON_RESOURCE_V6);
    public final ExposureNotificationSharedPreferences prefs;

    static {
        Double valueOf = Double.valueOf(1.0d);
        Double valueOf2 = Double.valueOf(0.0d);
        DEFAULT_ATTENUATION_BUCKET_WEIGHTS = CollectionsKt__CollectionsKt.listOf(valueOf, valueOf, Double.valueOf(0.5d), valueOf2);
        DEFAULT_REPORT_TYPE_WEIGHTS = CollectionsKt__CollectionsKt.listOf(valueOf, valueOf2, valueOf2, valueOf2);
        DEFAULT_INFECTIOUSNESS_WEIGHT = CollectionsKt__CollectionsKt.listOf(valueOf, valueOf);
    }

    public ExposureConfigurations(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = new ExposureNotificationSharedPreferences(context);
    }

    public final DiagnosisKeysDataMapping getDiagnosisKeysDataMapping() {
        boolean z = true;
        Integer num = 1;
        Integer valueOf = Integer.valueOf(this.prefs.sharedPreferences.getInt("ExposureNotificationSharedPreferences.INFECTIOUSNESS_WHEN_DAY_SINCE_ONSET_MISSING", num.intValue()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "prefs.getInfectiousnessW…_DAY_SINCE_ONSET_MISSING)");
        int intValue = valueOf.intValue();
        ReactYogaConfigProvider.checkArgument(zzg.zza(intValue) != null, "Invalid value of Infectiousness %d", Integer.valueOf(intValue));
        Integer valueOf2 = Integer.valueOf(intValue);
        ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = this.prefs;
        Map<Integer, Integer> map = DEFAULT_DAYS_SINCE_ONSET_TO_INFECTIOUSNESS;
        String string = exposureNotificationSharedPreferences.sharedPreferences.getString("ExposureNotificationSharedPreferences.DAYS_SINCE_ONSET_TO_INFECTIOUSNESS", null);
        if (string != null) {
            map = (Map) new Gson().fromJson(string, new TypeToken<Map<Integer, Integer>>(exposureNotificationSharedPreferences) {
                /* class org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences.AnonymousClass5 */
            }.type);
        }
        ReactYogaConfigProvider.checkArgument(map != null, "daysSinceOnsetToInfectiousness must not be null.");
        ReactYogaConfigProvider.checkArgument(map.size() <= 29, "the size of daysSinceOnsetToInfectiousness exceeds maximum size %d.", 29);
        Integer[] numArr = new Integer[29];
        Arrays.fill((Object[]) numArr, (Object) 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int intValue2 = entry.getKey().intValue();
            int intValue3 = entry.getValue().intValue();
            ReactYogaConfigProvider.checkArgument(Math.abs(intValue2) <= 14, "Invalid day since onset %d", Integer.valueOf(intValue2));
            ReactYogaConfigProvider.checkArgument(zzg.zza(intValue3) != null, "Invalid value of Infectiousness %d", Integer.valueOf(intValue3));
            numArr[intValue2 + 14] = Integer.valueOf(intValue3);
        }
        List asList = Arrays.asList(numArr);
        Integer num2 = 1;
        Integer valueOf3 = Integer.valueOf(this.prefs.sharedPreferences.getInt("ExposureNotificationSharedPreferences.REPORT_TYPE_WHEN_MISSING", num2.intValue()));
        Intrinsics.checkNotNullExpressionValue(valueOf3, "prefs.getReportTypeWhenM…REPORT_TYPE_WHEN_MISSING)");
        int intValue4 = valueOf3.intValue();
        ReactYogaConfigProvider.checkArgument(intValue4 != 0, "Invalid reportTypeWhenMissing value");
        ReactYogaConfigProvider.checkArgument(intValue4 >= 0 && intValue4 <= 5, "Invalid value of ReportType %d", Integer.valueOf(intValue4));
        ReactYogaConfigProvider.checkArgument(asList != null, "Must set daysSinceOnsetToInfectiousness");
        ReactYogaConfigProvider.checkArgument(intValue4 != 0, "Must set reportTypeWhenMissing");
        if (valueOf2 == null) {
            z = false;
        }
        ReactYogaConfigProvider.checkArgument(z, "Must set infectiousnessWhenDaysSinceOnsetMissing");
        DiagnosisKeysDataMapping diagnosisKeysDataMapping = new DiagnosisKeysDataMapping(asList, intValue4, valueOf2.intValue());
        Intrinsics.checkNotNullExpressionValue(diagnosisKeysDataMapping, "DiagnosisKeysDataMapping…   )\n            .build()");
        return diagnosisKeysDataMapping;
    }
}
