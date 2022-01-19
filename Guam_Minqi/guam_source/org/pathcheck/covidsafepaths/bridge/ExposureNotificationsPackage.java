package org.pathcheck.covidsafepaths.bridge;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.DebugMenuModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.DeviceInfoModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureHistoryModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureKeyModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.ExposureNotificationsModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.SymptomLogEntryModule;
import org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.UtilsModule;

public class ExposureNotificationsPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExposureNotificationsModule(reactApplicationContext));
        arrayList.add(new DebugMenuModule(reactApplicationContext));
        arrayList.add(new ExposureKeyModule(reactApplicationContext));
        arrayList.add(new DeviceInfoModule(reactApplicationContext));
        arrayList.add(new ExposureHistoryModule(reactApplicationContext));
        arrayList.add(new UtilsModule(reactApplicationContext));
        arrayList.add(new SymptomLogEntryModule(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
