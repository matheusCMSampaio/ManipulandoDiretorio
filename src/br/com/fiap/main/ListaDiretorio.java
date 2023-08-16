package br.com.fiap.main;

import java.io.File;

import javax.swing.JOptionPane;

public class ListaDiretorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String escolha = "Sim";
		while (escolha.equalsIgnoreCase("Sim")) {
			try {
				String path = JOptionPane.showInputDialog("Digite o caminho da pasta \n(utilize / entre as pastas)");
				File dir = new File(path);
				if (dir.isDirectory()) {
					System.out.println("Conteudo da pasta " + path);
					String[] lista = dir.list();                         
					for(String i : lista) {
						System.out.println(i);
					}
				} else {
					System.out.println("Caminho informado incorreto");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
	}

}
