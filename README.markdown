Storm integration with the Mesos cluster resource manager. This runs in production within Twitter.

Prebuilt Storm/Mesos releases are available from the [downloads page](http://downloads.mesosphere.io/storm/storm-mesos-0.9.0.1.tgz).

A tutorial can be found [here](http://mesosphere.io/learn/run-storm-on-mesos/).

Along with the Mesos master and Mesos cluster, you'll need to run the Storm master as well. Launch Nimbus with this command: 

```
bin/storm-mesos nimbus
```

It's recommended that you also run the UI on the same machine as Nimbus via the following command:

```
bin/storm ui
```

There's a minor bug in the UI where it displays the number of slots in the cluster – you don't need to worry about this.

Topologies are submitted to a Storm/Mesos cluster the exact same way they are submitted to a regular Storm cluster.

Storm/Mesos provides resource isolation between topologies. So you don't need to worry about topologies interfering with one another.

## Native libraries

This distribution uses Netty by default and does not rely on native lib anymore.

## Mandatory configurations:

1. `mesos.executor.uri`: Once you fill in the configs and repack the distribution, you need to place the distribution somewhere where Mesos executors can find it. Typically this is on HDFS, and this config is the location of where you put the distibution.
2. `mesos.master.url`: URL for the Mesos master.
3. `java.library.path`: Needs the location of the ZeroMQ libs and the Mesos native libraries. The Storm/Mesos distribution comes with the native ZeroMQ libraries in the "native" folder (for Linux). This config is typically set to "native:{location of mesos native libs}"
4. `storm.zookeeper.servers`: The location of the Zookeeper servers to be used by the Storm master.
5. `nimbus.host`: The hostname of where you run Nimbus.

