package ar.edu.unahur.obj2.command;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.Operable;
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
		List<Operable> builder = new ProgramBuilder().lodv(20).swap().lodv(17).add().build();
		Microprocesador micro = new Microprocesador();
		
		micro.run(builder);
		
		assertEquals(4,micro.getProgramCounter());
		assertEquals(37,micro.getAcumuladorA());
		assertEquals(0,micro.getAcumuladorB());
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
