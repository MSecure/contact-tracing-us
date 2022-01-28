# AlohaSafe Alert Analysis
### App Permissions
  - Network Status
  - WiFi Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Vibrate
  - Wake Lock

```
<uses-permission android:name="android.permission.INTERNET" />

<uses-permission android:name="android.permission.VIBRATE" />

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

<uses-permission android:name="android.permission.BLUETOOTH" />

<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />

<uses-permission android:name="android.permission.WAKE_LOCK" />
    
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```

The app can read/write to external storage without requesting the permissions
 
The app doesn't ask about any location permission but it uses the location helper and location manager classes

### Privacy Policy
DOH never collects or processes any personally identifiable information from the AlohaSafe Alert app. Bluetooth random codes are assigned to each device using the AlohaSafe Alert app. Each user’s random code changes frequently to further protect their identity. When an AlohaSafe Alert user comes into close contact with another AlohaSafe Alert user, their random codes are exchanged using Bluetooth. Random codes for close contacts are stored in a user’s device for 14 days. No personally identifiable or location information is collected, stored, or exchanged..
  - https://health.hawaii.gov/coronavirusdisease2019/alohasafe-alert/

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but the app is getting location information via the location helper class.
### Ghera Vulnerabilities
The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 

### Deeper Analysis
- The first vulnerability we can see is that the main activity of the app is not protected and therefore can be accessed by any other app.
- Within the main activity we can also see that the location helper and manager classes are being used meaning the app is: using the location information, and is allowing other apps to access that information through this app.
- Next the app can read/write to external storage which means the app is vulnerable to data injection and if any data is written from the app to the external storage it can be read from any other app.
- The app also uses ECB encryption which is known to be a weak crypto encryption algorithm with a MD5 hash function which is another weak outdated function that should be updated.
- [False Postive] Next is the rawQuery SQL vulnerability however while the function is vulnerable the program doesnt allow for opportunities for injection.
- The app uses an insecure Random Number Generator. While this isn't too much of a vulnerability the app should be updated to use SecureRandom.

