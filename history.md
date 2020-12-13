File:     history.md
Author:   Carlos Adolfo Ortiz Q
Date:     Mar.04/2019
Modified: Dec.12/2020

Dec.12/2020 V2020.1.0 Tag: V2020.1.0
- Change naming convention for release. Only uses yyyy.n.x format. The tag is also named without the release date, 
  this could be infered from git commit when tag is created.
- Upgraded to Spring Boot 2.4.1, JDK 15, Lombok 1.8.16 and JaCoCo 0.8.6
- Moves from Junit 4 to Junit 5, complete overhaul.
- Change the header info for each source java file.
- Fix generated docs snippets directory.
- Add PMD, SpotBugs.

Jul.07/2020 V1.0.7 Tag: 20200707-V1.0.7
- Fix JaCoCo lists in POM.XML

Jul.05/2020 V1.0.6 Tag: 20200705-V1.0.6
- Add Formatting code to all files with new settings.
- Updates release docs.

Dec.17/2019 V1.0.5 Tag: 20191217-V1.0.5
- Adds sonar properties to take care by maven plugin in all pom.xml files.

Oct.21/2019 V1.0.4 Tag: 20191021-V1.0.4
- Refactoring to ChuckNorris service.
  Upgrades to Spring Boot 2.2.0
  
Oct.11/2019 V1.0.3 Tag: 20191011-V1.0.3
- Adds a new microservice sample.
  This plays around the Chuck Norris Jokes Free API at https://api.chucknorris.io

Mar.22/2019 V1.0.2 Tag: 20190322-V1.0.2
- Instructs both sonar and JaCoCo to exclude folders/files.
- Change naming convention for tag.

Mar.16/2019 V1.0.1 Tag: 20190316-V1.0.1
- Adds documentation
- Adds more samples.

Mar.04/2019 V1.0.0 Tag: 20190301-V1.0.0
- Project init.