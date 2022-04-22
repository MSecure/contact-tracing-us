# COVIDWISE (Virginia) Analysis

## Hashes
- MD5: `e85623eb6eb97513d2c349ca1f96e7ab`
- SHA1: `e64bf5b899a318adb576bffd198ce4ebb5149143`
- SHA256: `744271e87c1365aa2cec85f438a7179d0ecf9a86828989395d2b346526c96556`

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
- Wake Lock
  - `<uses-permission android:name="android.permission.WAKE_LOCK" /> `

## Manifest Analysis
- Activity-Alias (`gov.vdh.exposurenotification.ENNotifyOthers`) is not Protected. 
  - This activity alias is exported, which means other applications on the device can access the activity to which this alias refers (`ShareDiagnosisActivity`). This activity includes several other class instances, including `ShareDiagnosisEditFragment`. This fragment contains code which deals with user verification via One-Time Passwords (OTP). Since the activity alias allows access to the `ShareDiagnosisActivity`, which in turn allows access to the `ShareDiagnosisEditFragment`, external apps can access the verification procedure.
- `ExposureNotificationBroadcastReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - This receiver/permission is maintained by Google
- `WakeUpService` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK"`
  - This permission is part of Google's Exposure Notification API
- `SystemJobService` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="android.permission.BIND_JOB_SERVICE"`
  - This permission has signature-level protection. This means that requests to access this service will only be accepted by the system if the requesting application has the same signature as this application.
- `DiagnosticsReceiver` is protected by a permission, but the protection level of the permission should be checked.
  - `android:permission="android.permission.DUMP"`
  - This is protected by system ([Android documentation](https://developer.android.com/reference/android/Manifest.permission#DUMP))

## Code Analysis
- The app logs information. Sensitive information should never be logged.
  - This is a false positive - the app logs hardcoded Strings and process information, such as error codes.
  
## Web Analysis
- All servers for this app are located within the United States as expected.
- All URLs accessed by this app use HTTPS.

## Privacy Policy
- VDH never collects or processes any personally identifiable information from the COVIDWISE App.
- No personally identifiable or location information is collected, stored, or exchanged.
- The COVIDWISE App will never collect, track or store your location, GPS information, or personal information.

## Privacy Policy Violations
- The app connects to Location and collects location data without user consent in `TwilightManager.java`.

## Ghera Vulnerabilities
- None found
