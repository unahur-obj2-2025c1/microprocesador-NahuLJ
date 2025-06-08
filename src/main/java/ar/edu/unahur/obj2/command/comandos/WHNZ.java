package ar.edu.unahur.obj2.command.comandos;

import java.util.List;

import ar.edu.unahur.obj2.command.Programable;

public class WHNZ extends OperableCommandComposite{
	
	public WHNZ (List<Operable> operaciones) {
		super(operaciones);
	}

	@Override
	public void executeConcreto(Programable micro) {
		while (micro.getAcumuladorA() != 0) {
			operaciones.forEach(o ->{
				o.execute(micro);
			});
		}
	}
}
