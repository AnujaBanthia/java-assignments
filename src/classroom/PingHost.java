package classroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Double> maxQueue;
    PriorityQueue<Double> minQueue;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxQueue=new PriorityQueue(Collections.reverseOrder()); //Stores lower half
        minQueue=new PriorityQueue(); //Stores upper half
    }

    public void addNum(double num) {
        if(maxQueue.size()==0 && minQueue.size()==0) minQueue.offer(num);
        else if(num<=minQueue.peek()){
            if(maxQueue.size()>minQueue.size()){
                double maxTop=maxQueue.poll();
                maxQueue.offer(Math.min(num,maxTop));
                minQueue.offer(Math.max(num,maxTop));
            }
            else
                maxQueue.offer(num);
        }
        else{
            if(maxQueue.size()<minQueue.size())
                maxQueue.offer(minQueue.poll());
            minQueue.offer(num);
        }
    }

    public double findMedian() {
        if(minQueue.size()==maxQueue.size())
            return (maxQueue.peek()+minQueue.peek())/2.0;
        else if(minQueue.size()>maxQueue.size()) return minQueue.peek().doubleValue();
        else return maxQueue.peek().doubleValue();
    }
}

public class PingHost {
    MedianFinder medianFinder = new MedianFinder();

    public void pingHost(String hostName){
        String command = "ping  "+hostName;
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            inputStream.readLine();
            String s = "";

            // reading output stream of the command
            while ((s = inputStream.readLine()) != null ) {
                String[] temp = s.split(" ");
                String rtt = temp[7];
                rtt= rtt.substring(5);
                System.out.println("Adding RTT to data values: "+rtt);
                //rttInMiliseconds.add(Double.parseDouble(rtt));
                medianFinder.addNum(Double.parseDouble(rtt));
                System.out.println("Median is : "+medianFinder.findMedian());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PingHost pingHost = new PingHost();
      pingHost.pingHost("google.com");
      //findMedian();
        //System.out.println(rtt);
    }
}
