import java.util.HashMap;
import java.util.Scanner;

public class InputStudent {

	/* 要求使用者一連串輸入學生的姓名，以及他們的成績，請將這些資料用HashMap儲存，再提供選項讓使用者可以就由學生姓名來查詢他們的成績。 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> student = new HashMap();
		String name = new String();
		String close = new String();
		int grade = 0, count = 0;
		close = "end";

		while (!name.equals(close)) {
			try {
				System.out.println("請輸入第" + (count + 1) + "位學生姓名(輸入end結束) : ");
				name = scanner.next();
				if (name.equals(close)) {
					break;
				} else {
					// 輸入成績
					while (true) {
						try {
							System.out.println("請輸入學生成績 : ");
							grade = scanner.nextInt();
							if (grade < 0 || grade > 100)
								System.out.println("成績超出範圍 !");
							else {
								student.put(name, grade);// 將資料存入HashMap
								count++;
								break;
							}
						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		// 查詢學生成績
		int option = 0;
		String key = new String();
		while (option != 2) {
			System.out.print("選項 1)查詢 2)離開 : ");
			option = scanner.nextInt();
			if (option == 1) {
				System.out.print("請輸入學生姓名 : ");
				key = scanner.next();
				System.out.println("姓名 : " + key + "\t成績 : " + student.get(key));
			}
			if (option == 2)
				break;
		}
	}
}
