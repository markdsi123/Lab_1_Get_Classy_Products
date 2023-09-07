public class ProductTest {
    public static void main(String[] args) {
        Product phone = new Product("phone", "iphone", "001", 500);
        System.out.println(phone.toCSVDataRecord());
        System.out.println(phone.getName());
        System.out.println(phone.getID());
        System.out.println(phone.getDescription());
        System.out.println(phone.getCost());

    }
}