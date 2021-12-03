DE Covid Track App Analysis

App Permissions:
- Internet
- Bluetooth
- Access Network State
- Wake Lock
- Recieve Boot Completed
- Foreground Service

Privacy Policy:
https://coronavirus.delaware.gov/wp-content/uploads/sites/177/2020/09/COVID-Alert-Terms-082720-.pdf
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

Privacy Violations:
- it discloses the ip address in 7 of the files in the code which clearly violates its policy of not sharing private information.
- It also logs sensitive information when in the private policy it said it wouldn't do that 

Ghera Vulnerabilities:
- It uses a rawSQLQuery which can lead to code injection,  it should use statements such as SQLiteStatemtn or a SQL function which is more protected to SQL code injections
- It reads and retrieves data from external storage which any other app can access to using the function getFromExternalDir
- It also uses the SHA-1 hash table which is really weak and causes collisions and should use SHA-256

