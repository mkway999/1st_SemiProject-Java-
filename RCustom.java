// ���� Ŀ���� ����

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;



public class RCustom
{
	int n;													// ����ڰ� �����ϴ� ���ϰ��� ���� ����
	int se;													// ���� ����
	int size = 0;											// ������ ���� ������ ����
	int sum = 0;											// ���ķ� ��ü���� ����
	int[] temp = new int[10];
	
 
	static public List<String> huru = new ArrayList<String>();		// ���ķ縦 �����ϴ� ����Ʈ ����


	VendingMachine menu = new VendingMachine();				// ���� �޴� Ŭ���� �ν��Ͻ� ����

	static Fruits fru = new Fruits();								// �⺻ ���� Ŭ���� �ν��Ͻ� ����

	Coating sugar = new Coating();							//  �������� Ŭ���� �ν��Ͻ� ����
	//SubsidiaryMaterial sm = new SubsidiaryMaterial();	    //  ����, ��ġ Ŭ���� �ν��Ͻ� ����
	

	// ���� �޴��� ����ϴ� �޼ҵ�	
	public void fruitPrint() throws IOException
	{
		
		// ��ġ ������ �� ������ �޼ҵ�

		if (Sub.sub.get(1).getStock() < 30 && Sub.sub.get(2).getStock() < 1)
		{
			System.out.println("���� ������ ��ġ�� �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");

			resetHuru();
			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else if (Sub.sub.get(2).getStock() < 1)
		{
			System.out.println("��ġ�� �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");

			resetHuru();
			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else if (Sub.sub.get(1).getStock() < 30)
		{
			System.out.println("������ �����մϴ�.");
			System.out.println("�� �̻� �ֹ� �� �� �����ϴ�.");
			System.out.println("��ٱ��Ϸ� �̵��մϴ�.");

			RCustom rus = new RCustom();
			rus.resetHuru();

			ShopingCart cart = new ShopingCart();

			cart.sMenu();
		}
		else 	
		{
			System.out.println(" \n   ���ϴ� ������ �������ּ���! (size 6 �ʰ� ��)");
			System.out.println("   �� [] ���� ���ڰ� ������ �Դϴ�.");
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");

			for (int i = 0; i<fru.fruits.size();)
			{
				for (int j=1; fru.fruits.size()-i > 0; j++)
				{
					if (fru.fruits.containsKey(j))
					{
						temp[i]=j;
						if (fru.fruits.get(j).getSize() * fru.fruits.get(j).getStock() <= 6)
						{
							System.out.printf ("%5d. %s [%d] (ǰ��)" ,(i+1), fru.fruits.get(j).getName(),fru.fruits.get(j).getSize());
						}

						else 
						{
							System.out.printf("%5d. %s [%d] (%d)" ,(i+1), fru.fruits.get(j).getName(),fru.fruits.get(j).getSize(), fru.fruits.get(j).getStock());
						}
						i++;
						if (i%4==0)
						{
							System.out.println();
						}
					}
					
				}
			}

			System.out.println();
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("   >> ");
		}
	}

		
	// ���� �ֹ��ϴ� �޼ҵ�
	public void cOrder() throws IOException
	{	
		n = 0;
		boolean flag = false;

		Scanner sc = new Scanner(System.in);
		fruitPrint();
		n = sc.nextInt();
		
		try
		{	
			if (n > fru.fruits.size() || n <- -1)
			{
				System.out.println("\n    �߸� �����̽��ϴ�!");
				System.out.println("    �ٽ� �����ּ���!");
				flag = true;
				cOrder();
			}
		}
		catch (Exception e)
		{	

			System.out.println("\n    ���������ֿ������ֿ����ٿ��쿡���֡濡������");
			System.out.println("    ���!!!!!!!! ���!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println("    �ɰ��� ���� �߻� ");
			
			System.out.println("\n    �ذ� ����� �ٽ� �Է��ϱ��Դϴ�~! ^0^");

			cOrder();

		}
		


		
		// �ڵ� ���� ���� ����
		for (int i = 1; i<fru.fruits.size();i++)
		{	
			if ((n - i ) == 0)
				break;
			else if (fru.fruits.get(n) == null)
			{
				n += 1;
				break;
			}
			else if (fru.fruits.get(n-i) == null)
			{
				n += 1;
				break;
			}
		}

		if (size == 5)
		{
			if (fru.fruits.get(n).getSize() == 2)
			{
				System.out.println(" ���� ������� 5�Դϴ�. [2] ����� ���� ������ ������ �Ұ����մϴ�.");
				size = 5;
				cOrder();	
			}
		}
		
		if (size == 0)
		{
			size = 0;
			sum = 0;
		}

		if (flag == true)
		{
			size -= fru.fruits.get(n).getSize();
			sum -= fru.fruits.get(n).getPrice();
			fru.fruits.get(n).setAddCount(fru.fruits.get(n).getAddCount()-1);
			fru.fruits.get(n).setCTemp(fru.fruits.get(n).getCTemp()-1);									// �ӽ� ���� ����
			fru.fruits.get(n).setStock(fru.fruits.get(n).getStock()+1);									// ���� ��� ����
			fru.fruits.get(n).setSTemp(fru.fruits.get(n).getSTemp()-1);									// �ӽ� ���� ����

		}
		
		size += fru.fruits.get(n).getSize();														// ���ķ� ������ ����
		sum += fru.fruits.get(n).getPrice();														// ���ķ� ���� ����

		fru.fruits.get(n).setAddCount(fru.fruits.get(n).getAddCount()+1);							// ���� �ǸŰ��� ����
		fru.fruits.get(n).setCTemp(fru.fruits.get(n).getCTemp()+1);									// �ӽ� ���� ����
		//fru.fruits.get(n).setTempC(fru.fruits.get(n).getTempC()+1);								// �ӽ� �ӽÿ� ���� ����

		
		// ���� ���� ǰ��
		if (fru.fruits.get(n).getSize() * fru.fruits.get(n).getStock() <= 6)
		{
			System.out.println("���� ������ ��� �����մϴ�.");
			System.out.println("�ٸ� ������ �������ּ���!");
			size -= fru.fruits.get(n).getSize();
			sum -= fru.fruits.get(n).getPrice();
			cOrder();	
		}
		
		fru.fruits.get(n).setStock(fru.fruits.get(n).getStock()-1);									// ���� ��� ����
		fru.fruits.get(n).setSTemp(fru.fruits.get(n).getSTemp()+1);									// �ӽ� ���� ����
		//fru.fruits.get(n).setTempS(fru.fruits.get(n).getTempS()+1);								// �ӽ� �ӽÿ� ���� ����

		// ����� 6�϶� 
		if (size == 6)
		{	
			pushFruits(n);
			sugarCoating();
		}

	} // end cOrder() 

	public void fruitIng()	throws IOException
	{	
		Scanner sc = new Scanner(System.in);	
				
		
			do
			{		
				pushFruits(n);

				System.out.println("������ : " + size);
				System.out.println("�̸� : "+ huru);
				System.out.println("���� : "+ sum);

				int num = 0;

				
				System.out.println("\n 1. ���ϱ��� ����ϱ� 2. ���� �÷� ������ ���� (���� ���� ����) 3. �޴��� ������(�ʱ�ȭ)\n");
				System.out.print(" >> ");	
				num = sc.nextInt();
				System.in.skip(2);

				if (num == 1)
				{
					cOrder();

				} 
				else if (num == 2)
				{
					ShopingCart ob = new ShopingCart();		// ���Ⱑ �Է�
					ob.setHuruPrice(sum);
					ob.huruInput();	

					//temp();
					sugar.sugarPrint();

					break; 
					
				}
				else if (num == 3)
				{	
					resetHuru();
					menu.turnOn();					
					
				}
				else 

				{	System.in.skip(2);
					n = 0;
					System.out.println("�߸� �����̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���!");
					cOrder();
					break;	

				}

			}
			while (size < 6);

	}
	
	// ���õ� ������ ��� �޼ҵ�
	public void pushFruits(int name)
	{	
		huru.add(fru.fruits.get(name).getName());	
	}

	//�ӽ� �ʱ�ȭ ����
	public void temp()
	{	
		for (int m = 1;  m <= fru.fruits.size() ; m++)
		{
			fru.fruits.get(m).setTempC(fru.fruits.get(m).getTempC() + fru.fruits.get(m).getCTemp());
			fru.fruits.get(m).setTempS(fru.fruits.get(m).getTempS() + fru.fruits.get(m).getSTemp());

			fru.fruits.get(m).setSTemp(0);
			fru.fruits.get(m).setCTemp(0);
		
			//System.out.println("�׽�Ʈ �� : " + fru.fruits.get(m).getTempS());
		}

	} 

	// ������ ������� �� �ѹ��ϴ� �޼ҵ�
	public void resetHuru() throws IOException
	{
		for (int m = 1; m <= fru.fruits.size() ; m++)
		{				
			
			
			fru.fruits.get(m).setStock(fru.fruits.get(m).getStock() + (fru.fruits.get(m).getSTemp()));
			fru.fruits.get(m).setAddCount(fru.fruits.get(m).getAddCount() - (fru.fruits.get(m).getCTemp()));
			
			//System.out.println(fru.fruits.get(m).getName() + " �� ���� ���: " + fru.fruits.get(m).getStock());
			//System.out.println(fru.fruits.get(m).getName() + " �� �߰� �� ���: " + fru.fruits.get(m).getSTemp());
		
			fru.fruits.get(m).setSTemp(0);
			fru.fruits.get(m).setCTemp(0);

		}	
		huru.clear();
		
	}
	
	// ��ٱ��� ���� ������ ��� �ʱ�ȭ
	public void allReset()
	{
		for (int m = 1; m <= fru.fruits.size() ; m++)
		{	
			//System.out.println(fru.fruits.get(m).getName() + " �� ���� ���: " + fru.fruits.get(m).getStock());				// �׽�Ʈ �� (������ ����)

			fru.fruits.get(m).setSTemp(fru.fruits.get(m).getSTemp() + fru.fruits.get(m).getTempS());
			fru.fruits.get(m).setStock(fru.fruits.get(m).getStock() + (fru.fruits.get(m).getSTemp()));
			
			fru.fruits.get(m).setCTemp(fru.fruits.get(m).getCTemp() + fru.fruits.get(m).getTempC());
			fru.fruits.get(m).setAddCount(fru.fruits.get(m).getAddCount() - (fru.fruits.get(m).getCTemp()));
			
			
			//System.out.println(fru.fruits.get(m).getName() + " �� �߰� �� ���: " + fru.fruits.get(m).getSTemp());			// �׽�Ʈ �� (������ ����)
		
			// �ӽ� ���� �ʱ�ȭ (���� ����� ���� ���� �ʰ� �ϱ� ���ؼ�)
			fru.fruits.get(m).setSTemp(0);
			fru.fruits.get(m).setCTemp(0);
			fru.fruits.get(m).setTempC(0);
			fru.fruits.get(m).setTempS(0);

		}	
		huru.clear();
		
	
	}
	
	// ���� ���� �޼ҵ�
	public void sugarCoating() throws IOException
	{	
		//size = 6;
		System.out.println("\n ����� ��� ä��̽��ϴ�.");
		System.out.println(" ���� �÷��� �����ϼ���!");
		
		ShopingCart ob = new ShopingCart();		// ���Ⱑ �Է�
		ob.setHuruPrice(sum);
		ob.huruInput();

		sugar.sugarPrint();
		
	}

	/*
	public static void main(String[] args)  throws IOException
	{
		Serial.fruitGet();
		Serial.subGet();
		RCustom ob = new RCustom();

		Coating sugar = new Coating();					  //  �������� Ŭ���� �ν��Ͻ� ����

		SubsidiaryMaterial sm = new SubsidiaryMaterial(); //  ����, ��ġ Ŭ���� �ν��Ͻ� ����
		sm.subMaterialInput(); // sm�� �޼ҵ�

		ob.cOrder();
		ob.fruitIng();
		
	}
	*/

}
