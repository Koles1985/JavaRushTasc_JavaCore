package javarush.tasks.java_core.level_7.task_9_offers;

public class Solution {

	public volatile int proposal = 0;

	public Solution() {
		new AcceptProposal().start();
		new MakeProposal().start();
	}

	public class MakeProposal extends Thread {
		@Override
		public void run() {
			int thisProposal = proposal;

			while (proposal < 10) {
				System.out.println("Сделано предложение №" + (thisProposal + 1));
				proposal = ++thisProposal;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public class AcceptProposal extends Thread {
		@Override
		public void run() {
			int thisProposal = proposal;

			while (thisProposal < 10) {
				if (thisProposal != proposal) {
					System.out.println("Принято предложение №" + proposal);
					thisProposal = proposal;
				}
			}
		}
	}

}
