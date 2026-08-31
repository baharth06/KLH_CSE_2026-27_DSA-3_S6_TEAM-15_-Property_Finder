package model;

public class Property {
    private String propertyId;
    private String title;
    private String location;
    private String district;
    private String propertyType;
    private double price;
    private int bedrooms;
    private int area; // in sq ft
    private String amenities;
    private String description;

    public Property(String propertyId, String title, String location, String district, 
                    String propertyType, double price, int bedrooms, int area, 
                    String amenities, String description) {
        this.propertyId = propertyId;
        this.title = title;
        this.location = location;
        this.district = district;
        this.propertyType = propertyType;
        this.price = price;
        this.bedrooms = bedrooms;
        this.area = area;
        this.amenities = amenities;
        this.description = description;
    }

    // Getters
    public String getPropertyId() { return propertyId; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public String getDistrict() { return district; }
    public String getPropertyType() { return propertyType; }
    public double getPrice() { return price; }
    public int getBedrooms() { return bedrooms; }
    public int getArea() { return area; }
    public String getAmenities() { return amenities; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format(
            "Property ID: %s | Title: %s\nLocation: %s, %s | Type: %s | Price: ₹%,.2f\n" +
            "Bedrooms: %d | Area: %d sq ft\nAmenities: %s\nDescription: %s\n",
            propertyId, title, location, district, propertyType, price, bedrooms, area, amenities, description
        );
    }
}
