package actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import businessService.AdminService;
import entities.Promotion;

public class GetPromotionsAction extends ActionSupport {
	
	private List<Promotion> listOfPromotions;
	private AdminService adminService;

	@Override
	public String execute() throws Exception {
		adminService = new AdminService();
		listOfPromotions = adminService.getPromotions();
		return SUCCESS;
	}
	


	public List<Promotion> getListOfPromotions() {
		return listOfPromotions;
	}

	public void setListOfPromotions(List<Promotion> listOfPromotions) {
		this.listOfPromotions = listOfPromotions;
	}
	
}
