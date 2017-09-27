import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class BruteGenerator implements TextGenerator{
	TrainingText text;
	Random random;

	/*
	 * initialize a BruteGenerator object with a random object that has a random seed
	 */
	public BruteGenerator(){
		random = new Random();
	}
	
	/*
	 * initialize a BruteGenerator object with a random object that has a given seed
	 */
	public BruteGenerator(int seed){
		random = new Random(seed);
	}
	
	
	
	/*
	 * Use the given Scanner, delimiter, and order to create a TrainingText object
	 */
	@Override
	public int train(Scanner source, String delimiter, int k) {
		text = new TrainingText(source,delimiter,k);
		return text.size();
	}
	
	
	
	/*
	 * This method returns a list of all the NGrams that follow the given NGram in the text
	 * This method takes the place of the HashMap that is used in the MapGenerator
	 */
	private ArrayList<NGram> getPossibleGrams(NGram key){
		ArrayList<NGram> toReturn = new ArrayList<NGram>();
		int val = -1;
		while (val+1 < text.size()){
			val = text.indexOf(key, val+1);
			if (val+1 < text.size()){
				toReturn.add(text.get(val+1));
			}
		}
		return toReturn;
	}
	
	
	
	/*
	 * Return a String that has pseudorandomly generated Strings based on the training text
	 */
	@Override
	public String generateText(int length) {
		//Get the seed NGram based on the seed random number
		NGram currentGram = text.get(random.nextInt(text.size()));
		StringBuilder toReturn = new StringBuilder(length);
		for (int i = 0; i < length; i++){
			//get the list of all NGrams that follow the seed NGram
			ArrayList<NGram> possibleNextNGrams = getPossibleGrams(currentGram);
			//pick a random NGram from the list of possible NGrams
			currentGram = possibleNextNGrams.get(random.nextInt(possibleNextNGrams.size()));
			//add the NGram's last entry to the string to return
			//you use only the last entry so that you don't repeat the previous ones
			toReturn.append(currentGram.toString());
		}
		return toReturn.toString();
	}
	
}