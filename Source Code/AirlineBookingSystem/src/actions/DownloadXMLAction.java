package actions;

import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entities.AbstractEntity;
import entities.Airport;

public class DownloadXMLAction extends ActionSupport implements SessionAware {
	
	private InputStream fileInputStream;
	private List<? extends AbstractEntity> listOfEntities;
	private String typeOfEntity;
	private Map<String, Object> sessionMap;

	@Override
	public String execute() throws Exception {
		listOfEntities = (List<? extends AbstractEntity>) sessionMap.get("listOfEntities");
		String filename = typeOfEntity + "Report.xml";
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		for(AbstractEntity entity: listOfEntities){
			encoder.writeObject(entity);
		}
		encoder.close();
		File file = new File(filename);
		fileInputStream = new FileInputStream(file);
		file.delete();
		return SUCCESS;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getTypeOfEntity() {
		return typeOfEntity;
	}

	public void setTypeOfEntity(String typeOfEntity) {
		this.typeOfEntity = typeOfEntity;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;		
	}	

}
