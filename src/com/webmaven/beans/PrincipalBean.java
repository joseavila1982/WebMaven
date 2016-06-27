package com.webmaven.beans;

import java.io.Serializable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "principalBean")
@ViewScoped
public class PrincipalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String nit;
	 private String usuarioRed;
	 private String email;
	 private String region;
	 private String comentarios;
	 private Integer opcion;
	 private Date fechaIngreso;
	 private Date fechaEgreso;
	 
	public void save() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido " + usuarioRed));
		this.resetFail();
	}

	public void reset() {
		RequestContext.getCurrentInstance().reset("form1:panel");
	}
	
    public void resetFail() {
        this.nit = null;
        this.usuarioRed = null;
        this.email = null;
        this.region = null;
        this.comentarios = null;
        this.opcion = null;
        this.fechaIngreso = null;
        this.fechaEgreso = null;
        this.reset();
        
    }
    
	 public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getObject())));
	 }
	
	    public void postProcessXLS(Object document) {
	        HSSFWorkbook wb = (HSSFWorkbook) document;
	        HSSFSheet sheet = wb.getSheetAt(0);
	        CellStyle style = wb.createCellStyle();
	        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
	 
	        for (Row row : sheet) {
	            for (Cell cell : row) {
	                cell.setCellValue(cell.getStringCellValue().toUpperCase());
	                cell.setCellStyle(style);
	            }
	        }
	    }
	    
	 
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getUsuarioRed() {
		return usuarioRed;
	}

	public void setUsuarioRed(String usuarioRed) {
		this.usuarioRed = usuarioRed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getOpcion() {
		return opcion;
	}

	public void setOpcion(Integer opcion) {
		this.opcion = opcion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	 
	 

}
