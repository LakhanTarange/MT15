package Day05Jun23;

import java.util.Random;

public class UniqueFileName {
	public static void main(String[] args) {

		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random rnd = new Random();
		System.out.println(getUniqueFileName(charSet, rnd, 10, "png"));
		System.out.println(getUniqueFileName(charSet, rnd, 20, "png"));
		System.out.println(getUniqueFileName(charSet, rnd, 5, "bmp"));
		System.out.println(getUniqueFileName(charSet, rnd, 40, "svg"));
		System.out.println(getUniqueFileName(charSet, rnd, 15, "jpg"));
		System.out.println(getUniqueFileName(charSet, rnd, 7, "jpeg"));

	}

	private static String getUniqueFileName(String charSet, Random rnd, int maxChars, String ext) {
		String fn = "";
		for (int i = 1; i <= maxChars; i++) {
			int ind = rnd.nextInt(charSet.length());
			fn = fn + charSet.charAt(ind);
		}
		return fn + "." + ext;
	}
}
