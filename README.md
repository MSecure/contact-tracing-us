# contact-tracing-us
Analysis of contact tracing Android apps


- For each app you analyze, make a directory with the app's package name
- In each directory, have a README file with your observations about the following:
  - What permissions does the app request.
  - What device features does the app use (e.g., bluetooth, location, phone, networking, etc.)
  - Does the app violate its own privacy policies and how?
  - Does the app have any known vulnerabilities caputured in the Ghera repository.
- The directory should also have a file called *apk_hash.txt* which should contain the hash value of the apk that you downloaded. 

Click [here](https://developers.google.com/android/exposure-notifications/apps) to see all the apps.
List of Apps covered in this project: 
✔️(Complete), 🚧 (Work in Progress), ❌ (Incomplete)
| Region        | Android package name | Status  |
| ------------- |:-------------:| -----:|
|USA - Alabama	|gov.adph.exposurenotifications | ✔️
|USA - Arizona	|gov.azdhs.covidwatch.android | ✔️
|USA - California	|gov.ca.covid19.exposurenotifications| 🚧
|USA - Colorado	|gov.co.cdphe.exposurenotifications| ✔️
|USA - Connecticut	|gov.ct.covid19.exposurenotifications|✔️
|USA - Delaware	|gov.de.covidtracker | ✔️
|USA - District of Columbia	|gov.dc.covid19.exposurenotifications | ✔️
|USA - Guam	|org.pathcheck.guam.bt | 🚧
|USA - Hawaii	|org.alohasafe.alert | ✔️
|USA - Louisiana	|org.pathcheck.la.bt | ❌
|USA - Maryland	|gov.md.covid19.exposurenotifications | ❌
|USA - Massachusetts	|Android Settings Integration | ❌
|USA - Michigan	|gov.michigan.MiCovidExposure | ✔️
|USA - Minnesota	|org.pathcheck.covidsafepathsBt.mn | ❌
|USA - Nevada	|gov.nv.dhhs.en | ❌
|USA - New Jersey	|com.nj.gov.covidalert | ✔️
|USA - New Mexico	|gov.nm.covid19.exposurenotifications | ❌
|USA - New York	|gov.ny.health.proximity | ✔️
|USA - North Carolina	|gov.nc.dhhs.exposurenotification | ✔️
|USA - North Dakota	|com.proudcrowd.exposure | ✔️
|USA - Pennsylvania	|gov.pa.covidtracker| ✔️
|USA - Utah	|gov.ut.covid19.exposurenotifications | ✔️
|USA - Virginia	|gov.vdh.exposurenotification | ❌
|USA - Washington	|gov.wa.doh.exposurenotifications | ✔️
|USA - Wisconsin	|gov.wi.covid19.exposurenotifications | ❌
|USA - Wyoming	|com.proudcrowd.exposure | ✔️
