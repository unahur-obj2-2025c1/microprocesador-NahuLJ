package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class IFNZ implements Operable{
	List<Operable> operaciones;
	Programable ultimoEstado = null;
	
	public IFNZ (List<Operable> operaciones) {
		this.operaciones = new ArrayList<>(operaciones);
	}

	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
		
		if (micro.getAcumuladorA() != 0) {
			operaciones.forEach(o -> o.execute(micro));
		}
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
