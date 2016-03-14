import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberString {

	/*
	 * 撰寫一個程式讓使用者輸入一行英文句子，請以英文的標點符號、空白字元等為分界取出每個字符(token)，其中大寫英文字母要全部轉為小寫。
	 * 如果token為數字字串，便將它累加起來。
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = new String();
		int sum = 0;

		try {
			System.out.println("請輸入字串 : ");
			str = scanner.nextLine();

			StringTokenizer token = new StringTokenizer(str, " .,:;!?~-*/\t");
			System.out.println("字串內容 : ");
			while (token.hasMoreTokens()) {
				str = token.nextToken().toLowerCase();
				System.out.println(str);

				// 判斷字串中是否只有數字
				if (str.matches("[0-9|\\.]*")) {
					sum += Integer.parseInt(str);
				}
			}
			System.out.println("數字字串總和 : " + sum);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
