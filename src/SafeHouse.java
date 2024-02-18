public class SafeHouse extends NormalLoc{
    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("Sağlığınız yenilendi, iyileştiniz...");
        System.out.println("Şu an Güvenli Ev adlı yerdesiniz.");
        return true;
    }
}
