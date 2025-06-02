package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
	private Integer a = 0; 
	private Integer b = 0;
	private Integer programCounter = 0;
	private List<Integer> datos = new ArrayList<>();
	
	@Override
	public void run(List<Operable> operaciones) {
		operaciones.stream().forEach(o -> o.execute(this));
	}

	@Override
	public void incProgramCounter() {
		programCounter ++;
	}

	@Override
	public Integer getProgramCounter() {
		return programCounter;
	}

	@Override
	public void setAcumuladorA(Integer value) {
		a = value;
	}

	@Override
	public Integer getAcumuladorA() {
		return a;
	}

	@Override
	public void setAcumuladorB(Integer value) {
		b = value;
	}

	@Override
	public Integer getAcumuladorB() {
		return b;
	}

	@Override
	public void copyFrom(Programable programable) {
		
	}

	@Override
	public Programable copy() {
		return null;
	}

	@Override
	public void reset() {
		a = 0;
		b = 0;
		programCounter = 0;
	}

	@Override
	public void setAddr(Integer addr) {
		if (addr < 0 || addr > 1023) {
			throw new MicroException("Error al colocar dato en posicion" + addr + ", solo se soportan valores entre 0 y 1023 inclusive");
		}
		datos.add(a);
	}

	@Override
	public Integer getAddr(Integer addr) {
		if (addr < 0 || addr > 1023) {			
			throw new MicroException("No existe un dato en la posicion " + addr);
		}
		return datos.get(addr);
	}

}