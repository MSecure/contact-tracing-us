# AlohaSafe Alert Analysis
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
DOH never collects or processes any personally identifiable information from the AlohaSafe Alert app. Bluetooth random codes are assigned to each device using the AlohaSafe Alert app. Each user’s random code changes frequently to further protect their identity. When an AlohaSafe Alert user comes into close contact with another AlohaSafe Alert user, their random codes are exchanged using Bluetooth. Random codes for close contacts are stored in a user’s device for 14 days. No personally identifiable or location information is collected, stored, or exchanged.
  - https://health.hawaii.gov/coronavirusdisease2019/alohasafe-alert/

### Privacy Violations
The app says it never collects, transmits, or stores personal information, but after running the analysis we see that the app is logging sensitive information which goes against its privacy policy.
The app also discloses the IP address which is also considered personal information

### Ghera Vulnerabilities
The app is vulnerable to SQL Raw Query SQL Injection Vulnerability (https://bitbucket.org/secure-it-i/android-app-vulnerability-benchmarks/src/master/Storage/SQLlite-RawQuery-SQLInjection-Lean/) since it uses rawQuery() to get information. 

### Deeper Analysis
- At first glance it seems that the IP Address is being disclosed however the app is just using a format similar to the ip addresses x.x.x.x format. We can see that it is not actually IP addresses because the constants that are used in the code come in various forms some being in the x.x.x.x.x.x.x.x.x format which is clearly not an ip address
- Next is the rawQuery SQL vulnerability however while the function is vulnerable the program doesnt allow for opportunities for injection.
- The big vulnerability in the app is that it uses the SHA-1 hash function which is known to be very vulnerable. this should instead be replaced with a SHA-256 hash which is a lot more secure.
- Another big vulnerability is that the app is accessing websites using an HTTP connection this is outdated and HTTPS should be used since HTTP connections are vulnerable to attack.
