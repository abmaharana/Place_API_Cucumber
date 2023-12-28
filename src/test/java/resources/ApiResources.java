package resources;

//enum is a special class in java which has collection of constants or methods
public enum ApiResources {
    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");
    private String resource;
    ApiResources(String resource){
        this.resource = resource;
    }
    public String getResource(){
        return resource;
    }
}
