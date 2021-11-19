package com.proudcrowd.exposure.core;

import android.net.Uri;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.proudcrowd.exposure.datamodel.DiagnosisKeyFile;
import com.proudcrowd.exposure.datamodel.ExposureConfigurationDetail;
import com.proudcrowd.exposure.datamodel.ScoringDetail;

/* access modifiers changed from: package-private */
public class ExposureDetectionInfo {
    private final ExposureApplication applicationContext;
    private ExposureConfiguration configuration;
    private Uri downloadBaseUri;
    private Uri downloadIndexUri;
    private Exception error;
    private ImmutableList<DiagnosisKeyFile> keyFiles;
    private ImmutableList<String> newWatermarkUrlFragments;

    ExposureDetectionInfo(ExposureApplication exposureApplication) {
        this.applicationContext = exposureApplication;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<String> getNewWatermarkUrlFragments() {
        return this.newWatermarkUrlFragments;
    }

    /* access modifiers changed from: package-private */
    public void setNewWatermarkUrlFragments(ImmutableList<String> immutableList) {
        this.newWatermarkUrlFragments = immutableList;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<DiagnosisKeyFile> getKeyFiles() {
        return this.keyFiles;
    }

    /* access modifiers changed from: package-private */
    public Exception getError() {
        return this.error;
    }

    /* access modifiers changed from: package-private */
    public void setError(Exception exc) {
        this.error = exc;
    }

    /* access modifiers changed from: package-private */
    public Uri getDownloadIndexUri() {
        return this.downloadIndexUri;
    }

    /* access modifiers changed from: package-private */
    public Uri getDownloadBaseUri() {
        return this.downloadBaseUri;
    }

    /* access modifiers changed from: package-private */
    public ExposureConfiguration getConfiguration() {
        return this.configuration;
    }

    /* access modifiers changed from: package-private */
    public boolean getSucceeded() {
        return getError() == null;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> setKeyFiles(ImmutableList<DiagnosisKeyFile> immutableList) {
        this.keyFiles = immutableList;
        return Futures.immediateVoidFuture();
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> setConfiguration(ExposureConfigurationDetail exposureConfigurationDetail) {
        this.applicationContext.setKeymatchSettings(exposureConfigurationDetail);
        this.applicationContext.setKeyServerUrls(exposureConfigurationDetail.keyServerSettings);
        Uri parse = Uri.parse(exposureConfigurationDetail.keyServerSettings.downloadUrl);
        this.downloadBaseUri = parse;
        this.downloadIndexUri = parse.buildUpon().appendEncodedPath(exposureConfigurationDetail.keyServerSettings.indexFileName).build();
        ScoringDetail scoringDetail = exposureConfigurationDetail.scoringSettings;
        this.configuration = new ExposureConfiguration.ExposureConfigurationBuilder().setAttenuationScores(scoringDetail.attenuationLevelValues).setAttenuationWeight(scoringDetail.attenuationWeight).setDaysSinceLastExposureScores(scoringDetail.daysSinceLastExposureLevelValues).setDaysSinceLastExposureWeight(scoringDetail.daysSinceLastExposureWeight).setDurationScores(scoringDetail.durationLevelValues).setDurationWeight(scoringDetail.durationWeight).setTransmissionRiskScores(scoringDetail.transmissionRiskLevelValues).setTransmissionRiskWeight(scoringDetail.transmissionRiskWeight).setMinimumRiskScore(scoringDetail.minimumRiskScore).setDurationAtAttenuationThresholds(scoringDetail.attenuationDurationThresholds[0], scoringDetail.attenuationDurationThresholds[1]).build();
        return Futures.immediateVoidFuture();
    }
}
