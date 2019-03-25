package design.facade;

public class Facade {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
}

class Cpu {
	public void startup() {
		System.out.println("cpu startup");
	}

	public void shutdown() {
		System.out.println("cpu shutdown");
	}
}

class Memory {
	public void startup() {
		System.out.println("Memory startup");
	}

	public void shutdown() {
		System.out.println("Memory shutdown");
	}
}

class Disk {
	public void startup() {
		System.out.println("Disk startup");
	}

	public void shutdown() {
		System.out.println("Disk shutdown");
	}
}

class Computer {
	private Cpu cpu;
	private Memory memory;
	private Disk dsDisk;

	public Computer() {
		// TODO Auto-generated constructor stub
		cpu = new Cpu();
		memory = new Memory();
		dsDisk = new Disk();
	}

	public void startup() {
		cpu.startup();
		memory.startup();
		dsDisk.startup();
	}

	public void shutdown() {
		cpu.shutdown();
		memory.shutdown();
		dsDisk.shutdown();
	}

}
