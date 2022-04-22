# Wisconsin Exposure Notification Analysis

## APK Info

This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file.
```
APK Signature:
md5: 572ee2b3302b8198828de574a7121cde
sha1: 56af2697b0ec10bd5a175e4e32a4d044a02bcf1c
sha256: f3e7d1752b302813da92a62402f1d1542a8050e663f8ca2820488b8ce5c3ad75

```

## App's Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``
- Biometric: `<android.permission.USE_BIOMETRIC/>`
- Finger Print: `<android.permission.USE_FINGERPRINT/>`

## WI Privacy Policy:
This is the Privacy Policy for WI Exposure Notification app for Covid Tracing: https://www.dhs.wisconsin.gov/covid-19/app-privacy.htm

- The app does not collect nor exchange personal information or identifiable information such as location, DOB, etc.
- The only data shared is the randomly generated bluetooth keys, date and duration of the exposure, and Bluetooth signal strength
- Whenever a user tests positive for covid, he or she can elect to share this information with other users on the app 
  - those keys are later cross checked by the other users on the platform to see if they had an encounter with that person with that specific key
  - sharing of keys and information is also completely voluntary and can be decided by the user
  - if yes, the app shares exposure data with that user for public health reasons
- the keys are constantly recycled every 14 days for security reasons
- the following data is collected upon request: 
  - App installation and deletion metrics
  - Exposure notification metrics
  - Exposure notification interaction metrics
  - Key upload metrics
  - Verification code metrics
  - Anonymous keys that have been voluntarily shared
- Information collected may be shared with public health authorities and also will be used to improve the performance of the app
- Intended for people 18 years or older
- There will be constant changes to the privacy policy over time, so whenever a change is made all users will be notified readily

## Manifest Analysis
- Broadcast Receiver: ``com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver`` is protected by a permission but the protection level should be checked
- Service: ``com.google.android.gms.nearby.exposurenotification.WakeUpService`` is protected by a permission but the permission level should also be checked
  - permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- Service: ``androidx.work.impl.background.systemjob.SystemJobService`` is protected by a permission but the protection level of the permission should be checked
  - permission: ``android.permission.BIND_JOB_SERVICE``
  - This permission is protected by signature level protection where in which the system can only accepted by the system if the requesting app and the current application have the same signature. 
- Broadcast Receiver: ``androidx.work.impl.diagnostics.DiagnosticsReceiver`` is protected by a permission but the protection level of the permissio should be checked
  - permission: `android.permission.DUMP`
- Service: `com.google.android.play.core.assetpacks.AssetPackExtractionService` is not protected and is exported leaving accessible to other apps on the device
- Broadcast Receiver: `com.google.android.apps.exposurenotification.nearby.SmsVerificationBroadcastReceiver` is protected by a permission but the protection level to the permission should be checked
  - permission: `com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK`

## Server Locations:
- Most servers exist within the US except for 1 of them: Noord-Holland, Neatherlands.

## Coding Vulnerabilities:
- [False Positive] ~~The Privacy Policy says that the app doesn't store private information however after running the analysis, it says the app inserts Sensitive Information into a Log File. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x05d-Testing-Data-Storage.md#logs)~~ After looking through each file, there were no sensitive information recorded and only String constants were recorded. 
- The app uses Java's library, `java.util.Random`, this library uses a protected algorithm to generate 32 pseudorandom bits: https://developer.android.com/reference/java/util/Random, but instead it should use SecureRandom Generator (this is a small error apart of Code Vulnerability).
- [False Positive]~~This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)~~ All inputs into the rawSQL methods are just constants and none of them are actual sql commands. 
- In file ``e/d/w.java`` line 37, the app uses CBC encryption mode with PKCS5/PKCS7 padding which can be vulnerable to padding oracle attacks. Also, `AES/CBC/PKCS7PADDING` is considered to be deprecated and should no longer be used according to [Android developer website](https://developer.android.com/guide/topics/security/cryptography#bc-algorithms)
- In file `f/b/a/f/a/b/b2.java` line 44, the app writes to external storage which can lead to other apps or hackers accessing that information on the device.
  - The file being called from external storage is being called in this line `b2.getExternalFilesDir(null)`

## Privacy Policy Violation:
- in `e\b\a\m.java`, they use functions such as Location.getLatitude() and Location.getLongitude(). Both of these functions access and retrieve the location data of the user which in the privacy policy said it wouldn't do. 

## Network Vulnerability
- uses HTTP instead of HTTPS when applying code from open source websites such as from `mikepenz.com`, `http://schemas.android.com/apk/res/android`, or `http://github.com/google/auto` which can be very susceptible to man-in-the-middle attacks or SQL Injections.






