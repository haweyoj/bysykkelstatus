package bysykkel;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

class JsonParser {
    private String stations_info; // raw data
    private ArrayList<Station> stations;

    /**
     * Constructor 
     * @param stations_info json file
     */
    public JsonParser(String stations_info) {
        this.stations_info = stations_info;
        stations = new ArrayList<Station>();
    }
    /**
     * This method creates Station objects and fills them
     * with information from the jsonfile that was recieved
     * through the Constructor. 
     * @return an Arraylist of the created station objects
     */
    public ArrayList<Station> createStations() { // LEGG TIL FEILHÅNDTERING
        
       String tmp = stations_info.substring(stations_info.indexOf("["));
        JSONArray stationdata = new JSONArray(tmp);
        int n = stationdata.length();

        for(int i = 0; i < n; i++) {
            JSONObject temp_stationobj = stationdata.getJSONObject(i);         

            String address = temp_stationobj.getString("address");
            int station_id = temp_stationobj.getInt("station_id");
            String name = temp_stationobj.getString("name");
            int capacity = temp_stationobj.getInt("capacity");

            Station stationobj = new Station(address,station_id,name,capacity);
            stations.add(stationobj);  
        }
        return stations;
    }
    /**
     * This method adds updated information about the
     * number of bikes and docks in the stations. It
     * cross references the station id from the objects in
     * the arraylist with the ones recieved in the status update.
     * @param status_update json file with updated information
     */
    public void createStatusUpdate(String status_update) {
        String tmp = status_update.substring(status_update.indexOf("["));
        JSONArray statusdata = new JSONArray(tmp);
        int n = statusdata.length();

        for(int i = 0; i < n; i++) {

            //husk aa fikse feilhåndtering her og.
            //hvis getStation returnerer null burde ikke .get kjøres,linje 50
            JSONObject temp_stationobj = statusdata.getJSONObject(i);
            int station_id = temp_stationobj.getInt("station_id");
            int num_bikes_available = temp_stationobj.getInt("num_bikes_available");
            int num_docks_available = temp_stationobj.getInt("num_docks_available");
            getStation(station_id).addStatusUpdate(num_bikes_available, num_docks_available);       
        }
    }   

        /**
     * finds the Station object that matches with the
     * station id given in the parameter
     * @param station_id station id of the desired station object
     * @return the desired station object
     */
        public Station getStation(int station_id) {
            for(Station s : stations) {
                if(s.getId() == station_id) {
                    return s;
                }
            }
            return null; //fiks feilhåndtering
        }
    }