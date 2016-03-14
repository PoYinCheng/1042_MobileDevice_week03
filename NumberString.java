import java.util.Scanner;
import java.util.StringTokenizer;

public class NumberString {

	/*
	 * ���g�@�ӵ{�����ϥΪ̿�J�@��^��y�l�A�ХH�^�媺���I�Ÿ��B�ťզr���������ɨ��X�C�Ӧr��(token)�A�䤤�j�g�^��r���n�����ର�p�g�C
	 * �p�Gtoken���Ʀr�r��A�K�N���֥[�_�ӡC
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = new String();
		int sum = 0;

		try {
			System.out.println("�п�J�r�� : ");
			str = scanner.nextLine();

			StringTokenizer token = new StringTokenizer(str, " .,:;!?~-*/\t");
			System.out.println("�r�ꤺ�e : ");
			while (token.hasMoreTokens()) {
				str = token.nextToken().toLowerCase();
				System.out.println(str);

				// �P�_�r�ꤤ�O�_�u���Ʀr
				if (str.matches("[0-9|\\.]*")) {
					sum += Integer.parseInt(str);
				}
			}
			System.out.println("�Ʀr�r���`�M : " + sum);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
