package ro.var.rentalshop.models.user;

import java.time.LocalDate;
import java.util.Date;

public class DrivingLicence {
    private LocalDate issueDate;
    private LocalDate expireDate;
    private DrivingLicenceCategory drivingLicenceCategory;

    public DrivingLicence(LocalDate issueDate, LocalDate expireDate, DrivingLicenceCategory drivingLicenceCategory) {
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.drivingLicenceCategory = drivingLicenceCategory;
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public DrivingLicenceCategory getDrivingLicenceCategory() {
        return drivingLicenceCategory;
    }

    public void setDrivingLicenceCategory(DrivingLicenceCategory drivingLicenceCategory) {
        this.drivingLicenceCategory = drivingLicenceCategory;
    }
}
