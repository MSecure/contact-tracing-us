<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert Guam Analysis (Minqi) 
### APK Basic Info
App: `Guam Covid Alert_1.0.10_apkcombo.com.apk` (You can find this apk file and its obfucated source code in this folder). The report from MobSF, ```Guam_MobSF_report.pdf```, is also inside this folder. 

```
APK Signature:
MD5: 05fe369de5ff42442f6e1036d48d114d
SHA1: f727762c5a53d2566ed84116df1a5b474ff954d8
SHA256: ba31125e4944b02b3eaec267e5bc890940f0d91c03e1a098fa0f83b57e436fd5
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - view Wi-Fi status (android.permission.ACCESS_WIFI_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - control vibrator (android.permission.VIBRATE)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)

### MANIFEST ANALYSIS
 - MainActivity is not protected.
   - org.pathcheck.covidsafepaths.MainActivity is not protected. [android:exported=true]
 - ~~Broadcast Receiver~~
   - [*False Positive*]. The permission is mained by the Google API used.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
 - ~~Service~~ 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - [*False Positive*] bacause these two permission are only used by Android System; and we assume that the system is not malicious.


 
### Privacy Policy
- DPHSS oversees public health efforts throughout Guam. The Guam Covid Alert is intended for use to facilitate contact tracing in response to COVID-19. Contact tracing consists of notifying and monitoring individuals who have been in close contact with someone who is infected with a virus and could potentially infect others. The Guam Covid Alert allows users to store data collected and processed by the App for the purposes of contact tracing locally on the respective user’s mobile device. The Guam Covid Alert can notify users if they have been exposed to a COVID-19-infected individual and provide instructions on how and where to get tested.
- Random codes for close contacts are stored in a user’s device for 14 days. No personally identifiable or location information is collected, stored, or exchanged.

https://guamcovidalert.guam.gov/resources/privacy-policy/

### Privacy Violations
<!-- The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `e/b/a/m.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function `c()`, from line 480 to 553, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

Therefore, this is clearly a violation of the privacy policy made on the app official website.


~~Although this function might be just a Twilight Manager that uses location to calculate the sun rise/down time.~~
Method `c()` is found to have a high degree of resemblance to method `getLastKnowLocation()` and `updateState()` in `androidx\appcompat\app\TwilightManager.java` from `Covid Alert ND & WY_v1.2 `. It is believed that method `c()` is implementing a self-difined `isNight()`, although the reason why they would need this method remains unknown. Yet the app has never the less violating the privacy policy by accessing location of the user in method `c()`. See the code comparison in `comparison.md` under this folder. -->

### CODE ANALYSIS
- (?) The code might have used a constant seed in `com/pedrouid/crypto/RandomBytesModule.java`
<!-- - The App uses an insecure Random Number Generator, java.util.Random. This should be replaced by java.secure.SecureRandom.
  - h/a/j1/f0.java
    h/a/k1/g.java
    h/a/j1/h0.java
    h/a/j1/n2.java
    h/a/n1/a.java
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists. -->
- [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `com/reactnativecommunity/asyncstorage/ReactDatabaseSupplier.java`, line 76, the raw SQL executed is a single string.

- The App uses an insecure Random Number Generator in `org/matomo/sdk/Tracker.java`. They should used `java.security.SecureRandom` instead.

- The App uses ECB mode in Cryptographic encryption algorithm. `com/bottlerocketstudios/vault/keys/wrapper/ObfuscatingSecretKeyWrapper.java`
<!-- - [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `b/q/d.java`, the function `public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str)` creates the temp file to temperarely store the data from ZipFile input stream.
  - In `b/s/l.java`, the function `public final void a(File file)` uses the temp file to store the input `file`. This function is called in `b\s\l.java` function `public final void b()` to copy database file.
  - In both case, the temperary files are deleted after use. -->




### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
No suspicious or insecure(HTTP) URLs found.
<!-- Lots of http URLs found in the app. Most of them are android/google sites or other open source websites. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the servers forces HTTPS on server's end after manually testing. For a full list of the HTTP URLs, please check the URL section `CO_MobSF_report.pdf`.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here. -->
