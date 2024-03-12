import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Document d1 = new Document("Passport", "123456", new Date(2015, 1, 1), "Canada", new Date(2025, 1, 1));
        System.out.println(d1.toString());
        System.out.println(d1.daysUntillExpiry());
        System.out.println(d1.documentValidityLength());
    }
}
