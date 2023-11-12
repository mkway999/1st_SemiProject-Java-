/*
[������ ����]

���� �� ������ �������� 2) �� �����ϸ� �ش� �ý��� ����

 2) ������ ����
  2-1) ���� ��� ����
  2-2) ��ġ ��� ����
  2-3) �ڷΰ���

*�޼ҵ� ����*

#1 2-1) ~ 2-3) ����� �����ϴ� �޼ҵ�

#2 ������ ��ǰ ��� ���� �޼ҵ�

*/
import java.util.Scanner;
import java.io.IOException;

class AdSub extends AdSetting
{
	//#1
	void subSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int number = 0;			// ���ð� ������ ����
		boolean temp = false;	// �ݺ����� �Ҹ� ����

		System.out.println("\n\t[������ ����]");
		System.out.println("[1] ���� ��� ����");
		System.out.println("[2] ��ġ ��� ����");
		System.out.println("[3] �ڷΰ���");

		do	// ����ڰ� �����(1~3 ������) �Է��Ҷ����� �ݺ�
		{
			System.out.print("\n������ ����� �����ϼ���. : ");
			try	// �� �� ��� �̻��ϰ� �Է������� ����
			{
				number = sc.nextInt();
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
		if (number==3)
			super.setSelect();
		else if (number==1||number==2)
			subEdit(number);
		else
		{
			System.out.println("\n���Է¿�����");
			System.out.println("1�̻� 3������ ������ �Է��ϼ���.");
			subSelect();
		}
			
	}// subSelect()

	//#2
	void subEdit(int number) throws IOException
	{
		Scanner sc = new Scanner(System.in);	
		int su=0;
		int oldStock=Sub.sub.get(number).getStock();
		boolean temp = true;

		System.out.printf("\n[%s]�� ��� �����մϴ�.",Sub.sub.get(number).getName());
		do
		{
			try
			{
				System.out.println("\n��� �߰� - ��� �Է� / ��� ���� - ���� �Է�");
				System.out.printf("���� ��� [%d] �� ������ ��� : ",oldStock);
				su = sc.nextInt();
				if (su<0)
				{
					if (oldStock+su<0)
					{
						System.out.println("���� [0] �̸��� �� �� �����ϴ�.");
						temp = true;
					}
					else
						temp = false;
				}
				else
				{
					if (su>Sub.sub.get(number).getMax())
					{
						System.out.printf("���� [%d] ���Ϸθ� �Է��� �� �ֽ��ϴ�.\n",Sub.sub.get(number).getMax());
						temp = true;
					}
					else if (oldStock+su>Sub.sub.get(number).getMax())
					{
						System.out.printf("���� [%d] ��(��) �ʰ� �� �� �����ϴ�.",Sub.sub.get(number).getMax());
						temp = true;
					}
					else
						temp = false;
				}
			}
			catch (Exception e)
			{
				System.out.println("\n���Է� ������");
				System.out.printf("[%d] ������ �������·� �Է��� �� �ֽ��ϴ�.",Sub.sub.get(number).getMax());
				sc.nextLine();
				temp = true;
			}
		}
		while (temp);

		System.out.printf("%s�� ��� [%d �� %d]�� �����Ͻðڽ��ϱ�?(Y/N) : ",Sub.sub.get(number).getName(),oldStock,oldStock+su);
		String answer = sc.next();
		if (answer.equals("Y")||answer.equals("y"))
		{
			Sub.sub.get(number).setStock(oldStock+su);
			System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
			subSelect();
		}
		else
		{
			System.out.println("\n������ ����մϴ�.");
			subSelect();
		}
	}// subEdit()
}