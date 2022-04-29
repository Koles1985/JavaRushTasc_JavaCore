package javarush.tasks.java_core.level_7.task_3_sinchronized_notes;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {
		
		
	}
	
	public class Note{
		public final List<String> notes = new ArrayList<>(); 
		
		public void addNote(int index, String note) {
			System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
			synchronized(notes) {
				notes.add(index, note);
			}
			System.out.println("Уже добавлена заметка [" + note + "]");
		}
		
		public void remove(int index) {
			System.out.println("Сейчас будет удалена заметка с позиции " + index);
			String note = null;
			synchronized(notes) {
				note = notes.remove(index);
			}
			System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
		}
	}

	
}
