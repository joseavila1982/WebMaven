package com.webmaven.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.webmaven.entity.Car;

@ManagedBean(name = "dtTableBean")
@ViewScoped
public class TableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> cars;
    private Car selectedCar;
    private List<Car> selectedCars;
	 
    
	 @PostConstruct
	    public void init() {
	        cars = createCars(100);
	    }
	    
	    
	public List<Car> createCars(int size) {
		List<Car> list = new ArrayList<Car>();
		for (int i = 0; i < size; i++) {
			list.add(new Car(getRandomId(), getRandomYear(), getRandomBrand(), getRandomColor()));
		}

		return list;
	}
	
	public void deleteCar() {
		cars.remove(selectedCar);
		selectedCar = null;
	}
    
	  private final static String[] colors;
     
	  private final static String[] brands;
	     
	    static {
	        colors = new String[10];
	        colors[0] = "Black";
	        colors[1] = "White";
	        colors[2] = "Green";
	        colors[3] = "Red";
	        colors[4] = "Blue";
	        colors[5] = "Orange";
	        colors[6] = "Silver";
	        colors[7] = "Yellow";
	        colors[8] = "Brown";
	        colors[9] = "Maroon";
	         
	        brands = new String[10];
	        brands[0] = "BMW";
	        brands[1] = "Mercedes";
	        brands[2] = "Volvo";
	        brands[3] = "Audi";
	        brands[4] = "Renault";
	        brands[5] = "Fiat";
	        brands[6] = "Volkswagen";
	        brands[7] = "Honda";
	        brands[8] = "Jaguar";
	        brands[9] = "Ford";
	    }
	    
	    private String getRandomId() {
	        return UUID.randomUUID().toString().substring(0, 8);
	    }
	     
	    private int getRandomYear() {
	        return (int) (Math.random() * 50 + 1960);
	    }
	     
	    private String getRandomColor() {
	        return colors[(int) (Math.random() * 10)];
	    }
	     
	    private String getRandomBrand() {
	        return brands[(int) (Math.random() * 10)];
	    }
	     
	 
	    public List<String> getColors() {
	        return Arrays.asList(colors);
	    }
	     
	    public List<String> getBrands() {
	        return Arrays.asList(brands);
	    }

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Car> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Car> selectedCars) {
		this.selectedCars = selectedCars;
	}

}
