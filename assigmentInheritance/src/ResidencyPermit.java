import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ResidencyPermit extends Document{
    public ResidencyPermit(String passportNumber, Date issueDate, Date expiryDate, String issuer, Boolean isPermanent) {
        super("Residence Permit", passportNumber, issueDate, issuer, expiryDate);
        this.isPermanent = isPermanent;
    }

    private Boolean isPermanent;

    public Boolean getIsPermanent() {

        return isPermanent;

    }

    public int getOverstay() {
        Date now = new Date();
        if (now.compareTo(getExpiryDate()) > 0) {
            return (int) TimeUnit.DAYS.convert(now.getTime() - getExpiryDate().getTime(), TimeUnit.MILLISECONDS);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String strType = "";
        if (isPermanent)
            strType = "permanent";
        else
            strType = "temporary";
        return "The " + strType + " residence permit was issued by " + getIssuer() + " on " + getIssueDate() + " with number " + getDocumentNumber() + " and it expired on " + getExpiryDate();
    }
}
