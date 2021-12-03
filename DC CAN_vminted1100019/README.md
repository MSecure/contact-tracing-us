# DC CAN (Washington DC)
### App Permissions
  - Network Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Wake Lock
  

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```
 
The app doesn't ask about any location permission but it uses the location and location manager classes

### Privacy Policy
DC Health takes your privacy and confidentiality very seriously. Apple and Google's framework is designed to avoid correlating any personal data and location information with the random identifiers that devices exchange. DC Health does not want or need to know where or who you are for DC CAN to work. If you are close enough to another app user, your device's BLE will exchange random identifiers with that user.
- https://coronavirus.dc.gov/dccan/privacy

### Privacy Violations
- The app says it never collects, transmits, or stores personal information, but the app is getting location information via the location manager class which is due to the use of Twilight Manager which takes the device's location to find out the sunset and sunrise times.
- Additionally, the app accesses the DIAL and SEND intents which allows it to make phone calls and send messages. This removes the anonymity of the app.  
- [False Positive] The initial analysis shows the use of the Content Resolver but this is used to access GMS (Google Mobile Services) which the app is allowed to access without violating its privacy policy.

### Ghera Vulnerabilities
 - [False Positive] The app is not vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it doesn't use rawQuery() to get information. 
- [False Positive] The app is not vulnerable to the insecure SSL implementation (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Networking/) since it is not using the getSocket() or getInsecure() methods

### Deeper Analysis
- The has [android:allowBackup=true] which means the app data can be backed allowing people to copy data from the app using adb.
- [False Postive] Next is the rawQuery SQL vulnerability however while the function is vulnerable the program doesnt allow for opportunities for injection.
- [False Positive] The app creates a temp file but it doesn't store sensitive info and deletes the file on exit.
- The app accesses the location to use Twilight Manager to calculate sunrise/sunset. This violates the privacy policy.
- The app uses an insecure Random Number Generator. While this isn't too much of a vulnerability the app should be updated to use SecureRandom.
- The app accesses multiple http urls which are not secure and leaves it open to injection.  
