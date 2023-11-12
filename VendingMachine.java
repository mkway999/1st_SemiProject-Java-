import java.util.Scanner;
import java.util.Map;
import java.io.IOException;

class VendingMachine implements VmMenu
{	
	int menuSel;
	public final int T_ORDER = 1;			// �ֹ��ϱ�
	public final int T_POPULAR_DISH = 2;	// �α� TOP3
	public final int T_CART = 3;			// ��ٱ���
	public final int T_ADMIN_MODE = 4;		// �����ڸ��

	private static final String ADMIN_PASSWORD = "minzzi";	// ������ ��� ���� ��й�ȣ
	

	@Override
	public void turnOn() throws IOException
	{
		menuDisp();
		menuSelect();
		menuRun();
	}

	@Override
	public void menuDisp()
	{	
		System.out.println();
		System.out.println("������������������������������������������������������������������������");
		System.out.println("��  ������������������������������������������           ��");
		System.out.println("��  �� ��   �ֹ��ϱ�     ��    ____   ��"); 
		System.out.println("��  ������������������������������������������   ����������   ��");
		System.out.println("��                                  ��");
		System.out.println("��  ������������������������������������������           ��");
		System.out.println("��  �� �� ���α� TOP 3�� ��           ��"); 
		System.out.println("��  ������������������������������������������           ��");
		System.out.println("��                          ����  ��");
		System.out.println("��  ������������������������������������������ ������������������ ��");
		System.out.println("��  �� ��   ��ٱ���     �� �� ______�� ��");
		System.out.println("��  ������������������������������������������ ������������������ ��");
		System.out.println("��       ���� ���리��                ��");
		System.out.println("��       ��         ��                ��");
		System.out.println("��   ��������������������������������������            ��");
		System.out.println("��   ��������������������������������������            ��");
		System.out.println("��   ��������������������������������������            ��");
		System.out.println("��    ����������������������������������             ��");
		System.out.println("��     ������������������������������              ��");
		System.out.println("��       ����������������������                ��");
		System.out.println("������������������������������������������������������������������������");
	}

	@Override
	public void menuSelect() throws IOException
	{
		Scanner sc = new Scanner(System.in);

		String inputTemp;
		
		boolean mJudge = false;

		do
		{
			System.out.print("  �޴��� ������ �ּ��� ");
			System.out.print("�� ");
			inputTemp = sc.next();
			System.out.println();

			mJudge = false;

			if (inputTemp.equals("1"))
			{
				menuSel = T_ORDER;
				return;
			}
			
			else if (inputTemp.equals("2"))
			{
				menuSel = T_POPULAR_DISH;
				return;
			}
			
			else if (inputTemp.equals("3"))
			{
				menuSel = T_CART;
				return;
			}

			else if (inputTemp.equals(ADMIN_PASSWORD))
			{
				menuSel = T_ADMIN_MODE;
				return;
			}

			else
			{
				System.out.println("�ùٸ� ���� �Է��� �ּ���.");
				System.out.println();
				mJudge = true;
			}
		}
		while (mJudge);
	}

	@Override
	public void menuRun() throws IOException
	{
		if (menuSel == T_ORDER)
		{
			// �ֹ��ϱ�

			OrderSel os1 = new OrderSel();
			os1.orderSelect();
		}

		else if (menuSel == T_POPULAR_DISH)
		{
			// �α� TOP3
			PopularDish pd = new PopularDish();
			pd.pMenuSelect();
		}

		else if (menuSel == T_CART)
		{
			// ��ٱ���
			ShopingCart sc1 = new ShopingCart();
			sc1.sMenu();
		
		}

		else if (menuSel == T_ADMIN_MODE)
		{	
			// ������ ��� ����
			System.out.println("�α��ο� �����߽��ϴ�.");
			System.out.println("������ ��忡 �����մϴ�.");

			AdMain am1 = new AdMain();
			am1.turnOn();
		}
	}

}