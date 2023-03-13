package service;

import javax.xml.ws.Endpoint;

public class Endpointing {
    private static final String url="http://localhost:8082/soap";
    public static void main(String[] args) {
        System.out.println("Will get publish "+url);
        Endpoint.publish(url,new MyService());
    }
}
