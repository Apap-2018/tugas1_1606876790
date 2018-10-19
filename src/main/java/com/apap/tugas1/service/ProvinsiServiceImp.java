package com.apap.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.DBProvinsi;

@Service
@Transactional
public class ProvinsiServiceImp implements ProvinsiService {
	@Autowired
	private DBProvinsi DBProvinsi;

	@Override
	public ProvinsiModel getProvinsiDetailById(long id) {
		return DBProvinsi.getOne(id);
	}

	@Override
	public List<ProvinsiModel> getProvinsiList() {
		return DBProvinsi.findAll();
	}


	//@Override
	//public long countEntity() {
		//return pegawaiDB.count();
	//}

	//@Override
	//public PegawaiModel getPegawaiDetailById(Long id) {
		//return pegawaiDB.getOne(id);
	//}
	
}