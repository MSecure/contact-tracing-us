# Covid Watch Arizona
### App Permissions
  - Network Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Wake Lock
  - C2DM Recieve Cloud to Device Permission
  - BIND_GET_INSTALL_REFERRER_SEVICE - defined by google to authenicate Google Play Store download
  

```
<uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <queries>
        <intent>
            <action android:name="android.intent.action.DIAL" />
        </intent>
        <intent>
            <action android:name="android.intent.action.SEND" />
        </intent>
    </queries>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
    <uses-permission android:name="com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
```
 
The app doesn't ask about any location permission but it uses the location and location manager classes

### Privacy Policy
Once you opt-in and enable exposure notifications on your phone, Covid Watch starts working immediately to detect if you come into close proximity with someone who has tested positive for COVID-19. The app is completely anonymous and works in the background without ever needing to know your location or personal information. It’s simple, safe, and secure.
- https://azdhs.gov/documents/privacy-policy/covid-watch-application-privacy-policy.pdf

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but the app is getting location information via the location manager class which is due to the use of Twilight Manager which takes the device's location to find out the sunset and sunrise times.

### Ghera Vulnerabilities
 - [False Positive] The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 
 - 
### Deeper Analysis
- The first vulnerability we can see is that the main activity of the app is not protected and therefore can be accessed by any other app.
- Within the main activity we can also see that the location helper and manager classes are being used meaning the app is: using the location information, and is allowing other apps to access that information through this app.
- Next the app can read/write to external storage which means the app is vulnerable to data injection and if any data is written from the app to the external storage it can be read from any other app.
- The app also uses ECB encryption which is known to be a weak crypto encryption algorithm with a MD5 hash function which is another weak outdated function that should be updated.
- [False Postive] Next is the rawQuery SQL vulnerability however while the function is vulnerable the program doesnt allow for opportunities for injection.

