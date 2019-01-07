package business;

public class Stuffy {
	
	private int id;
	private String type;
	private String size;
	private String color;

	public Stuffy(int id, String type, String size, String color) {
		this.id = id;
		this.type = type;
		this.size = size;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Stuffy [id=" + id + ", type=" + type + ", size=" + size + ", color=" + color + "]";
	}
	
	
}
