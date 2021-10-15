# Covid Alert PA Analysis (Soroush)
### App Permissions
  - Network Status
  - WiFi Status
  - Bluetooth
  - Foreground Service
  - Internet
  - Start at Boot
  - Vibrate

The app can read/write to external storage without requesting the permissions
 
### Privacy Policy
COVID Alert PA protects your privacy and personal information. Downloading the app is voluntary, but the more Pennsylvanians that use this app, the more successful our efforts will be to stop the spread of COVID-19.
  - The app detects if users are in close contact with another app user, using Bluetooth Low Energy (BLE) technology. It is the same technology that your phone uses to connect to wireless headphones or your car.
  - The app does not use GPS, location services, or any movement or geographical information.
  - The app will never collect, transmit, or store your personal information and is completely anonymous.
https://www.health.pa.gov/topics/disease/coronavirus/Pages/COVIDAlert.aspx#privacy

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but after running the analysis we see that the app is logging sensitive information which goes against its privacy policy.
The app also discloses the IP address which is also considered personal information

### Ghera Vulnerabilities
The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 
