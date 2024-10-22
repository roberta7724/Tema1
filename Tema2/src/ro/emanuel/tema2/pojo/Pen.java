package ro.emanuel.tema2.pojo;

public class Pen {

	private int id;
	private String name;
	private int weight;
	private String color;
	public Pen(int id, String name, int weight, String color) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.color = color;
	}
	public Pen(String name, int weight, String color) {
		super();
		this.name = name;
		this.weight = weight;
		this.color = color;
	}
	public Pen() {
		super();
	}
	@Override
	public String toString() {
		return "Pen [id=" + id + ", name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
