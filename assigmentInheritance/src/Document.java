import java.util.Date;
public class Document {
    private String name;
    private String documentNumber;
    private Date issueDate;
    private Date expiryDate;
    private Boolean isExpiring;
    private String issuer;

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




    public String toString() {
        if (isExpiring)
            return "The document " + name + " has been issued by " + issuer + " on the date of " + issueDate + " it has the number of " + documentNumber + " and it expires on " + expiryDate;
        else
            return "The document " + name + " has been issued by " + issuer + " on the date of " + issueDate + " it has the number of " + documentNumber + " and it doesn't expire";
    }

    public int daysUntillExpiry(){
        return 1;
    }

    public int documentValidityLength(){
        return 1;
    }
}
