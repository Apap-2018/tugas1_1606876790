package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;


@Controller
public class JabatanController {
	@Autowired
	private PegawaiService pegawaiService;

	@Autowired
	private ProvinsiService provinsiService;
	
	@Autowired 
	private JabatanService jabatanService;

	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.GET)
	private String addJabatan(Model model) {
		JabatanModel jabatan = new JabatanModel();
		
		model.addAttribute("jabatan", jabatan);
		return "add-jabatan";
	}

	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.POST)
	private String addJabatanSubmit(@ModelAttribute JabatanModel jabatan, Model model) {
		jabatanService.addJabatan(jabatan);
		model.addAttribute("jabatan", jabatan);
		return "add-jabatan-sukses";
	}
	
	@RequestMapping(value = "/jabatan/view", method = RequestMethod.GET)
	public String viewJabatan(@RequestParam("idJabatan") long idJabatan, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanDetailById(idJabatan);
		model.addAttribute("jabatan", jabatan);
		return "view-jabatan";
	}
	
	@RequestMapping(value = "/jabatan/viewall", method = RequestMethod.GET)
	private String viewAllJabatan(Model model) {
		List <JabatanModel> jabatan = jabatanService.findAllJabatan();
		model.addAttribute("listJabatan", jabatan);
		model.addAttribute("pageTitle", "Viewall Jabatan");
		return "view-all-jabatan";
	}
	
}