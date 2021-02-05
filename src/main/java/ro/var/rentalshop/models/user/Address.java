package ro.var.rentalshop.models.user;

public class Address {
    private int id;
    private String street;
    private String streetNo;
    private String buildingNo;
    private String floorNo;
    private String apartmentNo;
    private String city;
    private String country;

    public Address(int id, String street, String streetNo, String buildingNo, String floorNo, String apartmentNo, String city, String country) {
        this.id = id;
        this.street = street;
        this.streetNo = streetNo;
        this.buildingNo = buildingNo;
        this.floorNo = floorNo;
        this.apartmentNo = apartmentNo;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
