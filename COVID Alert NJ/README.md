### Summary:

This app uses the Exposure API developed by Apple and Google jointly. If you are within 6 feet of another person with the app for 10 minutes, your phone exchanges a secure Bluetooth token (code) with that person's. Then, if that person gets COVID, you get a notification that you were exposed- because you have their token. There is NO way for this app to see your location. There is NO tracking of your location through the app. It does NOT compromise bluetooth. This app can save lives.

### App Permissions:

From Android Manifest.xml:

<uses-feature android:name="android.hardware.bluetooth_le" android:required="true" />
    <uses-feature android:name="android.hardware.bluetooth" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

+ Bluetooth
+ Internet
+ Access Network State
+ Access Wifi State
+ Receive Boot Completed
+ Foreground Service
Foreground services show a status bar notification, so that users are actively aware that your app is performing a task in the foreground and is consuming system resources. The notification cannot be dismissed unless the service is either stopped or removed from the foreground.
+ Vibrate
- No Location

### Privacy Policy:

COVID Alert NJ Exposure Notification System (EN System) consists of the COVID Alert NJ app (App) and the Exposure
Notification Services (EN Services) in iphone iOS. The EN System is being made available by the New Jersey
Department of Health (DOH). The EN system is designed to assist in alerting individuals that came in close proximity
to someone who later is diagnosed with COVID-19, and to provide information about the virus and steps for
controlling the spread of the virus.
The use of this EN system is entirely voluntary and is available in the operating EN system of iOS users or as an App
to download for free from the Apple App Store and the Google Play Store. The App runs on iPhones that support iOS
13.5 and higher, and Android phones running Android 6.0 and higher. The EN system is not intended for use by
persons under 18 years of age, as they are considered not to have reached the digital age of consent or agreement
with the State of New Jersey. You will be asked to confirm that you are 18 years or older after you download the
App.

https://www.nj.gov/health/documents/DPP_COVIDALERTNJ.pdf

### Privacy Violations

- Uses the vulnerable SHA-1 hash function which should be replaced with a more secure SHA-256 hash
- Accessing websites which use or direct to HTTP connections, which are outdated compared to the more secure HTTPS connections
- Reads/writes to external storage, leaving it vulnerable to data injection
