package org.avol.zkclient;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author Durga, Padala on 05/01/18.
 */
public class ZkPathExist {

    private ZooKeeper zk;

    public ZkPathExist(ZooKeeper zk) {
        this.zk = zk;
    }

    public Stat pathExist(String path) throws KeeperException, InterruptedException {
        return zk.exists(path, false);
    }
}
