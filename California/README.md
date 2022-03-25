# Covid CA Notify App(Mihir Madhira)

## APK Info
This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file. 
```
  APK Signature:
  MD5: 0c91c6d718ac6f2b71ab183d26a42d6d
  SHA-1: 5c6799da2ba27769a0dd4be60fc2af85002ef616
  SHA-256: ad11797f06bf933b7d436f0ff633b3a083fa173b329278542c8acd4d77bbe94a
```

## App Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## Privacy Policy:
CA Notify has the potential to help stop the spread of the infection and its use is 
highly encouraged, but it is completely voluntary.

Users may turn the system on or off at any time, or uninstall the app on an Android device. 
The system does not collect, track or store users’ location, GPS information, or personal 
information.

This is the Privacy Policy for CA Notify app for Covid Tracing: https://canotify.ca.gov/privacy/

- only data used are the anonymous keys, Bluetooth signal strength, and date and duration of
exposure
- CA Notify does not collect or exchange any personal information
- Never shares user's keys with the system unless the user elects upon doing so, also a user's
keys changes randomly to protect the user's identity. *key = generated numbers shared via 
Bluetooth
- each day collects all the keys sent over voluntarily and checks with other keys the past
14 days for possible exposures and sends a notification accordingly
- accesses the IP address and collects them for analytical purposes and later anonymizes it 
for security purposes
- If the user uninstalls or deactivates CA Notify all keys currently stored on the device 
will be immediately deleted.
- When anonymous keys are released, the notifications that may be generated do not disclose 
the COVID-19 positive user’s identity, location, phone number, or any other personal 
information.
- information will not include any personal or location information, nor can it be 
used to identify any system user.

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

## Server Locations:
- Most servers exist within the US except for 2 of them: one exists in Districto Capital de Bogoto, Colombia and another in Maharastra, India. 

## Privacy Policy Violations:
- [False Positive] ~~The Privacy Policy says that the app doesn't store private information however after running the analysis, it says the app inserts Sensitive Information into a Log File. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x05d-Testing-Data-Storage.md#logs)~~ After looking through each file, there were no sensitive information recorded and only String constants were recorded. 
- The app uses Java's library, `java.util.Random`, this library uses a protected algorithm to generate 32 pseudorandom bits: https://developer.android.com/reference/java/util/Random.-> should use SecureRandom Generator (this is a small error apart of Code Vulnerability).
- [False Positive]~~retains keys and other sensitive information into its files evnetough it supposed to~~ a string constant was input in the file `h/a/k1/f.java`. 
- In the `e\b\a\m.java` file, Location is retrieved with the use of ``location.getLatitude()`` and location `location.getLongitude()`; however, in the Privacy Policy, it clearly states that no data regarding location will be collected about their users.

## Network Vulnerability
- uses HTTP instead of HTTPS when applying code from open source websites such as from `mikepenz.com`, `http://schemas.android.com/apk/res/android`, or `http://github.com/google/auto` which can be very susceptible to man-in-the-middle attacks or SQL Injections.

## Ghera Violations:
- [False Positive]~~This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)~~ All inputs into the rawSQL methods are just constants and none of them are actual sql commands. 




 

