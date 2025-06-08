package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV extends OperableCommand{
	private Integer valor;
	
	public LODV(Integer valor) {
		this.valor = valor;
	}
	
	@Override
	public void executeConcreto(Programable micro) {
		micro.setAcumuladorA(valor);
	}
}
