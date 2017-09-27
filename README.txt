Name: Dylan Peters
NetID: dlp22
Hours Spent: 10.0
Consulted With: NONE
Resources Used: NONE 
Impressions: This was a difficult assignment because some of the variables were ambiguous about what they were supposed to be fork so much of the time was spent figuring out what they did.

I have completed this assignment in accordance with the Duke Community Standard.


A)
1)The length of the text should affect the runtime of MapGenerator and BruteGenerator by n. In other words, the Big-O of the runtime, in terms of number of letters/words is O(n). This is because for both classes, the train() method loops through the training text a single time.
The runtime of the BruteGenerator and MapGenerator, in terms of the k-value or length of words should be O(c) (i.e. constant). This is because the train() method runs n-k times, where n represents the length of the training text, and O(n-k)=O(n), so O is not dependent on k
The runtime of the MapGenerator, in terms of length of random text, is O(n). This is because the generateText() method has a single loop that loops n times and appends a String to the end of the string to return.
The runtime of the BruteGenerator, in terms of length of random text, is also O(n), but it takes much longer than the MapGenerator class. The reason it takes longer is that for each randomly generated text, the program loops through the entire TrainingText object to search for matches. This looping takes a significant amount of time, but because the amount of time it takes is dependent on the length of the training text not the random text, so searching the training text is technically constant time. Therefore, the overall text-generation loop is a single loop, with each iteration being constant time. Therefore it is O(n).

2)For the MapGenerator:
The length of the training text had approximately an O(log(n)) effect on runtime. Based on the data, the mean runtime roughly increased by a factor of two when the length of the training text was increased by approximately a factor of 10 (from 20 to 260). This result is not consistent with the hypothesis.
The k-value or length of word had approximately an O(c) effect on runtime (meaning it did not affect runtime). The data for average runtime stayed between 0.000073 and 0.000230, even when the k value was varied by an order of magnitude. This is consistent with my hypothesis.
The length of the random text had approximately an O(n) effect on runtime. Based on the data, the mean runtime roughly increased by a factor of 10, when the length of the file increased by a factor of 10. This result is consistent with my hypothesis.
For the BruteGenerator:
The length of the training text had approximately an O(n) effect on runtime. This can be seen in the data, as the mean runtime increased by roughly three orders of magnitude, while the file length increased by three orders of magnitude. This result is consistent with my hypothesis.
The k-value or length of word had approximately an O(c) effect on runtime (meaning it did not affect runtime). This can be seen in the data, as the average runtime stayed between 1.062139 and 1.560159, even when the k value increased from 1 to 15. This result is consistent with my hypothesis.
The length of the random text had approximately an O(n) effect on runtime. This can be seen in the data, as an increase by one order of magnitude in the length of text generated results in an increase of one order of magnitude in the runtime. This result is consistent with my hypothesis.

B)
3)The runtime with the default hashcode will be O(n^2) because all the elements will collide and end up in the same bin, so each time the program accesses an element, it must loop through all elements up to the one it wants, rather than simply accessing it directly. Therefore, when the program loops through every element in the set, it is really looping through twice.
The runtime with the hashcode function I wrote should be O(n) because there should be few collisions, so each time the element loops through the map, accessing each elemnt should be constant time.
The runtime with a TreeMap should be O(n^2) because when the program tries to access a certain element, it must go through all elements that appear before that element in the map. Therefore, in the loops in the train() and generateText() methods, the loops in those methods, and the accessing of elements inside those loops, results in O(n^2).

4)For the HashMap with the default hashCode (return constant value), the runtime as a function of the number of keys was roughly O(log(n)), as an increase in an order of magnitude resulted in approximately a doubling of runtime. This result is not consistent with my hypothesis.
For the HashMap with my hashCode, the runtime was approximately O(log(n)), as an increase in an order of magnitude of the number of keys results in slightly less than a doubling of the runtime. This result is not consistent with my hypothesis.
For the TreeMap, the runtime was approximately O(log(n)), as an increase by an order of magnitude of the number of keys resulted in approximately a doubling of runtime. This result is not consistent with my hypothesis. 