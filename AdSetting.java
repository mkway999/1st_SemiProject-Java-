/*
[���� �� ������ ����]

���ο��� ���� �����ϸ� �ش� �ý��� ����

 1) ���� ����
  1-1) ���� �ű� ���
  1-2) ���� ���� ����
  1-3) ���� ���� ����
  1-4) �ڷΰ���

 2) ������ ����
  2-1) ���� ��� ����
  2-2) ��ġ ��� ����
  2-3) �ڷΰ���

 3) �ڷΰ���

*�޼ҵ� ����*

#1 1) ~ 3) ����� �����ϴ� �޼ҵ�

#2 ������ ������� �̵������ִ� �޼ҵ�
*/
import java.util.Scanner;
import java.io.IOException;

class AdSetting extends AdMain
{
	//#1
	void setSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int num = 0;			// ���ð� ������ ����
		boolean temp = false;	// �ݺ����� �Ҹ� ����

		System.out.println("\n\t[���� �� ������ ����]");
		System.out.println("[1] ���� ����");
		System.out.println("[2] ������ ����");
		System.out.println("[3] �ڷΰ���");

		do	// ����ڰ� �����(1~3 ������) �Է��Ҷ����� �ݺ�
		{
			System.out.print("\n������ ����� �����ϼ���. : ");
			try	// �� �� ��� �̻��ϰ� �Է������� ����
			{
				num = sc.nextInt();
				temp = false;	// ����� ������ �� ���� ����
			}
			catch (Exception e)
			{
				System.out.println("\n���Է¿�����");
				System.out.println("1�̻� 3������ ������ �Է��ϼ���.");
				sc.nextLine();
				temp = true;	// �������� temp true�� �ٲ��
			}
		}
		while (temp);			// ����� �� ������ �ݺ�
		setGo(num);
	}// setSelect()

	//#2
	void setGo(int num) throws IOException
	{
		switch (num)
		{
			case 1 : new AdFruit().frSelect();break;
			case 2 : new AdSub().subSelect();break;
			case 3 : super.turnOn(); break;	// �ڷΰ��� - ��ӹ��� �θ�(����) �������� ���ư���

			// �������� �Է��ߴµ� 1�̻� 3���ϰ� �ƴ϶��
			default : System.out.println("\n�߸��� �����Դϴ�.");
					System.out.println("1�̻� 3������ ������ �Է��ϼ���.");
					setSelect();
		}
	}// setGo()
}