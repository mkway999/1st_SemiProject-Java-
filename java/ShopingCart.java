import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

class ShopingCart extends RCustom // ��ٱ��� ���� Ŭ����
{
	static HashMap<Integer, ArrayList<String>> huruList = new HashMap<>();	// �ϼ��� ���ķ� �迭�� ������ �ڷᱸ��
	static List<Integer> priceList = new ArrayList<Integer>();
	public static List<String> sugarCoatinList = new ArrayList<String>();
	Serial sr = new Serial();

	private int huruPrice;		  // sum �� �������� ���� ���ķ� �ϳ��� ���� ����
	private int totalPrice;				  // ���ķ� ��ü������ ���� ����
	private static int keyCounter = 1;
	int sSel;
	Coating co1 = new Coating();
	int temp = 0;

	public void setHuruPrice(int huruPrice) // ���ķ� ���� setter
	{
        this.huruPrice = huruPrice;
    }

	public void setKeyCounter(int keyCounter) // keyCounter ���� setter
	{
        this.keyCounter = keyCounter;
    }

	// �߰�
	//ShopingCart Ŭ�������� huru ������ �޾ƿͼ� ���.
	public void setHuruList(List<String> huruList)
	{
        this.huru = new ArrayList<>(huruList);
	}

	public void sMenu() throws IOException
	{	
		Scanner sc = new Scanner(System.in);	
		
		try
		{
			do
			{	System.out.println("������������������������������������������������������������������������");
				System.out.println("��         ��ٱ���                 ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println("�� �� ��ٱ��� ���                 ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� �����ϱ�                      ��");
				System.out.println("��                                  ��"); 
				System.out.println("�� �� ��ٱ��� ����               ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� �ڷΰ���                      ��");
				System.out.println("��                                  ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.print("  �� "); 
				sSel = sc.nextInt();
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println();
			}
			while(sSel < 1 || sSel > 4);	
		}
		catch (InputMismatchException e)
		{
			System.out.println("�ùٸ� ���ڸ� �Է��� �ּ���.");
			sMenu();
		}

		if (sSel == 1)
		{
			//��ٱ��� ���
			huruPrint();
			
		}

		else if (sSel == 2)
		{	
			if (huruList.isEmpty())
			{
				System.out.println("��ٱ��ϰ� ������ϴ�.\n");
				sMenu();
			}

			else
			{
				Pay ppap = new Pay();
				ppap.paymenu();
			}
			
			
		}

		else if (sSel == 3)
		{	
			RandomFruit1212 rd12 = new RandomFruit1212();

			//�ڡڡڡڡڡ� ��ٱ��� ���� �ڡڡڡڡڡ�
			System.out.println("\n���� ��ٱ��ϸ� ���ðڽ��ϱ�? (Y/N)");
			System.out.print("�� ");
			
			String answer = sc.next();

			if (answer.equals("Y")||answer.equals("y"))
			{	
				sr.subGet();
				//someMethod(); // ���� ���� �޼ҵ�
				//kcStock1();   // ��ġ ���� �޼ҵ�

				setKeyCounter(1);

				sr.fruitGet();
				huruList.clear();		// ���ķ� �̸� ��
				priceList.clear();		// ���� ����Ʈ
				sugarCoatinList.clear();
		

				System.out.println("\n������ �Ϸ�Ǿ����ϴ�.");
				sMenu();
			}
			
			else
			{
				System.out.println("\n������ ����մϴ�.");

				/*
				for (int m = 1; m <= fru.fruits.size() ; m++)
				{		
					fru.fruits.get(m).setSTemp(0);
					fru.fruits.get(m).setCTemp(0);
				}	
				*/

				sMenu();
			}
			
		}

		else if (sSel == 4)
		{
			//�ڷΰ���
			VendingMachine vm2 = new VendingMachine();
			vm2.turnOn();
		}
	}
		
	public void huruInput() throws IOException
	{
		huruList.put(keyCounter++, new ArrayList<>(huru));
		huru.clear();		// �ϳ��� ���ķ縦 �����ϸ� �迭 �ʱ�ȭ
		priceList.add(huruPrice);
	}

	public void huruPrint() throws IOException
	{	
		Scanner sc = new Scanner(System.in);

		if (huruList.isEmpty())
		{
			System.out.println("��ٱ��ϰ� ������ϴ�.\n");
			sMenu();
		}
		
		else
		{	
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
			System.out.println("          ��ٱ��� ���            ");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 

			for (int i = 1; i <= huruList.size(); i++) 
			{
				System.out.printf ("  ���� %d�� ���ķ� ����\n", i);
				System.out.println();
				System.out.printf ("  ���ķ� ����: %s\n", huruList.get(i));
				System.out.printf ("  �� �� �� ��: %s\n", co1.sugarCoatinList.get(i-1));
				System.out.printf ("  ����       : %d�� \n", priceList.get(i-1));
				System.out.println("������������������������������������������������������������������������������������������������������������"); 
			
			}
        
		calculateTotalPrice();

			sMenu();
		}
	}

	public void calculateTotalPrice() 
	{
        totalPrice = 0;

        for (Integer price : priceList) 
		{
            totalPrice += price;
        }
        
		System.out.println("  �� ����: " + totalPrice + "��");
		System.out.println("������������������������������������������������������������������������������������������������������������");
	}

	public void someMethod() 
	{
        // Coating Ŭ������ sugarStockList�� ����
        List<Integer> sugarStock = Coating.sugarStockList;
        
           // sugarStock ���� ��ȸ�ϸ� �� ���� �ش��ϴ� �縸ŭ ���� ��� ������Ŵ
		for (Integer sugarAmount : sugarStock) 
		{
            // ���⿡�� ������ ��� ���� ������ �߰�
            // ���� ���, ���� Ŭ�������� �ش� �޼ҵ带 ȣ���Ͽ� ��� ����
            // sugarAmount�� ���� ���� ��� ����
            int sugarStockIncrease = sugarAmount; // 10���� ������ ���� 10g ������ ����
            Sub.sub.get(1).setStock(Sub.sub.get(1).getStock() + sugarStockIncrease);
        }
		sugarStock.clear();
    
    }

	public void kcStock1()
	{
		// Coating Ŭ������ sugarStockList�� ����
        List<Integer> kcStock = Coating.kcList;

		for (Integer kcAmount : kcStock)
		{
			// ��ġ�� ��� ���� ������ �߰�
			// kcAmount�� ���� ��ġ ��� ����
			Sub.sub.get(2).setStock(Sub.sub.get(2).getStock() + kcAmount);
		}

		kcStock.clear();
	
	}

}