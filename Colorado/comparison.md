Methond `c()`:
```
        @Override // e.b.a.m.f
        public int c() {
            boolean z;
            Location location;
            long j2;
            v vVar = this.c;
            v.a aVar = vVar.c;
            boolean z2 = false;
            if (!(aVar.b > System.currentTimeMillis())) {
                Location location2 = null;
                if (h.q(vVar.a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    try {
                        if (vVar.b.isProviderEnabled("network")) {
                            location = vVar.b.getLastKnownLocation("network");
                            if (h.q(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                                try {
                                    if (vVar.b.isProviderEnabled("gps")) {
                                        location2 = vVar.b.getLastKnownLocation("gps");
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            if (location2 == null || location == null ? location2 != null : location2.getTime() > location.getTime()) {
                                location = location2;
                            }
                            if (location == null) {
                                v.a aVar2 = vVar.c;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (u.f687d == null) {
                                    u.f687d = new u();
                                }
                                u uVar = u.f687d;
                                uVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                                uVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
                                if (uVar.c == 1) {
                                    z2 = true;
                                }
                                long j3 = uVar.b;
                                long j4 = uVar.a;
                                uVar.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                                long j5 = uVar.b;
                                if (j3 == -1 || j4 == -1) {
                                    j2 = 43200000 + currentTimeMillis;
                                } else {
                                    j2 = (currentTimeMillis > j4 ? j5 + 0 : currentTimeMillis > j3 ? j4 + 0 : j3 + 0) + 60000;
                                }
                                aVar2.a = z2;
                                aVar2.b = j2;
                            } else {
                                int i2 = Calendar.getInstance().get(11);
                                if (i2 < 6 || i2 >= 22) {
                                    z2 = true;
                                }
                                z = z2;
                                if (!z) {
                                    return 2;
                                }
                                return 1;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                location = null;
                if (h.q(vVar.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                }
                location = location2;
                if (location == null) {
                }
            }
            z = aVar.a;
            if (!z) {
            }
        }

```

---
Method `isNight()`, `getLastKnownLocation()`, and `getLastKnownLocationForProvider`
```
public boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location getLastKnownLocation() {
        Location location = null;
        Location lastKnownLocationForProvider = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? getLastKnownLocationForProvider("network") : null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = getLastKnownLocationForProvider("gps");
        }
        return (location == null || lastKnownLocationForProvider == null) ? location != null ? location : lastKnownLocationForProvider : location.getTime() > lastKnownLocationForProvider.getTime() ? location : lastKnownLocationForProvider;
    }

    private Location getLastKnownLocationForProvider(String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return this.mLocationManager.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d(TAG, "Failed to get last known location", e);
            return null;
        }
    }
```

Method `updateState()`:
```
  private void updateState(Location location) {
        long j;
        TwilightState twilightState = this.mTwilightState;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator instance = TwilightCalculator.getInstance();
        instance.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = instance.sunset;
        instance.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (instance.state != 1) {
            z = false;
        }
        long j3 = instance.sunrise;
        long j4 = instance.sunset;
        instance.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = instance.sunrise;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        twilightState.isNight = z;
        twilightState.yesterdaySunset = j2;
        twilightState.todaySunrise = j3;
        twilightState.todaySunset = j4;
        twilightState.tomorrowSunrise = j5;
        twilightState.nextUpdate = j;
    }
```
