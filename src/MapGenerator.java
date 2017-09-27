import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class MapGenerator implements TextGenerator{
	HashMap<NGram,ArrayList<NGram>> nGrams;
	TrainingText text;
	Random random;
	
	/*
	 * initialize a MapGenerator object with a random object that has a random seed
	 * The HashMap is used to associate each NGram to a list of NGrams that follow it
	 */
	public MapGenerator(){
		nGrams = new HashMap<NGram,ArrayList<NGram>>();
		random = new Random();
	}
	
	/*
	 * initialize a MapGenerator object with a random object that has a given seed
	 * The HashMap is used to associate each NGram to a list of NGrams that follow it
	 */
	public MapGenerator(int seed){
		nGrams = new HashMap<NGram,ArrayList<NGram>>();
		random = new Random((long)seed);
	}
	
	
	
	/*
	 * Use the given Scanner, delimiter, and order to create a TrainingText object
	 */
	@Override
	public int train(Scanner source, String delimiter, int k) {
		// TODO Auto-generated method stub
		nGrams.clear();
		text = new TrainingText(source,delimiter,k);
		for (int i = 0; i < text.size()-1; i++){
			NGram key = text.get(i);
			NGram val = text.get(i+1);
			if (!nGrams.containsKey(key)){
				nGrams.put(key, new ArrayList<NGram>());
			}
			nGrams.get(key).add(val);
		}
		return nGrams.keySet().size();
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
			ArrayList<NGram> possibleNextNGrams = nGrams.get(currentGram);
			//pick a random NGram from the list of possible NGrams
			currentGram = possibleNextNGrams.get(random.nextInt(possibleNextNGrams.size()));
			//add the NGram's last entry to the string to return
			//you use only the last entry so that you don't repeat the previous ones
			toReturn.append(currentGram.toString());
		}
		return toReturn.toString();
	}
	
}