# COVID Defense (Louisiana) Analysis

## Hashes
- MD5: `bb4ed4340ca7683797f55d4651913cee`
- SHA1: `af9e6c731d559e7f83091f9edb5d6012223ecedd`
- SHA256: `31d1742cd986d67cc788e08bd8a8e3a32f6ea3be9d7b327b182b7e8ff3e523a0`

## App Permissions
#### Permissions from manifest:
- Network Status
  - `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`
- WiFi Status
  - `<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />`
- Bluetooth
  - `<uses-permission android:name="android.permission.BLUETOOTH" />`
- Foreground Service
  - `<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />`
- Internet
  - `<uses-permission android:name="android.permission.INTERNET" />`
- Start at Boot
  - `<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />`
- Vibrate
  - `<uses-permission android:name="android.permission.VIBRATE" />`
- Wake Lock
  - `<uses-permission android:name="android.permission.WAKE_LOCK" /> `

## Manifest Analysis
- `MainActivity` is exported and not protected, meaning other apps can access the activity.
  - `MainActivity` includes code for managing Bluetooth and Location connections, meaning that connection-handling code can be accessed by other apps.
    - `MainActivity` creates and uses `BluetoothHelper` and `LocationHelper` objects which include code for handling Bluetooth and location state changes, respectively. They include callbacks to be run when Bluetooth or location becomes available or unavailable. The callbacks use a JS module (`RCTDeviceEventEmitter`) to emit a broadcast to indicate that a state change was detected. (In `onCreate` method)
    - `MainActivity` creates and registers two `BroadcastReceiver`s which are configured to handle Bluetooth and location state changes, respectively. (Lines 159, 175)
    - `MainActivity` references the devices' default Bluetooth adapter and location system service, and uses those references to determine if connection capabilities are available. (Lines 160-171, 177-189)
  - *`MainActivity` creates and uses a `Task` for code pertaining to Bluetooth and location availability detection. Since this task is created in an unprotected activity, it potentially introduces some of the TaskAffinity Ghera vulnerabilities outlined [here](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/ICC/).

- `ExposureNotificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - This receiver/permission is maintained by Google
  - TODO: Investigate `com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK` permission
- `WakeUpService` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK"`
  - This permission is part of Google's Exposure Notification API
- `SystemJobService` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="android.permission.BIND_JOB_SERVICE"`
  - This permission has signature-level protection. This means that requests to access this service will only be accepted by the system if the requesting application has the same signature as this application.
- `DiagnosticsReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="android.permission.DUMP"`
  - From [Android documentation](https://developer.android.com/reference/android/Manifest.permission#DUMP):
    - Allows an application to retrieve state dump information from system services.
    - Not for use by third-party applications.
  - *Based on Android documentation on this permission, use of this permission is not best practice for diagnostics.
- `InstallReferrerReceiver` is exported and not protected, meaning other apps can access the broadcast receiver.
  - This `BroadcastReceiver` is part of the [Matomo](https://matomo.org) analytics library.

## Code Analysis
- The app logs information. Sensitive information should never be logged.
  - This is a false positive - the app logs hardcoded Strings and process information, such as error codes.
- The app uses SQLite Database and executes raw SQL queries.
  - The relevant code for the `rawQueryWithFactory` calls could not be decompiled by MobSF (in `RoomDatabase.java`).
- The app uses ECB mode in encryption algorithm.
  - **This is a vulnerability** because encryptions done using ECB mode can be broken, potentially revealing sensitive information. See [this Ghera vulnerability](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-ECB-InformationExposure-Lean/) for details.
- The app uses an insecure Random Number Generator.
- The app may have root detection capabilities.
  - Secure
- The app uses SafetyNet API.
  - Secure
  
## Web Analysis
- All servers for this app are located within the United States as expected.
- All URLs accessed by this app use HTTPS.

## Privacy Policy
- Does not require your name, age, or address
- Does not require you to create an account or login
- Does not collect your phone number unless you choose to share it for a callback
- Does not track your location
- Cannot be used to check if you should be self-isolating
- Can only access information on your phone that you decide to enter or allow
- Cannot be used to identify who are your close contacts
- Cannot be used to identify people who tested positive for coronavirus
- Requires a user to enable bluetooth and exposure notifications for the app to function
- User does not create an account
- No personally identifiable or location information is collected, stored, or exchanged
- The COVID Defense App will never collect, track or store your location or GPS information
- The following event data may be processed and collected in the COVID Defense App. This data may be shared with other entities.
  - Installing the COVID Defense App
  - Enabling and disabling Exposure Notifications
  - Receiving an Exposure Notification
  - Submitting a verified verification code
  - Sharing a positive result
  - Downloading anonymous tokens for positive users that have chosen to notify others
  - Deleting the app

## Privacy Policy Violations
- The app performs many checks to determine the status of the device's location capabilities. However it seems that the app does not collect or store location information, which is consistent with the privacy policy.

## Ghera Vulnerabilities
- This app uses AES in ECB mode for encryption, which makes it vulnerable to attacks.
  - https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-ECB-InformationExposure-Lean/
- This app creates a `Task` in an unprotected activity. This makes it potentially vulnerable to TaskAffinity attacks.
  - https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/ICC/



