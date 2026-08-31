package data;

import model.Property;
import java.util.ArrayList;
import java.util.List;

public class TelanganaPropertyData {

    public static List<Property> generateData() {
        List<Property> properties = new ArrayList<>();

        // Hyderabad Properties (Majority)
        properties.add(new Property("HYD001", "Luxury 3 BHK Apartment", "Gachibowli", "Hyderabad", "Apartment", 8500000, 3, 1650, "Parking, Lift, Security, Gym, Pool", "Modern 3 BHK apartment near IT corridor."));
        properties.add(new Property("HYD002", "Spacious 2 BHK", "Madhapur", "Hyderabad", "Apartment", 6500000, 2, 1200, "Parking, Lift, Security", "Prime location, close to metro station."));
        properties.add(new Property("HYD003", "Premium Villa", "Jubilee Hills", "Hyderabad", "Villa", 45000000, 4, 4500, "Private Pool, Garden, 24/7 Security", "Exquisite villa with modern architecture."));
        properties.add(new Property("HYD004", "Affordable 1 BHK", "Kukatpally", "Hyderabad", "Apartment", 3500000, 1, 800, "Parking", "Budget-friendly flat for small families."));
        properties.add(new Property("HYD005", "Independent House", "Secunderabad", "Hyderabad", "House", 12000000, 3, 2000, "Parking, Garden", "Spacious independent house in a quiet neighborhood."));
        properties.add(new Property("HYD006", "IT Corridor 3 BHK", "Kondapur", "Hyderabad", "Apartment", 9200000, 3, 1750, "Gym, Pool, Club House", "Brand new apartment near top tech parks."));
        properties.add(new Property("HYD007", "Elegant 4 BHK Flat", "Banjara Hills", "Hyderabad", "Apartment", 25000000, 4, 3000, "Premium Amenities", "Luxurious living space in the heart of the city."));
        properties.add(new Property("HYD008", "Budget 2 BHK", "Miyapur", "Hyderabad", "Apartment", 5000000, 2, 1050, "Lift, Security", "Value for money investment near highway."));
        properties.add(new Property("HYD009", "Corner Plot", "Manikonda", "Hyderabad", "Land", 15000000, 0, 2500, "None", "Excellent corner plot for residential construction."));
        properties.add(new Property("HYD010", "Gated Community Flat", "Nallagandla", "Hyderabad", "Apartment", 7800000, 2, 1300, "Pool, Gym, Play Area", "Family-friendly gated community with full amenities."));
        properties.add(new Property("HYD011", "Spacious 3 BHK", "Uppal", "Hyderabad", "Apartment", 6800000, 3, 1500, "Parking, Lift", "Close to Uppal metro and stadium."));
        properties.add(new Property("HYD012", "Standalone House", "LB Nagar", "Hyderabad", "House", 9500000, 3, 1800, "Parking", "Well maintained old house."));
        properties.add(new Property("HYD013", "Studio Apartment", "Begumpet", "Hyderabad", "Apartment", 3000000, 1, 600, "Security", "Perfect for bachelors working nearby."));
        properties.add(new Property("HYD014", "Duplex Villa", "Kompally", "Hyderabad", "Villa", 18000000, 4, 3200, "Club House, Pool", "Luxury duplex villa in North Hyderabad."));
        properties.add(new Property("HYD015", "Compact 2 BHK", "Mehdipatnam", "Hyderabad", "Apartment", 4500000, 2, 1000, "None", "Affordable living near traditional markets."));
        properties.add(new Property("HYD016", "Near Airport Villa", "Shamshabad", "Hyderabad", "Villa", 22000000, 4, 3500, "Garden, Security", "Quiet villa property close to the international airport."));
        properties.add(new Property("HYD017", "High-rise 3 BHK", "Hitech City", "Hyderabad", "Apartment", 13000000, 3, 1900, "Gym, Pool, Spa", "Premium high-rise living with city views."));
        properties.add(new Property("HYD018", "Residential Plot", "Bachupally", "Hyderabad", "Land", 8000000, 0, 1800, "None", "Open plot for immediate construction."));
        properties.add(new Property("HYD019", "Affordable 3 BHK", "Kukatpally", "Hyderabad", "Apartment", 7500000, 3, 1400, "Lift, Security", "Good connectivity to all parts of the city."));
        properties.add(new Property("HYD020", "Penthouse", "Gachibowli", "Hyderabad", "Penthouse", 35000000, 4, 4000, "Private Terrace, Pool", "Exclusive penthouse for elite living."));

        // Other Telangana Locations
        properties.add(new Property("WAR001", "2 BHK Center", "Hanamkonda", "Warangal", "Apartment", 4000000, 2, 1100, "Parking", "Centrally located in Warangal."));
        properties.add(new Property("WAR002", "Independent House", "Kazipet", "Warangal", "House", 7000000, 3, 1600, "Garden", "Close to the railway station."));
        properties.add(new Property("WAR003", "Agricultural Land", "Geesugonda", "Warangal", "Land", 10000000, 0, 43560, "Water Supply", "One acre fertile agricultural land."));
        
        properties.add(new Property("KAR001", "3 BHK Gated", "Vidyanagar", "Karimnagar", "Apartment", 5500000, 3, 1400, "Security, Gym", "Modern amenities in Karimnagar town."));
        properties.add(new Property("KAR002", "Commercial Space", "Tower Circle", "Karimnagar", "Commercial", 15000000, 0, 2000, "None", "Prime commercial property for business."));

        properties.add(new Property("NIZ001", "2 BHK Flat", "Shivaji Nagar", "Nizamabad", "Apartment", 3500000, 2, 1000, "Lift", "Well-ventilated apartment."));
        properties.add(new Property("NIZ002", "Standalone House", "Kanteshwar", "Nizamabad", "House", 8500000, 3, 1800, "Parking", "Spacious family home."));

        properties.add(new Property("KHA001", "Luxury Villa", "Wyra Road", "Khammam", "Villa", 12000000, 4, 2500, "Garden", "Beautiful villa on the highway."));
        properties.add(new Property("KHA002", "Affordable 2 BHK", "NST Road", "Khammam", "Apartment", 3200000, 2, 950, "None", "Budget-friendly option."));

        properties.add(new Property("NAL001", "2 BHK Near Station", "Clock Tower", "Nalgonda", "Apartment", 3000000, 2, 900, "Parking", "Very close to transit."));
        properties.add(new Property("NAL002", "Open Plot", "Miryalaguda Road", "Nalgonda", "Land", 4000000, 0, 1500, "None", "Investment property."));

        properties.add(new Property("SID001", "Independent Villa", "Mustabad Road", "Siddipet", "Villa", 9000000, 3, 2000, "Garden", "Newly constructed villa."));
        properties.add(new Property("SAN001", "Farmhouse", "Kandi", "Sangareddy", "Farmhouse", 25000000, 3, 217800, "Pool, Orchard", "5 acres farmhouse for weekend getaways."));
        properties.add(new Property("MED001", "Heritage Home", "Medak Town", "Medak", "House", 6000000, 3, 1500, "None", "Classic architecture near the church."));
        properties.add(new Property("SUR001", "Highway Facing Plot", "NH65", "Suryapet", "Land", 7500000, 0, 2000, "None", "High appreciation potential."));
        properties.add(new Property("ADI001", "Spacious 3 BHK", "Bhuktapur", "Adilabad", "Apartment", 4500000, 3, 1300, "Parking", "Quiet and serene environment."));
        properties.add(new Property("MAH001", "2 BHK Flat", "Christian Pally", "Mahbubnagar", "Apartment", 3800000, 2, 1050, "Lift", "New apartment complex."));
        properties.add(new Property("VIK001", "Farm Land", "Ananthagiri", "Vikarabad", "Land", 5000000, 0, 43560, "None", "Scenic location near Ananthagiri hills."));
        properties.add(new Property("MAN001", "Townhouse", "College Road", "Mancherial", "House", 5500000, 2, 1200, "Parking", "Perfect for a small family."));
        properties.add(new Property("JAG001", "Market Plot", "Old Bus Stand", "Jagtial", "Commercial", 12000000, 0, 1000, "None", "Highly commercial area."));
        
        properties.add(new Property("HYD021", "Lake View 3 BHK", "Khajaguda", "Hyderabad", "Apartment", 11000000, 3, 1600, "Pool, Gym", "Stunning lake view apartment."));
        properties.add(new Property("HYD022", "Builder Floor", "SR Nagar", "Hyderabad", "Apartment", 6000000, 2, 1150, "None", "Standalone building floor."));
        properties.add(new Property("HYD023", "Luxury Penthouse", "Jubilee Hills", "Hyderabad", "Penthouse", 60000000, 5, 6000, "Private Pool, Gym", "Ultimate luxury with city views."));
        properties.add(new Property("WAR004", "Gated Community Flat", "Bheemaram", "Warangal", "Apartment", 4800000, 2, 1200, "Park, Security", "Safe environment for kids."));
        properties.add(new Property("KAR003", "Bungalow", "Mankammathota", "Karimnagar", "House", 11000000, 4, 2500, "Garden", "Large family bungalow."));
        properties.add(new Property("NIZ003", "Farm Land", "Dichpally", "Nizamabad", "Land", 3000000, 0, 43560, "Water Supply", "Good for agriculture."));
        properties.add(new Property("KHA003", "Commercial Shop", "Gandhi Chowk", "Khammam", "Commercial", 8000000, 0, 500, "None", "Prime shopping area."));

        return properties;
    }
}
