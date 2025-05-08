/**
 * A class for planets
 * Created by Sargon
 * Last edited April 24, 2025
 */

public class Planet {
    private String name;
    private String type;
    private String location;
    private String identifier;
    private String description;
    
    /**
     * Constructor method
     */
    public Planet(String n, String t, String l, String i, String d) {
        name = n;
        type = t;
        location = l;
        identifier = i;
        description = d;
    }
    
    /**
     * Getter method for the name of the planet
     * @return name The name of the planet
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter method for the type of the planet
     * @return type The type of the planet
     */
    public String getType() {
        return type;
    }
    
    /**
     * Getter method for the location of the planet
     * @return location The location of the planet
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Getter method for the identifier of the planet
     * @return identifier The identifier of the planet
     */
    public String getIdentifier() {
        return identifier;
    }
    
    /**
     * Getter method for the name of the planet
     * @return name The name of the planet
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Standard to string method
     * @return string
     */
    public String toString() {
        return name + ", " + identifier + ". It is a " + type + " located in " + location + ".\nHere is a description of this planet: " + description;
    }
}