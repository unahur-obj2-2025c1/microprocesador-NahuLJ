package ar.edu.unahur.obj2.command.comandos;

import java.util.ArrayList;
import java.util.List;

public abstract class OperableCommandComposite extends OperableCommand {
	protected List<Operable> operaciones;
	
	protected OperableCommandComposite(List<Operable> operaciones) {
		this.operaciones = new ArrayList<>(operaciones);
	}
}
