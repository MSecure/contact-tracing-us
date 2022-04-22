<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert CO Analysis (Minqi) 
### APK Basic Info
App: `CO Exposure Notifications_vminted1000003_apkpure.com.xapk` (You can find this apk file and its obfucated source code in this folder). The report from MobSF, ```CO_MobSF_report.pdf```, is also inside this folder. 

```
APK Signature:
MD5: 05fe369de5ff42442f6e1036d48d114d
SHA1: f727762c5a53d2566ed84116df1a5b474ff954d8
SHA256: ba31125e4944b02b3eaec267e5bc890940f0d91c03e1a098fa0f83b57e436fd5
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
 - Service 
    - Permissions
      - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
      - Permission: android.permission.DUMP[android:exported=true]
      - These two are possibly false positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.
    - `com.google.android.play.core.assetpacks.AssetPackExtractionService` is not Protected
      - This service is provided by Google as part of the Android API.


 
### Privacy Policy
- CO Exposure Notifications is the official Exposure Notifications app of Colorado and the Colorado Department of Public Health and Environment. Exposure Notifications is a voluntary new service developed in partnership with Google and Apple to help slow the spread of COVID-19. No GPS, location information or personal identifiers will ever be collected, stored or shared by this service. 

https://cdphe.colorado.gov/exposure-notifications-privacy-policy

### Privacy Violations
The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `e/b/a/m.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function `c()`, from line 480 to 553, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

Therefore, this is clearly a violation of the privacy policy made on the app official website.

~~Although this function might be just a Twilight Manager that uses location to calculate the sun rise/down time.~~
Method `c()` is found to have a high degree of resemblance to method `getLastKnowLocation()` and `updateState()` in `androidx\appcompat\app\TwilightManager.java` from `Covid Alert ND & WY_v1.2 `. It is believed that method `c()` is implementing a self-difined `isNight()`, although the reason why they would need this method remains unknown. Yet the app has never the less violating the privacy policy by accessing location of the user in method `c()`. See the code comparison in `comparison.md` under this folder.

In addition, this app includes code for collecting and handling biometrics information, for example in `e/d/w.java`.

### CODE ANALYSIS
- The App uses an insecure Random Number Generator, java.util.Random. This should be replaced by java.secure.SecureRandom.
  - h/a/j1/f0.java
    h/a/k1/g.java
    h/a/j1/h0.java
    h/a/j1/n2.java
    h/a/n1/a.java
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- App can read/write to External Storage. Any App can read data written to External Storage.
    - In `f/b/a/f/a/b/b2.java`, this app access the file located at the path returned by `getExternalFilesDir(null)`.
    - This app does not include the `android:name="android.permission.WRITE_EXTERNAL_STORAGE"` permission in the manifest. This means that the user is not directly notified that the application is accessing external storage.
- The app uses the encryption mode CBC with PKCS5/PKCS7 padding. This configuration is vulnerable to padding oracle attacks.
  - [This Ghera vulnerability](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-NonRandomIV-InformationExposure-Lean/) relates to encryption with a non-random initialization vector. This instance is initialized with the "androidxBiometric" key from the KeyStore. In addition, since this encryption mode uses padding, it is vulnerable to [padding oracle attacks](https://en.wikipedia.org/wiki/Padding_oracle_attack) using the Android `BadPaddingException` as the padding oracle.
<!-- - [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `b/s/f.java`, when there is a `execSQL()`, the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe. There is another variable `f2464b` contained an array of Strings. After manually checked all the places that uses this f class:
  ```
  .\gov\michigan\MiCovidExposure\storage\ExposureNotificationDatabase_Impl.java
  .\androidx\work\impl\WorkDatabase_Impl.java
  ```
  The input string array used in both file is hardcoded and then passed to `f2464b`; therefore, this variable should be safe from any injection as well. -->
<!-- - [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `b/q/d.java`, the function `public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str)` creates the temp file to temperarely store the data from ZipFile input stream.
  - In `b/s/l.java`, the function `public final void a(File file)` uses the temp file to store the input `file`. This function is called in `b\s\l.java` function `public final void b()` to copy database file.
  - In both case, the temperary files are deleted after use. -->




### SERVER LOCATIONS
- This app has one server located in the Netherlands, and one located in Columbia. The reason for servers located in these regions is unclear.

### URL
Lots of http URLs found in the app. Most of them are android/google sites or other open source websites. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the servers forces HTTPS on server's end after manually testing. For a full list of the HTTP URLs, please check the URL section `CO_MobSF_report.pdf`.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
