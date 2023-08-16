package br.com.fiap.main;

import java.io.File;

public class ExcluiDiretorio {

	public static void main(String[] args) {
		try {
			
			File dir = new File("d:/loja");
			String msg = "";
			if (dir.isDirectory()) {
				if (dir.delete()) {
					msg = dir.getName() + " excluido com sucesso";
					
				} else {
					if (exluirFilhos(dir)) {
						msg = dir.getName() + " excluido com sucesso";
					} else {
						msg = "Falha ao excluir pasta "+ dir.getName();
					}
				}
				System.out.println(msg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private static boolean exluirFilhos(File dir) {
		if(dir.isDirectory()) {
			String[] arquivos = dir.list();
			for (String i : arquivos) {
				boolean sucesso = exluirFilhos(new File(dir, i));
				if(sucesso) {
					System.out.println("Exluido: " + i);
				}else {
					System.out.println("Incapaz de excluir "+ i);
					return false;
				}
			}
		}
		return dir.delete();
	}

}
