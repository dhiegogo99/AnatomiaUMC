package br.com.anatomiaumc.AnatomiaUMC.controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

import br.com.anatomiaumc.AnatomiaUMC.models.Role;
import br.com.anatomiaumc.AnatomiaUMC.models.User;
import br.com.anatomiaumc.AnatomiaUMC.repositories.RolesRepository;
import br.com.anatomiaumc.AnatomiaUMC.repositories.UserRepository;
import br.com.anatomiaumc.AnatomiaUMC.services.FileStorage;
import br.com.anatomiaumc.AnatomiaUMC.util.Validations;

@Controller
public class RegisterChapa {
	
	Validations valid = new Validations();

	@Autowired
	RolesRepository rolesrepo;
	@Autowired
	FileStorage fileStorage;

	@Autowired
	UserRepository userRepo;

	@GetMapping("/RegisterChapa")
	public String RegisterChapa() {
		return "Views/admin/RegisterChapa";
	}

	
	@PostMapping("/RegisterChapa")
	public String uploadMultipartFileChapa(
			@RequestParam("file") MultipartFile file, Model model) {
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
					String aux = formatter.formatCellValue(cell)
							.toString();
					if (valid.validTeacher(aux)) {
						
						User user = new User();
						user.setLogin(formatter.formatCellValue(cell)
								.toString());
						Set<Role> roles = new HashSet<Role>();
						Role role = new Role();
						role = rolesrepo.findByRole("PROFESSOR");
						roles.add(role);
						user.setRoles(roles);
						user.setStatus(false);
						user.setLogin(formatter.formatCellValue(cell)
								.toString());
						userRepo.save(user);
						
					
					}
				}
			}
			myWorkBook.close();
		} catch (Exception e) {
			model.addAttribute("message",
					"Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
		return "Views/admin/RegisterChapa";
	}

	public File multipartToFile(MultipartFile multipart)
			throws IllegalStateException, IOException {
		File convFile = new File(multipart.getOriginalFilename());
		multipart.transferTo(convFile);
		return convFile;
	}

}
