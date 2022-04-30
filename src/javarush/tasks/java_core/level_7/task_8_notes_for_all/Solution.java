package javarush.tasks.java_core.level_7.task_8_notes_for_all;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	public class Note {
		public volatile List<String> notes = new ArrayList<>();

		public void addNote(int index, String note) {
			System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
			synchronized (notes) {
				notes.add(index, note);
			}
			System.out.println("Уже добавлена заметка [" + note + "]");
		}

		public void removeNote(int index) {
			System.out.println("Сейчас будет удалена заметка с позиции " + index);
			String note = null;
			synchronized (notes) {
				note = notes.remove(index);
			}
			System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
		}
	}

}
