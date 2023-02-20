package StudentComparison;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\denir\\Documents\\dgu_algorithm01\\workspace\\Homework\\src\\샘플주소록.csv"));
	while(true) {
		String line = br.readLine();
		if(line == null) {
			break;
		}
		System.out.println(line);	
		}
	}
}
