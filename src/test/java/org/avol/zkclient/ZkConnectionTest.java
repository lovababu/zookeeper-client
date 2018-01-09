package org.avol.zkclient;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

/**
 * @author Durga, Padala on 04/01/18.
 */
@RunWith(JUnit4.class)
public class ZkConnectionTest {


    @Test
    public void testConnection() {
        ZkConnection zkConnection = new ZkConnection("54.194.255.167");
        try {
            ZooKeeper zoo = zkConnection.connect();
            List<String> children = zoo.getChildren("/", false);
            children.forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

}
