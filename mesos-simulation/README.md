This module provides a simplistic Mesos simulation which can be used for Marathon scale tests.

The marathon with the simulated Mesos can be started from the command line like this:

```bash
sbt -Djava.library.path=<...include the directories of your native mesos libraries...> \
    "project mesosSimulation" "run --master zk://localhost:2181/mesos --zk zk://localhost:2181/marathon"
```

Of course, you can adjust your configuration. You need to provide the master configuration but no Mesos master or slave
has to be running.