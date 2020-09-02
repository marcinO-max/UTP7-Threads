package zad4;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server implements Runnable {
	ServerSocket serverSocket;	
	ExecutorService executor = Executors.newCachedThreadPool();
	
	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			try {
				Socket socketClient = serverSocket.accept();
				executor.submit(() -> handleConnection(socketClient));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleConnection(Socket socket) {
		Future<String> future = executor.submit(() -> obtainResponse(socket));
		try(BufferedReader scanner = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			while(!Thread.currentThread().isInterrupted()) {
				if(!future.isDone()) {
					if(scanner.ready()) {
						System.out.println("test2");
						String line = scanner.readLine();
						if(line.equalsIgnoreCase("pause"))
							future.cancel(true);
						System.out.println("Linia: " + line);
					}
				} else if(!future.isCancelled()) {
					System.out.println("Zadanie gotowe");
					try {
						String response = future.get();
						try(PrintWriter printer = new PrintWriter(socket.getOutputStream())) {
							printer.println(response);
						}
					} catch (InterruptedException | ExecutionException e) {} //Nigdy nie wystapi - odpowiedz jest juz gotowa
				}
			}
		} catch (Throwable e) {}
	}
	
	private String obtainResponse(Socket socket) throws InterruptedException {
		System.out.println("Rozpoczynam obliczanie...");
		Thread.sleep(50000);
		return "Miala matka syna";
	}
}
