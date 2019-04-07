package pl.edu.agh.soa.api;


import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@Stateless
@WebService
public class Test {


    @WebMethod
    public String Hello(@WebParam(name = "name") String name) {
        return "Hello" + name;
    }
}
