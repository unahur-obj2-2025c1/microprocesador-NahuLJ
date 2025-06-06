package ar.edu.unahur.obj2.command;

import ar.edu.unahur.obj2.command.comandos.*;

import java.util.ArrayList;
import java.util.List;

public class ProgramBuilder {
    private List<Operable> instrucciones = new ArrayList<>();

    public ProgramBuilder nop() {
        instrucciones.add(new NOP());
        return this;
    }

    public ProgramBuilder add() {
        instrucciones.add(new ADD());
        return this;
    }

    public ProgramBuilder swap() {
        instrucciones.add(new SWAP());
        return this;
    }

    public ProgramBuilder lod(Integer addr) {
        instrucciones.add(new LOD(addr));
        return this;
    }

    public ProgramBuilder str(Integer addr) {
        instrucciones.add(new STR(addr));
        return this;
    }

    public ProgramBuilder lodv(Integer valor) {
        instrucciones.add(new LODV(valor));
        return this;
    }
    
    public ProgramBuilder ifnz(List<Operable> programa) {
    	instrucciones.add(new IFNZ(programa));
    	return this;
    }
    
    public ProgramBuilder whnz(List<Operable> programa) {
    	instrucciones.add(new WHNZ(programa));
    	return this;
    }

    public List<Operable> build() {
        return new ArrayList<>(instrucciones); // devuelve una copia
    }
}

