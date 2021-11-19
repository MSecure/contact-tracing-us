<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert NC Analysis (Minqi) 
### APK Basic Info
App Name: SlowCOVIDNC
Apk Name: SlowCOVIDNC_1.6_apkcombo.com.apk (You can find this apk file and its obfucated source code in this folder). More detailed info can be found in the report from MobSF, ```MI_MobSF_report.pdf```, which is also inside this folder. 

```
MD5: b69f2a404980f66f00ea1b8aa951621d
SHA1: 1d47a8aee251ee5521fce2e31e4464544690d7fc
SHA256: 683b42f6e5a708c48e1b708e81549511d2803654e82a92301f3b7072d7fbfd40
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
   - False Positive. The permission is mained by the Google API used.
   <!-- - list of such Broadcast Receiver:
     - gov.nc.dhhs.exposurenotification.nearby.ExposureNotificationBroadcastReceiver
     - com.google.android.gms.nearby.exposurenotification.WakeUpService -->
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - These two are possibly false positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.

<!-- ###
Sidenotes: It looks like BIND_JOB_SERVICE and DUMP are requested without declared in the Manifest

DUMP: Allows an application to retrieve state dump information from system services. Not for use by third-party applications.
### -->

 
### Privacy Policy
- NCDHHS oversees public health efforts throughout the State of North Carolina. The SlowCOVIDNC app is intended for use to supplement state and local public health officials' contact tracing efforts in response to COVID-19. Public health officials use contact tracing to reach out to people who have been exposed to COVID-19 to offer support. The SlowCOVIDNC app enables users to store anonymous data collected and processed by the app for the purposes of notifying users of potential exposures on the respective user’s mobile device. The SlowCOVIDNC app can also notify users if they have been exposed to a COVID-19-infected individual and provide instructions on how and where to get tested.

https://covid19.ncdhhs.gov/slowcovidnc/slowcovidnc-privacy-policy

### Privacy Violations
The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `b/b/k/i.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function `C0006i.c()`, from line 620 to 686, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

Therefore, this is clearly a violation of the privacy policy made on the app official website.

### CODE ANALYSIS
- Application is signed with v1 signature scheme, making it vulnerable to Janus vulnerability on Android <7.0
<!-- - The App logs information. Sensitive information should never be logged. -->
- The App uses an insecure Random Number Generator, java.util.Random in e/b/f/b.java
- AES/ECB mode used for encryption in `c/b/c/a/m0/a.java`
- [*False Positive*] ~~IP Address disclosure.~~ This is just checking the version of a browser. gov/nc/dhhs/exposurenotification/nearby/ProvideDiagnosisKeysWorker.java
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `b/r/f.java`, when there is a `execSQL()`, the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe. 
  The input string array used in function `internalInitInvalidationTracker` in `/b/r/h.java` is hardcoded and then passed to `f1606b` in `b/r/f.java`; therefore, this variable should be safe from any injection as well.
- [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `b/p/d.java`, the function `public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str)` creates the temp file to temperarely store the data from ZipFile input stream.
  - In `b/r/l.java`, the function `public final void a(File file)` uses the temp file as a buffer. This function is called in `b\r\l.java` function `public final void b()` to copy database file.
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
HTTP Connection made in `c/a/b/x/f.java` and `e/b/f/c.java`, and http URL find is `http://schemas.android.com/apk/res/android` and `http://www.google.com`. This might leak some info when requesting. An secure app should enforce HTTPS at all time.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
