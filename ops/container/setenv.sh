
export JAVA_OPTS="$JAVA_OPTS -ea"
export JAVA_OPTS="$JAVA_OPTS -Xms2g"
export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
export JAVA_OPTS="$JAVA_OPTS -Daws.region=us-east-1"
export JAVA_OPTS="$JAVA_OPTS -Djms.queue.name=car-demo-dev"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.databaseName=medspa"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.portNumber=8080"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.username=Amy"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.password=Awu79613"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://medspadb.c8cgowjkpk0k.us-east-1.rds.amazonaws.com:5432/medspa"
export JAVA_OPTS="$JAVA_OPTS -Dserver.port=8080"