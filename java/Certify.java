/*
[������ �ڵ� ���� Ŭ����]

���α׷��� ����Ǹ� ����ڿ��� ������ �ڵ带 �Է¹޾�
�ش� �Է°��� ������ �ڵ�� ��ġ�ϴ����� ���θ� �Ǵ��ϰ�

-��ġ�Ѵٸ�? ������ �ý������� �̵� ����
-5ȸ �̻� Ʋ���ٸ�? ���α׷� ���� ����(���� �Ұ�)

*�޼ҵ� ����*

#1 ������ �ڵ� setter

#2 ������ �ڵ� getter

#3 ����ڿ��� �Է¹��� �ڵ尪 �Ǻ� ����� ���α׷� ���� or ������ �ý��� �̵�

#4 ����ڿ��� �Է¹��� �ڵ�� ������ �ڵ� ���Ͽ� ��� ��ȯ
*/

import java.util.Scanner;
class Certify
{
	private String admin = "minzzi";	//������ �ڵ� private~ �ƹ��� ���� ���
	
	//#1
	void setAdmin(String admin)
	{
		this.admin = admin;
	}

	//#2
	String getAdmin()
	{
		return admin;
	}

	//#3
	void adCertify()	// �Է¹��� �ڵ� �Ǻ� ����� �޾Ƽ�
	{					// ������ ���� �̵� or ���α׷� ���� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("\n������ �ڵ带 �Է��ϼ���.");
		System.out.println("�Է� Ƚ�� [5ȸ] �ʰ��� ���α׷��� ����˴ϴ�.");
		
		if (!codeCheck())		// �Ǻ� ����� false���
		{
			System.out.println("\n������ �ý��� ���� �Ұ�.\n���α׷��� ����˴ϴ�.");
			Exit.exit();		// ���α׷� ����
		}	
		else					// �Ǻ� ����� true���
		{
			System.out.println("\n������ �ý����� �����մϴ�.");
			return;				// �޼ҵ� ����(main���� ������ ��� ���� ����)
		}
	}

	//#4
	boolean codeCheck()	// �Է¹��� �ڵ� �Ǻ� �� true or false ��ȯ
	{
		Scanner sc = new Scanner(System.in);
		String code = "";			// �Է¹��� �ڵ�
		int num=1;					// �Է�Ƚ�� 5ȸ �ʰ��� ��������
		boolean result = false;		// �ڵ� �Ǻ� ���
		do
		{
			System.out.print("�������ڵ� : ");
			code = sc.next();
			if (code.equals(getAdmin()))
				result = true;
			else
			{
				if (num==5)	// �Է�Ƚ���� 5ȸ �ʰ��Ǹ�
				{
					System.out.println("\n�����ڵ� �Է� Ƚ���� �ʰ��Ͽ����ϴ�.");
					break;	// �ݺ��� ���� �� false ��ȯ
				}
				else		// �ڵ�� Ʋ������ 5ȸ �ʰ��� �ƴ϶��
				{
					System.out.printf("\n�����ڵ尡 ��ġ���� �ʽ��ϴ�. �Է� Ƚ�� %d�� ���ҽ��ϴ�.\n",5-num);
					num++;	// Ƚ���� �߰��ϰ� �ٽ� �Է¹ޱ�
				}
			}
		}
		while (!result);	// result�� false�� ��(Ʋ���� ��) �ݺ�
		return result;		// �Է� �ڵ尡 ��ġ�ϸ� result true�� �ٲ�
	}						// true�� �ٲ�� �ݺ��� Ż��~~~
}