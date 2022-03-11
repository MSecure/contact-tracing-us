# NM Notify (New Mexico) Analysis

## Hashes
- MD5: `0c81ca7d1ea3594ff4c4b05019196d25`
- SHA1: `90cb654ea633bbc1421ea6d365ac27566d0bdd0d`
- SHA256: `d52e89973977148a950ed40afbdba56dfc70ed23d4a52196f01605edbb2bcbb1`

## App Permissions
#### Permissions from manifest:
- Network Status
    - `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`
- Bluetooth
    - `<uses-permission android:name="android.permission.BLUETOOTH" />`
- Foreground Service
    - `<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />`
- Internet
    - `<uses-permission android:name="android.permission.INTERNET" />`
- Start at Boot
    - `<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />`
- Biometrics
    - `<uses-permission android:name="android.permission.USE_BIOMETRIC" />`
- Fingerprint
    - `<uses-permission android:name="android.permission.USE_FINGERPRINT" />`
- Wake Lock
    - `<uses-permission android:name="android.permission.WAKE_LOCK" /> `

## Manifest Analysis
- Application Data can be Backed up `[android:allowBackup=true]`
    - According to the app's privacy policy, the app does not collect or store any user information. The reason for allowing data backup from this app is therefore unclear.
- `ExposureNotificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked
    - `android:permission="com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK"`
    - This permission is maintained by Google.
- `SmsVerificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked
    - `android:permission="com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK"`
    - This permission is maintained by Google.
- `WakeUpService` is protected by a permission, but the protection level of the permission should be checked
    - `android:permission="com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK"`
    - This permission is maintained by Google.
- `SystemJobService` is Protected by a permission, but the protection level of the permission should be checked
    - `android:permission="android.permission.BIND_JOB_SERVICE"`
    - This permission has signature-level protection. This means that requests to access this service will only be accepted by the system if the requesting application has the same signature as this application.
- `DiagnosticsReceiver` is Protected by a permission, but the protection level of the permission should be checked
    - `android:permission="android.permission.DUMP"`
    - This is protected by system ([Android documentation](https://developer.android.com/reference/android/Manifest.permission#DUMP))
- `AssetPackExtractionService` is not Protected
    - This service is provided by Google as part of the Android API.

## Code Analysis
- App uses SQLite Database and execute raw SQL query. Untrusted user input in raw SQL queries can cause SQL Injection. Also sensitive information should be encrypted and written to the database
    - This app makes extensive use of SQL, SQLite, and raw SQL queries, for example in `f/b/c/k/t/x.java`.
    - This app uses the `execSQL` method in many cases, for example with data from `SharedPreferences` in `e/c0/a0/j.java`. Use of this method leaves the app vulnerable to [this Ghera vulnerability](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLite-execSQL-Lean/).
- This App may have root detection capabilities.
    - Secure
- The App logs information. Sensitive information should never be logged.
    - This app logs process/error information. This is not a security issue.
- The App uses an insecure Random Number Generator.
- App can read/write to External Storage. Any App can read data written to External Storage.
    - In `f/b/a/f/a/b/b2.java`, this app access the file located at the path returned by `getExternalFilesDir(null)`.
    - This app does not include the `android:name="android.permission.WRITE_EXTERNAL_STORAGE"` permission in the manifest. This means that the user is not directly notified that the application is accessing external storage.
    - TODO Follow control flow to find write location
- Files may contain hardcoded sensitive information like usernames, passwords, keys etc.
    - The relevant lines of risky code (174 in `h/a/k1/f.java`) are never executed - they are in an `else` block for which the corresponding `if` condition is always `true`.
        - ``z  = true;``
    ``if(z){...} else { [Log "Metadata Key"] }``
        - Best practice would be to remove this code if it is not used.
- The App uses the encryption mode CBC with PKCS5/PKCS7 padding. This configuration is vulnerable to padding oracle attacks.
    - Information encrypted with this cipher may be leaked, as described by [this Ghera vulnerability](https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-NonRandomIV-InformationExposure-Lean/).
    - TODO Research nonrandom IV
    - TODO Research android biometrics storage
- App creates temp file. Sensitive information should never be written into a temp file. 
    - `e/v/k.c()` creates a temp file (`room-copy-helper`) and uses an input stream from context assets to obtain bytes to write to that file.
    - [False positive] This is not a security issue. The file is stored in app-level internal storage as a temporary cache file (directory from `getCacheDir()`).
  
## Web Analysis
- This app has at least ten servers located in the United States.
- This app has one server located in the Netherlands. The reason for a server located in this region is unclear.
- This app includes several references to unencrypted HTTP web connections. Although these connections redirect to HTTPS equivalents, the more secure practice would be to access the sites via HTTPS directly.

## Privacy Policy
- NM Notify will never collect, track or store your location, GPS information, or personal information.
- Enabling exposure notification in NM Notify is your choice. You can enable and disable such notifications at any time.
- Random device keys do not collect or process any location or personally identifiable information.
- All PINs are anonymous and auto-generated.
- The following event data may be processed and collected in NM Notify:
    - Number of app users who have Exposure Notification Services enabled
    - Number of close contact notifications
    - Number of app users who uploaded positive diagnosis keys
    - Number of matched diagnosis keys per positive exposure notification

## Privacy Policy Violations
- This app includes code for collecting location/GPS information, which is in violation of the app's privacy policy. (`e/b/a/m.java`)
- TODO Biometrics

## Ghera Vulnerabilities
- The app uses CBC mode for encryption.
    - https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Crypto/BlockCipher-NonRandomIV-InformationExposure-Lean/
- The app uses SQLite and executes raw SQL queries, leaving it potentially vulnerable to SQL injection attacks.
    - https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLite-execSQL-Lean/


