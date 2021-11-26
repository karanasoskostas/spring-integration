package pydra.integration.SOAP.AFM;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
       String countryCode="Canada";
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

        return response.toString();

   }

}
