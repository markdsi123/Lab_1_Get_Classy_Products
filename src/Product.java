public class Product {
    private String name;
    private String desc;
    private String ID;
    private double cost;
    public Product(String name, String desc, String ID, double cost) {
        this.name = name;
        this.desc = desc;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public String toCSVDataRecord()
    {
        return ID + ", " + name + ", " + desc + ", " + cost;
    }

}