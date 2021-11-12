### Summary:

This app uses the Exposure API developed by Apple and Google jointly. If you are within 6 feet of another person with the app for 10 minutes, your phone exchanges a secure Bluetooth token (code) with that person's. Then, if that person gets COVID, you get a notification that you were exposed- because you have their token. There is NO way for this app to see your location. There is NO tracking of your location through the app. It does NOT compromise bluetooth. This app can save lives.

### App Permissions:

From Android Manifest.xml:

android.permission.ACCESS_NETWORK_STATE
android.permission.BLUETOOTH
android.permission.FOREGROUND_SERVICE
android.permission.INTERNET
android.permission.RECEIVE_BOOT_COMPLETED
android.permission.WAKE_LOCK

### Manifest Analysis

ShareDiagnosisActivity
<activity android:name="com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity" android:exported="true" android:windowSoftInputMode="adjustResize|stateHidden" android:parentActivityName="com.google.android.apps.exposurenotification.home.ExposureNotificationActivity">

A malicious intent can be passed due to the lack of android permission.

ExposureNotificationBroadcastReceiver
False Positive. The permission is mained by the Google API used.


### Privacy Policy:

COVID Alert CT allows users to send and receive notifications of a potential high-risk exposure to COVID-19, in a privacy-preserving manner. The notifications will include instructions on who to contact and next steps to take. 

The exposure notifications are intended to supplement the conventional contact tracing efforts undertaken by local public health authorities involving contact by a caseworker. 

https://portal.ct.gov/coronavirus/COVIDAlertCT/PrivacyPolicy

### Privacy Violations

Despite stating: "The system does not collect, track or store users’ location, GPS information, or personal information,"
the app uses GPS location API in e/b/a/m.java.

This file imports and uses android.location.Location, android.location.LocationManager
The function c(), from line 472 to 545, access android.permission.ACCESS_COARSE_LOCATION and android.permission.ACCESS_FINE_LOCATION permissions. Neither of the permissions here are declared in the manifest file.
The function above uses getLastKnownLocation("network") to access the location where the user connects to the Internet last time.
Therefore, this is clearly a violation of the privacy policy made on the app official website.

### Server Locations
No suspicious servers or suspicious location of servers find here.

### URL
http://ct.gov/covidalertct

### Code Analysis
Application is signed with v1 signature scheme, making it vulnerable to Janus vulnerability on Android <7.0
[False Positive] Files may contain hardcoded sensitive information like usernames, passwords, keys etc. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
[False Positive]App uses SQLite Database and execute raw SQL query.
In e/t/k.java, when there is a execSQL(), the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe.