# GuideSafe Analysis (Alabama)
### App Permissions
  - Network Status
  - WiFi Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Vibrate
  - Wake Lock


```
<uses-permission android:name="android.permission.INTERNET" />

<uses-permission android:name="android.permission.VIBRATE" />

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

<uses-permission android:name="android.permission.BLUETOOTH" />

<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

<uses-permission android:name="android.permission.WAKE_LOCK" />

<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```

The app can read/write to external storage without requesting the permissions

### Privacy Policy
The GuideSafe™ Exposure Notification app was developed by the Alabama Department of Public Health in cooperation with the University of Alabama at Birmingham and MotionMobs, using technology from a collaboration between Apple and Google. Users of the app exchange anonymous codes among their phones using Bluetooth — no location data is ever stored or exchanged, and your personal information is never shared.
https://www.guidesafe.org/privacy-statement/

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but after running the analysis we see that the has read/write permissions to the external storage which any app can access which allows for data injection and reading any data that the app writes to external storage.

### Ghera Vulnerabilities
[False Positive] The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 

### Deeper Analysis
- [False Positive] Next is the rawQuery SQL vulnerability which will allow for sql injection as a function is provided that directly takes an string as an argument and puts it in to the sql database using a rawQuery.
- The big vulnerability in the app is that it uses the ECB mode encryption which is known to be very vulnerable. 
- The main activity of the app is also not protected meaning it can be accessed and called by any other apps.
- The app also uses the locationHelper and locationManager classes within the main activity which means any other app will be able to access the current location by calling the main activity of this app.
- The app can also read/write to external storage which leaves it vulnerable to data injection and any data that is written to the external storage by the app can be read by any other app. The app is using the external storage to create a temp file and store it.
- One suspicious part of the app is that it is accessing a server in Bogota, Colombia. This seems unnecessary since the exposure notification servers should be in the US. The 
app is attempting to access encdn.prod.exposurenotification.health which gives the following error when attempting to be accessed. 

```
<h2>Our services aren't available right now</h2><p>We're working to restore all services as soon as possible. Please check back soon.</p>05LKOYQAAAAB6raS3jv9vRq4ROGa1WoQVRE5BRURHRTA0MTUARWRnZQ==
```

- The app uses an insecure Random Number Generator. While this isn't too much of a vulnerability the app should be updated to use SecureRandom.
