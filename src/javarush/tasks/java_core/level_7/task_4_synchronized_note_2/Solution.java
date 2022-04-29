package javarush.tasks.java_core.level_7.task_4_synchronized_note_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {

	}
	
	public class Note{
		public final List<String> notes = new ArrayList<>(); 
		
		public synchronized void addNote(int index, String note) {
			System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
			notes.add(index, note);
			System.out.println("Уже добавлена заметка [" + note + "]");
		}
		
		public synchronized void remove(int index) {
			System.out.println("Сейчас будет удалена заметка с позиции " + index);
			String note = null;
			note = notes.remove(index);
			System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
		}
	}

}
