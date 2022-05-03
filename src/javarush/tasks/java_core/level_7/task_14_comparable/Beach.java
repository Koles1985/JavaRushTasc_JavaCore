package javarush.tasks.java_core.level_7.task_14_comparable;

public class Beach implements Comparable<Beach>{
	
	private String name; // Название
	private float distance; //Расстояние
	private int quality; //Качество
	
	public Beach(String name, float distance, int quality) {
		this.name = name;
		this.distance = distance;
		this.quality = quality;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized float getDistance() {
		return distance;
	}

	public synchronized void setDistance(float distance) {
		this.distance = distance;
	}

	public synchronized int getQuality() {
		return quality;
	}

	public synchronized void setQuality(int quality) {
		this.quality = quality;
	}

	@Override
	public synchronized int compareTo(Beach other) {
		int thisScores = 0;
		int otherScores = 0;
		if(this.quality > other.getQuality()) {
			thisScores++;
		}else if(this.quality < other.getQuality()) {
			otherScores++;
		}
		if(this.distance < other.distance) {
			thisScores++;
		}else if(this.distance > other.getDistance()) {
			otherScores++;
		}
		
		return thisScores - otherScores;
		
	}
	
	

}
