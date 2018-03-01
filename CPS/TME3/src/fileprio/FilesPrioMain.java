package fileprio;

public class FilesPrioMain {

	public static void main(String[] args) {
		System.out.println("CPS_TME3");
		FilesPrioImpl impl = new FilesPrioImpl();
		FilesPrioImplBug bugged_impl = new FilesPrioImplBug();
		FilesPrioContract<Integer> cimpl = new FilesPrioContract<>(impl);
		FilesPrioContract<Integer> cimplb = new FilesPrioContract<>(bugged_impl);
		cimpl.init();
		cimplb.init();
		
		
		System.out.println("Adding 2");
		cimpl.put(2);
		System.out.println("Adding 3");
		cimpl.put(3);
		System.out.println("size: "+ cimpl.getSize());
		System.out.println(cimpl.getActivePrios());
		cimpl.removePrio(1);
		System.out.println("size: "+ cimpl.getSize());
		System.out.println(cimpl.getActivePrios());
		
	}

}
