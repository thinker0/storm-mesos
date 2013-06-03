(defproject storm/storm-mesos "airbnb"
  :description "Storm integration with the Mesos cluster manager"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :javac-options ["-g"]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
  :repositories {"releases" "http://artifactory.local.twitter.com/libs-releases-local"
                 "snapshots" "http://artifactory.local.twitter.com/libs-snapshots-local"}
  :dependencies [
    [org.apache.mesos/mesos "0.9.0-120"] ;; TODO: needs to be made public
    [com.google.protobuf/protobuf-java "2.4.1"]
    [storm "0.9.0-wip19"]
  ]
  :profiles {:dev {:resource-paths ["src/dev"]
                   :dependencies [
    [org.clojure/clojure "1.4.0"]
]}
             :release {}
             :lib {}
             }

)

