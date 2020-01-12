package bysykkel;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

class RequestHandler {

    public RequestHandler() {}

    //build path specifies execution environment javaSE-1.8 there are no JREs

    /**
     * this method sends a http request to the API 
     * using methods from the unirest library.
     * The recieved JSON file is sent to a JSON parser.
     * @param host is the endpoint URL sent from the app.
     */
    public String sendBysykkelRequest(String host) throws Exception {
        String prettyJsonString = "";
        String client_identifier = "haweyoj-bysykkeloversikt";

        try {
            HttpResponse <JsonNode> response = Unirest.get(host)
            .header("haweyoj-bysykkeloversikt", client_identifier).asJson();
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(response.getBody().toString());
             prettyJsonString = gson.toJson(je);

        }
        catch (Exception e) {
            System.out.println("havnet i exception blokken");
            //exit
            
        }
        return prettyJsonString;   
    }        
    }

