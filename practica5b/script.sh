cd pract5Sinref/
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=pract5Sinref \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=fef13e3c507d2398240451a0ae05f80ad97e3517
  
cd ../pract5Conref/
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=pract5Conref \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=fef13e3c507d2398240451a0ae05f80ad97e3517
cd ..
