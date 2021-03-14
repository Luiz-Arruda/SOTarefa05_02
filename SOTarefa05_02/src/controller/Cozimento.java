package controller;

import java.util.concurrent.Semaphore;

public class Cozimento extends Thread {
	
	private int idthread;
	private Semaphore semaforo;
//	private float aux;
	
	public Cozimento( int idthread, Semaphore semaforo) {
		this.idthread = idthread;
		this.semaforo = semaforo;
	} // fim metodo cozimento
	
	@Override
	public void run() {
		cozimento();
//		--------- inicio seção critica -------
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
// 		---------- fim seção critica ------
		}
	} // fim run
	
	public void cozimento() {
		int tempoCoz = 0;
		int tempoTot = 0;
		int increm = 100;
		double aux = 0.0;
		if (idthread % 2 != 0) {		// prato de sopa de cebola
			tempoTot = (int) (Math.random() * 601 + 200 );
			// incremento de tempo cozimento
			while (increm < tempoTot) {
				aux = (increm * 100) / tempoTot ;  
				System.out.println("Percentual do prato de Sopa de Cebola " + idthread + " é de " + aux + " %");
				increm += increm;			
			} // fim while
			System.out.println("Prato de Sopa de Cebola " + idthread + " está pronto");
		} // fim if impár 
		
		if (idthread % 2 == 0) {		// prato de lazanha
			tempoTot = (int) (Math.random() * 601 + 600 );
			// incremento de tempo cozimento
			while (increm < tempoTot) {
				aux = (increm * 100) / tempoTot ;  
				System.out.println("Percentual do prato de Lazanha a Bolonhesa " + idthread + " é de " + aux + " %");
				increm += increm;			
			} // fim while
			System.out.println("Prato Lazanha a Bolonhesa " + idthread + " está pronto");
		} // fim if par 		
	} // fim metodo Cozimento
	
	public void entrega() {
		int tempo = 500;
		if (idthread % 2 != 0) {
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println("Prato de Sopa de Cebola " + idthread + " foi entregue");
		}// fim if impar 
		
		else {
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.println("Prato de Lazanha a Bolonhesa " + idthread + " foi entregue");
		}
	}
} // fim da classe
