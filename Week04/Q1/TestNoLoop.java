package HW.Week4.Q1;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNoLoop {
	@Test
	void testNoLoop() throws FileNotFoundException { // 4 marks
		// You must provide the correct path for your file
		//File f = new File("ShiftableList.java");
		File f = new File("C:/Users/Asus/Desktop/Eclipse_work/DataAlgo/src/HW/Week4/Q1/ShiftableList.java");
		Scanner s = new Scanner(f);

		boolean foundLoop = false;
		String line = "";
		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("shift(DListNode")) {
				break;
			}
		}

		while (s.hasNextLine()) {
			if (line.contains("for") || line.contains("while")) {
				foundLoop = true;
				break;
			}
			line = s.nextLine();
		}
		s.close();
		assertFalse(foundLoop);

	}

}
