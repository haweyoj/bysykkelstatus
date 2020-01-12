package bysykkel;

class Station {

    //static data
    private String address;
    private int station_id;
    private String name;
    private int capacity;

    //dynamic data
    private int num_bikes_available;
    private int num_docks_available;
    
    /**
     * Constructor
     * @param adress station address
     * @param station_id station id
     * @param name station name
     * @param capacity station capacity
     */
    public Station(String address,int station_id,String name,int capacity) {
        
        this.address = address;
        this.station_id = station_id;
        this.name = name;
        this.capacity = capacity;
       
    }

    /**
     * updates the number of available bikes and docks
     * @param num_bikes_available 
     * @param num_docks_available 
     */
    public void addStatusUpdate(int num_bikes_available, int num_docks_available) {
        this.num_bikes_available = num_bikes_available;
        this.num_docks_available = num_docks_available;
    }

    /**
     * Returns a string of all the information to a station
     * @return station information
     */
    public String getStationInfo() {
        return "Adress: " + address + "\n" +
        "Station id: " + station_id + "\n" +
        "name: "+ name + "\n" + 
        "capacity: " + capacity + "\n" + 
        "available bikes: "+ num_bikes_available + "\n" + 
        "available docks: " + num_docks_available + " \n";
    }

    /**
     * fetches the station id
     * @return station id
     */
    public int getId() {
        return station_id;
    }

}