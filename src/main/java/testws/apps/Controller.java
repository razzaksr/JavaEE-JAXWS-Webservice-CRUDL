package testws.apps;

import apps.Hai;
import apps.MyServiceService;

public class Controller {
    public static void main(String[] args) {
        apps.MyServiceService myServiceService=new MyServiceService();
        apps.MyService service= myServiceService.getMyServicePort();
        apps.Hai h1=new Hai();
        h1.setName("Thomson");
        h1.setPrice(17900);
        service.create(h1);
        apps.ListHai listHai = service.list();
        for(apps.Hai hai: listHai.getList()){
            System.out.println(hai.getId()+" "+ hai.getPrice()+" "+hai.getName());
        }
    }
}
