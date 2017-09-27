import java.util.Arrays;
import java.util.List;

public class NGram implements Comparable<NGram> {

	private String[] contents;
	private String separator;
	
	public NGram(List<String> source, String sep) {
		separator = sep;
		contents = new String[source.size()];
		contents = Arrays.copyOf(source.toArray(new String[source.size()]), source.size());
	}
	
	
	
	/*
	 * This method compares this NGram to the NGram that is passed to it
	 * The NGrams are compared element by element. The first element that differs
	 * between the two is compared lexicographically and returned.
	 * If they are lexicographically the same, but one is longer, the shorter one comes first
	 * Otherwise, they are the same.
	 */
	public int compareTo(NGram other) {
		//complete compareTo per the specifications defined by Comparable and the assignment.
		
		//sanity check
		if (other == this){
			return 0;
		}
		//determine which one is shortest, so when you loop through, you don't get array out of bounds
		int shortest = Integer.MAX_VALUE;
		if (contents.length < shortest){
			shortest = contents.length;
		}
		if (other.contents.length < shortest){
			shortest = other.contents.length;
		}
		//loop through each element and compare lexicographically
		for (int i = 0; i < shortest; i++){
			if (!other.contents[i].equals(contents[i])){
				return contents[i].compareTo(other.contents[i]);
			}
		}
		//both are the same up to the shortest one
		//check if they are the same length
		return contents.length - other.contents.length;
	}
	
	
	
	/*
	 * Check if the two NGrams are equal.
	 * They are equal if all of the variables are the same, which is true if the compareTo equals 0
	 * Variables to check: separator, contents
	 */
	public boolean equals(Object o) {
		//complete equals per the specifications defined by the Object class and the assignment.
		if (o == null){
			return false;
		}
		if (o.getClass() != this.getClass()){
			return false;
		}
		//attempt to cast o to an NGram
		try {
			NGram other = (NGram)o;
			if (other.contents.length != contents.length){
				return false;
			}
			if (!separator.equals(other.separator)){
				return false;
			}
			for (int i = 0; i < contents.length; i++){
				if (!contents[i].equals(other.contents[i])){
					return false;
				}
			}
			return true;
		} catch (ClassCastException e){
			return false;
		}
	}
	
	
	
	/*
	 * Calculate a hashCode based on all instance variables
	 * Variables to use: separator, contents
	 */
	public int hashCode() {
		//define a hashCode function which minimizes the number of collisions of NGrams in a HashMap or Set.
		int num = 1;
		num += separator.hashCode()*17;
		for (int i = 0; i < contents.length; i++){
			num += contents[i].hashCode()*(num*(i+1301)%31);
		}
		return num;
	}
	
	
	
	/*
	 * Returns a string that has the last index of the NGram and then the separator
	 * Useful for generating text.
	 */
	public String toString() {
		//create a String representation of an NGram based on the assignment specification.
		if (contents.length > 0){
			return contents[contents.length-1]+separator;
		} else {
			return "";
		}
	}
}