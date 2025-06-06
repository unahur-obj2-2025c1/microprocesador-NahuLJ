package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR implements Operable{
	private Integer pos;
	private Programable ultimoEstado = null;
	
	public STR(Integer pos) {
		this.pos = pos;
	}
	
	@Override
	public void execute(Programable micro) {
		ultimoEstado = micro.copy();
		micro.incProgramCounter();
		micro.setUltimaOperacion(this);
		
		micro.setAddr(pos);
	}

	@Override
	public void undo(Programable micro) {
		micro.copyFrom(ultimoEstado);
	}
}
