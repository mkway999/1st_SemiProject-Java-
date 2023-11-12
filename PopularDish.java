import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PopularDish 
{
    private HashMap<ArrayList<String>, Integer> combinationCount = new HashMap<>();	// Ű: [��������], ��: [�Ǹ� ī��Ʈ]
    private List<Map.Entry<ArrayList<String>, Integer>> sortedCombinationCount;		// ���� �ڷᱸ���� �Ǹ� ī��Ʈ�� �������� �������� ����
    private ArrayList<String> fruitNames = new ArrayList<>();						// fruit�� �̸��� ���� �ڷᱸ��

	ArrayList<ArrayList<String>> allHuruLists = new ArrayList<>();

	int pSel;
	public final int P_DISH = 1;
	public final int P_ORDER = 2;
	public final int P_BACK = 3;
	
	public void pMenuSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		VendingMachine vm5 = new VendingMachine();

		try
		{
			do
			{	System.out.println("������������������������������������������������������������������������");
				System.out.println("��         ���α� TOP3��            ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println("�� �� ���α� TOP3�� ��ȸ            ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� �ֹ� �ϱ�                     ��");
				System.out.println("��                                  ��"); 
				System.out.println("�� �� �ڷ� ����                     ��");
				System.out.println("��                                  ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.print("  �� "); 
				pSel = sc.nextInt();
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println();
			}
			while(pSel < 1 || pSel > 3);	
		}
		
		catch (InputMismatchException e)
		{
			System.out.println("�ùٸ� ���ڸ� �Է��� �ּ���.");
			pMenuSelect();
		}

		if (pSel == P_DISH)
		{
			// �α� Top3 ��ȸ
			print();
		}

		else if (pSel == P_ORDER)
		{
			// �ֹ� �ϱ�
			OrderSel os9 = new OrderSel();
			os9.orderSelect();
		}

		else if (pSel == P_BACK)
		{
			//�ڷΰ���
			
			vm5.turnOn();
		}
	}

    public void input() throws IOException
	{
        Pay ob1 = new Pay();
		
		for (ArrayList<ArrayList<String>> huruLists : ob1.pdHuruList.values()) 
		{
			allHuruLists.addAll(huruLists);
		}

        for (FruitsProducts fruit : Fruits.fruits.values()) 
		{	
			// ���� �̸� ���
            fruitNames.add(fruit.getName());
        }

        for (ArrayList<String> combination : allHuruLists) 
		{	
			// ��ȿ��(fruits ������ �ִ� ���ϵ鸸) ���ո� �Ÿ���

            boolean validCombination = true;

            for (String fruit : combination) {
                if (!fruitNames.contains(fruit)) {
                    validCombination = false;
                    break;
                }
            }

            if (!validCombination) {
                continue;
            }
			
			// �����ϱ�
            Collections.sort(combination);

			// ī��Ʈ����
			 combinationCount.put(combination, combinationCount.getOrDefault(combination, 0) + 1);
        }
		
		// ī��Ʈ�� �������� �������� ����
        sortedCombinationCount = new ArrayList<>(combinationCount.entrySet());
        sortedCombinationCount.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
		
		allHuruLists.clear();
		combinationCount.clear();
    }

	public void print() throws IOException
	{	
		Scanner sc = new Scanner(System.in);

		int temp=0;

		input();

		int count = 0;

		System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
        for (Map.Entry<ArrayList<String>, Integer> entry : sortedCombinationCount)
		{
            count++;
            System.out.printf("  %d�� ����: %s �Ǹ� ���� : %d\n", count, entry.getKey(), entry.getValue());
            if (count >= 3) 
			{
                break;
            }
        }
		System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		do
		{
			System.out.println();
			System.out.println("  �ֹ��Ͻ÷��� �ش��ϴ� ������ ���ڸ� �������� (4���� �ڷΰ���)");
			System.out.print("  �� ");
			temp = sc.nextInt();
			System.out.println("  ����������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		}
		while (temp > 4 || temp < 1);

		
		if (temp == 1)
		{
			order1();
		}

		else if (temp == 2)
		{
			order2();
		}

		else if (temp == 3)
		{
			order3();
		}

		else
		{
			pMenuSelect();
		}

		
	}

	public void order1() throws IOException
	{	
		ArrayList<String> combination = sortedCombinationCount.get(0).getKey();
		int totalPrice = 0;

		for (String fruit : combination)
		{
			FruitsProducts fruitProduct = null;

			// ���� �̸����� ���� ��ü ã��
			for (Map.Entry<Integer, FruitsProducts> entry : Fruits.fruits.entrySet()) 
			{
				FruitsProducts product = entry.getValue();

				if (product.getName().equals(fruit)) 
				{
					fruitProduct = product;
					break;
				}
			}

			// ���� ��ü�� ���� ��� ���� ����
			if (fruitProduct != null) 
			{
				totalPrice += fruitProduct.getPrice();
			}
		}

		RCustom rc3 = new RCustom();
		rc3.huru.addAll(sortedCombinationCount.get(0).getKey());

		ShopingCart sc3 = new ShopingCart();
		sc3.setKeyCounter(sc3.huruList.size()+1);
		
		sc3.setHuruPrice(totalPrice);
		sc3.huruInput();

		decreaseStock(combination);
		
		Coating co3 = new Coating();
		co3.sugarPrint();
	}

	public void order2() throws IOException
	{	
		ArrayList<String> combination = sortedCombinationCount.get(1).getKey();
		int totalPrice = 0;

		for (String fruit : combination)
		{
			FruitsProducts fruitProduct = null;

			// ���� �̸����� ���� ��ü ã��
			for (Map.Entry<Integer, FruitsProducts> entry : Fruits.fruits.entrySet()) 
			{
				FruitsProducts product = entry.getValue();

				if (product.getName().equals(fruit)) 
				{
					fruitProduct = product;
					break;
				}
			}

			// ���� ��ü�� ���� ��� ���� ����
			if (fruitProduct != null) 
			{
				totalPrice += fruitProduct.getPrice();
			}
		}

		RCustom rc3 = new RCustom();
		rc3.huru.addAll(sortedCombinationCount.get(1).getKey());

		ShopingCart sc3 = new ShopingCart();
		sc3.setKeyCounter(sc3.huruList.size()+1);
		
		sc3.setHuruPrice(totalPrice);
		sc3.huruInput();

		decreaseStock(combination);
		
		Coating co3 = new Coating();
		co3.sugarPrint();
	}

	public void order3() throws IOException
	{	
		ArrayList<String> combination = sortedCombinationCount.get(2).getKey();
		int totalPrice = 0;

		for (String fruit : combination)
		{
			FruitsProducts fruitProduct = null;

			// ���� �̸����� ���� ��ü ã��
			for (Map.Entry<Integer, FruitsProducts> entry : Fruits.fruits.entrySet()) 
			{
				FruitsProducts product = entry.getValue();

				if (product.getName().equals(fruit)) 
				{
					fruitProduct = product;
					break;
				}
			}

			// ���� ��ü�� ���� ��� ���� ����
			if (fruitProduct != null) 
			{
				totalPrice += fruitProduct.getPrice();
			}
		}

		RCustom rc3 = new RCustom();
		rc3.huru.addAll(sortedCombinationCount.get(2).getKey());

		ShopingCart sc3 = new ShopingCart();
		sc3.setKeyCounter(sc3.huruList.size()+1);
		
		sc3.setHuruPrice(totalPrice);
		sc3.huruInput();

		decreaseStock(combination);
		
		Coating co3 = new Coating();
		co3.sugarPrint();
	}



	public void decreaseStock(ArrayList<String> combination) throws IOException {

		VendingMachine vm6 = new VendingMachine();

    for (String fruit : combination) {
        FruitsProducts fruitProduct = null;

        // ���� �̸����� ���� ��ü ã��
        for (Map.Entry<Integer, FruitsProducts> entry : Fruits.fruits.entrySet()) {
            FruitsProducts product = entry.getValue();
            if (product.getName().equals(fruit)) {
                fruitProduct = product;
                break;
            }
        }

        if (fruitProduct != null) {
            int currentStock = fruitProduct.getStock();
            if (currentStock > 0) {
                fruitProduct.setStock(currentStock - 1);
            } else {
                System.out.println(fruit + "�� ��� �����Ͽ� �ֹ��� �� �����ϴ�.");
				vm6.turnOn();
            }
        } else {
            System.out.println("�ش��ϴ� ���� ������ ã�� �� �����ϴ�: " + fruit);
			vm6.turnOn();
        }
    }
}

}