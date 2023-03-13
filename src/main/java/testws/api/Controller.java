package testws.api;


import api.Hai;
import service.MyService;

public class Controller {
    public static void main(String[] args) {
        MyServiceService myServiceService=new MyServiceService();
        api.MyService myService=myServiceService.getMyServicePort();
        api.Hai hai=new Hai();
        hai.setName("Redmi x 43");
        hai.setPrice(26000);
        System.out.println(myService.create(hai));
    }
}
