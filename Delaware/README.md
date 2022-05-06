# DE Covid Track App Analysis

## App Permissions:
- Internet: `<android.permission.INTERNET/>`
- Bluetooth: `<android.permission.BLUETOOTH/>`
- Access Network State: `<android.permission.ACCESS_NETWORK_STATE/>`
- Wifi State: `<android.permission.ACCESS_WIFI_STATE/>`
- Vibrate: `<android.permission.VIBRATE/>`
- Recieve Boot Completed: `<android.permission.RECEIVE_BOOT_COMPLETED/>`
- Foreground Service: `<android.permission.FOREGROUND_SERVICE/>`

## Privacy Policy:
https://coronavirus.delaware.gov/wp-content/uploads/sites/177/2020/09/COVID-Alert-Terms-082720-.pdf
- containing data elements that can't be used to detect an individual
	- Random Codes: these hashed codes are stored 14 days and then 
	  shared via bluetooth to check for possible exposure.
	- Verification Link: pops up after given verification code once 
	  an individual is tested positive and the link is only voluntarily
	  give out.
	- Usage Logs: these logs are generated within the phone and work like
	  any other apps usage logs. They are also stored for about
	  14 days as well.
	- Analytics Data: you can choose if the android.permission.VIBRATEapp can collect extra data 
	  about you and collects info of how smartphone is used
- protects info using Google's exposure Notification Framework which stores and
generates codes
- Phones allows you to delete exposure logs and turn off exposure notifications

## Manifest Analysis: 
- Broadcast Receiver: `com.dieam.reactnativepushnotification.modules.RNPushNotificationBootEventReceiver` is not protected 
  - Intent filter exists with this action `<action android:name="android.intent.action.BOOT_COMPLETED" />`
- Broadcast Receiver: `ie.gov.tracing.nearby.ExposureNotificationBroadcastReceiver` is protected by a permission but the protection level should be checked
  - permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
- Service: ``com.google.android.gms.nearby.exposurenotification.WakeUpService`` is protected by a permission but the permission level should also be checked
  - permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- Broadcast Receiver: `androidx.work.impl.background.gcm.WorkManagerGcmService)` is protected by a permission but the protection level to the permission should be checked
  - permission: `com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE`
- Service: ``androidx.work.impl.background.systemjob.SystemJobService`` is protected by a permission but the protection level of the permission should be checked
  - permission: ``android.permission.BIND_JOB_SERVICE``
  - This permission is protected by signature level protection where in which the system can only accepted by the system if the requesting app and the current application have the same signature. 
- Broadcast Receiver: ``androidx.work.impl.diagnostics.DiagnosticsReceiver`` is protected by a permission but the protection level of the permissio should be checked
  - permission: `android.permission.DUMP`
- Broadcast Receiver: ``com.google.firebase.iid.FirebaseInstanceIdReceiver`` is protected by a permission but the protection level of the permissio should be checked
  - permission: `com.google.android.c2dm.permission.SEND`

## Privacy Violations:
- ~~it discloses the ip address in 6 of the files in the code which clearly violates its policy of not sharing private information.~~[False Positive] Inputed constants
- The app uses Java's library, `java.util.Random`, this library uses a protected algorithm to generate 32 pseudorandom bits: https://developer.android.com/reference/java/util/Random.-> should use SecureRandom Generator (this is a small error apart of Code Vulnerability).
- In `androidx/appcompat/app/k.java`, Location is retrieved with the use of ``location.getLatitude()`` and location `location.getLongitude()`; however, in the Privacy Policy, it clearly states that no data regarding location will be collected about their users as part of the TwilightManager

## Network Vulnerability
- uses HTTP instead of HTTPS for one of the websites: `http://schemas.android.com/apk/res/android`

## Code Analysis:
- In `h/c/d/k/c.java`, uses SHA-1 Hash which leads to collisions, it should use any of the hash algorithms from the SHA-2 family
- In files `f/h/e/a.java, h/c/d/i/a.java, f/h/e/b.java, h/c/b/b/a.java` , the app writes to external storage which can lead to other apps or hackers accessing that information on the device.
  - These files either retrieve directories from external storage via `getExternalStorageDirectory()` or retrieve files via lines as such `getExternalFilesDir(str)` both are dangerous for outside attackers who can easily write into these files or export them


## Ghera Vulnerabilities:
- It reads and retrieves data from external storage which any other app can access to using the function getFromExternalDir
- It also uses the SHA-1 hash table which is really weak and causes collisions and should use SHA-256

