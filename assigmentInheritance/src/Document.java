import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Document {

    public Document (String name, String documentNumber, Date issueDate, String issuer) {

        this.name = name;
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.issuer = issuer;

        isExpiring = false;
    }

    public Document (String name, String documentNumber, Date issueDate, String issuer, Date expiryDate) {

        this.name = name;
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.issuer = issuer;

        if (expiryDate.compareTo(issueDate) > 0) {
            this.expiryDate = expiryDate;
            isExpiring = true;
        } else {
            throw new IllegalArgumentException("The expiry date cannot be before issue date");
        }

    }

    //<editor-fold desc="Fields">
    //<editor-fold desc="private vars">
    private String name;
    private String documentNumber;
    private Date issueDate;
    private Date expiryDate;
    private Boolean isExpiring;
    private String issuer;
    //</editor-fold>

    //<editor-fold desc="getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) throws Exception {
        if (isExpiring) {

            if (expiryDate.compareTo(issueDate) > 0){

                this.expiryDate = expiryDate;

            }else
                throw new Exception("The expiry date cannot be before issue date");

        }else
            throw new Exception("The document is not expiring");
    }

    public Boolean getExpiring() {
        return isExpiring;
    }

    public void setExpiring(Boolean expiring) {
        isExpiring = expiring;
        expiryDate = null;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    //</editor-fold>
    //</editor-fold>

    //<editor-fold desc="Methods">
    public String toString() {
        if (isExpiring)
            return "The document " + name + " has been issued by " + issuer + " on the date of " + issueDate + " it has the number of " + documentNumber + " and it expires on " + expiryDate;
        else
            return "The document " + name + " has been issued by " + issuer + " on the date of " + issueDate + " it has the number of " + documentNumber + " and it doesn't expire";
    }

    public int daysUntillExpiry(){
        Date now = new Date();
        long difference = expiryDate.getTime() - now.getTime();
        return (int)TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);

    }

    public int documentValidityLength(){
        long difference = expiryDate.getTime() - issueDate.getTime();
        return (int)TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }
    //</editor-fold>
}
