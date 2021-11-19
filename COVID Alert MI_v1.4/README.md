<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert MI Analysis (Minqi) 
### APK Basic Info
App: MI COVID Alert_1.4_apkcombo.com.apk (You can find this apk file and its obfucated source code in this folder). The report from MobSF, ```MI_MobSF_report.pdf```, is also inside this folder. 

```
MD5: 7a09c47bfedfa7ae69fb22b455b065a6
SHA1: 2090ade76f5b2c68d34cb6d42650c24c71ad3814
SHA256: e85ec2bf31c642bc0bfcefa384c34dd29cae1229b0279af0a44df9d3251bfa6d
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)

### MANIFEST ANALYSIS
 - Broadcast Receiver
   ~~- False Positive. The permission is mained by the Google API used.~~ 
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
   <!-- - Detail: (gov.michigan.MiCovidExposure.nearby.ExposureNotificationBroadcastReceiver) is Protected by a permission, but the protection level of the permission should be checked.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true] -->
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - These two are possibly false positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.

<!-- ###
Sidenotes: It looks like BIND_JOB_SERVICE and DUMP are requested without declared in the Manifest

DUMP: Allows an application to retrieve state dump information from system services. Not for use by third-party applications.
### -->

 
### Privacy Policy
- The MI COVID Alert app is intended for use to help facilitate contact tracing in response to COVID-19. Contacts who receive push notifications of past potential exposure will be given the option to be put in contact with Public Health and may be subsequently enrolled in contact monitoring. Contact tracing consists of notifying and monitoring individuals who have been in close contact with someone who is infected with a virus and could potentially infect others.

https://www.michigan.gov/coronavirus/0,9753,7-406-99891_102592_102596---,00.html

### Privacy Violations
The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `b/b/k/i.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function c(), from line 602 to 672, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

Therefore, this is clearly a violation of the privacy policy made on the app official website.

### CODE ANALYSIS
- Application is signed with v1 signature scheme, making it vulnerable to Janus vulnerability on Android <7.0
<!-- - The App logs information. Sensitive information should never be logged. -->
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `b/s/f.java`, when there is a `execSQL()`, the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe. There is another variable `f2464b` contained an array of Strings. After manually checked all the places that uses this f class:
  ```
  .\gov\michigan\MiCovidExposure\storage\ExposureNotificationDatabase_Impl.java
  .\androidx\work\impl\WorkDatabase_Impl.java
  ```
  The input string array used in both file is hardcoded and then passed to `f2464b`; therefore, this variable should be safe from any injection as well.
- [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `b/q/d.java`, the function `public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str)` creates the temp file to temperarely store the data from ZipFile input stream.
  - In `b/s/l.java`, the function `public final void a(File file)` uses the temp file to store the input `file`. This function is called in `b\s\l.java` function `public final void b()` to copy database file.
  - In both case, the temperary files are deleted after use.


<!-- ### Crypto files
```
c/b/c/a/m0/d.java ECB and CTR used
c/b/c/a/m0/a.java ECB used here
c/b/c/a/m0/g.java CTR mode
``` -->

### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
HTTP Connection made in `c/a/b/x/f.java`, and http URL find is `http://www.michigan.gov/coronavirus`. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the server forces HTTPS on its end after manually testing.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
