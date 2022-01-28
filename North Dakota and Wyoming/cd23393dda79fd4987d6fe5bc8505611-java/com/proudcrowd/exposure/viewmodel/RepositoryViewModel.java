package com.proudcrowd.exposure.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.proudcrowd.exposure.storage.ExposureEntity;
import com.proudcrowd.exposure.storage.ExposureRepository;
import com.proudcrowd.exposure.storage.KeyScanEntity;
import com.proudcrowd.exposure.storage.KeyScanRepository;
import com.proudcrowd.exposure.storage.PartyEntity;
import com.proudcrowd.exposure.storage.PartyRepository;
import java.util.List;

public class RepositoryViewModel extends AndroidViewModel {
    private final LiveData<List<ExposureEntity>> mExposureLiveData;
    private final ExposureRepository mExposureRepository;
    private final LiveData<List<PartyEntity>> mPartyLiveData;
    private final PartyRepository mPartyRepository;
    private final LiveData<List<KeyScanEntity>> mScanLiveData;
    private final KeyScanRepository mScanRepository;

    public RepositoryViewModel(Application application) {
        super(application);
        KeyScanRepository keyScanRepository = new KeyScanRepository(application);
        this.mScanRepository = keyScanRepository;
        this.mScanLiveData = keyScanRepository.getAllLiveData();
        ExposureRepository exposureRepository = new ExposureRepository(application);
        this.mExposureRepository = exposureRepository;
        this.mExposureLiveData = exposureRepository.getAllLiveData();
        PartyRepository partyRepository = new PartyRepository(application);
        this.mPartyRepository = partyRepository;
        this.mPartyLiveData = partyRepository.getAllLiveData();
    }

    public LiveData<List<KeyScanEntity>> getScanLiveData() {
        return this.mScanLiveData;
    }

    public LiveData<List<ExposureEntity>> getExposureLiveData() {
        return this.mExposureLiveData;
    }

    public LiveData<List<PartyEntity>> getPartyLiveData() {
        return this.mPartyLiveData;
    }
}
