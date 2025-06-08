package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class OperableCommand implements Operable{
	private Programable ultimoEstado;
	
	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		
		this.executeConcreto(micro);
	}

	public abstract void executeConcreto(Programable micro);

	
	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}

}
