import java.util.HashMap;
import java.util.Scanner;

public class InputStudent {

	/* �n�D�ϥΪ̤@�s���J�ǥͪ��m�W�A�H�ΥL�̪����Z�A�бN�o�Ǹ�ƥ�HashMap�x�s�A�A���ѿﶵ���ϥΪ̥i�H�N�Ѿǥͩm�W�Ӭd�ߥL�̪����Z�C */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> student = new HashMap();
		String name = new String();
		String close = new String();
		int grade = 0, count = 0;
		close = "end";

		while (!name.equals(close)) {
			try {
				System.out.println("�п�J��" + (count + 1) + "��ǥͩm�W(��Jend����) : ");
				name = scanner.next();
				if (name.equals(close)) {
					break;
				} else {
					// ��J���Z
					while (true) {
						try {
							System.out.println("�п�J�ǥͦ��Z : ");
							grade = scanner.nextInt();
							if (grade < 0 || grade > 100)
								System.out.println("���Z�W�X�d�� !");
							else {
								student.put(name, grade);// �N��Ʀs�JHashMap
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

		// �d�߾ǥͦ��Z
		int option = 0;
		String key = new String();
		while (option != 2) {
			System.out.print("�ﶵ 1)�d�� 2)���} : ");
			option = scanner.nextInt();
			if (option == 1) {
				System.out.print("�п�J�ǥͩm�W : ");
				key = scanner.next();
				System.out.println("�m�W : " + key + "\t���Z : " + student.get(key));
			}
			if (option == 2)
				break;
		}
	}
}
