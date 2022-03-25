# Wisconsin Exposure Notification Analysis

## APK Info

This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file.
```
APK Signature:
md5: 572ee2b3302b8198828de574a7121cde
sha1: 56af2697b0ec10bd5a175e4e32a4d044a02bcf1c
sha256: f3e7d1752b302813da92a62402f1d1542a8050e663f8ca2820488b8ce5c3ad75

```

## App's Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## WI Privacy Policy:
This is the Privacy Policy for WI Exposure Notification app for Covid Tracing: https://www.dhs.wisconsin.gov/covid-19/app-privacy.htm

- The app does not collect nor exchange personal information or identifiable information such as location, DOB, etc.
- The only data shared is the randomly generated bluetooth keys, date and duration of the exposure, and Bluetooth signal strength
- Whenever a user tests positive for covid, he or she can elect to share this information with other users on the app 
  - those keys are later cross checked by the other users on the platform to see if they had an encounter with that person with that specific key
  - sharing of keys and information is also completely voluntary and can be decided by the user
  - if yes, the app shares exposure data with that user for public health reasons
- the keys are constantly recycled every 14 days for security reasons
- the following data is collected upon request: 
  - App installation and deletion metrics
  - Exposure notification metrics
  - Exposure notification interaction metrics
  - Key upload metrics
  - Verification code metrics
  - Anonymous keys that have been voluntarily shared
- Information collected may be shared with public health authorities and also will be used to improve the performance of the app
- Intended for people 18 years or older
- There will be constant changes to the privacy policy over time, so whenever a change is made all users will be notified readily

## Manifest Analysis




