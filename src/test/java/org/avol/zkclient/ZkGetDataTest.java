package org.avol.zkclient;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * @author Durga, Padala on 05/01/18.
 */

@RunWith(JUnit4.class)
public class ZkGetDataTest {

    @Test
    public void testGetData() {
        ZkConnection connection = new ZkConnection("52.16.10.36");
        try {
            ZkGetData zkGetData = new ZkGetData(connection.connect());
            System.out.println("Data  : " + zkGetData.getData());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
