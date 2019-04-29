package frames;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;
import java.util.Collections;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

public class WeatherYdnJava {
		public String Temp, WindChill, Wind, Humidity, PressureWeather, Visibility;
		public int status;
    public WeatherYdnJava() throws Exception {

        final String appId = "dVtA4T5a";
        final String consumerKey = "dj0yJmk9OEpMYUtTVUF0UGlCJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PTNk";
        final String consumerSecret = "5f48965b98da2fab7096e0184e919c5a24551c38";
        final String url = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        List<String> parameters = new ArrayList<>();
        parameters.add("oauth_consumer_key=" + consumerKey);
        parameters.add("oauth_nonce=" + oauthNonce);
        parameters.add("oauth_signature_method=HMAC-SHA1");
        parameters.add("oauth_timestamp=" + timestamp);
        parameters.add("oauth_version=1.0");
        // Make sure value is encoded
        parameters.add("location=" + URLEncoder.encode("warsaw,pl", "UTF-8"));
        parameters.add("format=json");
        Collections.sort(parameters);

        StringBuffer parametersList = new StringBuffer();
        for (int i = 0; i < parameters.size(); i++) {
            parametersList.append(((i > 0) ? "&" : "") + parameters.get(i));
        }

        String signatureString = "GET&" +
            URLEncoder.encode(url, "UTF-8") + "&" +
            URLEncoder.encode(parametersList.toString(), "UTF-8");

        String signature = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec((consumerSecret + "&").getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHMAC = mac.doFinal(signatureString.getBytes());
            Encoder encoder = Base64.getEncoder();
            signature = encoder.encodeToString(rawHMAC);
        } catch (Exception e) {
            System.err.println("Unable to append signature");
            System.exit(0);
        }

        String authorizationLine = "OAuth " +
            "oauth_consumer_key=\"" + consumerKey + "\", " +
            "oauth_nonce=\"" + oauthNonce + "\", " +
            "oauth_timestamp=\"" + timestamp + "\", " +
            "oauth_signature_method=\"HMAC-SHA1\", " +
            "oauth_signature=\"" + signature + "\", " +
            "oauth_version=\"1.0\"";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + "?location=warsaw,pl&format=json"))
            .header("Authorization", authorizationLine)
            .header("X-Yahoo-App-Id", appId)
            .header("Content-Type", "application/json")
            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        //System.out.print(response.body()+"\n");
        
        int IndexTemp = response.body().indexOf("temperature");
        Temp = String.format ("%.2f", (Float.valueOf(response.body().substring(IndexTemp + 13,IndexTemp + 15))-32)*5/9);
        //System.out.print("Temperatura: " + Temp + "\n");
        
        int IndexWindChill = response.body().indexOf("chill");
        WindChill = String.format ("%.2f", (Float.valueOf(response.body().substring(IndexWindChill + 7,IndexWindChill + 9))-32)*5/9);
        //System.out.print("Temperatura odczuwalna: " + WindChill + "\n");
        
        int IndexWind = response.body().indexOf("speed");
        Wind = String.format ("%.2f", (Float.valueOf(response.body().substring(IndexWind + 7,IndexWind + 11))*1.609344));
        //System.out.print("predkosc wiatru: " + Wind + "\n");
        
        int IndexHumidity = response.body().indexOf("humidity");
        Humidity = response.body().substring(IndexHumidity + 10,IndexHumidity + 12);
        //System.out.print("wilgotnosc: " + Humidity + "\n");
        
        int IndexPressureWeather = response.body().indexOf("pressure");
        PressureWeather = String.format("%.2f", (Float.valueOf(response.body().substring(IndexPressureWeather + 10,IndexPressureWeather + 14))*33.86389));
        //System.out.print("cisnienie atmosferyczne: " + PressureWeather + "\n");
        
        int IndexVisibility = response.body().indexOf("visibility");
        Visibility = String.format ("%.2f", (Float.valueOf(response.body().substring(IndexVisibility + 12,IndexVisibility + 16))*1.609344));
        //System.out.print("widocznosc: " + Visibility + "\n");
        
        int IndexStatus = response.body().indexOf("code");
        status = Integer.parseInt(response.body().substring(IndexStatus + 6,IndexStatus + 8));
        //System.out.print("status: " + status + "\n");
    }
    
    public static void main(String[] args) throws Exception {
    	WeatherYdnJava wr = new WeatherYdnJava();
    }
}
