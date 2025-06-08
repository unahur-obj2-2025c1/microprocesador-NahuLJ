package ar.edu.unahur.obj2.command;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.*;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MicroprocesadorTest {
	
	@Test
	void hacerAvanzar3Veces() {
		List<Operable> builder = new ProgramBuilder().nop().nop().nop().build();
		Microprocesador micro = new Microprocesador();
		
		micro.run(builder);
		
		assertEquals(3,micro.getProgramCounter());
		assertEquals(0,micro.getAcumuladorA());
		assertEquals(0,micro.getAcumuladorB());
	}
	
	@Test
	void sumar20y17() {
		Microprocesador micro = new Microprocesador();		
		Operable lodv1 = new LODV(20);
		Operable swap = new SWAP();
		Operable lodv2 = new LODV(17);
		Operable add = new ADD();
		
		List<Operable> operaciones = List.of(lodv1,swap,lodv2,add);
		micro.run(operaciones);
		
		assertEquals(4,micro.getProgramCounter());
		assertEquals(37,micro.getAcumuladorA());
		assertEquals(0,micro.getAcumuladorB());
		
		add.undo(micro);
		assertEquals(3,micro.getProgramCounter());
		assertEquals(17,micro.getAcumuladorA());
		assertEquals(20,micro.getAcumuladorB());
		
		lodv2.undo(micro);
		assertEquals(2,micro.getProgramCounter());
		assertEquals(0,micro.getAcumuladorA());
		assertEquals(20,micro.getAcumuladorB());
	}
	
	@Test
	void sumar2y8y5() {
		List<Operable> builder = new ProgramBuilder().lodv(2).str(0).lodv(8).swap().lodv(5).add().swap().lod(0).add().build();
		Microprocesador micro = new Microprocesador();
		
		micro.run(builder);
		
		assertEquals(9,micro.getProgramCounter());
		assertEquals(15,micro.getAcumuladorA());
		assertEquals(0,micro.getAcumuladorB());
	}
	
	@Test
	void sumar2y8y5PeroConElLOD12345TiraError() {
		List<Operable> builder = new ProgramBuilder().lodv(2).str(0).lodv(8).swap().lodv(5).add().swap().lod(12345).add().build();
		Microprocesador micro = new Microprocesador();
		
		assertThrows(MicroException.class, () -> {
			micro.run(builder);
			}
		);
		
		assertEquals(8,micro.getProgramCounter());
		assertEquals(0,micro.getAcumuladorA());
		assertEquals(13,micro.getAcumuladorB());
	}
}
