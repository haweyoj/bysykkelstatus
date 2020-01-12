package bysykkel;
import java.util.ArrayList;

public final class App  {
    /**
    * Constructor
    * 
    */
    private App() {}
    
    public void runProgram() throws Exception {
        String stations_URL = "https://gbfs.urbansharing.com/oslobysykkel.no/station_information.json";
        RequestHandler rh = new RequestHandler();
        String stations = rh.sendBysykkelRequest(stations_URL);
        
        
        String status_URL = "https://gbfs.urbansharing.com/oslobysykkel.no/station_status.json";
        String status = rh.sendBysykkelRequest(status_URL);
        
        JsonParser jp = new JsonParser(stations);
        ArrayList<Station> obj = jp.createStations(); // denne skal sendes til GUIklassen
        jp.createStatusUpdate(status); // gi 
        
        for(Station s: obj) {
            System.out.println(s.getStationInfo());
        }
    }
    
    /**
    * runs program
    * @param args The arguments of the program.
    */
    public static void main(String[] args) throws Exception {
        App obj = new App ();
        obj.runProgram();       
    }
}