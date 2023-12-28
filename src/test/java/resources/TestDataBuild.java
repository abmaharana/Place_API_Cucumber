package resources;

import POJO.AddPlace;
import POJO.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload(String name,String language,String address){
        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress(address);
        addPlace.setLanguage(language);
        addPlace.setPhone_number("+91-9778063806");
        addPlace.setWebsite("www.google.com");
        addPlace.setName(name);

        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        addPlace.setTypes(myList);

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        addPlace.setLocation(location);

        return addPlace;
    }

    public String deletePlacePayLoad(String placeId){
        return "{\n" +
        "    \"place_id\": \""+placeId+"\"\n" +
                "}";
    }
}
