<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert CO Analysis (Minqi) 
### APK Basic Info
App: `UT Exposure Notifications_minted1100011_apkcombo.com.apk` (You can find this apk file and its obfucated source code in this folder). The report from MobSF, `UT_MobSF_report.pdf`, is also inside this folder. 

```
APK Signature:
MD5: 775d5cad9173c1988958bee531915fa6
SHA1: 577b354b4e4e057e3373176821b06dd32920d8b3
SHA256: 2beb14c85da568344c972a21ca6ead23c1b9d86c17a39b39d8842ebc43c0e308
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)

### MANIFEST ANALYSIS
 - Application Data can be Backed up [android:allowBackup=true]
   - This flag allows anyone to backup your application data via adb. It allows users who have enabled USB debugging to copy application data off of the device.
 - Broadcast Receiver
   - False Positive. The permission is mained by the Google API used.
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
- UT Exposure Notifications is the official Exposure Notifications app of Utah and the Utah Department of Health. Exposure Notifications is a voluntary new service developed in partnership with Google and Apple to help slow the spread of COVID-19. No GPS, location information or personal identifiers will ever be collected, stored or shared by this service.

https://coronavirus.utah.gov/EN-privacy-policy/


### Privacy Violations
The app says no location info collected, but it has the function to find the location of nearby testing site. And the app uses GPS location API in `e/b/a/m.java`.
- This file imports and uses `android.location.Location`, `android.location.LocationManager`
- The function `c()`, access `android.permission.ACCESS_COARSE_LOCATION` and `android.permission.ACCESS_FINE_LOCATION` permissions. Neither of the permission here is declared in the manifest file.
- In function above, it also uses `getLastKnownLocation("network")` to access the location where the user connects to the Internet last time.

This is similiar to the case in CO, that this funtion is implementing an isNight() function from TwilightManager. Please check the `Privacy Violations` secton in README from `Covid Alert Co` folder for more details.

### CODE ANALYSIS
- The App uses an insecure Random Number Generator, java.util.Random. This should be replaced by java.secure.SecureRandom.
  - h/a/j1/n2.java
    h/a/j1/h0.java
    h/a/k1/g.java
    h/a/n1/a.java
    h/a/j1/f0.java
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
<!-- - [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~
  - In `b/s/f.java`, when there is a `execSQL()`, the functions only take in an int and SQLiteDatabase; since we can't do any SQL injection with an int as input, this rawSQL seems to be safe. There is another variable `f2464b` contained an array of Strings. After manually checked all the places that uses this f class:
  ```
  .\gov\michigan\MiCovidExposure\storage\ExposureNotificationDatabase_Impl.java
  .\androidx\work\impl\WorkDatabase_Impl.java
  ```
  The input string array used in both file is hardcoded and then passed to `f2464b`; therefore, this variable should be safe from any injection as well. -->
- [*False Positive*] ~~App creates temp file. Sensitive information should never be written into a temp file.~~
  - In `e/u/k.java`, the function `public final void c(File file)` creates the temp file to temperarely store the data for out stream channel stream. The temperary files are deleted on exit.




### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
Lots of HTTP URLs found in the app. Most of them are android/google sites or other open source websites. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the servers forces HTTPS on server's end after manually testing. For a full list of the HTTP URLs, please check the URL section `UT_MobSF_report.pdf`.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
