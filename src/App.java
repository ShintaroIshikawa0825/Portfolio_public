import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //キーボード入力用スキャナー
        Scanner scanner = new Scanner(System.in);
        //ランダムカードを引くためのインスタンス
        Random random = new Random();

        //プレイヤーとCPUの引いたカードを管理するための配列（最大１０枚）
        int [] plyaerCards = new int[10];  //最大１０枚引ける
        int [] cpuCards = new int[10];

        //プレイヤーとCPUの引いたカードの合計を記録する変数
        int plyaerSum = 0; 
        int cpuSum = 0;

        //プレイヤーのターンの処理
        int plyaerCardCount = 0; //プレイヤーが引いたカードの枚数
        boolean playerBust = false; //プレイヤーがバーストしたか評価

        while (true){
            //カードを一枚引く
            int card = drawCard(random);
            //配列にカードの値を記録
            plyaerCards[plyaerCardCount++] =card;
            //合計点に加算
            plyaerSum += card;

            //引いたカードと合計値を表示
            System.out.println("あなたが引いたカードは" + card +"です！");
            System.out.println("現在の合計は" + plyaerSum + "です！");
            if (plyaerSum > 21){
                System.out.println("バースト！あなたの負けです！");
                playerBust = true;
                break;
            }

            System.out.println("カードを引きますか？(yes/no)");
            String input = scanner.nextLine();
            if (input.equals("no")) {
                break;
            }
        }

        //CPUのターン
        if(!playerBust){
            int cpuCardCount = 0;//CPUの引いたカードの枚数を記録

            while (cpuSum < 17) {
                int card = drawCard(random);
                cpuCards[cpuCardCount++] = card;
                cpuSum += card;

                System.out.println("CPUが引いたカード" + card);
            }
            System.out.println("CPUの引いたカードの合計は" + cpuSum);

            //勝敗判定
            //cpuの合計値が２１を超えたとき
            if (cpuSum > 21){
                System.out.println("CPUのバースト！");
            //プレイヤーがより２１に近い時
            }else if(plyaerSum > cpuSum){
                System.out.println("あなたの勝ちです！");
            //CPUが２１に近い時
            }else if(plyaerSum < cpuSum){
                System.out.println("あなたの負けです！");
            //それ以外
            }else{
                System.out.println("引き分けです！");
            }
        }
        scanner.close();
    }

    //試験的にメソッド化を試す
    public static int drawCard (Random random){
        return random.nextInt(11) + 1;
    }
}
