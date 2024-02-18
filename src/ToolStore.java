import javax.rmi.ssl.SslRMIClientSocketFactory;

public class ToolStore extends NormalLoc{
    ToolStore(Player player) {
        super(player, "Mağaza");
    }

   @Override
   public boolean getLocation() {
       System.out.println("Paranız: " + player.getMoney());
       System.out.print("1- Silahlar");
       System.out.print("2- Zırhlar");
       System.out.print("3- Çıkış");
       System.out.print("Seçiminiz: ");
       int selTool = scan.nextInt();
       int selItemID;
       switch (selTool){
           case 1:
               selItemID = weaponMenu();
               buyWeapon(selItemID);
               break;
           case 2:
               selItemID = armorMenu();
               buyArmor(selItemID);
       }
       return true;
   }
   public int armorMenu(){
       System.out.println("1- Hafif Zırh\t <Para: 15 - Hasar: 1>");
       System.out.println("2- Orta Zırh\t <Para: 25 - Hasar: 3>");
       System.out.println("3- Ağır Zırh\t <Para: 40 - Hasar: 5>");
       System.out.println("4- Çıkış");
       System.out.print("Zırh Seçiniz: ");
       int selArmorID = scan.nextInt();
       return selArmorID;
   }
   public void buyArmor(int itemID){
       int avoid = 0, price = 0;
       String armorName = null;
       switch (itemID){
           case 1:
               avoid = 1;
               armorName = "Hafif Zırh";
               price = 15;
               break;
           case 2:
               avoid = 3;
               armorName = "Orta Zırh";
               price = 25;
               break;
           case 3:
               avoid = 5;
               armorName = "Ağır Zırh";
               price = 40;
               break;
           case 4:
               System.out.println("Çıkış yapılıyor...");
           default:
               System.out.println("Geçersiz işlem!");
       }
       if (price>0){
           if (player.getMoney() >= price){
               player.getInv().setArmor(avoid);
               player.getInv().setArmorName(armorName);
               player.setMoney(player.getMoney()-price);
               System.out.println(armorName + " satın aldınız, Engellenen Hasarınız: " + player.getInv().getArmor());
               System.out.println("Kalan para: "+player.getMoney());
           }
           else {
               System.out.println("Paranız yetersiz!");
           }
       }
   }
   public int weaponMenu(){
       System.out.println("1- Tabanca\t <Para: 25 - Hasar: 2>");
       System.out.println("2- Kılıç\t <Para: 35 - Hasar: 3>");
       System.out.println("3- Tüfek\t <Para: 45 - Hasar: 7>");
       System.out.println("4- Çıkış");
       System.out.print("Silah Seçiniz: ");
       int selWeaponID = scan.nextInt();
       return selWeaponID;
   }
   public void buyWeapon(int itemID){
       int damage = 0, price = 0;
       String weaponName = null;
           switch (itemID){
               case 1:
                   damage = 2;
                   weaponName = "Tabanca";
                   price = 25;
                   break;
               case 2:
                   damage = 3;
                   weaponName = "Kılıç";
                   price = 35;
                   break;
               case 3:
                   damage = 7;
                   weaponName = "Tüfek";
                   price = 45;
                   break;
               case 4:
                   System.out.println("Çıkış yapılıyor...");
               default:
                   System.out.println("Geçersiz işlem!");
           }
           if (price>0){
               if (player.getMoney() > price){
                   player.getInv().setDamage(damage);
                   player.getInv().setWeaponName(weaponName);
                   player.setMoney(player.getMoney()-price);
                   System.out.println(weaponName + " satın aldınız, Önceki Hasarınız: " + player.getDamage() + "Yeni Hasarınız: "
                           + player.getTotalDamage());
                   System.out.println("Kalan para: "+player.getMoney());
               }
               else {
                   System.out.println("Paranız yetersiz!");
               }
           }

    }
}

