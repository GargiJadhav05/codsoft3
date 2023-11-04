import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount{
public static void main(String[] args) {
System.out.println("Welcome to the Word Count Tool!");
System.out.println("Please enter the text or provide the path to a file: ");

try (BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in))) {
String userInput = br.readLine();

// Read the input text or file
String inputText;
if (userInput.toLowerCase().endsWith(".txt")) {
try {
inputText = readFile(userInput);
} catch (IOException e) {
System.out.println("File not found.");
return;
}
} else {
inputText = userInput;
}

// Split the text into words
String[] words = inputText.toLowerCase().split("[\\s\\p{Punct}]+");

// Initialize a counter variable
Map<String, Integer> wordCount = new HashMap<>();

// Count the words
for (String word : words) {
wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}

// Display the total word count
System.out.println("Total word count: " + words.length);

// Display word frequency
System.out.println("\nWord frequency:");
for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
System.out.println(entry.getKey() + ": " + entry.getValue());
}
} catch (IOException e) {
e.printStackTrace();
}
}

private static String readFile(String filePath) throws IOException {
StringBuilder content = new StringBuilder();
try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
String line;
while ((line = br.readLine()) != null) {
content.append(line).append("\n");
}
}
return content.toString();
}
}