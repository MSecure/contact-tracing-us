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
  - **This is a vulnerability** because `MainActivity` includes code for managing Bluetooth and Location connections, meaning that connection-handling code can be accessed by other apps.
- `ExposureNotificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - TODO
- `WakeUpService` is protected by a permission, but the protection level of the permission should be checked.
  - TODO
- `SystemJobService` is protected by a permission, but the protection level of the permission should be checked..
  - TODO
- `DiagnosticsReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - TODO
- `InstallReferrerReceiver` is exported and not protected, meaning other apps can access the broadcast receiver.
  - TODO

## Code Analysis
- The app logs information. Sensitive information should never be logged.
  - This is a false positive - the app logs hardcoded Strings and process information, such as error codes.
- The app uses SQLite Database and executes raw SQL queries.
  - TODO: Investigate strange `rawQueryWithFactory` calls
- The app uses ECB mode in encryption algorithm.
  - **This is a vulnerability** because encryptions done using ECB mode can be broken, potentially revealing sensitive information. See [this Ghera vulnerability](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-ECB-InformationExposure-Lean/) for details.
- The app uses an insecure Random Number Generator.
- The app may have root detection capabilities.
  - Secure
- The app uses SafetyNet API.
  - Secure
  
## Web Analysis
- All servers for this app are located within the United States as expected.
- TODO: URL analysis

## Privacy Policy
TODO

## Privacy Violations
TODO

## Ghera Vulnerabilities
- This app uses AES in ECB mode for encryption, which make it vulnerable to attacks.
  - https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-ECB-InformationExposure-Lean/


