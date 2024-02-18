import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Player player;
    Location location;
    public void login(){
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Oyuna başlamadan önce isminizi giriniz: ");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();
    }
    public void start(){
        while (true){
            System.out.println();
            System.out.println("===========================================================");
            System.out.println();
            System.out.println("Harekete geçmek için lütfen bir yer seçiniz: ");
            System.out.println("1- Güvenli Ev --> Size ait güvenli bir mekan, düşman bulunmaz!");
            System.out.println("2- Mağara --> Karşınıza belki zombi çıkabilir!");
            System.out.println("3- Orman --> Karşınıza belki vampir çıkabilir!");
            System.out.println("4- Nehir --> Karşınıza belki ayı çıkabilir!");
            System.out.println("5- Mağaza --> Silah veya zırh alabilirsiniz!");
            System.out.print("Gitmek istediğiniz yer: ");
            int selLocation = scan.nextInt();
            while (selLocation<0 || selLocation>5){
                System.out.println("Lütfen geçerli bir yer seçiniz: ");
                selLocation = scan.nextInt();
            }
            switch (selLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location.getClass().getName().equals("SafeHouse")){
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                    System.out.println("Tebrikler! Oyunu kazandınız...");
                }
            }
            if (!location.getLocation()){
                System.out.println("Oyun Bitti !");
                break;
            }
        }
    }
}
