
public class ListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> setList = new List<String>();
		setList.add("Starboy");
		setList.add("Heartless");
		setList.add("Gasoline");
		setList.add("Blinding Lights");
		setList.add("Call Out My Name");
		setList.add("Party Monster");
		setList.add("I was Never There");
		setList.add("Best Friends");
		setList.add("Secrets");
		setList.add("Die For You");
		setList.replace(3, "Take My Breath");
		setList.replace(7, "Less Than Zero");
		setList.remove(5);
		
		System.out.println("Checking if Setlist is empty: " +setList.isEmpty());
		System.out.println("Checking if Heartless is on the Setlist:" +setList.contains("Heartless"));
		System.out.println("Setlist contains " +setList.getLength()+ " songs");
		
		int numOfEntries = setList.getLength();
		for(int position = 1; position <= numOfEntries; position++) {
			System.out.println("Song: " + position + " " + setList.getEntry(position));
		}
		
		
	}

}
