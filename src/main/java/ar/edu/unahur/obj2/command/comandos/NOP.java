package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class NOP implements Operable {
	private Programable ultimoEstado = null;
	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
