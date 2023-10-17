package org.chapter.chapter5.exercise4;


/**
 * 2장에서 6장의 카드를 포함하는 무작위 블랙잭 핸드를 생성하고,
 * 각 핸드의 블랙잭 값을 출력합니다. 사용자가 멈추기를 원할 때까지 계속합니다.
 */
public class Exercise4 {

    public static void main(String[] args) {

        Deck deck;            // 카드 덱.
        Card card;            // 덱에서 뽑은 카드.
        BlackjackHand hand;   // 2장에서 6장의 카드로 이루어진 핸드.
        int cardsInHand;      // 핸드에 있는 카드 수.
        boolean again;        // 사용자가 계속할지 여부.

        deck = new Deck();    // 카드 덱 생성.

        do {
            deck.shuffle();
            hand = new BlackjackHand();
            cardsInHand = 2 + (int) (Math.random() * 5);
            System.out.println();
            System.out.println();
            System.out.println("핸드에 포함된 카드:");
            for (int i = 1; i <= cardsInHand; i++) {
                // 덱에서 카드를 가져와 출력하고 핸드에 추가합니다.
                card = deck.dealCard();
                hand.addCard(card);
                System.out.println("    " + card);
            }
            System.out.println("핸드의 값은 " + hand.getBlackjackValue());
            System.out.println();
            System.out.print("계속하시겠습니까? ");
            again = TextIO.getlnBoolean();
        } while (again == true);

    }

}  // end class TestBlackjackHand
