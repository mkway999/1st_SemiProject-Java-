import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

class OrderSel
{
	int oSel;						// �ֹ� ���� ����
	public final int O_CUSTOM = 1;	// Ŀ���� �ֹ�
	public final int O_RANDOM = 2;	// ���� �ֹ�
	public final int O_BACK = 3;

	public void orderSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);	

		try
		{
			do
			{	System.out.println("������������������������������������������������������������������������");
				System.out.println("��         �ֹ��ϱ�                 ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println("�� �� Ŀ���� �ֹ�                   ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� ���� �ֹ�                     ��");
				System.out.println("��                                  ��"); 
				System.out.println("�� �� �ڷ� ����                     ��");
				System.out.println("��                                  ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.print("  �� "); 
				oSel = sc.nextInt();
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println();
			}
			while(oSel < 1 || oSel > 3);	
		}
		
		catch (InputMismatchException e)
		{
			System.out.println("�ùٸ� ���ڸ� �Է��� �ּ���.");
			orderSelect();
		}

		if (oSel == 1)
		{
			//Ŀ���� �ֹ�
			RCustom cob1 = new RCustom();
			cob1.cOrder();
			cob1.fruitIng();
		}

		else if (oSel == 2)
		{
			//���� �ֹ�
			RandomFruit1212 rd12 = new RandomFruit1212();
			rd12.print();
			rd12.runRd();
			rd12.getSelectedFruits();
		}

		else if (oSel == 3)
		{
			//�ڷΰ���
			VendingMachine vm1 = new VendingMachine();
			vm1.turnOn();
		}
	}
}