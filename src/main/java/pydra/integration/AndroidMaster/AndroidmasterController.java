package pydra.integration.AndroidMaster;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Arrays;
import java.util.List;



@RestController
public class AndroidmasterController {


    @Autowired
    private AndroidmasterService eService;

    private RestTemplate restTemplate = new RestTemplate();
    private RestTemplate postrestTemplate = new RestTemplate();



    String getBaseUrl(HttpServletRequest req) {
        return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
    }

    @GetMapping("/androidmaster")
    public ResponseEntity<List<Androidmaster>> getAndroidmaster() {
        return new ResponseEntity<List<Androidmaster>>(eService.getAndroidmaster(), HttpStatus.OK);
    }

    @GetMapping("/androidmaster/{id}")
    public ResponseEntity<Androidmaster> getAndroidmasterBYId(HttpServletRequest request, @PathVariable("id") Long id) {
        Androidmaster master = eService.getAndroidmasterById(id);
        return new ResponseEntity<>(master, HttpStatus.OK);
    }

    @GetMapping("/androidmaster/post/{id}")
    public ResponseEntity<String> postAndroidMaster(HttpServletRequest request, @PathVariable("id") Long id){
        String baseurl = getBaseUrl(request)+"/androidmaster/"+id.toString();
        System.out.println("BaseUrl "+ baseurl);

//        String plainCreds = "ianic@microsystems.gr:sd@3S7T#J!uW32d";
//        byte[] plainCredsBytes = plainCreds.getBytes();
//        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
//        String base64Creds = new String(base64CredsBytes);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + base64Creds);
//
//        HttpEntity<String> req = new HttpEntity<String>(headers);
//        ResponseEntity<Androidmaster> response = restTemplate.exchange(baseurl, HttpMethod.GET, req, Androidmaster.class);
//        Androidmaster master = response.getBody();

        Androidmaster master = eService.getAndroidmasterById(id);
        System.out.println(master);

        String postUrl = "http://demo.smartville.gr/api/rest/routelist";
        RestTemplate restTemplate = new RestTemplate();
        String postplainCreds = "pydra@smartville.gr:pydratest1";
        byte[] postplainCredsBytes = postplainCreds.getBytes();
        byte[] postbase64CredsBytes = Base64.encodeBase64(postplainCredsBytes);
        String postbase64Creds = new String(postbase64CredsBytes);

        HttpHeaders postheaders = new HttpHeaders();
        postheaders.add("Authorization", "Basic " + postbase64Creds);

        HttpEntity<Androidmaster> postreq = new HttpEntity<Androidmaster>(master, postheaders);
        URI uri = restTemplate.postForLocation(postUrl,  postreq);

        //master = restTemplate.postForObject( postUrl, master, Androidmaster.class, );

        return new ResponseEntity<String>(uri.toString(),HttpStatus.OK);
    }

}
