package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pydra.integration.AndroidMaster.Androidmaster;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Controller
public class AndroidMasterPostController {

    @Autowired
    private AndroidMasterPostService eService;

    String getBaseUrl(HttpServletRequest req) {
        return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
    }


    @GetMapping("/androidmaster/getforposttosmartville/{id}")
    public ResponseEntity<AndroidMasterPost>  getSingleAndroidMasterPost(@PathVariable("id") Long id){
        return new ResponseEntity<AndroidMasterPost>(eService.getSingleAndroidMasterPost(id), HttpStatus.OK);
    }

    @GetMapping("/androidmasterpost/{id}")
    public ResponseEntity<String> postAndroidMaster(HttpServletRequest request, @PathVariable("id") Long id) throws URISyntaxException {
        String baseurl = getBaseUrl(request)+"/androidmaster/getforposttosmartville/"+id.toString();
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

        AndroidMasterPost master = eService.getSingleAndroidMasterPost(id);
        System.out.println("master ="+ master);

        String postUrl = "http://demo.smartville.gr/api/rest/routelist";
        HttpHeaders postheaders = getPostHeaders();
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<AndroidMasterPost> requestEntity = new HttpEntity<AndroidMasterPost>(master, postheaders);
        //URI uri = restTemplate.postForLocation(postUrl,  requestEntity);
        ResponseEntity<AndroidMasterPost> responseEntity = restTemplate.postForEntity(postUrl, requestEntity, AndroidMasterPost.class);
        //master = restTemplate.postForObject( postUrl, master, Androidmaster.class, );

        return new ResponseEntity<String>(responseEntity.getStatusCode().toString(),HttpStatus.OK);
    }

    private HttpHeaders getPostHeaders() {
        String postplainCreds = "pydra@smartville.gr:pydratest1";
        byte[] postplainCredsBytes = postplainCreds.getBytes();
        byte[] postbase64CredsBytes = Base64.encodeBase64(postplainCredsBytes);
        String postbase64Creds = new String(postbase64CredsBytes);

        HttpHeaders postheaders = new HttpHeaders();
        postheaders.setContentType(MediaType.APPLICATION_JSON);
        postheaders.add("Authorization", "Basic " + postbase64Creds);
        return postheaders;
    }

}
