package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {	
	
	 List<Empleado> findByNombre(String nombre);

}
