package org.avol.zkclient;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author Durga, Padala on 05/01/18.
 */
public class ZkGetData {

    private final ZooKeeper zk;
    private final ZkPathExist zkPathExist;

    public ZkGetData(ZooKeeper zk) {
        this.zk = zk;
        zkPathExist = new ZkPathExist(zk);
    }

    public String getData() {
        String path = "/order";
        final String[] data = {""};
        try {
            Stat stat = zkPathExist.pathExist(path);
            if (stat != null) {
                byte[] b = zk.getData(path, false, stat);
                data[0] = new String(b, "UTF-8");
            } else {
                System.out.println("Node does not exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data[0];
    }
}
