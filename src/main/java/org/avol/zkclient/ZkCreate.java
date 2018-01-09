package org.avol.zkclient;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * @author Durga, Padala on 04/01/18.
 */
public class ZkCreate {

    // create static instance for zookeeper class.
    private ZooKeeper zk;


    public void setConn(ZooKeeper conn) {
        this.zk = conn;
    }

    public ZooKeeper getConn() {
        return zk;
    }

    // Method to create znode in zookeeper ensemble
    public String create(String path, byte[] data) throws KeeperException,
            InterruptedException {
        return zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }
}
