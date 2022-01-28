package gov.nc.dhhs.exposurenotification.nearby;

import android.content.Context;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import java.util.TreeMap;

public class ExposureConfigurations {
    public final Context context;
    public final ExposureNotificationSharedPreferences prefs;

    public ExposureConfigurations(Context context2) {
        this.context = context2;
        this.prefs = new ExposureNotificationSharedPreferences(context2);
    }

    public ExposureConfiguration get() {
        return new ExposureConfiguration.ExposureConfigurationBuilder().setMinimumRiskScore(1).setDurationAtAttenuationThresholds(50, 63).setAttenuationScores(0, 0, 1, 1, 1, 1, 1, 1).setDaysSinceLastExposureScores(1, 1, 1, 1, 1, 1, 1, 1).setDurationScores(0, 1, 1, 1, 1, 1, 1, 1).setTransmissionRiskScores(1, 1, 1, 1, 1, 1, 1, 1).build();
    }

    public DiagnosisKeysDataMapping get2() {
        Integer num;
        TreeMap treeMap = new TreeMap();
        int i = -14;
        while (true) {
            int i2 = 2;
            if (i > 14) {
                return new DiagnosisKeysDataMapping.DiagnosisKeysDataMappingBuilder().setDaysSinceOnsetToInfectiousness(treeMap).setReportTypeWhenMissing(1).setInfectiousnessWhenDaysSinceOnsetMissing(2).build();
            }
            if (i < -14 || i >= -2) {
                num = Integer.valueOf(i);
            } else {
                num = Integer.valueOf(i);
                i2 = 0;
            }
            treeMap.put(num, Integer.valueOf(i2));
            i++;
        }
    }
}
