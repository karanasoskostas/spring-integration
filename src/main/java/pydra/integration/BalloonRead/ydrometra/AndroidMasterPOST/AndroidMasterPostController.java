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
import pydra.integration.Snd_genpar.Sndgenpar;
import pydra.integration.Snd_genpar.SndgenparService;
import pydra.integration.exception.GeneralException;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import static pydra.integration.GenparConfiguration.defaultProperties;


@Controller
public class AndroidMasterPostController {

    @Autowired
    private AndroidMasterPostService eService;
    @Autowired
    private AndroidDetailPostService detailService;
    @Autowired
    private SndgenparService gService;

    String getBaseUrl(HttpServletRequest req) {
        return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
    }


    @GetMapping("/androidmasterpost/{id}")
    public ResponseEntity<String> postAndroidMaster(HttpServletRequest request, @PathVariable("id") Long id) {

        AndroidMasterPost master = eService.getSingleAndroidMasterPost(id);   // get AndroidMaster
        List<AndroidDetailPost> detaillist = detailService.getallByFileId(id);    // get AndroidDetail

//        Map<String,String> map =  AndroidMasterMap(master);   //master JSON
//        String requestJson = map.toString();
        ObjectNode objectnode = AndroidMasterObjectNode(master);
        String requestJson = objectnode.toString();

        String detailstring = "[";
        ObjectNode detailobjectnode = null;
        for (int i = 0; i < detaillist.size(); i++) {
            detailobjectnode = AndroidDetailObjectNode(detaillist.get(i));
            detailstring = detailstring + detailobjectnode.toString();
            if (i < detaillist.size() - 1) {
                detailstring = detailstring + ",";
            }
        }
        detailstring = detailstring + "]";
        requestJson = requestJson.substring(0, requestJson.length() - 1) + ",\"meters\":" + detailstring;


        requestJson = "[" + requestJson + "}]";

//        String postUrl = "http://demo.smartville.gr/api/rest/routelist";
        String postUrl = this.getPostUrl();
        HttpHeaders headers = getPostHeaders();
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(postUrl, entity, String.class);
        System.out.println(answer);

        return new ResponseEntity<String>("200 from Spring", HttpStatus.OK);
    }


    private HttpHeaders getPostHeaders() {                   // φτιαχνει headers για post στο Smartville
        String postplainCreds = this.getCredentials();
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

    public ObjectNode AndroidMasterObjectNode(AndroidMasterPost master) {    // to master node
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

    public ObjectNode AndroidDetailObjectNode(AndroidDetailPost detail) {  // detail node
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("id", detail.getId());
        objectNode.put("serial_number", detail.getSerial_number());

        return objectNode;
    }

    private String getPostUrl() {
        String url = "";
        String deyaAA = defaultProperties.getProperty("deyaAA");
        String smartvillename = defaultProperties.getProperty("smartvillename");

        url = "http://" + smartvillename + ".smartville.gr/api/rest/routelist";

        return url;
    }

    private String getCredentials() {
        String deyaAA = defaultProperties.getProperty("deyaAA");
        
        switch (deyaAA) {
            case "5":
                return "erp@deyakos.gr:epEYexW9XMZsJM0gOheY";
            case "22":
                return "erp@deya-parou.gr:cyTwFMAbrF6nhchp";
            default:
                return "pydra@smartville.gr:pydratest1";
        }
    }



}











