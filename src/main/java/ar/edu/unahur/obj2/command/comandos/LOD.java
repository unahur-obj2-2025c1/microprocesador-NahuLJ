package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD extends OperableCommand {
	private Integer pos;
	
	public LOD(Integer pos) {
		this.pos = pos;
	}
	
	@Override
	public void executeConcreto(Programable micro) {		
		micro.setAcumuladorA(micro.getAddr(pos));
	}
}
