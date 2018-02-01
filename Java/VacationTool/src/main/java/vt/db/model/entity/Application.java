package vt.db.model.entity;

import vt.db.model.entity.base.Entity;

public class Application extends Entity {
	private static final long serialVersionUID = -1142522010772045610L;
	private Integer appType;
	private String appDateFrom;
	private String appDateTo;
	private Integer appDays;
	private Integer appReplacement;
	private String appComment;
	private Integer appEmployeeId;
	private String appCreatedDate;
	private Integer appAcceptedManager;
	private String appAcceptedDate;
	private Integer appModifiedBy;
	private String appModifiedDate;
	private String appStatus;
	private String appPdf;
	private String appManagerComment;
	
	
	public Application() {
		super();
	}
	public Application(Integer appType, String appDateFrom, String appDateTo, Integer appDays, Integer appReplacement,
			String appComment, Integer appEmployeeId, String appCreatedDate, Integer appAcceptedManager,
			String appAcceptedDate, Integer appModifiedBy, String appModifiedDate, String appStatus, String appPdf, String appManagerComment) {
		super();
		this.appType = appType;
		this.appDateFrom = appDateFrom;
		this.appDateTo = appDateTo;
		this.appDays = appDays;
		this.appReplacement = appReplacement;
		this.appComment = appComment;
		this.appEmployeeId = appEmployeeId;
		this.appCreatedDate = appCreatedDate;
		this.appAcceptedManager = appAcceptedManager;
		this.appAcceptedDate = appAcceptedDate;
		this.appModifiedBy = appModifiedBy;
		this.appModifiedDate = appModifiedDate;
		this.appStatus = appStatus;
		this.appPdf = appPdf;
		this.setAppManagerComment(appManagerComment);
	}
	

	public Integer getAppType() {
		return this.appType;
	}
	public void setAppType(Integer appType) {
		this.appType = appType;
	}
	public String getAppDateFrom() {
		return this.appDateFrom;
	}
	public void setAppDateFrom(String appDateFrom) {
		this.appDateFrom = appDateFrom;
	}
	public String getAppDateTo() {
		return this.appDateTo;
	}
	public void setAppDateTo(String appDateTo) {
		this.appDateTo = appDateTo;
	}
	public Integer getAppDays() {
		return this.appDays;
	}
	public void setAppDays(Integer appDays) {
		this.appDays = appDays;
	}
	public Integer getAppReplacement() {
		return this.appReplacement;
	}
	public void setAppReplacement(Integer appReplacement) {
		this.appReplacement = appReplacement;
	}
	public String getAppComment() {
		return this.appComment;
	}
	public void setAppComment(String appComment) {
		this.appComment = appComment;
	}
	public Integer getAppEmployeeId() {
		return this.appEmployeeId;
	}
	public void setAppEmployeeId(Integer appEmployeeId) {
		this.appEmployeeId = appEmployeeId;
	}
	public String getAppCreatedDate() {
		return this.appCreatedDate;
	}
	public void setAppCreatedDate(String appCreatedDate) {
		this.appCreatedDate = appCreatedDate;
	}
	public Integer getAppAcceptedManager() {
		return this.appAcceptedManager;
	}
	public void setAppAcceptedManager(Integer appAcceptedManager) {
		this.appAcceptedManager = appAcceptedManager;
	}
	public String getAppAcceptedDate() {
		return this.appAcceptedDate;
	}
	public void setAppAcceptedDate(String appAcceptedDate) {
		this.appAcceptedDate = appAcceptedDate;
	}
	public Integer getAppModifiedBy() {
		return this.appModifiedBy;
	}
	public void setAppModifiedBy(Integer appModifiedBy) {
		this.appModifiedBy = appModifiedBy;
	}
	public String getAppModifiedDate() {
		return this.appModifiedDate;
	}
	public void setAppModifiedDate(String appModifiedDate) {
		this.appModifiedDate = appModifiedDate;
	}
	public String getAppStatus() {
		return this.appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getAppPdf() {
		return this.appPdf;
	}
	public void setAppPdf(String appPdf) {
		this.appPdf = appPdf;
	}
	public String getAppManagerComment() {
		return appManagerComment;
	}
	public void setAppManagerComment(String appManagerComment) {
		this.appManagerComment = appManagerComment;
	}
}