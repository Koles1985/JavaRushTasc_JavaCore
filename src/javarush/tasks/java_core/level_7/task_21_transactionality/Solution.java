package javarush.tasks.java_core.level_7.task_21_transactionality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<String> allLines = new ArrayList<>();
	public static List<String> forRemoveLines = new ArrayList<>();

	public Solution() {

	}

	public void joinData() throws CorruptedDataException {

	}

	private void getPathToTwoFile() {
		String firstPath;
		String secondPath;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			firstPath = reader.readLine();
			secondPath = reader.readLine();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
