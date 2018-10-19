package com.apap.tugas1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.DBPegawai;

@Service
@Transactional
public class PegawaiServiceImp implements PegawaiService {
	@Autowired
	private DBPegawai DBPegawai;

	@Override
	public PegawaiModel getPegawaiDetailByNip(String nip) {
		return DBPegawai.findByNip(nip);
	}

	@Override
	public double getGajiLengkapByNip(String nip) {
		double gajiLengkap = 0;
		PegawaiModel pegawai = this.getPegawaiDetailByNip(nip);
		double gajiTerbesar = 0; 
		for (JabatanModel jabatan:pegawai.getListJabatan()) {
			if (jabatan.getGaji_pokok() > gajiTerbesar) {
				gajiTerbesar = jabatan.getGaji_pokok();
			}
		}
		System.out.println("Pokok: " + gajiTerbesar);
		gajiLengkap += gajiTerbesar;
		double presentaseTunjangan = pegawai.getInstansi().getProvinsi().getPresentaseTunjangan();
		System.out.println("Presentase: " + presentaseTunjangan);
		gajiLengkap += (gajiLengkap * presentaseTunjangan/100);
		System.out.println("Lengkap: " + gajiLengkap);
		return gajiLengkap;
	}

	@Override
	public void addPegawai(PegawaiModel pegawai) {
		DBPegawai.save(pegawai);
	}

	@Override
	public PegawaiModel getPegawaiDetailById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}