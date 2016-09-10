package pod.q5.node1;

import java.util.Timer;
import java.util.TimerTask;

import pod.q5.node1.impl.Node1Impl;

public class Main {
	
	private static void startTask(INode1 node){
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				node.sync();//sincroniza (tarefa de background)
			}
		}, 5000, 60000);
	}

	public static void main(String[] args) throws InterruptedException {
		Node1Impl impl = new Node1Impl();
		//
		startTask(impl);
		//
		for (int i = 0; i < 5; i++){
			impl.request();//tenta requisitar (true)
			Thread.sleep(90000);//enquanto isto altere a lista no disco
		}
	}
}
