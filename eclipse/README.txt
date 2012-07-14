= Importing =

1) make sure you have the maven plugin (m2e) installed; 
2) import this project using File > Import... > "Existing Maven Projects" on the parent project

= Running Unit Tests =

1) Create a new JUnit Test run configuration (NOT android junit test)
2) Select "run all projects in selected package, project...", and select the diaspora-cluster-manager-project
3) Ensure that the Test runner is JUnit4 
4) Download robolectric-1.1-jar-with-dependencies.jar from https://oss.sonatype.org/index.html#nexus-search;quick~robolectric
5) in the "casspath" tab, add android.jar (API 10) and robolectric-1.1-jar-with-dependencies.jar as external jars
