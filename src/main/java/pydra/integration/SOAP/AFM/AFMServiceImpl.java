package pydra.integration.SOAP.AFM;

import static pydra.integration.GenparConfiguration.defaultProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class AFMServiceImpl implements AFMService{

    @Override
    public String getAFMVersion() {
        try {
            return this.getVersion();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getAFM(String AFMtoFind) {
        String response = "";
        try {
            response =  this.getAFMDetails(AFMtoFind);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    public String getVersion() throws MalformedURLException {
       String url = "https://www1.gsis.gr:443/wsaade/RgWsPublic2/RgWsPublic2";
       URL obj = new URL(url);
       HttpURLConnection con = null;
       try {
           con = (HttpURLConnection) obj.openConnection();
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           con.setRequestMethod("POST");
       } catch (ProtocolException e) {
           e.printStackTrace();
       }
       con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
       String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
               "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:rgw=\"http://rgwspublic2/RgWsPublic2Service\">\n" +
               "   <soap:Header/>\n" +
               "   <soap:Body>\n" +
               "      <rgw:rgWsPublic2VersionInfo/>\n" +
               "   </soap:Body>\n" +
               "</soap:Envelope>";
       con.setDoOutput(true);
       DataOutputStream wr = null;
       try {
           wr = new DataOutputStream(con.getOutputStream());
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           wr.writeBytes(xml);
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           wr.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           wr.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       String responseStatus = null;
       try {
           responseStatus = con.getResponseMessage();
       } catch (IOException e) {
           e.printStackTrace();
       }
       System.out.println(responseStatus);
       BufferedReader in = null;
       try {
           in = new BufferedReader(new InputStreamReader(
                   con.getInputStream()));
       } catch (IOException e) {
           e.printStackTrace();
       }
       String inputLine=null;
       StringBuffer response = new StringBuffer();
       while (true) {
           try {
               if (!((inputLine = in.readLine()) != null)) break;
           } catch (IOException e) {
               e.printStackTrace();
           }
           response.append(inputLine);
       }
       try {
           in.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
//       System.out.println("response:" + response.toString());
       String responsestring =  response.toString();
       int PRETTY_PRINT_INDENT_FACTOR = 4;
       String jsonPrettyPrintString = "";
       JSONObject xmlJSONObj = null;
       try {
           xmlJSONObj = XML.toJSONObject(responsestring);
           jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
           //System.out.println(jsonPrettyPrintString);
       } catch (JSONException je) {
           System.out.println(je.toString());
       }
//
//
        return jsonPrettyPrintString;
   }


    public String getAFMDetails(String AFMtoFind) throws MalformedURLException {
        String url = "https://www1.gsis.gr:443/wsaade/RgWsPublic2/RgWsPublic2";
        String username ="", password="";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String searchDate = formatter.format(new Date());
        URL obj = new URL(url);
        HttpURLConnection con = null;

//        username ="090262997DE21";
//        password="090262997deyal";
        username = defaultProperties.getProperty("afmusername");
        password = defaultProperties.getProperty("afmpassword");

        try {
            con = (HttpURLConnection) obj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            con.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
        String xml = "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:ns1=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:ns2=\"http://rgwspublic2/RgWsPublic2Service\" xmlns:ns3=\"http://rgwspublic2/RgWsPublic2\">\n" +
                "   <env:Header>\n" +
                "      <ns1:Security>\n" +
                "         <ns1:UsernameToken>\n" +
                "            <ns1:Username>"+username+"</ns1:Username>\n" +
                "            <ns1:Password>"+password+"</ns1:Password>\n" +
                "         </ns1:UsernameToken>\n" +
                "      </ns1:Security>\n" +
                "   </env:Header>\n" +
                "   <env:Body>\n" +
                "      <ns2:rgWsPublic2AfmMethod>\n" +
                "         <ns2:INPUT_REC>\n" +
                "            <ns3:afm_called_by/>\n" +
                "            <ns3:afm_called_for>"+AFMtoFind+"</ns3:afm_called_for>\n" +
                "            <ns3:as_on_date>"+searchDate+"</ns3:as_on_date>\n" +
                "         </ns2:INPUT_REC>\n" +
                "      </ns2:rgWsPublic2AfmMethod>\n" +
                "   </env:Body>\n" +
                "</env:Envelope>";
        con.setDoOutput(true);
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.writeBytes(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseStatus = null;
        try {
            responseStatus = con.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseStatus);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine=null;
        StringBuffer response = new StringBuffer();
        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.append(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//       System.out.println("response:" + response.toString());
        String responsestring =  response.toString();
        int PRETTY_PRINT_INDENT_FACTOR = 4;
        String jsonPrettyPrintString = "";
        JSONObject xmlJSONObj = null;
        try {
            xmlJSONObj = XML.toJSONObject(responsestring);
            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            //System.out.println(jsonPrettyPrintString);
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
//
        JSONObject myjson = new JSONObject(jsonPrettyPrintString);
        JSONObject envelope= myjson.getJSONObject("env:Envelope");
        JSONObject body = envelope.getJSONObject("env:Body");
        JSONObject afmresponse = body.getJSONObject("srvc:rgWsPublic2AfmMethodResponse");
        JSONObject result =afmresponse.getJSONObject("srvc:result");

        JSONObject result_rtType =result.getJSONObject("rg_ws_public2_result_rtType");

        JSONObject error_rec = result_rtType.getJSONObject("error_rec");


        JSONObject basic_rec = result_rtType.getJSONObject("basic_rec");




        return basic_rec.toString();

//
//        return jsonPrettyPrintString;
    }






}