import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class InputEnglishSentence {
	/*
	 * 擴充第3.1節與第3.2節的程式，要求使用者一整行英文句子，請依照第3.1節的規範切割出字符，轉成小寫後並將它們存入HashMap中；
	 * HashMap之中同時儲存每個字符對應的出現次數，程式可提供選項讓使用者藉由輸入新的句子來新增字符，也可以輸入字符來查詢他們出現的次數。程式結束前
	 * ，請將目前HashMap中記錄的資料寫入檔案之中。下次程式執行前必須事先讀取出來。
	 */
	private static HashMap<String, Integer> word = new HashMap();

	private static void InputSentence() {
		Scanner scanner = new Scanner(System.in);
		String str = new String();

		try {
			System.out.println("請輸入英文句子 : ");
			str = scanner.nextLine();
			String[] split = str.split("[ .,:;!?/\t\\s]+");// 切割字串

			for (int i = 0; i < split.length; i++) {
				String s = split[i].toLowerCase();// 將切割過的字串轉成小寫
				if (s.matches("[a-z|\\.]*"))// 判斷字串中是否只有小寫英文
				{
					if (word.get(s) == null)// HashMap中不存在此key
						word.put(s, 1);// 出現次數=1
					else {
						int count = word.get(s);
						word.put(s, count + 1);// 出現次數+1
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// 讀檔
	public static void FileToText() {
		try (FileReader file = new FileReader("HashMap.txt")) {
			BufferedReader buffer = new BufferedReader(file);
			String read = buffer.readLine();
			while (read != null) {
				String[] split = read.split("[ .,:;!?/\t\\s]+");
				word.put(split[0], Integer.parseInt(split[1]));// split[0]=key
				read = buffer.readLine();
			}
			file.close();// 關檔
			System.out.println("讀檔完成 !");
		} catch (FileNotFoundException e) {
			System.out.println("找不到該檔案 !");
		} catch (final IOException e) {
			System.out.println("檔案存取錯誤 !");
		}
	}

	// 寫檔
	public static void TextToFile() {
		try {
			FileWriter file = new FileWriter("HashMap.txt");
			Set<String> key = word.keySet();
			for (String k : key) {
				file.write(k + " " + word.get(k) + "\n");
			}
			file.close();// 關檔
			System.out.println("寫檔完成 !");
		} catch (IOException e) {
			System.out.println("檔案存取錯誤 !");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		FileToText();// 讀檔
		InputSentence();// 輸入英文句子

		int option = 0;
		String key = new String();
		while (option != -1) {
			try {
				System.out.print("選項 1)輸入 2)查詢 3)印出 -1)離開 : ");
				option = scanner.nextInt();
				if (option == 1) {
					InputSentence();
				}
				if (option == 2) {
					System.out.print("請輸入查詢字符 : ");
					key = scanner.next().toLowerCase();
					if (word.get(key) == null)// 回傳null表示不存在此key
						System.out.println(key + " 出現 0 次");
					else
						System.out.println(key + " 出現 " + word.get(key) + " 次");
				}
				if (option == 3) {
					for (String k : word.keySet()) {// 取出每個key值
						System.out.println(k + "\t" + word.get(k));
					}
				}
				if (option == -1) {
					TextToFile();// 寫檔
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}
}
