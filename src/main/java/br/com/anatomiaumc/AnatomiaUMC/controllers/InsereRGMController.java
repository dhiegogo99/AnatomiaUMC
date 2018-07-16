package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.anatomiaumc.AnatomiaUMC.models.RgmModel;
import br.com.anatomiaumc.AnatomiaUMC.repositories.RgmRepository;
import br.com.anatomiaumc.AnatomiaUMC.services.FileStorage;

@Controller
public class InsereRGMController {

	@Autowired
	FileStorage fileStorage;

	@Autowired
	RgmRepository rgmRepo;

	@GetMapping("/insereRGM")
	public String insereRGM() {
		return "Views/InsereRGM";
	}

	// // @RequestMapping(value = "/insereRGM", method = RequestMethod.POST)
	// private void Insere(File arquivo) throws FileNotFoundException,
	// IOException {
	// System.out.println(arquivo.getName());
	// // HSSFWorkbook workbook = new HSSFWorkbook(new
	// // FileInputStream(arquivo));
	//
	// }
	
	@PostMapping("/insereRGM")
	public String uploadMultipartFile(
			@RequestParam("arquivo") MultipartFile file, Model model) {
		try {
			XSSFWorkbook myWorkBook = new XSSFWorkbook(file.getInputStream());
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					DataFormatter formatter = new DataFormatter();
					RgmModel rgm = new RgmModel();
					rgm.setNumeroRGM(formatter.formatCellValue(cell).toString());
					rgmRepo.save(rgm);
				}
			}
			myWorkBook.close();
		} catch (Exception e) {
			model.addAttribute("message",
					"Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		return "Views/InsereRGM";
	}

	public File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

}
