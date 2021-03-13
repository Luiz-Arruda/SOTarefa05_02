package view;

import java.util.concurrent.Semaphore;

import controller.Cozimento;


public class Main_cozinhar {

	public static void main(String[] args) {

		int permissoes = 1;   // quantas Threads podem usar simultaneamente
		Semaphore semaforo = new Semaphore(permissoes);  // instanceamento
		for (int idT = 0; idT < 5; idT ++) {
			Thread IDT = new Cozimento(idT, semaforo);
				IDT.start();
			}  // fim for
	} // fim main

	

} // fim classe
