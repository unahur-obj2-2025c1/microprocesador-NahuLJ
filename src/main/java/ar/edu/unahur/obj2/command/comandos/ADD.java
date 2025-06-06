package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable{
	private Programable ultimoEstado = null;
	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
		
		micro.setAcumuladorA(micro.getAcumuladorA() + micro.getAcumuladorB());
		micro.setAcumuladorB(0);
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
