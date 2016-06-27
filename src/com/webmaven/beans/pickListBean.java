package com.webmaven.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "pickListBean")
@ViewScoped
public class pickListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private DualListModel<String> perfiles;
     
    @PostConstruct
    public void init() {
    	//Perfiles
    	List<String> perfilesSource = new ArrayList<String>();
    	List<String> perfilesTarget = new ArrayList<String>();
        //List<String> citiesSource = new ArrayList<String>();
       // List<String> citiesTarget = new ArrayList<String>();
         
        perfilesSource.add("Administrador");
        perfilesSource.add("Usuario interno");
        perfilesSource.add("Usuario Externo");
        perfilesSource.add("Desarrollador");
        perfilesSource.add("Contador");
        perfilesSource.add("Auxiliar");
        perfilesSource.add("Gerente");
         
        perfiles = new DualListModel<String>(perfilesSource, perfilesTarget);
         
    }

    
    public DualListModel<String> getPerfiles() {
		return perfiles;
	}


	public void setPerfiles(DualListModel<String> perfiles) {
		this.perfiles = perfiles;
	}	
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
}