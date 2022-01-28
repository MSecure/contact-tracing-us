package gov.michigan.MiCovidExposure.nearby;

import android.content.Context;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
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
        int i;
        Integer num;
        TreeMap treeMap = new TreeMap();
        int i2 = -14;
        while (true) {
            int i3 = 2;
            if (i2 > 14) {
                return new DiagnosisKeysDataMapping.DiagnosisKeysDataMappingBuilder().setDaysSinceOnsetToInfectiousness(treeMap).setReportTypeWhenMissing(1).setInfectiousnessWhenDaysSinceOnsetMissing(2).build();
            }
            if (i2 >= -2 && i2 < 4) {
                num = Integer.valueOf(i2);
            } else if (i2 == -3 || i2 == 4) {
                num = Integer.valueOf(i2);
                i = 1;
                treeMap.put(num, i);
                i2++;
            } else {
                num = Integer.valueOf(i2);
                i3 = 0;
            }
            i = Integer.valueOf(i3);
            treeMap.put(num, i);
            i2++;
        }
    }
}
