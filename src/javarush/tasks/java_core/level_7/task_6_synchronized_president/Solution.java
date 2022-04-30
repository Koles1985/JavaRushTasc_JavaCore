package javarush.tasks.java_core.level_7.task_6_synchronized_president;

public class Solution {

	public Solution() {
		OurPresident expectedPresident = OurPresident.getOurPresident();
		OurPresident ourPresident = OurPresident.getOurPresident();
		System.out.println("ExpectedPresident = ourPresident - " + (expectedPresident == ourPresident));
	}
}
