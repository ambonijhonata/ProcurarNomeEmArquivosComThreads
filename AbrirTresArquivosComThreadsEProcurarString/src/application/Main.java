package application;

import java.io.File;

import Threads.FileOpener;

public class Main {

	public static void main(String[] args) {
		File file1 = new File(System.getProperty("user.dir") + "\\1nomes-fev-2002.txt");
		File file2 = new File(System.getProperty("user.dir") + "\\2nomes-fev-2016.txt");
		File file3 = new File(System.getProperty("user.dir") + "\\3nomes-out-2014.txt");
		String search = "Holger Scheller";
		 
		Thread thread1 = new Thread(new FileOpener(file1, search), "Thread 1");
		thread1.start();		

		Thread thread2 = new Thread(new FileOpener(file2, search), "Thread 2");
		thread2.start();

		Thread thread3 = new Thread(new FileOpener(file3, search), "Thread 3");
		thread3.start();
				
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
