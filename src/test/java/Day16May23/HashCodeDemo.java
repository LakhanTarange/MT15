package Day16May23;

public class HashCodeDemo {
	public static void main(String[] args) {
		String str1 = new String("Pune");
		String str2 = new String("Pune");

		System.out.println("HEAP HC1: " + System.identityHashCode(str1)); // 1023487453
		System.out.println("SCP  HC1: " + str1.hashCode()); // 2499228

		System.out.println("HEAP HC2: " + System.identityHashCode(str2)); // 1651191114
		System.out.println("SCP  HC2: " + str2.hashCode()); // 2499228

		String str3 = "Pune";
		System.out.println("HEAP HC3: " + System.identityHashCode(str3)); // 1586600255
		System.out.println("SCP  HC3: " + str3.hashCode()); // 2499228
	}
}
