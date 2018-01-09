package org.avol.zkclient;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * @author Durga, Padala on 04/01/18.
 */
@RunWith(JUnit4.class)
public class ZkCreateTest {

    @Test
    public void testCreate() throws KeeperException, InterruptedException {
        ZkCreate zkCreate = new ZkCreate();
        try {
            ZooKeeper zooKeeper = new ZkConnection("52.16.10.36").connect();
            zkCreate.setConn(zooKeeper);
            String path = zkCreate.create("/order3", "Hello, TESCO.".getBytes());
            System.out.println("Path: " + path);

            zooKeeper.getChildren("/", false).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
