# WA Notify Analysis

## APK Info
This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file. 
```
  APK Signature:
  MD5: f99f9ea23666c8688c3f7194e046b674
  SHA1: e6e41e81e21499573e11f80910a0a56a5a90499d
  SHA256: 579d75c6276c8cd818288a136944ba72bcc6b3e4b5168702f5da9cf9b7c1c028
```

## App's Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## WA Privacy Policy:
This is the Privacy Policy for WA Notify app for Covid Tracing: https://doh.wa.gov/emergencies/covid-19/wa-notify/privacy-policy
- containing data elements that can't be used to detect an individual	
	- Random Codes: these hashed codes are stored 14 days and then 
	  shared via bluetooth to check for possible exposure.
	- Verification Link: pops up after given verification code once 
	  an individual is tested positive and the link is only voluntarily
	  give out.
	- Usage Logs: these logs are generated within the phone and work like
	  any other apps usage logs. They are also stored for about
	  14 days as well.
	- Analytics Data: you can choose if the app can collect extra data 
	  about you and collects info of how smartphone is used
- protects info using Google's exposure Notification Framework which stores and
generates codes
- Phones allows you to delete exposure logs and turn off exposure notifications

## Manifest Analysis:
- Activity: ``com.google.android.apps.exposurenotification.notify.ShareDiagnosisActivity`` is not protected
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
- Most servers exist within the US except for 3 of them: one exists in Districto Capital de Bogoto, Columbia; Dublin, Ireland; and Noord-Holland, Neatherlands. 

## Privacy Violation:
- [False Positive]~~The Privacy Policy says that it doesn't log private info, however according to the reportit logs sensitive info~~ After looking through each file, there were no sensitive information recorded and only String constants were recorded. 
- [False Positive]~~Private information like username, password, and keys are hardcoded~~ the file doesn't hardcode any keys, the line in which the error came is this one: StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value=");. str4 is a string object that decodes the bytes set from bArr2 using the charset from f.b.b.a.d.a in the line: String str4 = new String(bArr2, f.b.b.a.d.a);. Clearly the inputed value is not any constant from these two lines.  
- The app uses Java's library, `java.util.Random`, this library uses a protected algorithm to generate 32 pseudorandom bits: https://developer.android.com/reference/java/util/Random.-> should use SecureRandom Generator (this is a small error apart of Code Vulnerability).
- In the `e\b\a\m.java` file, Location is retrieved with the use of ``location.getLatitude()`` and location `location.getLongitude()`; however, in the Privacy Policy, it clearly states that no data regarding location will be collected about their users.

## Network Vulnerability:
- uses HTTP instead of HTTPS when applying code from open source websites such as from `mikepenz.com`, `http://schemas.android.com/apk/res/android`, `http://github.com/google/auto` which can be very susceptible to man-in-the-middle attacks or SQL Injections. 20 websites in total are written in http

## Code Vulernabilities:
- In `f/b/c/k/t.w0.java`, the method a(Object obj) throw a Throwable object th, but the Throwable object was never initialized and it's thrown after the return statement ~ redundant code

## Ghera Vulnerabilities:
- [False Positive]~~This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)~~ All inputs into the rawSQL methods are just constants and none of them are actual sql commands. [TODO: look into ths and what it might be]

