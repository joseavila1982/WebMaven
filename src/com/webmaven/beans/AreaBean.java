package com.webmaven.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "areaBean")
@ViewScoped
public class AreaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String nombreJefe;
	private String areaSuperior;	
	
	public void save() {
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + nombre ));
	    this.resetFail();
	}
	
	 public void update() {
	        addMessage("Success", "Data updated");
	    }
	     
	    public void delete() {
	        addMessage("Success", "Data deleted");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    
		public void reset() {
			RequestContext.getCurrentInstance().reset("areaform:panel");
		}
	    public void resetFail() {
	        this.nombre = null;
	        this.nombreJefe = null;
	        this.areaSuperior = null;
	        this.reset();
	        
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getNombreJefe() {
			return nombreJefe;
		}

		public void setNombreJefe(String nombreJefe) {
			this.nombreJefe = nombreJefe;
		}

		public String getAreaSuperior() {
			return areaSuperior;
		}

		public void setAreaSuperior(String areaSuperior) {
			this.areaSuperior = areaSuperior;
		}
	    
}
