package pydra.integration.BalloonRead.ydrometra.AndroidMasterPOST;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pydra.integration.AndroidMaster.Androidmaster;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
//        String baseurl = getBaseUrl(request)+"/androidmaster/getforposttosmartville/"+id.toString();
//        System.out.println("BaseUrl "+ baseurl);

        AndroidMasterPost master = eService.getSingleAndroidMasterPost(id);   // get AndroidMaster

//        Map<String,String> map =  AndroidMasterMap(master);   //master JSON
//        String requestJson = map.toString();
        ObjectNode objectnode = AndroidMasterObjectNode(master);
        String requestJson = objectnode.toString();

        requestJson = "["  + requestJson +  "]";

        String postUrl = "http://demo.smartville.gr/api/rest/routelist";
        HttpHeaders headers = getPostHeaders();
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(postUrl, entity, String.class);
        System.out.println(answer);

//        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
//
//
//        HttpEntity<AndroidMasterPost> requestEntity = new HttpEntity<AndroidMasterPost>(master, postheaders);
//        //URI uri = restTemplate.postForLocation(postUrl,  requestEntity);
//        ResponseEntity<AndroidMasterPost> responseEntity = restTemplate.postForEntity(postUrl, requestEntity, AndroidMasterPost.class);
//        //master = restTemplate.postForObject( postUrl, master, Androidmaster.class, );

        return new ResponseEntity<String>(answer,HttpStatus.OK);
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

    private Map<String, String> AndroidMasterMap(AndroidMasterPost master) {
        HashMap<String, String> map = new HashMap<>();

        map.put("code", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }

    public ObjectNode AndroidMasterObjectNode(AndroidMasterPost master) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("code", master.getCode());
        objectNode.put("route_name", master.getRoute_name());
        objectNode.put("description", master.getDescription());
        objectNode.put("start_date", master.getStart_date().toString());
        objectNode.put("end_date", master.getEnd_date().toString());
        objectNode.put("period", master.getPeriod());
        return objectNode;
    }









}
