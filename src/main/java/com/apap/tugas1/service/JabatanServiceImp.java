package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.DBJabatan;

@Service
@Transactional
public class JabatanServiceImp implements JabatanService {
	@Autowired
	private DBJabatan DBJabatan;

	@Override
	public List<JabatanModel> findAllJabatan() {
		return DBJabatan.findAll();
	}

	@Override
	public void addJabatan(JabatanModel jabatan) {
		DBJabatan.save(jabatan);
	}

	@Override
	public JabatanModel getJabatanDetailById(long id) {
		return DBJabatan.findById(id);
	}
}

	
	
