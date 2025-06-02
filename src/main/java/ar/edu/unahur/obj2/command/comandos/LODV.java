package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV implements Operable{
	private Integer valor;
	
	public LODV(Integer valor) {
		this.valor = valor;
	}
	
	@Override
	public void execute(Programable micro) {
		micro.incProgramCounter();
		micro.setAcumuladorA(valor);
	}

	@Override
	public void undo(Programable micro) {
		
	}
}
