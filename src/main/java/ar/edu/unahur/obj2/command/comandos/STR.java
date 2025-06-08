package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR extends OperableCommand {
	private Integer pos;
	
	public STR(Integer pos) {
		this.pos = pos;
	}
	
	@Override
	public void executeConcreto(Programable micro) {
		micro.setAddr(pos);
	}
}
