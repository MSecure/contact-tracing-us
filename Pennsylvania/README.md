# Covid Alert PA Analysis
### App Permissions
  - Network Status
  - WiFi Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Vibrate


```
<uses-permission android:name="android.permission.BLUETOOTH" />

<uses-permission android:name="android.permission.INTERNET" />

<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

<uses-permission android:name="android.permission.VIBRATE" />

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```

The app can read/write to external storage without requesting the permissions

### Privacy Policy
COVID Alert PA protects your privacy and personal information. Downloading the app is voluntary, but the more Pennsylvanians that use this app, the more successful our efforts will be to stop the spread of COVID-19.
  - The app detects if users are in close contact with another app user, using Bluetooth Low Energy (BLE) technology. It is the same technology that your phone uses to connect to wireless headphones or your car.
  - The app does not use GPS, location services, or any movement or geographical information.
  - The app will never collect, transmit, or store your personal information and is completely anonymous.
https://www.health.pa.gov/topics/disease/coronavirus/Pages/COVIDAlert.aspx#privacy

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but after running the analysis we see that the has read/write permissions to the external storage which any app can access which allows for data injection and reading any data that the app writes to external storage.

### Ghera Vulnerabilities
[False Positive] The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 

### Deeper Analysis
- `WakeUpService` is protected by a permission, but the protection level of the permission should be checked.
  - Permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- `ExposureNotificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - Permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- `WorkManagerGcmService` is protected by a permission, but the protection level of the permission should be checked.
  - Permission: ``com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE``
  - This permission is maintained by Google
- `SystemJobService` is protected by a permission, but the protection level of the permission should be checked.
  - permission: ``android.permission.BIND_JOB_SERVICE``
  - This permission is protected by signature level protection where in which the system can only accepted by the system if the requesting app and the current application have the same signature. 
- `DiagnosticsReceiver` Broadcast Receiver is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="android.permission.DUMP"`
  - This is protected by system ([Android documentation](https://developer.android.com/reference/android/Manifest.permission#DUMP))
- `FirebaseInstanceIdReceiver` Broadcast Receiver is protected by a permission, but the protection level of the permissio should be checked.
  - Permission: `com.google.android.c2dm.permission.SEND`
- [False Positive] At first glance it seems that the IP Address is being disclosed however the app is just using a format similar to the ip addresses x.x.x.x format. We can see that it is not actually IP addresses because the constants that are used in the code come in various forms some being in the x.x.x.x.x.x.x.x.x format which is clearly not an ip address
- Next is the rawQuery SQL vulnerability which will allow for sql injection as a function is provided that directly takes an string as an argument and puts it in to the sql database using a rawQuery.
- The big vulnerability in the app is that it uses the SHA-1 hash function which is known to be very vulnerable. this should instead be replaced with a SHA-256 hash which is a lot more secure.
- Another big vulnerability is that the app is accessing websites using an HTTP connection this is outdated and HTTPS should be used since HTTP connections are vulnerable to attack.
- The app can also read/write to external storage which leaves it vulnerable to data injection and any data that is written to the external storage by the app can be read by any other app
- The app uses an insecure Random Number Generator. While this isn't too much of a vulnerability the app should be updated to use SecureRandom.
