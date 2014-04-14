(defproject storm/storm-mesos "0.9.1"
  :description "Storm integration with the Mesos cluster manager"
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"]
  :javac-options ["-g"]
  :jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib"]
  :repositories {"mesosphere-public-repo" "http://s3.amazonaws.com/mesosphere-maven-public"}
  :dependencies [
    [org.apache.mesos/mesos "0.18.0"]
    [com.google.protobuf/protobuf-java "2.5.0"]
    [org.apache.storm/storm-core "0.9.1-incubating"]
    [org.apache.commons/commons-exec "1.1"]
    [commons-lang "2.6"]
    [com.googlecode.json-simple/json-simple "1.1"]
    [org.slf4j/log4j-over-slf4j "1.6.6"]
    [org.mortbay.jetty/jetty "6.1.26"]
  ]
  :profiles {:dev {:resource-paths ["src/dev"]
                   :dependencies [
    [org.clojure/clojure "1.4.0"]
]}
             :release {}
             :lib {}
             }

)

