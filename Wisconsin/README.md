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
- Activity: ``com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity`` is not protected
  - On line 41 in SharedDiagnosisActivity.java file, in the onActivityResult method it creates a bundle to allow it to share data amongst other activities in the application
  - TODO: need to do more research into if there can be a plausible vulnerability from this 
- Broadcast Receiver: ``com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver`` is protected by a permission but the protection level should be checked
- Broadcast Receiver: ``com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver`` is not protected, an intent filter exists 
  - This broadcast receiver allows the app to dismiss notifications for the appliation by changing the shared preferences as shown in lines 16-19 where the app accordingly changes the shared preference based on if the Intent is a "Notification_Dissmissed_Action_ID".
  - The lack of a permission to protect the DismissedReceiver allows a malicious app to send Intents that access and change the sharedPreferences of the app
- Service: ``com.google.android.gms.nearby.exposurenotification.WakeUpService`` is protected by a permission but the permission level should also be checked
  - permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- Service: ``androidx.work.impl.background.systemjob.SystemJobService`` is protected by a permission but the protection level of the permission should be checked
  - permission: ``android.permission.BIND_JOB_SERVICE``
  - This permission is protected by signature level protection where in which the system can only accepted by the system if the requesting app and the current application have the same signature. 
- Broadcast Receiver: ``androidx.work.impl.diagnostics.DiagnosticsReceiver`` is protected by a permission but the protection level of the permissio should be checked
  - permission: `android.permission.DUMP`




