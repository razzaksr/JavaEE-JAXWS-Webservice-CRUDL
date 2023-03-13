package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MyService {

    @WebMethod
    @WebResult(name="ListHai")
    public ListHai list(){
        return new HaiDAO().every();
    }

    @WebMethod
    @WebResult(name="ResponseMessage")
    public String create(@WebParam(name="Hai") Hai adding){
        return new HaiDAO().insert(adding);
    }

}
