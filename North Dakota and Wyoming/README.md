<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert ND&WY Analysis (Minqi) 
### APK Basic Info
App: Care19 Alert_1.2_apkcombo.com.apk (You can find this apk file and its obfucated source code in this folder). The report from MobSF, ```ND&WY_MobSF_report.pdf```, is also inside this folder. 

```
APK Signature:
MD5: cd23393dda79fd4987d6fe5bc8505611
SHA1: 140de96c739c41e7db117ea5dc628b4ec5f67a23
SHA256: 2bbe4e971a4d98b6e96ba82227b3964103135ae069b4a4cdf430e1d40543a2b2
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)
  - C2DM permissions(com.google.android.c2dm.permission.RECEIVE)
  - Unknown permission(com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE) This permission is required by Firebase Analytics for the reporting of install referrer campaign information. It is a requirement from Play Install Referrer API

### MANIFEST ANALYSIS
 - Broadcast Receiver
   - False Positive. The permission is mained by the Google API used.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE [android:exported=true]
    - Permission: android.permission.DUMP [android:exported=true]
    - False positive bacause the above permissions are only used by Android System; and we assume that the system is not malicious.

<!-- ###
Sidenotes: It looks like BIND_JOB_SERVICE and DUMP are requested without declared in the Manifest

DUMP: Allows an application to retrieve state dump information from system services. Not for use by third-party applications.
### -->

 
### Privacy Policy
- Care19 Alert respects your privacy and does not ask you to provide personal details, such as name, email, phone number, or address. The Care19 Alert application does not collect location data.

https://www.care19.app/alert/privacy

### Privacy Violations
The app says no location info collected. 

In `androidx/appcompat/app/TwilightManager.smali -> isNight()Z`, the assembly code called getLastKnowLocation(). The source code can be found in `androidx\appcompat\app\TwilightManager.java`. After checking all the code, the location info that accquired here has never been passed outside. So altough the location is asscessed, it has never been stored for other use.

In `com\proudcrowd\exposure\viewmodel\ExposureViewModel.java`, LocationManager is also used. Here the location is accuqired from FirebaseAnalytics.
<!-- - This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function c(), from line 602 to 672, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time. -->

<!-- Therefore, this is clearly a violation of the privacy policy made on the app official website. -->

### CODE ANALYSIS
<!-- - The App logs information. Sensitive information should never be logged. -->
- SHA-1 is a weak hash known to have hash collisions. But SHA-1 is used in `com/bugfender/sdk/a/a/e/d.java`, which imposes potential security threat and should not be used anywhere. Although this is due to the third-party code, the developers cannot always assume the third-party is save and it's their responsibility to make sure there's no potential security leak in the third-party code they used.
- The App uses an insecure Random Number Generator in `com/bugfender/sdk/a/a/m/a.java`, `java.util.Random`. This should be replaced by `java.security.SecureRandom` or any other secure random number generator.
- Diagonsis key files are downloaded and writed to External Storage in `com/proudcrowd/exposure/datasource/ExposureDownloadDataSource.java`. Any App can read data written to External Storage.
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
<!-- - [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `b/s/f.java`, when there is a `execSQL()`, the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe. There is another variable `f2464b` contained an array of Strings. After manually checked all the places that uses this f class:
  ```
  .\gov\michigan\MiCovidExposure\storage\ExposureNotificationDatabase_Impl.java
  .\androidx\work\impl\WorkDatabase_Impl.java
  ```
  The input string array used in both file is hardcoded and then passed to `f2464b`; therefore, this variable should be safe from any injection as well.
- [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `b/q/d.java`, the function `public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str)` creates the temp file to temperarely store the data from ZipFile input stream.
  - In `b/s/l.java`, the function `public final void a(File file)` uses the temp file to store the input `file`. This function is called in `b\s\l.java` function `public final void b()` to copy database file.
  - In both case, the temperary files are deleted after use. -->


<!-- ### Crypto files
```
c/b/c/a/m0/d.java ECB and CTR used
c/b/c/a/m0/a.java ECB used here
c/b/c/a/m0/g.java CTR mode
``` -->

### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.
<!-- 
### URL
HTTP Connection made in `c/a/b/x/f.java`, and http URL find is `http://www.michigan.gov/coronavirus`. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the server forces HTTPS on its end after manually testing.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here. -->
