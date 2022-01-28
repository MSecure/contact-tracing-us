package com.proudcrowd.exposure.core;

import com.proudcrowd.exposure.datamodel.AttenuationDetail;
import java.util.ArrayList;
import java.util.Iterator;

public class DayBucket {
    public ArrayList<AttenuationBucket> attenuationBuckets = new ArrayList<>();
    public long dateTimeInMs;
    public int triggerScore;

    public DayBucket(long j, int i, AttenuationDetail[] attenuationDetailArr) {
        this.dateTimeInMs = j;
        this.triggerScore = i;
        for (AttenuationDetail attenuationDetail : attenuationDetailArr) {
            this.attenuationBuckets.add(new AttenuationBucket(attenuationDetail));
        }
    }

    public boolean IsExposure() {
        Iterator<AttenuationBucket> it = this.attenuationBuckets.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            AttenuationBucket next = it.next();
            d += ((double) next.accumulatedSeconds) * next.attenuationWeight;
        }
        return d > ((double) this.triggerScore);
    }

    public class AttenuationBucket {
        public int accumulatedSeconds = 0;
        public double attenuationWeight;
        public int maximumAttenuation;

        public AttenuationBucket(AttenuationDetail attenuationDetail) {
            this.maximumAttenuation = attenuationDetail.maximumAttenuation;
            this.attenuationWeight = attenuationDetail.attenuationWeight;
        }
    }
}
