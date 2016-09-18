package actions;


import com.opensymphony.xwork2.ActionSupport;

import businessService.AdminService;

public class ChangePromotionAction extends ActionSupport{
	
	private String originId;
	private String destinationId;
	private String value;
	private AdminService adminService;

	@Override
	public String execute() throws Exception {
		adminService = new AdminService();
		adminService.setPromotion(originId, destinationId,value);
		return SUCCESS;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
