import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Document d1 = new Document("Passport", "123456", new Date(2015, 1, 1), "Canada", new Date(2025, 1, 1));
        System.out.println(d1);
        System.out.println(d1.daysUntillExpiry());
        System.out.println(d1.documentValidityLength());

        Passport p1 = new Passport("123456", new Date(2015, 1, 1), new Date(2025, 1, 1), "USA", 1);
        System.out.println(p1);
        System.out.println(p1.daysUntillExpiry());
        System.out.println(p1.documentValidityLength());
        System.out.println(p1.getNationalityAsString());

        ResidencyPermit r1 = new ResidencyPermit("123456", new Date(2015, 1, 1), new Date(2025, 1, 1), "USA", true);
        System.out.println(r1);
        System.out.println(r1.daysUntillExpiry());
        System.out.println(r1.documentValidityLength());
        System.out.println(r1.getOverstay());

        BirthCertificate b1 = new BirthCertificate("123456", new Date(2015, 1, 1), "USA", 1, 2);
        System.out.println(b1);
        System.out.println(b1.getNationalityFather());
        System.out.println(b1.getNationalityMother());

    }
}
