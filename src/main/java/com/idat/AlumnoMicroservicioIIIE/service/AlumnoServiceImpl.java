package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;
import com.idat.AlumnoMicroservicioIIIE.model.Alumno;
import com.idat.AlumnoMicroservicioIIIE.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	private AlumnoRepository repository;

	@Override
	public List<AlumnoDTO> listar() {
		List<AlumnoDTO> listadto = new ArrayList<>();
		AlumnoDTO dto = null;

		for (Alumno alumno : repository.findAll()) {
			dto = new AlumnoDTO();
			dto.setApe(alumno.getApellido());
			dto.setNom(alumno.getNombre());
			dto.setCod(alumno.getIdAlumno());
			listadto.add(dto);
		}

		return listadto;
	}

	@Override
	public AlumnoDTO obtenerId(Integer idAlumno) {
		Alumno alumno = repository.findById(idAlumno).orElse(null);

		AlumnoDTO dto = new AlumnoDTO();
		dto.setApe(alumno.getApellido());
		dto.setNom(alumno.getNombre());
		dto.setCod(alumno.getIdAlumno());

		return dto;
	}

	@Override
	public void guardar(AlumnoDTO newAlumno) {
		Alumno alu = new Alumno();
		alu.setApellido(newAlumno.getApe());
		alu.setNombre(newAlumno.getNom());
		alu.setIdAlumno(newAlumno.getCod());

		repository.save(alu);
	}

	@Override
	public void actualizar(AlumnoDTO updateAlumno) {
		Alumno alu = new Alumno();
		alu.setApellido(updateAlumno.getApe());
		alu.setNombre(updateAlumno.getNom());
		alu.setIdAlumno(updateAlumno.getCod());

		repository.saveAndFlush(alu);
	}

	@Override
	public void eliminar(Integer idAlumno) {
		repository.deleteById(idAlumno);
	}

}
