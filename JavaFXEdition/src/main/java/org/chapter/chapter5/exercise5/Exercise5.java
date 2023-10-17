package org.chapter.chapter5.exercise5;

/**
 * 이 프로그램은 사용자가 블랙잭을 플레이하는 것을 허용합니다. 컴퓨터가 딜러 역할을 합니다.
 * 사용자는 100달러를 가지고 시작하며 각 게임에 베팅합니다. 사용자는 언제든지 나갈 수 있으며
 * 돈을 모두 잃으면 퇴장합니다.
 * 하우스 룰: 딜러는 합계가 16 이하이면 카드를 뽑으며 17 이상이면 멈춥니다. 딜러가 비길 경우 딜러가 승리합니다.
 * 각 게임마다 새로운 카드 덱을 사용합니다.
 */
public class Exercise5 {

    public static void main(String[] args) {

        int money;          // 사용자가 가지고 있는 돈.
        int bet;            // 사용자가 게임에 베팅한 금액.
        boolean userWins;   // 사용자가 게임에서 이겼는지 여부.

        System.out.println("블랙잭 게임에 오신 것을 환영합니다.");
        System.out.println();

        money = 100;  // 사용자는 100달러로 시작합니다.

        while (true) {
            System.out.println("현재 보유 금액: " + money + "달러");
            do {
                System.out.println("얼마를 베팅하시겠습니까? (종료하려면 0을 입력하세요.)");
                System.out.print("? ");
                bet = TextIO.getlnInt();
                if (bet < 0 || bet > money)
                    System.out.println("베팅 금액은 0부터 " + money + " 사이여야 합니다.");
            } while (bet < 0 || bet > money);
            if (bet == 0)
                break;
            userWins = playBlackjack();
            if (userWins)
                money = money + bet;
            else
                money = money - bet;
            System.out.println();
            if (money == 0) {
                System.out.println("돈을 모두 소진한 것 같네요!");
                break;
            }
        }

        System.out.println();
        System.out.println("당신은 " + money + "달러로 퇴장하셨습니다.");

    } // end main()


    /**
     * 사용자가 컴퓨터 딜러와 함께 한 게임의 블랙잭을 플레이하도록 합니다.
     * @return 사용자가 게임에서 이기면 true, 게임에서 지면 false.
     */
    static boolean playBlackjack() {

        Deck deck;                  // 카드 덱. 각 게임마다 새로운 덱 사용.
        BlackjackHand dealerHand;   // 딜러의 패.
        BlackjackHand userHand;     // 사용자의 패.

        deck = new Deck();
        dealerHand = new BlackjackHand();
        userHand = new BlackjackHand();

        /* 카드 덱을 섞은 다음, 각 플레이어에게 두 장의 카드를 나눠줍니다. */

        deck.shuffle();
        dealerHand.addCard( deck.dealCard() );
        dealerHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );

        System.out.println();
        System.out.println();

      /* 한 명 이상의 플레이어가 블랙잭 (총합이 21인 두 개의 카드)을 가졌는지 확인합니다.
         블랙잭을 가진 플레이어가 게임에서 이깁니다. 비길 경우 딜러가 이깁니다.
      */

        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("딜러는 " + dealerHand.getCard(0)
                    + "와 " + dealerHand.getCard(1) + "을 가지고 있습니다.");
            System.out.println("사용자는 " + userHand.getCard(0)
                    + "와 " + userHand.getCard(1) + "을 가지고 있습니다.");
            System.out.println();
            System.out.println("딜러가 블랙잭을 가지고 있습니다. 딜러가 승리합니다.");
            return false;
        }

        if (userHand.getBlackjackValue() == 21) {
            System.out.println("딜러는 " + dealerHand.getCard(0)
                    + "와 " + dealerHand.getCard(1) + "을 가지고 있습니다.");
            System.out.println("사용자는 " + userHand.getCard(0)
                    + "와 " + userHand.getCard(1) + "을 가지고 있습니다.");
            System.out.println();
            System.out.println("블랙잭을 가지고 있습니다. 승리합니다.");
            return true;
        }

      /* 블랙잭을 가진 플레이어가 없는 경우 게임을 플레이합니다.
         먼저 사용자가 카드를 뽑을 기회가 옵니다 (즉, "Hit"할 수 있음). while 루프는
         사용자가 "Stand"를 선택할 때 끝납니다. 사용자가 21을 초과하면 즉시 패배합니다.
      */

        while (true) {

            /* 사용자의 카드를 표시하고 사용자가 Hit 또는 Stand를 결정하도록 합니다. */

            System.out.println();
            System.out.println();
            System.out.println("당신의 카드는:");
            for ( int i = 0; i < userHand.getCardCount(); i++ )
                System.out.println("    " + userHand.getCard(i));
            System.out.println("현재 총합: " + userHand.getBlackjackValue());
            System.out.println();
            System.out.println("딜러가 " + dealerHand.getCard(0) + "을 보여줍니다.");
            System.out.println();
            System.out.print("Hit (H) 또는 Stand (S)을 선택하세요: ");
            char userAction;  // 사용자의 응답, 'H' 또는 'S'.
            do {
                userAction = Character.toUpperCase( TextIO.getlnChar() );
                if (userAction != 'H' && userAction != 'S')
                    System.out.print("H 또는 S로 응답하세요:  ");
            } while (userAction != 'H' && userAction != 'S');

            /* 사용자가 Stand하는 경우 루프가 종료됩니다 (딜러가 카드를 뽑기 시작함). */

            if ( userAction == 'S' ) {
                // 사용자가 카드를 더 이상 뽑지 않음; 루프 종료.
                break;
            }
            else {  // 사용자가 Hit을 선택한 경우
                // 사용자에게 카드를 한 장 더 주며 사용자가 21을 초과하면 패배합니다.
                Card newCard = deck.dealCard();
                userHand.addCard(newCard);
                System.out.println();
                System.out.println("Hit 했습니다.");
                System.out.println("당신의 카드: " + newCard);
                System.out.println("현재 총합: " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {
                    System.out.println();
                    System.out.println("21을 초과하여 패배했습니다. 딜러의 다른 카드는 "
                            + dealerHand.getCard(1) + "입니다.");
                    return false;
                }
            }

        } // end while loop

      /* 여기까지 왔다면 사용자가 21 이하로 Stand했습니다. 이제 딜러가 카드를 뽑을 차례입니다.
         딜러는 합계가 16 이상이 될 때까지 카드를 뽑습니다. 딜러가 21을 초과하면 딜러 패배합니다.
      */

        System.out.println();
        System.out.println("사용자가 Stand했습니다.");
        System.out.println("딜러의 카드:");
        System.out.println("    " + dealerHand.getCard(0));
        System.out.println("    " + dealerHand.getCard(1));
        while (dealerHand.getBlackjackValue() <= 16) {
            Card newCard = deck.dealCard();
            System.out.println("딜러가 카드를 뽑아 " + newCard + "를 얻었습니다.");
            dealerHand.addCard(newCard);
            if (dealerHand.getBlackjackValue() > 21) {
                System.out.println();
                System.out.println("딜러가 21을 초과하여 패배했습니다. 승리합니다.");
                return true;
            }
        }
        System.out.println("딜러의 현재 총합: " + dealerHand.getBlackjackValue());

        /* 여기까지 왔다면 양쪽 플레이어 모두 21 이하입니다. 승자는 두 패의 값을 비교하여 결정할 수 있습니다. */

        System.out.println();
        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
            System.out.println("무승부입니다. 딜러가 이겼습니다.");
            return false;
        }
        else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
            System.out.println("딜러 승리, " + dealerHand.getBlackjackValue()
                    + "점 대 " + userHand.getBlackjackValue() + "점.");
            return false;
        }
        else {
            System.out.println("당신의 승리, " + userHand.getBlackjackValue()
                    + "점 대 " + dealerHand.getBlackjackValue() + "점.");
            return true;
        }

    }  // end playBlackjack()

} // end class Blackjack

