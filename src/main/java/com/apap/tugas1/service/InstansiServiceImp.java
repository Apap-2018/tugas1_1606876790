package com.apap.tugas1.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.DBInstansi;

@Service
@Transactional
public class InstansiServiceImp implements InstansiService {
	@Autowired
	private DBInstansi DBInstansi;

	@Override
	public List<String> getInstansiList() {
		List<String> listInstansiBersih = new ArrayList();
		Set<String> setInstansiBersih = new HashSet();
		for (InstansiModel instansi:DBInstansi.findAll()) {
			setInstansiBersih.add(instansi.getNama());
		}
		for (String instansi:setInstansiBersih) {
			listInstansiBersih.add(instansi);
		}
		return listInstansiBersih;
	}

	@Override
	public InstansiModel getInstansiById(long id) {
		return DBInstansi.findById(id);
	}

}