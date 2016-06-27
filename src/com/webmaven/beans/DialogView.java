package com.webmaven.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "dialogView")
@ViewScoped
public class DialogView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public void destroyWorld() {
	        addMessage("Error en el Sistema", "Por favor intentelo mas tarde.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	

}
