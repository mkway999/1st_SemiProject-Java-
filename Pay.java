import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DecimalFormat; // �� ���Ë� , ���������ִ� �Լ��� ���ԵǾ� ����
import java.lang.Math;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Collections;

public class Pay extends ShopingCart implements Serializable
{
	
	VendingMachine ve = new VendingMachine(); 
	ShopingCart  sh = new ShopingCart();
	
	static HashMap<LocalDate, ArrayList<ArrayList<String>>> pdHuruList = new HashMap<>(); // ������ �Ϸ�� ���ķ� - ��¥�� ����
	static HashMap<Integer, ArrayList<String>> totalPdHuruList = new HashMap<>();	// ������ �Ϸ�� ���ķ� - ��¥ ������� �� ����
	static private int totalHap;

	static Map<String, Integer> fruitCounts = new HashMap<>();				  // �Ǹŵ� ���� ����(��¥��)
	
	static Map<String, Integer> fruitCounts1 = new HashMap<>();				  // �Ǹŵ� ���� ����(��)

	//���� �߰��Ѱ�
	static HashMap<Integer, ArrayList<String>> pd_HuruList1 = new HashMap<>(); //���պ� ����
	static HashMap<Integer, ArrayList<String>> pd_HuruList2 = new HashMap<>(); //�α� ���պ� ����

	static List<String> availableFruits = new ArrayList<String>();  // ���� ���������� ��� ������ ���� �̸� ���

	static HashSet<String> type = new HashSet();
	static HashSet<String> type1 = new HashSet();

	static Map<String, Integer> fruittype = new HashMap<>();
	static Map<String, Integer> fruittype1 = new HashMap<>();
	
	AdSales ad = new AdSales();
	int choice;
	static private int totahap; // �̳��� �� ������ȸ�ҋ� ��
	int totlamoney;

	Coating co = new Coating();

	public int getTotalHap()
	{
		return totalHap;
	}

	public void setTotalHap(int totalHap)
	{
		this.totalHap =totalHap;
	}
	
	public int gettotahap()
	{
		return totahap;
	}
	
	public void settotahap(int totahap)
	{
		this.totahap = totahap;
	}

	// �޷�...
	Calendar ca = new GregorianCalendar();
			int year  = ca.get(Calendar.YEAR);
			int month = ca.get(Calendar.MONTH);
			int day   = ca.get(Calendar.DATE);


	public void paymenu() throws IOException
	{
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("������������������������������������������������������������������������");
				System.out.println("��         ���� �޴�                ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.println("�� �� �����ϱ�                      ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� ��ٱ��Ϸ� ���ư���           ��");
				System.out.println("��                                  ��"); 
				System.out.println("�� �� ���� �޴��� ���ư���          ��");
				System.out.println("��                                  ��");
				System.out.println("������������������������������������������������������������������������"); 
				System.out.print("  �� "); 
				choice = sc.nextInt();
				System.out.println("������������������������������������������������������������������������"); 
				} 
			catch (Exception e)
				{
					e.toString();
					System.out.println("���~~~ ���� �߻�! ");
					System.out.println("�ذ��� ����� �����ϳ�  ");
					System.out.println("�ٽ� �Է��ϼ��� ^_^");
					sc.nextLine(); // ���� ����
					continue; // �߸��� �Է� ó�� �� �ٽ� �ݺ��� ����
				}

            if (choice == 1)
			{
                // �����ϱ�
				//System.out.println(rc.sum);
				//System.out.println(shh.huru);
				//System.out.println(shh.huruprice);
               System.out.println("������������������������������������������������������������������������"); 
				System.out.println("�� �� ī�� ����                     ��");
				System.out.println("��                                  ��");
				System.out.println("�� �� ���� ����                     ��");
				System.out.println("��                                  ��"); 
				System.out.println("������������������������������������������������������������������������"); 
				System.out.print("  �� ");
                choice = sc.nextInt();
				System.out.println("������������������������������������������������������������������������"); 
                if (choice == 1)
				{
                    // ī�� ���� �ϱ�
                    cardPay();
                } 
				else if (choice == 2) 
				{
                    // ���� ���� �ϱ�
                    cashPay();
                }
				else
				{
                    System.out.println("�ٽ� �Է��ϼ���");
				}
            }
			else if (choice == 2)
			{
                // ��ٱ��� ���ư���
				sMenu();
            }
			else if (choice == 3)
			{
                // ��ٱ��� �ʱ�ȭ?
				// ȸ�� �ʿ�
                
				
				// ���θ޴��� ���ư���
                ve.turnOn();
                break; // �ݺ��� ����
            } 
			else
			{
                System.out.println("�ٽ� �Է��ϼ���");
            }
        }
    }


	public void cashPay() throws IOException// ���� ���� �Լ�
	{
		
	 // ����ڷκ��� ���� �ݾ� �Է�
       Scanner sc = new Scanner(System.in);
	   DecimalFormat df = new DecimalFormat("###,###"); // �� ����Ҷ� , ������ �ϴ� ��
	   
       int usermoney;  // ����ڰ� �Է��� ����
	   
				for (int i = 0; i < ShopingCart.priceList.size(); i++)
				{
					int price = ShopingCart.priceList.get(i);
					totlamoney+=price;
	
					//increaseAddCount(fruitName);
					//�׽�Ʈ System.out.println(fruitName + " - ����: " + price + "��");
				}

       do
		{	
		   String changemoney2 = df.format(totlamoney);
		   	System.out.println("������������������������������������������������������������������������"); 
		    System.out.print  ("�� �Ѿ��� "+changemoney2+"�Դϴ�.");System.out.println("              ��");
			System.out.println("������������������������������������������������������������������������");
			System.out.print  ("  �� ������ �־� �ּ���: ");


		//�ϴ� �׽�Ʈ �뵵 
		// �Ǹŵ� ���� ���� ���
		/*
		System.out.println("�Ǹŵ� ���� ����:");
		for (FruitsProducts fruit : fru.fruits.values())
		{
			int addCount = fruit.getAddCount();
			if (addCount > 0)
			{
				System.out.println(fruit.getName() + " - �Ǹŵ� ����: " + addCount);
			}
		}
		*/
            usermoney = sc.nextInt();
            if (usermoney < totlamoney) 
				{
					
					int aa=usermoney - totlamoney;
					int change=Math.abs(aa);
					String changemoney1 = df.format(change);
					System.out.println("�Է��� �ݾ��� ���� �ݾ׺��� �����մϴ�.");
					System.out.println("������ �ݾ�: " + changemoney1 + "��");
					System.out.println("�ٽ� �̿��Ϸ��� �ݾ��� �� �Է��� �ּ���.");
					
				}
		} while (usermoney < totlamoney);


		String changemoney = df.format(usermoney - totlamoney);
        System.out.println("������������������������������������������������������������������������");
        System.out.println("�� ���ݰ����� �Ϸ�Ǿ����ϴ�.       ��");
        System.out.println("�� �Ž�����: "+changemoney + "��");
		System.out.println("������������������������������������������������������������������������");
        System.out.println("�� �������� ����Ͻðڽ��ϱ�?       ��");
		System.out.println("��                                  ��");
		System.out.println("�� �� ��                            ��");
		System.out.println("��                                  ��");
		System.out.println("�� �� �ƴϿ�                        ��");
		System.out.println("��                                  ��");
		System.out.println("������������������������������������������������������������������������");
		System.out.print("  �� ");
		choice = sc.nextInt();
		System.out.println("������������������������������������������������������������������������");
		System.out.println();
		if (choice == 1)
		{
			// ������ ���
			System.out.println("  ���� ��  ��  �� ����");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
			System.out.println("  �� �� �� �� ��: " + year + "��" + (month+1) + "��" + day + "��");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
			System.out.println("  �� �� �� �� �� ��");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 

			
			for (int i = 0; i < ShopingCart.priceList.size(); i++)
			{	
				
				int price = ShopingCart.priceList.get(i);
				System.out.printf("  �ܡܡ� %d�� ���ķ� �ܡܡ�\n", (i+1));
				System.out.printf("  ���ķ� ����  : %s \n", ShopingCart.huruList.get(i+1));
				System.out.printf("  ���� �β�    : %s \n", co.sugarCoatinList.get(i));
				System.out.printf("  ����         : %d ��\n", price);
				System.out.println("������������������������������������������������������������������������������������������������������������");
			}

		
			String hapmoney = df.format(totlamoney);
			System.out.println   ("  �� �� �� ��  : "+ hapmoney+ "��");
			System.out.println   ("  ���� ���Ҿ�  : " + usermoney+ "��");


			// �Ǹ� �Ѿ��� ��ü ���⿡ �ֱ�
			//totahap+=rc.sum;
			totalHap+=totlamoney;
			totahap = totalHap;

			//setTotalHap(totalHap);
			ad.addSale(LocalDate.of(year, (month+1), day), totalHap);


			// �׸��� �ٽ� ���� �Ѿ� 0���� �ʱ�ȭ
			totlamoney=0;
			
			// ������ ������ pd_HuruList�� �ֱ�
			totalPdHuruList.putAll(huruList);
			pd_HuruList1.putAll(huruList);
			input();

			// ����(�Ǹſ�) �ý��� ��ȯ
			Serial.fruitSet(); 
			Serial.subSet(); 
			//���ѿ� ���� - �������� �����

			Serial.totahapSet();
			Serial.dailySalesSet();
			Serial.totalPdHuruListSet();
			Serial.pdHuruListSet();
			Serial.fruitCountsSet();

			// ��ٱ��� �ʱ�ȭ
			for (int m = 1; m <= fru.fruits.size() ; m++)
			{		
				fru.fruits.get(m).setSTemp(0);
				fru.fruits.get(m).setCTemp(0);
				
				fru.fruits.get(m).setTempC(0);
				fru.fruits.get(m).setTempS(0);


			}	

			ShopingCart.huruList.clear();
			ShopingCart.priceList.clear();
			co.sugarCoatinList.clear();
			setKeyCounter(1);
			
			// ���θ޴��� ���ư���
			ve.turnOn();
			
		}
		else if (choice ==2)
		{
			System.out.println("�������ּż� �����մϴ� �� �̿����ּ���");
			
			totalHap+=totlamoney;
			totahap = totalHap;
			ad.addSale(LocalDate.of(year, (month+1), day), totalHap);
			
			
			// ������ ������ pd_HuruList�� �ֱ�
			totalPdHuruList.putAll(huruList);
			pd_HuruList1.putAll(huruList);
			input();
			
			// ����(�Ǹſ�) �ý��� ��ȯ
			Serial.fruitSet(); 
			Serial.subSet(); 
			//���ѿ� ���� - �������� �����

			Serial.totahapSet();
			Serial.dailySalesSet();
			Serial.totalPdHuruListSet();
			Serial.pdHuruListSet();
			Serial.fruitCountsSet();

			// ��ٱ��� �ʱ�ȭ
			for (int m = 1; m <= fru.fruits.size() ; m++)
			{		
				fru.fruits.get(m).setSTemp(0);
				fru.fruits.get(m).setCTemp(0);
				fru.fruits.get(m).setTempC(0);
				fru.fruits.get(m).setTempS(0);

			}	

			ShopingCart.huruList.clear();
			ShopingCart.priceList.clear();
			co.sugarCoatinList.clear();
			setKeyCounter(1);
			
			// ���θ޴��� ���ư��� �Լ�
			ve.turnOn();
			
		}
    }


public void cardPay() throws IOException// ī�� ���� �Լ�
	{
		
		Scanner sc =new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###,###");

		System.out.println("������������������������������������������������������������������������");
        System.out.println("�� ī������� �Ϸ�Ǿ����ϴ�.       ��");
		System.out.println("������������������������������������������������������������������������");
        System.out.println("�� �������� ����Ͻðڽ��ϱ�?       ��");
		System.out.println("��                                  ��");
		System.out.println("�� �� ��                            ��");
		System.out.println("��                                  ��");
		System.out.println("�� �� �ƴϿ�                        ��");
		System.out.println("��                                  ��");
		System.out.println("������������������������������������������������������������������������");
		System.out.print("  �� ");
		choice = sc.nextInt();
		System.out.println("������������������������������������������������������������������������");
		System.out.println();

		//System.in.skip(2);
		if (choice == 1)
		{
			// ������ ���
		System.out.println("  IC �ſ� ����(���Ǳ��)");
			System.out.println("  ���� ��  ��  �� ����");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
			System.out.println("  �� �� �� �� ��: " + year + "��" + (month+1) + "��" + day + "��");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
			System.out.println("  �� �� �� �� �� ��");
			System.out.println("������������������������������������������������������������������������������������������������������������"); 
		
		
			for (int i = 0; i < ShopingCart.priceList.size(); i++)
			{	
				
				int price = ShopingCart.priceList.get(i);
				totlamoney+=ShopingCart.priceList.get(i);
				
				System.out.printf("  �ܡܡ� %d�� ���ķ� �ܡܡ�\n", (i+1));
				System.out.printf("  ���ķ� ����  : %s \n", ShopingCart.huruList.get(i+1));
				System.out.printf("  ���� �β�    : %s \n", co.sugarCoatinList.get(i));
				System.out.printf("  ����         : %d ��\n", price);
				System.out.println("������������������������������������������������������������������������������������������������������������");
			}
		
				
			String hapmoney = df.format(totlamoney);
			System.out.println   ("  �� �� �� ��  : " + hapmoney+ "��");
			System.out.println   ("  ī�� ���Ҿ�  : " + hapmoney+ "��");
			System.out.println   ("������������������������������������������������������������������������������������������������������������");			
			System.out.println   ("  [�� �� �� ��]");
			System.out.println   ("  *** �ſ��������(����) ***");
			System.out.println   ("  ī �� �� ��  : �ֿ�ſ�ī��");
			System.out.println   ("  ī �� �� ȣ  : ****-****-****-****");
			System.out.println   ("  �� �� �� ��  : �Ͻú�");

			System.out.println("\n  �������ּż� �����մϴ� �� �̿����ּ���");

		//plusAddCount();

			// �Ǹ� �Ѿ��� ��ü ���⿡ �ֱ�
			
			totalHap+=totlamoney;
			totahap = totalHap;
			ad.addSale(LocalDate.of(year, (month+1), day), totalHap);
			
			// �׸��� �ٽ� ���� �Ѿ� 0���� �ʱ�ȭ
			totlamoney=0;

			// ������ ������ pd_HuruList�� �ֱ�
			totalPdHuruList.putAll(huruList);
			pd_HuruList1.putAll(huruList);
			input();

			// ����(�Ǹſ�) �ý��� ��ȯ
			Serial.fruitSet(); 
			Serial.subSet(); 
			//���ѿ� ���� - �������� �����

			Serial.totahapSet();
			Serial.dailySalesSet();
			Serial.totalPdHuruListSet();
			Serial.pdHuruListSet();
			Serial.fruitCountsSet();

			// ��ٱ��� �ʱ�ȭ
			for (int m = 1; m <= fru.fruits.size() ; m++)
			{		
				fru.fruits.get(m).setSTemp(0);
				fru.fruits.get(m).setCTemp(0);

				fru.fruits.get(m).setTempC(0);
				fru.fruits.get(m).setTempS(0);
			}	

			ShopingCart.huruList.clear();
			ShopingCart.priceList.clear();
			co.sugarCoatinList.clear();
			setKeyCounter(1);
			
			//System.out.println(totahap);
			
			
			// ���θ޴��� ���ư���
			ve.turnOn();

		}
		else if (choice ==2)
		{
			System.out.println("�������ּż� �����մϴ� �� �̿����ּ���");

			for (int i = 0; i < ShopingCart.priceList.size(); i++)
			{	
				
				int price = ShopingCart.priceList.get(i);
				totlamoney+=ShopingCart.priceList.get(i);
			}

			totalHap+=totlamoney;
			totahap = totalHap;
			ad.addSale(LocalDate.of(year, (month+1), day), totalHap);
			
			// ������ ������ pd_HuruList�� �ֱ�
			totalPdHuruList.putAll(huruList);
			pd_HuruList1.putAll(huruList);
			input();

			// ��ٱ��� �ʱ�ȭ
			for (int m = 1; m <= fru.fruits.size() ; m++)
			{		
				fru.fruits.get(m).setSTemp(0);
				fru.fruits.get(m).setCTemp(0);

				fru.fruits.get(m).setTempC(0);
				fru.fruits.get(m).setTempS(0);
			}	

			ShopingCart.huruList.clear();
			ShopingCart.priceList.clear();
			co.sugarCoatinList.clear();
			setKeyCounter(1);
			
			// ���θ޴��� ���ư��� �Լ� 
			ve.turnOn();
		}
    }

	public void input() 
	{
		LocalDate date = LocalDate.of(year, (month + 1), day);
		ArrayList<ArrayList<String>> huruListForDate = pdHuruList.get(date);

		if (huruListForDate == null) 
		{	
			// ���α׷� ���� ���� Ű�� ���� null �̶�� ���ο� ���� ����
			huruListForDate = new ArrayList<>();
		}

		for (Map.Entry<Integer, ArrayList<String>> entry : huruList.entrySet()) 
		{	
			// ���α׷� ���� ���� Ű�� ���� null �� �ƴ϶�� ��ٱ��Ͽ��� �����Ϸ� �� ���ķ���� pdHuruList�� �߰�
			ArrayList<String> huruListA = entry.getValue();
			
			ArrayList<String> copyHuruList = new ArrayList<>(huruListA); // ���� huruList�� ������ ���� ���� �ʵ��� ���� ���� ����
			huruListForDate.add(copyHuruList);
		}

		pdHuruList.put(date, huruListForDate);
		//System.out.println("��¥�� ���� �׽�Ʈ : " + pdHuruList);		// �׽�Ʈ
	}

	
	public static void plusAddCount() // �� ���� ���� ����
	{
		//Map<String, Integer> fruitCounts = new HashMap<>();

		for (Map.Entry<Integer, ArrayList<String>> entry : totalPdHuruList.entrySet()) 
			{
				ArrayList<String> fruits = entry.getValue();
				for (String fruit : fruits) 

				{
					fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + 1);
				}
			}

		for (Map.Entry<String, Integer> entry : fruitCounts.entrySet()) 
			{
				System.out.println(entry.getKey() + ": " + entry.getValue() + "��");
			}
	}

	public static void countFruits() // ��¥�� ���� ���� ����
	{
        for (Map.Entry<LocalDate, ArrayList<ArrayList<String>>> entry : pdHuruList.entrySet()) 
			{
				LocalDate date = entry.getKey();
				ArrayList<ArrayList<String>> huruListForDate = entry.getValue();
				Map<String, Integer> fruitCounts = new HashMap<>();

				for (ArrayList<String> huru : huruListForDate) 
				{
					for (String fruit : huru) 
					{
						fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + 1);
					}
				}	

				
				System.out.println(date + ":");
				for (Map.Entry<String, Integer> fruitCountEntry : fruitCounts.entrySet()) 
				{
					System.out.println(fruitCountEntry.getKey() + ": " + fruitCountEntry.getValue());
				}
			}
    }

	public static void plusAddCount1() // �� ���� ���� ����
	{
		//Map<String, Integer> fruitCounts = new HashMap<>();

		for (Map.Entry<Integer, ArrayList<String>> entry : totalPdHuruList.entrySet()) 
			{
				ArrayList<String> fruits = entry.getValue();
				for (String fruit : fruits) 

				{
					fruitCounts.put(fruit, fruitCounts1.getOrDefault(fruit, 0) + 1);
				}
			}

		for (Map.Entry<String, Integer> entry : fruitCounts1.entrySet()) 
			{
				System.out.println(entry.getKey() + ": " + entry.getValue() + "��");
			}
	}
	public static void countTotalFruits() {
    Map<String, Integer> fruitCounts = new HashMap<>();

    for (ArrayList<ArrayList<String>> huruListForDate : pdHuruList.values()) {
        for (ArrayList<String> huru : huruListForDate) {
            for (String fruit : huru) {
                fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + 1);
            }
        }
    }

    // Print total fruit counts
	System.out.println();
    System.out.println("���� :");
    for (Map.Entry<String, Integer> fruitCountEntry : fruitCounts.entrySet()) {
        System.out.println(fruitCountEntry.getKey() + ": " + fruitCountEntry.getValue());
    }
}

// ���� ���� �Ǹ� ���� �ö󰡴� �Լ� // �����ڸ�忡���� �� �� ���� 

public static void typefru() 
{
    System.out.println("���� ���պ� �Ǹ� ����:");
    HashMap<String, Integer> fruitTypeCount = new HashMap<>();

    for (Map.Entry<LocalDate, ArrayList<ArrayList<String>>> entry : pdHuruList.entrySet()) 
	{
        LocalDate date = entry.getKey();
        System.out.println("");
        System.out.println(date + " �Ǹ� ���� " + entry.getValue().size() + "��");
		 System.out.println();

        for (ArrayList<String> huru : entry.getValue()) 
		{
            
            Collections.sort(huru);
            ArrayList<String> uniqueFruits = new ArrayList<>(new HashSet<>(huru));
            String key = String.join(", ", uniqueFruits);

            
            fruitTypeCount.put(key, fruitTypeCount.getOrDefault(key, 0) + 1);
        }
    }

    
    for (Map.Entry<String, Integer> entry : fruitTypeCount.entrySet()) {
        System.out.println("["+entry.getKey() + "] " + entry.getValue() + "��");
    }
}






	
	public static void main(String [] args) // �׽�Ʈ�� ���� �Լ�  
	{
		/*
		ShopingCart sh = new ShopingCart();
		Pay ppay = new Pay();
		ppay.setShopping(sh);
		
		ppay.paymenu();

*/
		
		
	}
	
}//class end   