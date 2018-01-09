package org.avol.zkclient;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Durga, Padala on 04/01/18.
 */
public class ZkConnection {

    final CountDownLatch connectedSignal = new CountDownLatch(1);

    final String host;

    private ZooKeeper zoo = null;

    ZkConnection(String host) {
        this.host = host;
    }
    // Method to connect zookeeper ensemble.
    public ZooKeeper connect() throws IOException,
            InterruptedException {
         zoo = new ZooKeeper(host, 5000, we -> {
            if (we.getState() == Watcher.Event.KeeperState.SyncConnected) {
                connectedSignal.countDown();
            }
        });
        connectedSignal.await();
        return zoo;
    }

    public void close() {
        try {
            zoo.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
