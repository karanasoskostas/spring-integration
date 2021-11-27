package pydra.integration.SOAP.AFM;

import org.springframework.stereotype.Controller;

import java.net.MalformedURLException;


public interface AFMService {

    String getAFMVersion();

    String getAFM(String AFMtoFind) throws MalformedURLException;

}
