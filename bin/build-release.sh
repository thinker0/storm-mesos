#!/bin/bash

set -o errexit -o nounset -o pipefail
set -x

RELEASE=`head -1 project.clj | awk '{print $3}' | sed -e 's/\"//' | sed -e 's/\"//'`

export LEIN_ROOT=1

echo `rm -rf _release`
echo `rm -rf lib/ classes/`
echo `rm -rf target`
echo `rm -f *mesos*.tgz`

echo `lein with-profile release deps`
echo `lein with-profile release jar`
echo `lein with-profile release install`
echo `lein with-profile release pom`
echo `mvn dependency:copy-dependencies`

echo `rm -rf _release`
echo `mkdir -p _release`
echo `cp $1 _release/storm.zip`
cd _release
echo `unzip storm.zip`
echo `rm storm.zip`
echo `mv storm* storm`
cd ..
echo `rm _release/storm/*.jar`

# non existent
echo `rm target/release/dependency/storm-*.jar`

# copies storm-mesos-0.9.jar over
echo `cp target/*.jar _release/storm/lib/`

# non existent
echo `cp target/release/*.jar _release/storm/lib/`
echo `cp target/release/dependency/*.jar _release/storm/lib/`
echo `cp target/release+provided/*.jar _release/storm/lib/`

# delete all storm modules
#echo `rm target/dependency/storm*.jar`

# copy all dep jars over (remember: storm*jars are missing)
echo `cp target/dependency/*.jar _release/storm/lib/`

# non existent
echo `cp *.jar _release/storm/lib/`
echo `cp bin/storm-mesos _release/storm/bin/`

echo `mkdir -p _release/storm/native`

#non existent
echo `cp native/* _release/storm/native`

echo `cp storm.yaml _release/storm/conf/storm.yaml`

cd _release
echo `mv storm storm-mesos-$RELEASE`
echo `tar czf storm-mesos-$RELEASE.tgz storm-mesos-$RELEASE`
echo `cp storm-mesos-$RELEASE.tgz ../`
cd ..
#echo `rm -rf _release`
