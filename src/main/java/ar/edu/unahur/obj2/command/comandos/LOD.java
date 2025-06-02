package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable{
	private Integer pos;
	
	public LOD(Integer pos) {
		this.pos = pos;
	}
	
	@Override
	public void execute(Programable micro) {
		micro.incProgramCounter();
		micro.setAcumuladorA(micro.getAddr(pos));
	}

	@Override
	public void undo(Programable micro) {
		
	}
}
