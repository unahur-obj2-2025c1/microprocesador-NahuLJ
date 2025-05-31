package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable{

	@Override
	public void execute(Programable micro) {
		micro.setAcumuladorA(micro.getAcumuladorA() + micro.getAcumuladorB());
		micro.setAcumuladorB(0);
		micro.incProgramCounter();
	}

	@Override
	public void undo(Programable micro) {

	}

}
