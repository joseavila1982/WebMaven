package com.webmaven.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "graphicImageView")
@ViewScoped
public class GraphicImageView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private StreamedContent chart;
	 
	    @PostConstruct
	    public void init() {
	        try {
	            //Chart
	            chart = new DefaultStreamedContent(null, "../imagen/ajax-loader.gif");
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public StreamedContent getChart() {
	        return chart;
	    }
	     


}
