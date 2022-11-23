package com.idat.AlumnoMicroservicioIIIE.service;

import java.util.List;

import com.idat.AlumnoMicroservicioIIIE.dto.AlumnoDTO;

public interface AlumnoService {
	
	List<AlumnoDTO> listar();
	
	AlumnoDTO obtenerId(Integer idAlumno);
	
	void guardar(AlumnoDTO newAlumno);
	
	void actualizar(AlumnoDTO updateAlumno);
	
	void eliminar(Integer idAlumno);	
	
}
