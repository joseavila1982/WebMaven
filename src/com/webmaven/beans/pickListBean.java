package com.webmaven.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "pickListBean")
@ViewScoped
public class pickListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String login;
    private DualListModel<String> perfiles;
     
    @PostConstruct
    public void init() {
    	//Perfiles
    	List<String> perfilesSource = new ArrayList<String>();
    	List<String> perfilesTarget = new ArrayList<String>();
         
        perfilesSource.add("Administrador");
        perfilesSource.add("Usuario interno");
        perfilesSource.add("Usuario Externo");
        perfilesSource.add("Desarrollador");
        perfilesSource.add("Contador");
        perfilesSource.add("Auxiliar");
        perfilesSource.add("Gerente");
         
        perfiles = new DualListModel<String>(perfilesSource, perfilesTarget);
         
    }

	public void save() {
		if(perfiles.getTarget().size() > 0){
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfiles Asignados: " + perfiles.getTarget() ));
	        this.resetFail();
	        
		}else{
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia! Debe seleccionar un valor en el campo Perfiles Asignados", ""));
	
		}
		
	}
	
	public void reset() {
		RequestContext.getCurrentInstance().reset("formPerfiles:panel");
	}
    public void resetFail() {
        this.nombre = null;
        this.login = null;
        this.reset();
        
    }
    
    public DualListModel<String> getPerfiles() {
		return perfiles;
	}


	public void setPerfiles(DualListModel<String> perfiles) {
		this.perfiles = perfiles;
	}	
 

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	} 
    
}