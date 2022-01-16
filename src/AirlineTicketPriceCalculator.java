import java.util.Scanner;

public class AirlineTicketPriceCalculator {
    public static void main(String[] args) {
         /*
        Kullanıcıdan gidelecek mesafe(km), yaş ve tek yön ya da gidiş dönüş olması bilgilerini al.

        İndirim kriterleri:

        Kişi 12 yaşından küçük ise %50 indirim,
        12-24 yaş aralığında ise %10,
        65 yaşından büyük ise %30,
        Gidiş dönüş seçildi ise bilet fiyatı üzerinden %20.

        Mesafe başına ücret 0.10 / km

         */
        Scanner input = new Scanner(System.in);
        int range, age, flyType;

        System.out.print("Yolculuk mesafesi(km): ");
        range = input.nextInt();

        System.out.print("Yolcunun yaşı: ");
        age = input.nextInt();


        System.out.print("Yolculuk:\n Tek yön ise -> 1\n Gidiş-Dönüş ise -> 2\nSeçiminiz:");
        flyType = input.nextInt();

        if (range > 0 && age > 0) {

            double price = range * 0.10;
            System.out.println("Tek Yön İndirimsiz Bilet Tutarı: " + price);

            double discountUnder12 = price - (price * 0.50);
            double discountUnder24 = price - (price * 0.10);
            double discount65Plus = price - (price * 0.30);
            double discountUnder12RoundTrip = discountUnder12 - (discountUnder12 * 0.20);
            double discountUnder24RoundTrip = discountUnder24 - (discountUnder24 * 0.20);
            double discountUnder65RoundTrip = price * 0.20;
            double discount65PlusRoundTrip = discount65Plus - (discount65Plus * 0.20);

            switch (flyType) {
                case 1:
                    if (age < 12) {
                        System.out.print("Tek Yön İndirimli Bilet Tutarı: " + (discountUnder12));
                    } else if (age <= 24) {
                        System.out.print("Tek Yön İndirimli Bilet Tutarı: " + (discountUnder24));
                    } else if (age < 65) {
                        System.out.println("Tek Yön İndirimli Bilet Tutarı:" + price);
                    } else if (age > 65) {
                        System.out.print("Tek Yön İndirimli Bilet Tutarı: " + (discount65Plus));
                    }
                    break;
                case 2:
                    if (age < 12) {
                        System.out.print("Gidiş Dönüş İndirimli Bilet Tutarı: " + (discountUnder12RoundTrip * 2));
                    } else if (age <= 24) {
                        System.out.print("Gidiş Dönüş İndirimli Bilet Tutarı: " + (discountUnder24RoundTrip * 2));
                    } else if (age < 65) {
                        System.out.print("Gidiş Dönüş İndirimli Bilet Tutarı:" + (price - discountUnder65RoundTrip) * 2);
                    } else if (age > 65) {
                        System.out.print("Gidiş Dönüş İndirimli Bilet Tutarı: " + (discount65PlusRoundTrip * 2));
                    }
                    break;
                default:
                    System.out.print("Hatalı giriş yaptınız.");
            }
        } else {
            System.out.print("Hatalı giriş yaptınız.");
        }
    }
}
