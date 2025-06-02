package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR implements Operable{
	private Integer pos;
	
	public STR(Integer pos) {
		this.pos = pos;
	}
	
	@Override
	public void execute(Programable micro) {
		micro.incProgramCounter();
		micro.setAddr(pos);
	}

	@Override
	public void undo(Programable micro) {
		
	}
}
