package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable {
	private Programable ultimoEstado = null;
	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
		
		Integer valorA = micro.getAcumuladorA();
		Integer valorB = micro.getAcumuladorB();
		micro.setAcumuladorA(valorB);
		micro.setAcumuladorB(valorA);
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
