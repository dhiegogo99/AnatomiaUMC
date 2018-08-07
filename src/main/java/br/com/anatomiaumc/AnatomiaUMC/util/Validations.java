package br.com.anatomiaumc.AnatomiaUMC.util;

public class Validations {
	public boolean validTeacher(String chapa) {
		chapa = chapa.toUpperCase();
		boolean resp = false;
		if (chapa != null) {
			if (chapa.length() == 8) {
				if (chapa.startsWith("UM")) {
					char[] c = chapa.substring(2, 8).toCharArray();

					for (char l : c) {
						if (!Character.isAlphabetic(l)) {
							resp = true;
						} else {
							resp = false;
							break;
						}
					}
				}
			}
		}

		return resp;
	}

	public boolean validStudent(String rgm) {
		boolean resp = false;
		if (rgm != null) {
			if (rgm.length() == 11) {
				if (rgm.charAt(0) == '1'
						&& (rgm.charAt(1) == '1' || rgm.charAt(1) == '2')) {
					char[] c = rgm.toCharArray();
					for (char l : c) {
						if (!Character.isAlphabetic(l)) {
							resp = true;
						} else {
							resp = false;
							break;
						}
					}
				}
			}
		}
		return resp;

	}

}
