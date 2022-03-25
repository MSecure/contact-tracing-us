<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert NV Analysis (Minqi) 
### APK Basic Info
App: COVID Trace Nevada. The report from MobSF, ```NV_MobSF_report.pdf```, is also inside this folder. 

```
APK Signature:
MD5: 97aad4dfa0b446bb04222db96e5a4162
SHA1: 05172b3f75752464d1558683041d22d9c0c6ceaa
SHA256: 94edd44dd7e7e99cd271d827abc5658930557f20ecca3b16f8e5a978da18bbbf
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - Allows an app to use device supported biometric modalities.(android.permission.USE_BIOMETRIC)
  - allow use of fingerprint(android.permission.USE_FINGERPRINT)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)

### MANIFEST ANALYSIS
 - Application Data can be Backed up. [android:allowBackup=true]. This flag allows anyone to backup your application data via adb. It allows users who have enabled USB debugging to copy application data off of the device.
 - Broadcast Receiver
   - [False Positive]. The permission is maintained by the Google API used.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - [False Positive] bacause these two permission are only used by Android System; and we assume that the system is not malicious.
    - [Possible False Positive] com.google.android.play.core.assetpacks.AssetPackExtractionService


 
### Privacy Policy
- In the privacy policy it says that the app "does not record your location or use your GPS".

https://nvhealthresponse.nv.gov/exposure-notifications/

### Privacy Violations
The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `e/b/a/m.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- It access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- It also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

Therefore, this is clearly a violation of the privacy policy made on the app official website.

[*Following-up*] Later I found that this is similiar to the case in CO, that this funtion is implementing an isNight() function from TwilightManager. Please check the `Privacy Violations` secton in README from `Covid Alert Co` folder for more details.

Also the app uses Biometric. android.permission.USE_BIOMETRIC and android.permission.USE_FINGERPRINT.

### CODE ANALYSIS
- The App uses an insecure Random Number Generator `java.util.Random`.
- The App uses the encryption mode CBC with PKCS5/PKCS7 padding. This configuration is vulnerable to padding oracle attacks.
- [False Positive] ~~The App logs information. Sensitive information should never be logged~~. No suspicous sensitive information found to be logged.
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  
- [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~




### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
HTTP Connection made in `f/b/a/b/h/c.java` and `f/a/b/w/e.java`. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the server forces HTTPS on its end.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
