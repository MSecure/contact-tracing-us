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
   ~~- False Positive. The permission is maintained by the Google API used.~~ 
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - These two are possibly false positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.


 
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

### CODE ANALYSIS
- The App uses an insecure Random Number Generator, java.util.Random. This should be replaced by java.secure.SecureRandom.
  - h/a/j1/f0.java
    h/a/k1/g.java
    h/a/j1/h0.java
    h/a/j1/n2.java
    h/a/n1/a.java
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.



### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
Lots of http URLs found in the app. Most of them are android/google sites or other open source websites. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the servers forces HTTPS on server's end after manually testing. For a full list of the HTTP URLs, please check the URL section `CO_MobSF_report.pdf`.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
