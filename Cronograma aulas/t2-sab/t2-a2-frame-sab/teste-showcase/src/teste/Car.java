package teste;

public class Car {
	
	private String id;
	private String brand;
	private int year;
	private String color;
	private int randomPrice;
	private boolean randomSoldState;

	public Car(String id, String brand, int year, String color, int randomPrice, boolean randomSoldState) {
		super();
		this.setId(id);
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.randomPrice = randomPrice;
		this.randomSoldState = randomSoldState;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRandomPrice() {
		return randomPrice;
	}

	public void setRandomPrice(int randomPrice) {
		this.randomPrice = randomPrice;
	}

	public boolean isRandomSoldState() {
		return randomSoldState;
	}

	public void setRandomSoldState(boolean randomSoldState) {
		this.randomSoldState = randomSoldState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
