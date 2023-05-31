package convertJsontoPOJO;


import org.apache.commons.lang3.builder.ToStringBuilder;

public class AddressGeoPOJOClass {

    private String latitude ;
    private String longitude ;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public  String toString () {

        return new ToStringBuilder(this).append("latitude" , latitude).
                append("longitude" , longitude).toString() ;


    }



}
