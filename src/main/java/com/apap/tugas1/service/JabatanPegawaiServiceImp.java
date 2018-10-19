package com.apap.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.DBJabatanPegawai;

@Service
@Transactional
public class JabatanPegawaiServiceImp implements JabatanPegawaiService {
	@Autowired
	private DBJabatanPegawai DBJabatanPegawai;

	@Override
	public List<JabatanPegawaiModel> getJabatanByPegawaiId(long id) {
		return null;
	}

	@Override
	public long sizeJabatanPegawai() {
		return DBJabatanPegawai.count();
	}

	@Override
	public JabatanPegawaiModel checkWho(long id) {
		return DBJabatanPegawai.getOne(id);
	}

}