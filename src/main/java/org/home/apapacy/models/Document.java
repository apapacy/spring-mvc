package org.home.apapacy.models;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.ektorp.support.TypeDiscriminator;
 
public class Document extends CouchDbBaseDocument{
 
    private static final long serialVersionUID = 59516215253102057L;
     
    public Document() {
        super();
    }
     
    public Document(String title) {
        this.title = title;
    }
     
    /**
     * @TypeDiscriminator is used to mark properties that makes this class's documents unique in the database. 
     */
    @TypeDiscriminator
    @NotNull
    private String title;
     
    private int clientId;
    private int createdByEmployeeId;
    private int reviewedByEmployeeId;
    private int approvedByManagerId;
    private Date dateEffective;
    private Date dateCreated;
    private Date dateReviewed;
    private Date dateApproved;
    private int investorId;
    private int categoryId;
    private int subCategoryId;
    private int statusId;
     
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public int getCreatedByEmployeeId() {
        return createdByEmployeeId;
    }
    public void setCreatedByEmployeeId(int createdByEmployeeId) {
        this.createdByEmployeeId = createdByEmployeeId;
    }
    public int getReviewedByEmployeeId() {
        return reviewedByEmployeeId;
    }
    public void setReviewedByEmployeeId(int reviewedByEmployeeId) {
        this.reviewedByEmployeeId = reviewedByEmployeeId;
    }
    public int getApprovedByManagerId() {
        return approvedByManagerId;
    }
    public void setApprovedByManagerId(int approvedByManagerId) {
        this.approvedByManagerId = approvedByManagerId;
    }
   
    public Date getDateEffective() {
        return dateEffective;
    }
 
    public void setDateEffective(Date dateEffective) {
        this.dateEffective = dateEffective;
    }
 
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Date getDateReviewed() {
        return dateReviewed;
    }
    public void setDateReviewed(Date dateReviewed) {
        this.dateReviewed = dateReviewed;
    }
    public Date getDateApproved() {
        return dateApproved;
    }
    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }
    public int getInvestorId() {
        return investorId;
    }
    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public int getSubCategoryId() {
        return subCategoryId;
    }
 
    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
    public int getStatusId() {
        return statusId;
    }
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    @Override
    public void setRevision(String s) {
        // downstream code does not like revision set to emtpy string, which Spring does when binding
        if (s != null && !s.isEmpty()) super.setRevision(s);
    }
     
    public boolean isNew() {
        return getId() == null;
    }
}