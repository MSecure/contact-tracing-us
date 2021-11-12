WA Notify Analysis

WA Privacy Policy:
- containing data elements that can't be used to detect an individual
	- Random Codes: these hashed codes are stored 14 days and then 
	  shared via bluetooth to check for possible exposure.
	- Verification Link: pops up after given verification code once 
	  an individual is tested positive and the link is only voluntarily
	  give out.
	- Usage Logs: these logs are generated within the phone and work like
	  any other apps usage logs. They are also stored for about
	  14 days as well.
	- Analytics Data: you can choose if the app can collect extra data 
	  about you and collects info of how smartphone is used
- protects info using Google's exposure Notification Framework which stores and
generates codes
- Phones allows you to delete exposure logs and turn off exposure notifications

App's Permissions:
- ACCESS_NETWORK_STATE
- BLUETOTTH
- FOREGROUND_SERVICE
- INTERNET
- RECEIVE_BOOT_COMPLETED
- WAKE_LOCK

Privacy Violation
- It says that it doesn't log private info, however according to the report
it logs sensitive info [False Positive] ~ all info being logged is info 
voluntarily given by the user itself

Ghera Vulnerabilities:
- App uses SQLite RawQuery so it's vulnerable to code injection, but instead it 
should use SQLiteStatement or a SQL function which is more protected to SQL code
injections
- app creates temp file by using the method createNewTempFile() should not store info
into this file should say createNewFile() method instead
