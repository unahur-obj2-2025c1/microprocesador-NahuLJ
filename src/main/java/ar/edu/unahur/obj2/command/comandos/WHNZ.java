package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class WHNZ implements Operable{
	List<Operable> operaciones;
	Programable ultimoEstado = null;
	
	public WHNZ (List<Operable> operaciones) {
		this.operaciones = new ArrayList<>(operaciones);
	}

	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
		
		operaciones.forEach(o ->{
			while (micro.getAcumuladorA() != 0){
				o.execute(micro);
			}
		});
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
