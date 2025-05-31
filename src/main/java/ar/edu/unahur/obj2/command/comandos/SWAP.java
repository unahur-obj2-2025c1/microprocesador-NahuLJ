package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable{

	@Override
	public void execute(Programable micro) {
		Integer valorA = micro.getAcumuladorA();
		Integer valorB = micro.getAcumuladorB();
		micro.setAcumuladorA(valorB);
		micro.setAcumuladorB(valorA);
		micro.incProgramCounter();
	}

	@Override
	public void undo(Programable micro) {
		
	}

}
